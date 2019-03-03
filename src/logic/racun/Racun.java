package logic.racun;

public class Racun {
	private int brojDanaObracunskogPerioda;
	private String vrstaBrojila;
	private double utrosenoVisa;
	private double utrosenoNiza;
	private double utrosenoSrednja;
	private String vrstaPrikljucka;
	private double odobrenaSnaga;
	private boolean taksaZaRTS;
	private double ukupnoUtroseno;
	public Racun() {
	}

	public Racun(int brDanaObrPerioda, double utrosenoVisa, double utrosenoNiza, String vrstaPrikljucka,
			String vrstaBrojila, double odobrenaSnaga) {
		this.brojDanaObracunskogPerioda = brDanaObrPerioda;
		this.utrosenoVisa = utrosenoVisa;
		this.utrosenoNiza = utrosenoNiza;
		this.vrstaPrikljucka = vrstaPrikljucka;
		this.vrstaBrojila = vrstaBrojila;
		this.odobrenaSnaga = odobrenaSnaga;
	}

	public int getBrojDanaObracunskogPerioda() {
		return brojDanaObracunskogPerioda;
	}

	public void setBrojDanaObracunskogPerioda(int brojDanaObracunskogPerioda) {
		this.brojDanaObracunskogPerioda = brojDanaObracunskogPerioda;
	}

	public String getVrstaBrojila() {
		return vrstaBrojila;
	}

	public void setVrstaBrojila(String vrstaBrojila) {
		this.vrstaBrojila = vrstaBrojila;
	}

	public double getUtrosenoVisa() {
		return utrosenoVisa;
	}

	public void setUtrosenoVisa(double d) {
		this.utrosenoVisa = d;
	}

	public double getUtrosenoNiza() {
		return utrosenoNiza;
	}

	public void setUtrosenoNiza(double utrosenoNiza) {
		this.utrosenoNiza = utrosenoNiza;
	}

	public double getUtrosenoSrednja() {
		return utrosenoSrednja;
	}

	public void setUtrosenoSrednja(double utrosenoSrednja) {
		this.utrosenoSrednja = utrosenoSrednja;
	}

	public String getVrstaPrikljucka() {
		return vrstaPrikljucka;
	}

	public void setVrstaPrikljucka(String vrstaPrikljucka) {
		this.vrstaPrikljucka = vrstaPrikljucka;
	}

	public double getOdobrenaSnaga() {
		return odobrenaSnaga;
	}

	public void setOdobrenaSnaga(double odobrenaSnaga) {
		this.odobrenaSnaga = odobrenaSnaga;
	}

	public boolean isTaksaZaRTS() {
		return taksaZaRTS;
	}

	public void setTaksaZaRTS(boolean taksaZaRTS) {
		this.taksaZaRTS = taksaZaRTS;
	}

	public double getUkupnoUtroseno() {
		return ukupnoUtroseno;
	}

	public void setUkupnoUtroseno(double ukupnoUtroseno) {
		this.ukupnoUtroseno = ukupnoUtroseno;
	}

}
