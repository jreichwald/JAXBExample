package de.dhbw.vs.jaxbserialization;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * @author Prof. Dr. Julian Reichwald <julian.reichwald@dhbw-mannheim.de>
 * 
 * Repräsentation eines Kunden
 */

@XmlRootElement
public class Kunde {

	private String vorname ; 
	
	private String nachname; 
	
	private int kundennummer;

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public int getKnr() {
		return kundennummer;
	}
	
	@XmlAttribute(name="Kundennummer")
	public void setKnr(int knr) {
		this.kundennummer = knr;
	} 
}
