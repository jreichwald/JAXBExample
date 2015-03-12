package de.dhbw.vs.jaxbserialization;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Validator;
import javax.xml.namespace.QName;

/**
 * Testprogramm für JAXB-Marshalling 
 * @author Prof. Dr. Julian Reichwald <julian.reichwald@dhbw-mannheim.de>
 *
 */

public class TestMain {
	
	public static void main(String[] args) {	
		
		Kunde p = new Kunde(); 
		p.setVorname("Max");
		p.setNachname("Mustermann");
		p.setKnr(42);
		
		try {
			// JAXB initialisieren
			JAXBContext kundenContext = JAXBContext.newInstance(Kunde.class);
			Marshaller jaxbMarshaller = kundenContext.createMarshaller();
			Unmarshaller jaxbUnmarshaller = kundenContext.createUnmarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			// Datei erzeugen 
			File f = File.createTempFile("jaxbexample",".xml");
			
			// Kunde in tmp-Datei schreiben
			jaxbMarshaller.marshal(p, f);			
			jaxbMarshaller.marshal(p, System.out);
			System.out.println("XML geschrieben in Datei: " + f.toString());
			
			// Kunde aus tmp-Datei lesen
			Kunde kundeAusXML = (Kunde)jaxbUnmarshaller.unmarshal(f);
			System.out.println("Kunde in XML-Datei: " + kundeAusXML.getKnr()+", "+kundeAusXML.getVorname()+" "+kundeAusXML.getNachname());
			
		} catch (Exception e) { e.printStackTrace(); }
	}
}
