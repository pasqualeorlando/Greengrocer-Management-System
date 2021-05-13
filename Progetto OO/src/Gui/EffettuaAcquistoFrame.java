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
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Persona;
import Classi.Prodotto;
import Controller.Controller;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class EffettuaAcquistoFrame extends JFrame {

	private int codAcquistoAttuale;
	private JPanel contentPane;
	private JTextField cassaTF;
	private JTextField totaleDaPagareTF;
	private JTextField restoDovutoTF;
	private JTable prodottiAcquistatiTab;
	private JComboBox clientiCB;
	private JSpinner quantitaSpinner;
	private JSpinner scontoSpinner;
	private JButton rimuoviButton;
	private JSpinner totalePagatoSpinner;
	private JButton completaButton;
	private Controller controller;
	
	public EffettuaAcquistoFrame(Controller c, Persona p) {
		controller = c;
		codAcquistoAttuale = -1;
		JFrame attuale = this;
		
		setTitle("OrtofruttaPerTutti - Effettua acquisto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EffettuaAcquistoFrame.class.getResource("/immagini/fruits.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 562);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 52, 353, 402);
		contentPane.add(scrollPane);
		
		prodottiAcquistatiTab = new JTable();
		prodottiAcquistatiTab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rimuoviButton.setEnabled(true);
			}
		});
		prodottiAcquistatiTab.setModel(new DefaultTableModel(
			null,
			new String[] {
					"Nome prodotto", "Marca", "Quantità"
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
		prodottoLabel.setBounds(385, 226, 80, 18);
		contentPane.add(prodottoLabel);
		
		JComboBox prodottoCB = new JComboBox(controller.getProdottiAcquistabili().toArray());
		prodottoCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String prodottoMarca = prodottoCB.getSelectedItem().toString();
				int posTrattino = prodottoMarca.indexOf("-");
				Prodotto p = controller.getProdottoDaNomeMarca(prodottoMarca.substring(0, posTrattino-1), prodottoMarca.substring(posTrattino+2, prodottoMarca.length()));
				quantitaSpinner.setModel(new SpinnerNumberModel(0.0f, 0.0f, p.getQuantitaNegozio(), 0.01f));
			}
		});
		prodottoCB.setFont(new Font("Georgia", Font.PLAIN, 12));
		prodottoCB.setEnabled(false);
		prodottoCB.setBounds(464, 224, 258, 21);
		contentPane.add(prodottoCB);
		
		JLabel quantitaLabel = new JLabel("Quantit\u00E0:");
		quantitaLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		quantitaLabel.setBounds(385, 254, 80, 18);
		contentPane.add(quantitaLabel);
		
		JSeparator separatorOrizzontale = new JSeparator();
		separatorOrizzontale.setBounds(373, 322, 425, 2);
		contentPane.add(separatorOrizzontale);
		
		JButton aggiungiProdottoButton = new JButton("Aggiungi prodotto");
		aggiungiProdottoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String prodottoMarca = prodottoCB.getSelectedItem().toString();
				int posTrattino = prodottoMarca.indexOf("-");
				controller.inserisciSpecificaAcquisto(codAcquistoAttuale, prodottoMarca.substring(0, posTrattino-1), prodottoMarca.substring(posTrattino+2, prodottoMarca.length()), Float.parseFloat(quantitaSpinner.getValue().toString()));
				
				prodottiAcquistatiTab.setModel(new DefaultTableModel(
						controller.getProdottiAcquistoDaCod(codAcquistoAttuale).toArray(new Object[controller.getProdottiAcquistoDaCod(codAcquistoAttuale).size()][]),
						new String[] {
								"Nome prodotto", "Marca", "Quantità"
						}
				));
				
				totaleDaPagareTF.setText(String.format("%.2f", controller.ricalcolaTotaleAcquisto(codAcquistoAttuale, Integer.parseInt(scontoSpinner.getValue().toString()))).replaceAll(",", "."));
				totalePagatoSpinner.setEnabled(true);
				scontoSpinner.setEnabled(true);
				completaButton.setEnabled(true);
				float resto = Float.parseFloat(totalePagatoSpinner.getValue().toString()) - Float.parseFloat(totaleDaPagareTF.getText());
				if(resto<0)
					resto = 0.0f;
				System.out.println(resto);
				restoDovutoTF.setText(String.format("%.2f", resto).replaceAll(",", "."));
			}
		});
		aggiungiProdottoButton.setEnabled(false);
		aggiungiProdottoButton.setForeground(Color.BLACK);
		aggiungiProdottoButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		aggiungiProdottoButton.setContentAreaFilled(false);
		aggiungiProdottoButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		aggiungiProdottoButton.setBounds(639, 280, 147, 32);
		contentPane.add(aggiungiProdottoButton);
		
		quantitaSpinner = new JSpinner();
		quantitaSpinner.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(0.01)));
		quantitaSpinner.setEnabled(false);
		quantitaSpinner.setFont(new Font("Georgia", Font.PLAIN, 15));
		quantitaSpinner.setBounds(464, 253, 80, 21);
		contentPane.add(quantitaSpinner);
		
		JSeparator separatorVerticale = new JSeparator();
		separatorVerticale.setOrientation(SwingConstants.VERTICAL);
		separatorVerticale.setBounds(373, 0, 2, 533);
		contentPane.add(separatorVerticale);
		
		JLabel aggiuntaProdottiLabel = new JLabel("Sezione aggiunta prodotti");
		aggiuntaProdottiLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		aggiuntaProdottiLabel.setBounds(489, 193, 202, 21);
		contentPane.add(aggiuntaProdottiLabel);
		
		JLabel selezioneClienteLabel = new JLabel("*Selezione cliente:");
		selezioneClienteLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		selezioneClienteLabel.setBounds(383, 74, 141, 18);
		contentPane.add(selezioneClienteLabel);
		
		ArrayList<String> clienti = controller.getClientiPerComboBox();
		clienti.add(0, "");
		clientiCB = new JComboBox(clienti.toArray(new Object[controller.getClientiPerComboBox().size()]));
		clientiCB.setFont(new Font("Georgia", Font.PLAIN, 12));
		clientiCB.setBounds(526, 72, 258, 21);
		contentPane.add(clientiCB);
		
		JLabel totaleDaPagareLabel = new JLabel("Totale da pagare:");
		totaleDaPagareLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		totaleDaPagareLabel.setBounds(387, 396, 137, 21);
		contentPane.add(totaleDaPagareLabel);
		
		totaleDaPagareTF = new JTextField("0.00");
		totaleDaPagareTF.setEditable(false);
		totaleDaPagareTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		totaleDaPagareTF.setColumns(10);
		totaleDaPagareTF.setBounds(544, 398, 161, 21);
		contentPane.add(totaleDaPagareTF);
		
		JLabel totalePagatoLabel = new JLabel("Totale pagato:");
		totalePagatoLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		totalePagatoLabel.setBounds(387, 427, 137, 21);
		contentPane.add(totalePagatoLabel);
		
		JLabel restoDovutoLabel = new JLabel("Resto dovuto:");
		restoDovutoLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		restoDovutoLabel.setBounds(387, 458, 137, 21);
		contentPane.add(restoDovutoLabel);
		
		restoDovutoTF = new JTextField();
		restoDovutoTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		restoDovutoTF.setEditable(false);
		restoDovutoTF.setColumns(10);
		restoDovutoTF.setBounds(544, 459, 161, 21);
		contentPane.add(restoDovutoTF);
		
		completaButton = new JButton("Completa");
		completaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.impostaAcquistoCompletato(codAcquistoAttuale);
			}
		});
		completaButton.setEnabled(false);
		completaButton.setForeground(Color.BLACK);
		completaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		completaButton.setContentAreaFilled(false);
		completaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		completaButton.setBounds(674, 490, 110, 32);
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
		annullaButton.setBounds(383, 490, 110, 32);
		contentPane.add(annullaButton);
		
		JLabel generalitaAcquistoLabel = new JLabel("Sezione generalit\u00E0 acquisto");
		generalitaAcquistoLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		generalitaAcquistoLabel.setBounds(489, 335, 212, 21);
		contentPane.add(generalitaAcquistoLabel);
		
		JLabel infoLabel = new JLabel("* selezionare solo se il cliente possiede la tessera punti");
		infoLabel.setFont(new Font("Georgia", Font.PLAIN, 13));
		infoLabel.setBounds(385, 101, 337, 21);
		contentPane.add(infoLabel);
		
		JLabel riepilogoAcquistoLabel = new JLabel("Riepilogo prodotti acquistati");
		riepilogoAcquistoLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		riepilogoAcquistoLabel.setBounds(76, 10, 231, 21);
		contentPane.add(riepilogoAcquistoLabel);
		
		rimuoviButton = new JButton("Rimuovi");
		rimuoviButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeProdotto = prodottiAcquistatiTab.getValueAt(prodottiAcquistatiTab.getSelectedRow(), 0).toString();
				String marcaProdotto = prodottiAcquistatiTab.getValueAt(prodottiAcquistatiTab.getSelectedRow(), 1).toString();
				controller.rimuoviProdottoDaAcquisto(codAcquistoAttuale, nomeProdotto, marcaProdotto);
				rimuoviButton.setEnabled(false);
				
				prodottiAcquistatiTab.setModel(new DefaultTableModel(
						controller.getProdottiAcquistoDaCod(codAcquistoAttuale).toArray(new Object[controller.getProdottiAcquistoDaCod(codAcquistoAttuale).size()][]),
						new String[] {
								"Nome prodotto", "Marca", "Quantità"
						}
				));
				
				totaleDaPagareTF.setText(String.format("%.2f", controller.ricalcolaTotaleAcquisto(codAcquistoAttuale, Integer.parseInt(scontoSpinner.getValue().toString()))).replaceAll(",", "."));
				float resto = Float.parseFloat(totalePagatoSpinner.getValue().toString())  - Float.parseFloat(totaleDaPagareTF.getText());
				if(resto<0)
					resto = 0;
				restoDovutoTF.setText(String.format("%.2f", resto).replaceAll(",", "."));
				if(prodottiAcquistatiTab.getRowCount() == 0) {
					completaButton.setEnabled(false);
					totalePagatoSpinner.setEnabled(false);
					totalePagatoSpinner.setValue(Float.parseFloat("0.00"));
					restoDovutoTF.setText("");
					scontoSpinner.setEnabled(false);
					scontoSpinner.setValue(Integer.parseInt("0"));
				}
					
			}
		});
		rimuoviButton.setEnabled(false);
		rimuoviButton.setForeground(Color.BLACK);
		rimuoviButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		rimuoviButton.setContentAreaFilled(false);
		rimuoviButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		rimuoviButton.setBounds(10, 490, 110, 32);
		contentPane.add(rimuoviButton);
		
		JLabel creazioneAcquistoLabel = new JLabel("Sezione creazione acquisto");
		creazioneAcquistoLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		creazioneAcquistoLabel.setBounds(487, 10, 202, 21);
		contentPane.add(creazioneAcquistoLabel);
		
		JSeparator separatorOrizzontale2 = new JSeparator();
		separatorOrizzontale2.setBounds(373, 180, 425, 2);
		contentPane.add(separatorOrizzontale2);
		
		JButton creaAcquistoButton = new JButton("Crea acquisto");
		creaAcquistoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cassa = cassaTF.getText();
				String cf = clientiCB.getSelectedItem().toString();

				if(cassa.isBlank())
					codAcquistoAttuale = controller.creaAcquisto('\0', cf);
				else
					codAcquistoAttuale = controller.creaAcquisto(cassa.charAt(0), cf);
				
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
		creaAcquistoButton.setBounds(676, 137, 110, 32);
		contentPane.add(creaAcquistoButton);
		
		totalePagatoSpinner = new JSpinner();
		totalePagatoSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				float resto = Float.parseFloat(totalePagatoSpinner.getValue().toString()) - Float.parseFloat(totaleDaPagareTF.getText());
				if(resto < 0)
					restoDovutoTF.setText("0.00");
				else
					restoDovutoTF.setText(String.format("%.2f", resto).replaceAll(",", "."));
			}
		});
		totalePagatoSpinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(0.01)));
		totalePagatoSpinner.setFont(new Font("Georgia", Font.PLAIN, 15));
		totalePagatoSpinner.setEnabled(false);
		totalePagatoSpinner.setBounds(544, 428, 161, 23);
		contentPane.add(totalePagatoSpinner);
		
		JLabel scontoPercentualeLabel = new JLabel("Sconto sul totale(%):");
		scontoPercentualeLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		scontoPercentualeLabel.setBounds(387, 367, 157, 21);
		contentPane.add(scontoPercentualeLabel);
		
		scontoSpinner = new JSpinner();
		scontoSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				totaleDaPagareTF.setText(String.format("%.2f", controller.ricalcolaTotaleAcquisto(codAcquistoAttuale, Integer.parseInt(scontoSpinner.getValue().toString()))).replaceAll(",", "."));
			
				float resto = Float.parseFloat(totalePagatoSpinner.getValue().toString()) - Float.parseFloat(totaleDaPagareTF.getText());
				if(resto < 0)
					restoDovutoTF.setText("0.00");
				else
					restoDovutoTF.setText(String.format("%.2f", resto).replaceAll(",", "."));
			
			}
		});
		scontoSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		scontoSpinner.setFont(new Font("Georgia", Font.PLAIN, 15));
		scontoSpinner.setEnabled(false);
		scontoSpinner.setBounds(544, 367, 161, 23);
		contentPane.add(scontoSpinner);
	}
}

