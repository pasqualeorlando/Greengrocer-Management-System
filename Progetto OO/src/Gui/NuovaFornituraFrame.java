package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import Classi.Persona;
import Controller.Controller;
import Enum.TAllevamento;
import Enum.TFarinaceo;

import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NuovaFornituraFrame extends JFrame {

	private JPanel contentPane;
	private JTextField dataFornituraTF;
	private JTextField nomeProdottoTF;
	private JTextField paeseTF;
	private JTextField marcaTF;
	private JTextField dataScadenzaTF;
	private JTextField jollyTF2;
	private JTextField jollyTF1;
	private JComboBox jollyCB;
	private JComboBox tipoProdottoCB;
	private JComboBox fornitoreCB;
	private JSpinner prezzoFornituraSpinner;
	private JSpinner quantitaNegozioSpinner;
	private JSpinner prezzoSpinner;
	private JSpinner quantitaDepositoSpinner;
	private JLabel jollyLabel1;
	private JLabel jollyLabel2;
	private JLabel dataScadenzaLabel;
	private Controller controller;

	
	public NuovaFornituraFrame(Controller c, Persona p) {
		setTitle("OrtofruttaPerTutti - Nuova Fornitura");
		controller = c;
		JFrame attuale = this;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(NuovaFornituraFrame.class.getResource("/immagini/fruits.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 521);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fornitoreLabel = new JLabel("Fornitore*: ");
		fornitoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
		fornitoreLabel.setForeground(new Color(0, 0, 0));
		fornitoreLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		fornitoreLabel.setBounds(21, 44, 112, 24);
		contentPane.add(fornitoreLabel);
		
		String[] fornitori = null;
		fornitori = controller.getFornitoriPIvaNomeSocieta().toArray(new String[controller.getFornitoriPIvaNomeSocieta().size()]);
		fornitoreCB = new JComboBox(fornitori);
		fornitoreCB.setFont(new Font("Georgia", Font.PLAIN, 15));
		fornitoreCB.setBounds(118, 43, 210, 29);
		contentPane.add(fornitoreCB);
		
		JLabel dataFornituraLabel = new JLabel("Data Fornitura*: ");
		dataFornituraLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dataFornituraLabel.setForeground(Color.BLACK);
		dataFornituraLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		dataFornituraLabel.setBounds(21, 120, 156, 24);
		contentPane.add(dataFornituraLabel);
		
		dataFornituraTF = new JTextField();
		dataFornituraTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		dataFornituraTF.setBounds(165, 119, 163, 29);
		contentPane.add(dataFornituraTF);
		dataFornituraTF.setColumns(10);
		
		JLabel nomeProdottoLabel = new JLabel("Nome Prodotto*: ");
		nomeProdottoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nomeProdottoLabel.setForeground(Color.BLACK);
		nomeProdottoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		nomeProdottoLabel.setBounds(360, 87, 156, 24);
		contentPane.add(nomeProdottoLabel);
		
		nomeProdottoTF = new JTextField();
		nomeProdottoTF.setBackground(new Color(255, 255, 255));
		nomeProdottoTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		nomeProdottoTF.setColumns(10);
		nomeProdottoTF.setBounds(525, 89, 192, 29);
		contentPane.add(nomeProdottoTF);
		
		JLabel paeseLabel = new JLabel("Paese*: ");
		paeseLabel.setHorizontalAlignment(SwingConstants.LEFT);
		paeseLabel.setForeground(Color.BLACK);
		paeseLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		paeseLabel.setBounds(360, 205, 70, 24);
		contentPane.add(paeseLabel);
		
		JLabel prezzoFornituraLabel = new JLabel("Prezzo Fornitura*:");
		prezzoFornituraLabel.setHorizontalAlignment(SwingConstants.LEFT);
		prezzoFornituraLabel.setForeground(Color.BLACK);
		prezzoFornituraLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		prezzoFornituraLabel.setBounds(20, 85, 167, 24);
		contentPane.add(prezzoFornituraLabel);
		
		prezzoFornituraSpinner = new JSpinner();
		prezzoFornituraSpinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(0.01)));
		prezzoFornituraSpinner.setFont(new Font("Georgia", Font.PLAIN, 16));
		prezzoFornituraSpinner.setBounds(178, 81, 150, 29);
		contentPane.add(prezzoFornituraSpinner);
		
		paeseTF = new JTextField();
		paeseTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		paeseTF.setColumns(10);
		paeseTF.setBackground(Color.WHITE);
		paeseTF.setBounds(452, 203, 265, 29);
		contentPane.add(paeseTF);
		
		JLabel marcaLabel = new JLabel("Marca*:");
		marcaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		marcaLabel.setForeground(Color.BLACK);
		marcaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		marcaLabel.setBounds(360, 166, 70, 24);
		contentPane.add(marcaLabel);
		
		marcaTF = new JTextField();
		marcaTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		marcaTF.setColumns(10);
		marcaTF.setBackground(Color.WHITE);
		marcaTF.setBounds(452, 165, 265, 29);
		contentPane.add(marcaTF);
		
		dataScadenzaLabel = new JLabel("Data Scadenza:");
		dataScadenzaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dataScadenzaLabel.setForeground(Color.BLACK);
		dataScadenzaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		dataScadenzaLabel.setBounds(360, 128, 145, 24);
		contentPane.add(dataScadenzaLabel);
		
		dataScadenzaTF = new JTextField();
		dataScadenzaTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		dataScadenzaTF.setColumns(10);
		dataScadenzaTF.setBounds(525, 127, 192, 29);
		dataScadenzaTF.setEnabled(false);
		contentPane.add(dataScadenzaTF);
		
		JLabel quantitaNegozioLabel = new JLabel("Quantit\u00E0 negozio*:");
		quantitaNegozioLabel.setHorizontalAlignment(SwingConstants.LEFT);
		quantitaNegozioLabel.setForeground(Color.BLACK);
		quantitaNegozioLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		quantitaNegozioLabel.setBounds(360, 240, 167, 24);
		contentPane.add(quantitaNegozioLabel);
		
		quantitaNegozioSpinner = new JSpinner();
		quantitaNegozioSpinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(0.01)));
		quantitaNegozioSpinner.setFont(new Font("Georgia", Font.PLAIN, 16));
		quantitaNegozioSpinner.setBounds(561, 242, 156, 28);
		contentPane.add(quantitaNegozioSpinner);
		
		JLabel prezzoLabel = new JLabel("Prezzo*:");
		prezzoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		prezzoLabel.setForeground(Color.BLACK);
		prezzoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		prezzoLabel.setBounds(360, 316, 70, 24);
		contentPane.add(prezzoLabel);
		
		prezzoSpinner = new JSpinner();
		prezzoSpinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(0.01)));
		prezzoSpinner.setFont(new Font("Georgia", Font.PLAIN, 16));
		prezzoSpinner.setBounds(460, 318, 257, 28);
		contentPane.add(prezzoSpinner);
		
		JLabel quantitaDepositoLabel = new JLabel("Quantit\u00E0 deposito*:");
		quantitaDepositoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		quantitaDepositoLabel.setForeground(Color.BLACK);
		quantitaDepositoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		quantitaDepositoLabel.setBounds(360, 278, 179, 24);
		contentPane.add(quantitaDepositoLabel);
		
		quantitaDepositoSpinner = new JSpinner();
		quantitaDepositoSpinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(0.01)));
		quantitaDepositoSpinner.setFont(new Font("Georgia", Font.PLAIN, 16));
		quantitaDepositoSpinner.setBounds(560, 280, 157, 28);
		contentPane.add(quantitaDepositoSpinner);
		
		JButton annullaButton = new JButton("Annulla");
		annullaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiHomepage(attuale, p);
			}
		});
		annullaButton.setForeground(Color.BLACK);
		annullaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		annullaButton.setContentAreaFilled(false);
		annullaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		annullaButton.setBounds(76, 441, 101, 42);
		contentPane.add(annullaButton);
		
		
		JLabel datiFornituraLabel = new JLabel("DATI FORNITURA");
		datiFornituraLabel.setHorizontalAlignment(SwingConstants.LEFT);
		datiFornituraLabel.setForeground(Color.BLACK);
		datiFornituraLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		datiFornituraLabel.setBounds(68, 10, 167, 24);
		contentPane.add(datiFornituraLabel);
		
		JLabel datiProdottoLabel = new JLabel("DATI PRODOTTO");
		datiProdottoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		datiProdottoLabel.setForeground(Color.BLACK);
		datiProdottoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		datiProdottoLabel.setBounds(424, 10, 167, 24);
		contentPane.add(datiProdottoLabel);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(338, 36, 2, 382);
		contentPane.add(separator);
		
		JLabel notaLabel = new JLabel("NB: i campi contrassegnati con * sono obbligatori");
		notaLabel.setVerticalAlignment(SwingConstants.TOP);
		notaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		notaLabel.setForeground(Color.BLACK);
		notaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 11));
		notaLabel.setBounds(9, 394, 311, 24);
		contentPane.add(notaLabel);
		
		JLabel tipoProdottoLabel = new JLabel("Tipo Prodotto*: ");
		tipoProdottoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		tipoProdottoLabel.setForeground(Color.BLACK);
		tipoProdottoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		tipoProdottoLabel.setBounds(360, 45, 156, 24);
		contentPane.add(tipoProdottoLabel);
		
		jollyLabel2 = new JLabel("");
		jollyLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		jollyLabel2.setForeground(Color.BLACK);
		jollyLabel2.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		jollyLabel2.setBounds(360, 392, 179, 24);
		contentPane.add(jollyLabel2);
		
		jollyTF2 = new JTextField();
		jollyTF2.setVisible(false);
		jollyTF2.setFont(new Font("Georgia", Font.PLAIN, 15));
		jollyTF2.setColumns(10);
		jollyTF2.setBounds(525, 387, 192, 29);
		contentPane.add(jollyTF2);
		
		jollyLabel1 = new JLabel("Data Raccolta*:");
		jollyLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		jollyLabel1.setForeground(Color.BLACK);
		jollyLabel1.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		jollyLabel1.setBounds(360, 351, 179, 24);
		contentPane.add(jollyLabel1);
		
		jollyTF1 = new JTextField();
		jollyTF1.setVisible(true);
		jollyTF1.setFont(new Font("Georgia", Font.PLAIN, 15));
		jollyTF1.setColumns(10);
		jollyTF1.setBackground(Color.WHITE);
		jollyTF1.setBounds(525, 353, 192, 29);
		contentPane.add(jollyTF1);
		
		jollyCB = new JComboBox();
		jollyCB.setBounds(507, 352, 192, 29);
		jollyCB.setFont(new Font("Georgia", Font.PLAIN, 15));
		jollyCB.setVisible(false);
		contentPane.add(jollyCB);
		
		
		tipoProdottoCB = new JComboBox();
		tipoProdottoCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String tipoProdotto = tipoProdottoCB.getSelectedItem().toString();
				if(tipoProdotto.equalsIgnoreCase("frutta") || tipoProdotto.equalsIgnoreCase("verdura")) {
					jollyLabel1.setText("Data Raccolta*:");
					dataScadenzaLabel.setText("Data Scadenza:");
					jollyTF1.setVisible(true);
					jollyCB.setVisible(false);
					jollyTF2.setVisible(false);
					jollyLabel2.setText("");
					dataScadenzaTF.setEnabled(false);
				}else if(tipoProdotto.equalsIgnoreCase("farinaceo")) {
					dataScadenzaLabel.setText("Data Scadenza*:");
					jollyTF1.setVisible(false);
					jollyCB.setVisible(true);
					jollyLabel1.setText("Tipo farinaceo*:");
					jollyTF2.setVisible(false);
					jollyLabel2.setText("");
					dataScadenzaTF.setEnabled(true);
					jollyCB.setModel(new DefaultComboBoxModel<>(TFarinaceo.values()));
				}else if(tipoProdotto.equalsIgnoreCase("latticino")) {
					jollyLabel1.setText("Data mungitura*:");
					jollyLabel2.setText("Data produzione*:");
					dataScadenzaLabel.setText("Data Scadenza*:");
					jollyCB.setVisible(false);
					jollyTF1.setVisible(true);
					jollyTF2.setVisible(true);
					dataScadenzaTF.setEnabled(true);
				}else if(tipoProdotto.equalsIgnoreCase("uova")) {
					dataScadenzaLabel.setText("Data Scadenza*:");
					jollyTF2.setVisible(false);
					jollyLabel2.setText("");
					jollyTF1.setVisible(false);
					jollyLabel1.setText("Tipo allevamento*:");
					jollyCB.setVisible(true);
					dataScadenzaTF.setEnabled(true);
					jollyCB.setModel(new DefaultComboBoxModel<>(TAllevamento.values()));
				}else {
					dataScadenzaLabel.setText("Data Scadenza*:");
					jollyTF2.setVisible(false);
					jollyCB.setVisible(false);
					jollyLabel2.setText("");
					jollyTF1.setVisible(true);
					jollyLabel1.setText("Tipo confezione*:");
					dataScadenzaTF.setEnabled(true);
				}
			}
		});
		tipoProdottoCB.setModel(new DefaultComboBoxModel(new String[] {"Frutta", "Verdura", "Farinaceo", "Latticino", "Uova", "Confezionato"}));
		tipoProdottoCB.setFont(new Font("Georgia", Font.PLAIN, 15));
		tipoProdottoCB.setBounds(525, 43, 192, 29);
		contentPane.add(tipoProdottoCB);
		
		JButton inserisciButton = new JButton("Inserisci");
		inserisciButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.inserisciProdotto(fornitoreCB.getSelectedItem().toString(), (float)prezzoFornituraSpinner.getValue(), dataFornituraTF.getText(),
						tipoProdottoCB.getSelectedItem().toString(), nomeProdottoTF.getText(), dataScadenzaTF.getText(), marcaTF.getText(), paeseTF.getText(),
						(float)quantitaNegozioSpinner.getValue(), (float)quantitaDepositoSpinner.getValue(), (float)prezzoSpinner.getValue(), jollyTF1.getText(), jollyTF2.getText(), jollyCB.getSelectedItem());
			}
		});
		inserisciButton.setForeground(Color.BLACK);
		inserisciButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		inserisciButton.setContentAreaFilled(false);
		inserisciButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		inserisciButton.setBounds(635, 441, 101, 42);
		contentPane.add(inserisciButton);
	}
	
	public void resetForm() {
		tipoProdottoCB.setSelectedIndex(0);
		fornitoreCB.setSelectedIndex(0);
		jollyCB.setVisible(false);
		jollyTF1.setText("");
		jollyTF1.setVisible(true);
		jollyTF2.setText("");
		jollyTF2.setVisible(false);
		jollyLabel1.setText("Data Raccolta*:");
		jollyLabel2.setText("");
		dataScadenzaLabel.setText("Data Scadenza:");
		dataScadenzaTF.setText("");
		dataScadenzaTF.setEnabled(false);
		dataFornituraTF.setText("");
		nomeProdottoTF.setText("");
		marcaTF.setText("");
		paeseTF.setText("");
		prezzoFornituraSpinner.setValue(new Float(0));
		quantitaNegozioSpinner.setValue(new Float(0));
		prezzoSpinner.setValue(new Float(0));
		quantitaDepositoSpinner.setValue(new Float(0));
	}
}
