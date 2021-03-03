package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Classi.Persona;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.ScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Enum.*;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonaleFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable table;
	private JLabel CFLabel, NomeLabel, CognomeLabel, DataNascitaLabel, EmailLabel, SessoLabel, Citt‡Label, ProvinciaLabel;
	private JComboBox CambioRuoloCB;
	
	public PersonaleFrame(Controller c, Persona p) {
		controller = c;
		JFrame attuale = this;
		
		setTitle("OrtofruttaPerTutti - Personale");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonaleFrame.class.getResource("/immagini/fruits.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel InserimentoPersonalePanel = new JPanel();
		InserimentoPersonalePanel.setBackground(new Color(255, 255, 255));
		InserimentoPersonalePanel.setBounds(10, 286, 400, 274);
		contentPane.add(InserimentoPersonalePanel);
		
		JButton AnnullaButton = new JButton("Annulla");
		AnnullaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiHomepage(attuale, p);
			}
		});
		AnnullaButton.setForeground(new Color(0, 0, 0));
		AnnullaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		AnnullaButton.setContentAreaFilled(false);
		AnnullaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		AnnullaButton.setBounds(420, 518, 101, 42);
		contentPane.add(AnnullaButton);
		
		JButton EliminaButton = new JButton("Elimina");
		EliminaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.eliminaPersonaDaCF(table.getValueAt(table.getSelectedRow(), 0).toString(), p);
				table.setModel(new DefaultTableModel(
						controller.getPersonale(),
						new String[] {
								"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Ruolo", "Citta", "Provincia"
						}
					));
			}
		});
		EliminaButton.setForeground(Color.BLACK);
		EliminaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		EliminaButton.setContentAreaFilled(false);
		EliminaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		EliminaButton.setBounds(551, 518, 101, 42);
		contentPane.add(EliminaButton);
		
		JButton SalvaButton = new JButton("Salva");
		SalvaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.modificaRuolo(CambioRuoloCB.getSelectedItem().toString(), p);
				table.setModel(new DefaultTableModel(
						controller.getPersonale(),
						new String[] {
								"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Ruolo", "Citta", "Provincia"
						}
					));
			}
		});
		SalvaButton.setForeground(Color.BLACK);
		SalvaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		SalvaButton.setContentAreaFilled(false);
		SalvaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		SalvaButton.setBounds(683, 518, 101, 42);
		contentPane.add(SalvaButton);
		
		CFLabel = new JLabel("CF:");
		CFLabel.setHorizontalAlignment(SwingConstants.LEFT);
		CFLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		CFLabel.setBounds(444, 37, 340, 14);
		contentPane.add(CFLabel);
		
		NomeLabel = new JLabel("Nome:");
		NomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		NomeLabel.setBounds(444, 70, 340, 14);
		contentPane.add(NomeLabel);
		
		CognomeLabel = new JLabel("Cognome:");
		CognomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		CognomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		CognomeLabel.setBounds(444, 106, 340, 14);
		contentPane.add(CognomeLabel);
		
		DataNascitaLabel = new JLabel("DataNascita:");
		DataNascitaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		DataNascitaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		DataNascitaLabel.setBounds(444, 142, 340, 14);
		contentPane.add(DataNascitaLabel);
		
		EmailLabel = new JLabel("Email:");
		EmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		EmailLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		EmailLabel.setBounds(444, 177, 340, 14);
		contentPane.add(EmailLabel);
		
		SessoLabel = new JLabel("Sesso:");
		SessoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		SessoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		SessoLabel.setBounds(444, 213, 340, 14);
		contentPane.add(SessoLabel);
		
		Citt‡Label = new JLabel("Citt\u00E0:");
		Citt‡Label.setHorizontalAlignment(SwingConstants.LEFT);
		Citt‡Label.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		Citt‡Label.setBounds(444, 249, 340, 14);
		contentPane.add(Citt‡Label);
		
		ProvinciaLabel = new JLabel("Provincia:");
		ProvinciaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ProvinciaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		ProvinciaLabel.setBounds(444, 286, 340, 14);
		contentPane.add(ProvinciaLabel);
		
		JLabel RuoloLabel = new JLabel("Ruolo:");
		RuoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		RuoloLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		RuoloLabel.setBounds(444, 327, 63, 14);
		contentPane.add(RuoloLabel);
		
		CambioRuoloCB = new JComboBox();
		CambioRuoloCB.setModel(new DefaultComboBoxModel(TRuolo.values()));
		CambioRuoloCB.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		CambioRuoloCB.setBackground(new Color(255, 255, 255));
		CambioRuoloCB.setBounds(517, 324, 164, 22);
		CambioRuoloCB.setSelectedIndex(-1);
		contentPane.add(CambioRuoloCB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 10, 400, 266);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.aggiornaLabels(table.getValueAt(table.getSelectedRow(), 0).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			controller.getPersonale(),
			new String[] {
					"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Ruolo", "Citta", "Provincia"
			}
		));
		table.setDefaultEditor(Object.class, null);			//permette di non modificare le celle nella tabella
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 	//permette di eliminare l'autoresize cosÏ da avere spazio illimitato a disposizione per allargare le colonne
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		
	}
	public void setData(String[] etichetteAggiornate, int index) {
		CFLabel.setText("CF: " + etichetteAggiornate[0]);
		NomeLabel.setText("Nome: " + etichetteAggiornate[1]);
		CognomeLabel.setText("Cognome: " + etichetteAggiornate[2]);
		DataNascitaLabel.setText("DataNascita: " + etichetteAggiornate[3]);
		EmailLabel.setText("Email: " + etichetteAggiornate[4]);
		SessoLabel.setText("Sesso: " + etichetteAggiornate[5]);
		Citt‡Label.setText("Citt‡ nascita: " + etichetteAggiornate[6]);
		ProvinciaLabel.setText("Provincia: " + etichetteAggiornate[7]);
		CambioRuoloCB.setSelectedIndex(index);
	}
}
