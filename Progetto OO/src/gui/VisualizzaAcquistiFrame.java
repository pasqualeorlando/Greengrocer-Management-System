package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import classi.Acquisto;
import classi.Persona;
import controller.Controller;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class VisualizzaAcquistiFrame extends JFrame {

	private Controller controller;
	private JPanel contentPane;
	private JTextField dataInizioTF;
	private JTextField dataFineTF;
	private JTable acquistiTab;
	private JTable prodottiTab;
	

	
	public VisualizzaAcquistiFrame(Controller c, Persona p) {
		controller = c;
		JFrame attuale = this;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzaAcquistiFrame.class.getResource("/immagini/fruits.png")));
		setTitle("OrtofruttaPerTutti - Acquisti ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel visualizzaAcquistiLabel = new JLabel("Visualizza acquisti dal:");
		visualizzaAcquistiLabel.setBounds(40, 36, 190, 18);
		visualizzaAcquistiLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		contentPane.add(visualizzaAcquistiLabel);
		
		dataInizioTF = new JTextField();
		dataInizioTF.setBounds(228, 37, 96, 18);
		dataInizioTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		dataInizioTF.setColumns(10);
		contentPane.add(dataInizioTF);
		
		JLabel alLabel = new JLabel("al:");
		alLabel.setBounds(329, 36, 31, 18);
		alLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		contentPane.add(alLabel);
		
		dataFineTF = new JTextField();
		dataFineTF.setBounds(354, 37, 96, 18);
		dataFineTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		dataFineTF.setColumns(10);
		contentPane.add(dataFineTF);
		
		JButton cercaButton = new JButton("Cerca");
		cercaButton.setBounds(463, 34, 78, 24);
		cercaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				acquistiTab.setModel(new DefaultTableModel(
						controller.getAcquisti(dataInizioTF.getText(), dataFineTF.getText()).toArray(new Object[controller.getAcquisti(dataInizioTF.getText(), dataFineTF.getText()).size()][]),
						new String[] {
								"Data e Ora", "Cassa", "Sconto", "Totale", "Cliente"
						}
				));
			}
		});
		cercaButton.setForeground(Color.BLACK);
		cercaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		cercaButton.setContentAreaFilled(false);
		cercaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		contentPane.add(cercaButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 69, 360, 319);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		acquistiTab = new JTable();
		acquistiTab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dataOra = acquistiTab.getValueAt(acquistiTab.getSelectedRow(), 0).toString();
				char cassa = acquistiTab.getValueAt(acquistiTab.getSelectedRow(), 1).toString().charAt(0);
				prodottiTab.setModel(new DefaultTableModel(
						controller.getProdottiAcquisto(dataOra, cassa).toArray(new Object[controller.getProdottiAcquisto(dataOra, cassa).size()][]),
						new String[] {
								"Nome prodotto", "Quantità"
						}
				));
			}
		});
		acquistiTab.setModel(new DefaultTableModel(
			controller.getAcquisti("", "").toArray(new Object[controller.getAcquisti("", "").size()][]),
			new String[] {
					"Data e Ora", "Cassa", "Sconto", "Totale", "Cliente"
			}
		));
		acquistiTab.setDefaultEditor(Object.class, null);			//permette di non modificare le celle nella tabella
		acquistiTab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(acquistiTab);
		
		JButton indietroButton = new JButton("Indietro");
		indietroButton.setBounds(40, 408, 101, 42);
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiHomepage(attuale, p);
			}
		});
		indietroButton.setForeground(Color.BLACK);
		indietroButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		indietroButton.setContentAreaFilled(false);
		indietroButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		contentPane.add(indietroButton);
		
		JLabel prodottiLabel = new JLabel("Prodotti:");
		prodottiLabel.setBounds(410, 76, 96, 18);
		prodottiLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		contentPane.add(prodottiLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(410, 95, 272, 293);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane_1);
		
		prodottiTab = new JTable();
		prodottiTab.setModel(new DefaultTableModel(
			null,
			new String[] {
					"Nome prodotto", "Quantità"
			}
		));
		prodottiTab.setDefaultEditor(Object.class, null);			//permette di non modificare le celle nella tabella
		prodottiTab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_1.setViewportView(prodottiTab);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(581, 408, 101, 42);
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				acquistiTab.setModel(new DefaultTableModel(
						controller.getAcquisti("", "").toArray(new Object[controller.getAcquisti("", "").size()][]),
						new String[] {
								"Data e Ora", "Cassa", "Sconto", "Totale", "Cliente"
						}
				));
				prodottiTab.setModel(new DefaultTableModel(
						null,
						new String[] {
								"Nome prodotto", "Quantità"
						}
				));
				dataInizioTF.setText("");
				dataFineTF.setText("");
			}
		});
		resetButton.setForeground(Color.BLACK);
		resetButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		resetButton.setContentAreaFilled(false);
		resetButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		contentPane.add(resetButton);
		
		JLabel divisoreLabel = new JLabel("");
		divisoreLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		divisoreLabel.setIcon(new ImageIcon(VisualizzaAcquistiFrame.class.getResource("/immagini/divisore2.png")));
		divisoreLabel.setBounds(151, 399, 429, 51);
		contentPane.add(divisoreLabel);
	}
}
