import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

public class Frame extends JFrame implements ActionListener {

	public static int amountP, taxP, priceP = 0;

	private double nettoD, bruttoD, amountFinal, taxFinal, priceFinal = 0;
	private int amount, tax, price = 0;
	private String path, netto, brutto = "";
	// private int amount, tax, price;
	private JPanel contentPane;
	private JTextField textPath;
	private JLabel lblStawkaVat;
	private JSpinner spinner_tax;
	private JSpinner spinner_price;
	private JSpinner spinner_amount;
	private JLabel lblCenaBrutto;
	private JLabel lblCenaNetto;
	private JLabel lblPriceB;
	private JLabel lblPriceN;
	private JLabel lblPln;
	private JLabel lblPln_1;
	private JLabel lblPrzykad;
	private JButton btnLicz;
	private JButton btnImport;
	private JButton btnExport;

	public Frame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 327, 100, 111, 0 };
		gbl_contentPane.rowHeights = new int[] { 23, 27, 0, 25, 25, 34, 0, 0, 33, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		SpinnerModel price = new SpinnerNumberModel(0, 0, 2147483647, 1);
		SpinnerModel amount = new SpinnerNumberModel(0, 0, 2147483647, 1);
		SpinnerModel tax = new SpinnerNumberModel(0, 0, 100, 1);

		textPath = new JTextField();
		GridBagConstraints gbc_textPath = new GridBagConstraints();
		gbc_textPath.insets = new Insets(0, 0, 5, 5);
		gbc_textPath.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPath.gridx = 0;
		gbc_textPath.gridy = 0;
		contentPane.add(textPath, gbc_textPath);
		textPath.setColumns(10);

		btnImport = new JButton("Import");
		GridBagConstraints gbc_btnImport = new GridBagConstraints();
		gbc_btnImport.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImport.insets = new Insets(0, 0, 5, 5);
		gbc_btnImport.gridx = 1;
		gbc_btnImport.gridy = 0;
		contentPane.add(btnImport, gbc_btnImport);
		btnImport.addActionListener(this);

		btnExport = new JButton("Export");
		GridBagConstraints gbc_btnExport = new GridBagConstraints();
		gbc_btnExport.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExport.insets = new Insets(0, 0, 5, 0);
		gbc_btnExport.gridx = 2;
		gbc_btnExport.gridy = 0;
		contentPane.add(btnExport, gbc_btnExport);
		btnExport.addActionListener(this);

		lblPrzykad = new JLabel("Przyk\u0142ad: C:/Users/User/Desktop/plik.xml");
		lblPrzykad.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblPrzykad.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblPrzykad = new GridBagConstraints();
		gbc_lblPrzykad.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrzykad.gridx = 0;
		gbc_lblPrzykad.gridy = 1;
		contentPane.add(lblPrzykad, gbc_lblPrzykad);

		JLabel lblIloTowaru = new JLabel("Ilo\u015B\u0107 Towaru (szt.)");
		GridBagConstraints gbc_lblIloTowaru = new GridBagConstraints();
		gbc_lblIloTowaru.anchor = GridBagConstraints.EAST;
		gbc_lblIloTowaru.insets = new Insets(0, 0, 5, 5);
		gbc_lblIloTowaru.gridx = 0;
		gbc_lblIloTowaru.gridy = 2;
		contentPane.add(lblIloTowaru, gbc_lblIloTowaru);

		spinner_amount = new JSpinner(amount);
		GridBagConstraints gbc_spinner_amount = new GridBagConstraints();
		gbc_spinner_amount.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_amount.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_amount.gridx = 1;
		gbc_spinner_amount.gridy = 2;
		contentPane.add(spinner_amount, gbc_spinner_amount);

		JLabel lblCenaTowaruszt = new JLabel("Cena Towaru (w groszach)");
		GridBagConstraints gbc_lblCenaTowaruszt = new GridBagConstraints();
		gbc_lblCenaTowaruszt.insets = new Insets(0, 0, 5, 5);
		gbc_lblCenaTowaruszt.anchor = GridBagConstraints.EAST;
		gbc_lblCenaTowaruszt.gridx = 0;
		gbc_lblCenaTowaruszt.gridy = 3;
		contentPane.add(lblCenaTowaruszt, gbc_lblCenaTowaruszt);

		spinner_price = new JSpinner(price);
		GridBagConstraints gbc_spinner_price = new GridBagConstraints();
		gbc_spinner_price.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_price.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_price.gridx = 1;
		gbc_spinner_price.gridy = 3;
		contentPane.add(spinner_price, gbc_spinner_price);

		lblStawkaVat = new JLabel("Podatek (%)");
		GridBagConstraints gbc_lblStawkaVat = new GridBagConstraints();
		gbc_lblStawkaVat.insets = new Insets(0, 0, 5, 5);
		gbc_lblStawkaVat.anchor = GridBagConstraints.EAST;
		gbc_lblStawkaVat.gridx = 0;
		gbc_lblStawkaVat.gridy = 4;
		contentPane.add(lblStawkaVat, gbc_lblStawkaVat);

		spinner_tax = new JSpinner(tax);
		spinner_tax.setToolTipText("");
		GridBagConstraints gbc_spinner_tax = new GridBagConstraints();
		gbc_spinner_tax.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_tax.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_tax.gridx = 1;
		gbc_spinner_tax.gridy = 4;
		contentPane.add(spinner_tax, gbc_spinner_tax);

		btnLicz = new JButton("Licz");
		GridBagConstraints gbc_btnLicz = new GridBagConstraints();
		gbc_btnLicz.insets = new Insets(0, 0, 5, 5);
		gbc_btnLicz.gridx = 1;
		gbc_btnLicz.gridy = 5;
		contentPane.add(btnLicz, gbc_btnLicz);
		btnLicz.addActionListener(this);

		lblCenaNetto = new JLabel("Cena Netto");
		GridBagConstraints gbc_lblCenaNetto = new GridBagConstraints();
		gbc_lblCenaNetto.anchor = GridBagConstraints.EAST;
		gbc_lblCenaNetto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCenaNetto.gridx = 0;
		gbc_lblCenaNetto.gridy = 6;
		contentPane.add(lblCenaNetto, gbc_lblCenaNetto);

		lblPriceN = new JLabel("-");
		GridBagConstraints gbc_lblPriceN = new GridBagConstraints();
		gbc_lblPriceN.insets = new Insets(0, 0, 5, 5);
		gbc_lblPriceN.gridx = 1;
		gbc_lblPriceN.gridy = 6;
		contentPane.add(lblPriceN, gbc_lblPriceN);

		lblPln = new JLabel("PLN");
		GridBagConstraints gbc_lblPln = new GridBagConstraints();
		gbc_lblPln.anchor = GridBagConstraints.WEST;
		gbc_lblPln.insets = new Insets(0, 0, 5, 0);
		gbc_lblPln.gridx = 2;
		gbc_lblPln.gridy = 6;
		contentPane.add(lblPln, gbc_lblPln);

		lblCenaBrutto = new JLabel("Cena Brutto");
		GridBagConstraints gbc_lblCenaBrutto = new GridBagConstraints();
		gbc_lblCenaBrutto.anchor = GridBagConstraints.EAST;
		gbc_lblCenaBrutto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCenaBrutto.gridx = 0;
		gbc_lblCenaBrutto.gridy = 7;
		contentPane.add(lblCenaBrutto, gbc_lblCenaBrutto);

		lblPriceB = new JLabel("-");
		GridBagConstraints gbc_lblPriceB = new GridBagConstraints();
		gbc_lblPriceB.insets = new Insets(0, 0, 5, 5);
		gbc_lblPriceB.gridx = 1;
		gbc_lblPriceB.gridy = 7;
		contentPane.add(lblPriceB, gbc_lblPriceB);

		lblPln_1 = new JLabel("PLN");
		GridBagConstraints gbc_lblPln_1 = new GridBagConstraints();
		gbc_lblPln_1.anchor = GridBagConstraints.WEST;
		gbc_lblPln_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblPln_1.gridx = 2;
		gbc_lblPln_1.gridy = 7;
		contentPane.add(lblPln_1, gbc_lblPln_1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		amount = (int) spinner_amount.getValue();
		price = (int) spinner_price.getValue();
		tax = (int) spinner_tax.getValue();
		
		amountP = amount;
		priceP = price;
		taxP = tax;
		
		Object source = e.getSource();
		if (source == btnImport) {
			System.out.println("Import | " + path);
			try {
				path = textPath.getText();
				Import import1 = new Import(path);
				amount = amountP;
				price = priceP;
				tax = taxP;
			} catch (FileNotFoundException e1) {
				System.out.println("Import failed");
			}
		}
		
		spinner_amount.setValue(amountP);
		spinner_price.setValue(priceP);
		spinner_tax.setValue(taxP);

		amountFinal = amount;
		priceFinal = price;
		taxFinal = tax;

		nettoD = (amountFinal * priceFinal) / 100;
		if (tax != 0) {
			bruttoD = ((amountFinal * priceFinal) / 100) - ((((amountFinal * priceFinal) / 100) * taxFinal) / 100);
		} else {
			bruttoD = 0;
		}

		netto = Double.toString(nettoD);
		brutto = Double.toString(bruttoD);

		lblPriceN.setText(netto);
		lblPriceB.setText(brutto);

		if (source == btnExport) {
			System.out.println("Export | " + path);
			try {
				path = textPath.getText();
				Save save1 = new Save(path, amount, price, tax);
			} catch (FileNotFoundException e1) {
				System.out.println("Export failed");
			}
		}
		// } else if (source == btnImport) {
		// System.out.println("Import | " + path);
		// try {
		// Import import1 = new Import(path);
		// } catch (FileNotFoundException e1) {
		// System.out.println("Import failed");
		// }
		if (source == btnLicz) {
			System.out.println("Licz");
		} else {
			System.out.println("Nieznana Akcja");
		}
		System.out.println("Akcja Przetworzona");
	}

}
