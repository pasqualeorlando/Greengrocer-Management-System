package Gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Persona;
import Controller.Controller;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProdottiFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable prodottiTab;
	private JLabel nomeLabel;
	private JLabel paeseDiProvenienzaLabel;
	private JLabel marcaLabel;
	private JLabel dataScadenzaLabel;
	private JLabel quantitaNegozioLabel;
	private JLabel prezzoUnitarioLabel;
	private JLabel quantitaDepositoLabel;
	private JSpinner scontoSpinner;
	private JButton rifornisciButton;
	
	public ProdottiFrame(Controller c, Persona p) {
		controller = c;
		JFrame attuale = this;
		
		setTitle("OrtofruttaPerTutti - Prodotti");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProdottiFrame.class.getResource("/immagini/fruits.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 674, 266);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		JButton salvaButton = new JButton("Salva");
		salvaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int riga = prodottiTab.getSelectedRow();
				controller.aggiornaScontoProdotto(prodottiTab.getValueAt(prodottiTab.getSelectedRow(), 0).toString(), prodottiTab.getValueAt(prodottiTab.getSelectedRow(), 2).toString(), (int)scontoSpinner.getValue());
				prodottiTab.setModel(new DefaultTableModel(
						controller.getProdotti(),
						new String[] {
								"Nome", "PaeseDiProvenienza", "Marca", "DataScadenza", "QuantitaNegozio", "PrezzoUnitario", "ScontoPercentuale", "QuantitaDeposito"
						}
					));
				prodottiTab.setRowSelectionInterval(riga, riga);
			}
		});
		salvaButton.setEnabled(false);
		salvaButton.setForeground(Color.BLACK);
		salvaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		salvaButton.setContentAreaFilled(false);
		salvaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		salvaButton.setBounds(542, 497, 101, 42);
		contentPane.add(salvaButton);
		
		rifornisciButton = new JButton("Rifornisci");
		rifornisciButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.vaiRifornimento(prodottiTab.getValueAt(prodottiTab.getSelectedRow(), 0).toString(), prodottiTab.getValueAt(prodottiTab.getSelectedRow(), 2).toString(), p);
				prodottiTab.setModel(new DefaultTableModel(
						controller.getProdotti(),
						new String[] {
								"Nome", "PaeseDiProvenienza", "Marca", "DataScadenza", "QuantitaNegozio", "PrezzoUnitario", "ScontoPercentuale", "QuantitaDeposito"
						}
					));
			}
		});
		rifornisciButton.setForeground(Color.BLACK);
		rifornisciButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		rifornisciButton.setEnabled(false);
		rifornisciButton.setContentAreaFilled(false);
		rifornisciButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		rifornisciButton.setBounds(330, 497, 101, 42);
		contentPane.add(rifornisciButton);
		
		prodottiTab = new JTable();
		prodottiTab.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				controller.aggiornaLabelsProdotti(prodottiTab.getValueAt(prodottiTab.getSelectedRow(), 0).toString(), prodottiTab.getValueAt(prodottiTab.getSelectedRow(), 2).toString());
				salvaButton.setEnabled(true);
				rifornisciButton.setEnabled(true);
			}
		});
		prodottiTab.setModel(new DefaultTableModel(
			controller.getProdotti(),
			new String[] {
					"Nome", "PaeseDiProvenienza", "Marca", "DataScadenza", "QuantitaNegozio", "PrezzoUnitario", "ScontoPercentuale", "QuantitaDeposito"
			}
		));
		prodottiTab.setDefaultEditor(Object.class, null);			//permette di non modificare le celle nella tabella
		prodottiTab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(prodottiTab);
		
		nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(21, 308, 232, 17);
		nomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(nomeLabel);
		
		paeseDiProvenienzaLabel = new JLabel("Paese Di Provenienza:");
		paeseDiProvenienzaLabel.setBounds(330, 308, 356, 17);
		paeseDiProvenienzaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		paeseDiProvenienzaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(paeseDiProvenienzaLabel);
		
		marcaLabel = new JLabel("Marca:");
		marcaLabel.setBounds(21, 353, 232, 17);
		marcaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		marcaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(marcaLabel);
		
		dataScadenzaLabel = new JLabel("Data Scadenza:");
		dataScadenzaLabel.setBounds(330, 353, 354, 17);
		dataScadenzaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dataScadenzaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(dataScadenzaLabel);
		
		quantitaNegozioLabel = new JLabel("Quantit\u00E0 Negozio:");
		quantitaNegozioLabel.setBounds(21, 398, 232, 17);
		quantitaNegozioLabel.setHorizontalAlignment(SwingConstants.LEFT);
		quantitaNegozioLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(quantitaNegozioLabel);
		
		prezzoUnitarioLabel = new JLabel("Prezzo Unitario:");
		prezzoUnitarioLabel.setBounds(330, 398, 354, 17);
		prezzoUnitarioLabel.setHorizontalAlignment(SwingConstants.LEFT);
		prezzoUnitarioLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(prezzoUnitarioLabel);
		
		JLabel scontoPercentualeLabel = new JLabel("Sconto Percentuale:");
		scontoPercentualeLabel.setBounds(21, 444, 211, 17);
		scontoPercentualeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		scontoPercentualeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(scontoPercentualeLabel);
		
		quantitaDepositoLabel = new JLabel("Quantit\u00E0 Deposito:");
		quantitaDepositoLabel.setBounds(330, 444, 354, 17);
		quantitaDepositoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		quantitaDepositoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(quantitaDepositoLabel);
		
		scontoSpinner = new JSpinner();
		scontoSpinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		scontoSpinner.setFont(new Font("Georgia", Font.PLAIN, 16));
		scontoSpinner.setBounds(202, 444, 51, 26);
		contentPane.add(scontoSpinner);
		
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
		annullaButton.setBounds(39, 497, 101, 42);
		contentPane.add(annullaButton);
		
	}
	
	public void setData(Object aggiornamento[]) {
		nomeLabel.setText("Nome: " + aggiornamento[0]);
		paeseDiProvenienzaLabel.setText("Paese Di Provenienza: " + aggiornamento[1]);
		marcaLabel.setText("Marca: " + aggiornamento[2]);
		if(aggiornamento[3] == null)
			aggiornamento[3] = "non disponibile";
		dataScadenzaLabel.setText("Data Scadenza: " + aggiornamento[3]);
		quantitaNegozioLabel.setText("Quantità Negozio: " + aggiornamento[4]);
		prezzoUnitarioLabel.setText("Prezzo Unitario: " + aggiornamento[5]);
		scontoSpinner.setValue((int)aggiornamento[6]);
		quantitaDepositoLabel.setText("Quantità Deposito: " + aggiornamento[7]);
	}
}
