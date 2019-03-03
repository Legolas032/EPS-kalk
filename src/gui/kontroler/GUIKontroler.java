package gui.kontroler;

import javax.swing.table.DefaultTableModel;

import gui.KalkulatorGUI;
import logic.Logika;
import logic.racun.Racun;

public class GUIKontroler {
	public static Logika sistem;
	public static KalkulatorGUI gp;

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sistem = new Logika();
					gp = new KalkulatorGUI();
					gp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ugasiAplikaciju() {
		System.exit(0);
	}

	public static void pokupiPodatke(int brDanaObrPerioda, double utrosenoVisa, double utrosenoNiza,
			String vrstaPrikljucka, String vrstaBrojila, int taksa,double odobrenaSnaga) {
		Racun r = new Racun(brDanaObrPerioda, utrosenoVisa, utrosenoNiza, vrstaPrikljucka, vrstaBrojila, odobrenaSnaga);
		if (taksa % 2 == 0) {
			r.setTaksaZaRTS(true);
		} else
			r.setTaksaZaRTS(false);
		Logika.racun=r;
	}
	public static void postaviKwhPoZonama() {
		DefaultTableModel model = (DefaultTableModel) gp.getZelenaZonaJtable().getModel();
		model.setValueAt(Math.round(Logika.zelenaZona.getUtrosenoVisa()), 0, 1);
		model.setValueAt(Math.round(Logika.zelenaZona.getUtrosenoNiza()), 1, 1);
		DefaultTableModel model1 = (DefaultTableModel) gp.getPlavaZonaJTable().getModel();
		model1.setValueAt(Math.round(Logika.plavaZona.getUtrosenoVisa()), 0, 1);
		model1.setValueAt(Math.round(Logika.plavaZona.getUtrosenoNiza()), 1, 1);
		DefaultTableModel model2 = (DefaultTableModel) gp.getCrvenaZonaJTable().getModel();
		model2.setValueAt(Math.round(Logika.crvenaZona.getUtrosenoVisa()), 0, 1);
		model2.setValueAt(Math.round(Logika.crvenaZona.getUtrosenoNiza()), 1, 1);

	}

	public static void izracunaj() {
		Logika.izracunaj();
		postaviKwhPoZonama();
		
	}

}
