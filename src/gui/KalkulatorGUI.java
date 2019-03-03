package gui;

import java.awt.EventQueue;
import gui.kontroler.GUIKontroler;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import logic.Logika;
import logic.racun.Racun;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class KalkulatorGUI extends JFrame {
	protected JTextField txtBrDanaObrPeriod;
	protected JTextField txtUtrosenoUVisoj;
	protected JTextField txtUtrosenoUNizoj;
	private JTable zelenaZonaJtable;
	private JTable plavaZonaJTable;
	protected JTable crvenaZonaJTable;
	protected JTable tableStavke;
	private JComboBox cmbVrstaPrikljucka;
	private JComboBox vrstaBrojila;
	private JComboBox cmbOdobrenaSnaga;
	private int taksa = 1;

	public KalkulatorGUI() {
		setTitle("KALKULATOR POTROSNJE");
		setBounds(100, 100, 799, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblBrojDanaObracunskog = new JLabel("Broj dana obracunskog perioda:");
		lblBrojDanaObracunskog.setBounds(10, 47, 161, 25);
		getContentPane().add(lblBrojDanaObracunskog);

		JLabel lblKalkulatorPotrosnjeZa = new JLabel("KALKULATOR POTROSNJE ZA DOMACINSTVA");
		lblKalkulatorPotrosnjeZa.setHorizontalAlignment(SwingConstants.CENTER);
		lblKalkulatorPotrosnjeZa.setBounds(150, 11, 399, 25);
		getContentPane().add(lblKalkulatorPotrosnjeZa);
		txtBrDanaObrPeriod = new JTextField();
		txtBrDanaObrPeriod.setText("30");
		txtBrDanaObrPeriod.setBounds(181, 49, 96, 20);
		getContentPane().add(txtBrDanaObrPeriod);
		txtBrDanaObrPeriod.setColumns(10);

		JLabel lblVrstaBrojila = new JLabel("Vrsta brojila:");
		lblVrstaBrojila.setBounds(10, 83, 161, 25);
		getContentPane().add(lblVrstaBrojila);

		JComboBox cmbvrstaBrojila = new JComboBox();
		cmbvrstaBrojila.setModel(new DefaultComboBoxModel(new String[] { "DVOTARIFNO", "JEDNOTARIFNO" }));
		cmbvrstaBrojila.setBounds(181, 80, 108, 25);
		getContentPane().add(cmbvrstaBrojila);

		JLabel lblUtrosenoUVisoj = new JLabel("Utroseno u visoj tarifi:");
		lblUtrosenoUVisoj.setBounds(10, 119, 161, 25);
		getContentPane().add(lblUtrosenoUVisoj);

		JLabel lblUtrosenoUNizoj = new JLabel("Utroseno u nizoj tarifi:");
		lblUtrosenoUNizoj.setBounds(10, 155, 161, 25);
		getContentPane().add(lblUtrosenoUNizoj);

		JLabel lblVrstaPrikljucka = new JLabel("Vrsta prikljucka:");
		lblVrstaPrikljucka.setBounds(10, 191, 161, 25);
		getContentPane().add(lblVrstaPrikljucka);

		txtUtrosenoUVisoj = new JTextField();
		txtUtrosenoUVisoj.setBounds(181, 121, 96, 20);
		getContentPane().add(txtUtrosenoUVisoj);
		txtUtrosenoUVisoj.setColumns(10);

		txtUtrosenoUNizoj = new JTextField();
		txtUtrosenoUNizoj.setBounds(181, 157, 96, 20);
		getContentPane().add(txtUtrosenoUNizoj);
		txtUtrosenoUNizoj.setColumns(10);

		JComboBox cmbVrstaPrikljucka = new JComboBox();
		cmbVrstaPrikljucka.setModel(new DefaultComboBoxModel(new String[] { "TROFAZNO", "MONOFAZNO" }));
		cmbVrstaPrikljucka.setBounds(181, 191, 96, 25);
		getContentPane().add(cmbVrstaPrikljucka);

		JLabel lblKwh = new JLabel("kWh");
		lblKwh.setBounds(287, 124, 48, 14);
		getContentPane().add(lblKwh);

		JLabel label = new JLabel("kWh");
		label.setBounds(287, 160, 48, 14);
		getContentPane().add(label);
		JLabel lblOdobrenaSnaga = new JLabel("Odobrena snaga:");
		lblOdobrenaSnaga.setBounds(297, 191, 87, 25);
		getContentPane().add(lblOdobrenaSnaga);

		JComboBox cmbOdobrenaSnaga = new JComboBox();
		cmbOdobrenaSnaga.setModel(new DefaultComboBoxModel(
				new String[] { "6.90", "11.04", "13.08", "17.25", "22.08", "24.15", "27.60", "34.50", "43.47" }));
		cmbOdobrenaSnaga.setBounds(394, 191, 70, 25);
		getContentPane().add(cmbOdobrenaSnaga);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(0, 260, 774, 218);
		getContentPane().add(scrollPane);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(110, 10));
		scrollPane.setRowHeaderView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblZelenaZona = new JLabel("ZELENA ZONA");
		lblZelenaZona.setHorizontalAlignment(SwingConstants.CENTER);
		lblZelenaZona.setBorder(new LineBorder(new Color(0, 153, 0), 1, true));
		lblZelenaZona.setPreferredSize(new Dimension(100, 51));
		panel.add(lblZelenaZona);

		JLabel lblPlavaZona = new JLabel("PLAVA ZONA");
		lblPlavaZona.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlavaZona.setBorder(new LineBorder(new Color(0, 102, 255), 1, true));
		lblPlavaZona.setPreferredSize(new Dimension(100, 51));
		panel.add(lblPlavaZona);

		JLabel lblCrvenaZona = new JLabel("CRVENA ZONA");
		lblCrvenaZona.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrvenaZona.setBorder(new LineBorder(new Color(204, 51, 0), 1, true));
		lblCrvenaZona.setPreferredSize(new Dimension(100, 51));
		panel.add(lblCrvenaZona);

		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);

		setZelenaZonaJtable(new JTable());
		getZelenaZonaJtable().setRowSelectionAllowed(false);
		getZelenaZonaJtable().setRowHeight(20);
		getZelenaZonaJtable().setGridColor(new Color(0, 153, 0));
		getZelenaZonaJtable().setBorder(new LineBorder(new Color(0, 153, 0)));
		getZelenaZonaJtable().setBounds(10, 11, 632, 40);
		getZelenaZonaJtable().setModel(new DefaultTableModel(
				new Object[][] { { " Visa tarifa:", null, new Double(5.962), null },
						{ " Niza tarifa:", null, new Double(1.491), null }, },
				new String[] { "", "Utroseno(kWh)", "Cena po jedinici", "Iznos(din)" }) {
			Class[] columnTypes = new Class[] { String.class, Double.class, Double.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		panel_1.add(getZelenaZonaJtable());

		setPlavaZonaJTable(new JTable());
		getPlavaZonaJTable().setRowSelectionAllowed(false);
		getPlavaZonaJTable().setModel(new DefaultTableModel(
				new Object[][] { { " Visa tarifa:", null, new Double(8.943), null },
						{ " Niza tarifa:", null, new Double(2.236), null }, },
				new String[] { "", "Utoseno(kWh)", "Cena po Jedinici", "Iznos(din)" }) {
			Class[] columnTypes = new Class[] { String.class, Double.class, Double.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		getPlavaZonaJTable().setRowHeight(20);
		getPlavaZonaJTable().setGridColor(new Color(0, 0, 255));
		getPlavaZonaJTable().setBorder(new LineBorder(new Color(0, 102, 255), 1, true));
		getPlavaZonaJTable().setBounds(10, 62, 632, 40);
		panel_1.add(getPlavaZonaJTable());

		crvenaZonaJTable = new JTable();
		getCrvenaZonaJTable().setRowSelectionAllowed(false);
		getCrvenaZonaJTable().setModel(new DefaultTableModel(
				new Object[][] { { " Visa tarifa:", null, new Double(17.887), null },
						{ " Niza tarifa:", null, new Double(4.472), null }, },
				new String[] { "", "Utroseno(kWh)", "Cena po jedinici", "Iznos(din)" }) {
			Class[] columnTypes = new Class[] { String.class, Double.class, Double.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		getCrvenaZonaJTable().setRowHeight(20);
		getCrvenaZonaJTable().setGridColor(new Color(204, 0, 0));
		getCrvenaZonaJTable().setBorder(new LineBorder(new Color(204, 0, 0), 1, true));
		getCrvenaZonaJTable().setBounds(10, 125, 632, 40);
		panel_1.add(getCrvenaZonaJTable());

		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 40));
		scrollPane.setColumnHeaderView(panel_2);
		panel_2.setLayout(null);

		JLabel lblUtroseno = new JLabel("Utroseno(kWh)");
		lblUtroseno.setHorizontalAlignment(SwingConstants.CENTER);
		lblUtroseno.setBounds(169, 0, 155, 40);
		panel_2.add(lblUtroseno);

		JLabel lblCenaPoJedinici = new JLabel("Cena po jedinici");
		lblCenaPoJedinici.setHorizontalAlignment(SwingConstants.CENTER);
		lblCenaPoJedinici.setBounds(326, 0, 155, 40);
		panel_2.add(lblCenaPoJedinici);

		JLabel lblIznosdin = new JLabel("Iznos(din)");
		lblIznosdin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIznosdin.setBounds(487, 0, 155, 40);
		panel_2.add(lblIznosdin);

		JCheckBox chckbxTaksaZaJavni = new JCheckBox("Taksa za javni medijski servis");
		chckbxTaksaZaJavni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taksa += 1;
			}
		});
		chckbxTaksaZaJavni.setBounds(181, 223, 203, 23);
		getContentPane().add(chckbxTaksaZaJavni);

		JButton btnIzracunaj = new JButton("Izracunaj");
		btnIzracunaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.pokupiPodatke(Integer.parseInt(txtBrDanaObrPeriod.getText()),
						Double.parseDouble(txtUtrosenoUVisoj.getText()),
						Double.parseDouble(txtUtrosenoUNizoj.getText()),
						String.valueOf(cmbVrstaPrikljucka.getSelectedItem()),
						String.valueOf(cmbvrstaBrojila.getSelectedItem()), taksa,
						Double.parseDouble((String) cmbOdobrenaSnaga.getSelectedItem()));
				GUIKontroler.izracunaj();
			}
		});
		btnIzracunaj.setBounds(460, 226, 89, 23);
		getContentPane().add(btnIzracunaj);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 489, 764, 211);
		getContentPane().add(panel_3);

		tableStavke = new JTable();
		tableStavke.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableStavke.setRowHeight(21);
		tableStavke.setSize(new Dimension(754, 200));
		tableStavke.setPreferredSize(new Dimension(754, 200));
		tableStavke.setShowGrid(false);
		tableStavke.setBackground(new Color(255, 255, 255));
		tableStavke.setForeground(new Color(0, 0, 0));
		tableStavke.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableStavke.setCellSelectionEnabled(true);
		tableStavke.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				c.setBackground(row % 2 == 0 ? new Color(200, 222, 255) : Color.WHITE);
				return c;
			}
		});
		tableStavke.setBounds(0, 0, 754, 211);
		tableStavke.setModel(new DefaultTableModel(new Object[][] {
				{ "\u041E\u0431\u0440\u0430\u0447\u0443\u043D\u0441\u043A\u0430 \u0441\u043D\u0430\u0433\u0430 (kW):",
						null, null, null },
				{ "\u0422\u0440\u043E\u0448\u0430\u043A \u0433\u0430\u0440\u0430\u043D\u0442\u043E\u0432\u0430\u043D\u043E\u0433 \u0441\u043D\u0430\u0431\u0434\u0435\u0432\u0430\u0447\u0430:",
						null, null, null },
				{ "\u041D\u0430\u043A\u043D\u0430\u0434\u0430 \u0437\u0430 \u043F\u043E\u0432\u043B. \u043F\u0440\u043E\u0438\u0437\u0432. \u0435\u043B. \u0435\u043D\u0435\u0440\u0433\u0438\u0458\u0435:",
						null, null, null },
				{ "\u041E\u0441\u043D\u043E\u0432\u0438\u0446\u0430 \u0437\u0430 \u043E\u0431\u0440\u0430\u0447\u0443\u043D \u0430\u043A\u0446\u0438\u0437\u0435:",
						null, null, null },
				{ "\u0418\u0437\u043D\u043E\u0441 \u0430\u043A\u0446\u0438\u0437\u0435 (7,5%):", null, null, null },
				{ "\u041E\u0441\u043D\u043E\u0432\u0438\u0446\u0430 \u0437\u0430 \u043E\u0431\u0440\u0430\u0447\u0443\u043D \u041F\u0414\u0412-\u0430:",
						null, null, null },
				{ "\u041F\u0414\u0412 (20%):", null, null, null },
				{ "\u0417\u0430\u0434\u0443\u0436\u0435\u045A\u0435 \u0437\u0430 \u043E\u0431\u0440\u0430\u0447\u0443\u043D\u0441\u043A\u0438 \u043F\u0435\u0440\u0438\u043E\u0434:",
						null, null, null },
				{ "\u0422\u0430\u043A\u0441\u0430 \u0437\u0430 \u0458\u0430\u0432\u043D\u0438 \u043C\u0435\u0434\u0438\u0458\u0441\u043A\u0438 \u0441\u0435\u0440\u0432\u0438\u0441:",
						null, null, null },
				{ "\u0423\u043A\u0443\u043F\u043D\u043E \u0437\u0430\u0434\u0443\u0436\u0435\u045A\u0435 \u0437\u0430 \u043E\u0431\u0440. \u043F\u0435\u0440\u0438\u043E\u0434:",
						null, null, null }, },
				new String[] { "Stavke", "Utroseno(kWh)", "Cena po jedinici", "Iznos(din)" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableStavke.getColumnModel().getColumn(0).setPreferredWidth(199);

		panel_3.setLayout(null);
		panel_3.add(tableStavke);
	}

	public JTable getZelenaZonaJtable() {
		return zelenaZonaJtable;
	}

	public void setZelenaZonaJtable(JTable zelenaZonaJtable) {
		this.zelenaZonaJtable = zelenaZonaJtable;
	}

	public JTable getPlavaZonaJTable() {
		return plavaZonaJTable;
	}

	public void setPlavaZonaJTable(JTable plavaZonaJTable) {
		this.plavaZonaJTable = plavaZonaJTable;
	}
	public void setCrvenaZonaJTable(JTable crvenaZonaJTable) {
		this.crvenaZonaJTable = crvenaZonaJTable;
	}

	public JTable getCrvenaZonaJTable() {
		// TODO Auto-generated method stub
		return crvenaZonaJTable;
	}
	
}

/**
 * Create the application.
 */

/**
 * Initialize the contents of the frame.
 */
