package logic;

import javax.swing.table.DefaultTableModel;
import gui.kontroler.GUIKontroler;
import logic.racun.Racun;
import logic.racun.StavkeRacuna;
import logic.zona.Zona;

public class Logika {
    public static Racun racun = new Racun();
    public static StavkeRacuna stavke = new StavkeRacuna();
    public static Zona zelenaZona = new Zona();
    public static Zona plavaZona = new Zona();
    public static Zona crvenaZona = new Zona();
    public static GUIKontroler kontroler = new GUIKontroler();

    public static void izracunajUkupnoUtrosenoKWH() {
	racun.setUkupnoUtroseno(racun.getUtrosenoNiza() + racun.getUtrosenoVisa());
    }
    
    public static void izracunaj() {
	izracunajUkupnoUtrosenoKWH();
	podeliKwhPoZonama();
    }

	private static void podeliKwhPoZonama() {
		zelenaZona.setMaxKwh(350*racun.getBrojDanaObracunskogPerioda()/30);
		plavaZona.setMaxKwh(1600*racun.getBrojDanaObracunskogPerioda()/30);
		if(racun.getUkupnoUtroseno()<=zelenaZona.getMaxKwh()) {
			zelenaZona.setUtrosenoVisa(racun.getUtrosenoVisa());
			zelenaZona.setUtrosenoNiza(racun.getUtrosenoNiza());
			plavaZona.setUtrosenoVisa(0);
			plavaZona.setUtrosenoNiza(0);
			crvenaZona.setUtrosenoVisa(0);
			crvenaZona.setUtrosenoNiza(0);
			
		}
		plavaZona.setRaspon(plavaZona.getMaxKwh()-zelenaZona.getMaxKwh());
		if(racun.getUkupnoUtroseno()<=plavaZona.getMaxKwh()) {
			zelenaZona.setUtrosenoVisa(racun.getUtrosenoVisa()/racun.getUkupnoUtroseno()*zelenaZona.getMaxKwh());
			zelenaZona.setUtrosenoNiza(racun.getUtrosenoNiza()/racun.getUkupnoUtroseno()*zelenaZona.getMaxKwh());
			plavaZona.setUtrosenoVisa(racun.getUtrosenoVisa()/racun.getUkupnoUtroseno()*(racun.getUkupnoUtroseno()-zelenaZona.getMaxKwh()));
			plavaZona.setUtrosenoNiza(racun.getUtrosenoNiza()/racun.getUkupnoUtroseno()*(racun.getUkupnoUtroseno()-zelenaZona.getMaxKwh()));
			crvenaZona.setUtrosenoVisa(0);
			crvenaZona.setUtrosenoNiza(0);
			
		}else {
		zelenaZona.setUtrosenoVisa(racun.getUtrosenoVisa()/racun.getUkupnoUtroseno()*zelenaZona.getMaxKwh());
		zelenaZona.setUtrosenoNiza(racun.getUtrosenoNiza()/racun.getUkupnoUtroseno()*zelenaZona.getMaxKwh());
		plavaZona.setUtrosenoVisa(racun.getUtrosenoVisa()/racun.getUkupnoUtroseno()*plavaZona.getRaspon());
		plavaZona.setUtrosenoNiza(racun.getUtrosenoNiza()/racun.getUkupnoUtroseno()*plavaZona.getRaspon());
		crvenaZona.setUtrosenoVisa(racun.getUtrosenoVisa()-zelenaZona.getUtrosenoVisa()-plavaZona.getUtrosenoVisa());
		crvenaZona.setUtrosenoNiza(racun.getUtrosenoNiza()-zelenaZona.getUtrosenoNiza()-plavaZona.getUtrosenoNiza());
		}	
	}  
}
