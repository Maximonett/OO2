package ar.edu.unlp.info.oo2.biblioteca;

import java.util.List;

public class VoorheesExporter implements Exporter {

	private String exportar(Socio socio) {
		String separator = System.lineSeparator();
		return "\t{" + separator
			+ "\t\t\"nombre\": \"" + socio.getNombre() + "\"," + separator
			+ "\t\t\"email\": \"" + socio.getEmail() + "\"," + separator
			+ "\t\t\"legajo\": \"" + socio.getLegajo() + "\"" + separator
			+ "\t}";
	}

	@Override
	public String exportar(List<Socio> socios) {
		if (socios.isEmpty()) {
			return "[]";
		}
		String separator = System.lineSeparator();
		StringBuilder buffer = new StringBuilder("[" + separator);
		socios.forEach(socio -> {
			buffer.append(this.exportar(socio))
				.append(",")
				.append(separator);
		});
		// remueve la última coma y fin de línea
		buffer.setLength(buffer.length() - (separator.length() + 1)); //borro la última coma y el salto de línea	
		buffer.append(separator).append("]"); // cierra el array
		return buffer.toString(); // devuelve el resultado en un String
	}
}
