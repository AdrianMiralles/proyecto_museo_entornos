package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import modelo.Obra;



public class Fichero {
	public void generarXLS(ArrayList<Obra> consulta, String nombre) {
		//Crea un libro
		Workbook workbook = new HSSFWorkbook();
		// Crea hoja nueva
		Sheet sheet = workbook.createSheet("Hoja de datos");

		Iterator<Obra> iterador = consulta.iterator();
		int numeroRenglon = 0;//inicio de filas
	
		Row row = sheet.createRow(numeroRenglon++);
		Cell cell = row.createCell(0);
		cell.setCellValue("ID-Obra");
		cell = row.createCell(1);
		cell.setCellValue("Título de la obra");
		cell = row.createCell(2);
		cell.setCellValue("Tipo de obra");
		cell = row.createCell(3);
		cell.setCellValue("Fecha de creación");
		cell = row.createCell(3);
		cell.setCellValue("Ubicación actual");
		while (iterador.hasNext()) {
			int numeroCelda = 0;//Número de inicio de celdas
			Obra elemento = iterador.next();
			row = sheet.createRow(numeroRenglon++);//cada vez que entra al while avanzo una fila
			
			cell = row.createCell(numeroCelda++);
			cell.setCellValue(elemento.getIdObra());
			cell = row.createCell(numeroCelda++);
			cell.setCellValue(elemento.getTitulo());
			cell = row.createCell(numeroCelda++);//cada vez que escribe una celda avanzo una celda
			cell.setCellValue(elemento.getTipo());
			cell = row.createCell(numeroCelda++);
			cell.setCellValue(elemento.getFecha());
			cell = row.createCell(numeroCelda++);
			cell.setCellValue(elemento.getLugar());

		}

		try {
			// Se genera el documento
			FileOutputStream fichero = new FileOutputStream(new File(nombre + "Consulta.xls"));
			workbook.write(fichero);
			fichero.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
