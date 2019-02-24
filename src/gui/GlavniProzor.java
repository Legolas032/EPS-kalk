package gui;

import java.awt.EventQueue;

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

import logic.Logika;
import logic.racun.Racun;

import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor {

    protected JFrame frmKalkulatorPotrosnje;
    protected JTextField txtBrDanaObrPeriod;
    protected JTextField txtUtrosenoUVisoj;
    protected JTextField txtUtrosenoUNizoj;
    protected JTable table;
    protected JTable table_2;
    protected JTable table_3;
    protected JTable tableStavke;
    private JComboBox cmbVrstaPrikljucka;
    private JComboBox vrstaBrojila;
    private JComboBox cmbOdobrenaSnaga;
    private int taksa = 1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    GlavniProzor window = new GlavniProzor();
		    window.frmKalkulatorPotrosnje.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public GlavniProzor() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frmKalkulatorPotrosnje = new JFrame();
	frmKalkulatorPotrosnje.setTitle("KALKULATOR POTROSNJE");
	frmKalkulatorPotrosnje.setBounds(100, 100, 799, 750);
	frmKalkulatorPotrosnje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmKalkulatorPotrosnje.getContentPane().setLayout(null);

	JLabel lblBrojDanaObracunskog = new JLabel("Broj dana obracunskog perioda:");
	lblBrojDanaObracunskog.setBounds(10, 47, 161, 25);
	frmKalkulatorPotrosnje.getContentPane().add(lblBrojDanaObracunskog);

	JLabel lblKalkulatorPotrosnjeZa = new JLabel("KALKULATOR POTROSNJE ZA DOMACINSTVA");
	lblKalkulatorPotrosnjeZa.setHorizontalAlignment(SwingConstants.CENTER);
	lblKalkulatorPotrosnjeZa.setBounds(150, 11, 399, 25);
	frmKalkulatorPotrosnje.getContentPane().add(lblKalkulatorPotrosnjeZa);
	txtBrDanaObrPeriod = new JTextField();
	txtBrDanaObrPeriod.setText("30");
	txtBrDanaObrPeriod.setBounds(181, 49, 96, 20);
	frmKalkulatorPotrosnje.getContentPane().add(txtBrDanaObrPeriod);
	txtBrDanaObrPeriod.setColumns(10);

	JLabel lblVrstaBrojila = new JLabel("Vrsta brojila:");
	lblVrstaBrojila.setBounds(10, 83, 161, 25);
	frmKalkulatorPotrosnje.getContentPane().add(lblVrstaBrojila);

	JComboBox vrstaBrojila = new JComboBox();
	vrstaBrojila.setModel(new DefaultComboBoxModel(new String[] { "DVOTARIFNO", "JEDNOTARIFNO" }));
	vrstaBrojila.setBounds(181, 80, 96, 25);
	frmKalkulatorPotrosnje.getContentPane().add(vrstaBrojila);

	JLabel lblUtrosenoUVisoj = new JLabel("Utroseno u visoj tarifi:");
	lblUtrosenoUVisoj.setBounds(10, 119, 161, 25);
	frmKalkulatorPotrosnje.getContentPane().add(lblUtrosenoUVisoj);

	JLabel lblUtrosenoUNizoj = new JLabel("Utroseno u nizoj tarifi:");
	lblUtrosenoUNizoj.setBounds(10, 155, 161, 25);
	frmKalkulatorPotrosnje.getContentPane().add(lblUtrosenoUNizoj);

	JLabel lblVrstaPrikljucka = new JLabel("Vrsta prikljucka:");
	lblVrstaPrikljucka.setBounds(10, 191, 161, 25);
	frmKalkulatorPotrosnje.getContentPane().add(lblVrstaPrikljucka);

	txtUtrosenoUVisoj = new JTextField();
	txtUtrosenoUVisoj.setBounds(181, 121, 96, 20);
	frmKalkulatorPotrosnje.getContentPane().add(txtUtrosenoUVisoj);
	txtUtrosenoUVisoj.setColumns(10);

	txtUtrosenoUNizoj = new JTextField();
	txtUtrosenoUNizoj.setBounds(181, 157, 96, 20);
	frmKalkulatorPotrosnje.getContentPane().add(txtUtrosenoUNizoj);
	txtUtrosenoUNizoj.setColumns(10);

	JComboBox cmbVrstaPrikljucka = new JComboBox();
	cmbVrstaPrikljucka.setModel(new DefaultComboBoxModel(new String[] { "TROFAZNO", "MONOFAZNO" }));
	cmbVrstaPrikljucka.setBounds(181, 191, 96, 25);
	frmKalkulatorPotrosnje.getContentPane().add(cmbVrstaPrikljucka);

	JLabel lblKwh = new JLabel("kWh");
	lblKwh.setBounds(287, 124, 48, 14);
	frmKalkulatorPotrosnje.getContentPane().add(lblKwh);

	JLabel label = new JLabel("kWh");
	label.setBounds(287, 160, 48, 14);
	frmKalkulatorPotrosnje.getContentPane().add(label);

	JLabel lblOdobrenaSnaga = new JLabel("Odobrena snaga:");
	lblOdobrenaSnaga.setBounds(297, 191, 87, 25);
	frmKalkulatorPotrosnje.getContentPane().add(lblOdobrenaSnaga);

	JComboBox cmbOdobrenaSnaga = new JComboBox();
	cmbOdobrenaSnaga.setModel(new DefaultComboBoxModel(
		new String[] { "6.90", "11.04", "13.08", "17.25", "22.08", "24.15", "27.60", "34.50", "43.47" }));
	cmbOdobrenaSnaga.setBounds(394, 191, 70, 25);
	frmKalkulatorPotrosnje.getContentPane().add(cmbOdobrenaSnaga);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setViewportBorder(null);
	scrollPane.setBounds(0, 260, 774, 218);
	frmKalkulatorPotrosnje.getContentPane().add(scrollPane);

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

	table = new JTable();
	table.setRowSelectionAllowed(false);
	table.setRowHeight(20);
	table.setGridColor(new Color(0, 153, 0));
	table.setBorder(new LineBorder(new Color(0, 153, 0)));
	table.setBounds(10, 11, 632, 40);
	table.setModel(new DefaultTableModel(
		new Object[][] { { " Visa tarifa:", null, new Double(5.962), null },
			{ " Niza tarifa:", null, new Double(1.491), null }, },
		new String[] { "", "Utroseno(kWh)", "Cena po jedinici", "Iznos(din)" }) {
	    Class[] columnTypes = new Class[] { String.class, Double.class, Double.class, Double.class };

	    public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	    }

	    boolean[] columnEditables = new boolean[] { true, true, false, true };

	    public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	    }
	});
	panel_1.add(table);

	table_2 = new JTable();
	table_2.setRowSelectionAllowed(false);
	table_2.setModel(new DefaultTableModel(
		new Object[][] { { " Visa tarifa:", null, new Double(8.943), null },
			{ " Niza tarifa:", null, new Double(2.236), null }, },
		new String[] { "", "Utoseno(kWh)", "Cena po Jedinici", "Iznos(din)" }) {
	    Class[] columnTypes = new Class[] { String.class, Integer.class, Double.class, Double.class };

	    public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	    }

	    boolean[] columnEditables = new boolean[] { true, true, false, true };

	    public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	    }
	});
	table_2.setRowHeight(20);
	table_2.setGridColor(new Color(0, 0, 255));
	table_2.setBorder(new LineBorder(new Color(0, 102, 255), 1, true));
	table_2.setBounds(10, 62, 632, 40);
	panel_1.add(table_2);

	table_3 = new JTable();
	table_3.setRowSelectionAllowed(false);
	table_3.setModel(new DefaultTableModel(
		new Object[][] { { " Visa tarifa:", null, new Double(17.887), null },
			{ " Niza tarifa:", null, new Double(4.472), null }, },
		new String[] { "", "Utroseno(kWh)", "Cena po jedinici", "Iznos(din)" }) {
	    Class[] columnTypes = new Class[] { String.class, Integer.class, Double.class, Double.class };

	    public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	    }

	    boolean[] columnEditables = new boolean[] { true, true, false, true };

	    public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	    }
	});
	table_3.setRowHeight(20);
	table_3.setGridColor(new Color(204, 0, 0));
	table_3.setBorder(new LineBorder(new Color(204, 0, 0), 1, true));
	table_3.setBounds(10, 125, 632, 40);
	panel_1.add(table_3);

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
		taksa+=1;
	    }
	});
	chckbxTaksaZaJavni.setBounds(181, 223, 203, 23);
	frmKalkulatorPotrosnje.getContentPane().add(chckbxTaksaZaJavni);

	JButton btnIzracunaj = new JButton("Izracunaj");
	btnIzracunaj.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		Logika.izracunaj();
	    }
	});
	btnIzracunaj.setBounds(460, 226, 89, 23);
	frmKalkulatorPotrosnje.getContentPane().add(btnIzracunaj);

	JPanel panel_3 = new JPanel();
	panel_3.setBounds(10, 489, 764, 211);
	frmKalkulatorPotrosnje.getContentPane().add(panel_3);

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

    public Racun pokupiPodatke() {
	Racun r = new Racun();
	r.setBrojDanaObracunskogPerioda(Integer.parseInt(txtBrDanaObrPeriod.getText()));
	r.setUtrosenoVisa(Integer.parseInt(txtUtrosenoUVisoj.getText()));
	r.setUtrosenoNiza(Integer.parseInt(txtUtrosenoUNizoj.getText()));
	r.setVrstaPrikljucka(String.valueOf(cmbVrstaPrikljucka.getSelectedItem()));
	r.setVrstaBrojila(String.valueOf(vrstaBrojila.getSelectedItem()));
	if(taksa%2 == 0) {
	r.setTaksaZaRTS(true);
	}else
	    r.setTaksaZaRTS(false);
	r.setOdobrenaSnaga(Double.parseDouble(String.valueOf(cmbOdobrenaSnaga.getSelectedItem())));
	return r;
    }
}
