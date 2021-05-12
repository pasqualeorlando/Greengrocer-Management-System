package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Persona;
import Controller.Controller;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EffettuaAcquistoFrame extends JFrame {

	private int codAcquistoAttuale;
	private JPanel contentPane;
	private JTextField cassaTF;
	private JTextField totaleDaPagareTF;
	private JTextField totalePagatoTF;
	private JTextField restoDovutoTF;
	private JTable prodottiAcquistatiTab;
	private JComboBox clientiCB;
	private Controller controller;
	
	public EffettuaAcquistoFrame(Controller c, Persona p) {
		controller = c;
		codAcquistoAttuale = -1;
		JFrame attuale = this;
		
		setTitle("OrtofruttaPerTutti - Effettua acquisto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EffettuaAcquistoFrame.class.getResource("/immagini/fruits.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 52, 353, 378);
		contentPane.add(scrollPane);
		
		prodottiAcquistatiTab = new JTable();
		prodottiAcquistatiTab.setModel(new DefaultTableModel(
			//controller.getClientiPerTipologiaProdotto().toArray(new Object[controller.getClientiPerTipologiaProdotto().size()][]),
			null,
			new String[] {
					"Prodotto", "Quantità"
			}
		));
		prodottiAcquistatiTab.setDefaultEditor(Object.class, null);			//permette di non modificare le celle nella tabella
		prodottiAcquistatiTab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(prodottiAcquistatiTab);
		
		JLabel cassaLabel = new JLabel("Cassa*:");
		cassaLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		cassaLabel.setBounds(383, 42, 58, 18);
		contentPane.add(cassaLabel);
		
		cassaTF = new JTextField();
		cassaTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		cassaTF.setColumns(10);
		cassaTF.setBounds(440, 41, 80, 21);
		contentPane.add(cassaTF);
		
		JLabel prodottoLabel = new JLabel("Prodotto:");
		prodottoLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		prodottoLabel.setBounds(385, 183, 80, 18);
		contentPane.add(prodottoLabel);
		
		JComboBox prodottoCB = new JComboBox(controller.getProdottiAcquistabili().toArray());
		prodottoCB.setFont(new Font("Georgia", Font.PLAIN, 12));
		prodottoCB.setEnabled(false);
		prodottoCB.setBounds(464, 181, 258, 21);
		contentPane.add(prodottoCB);
		
		JLabel quantitaLabel = new JLabel("Quantit\u00E0:");
		quantitaLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		quantitaLabel.setBounds(385, 211, 80, 18);
		contentPane.add(quantitaLabel);
		
		JSeparator separatorOrizzontale = new JSeparator();
		separatorOrizzontale.setBounds(373, 279, 425, 2);
		contentPane.add(separatorOrizzontale);
		
		JButton aggiungiProdottoButton = new JButton("Aggiungi prodotto");
		aggiungiProdottoButton.setEnabled(false);
		aggiungiProdottoButton.setForeground(Color.BLACK);
		aggiungiProdottoButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		aggiungiProdottoButton.setContentAreaFilled(false);
		aggiungiProdottoButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		aggiungiProdottoButton.setBounds(639, 237, 147, 32);
		contentPane.add(aggiungiProdottoButton);
		
		JSpinner quantitaSpinner = new JSpinner();
		quantitaSpinner.setEnabled(false);
		quantitaSpinner.setFont(new Font("Georgia", Font.PLAIN, 15));
		//quantitaSpinner.setModel(new SpinnerNumberModel(0.0, 0.0, p.getQuantitaDeposito(), 0.01));
		quantitaSpinner.setBounds(463, 213, 80, 21);
		contentPane.add(quantitaSpinner);
		
		JSeparator separatorVerticale = new JSeparator();
		separatorVerticale.setOrientation(SwingConstants.VERTICAL);
		separatorVerticale.setBounds(373, 0, 2, 482);
		contentPane.add(separatorVerticale);
		
		JLabel aggiuntaProdottiLabel = new JLabel("Sezione aggiunta prodotti");
		aggiuntaProdottiLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		aggiuntaProdottiLabel.setBounds(489, 150, 202, 21);
		contentPane.add(aggiuntaProdottiLabel);
		
		JLabel selezioneClienteLabel = new JLabel("*Selezione cliente:");
		selezioneClienteLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		selezioneClienteLabel.setBounds(383, 74, 137, 18);
		contentPane.add(selezioneClienteLabel);
		
		clientiCB = new JComboBox(controller.getClientiPerComboBox().toArray(new Object[controller.getClientiPerComboBox().size()]));
		clientiCB.setFont(new Font("Georgia", Font.PLAIN, 12));
		clientiCB.setBounds(526, 72, 258, 21);
		contentPane.add(clientiCB);
		
		JLabel totaleDaPagareLabel = new JLabel("Totale da pagare:");
		totaleDaPagareLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		totaleDaPagareLabel.setBounds(387, 321, 137, 21);
		contentPane.add(totaleDaPagareLabel);
		
		totaleDaPagareTF = new JTextField();
		totaleDaPagareTF.setEnabled(false);
		totaleDaPagareTF.setEditable(false);
		totaleDaPagareTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		totaleDaPagareTF.setColumns(10);
		totaleDaPagareTF.setBounds(530, 322, 161, 21);
		contentPane.add(totaleDaPagareTF);
		
		JLabel totalePagatoLabel = new JLabel("Totale pagato:");
		totalePagatoLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		totalePagatoLabel.setBounds(387, 352, 137, 21);
		contentPane.add(totalePagatoLabel);
		
		totalePagatoTF = new JTextField();
		totalePagatoTF.setEnabled(false);
		totalePagatoTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		totalePagatoTF.setColumns(10);
		totalePagatoTF.setBounds(530, 352, 161, 21);
		contentPane.add(totalePagatoTF);
		
		JLabel restoDovutoLabel = new JLabel("Resto dovuto:");
		restoDovutoLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		restoDovutoLabel.setBounds(387, 383, 137, 21);
		contentPane.add(restoDovutoLabel);
		
		restoDovutoTF = new JTextField();
		restoDovutoTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		restoDovutoTF.setEnabled(false);
		restoDovutoTF.setEditable(false);
		restoDovutoTF.setColumns(10);
		restoDovutoTF.setBounds(530, 383, 161, 21);
		contentPane.add(restoDovutoTF);
		
		JButton completaButton = new JButton("Completa");
		completaButton.setEnabled(false);
		completaButton.setForeground(Color.BLACK);
		completaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		completaButton.setContentAreaFilled(false);
		completaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		completaButton.setBounds(678, 440, 110, 32);
		contentPane.add(completaButton);
		
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
		annullaButton.setBounds(387, 440, 110, 32);
		contentPane.add(annullaButton);
		
		JLabel generalitaAcquistoLabel = new JLabel("Sezione generalit\u00E0 acquisto");
		generalitaAcquistoLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		generalitaAcquistoLabel.setBounds(489, 291, 212, 21);
		contentPane.add(generalitaAcquistoLabel);
		
		JLabel infoLabel = new JLabel("* selezionare solo se il cliente possiede la tessera punti");
		infoLabel.setFont(new Font("Georgia", Font.PLAIN, 13));
		infoLabel.setBounds(387, 409, 337, 21);
		contentPane.add(infoLabel);
		
		JLabel riepilogoAcquistoLabel = new JLabel("Riepilogo prodotti acquistati");
		riepilogoAcquistoLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		riepilogoAcquistoLabel.setBounds(76, 10, 231, 21);
		contentPane.add(riepilogoAcquistoLabel);
		
		JButton rimuoviButton = new JButton("Rimuovi");
		rimuoviButton.setEnabled(false);
		rimuoviButton.setForeground(Color.BLACK);
		rimuoviButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		rimuoviButton.setContentAreaFilled(false);
		rimuoviButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		rimuoviButton.setBounds(10, 440, 110, 32);
		contentPane.add(rimuoviButton);
		
		JLabel creazioneAcquistoLabel = new JLabel("Sezione creazione acquisto");
		creazioneAcquistoLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		creazioneAcquistoLabel.setBounds(487, 10, 202, 21);
		contentPane.add(creazioneAcquistoLabel);
		
		JSeparator separatorOrizzontale2 = new JSeparator();
		separatorOrizzontale2.setBounds(373, 138, 425, 2);
		contentPane.add(separatorOrizzontale2);
		
		JButton creaAcquistoButton = new JButton("Crea acquisto");
		creaAcquistoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cassa = cassaTF.getText();
				if(cassa.isBlank())
					codAcquistoAttuale = controller.creaAcquisto('\0', clientiCB.getSelectedItem().toString().substring(0, 16));
				else
					codAcquistoAttuale = controller.creaAcquisto(cassa.charAt(0), clientiCB.getSelectedItem().toString().substring(0, 16));
				if(codAcquistoAttuale != -1) {
					cassaTF.setEnabled(false);
					clientiCB.setEnabled(false);
					creaAcquistoButton.setEnabled(false);
					prodottoCB.setEnabled(true);
					quantitaSpinner.setEnabled(true);
					aggiungiProdottoButton.setEnabled(true);
				}
				else {
					cassaTF.setEnabled(true);
					clientiCB.setEnabled(true);
					creaAcquistoButton.setEnabled(true);
					prodottoCB.setEnabled(false);
					quantitaSpinner.setEnabled(false);
					aggiungiProdottoButton.setEnabled(false);
				}
			}
		});
		creaAcquistoButton.setForeground(Color.BLACK);
		creaAcquistoButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		creaAcquistoButton.setContentAreaFilled(false);
		creaAcquistoButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		creaAcquistoButton.setBounds(676, 103, 110, 32);
		contentPane.add(creaAcquistoButton);
	}
}
