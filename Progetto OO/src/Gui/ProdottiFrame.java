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
	private JTable ProdottiTab;
	private JLabel NomeLabel;
	private JLabel PaeseDiProvenienzaLabel;
	private JLabel MarcaLabel;
	private JLabel DataScadenzaLabel;
	private JLabel QuantitaNegozioLabel;
	private JLabel PrezzoUnitarioLabel;
	private JLabel QuantitaDepositoLabel;
	private JSpinner spinner;
	private JButton RifornisciButton;
	
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
		
		JButton SalvaButton = new JButton("Salva");
		SalvaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int riga = ProdottiTab.getSelectedRow();
				controller.aggiornaScontoProdotto(ProdottiTab.getValueAt(ProdottiTab.getSelectedRow(), 0).toString(), ProdottiTab.getValueAt(ProdottiTab.getSelectedRow(), 2).toString(), (int)spinner.getValue());
				ProdottiTab.setModel(new DefaultTableModel(
						controller.getProdotti(),
						new String[] {
								"Nome", "PaeseDiProvenienza", "Marca", "DataScadenza", "QuantitaNegozio", "PrezzoUnitario", "ScontoPercentuale", "QuantitaDeposito"
						}
					));
				ProdottiTab.setRowSelectionInterval(riga, riga);
			}
		});
		SalvaButton.setEnabled(false);
		SalvaButton.setForeground(Color.BLACK);
		SalvaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		SalvaButton.setContentAreaFilled(false);
		SalvaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		SalvaButton.setBounds(542, 497, 101, 42);
		contentPane.add(SalvaButton);
		
		RifornisciButton = new JButton("Rifornisci");
		RifornisciButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.vaiRifornimento(ProdottiTab.getValueAt(ProdottiTab.getSelectedRow(), 0).toString(), ProdottiTab.getValueAt(ProdottiTab.getSelectedRow(), 2).toString(), p);
				ProdottiTab.setModel(new DefaultTableModel(
						controller.getProdotti(),
						new String[] {
								"Nome", "PaeseDiProvenienza", "Marca", "DataScadenza", "QuantitaNegozio", "PrezzoUnitario", "ScontoPercentuale", "QuantitaDeposito"
						}
					));
			}
		});
		RifornisciButton.setForeground(Color.BLACK);
		RifornisciButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		RifornisciButton.setEnabled(false);
		RifornisciButton.setContentAreaFilled(false);
		RifornisciButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		RifornisciButton.setBounds(330, 497, 101, 42);
		contentPane.add(RifornisciButton);
		
		ProdottiTab = new JTable();
		ProdottiTab.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				controller.aggiornaLabelsProdotti(ProdottiTab.getValueAt(ProdottiTab.getSelectedRow(), 0).toString(), ProdottiTab.getValueAt(ProdottiTab.getSelectedRow(), 2).toString());
				SalvaButton.setEnabled(true);
				RifornisciButton.setEnabled(true);
			}
		});
		ProdottiTab.setModel(new DefaultTableModel(
			controller.getProdotti(),
			new String[] {
					"Nome", "PaeseDiProvenienza", "Marca", "DataScadenza", "QuantitaNegozio", "PrezzoUnitario", "ScontoPercentuale", "QuantitaDeposito"
			}
		));
		ProdottiTab.setDefaultEditor(Object.class, null);			//permette di non modificare le celle nella tabella
		ProdottiTab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(ProdottiTab);
		
		NomeLabel = new JLabel("Nome:");
		NomeLabel.setBounds(21, 308, 232, 17);
		NomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(NomeLabel);
		
		PaeseDiProvenienzaLabel = new JLabel("Paese Di Provenienza:");
		PaeseDiProvenienzaLabel.setBounds(330, 308, 356, 17);
		PaeseDiProvenienzaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		PaeseDiProvenienzaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(PaeseDiProvenienzaLabel);
		
		MarcaLabel = new JLabel("Marca:");
		MarcaLabel.setBounds(21, 353, 232, 17);
		MarcaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		MarcaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(MarcaLabel);
		
		DataScadenzaLabel = new JLabel("Data Scadenza:");
		DataScadenzaLabel.setBounds(330, 353, 354, 17);
		DataScadenzaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		DataScadenzaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(DataScadenzaLabel);
		
		QuantitaNegozioLabel = new JLabel("Quantit\u00E0 Negozio:");
		QuantitaNegozioLabel.setBounds(21, 398, 232, 17);
		QuantitaNegozioLabel.setHorizontalAlignment(SwingConstants.LEFT);
		QuantitaNegozioLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(QuantitaNegozioLabel);
		
		PrezzoUnitarioLabel = new JLabel("Prezzo Unitario:");
		PrezzoUnitarioLabel.setBounds(330, 398, 354, 17);
		PrezzoUnitarioLabel.setHorizontalAlignment(SwingConstants.LEFT);
		PrezzoUnitarioLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(PrezzoUnitarioLabel);
		
		JLabel ScontoPercentualeLabel = new JLabel("Sconto Percentuale:");
		ScontoPercentualeLabel.setBounds(21, 444, 211, 17);
		ScontoPercentualeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ScontoPercentualeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(ScontoPercentualeLabel);
		
		QuantitaDepositoLabel = new JLabel("Quantit\u00E0 Deposito:");
		QuantitaDepositoLabel.setBounds(330, 444, 354, 17);
		QuantitaDepositoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		QuantitaDepositoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(QuantitaDepositoLabel);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner.setFont(new Font("Georgia", Font.PLAIN, 16));
		spinner.setBounds(202, 444, 51, 26);
		contentPane.add(spinner);
		
		JButton AnnullaButton = new JButton("Annulla");
		AnnullaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiHomepage(attuale, p);
			}
		});
		AnnullaButton.setForeground(Color.BLACK);
		AnnullaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		AnnullaButton.setContentAreaFilled(false);
		AnnullaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		AnnullaButton.setBounds(39, 497, 101, 42);
		contentPane.add(AnnullaButton);
		
	}
	
	public void setData(Object aggiornamento[]) {
		NomeLabel.setText("Nome: " + aggiornamento[0]);
		PaeseDiProvenienzaLabel.setText("Paese Di Provenienza: " + aggiornamento[1]);
		MarcaLabel.setText("Marca: " + aggiornamento[2]);
		if(aggiornamento[3] == null)
			aggiornamento[3] = "non disponibile";
		DataScadenzaLabel.setText("Data Scadenza: " + aggiornamento[3]);
		QuantitaNegozioLabel.setText("Quantità Negozio: " + aggiornamento[4]);
		PrezzoUnitarioLabel.setText("Prezzo Unitario: " + aggiornamento[5]);
		spinner.setValue((int)aggiornamento[6]);
		QuantitaDepositoLabel.setText("Quantità Deposito: " + aggiornamento[7]);
	}
}
