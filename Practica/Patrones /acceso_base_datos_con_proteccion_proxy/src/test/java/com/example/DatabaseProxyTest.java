package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseProxyTest {

    private DatabaseAccess realDatabase;
    private DatabaseProxy proxy;
    private User user;

    @BeforeEach
    public void setUp() {
        realDatabase = new DatabaseRealAccess();
        user = new User("juan.perez");
        proxy = new DatabaseProxy(realDatabase, user);
    }

    @Test
    public void testAccesoDenegadoSinAutenticar() {
        // El usuario NO está autenticado
        assertFalse(user.isAuthenticated());

        // Debería lanzar excepción al intentar acceder
        SecurityException exception = assertThrows(
                SecurityException.class,
                () -> proxy.getSearchResults("select * from comics where id=1"));

        assertTrue(exception.getMessage().contains("no está autenticado"));
    }

    @Test
    public void testAccesoPermitidoConAutenticacion() {
        // El usuario se autentica
        user.login();
        assertTrue(user.isAuthenticated());

        // Ahora debería poder acceder
        Collection<String> results = proxy.getSearchResults("select * from comics where id=1");

        assertNotNull(results);
        assertEquals(2, results.size());
        assertTrue(results.contains("Spiderman"));
        assertTrue(results.contains("Marvel"));
    }

    @Test
    public void testInsercionSinAutenticar() {
        // Sin autenticación
        SecurityException exception = assertThrows(
                SecurityException.class,
                () -> proxy.insertNewRow(Arrays.asList("Patoruzú", "La flor")));

        assertTrue(exception.getMessage().contains("Acceso denegado"));
    }

    @Test
    public void testInsercionConAutenticacion() {
        // Con autenticación
        user.login();

        int newId = proxy.insertNewRow(Arrays.asList("Patoruzú", "La flor"));

        assertEquals(3, newId); // Debería ser el id 3

        // Verificar que se insertó correctamente
        Collection<String> results = proxy.getSearchResults("select * from comics where id=3");
        assertNotNull(results);
        assertTrue(results.contains("Patoruzú"));
        assertTrue(results.contains("La flor"));
    }

    @Test
    public void testLogoutRevocaAcceso() {
        // Autenticar
        user.login();
        assertTrue(user.isAuthenticated());

        // Acceder exitosamente
        Collection<String> results = proxy.getSearchResults("select * from comics where id=1");
        assertNotNull(results);

        // Cerrar sesión
        user.logout();
        assertFalse(user.isAuthenticated());

        // Ahora debería denegar el acceso
        SecurityException exception = assertThrows(
                SecurityException.class,
                () -> proxy.getSearchResults("select * from comics where id=2"));

        assertTrue(exception.getMessage().contains("no está autenticado"));
    }

    @Test
    public void testMultipleUsuarios() {
        User user1 = new User("alice");
        User user2 = new User("bob");

        DatabaseProxy proxy1 = new DatabaseProxy(realDatabase, user1);
        DatabaseProxy proxy2 = new DatabaseProxy(realDatabase, user2);

        // Solo alice se autentica
        user1.login();

        // Alice puede acceder
        Collection<String> results1 = proxy1.getSearchResults("select * from comics where id=1");
        assertNotNull(results1);

        // Bob no puede acceder
        assertThrows(SecurityException.class,
                () -> proxy2.getSearchResults("select * from comics where id=1"));

        // Bob se autentica
        user2.login();

        // Ahora bob también puede acceder
        Collection<String> results2 = proxy2.getSearchResults("select * from comics where id=2");
        assertNotNull(results2);
    }

    @Test
    public void testConsultaMultipleConAutenticacion() {
        user.login();

        // Múltiples consultas deberían funcionar
        Collection<String> result1 = proxy.getSearchResults("select * from comics where id=1");
        Collection<String> result2 = proxy.getSearchResults("select * from comics where id=2");

        assertNotNull(result1);
        assertNotNull(result2);

        assertTrue(result1.contains("Spiderman"));
        assertTrue(result2.contains("Batman"));
    }
}
