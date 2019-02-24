package logic;

import gui.GlavniProzor;
import logic.racun.Racun;
import logic.racun.StavkeRacuna;
import logic.zona.Zona;

public class Logika {
    public static Racun racun = new Racun();
    public static StavkeRacuna stavke = new StavkeRacuna();
    public static Zona zelenaZona = new Zona();
    public static Zona plavaZona = new Zona();
    public static Zona crvenaZona = new Zona();
    public static GlavniProzor gl = new GlavniProzor();

    public static void izracunajUkupnoUtrosenoKWH() {
	racun.setUkupnoUtroseno(racun.getUtrosenoNiza() + racun.getUtrosenoVisa());
    }

  

    private static void pokupiPodatke() {
	racun = gl.pokupiPodatke();
	izracunajUkupnoUtrosenoKWH();
    }

    public static void izracunaj() {
	pokupiPodatke();
	
    }
    
}
