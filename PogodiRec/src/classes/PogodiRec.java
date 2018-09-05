package classes;

import java.util.ArrayList;
import java.util.Random;

import enums.Stanje;
import interfaces.IOperations;

public class PogodiRec implements IOperations{

	protected int brSlova;
	protected String unesenaRec;
	protected Stanje stanje;
	protected int brDozGres;
	protected int brTrenutnihGreski;
	protected String trazenaRec;
	protected ArrayList<String> sveReci;
	protected boolean terminirajProgram;
	
	public String getUnesenaRec() {
		return unesenaRec;
	}
	public void setUnesenaRec(String unesenaRec) {
		this.unesenaRec = unesenaRec;
	}
	public Stanje getStanje() {
		return stanje;
	}
	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}
	public int getBrDozGres() {
		return brDozGres;
	}
	public void setBrDozGres(int brDozGres) {
		this.brDozGres = brDozGres;
	}
	
	public int getBrSlova() {
		return brSlova;
	}
	public void setBrSlova(int brSlova) {
		this.brSlova = brSlova;
	}
	public int getBrTrenutnihGreski() {
		return brTrenutnihGreski;
	}
	public void setBrTrenutnihGreski(int brTrenutnihGreski) {
		this.brTrenutnihGreski = brTrenutnihGreski;
	}
	public String getTrazenaRec() {
		return trazenaRec;
	}
	public void setTrazenaRec(String trazenaRec) {
		this.trazenaRec = trazenaRec;
	}
	public ArrayList<String> getSveReci() {
		return sveReci;
	}
	public void setSveReci(ArrayList<String> sveReci) {
		this.sveReci = sveReci;
	}
	public boolean is_terminirajProgram() {
		return terminirajProgram;
	}
	public void set_terminirajProgram(boolean _terminirajProgram) {
		this.terminirajProgram = _terminirajProgram;
	}
	public PogodiRec() {
		
		this.sveReci = new ArrayList<String>();
		
		this.sveReci.add("Zorica");
		this.sveReci.add("Lizalica");
		this.sveReci.add("Fan");
		
		Random rnd = new Random();
		
		int indeksReci = rnd.nextInt(this.sveReci.size());
		
		this.trazenaRec = this.sveReci.get(indeksReci);
		
		this.brSlova = this.trazenaRec.length();
		
		this.brDozGres = this.brSlova + 5;
		
		this.terminirajProgram = false;
		
		this.unesenaRec = "";
		this.brTrenutnihGreski = 0;
		this.stanje = Stanje.sNijePogodjena;
		
		}
	
	@Override
	public Stanje Validacija (String unetaRec){
		
		this.unesenaRec = unetaRec;
		boolean pogodjenaRec = false;
		
		if(this.trazenaRec.toLowerCase().trim().equals(this.unesenaRec.toLowerCase().trim())){
			this.stanje = Stanje.sPogodjena;
			pogodjenaRec = true;
		}
		else {
			
			this.stanje = Stanje.sNijePogodjena;
			this.brTrenutnihGreski++;
			
		}
		if (!pogodjenaRec)
		{
			if (this.trazenaRec.toLowerCase().trim().contains(this.unesenaRec.toLowerCase().trim())) 
				this.stanje = Stanje.sPodRec;
		}
		
		if (this.brTrenutnihGreski>=this.brDozGres) this.terminirajProgram = true;
		
		
		return this.stanje;
		
	}
	
}
