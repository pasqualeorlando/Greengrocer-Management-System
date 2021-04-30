package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class NuovaFornituraFrame extends JFrame {

	private JPanel contentPane;
	private JTextField dataFornituraTF;
	private JTextField nomeProdottoTF;
	private JTextField paeseTF;
	private JTextField marcaTF;
	private JTextField dataScadenzaTF;

	
	public NuovaFornituraFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NuovaFornituraFrame.class.getResource("/immagini/fruits.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fornitoreLabel = new JLabel("Fornitore: ");
		fornitoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
		fornitoreLabel.setForeground(new Color(0, 0, 0));
		fornitoreLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		fornitoreLabel.setBounds(21, 44, 97, 24);
		contentPane.add(fornitoreLabel);
		
		JComboBox fornitoreCB = new JComboBox();
		fornitoreCB.setFont(new Font("Georgia", Font.PLAIN, 15));
		fornitoreCB.setBounds(118, 46, 156, 25);
		contentPane.add(fornitoreCB);
		
		JLabel dataFornituraLabel = new JLabel("Data Fornitura: ");
		dataFornituraLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dataFornituraLabel.setForeground(Color.BLACK);
		dataFornituraLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		dataFornituraLabel.setBounds(320, 44, 138, 24);
		contentPane.add(dataFornituraLabel);
		
		dataFornituraTF = new JTextField();
		dataFornituraTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		dataFornituraTF.setBounds(464, 45, 117, 24);
		contentPane.add(dataFornituraTF);
		dataFornituraTF.setColumns(10);
		
		JLabel nomeProdottoLabel = new JLabel("Nome Prodotto: ");
		nomeProdottoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nomeProdottoLabel.setForeground(Color.BLACK);
		nomeProdottoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		nomeProdottoLabel.setBounds(320, 85, 148, 24);
		contentPane.add(nomeProdottoLabel);
		
		nomeProdottoTF = new JTextField();
		nomeProdottoTF.setBackground(new Color(255, 255, 255));
		nomeProdottoTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		nomeProdottoTF.setColumns(10);
		nomeProdottoTF.setBounds(464, 86, 200, 24);
		contentPane.add(nomeProdottoTF);
		
		JLabel paeseLabel = new JLabel("Paese: ");
		paeseLabel.setHorizontalAlignment(SwingConstants.LEFT);
		paeseLabel.setForeground(Color.BLACK);
		paeseLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		paeseLabel.setBounds(21, 120, 58, 24);
		contentPane.add(paeseLabel);
		
		JLabel prezzoFornituraLabel = new JLabel("Prezzo Fornitura:");
		prezzoFornituraLabel.setHorizontalAlignment(SwingConstants.LEFT);
		prezzoFornituraLabel.setForeground(Color.BLACK);
		prezzoFornituraLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		prezzoFornituraLabel.setBounds(21, 85, 156, 24);
		contentPane.add(prezzoFornituraLabel);
		
		JSpinner prezzoFornituraSpinner = new JSpinner();
		prezzoFornituraSpinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(0.01)));
		prezzoFornituraSpinner.setFont(new Font("Georgia", Font.PLAIN, 16));
		prezzoFornituraSpinner.setBounds(176, 82, 64, 28);
		contentPane.add(prezzoFornituraSpinner);
		
		paeseTF = new JTextField();
		paeseTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		paeseTF.setColumns(10);
		paeseTF.setBackground(Color.WHITE);
		paeseTF.setBounds(89, 120, 151, 24);
		contentPane.add(paeseTF);
		
		JLabel marcaLabel = new JLabel("Marca:");
		marcaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		marcaLabel.setForeground(Color.BLACK);
		marcaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		marcaLabel.setBounds(320, 120, 70, 24);
		contentPane.add(marcaLabel);
		
		marcaTF = new JTextField();
		marcaTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		marcaTF.setColumns(10);
		marcaTF.setBackground(Color.WHITE);
		marcaTF.setBounds(390, 120, 151, 24);
		contentPane.add(marcaTF);
		
		JLabel dataScadenzaLabel = new JLabel("Data Scadenza: ");
		dataScadenzaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dataScadenzaLabel.setForeground(Color.BLACK);
		dataScadenzaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		dataScadenzaLabel.setBounds(21, 161, 138, 24);
		contentPane.add(dataScadenzaLabel);
		
		dataScadenzaTF = new JTextField();
		dataScadenzaTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		dataScadenzaTF.setColumns(10);
		dataScadenzaTF.setBounds(158, 161, 117, 24);
		contentPane.add(dataScadenzaTF);
		
		JLabel quantitaNegozioLabel = new JLabel("Quantit\u00E0 negozio:");
		quantitaNegozioLabel.setHorizontalAlignment(SwingConstants.LEFT);
		quantitaNegozioLabel.setForeground(Color.BLACK);
		quantitaNegozioLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		quantitaNegozioLabel.setBounds(320, 161, 156, 24);
		contentPane.add(quantitaNegozioLabel);
		
		JSpinner quantitaNegozioSpinner = new JSpinner();
		quantitaNegozioSpinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(0.01)));
		quantitaNegozioSpinner.setFont(new Font("Georgia", Font.PLAIN, 16));
		quantitaNegozioSpinner.setBounds(477, 155, 64, 28);
		contentPane.add(quantitaNegozioSpinner);
		
		JLabel prezzoLabel = new JLabel("Prezzo:");
		prezzoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		prezzoLabel.setForeground(Color.BLACK);
		prezzoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		prezzoLabel.setBounds(21, 196, 70, 24);
		contentPane.add(prezzoLabel);
		
		JSpinner prezzoSpinner = new JSpinner();
		prezzoSpinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(0.01)));
		prezzoSpinner.setFont(new Font("Georgia", Font.PLAIN, 16));
		prezzoSpinner.setBounds(89, 195, 64, 28);
		contentPane.add(prezzoSpinner);
		
		JLabel scontoLabel = new JLabel("Sconto:");
		scontoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		scontoLabel.setForeground(Color.BLACK);
		scontoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		scontoLabel.setBounds(320, 196, 70, 24);
		contentPane.add(scontoLabel);
		
		JSpinner scontoSpinner = new JSpinner();
		scontoSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		scontoSpinner.setFont(new Font("Georgia", Font.PLAIN, 16));
		scontoSpinner.setBounds(394, 196, 64, 28);
		contentPane.add(scontoSpinner);
		
		JLabel quantitaDepositoLabel = new JLabel("Quantit\u00E0 deposito:");
		quantitaDepositoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		quantitaDepositoLabel.setForeground(Color.BLACK);
		quantitaDepositoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		quantitaDepositoLabel.setBounds(21, 236, 167, 24);
		contentPane.add(quantitaDepositoLabel);
		
		JSpinner quantitaDepositoSpinner = new JSpinner();
		quantitaDepositoSpinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(0.01)));
		quantitaDepositoSpinner.setFont(new Font("Georgia", Font.PLAIN, 16));
		quantitaDepositoSpinner.setBounds(190, 235, 64, 28);
		contentPane.add(quantitaDepositoSpinner);
		
		JButton annullaButton = new JButton("Annulla");
		annullaButton.setForeground(Color.BLACK);
		annullaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		annullaButton.setContentAreaFilled(false);
		annullaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		annullaButton.setBounds(52, 366, 101, 42);
		contentPane.add(annullaButton);
		
		JButton inserisciButton = new JButton("Inserisci");
		inserisciButton.setForeground(Color.BLACK);
		inserisciButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		inserisciButton.setContentAreaFilled(false);
		inserisciButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		inserisciButton.setBounds(464, 366, 101, 42);
		contentPane.add(inserisciButton);
	}

}
