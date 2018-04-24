package it.istruzione.ossscudig.controllers.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.springframework.web.multipart.MultipartFile;

public class RivMonUtility {
	
	private final static Logger logger = Logger.getLogger(RivMonUtility.class);
	
	public static Sheet getSheetFromExcelFile(MultipartFile file) throws IOException{
		
		Workbook workbook = null;
		byte[] byteArr = null;
		
		try {
			byteArr = file.getBytes();
			InputStream inputStream = new ByteArrayInputStream(byteArr);
			
			// recupero l'estensione del file
		    String[] array = file.getOriginalFilename().split("\\.");
			String extension = array[array.length-1];
		
			// in base all'estensione utilizzo un tipo di libreria piuttosto che un'altra
			if ("xls".equals(extension)) {
				workbook = new HSSFWorkbook(inputStream);
			} else if ("xlsx".equals(extension)) {  
				workbook = new XSSFWorkbook(inputStream);
			} else {
				workbook = new XSSFWorkbook(inputStream);
			}
		} catch (IOException e) {
			logger.error("Errore o interruzione nell'operazione di lettura del file excel: " + e.getMessage());
			throw new IOException();
		}
		
		return workbook.getSheetAt(0);
	}
	
	public static Long differenzaMesi(Date startDate,Date endDate){
		DateTime data1 = new DateTime(startDate);
		DateTime data2 = new DateTime(endDate);
		Integer mesi = Months.monthsBetween(data1, data2).getMonths();
		return mesi.longValue()+1;
	}
	
	public static Long differenzaGiorni(Date startDate,Date endDate){
		DateTime data1 = new DateTime(startDate);
		DateTime data2 = new DateTime(endDate);
		Integer giorni = Days.daysBetween(data1, data2).getDays();
		return giorni.longValue();
	}
	
	public static Date aggiungiGiorni(Date dateToAdd,int days){
		DateTime data1 = new DateTime(dateToAdd);
		data1 = data1.plusDays(days);
		return data1.toDate();
	}
	
	public static List<String> getCapitale(){
		List<String> lista = new ArrayList<>();
		lista.add("Lordo");
		lista.add("Netto");
		return lista;
	}
	
	public static List<String> getTipoIncidenza(){
		List<String> lista = new ArrayList<>();
		lista.add("Massima");
		lista.add("Media");
		return lista;
	}

}
