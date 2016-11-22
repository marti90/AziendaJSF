package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import modelBean.BustaPagaService;
import dao.BustaPaga2DAO;

public class GestioneJasperReport {
	
	BustaPaga2DAO bpDao = new BustaPaga2DAO();
	
	public void creaPDFelencoBuste(){
		
		String nomeFile = "ElencoBustePaga.pdf";
		String percorso = "C:\\Users\\corso\\Desktop\\Jasper\\";
		String fileFinale = percorso + nomeFile;
		
		try {
			
			//la mia lista che mantiene i dati
			List<BustaPagaService> buste = bpDao.readBustePaga2();
			
			// Converto la  lista to JRBeanCollectionDataSource 
			JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(buste,false);

			// una mappa per mandare i parametri a Jasper
			Map<String, Object> parameters = new HashMap<String, Object>();

//			parameters.put("BustaDataSource", itemsJRBean);
//	        parameters.put("Codice Busta", );
//	        parameters.put("Data Emissione", );
//	        parameters.put("Importo", );

			// file compilato di jasper (.jasper) di Jasper Report per creare
			// PDF
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					"formato.jasper", parameters, new JREmptyDataSource());

			// outputStream per creare PDF
			OutputStream outputStream = new FileOutputStream(new File(
					fileFinale));

			// scrivo in un file PDF
			JasperExportManager.exportReportToPdfStream(jasperPrint,
					outputStream);
			System.out.println("il File.pdf e' stato creato");

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
