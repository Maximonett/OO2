package com.example;

import java.util.Collection;
import java.util.List;

public class DatabaseProxy implements DatabaseAccess {
    private DatabaseAccess realDatabase;
    private User currentUser;

    public DatabaseProxy(DatabaseAccess realDatabase, User user) {
        this.realDatabase = realDatabase;
        this.currentUser = user;
    }

    @Override
    public Collection<String> getSearchResults(String queryString) {
        if (!checkAcces()) {
            throw new SecurityException(
                    "Acceso denegado: Usuario " + currentUser.getUsername() +
                            " no está autenticado");
        }
        System.out.println("Proxy: Permitiedno consulta para " + currentUser.getUsername());
        return realDatabase.getSearchResults(queryString);
    }

    @Override
    public int insertNewRow(List<String> rowData) {
        if (!checkAcces()) {
            throw new SecurityException(
                    "Acceso denegado Usuario: " + currentUser.getUsername() +
                            " no está autenticado.");
        }
        System.out.println("Proxy: Permitiendo insecion para " + currentUser.getUsername());
        return realDatabase.insertNewRow(rowData);
    }

    public boolean checkAcces() {
        if (currentUser != null && currentUser.isAuthenticated()) {
            return true;
        }
        return false;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

}
