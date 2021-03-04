package Gui;

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
		EliminaButton.setEnabled(false);
		EliminaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		SalvaButton.setEnabled(false);
		SalvaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int riga = table.getSelectedRow();
				controller.modificaRuoloDaCF(CambioRuoloCB.getSelectedItem().toString(), p, table.getValueAt(table.getSelectedRow(), 0).toString());
				table.setModel(new DefaultTableModel(
						controller.getPersonale(),
						new String[] {
								"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Ruolo", "Citta", "Provincia"
						}
				));
				table.setRowSelectionInterval(riga, riga);
			}
		});
		SalvaButton.setForeground(Color.BLACK);
		SalvaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		SalvaButton.setContentAreaFilled(false);
		SalvaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		SalvaButton.setBounds(683, 518, 101, 42);
		contentPane.add(SalvaButton);
		
		CFLabel = new JLabel("CF:");
		CFLabel.setForeground(Color.WHITE);
		CFLabel.setHorizontalAlignment(SwingConstants.LEFT);
		CFLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		CFLabel.setBounds(434, 57, 350, 23);
		contentPane.add(CFLabel);
		
		NomeLabel = new JLabel("Nome:");
		NomeLabel.setForeground(Color.WHITE);
		NomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		NomeLabel.setBounds(434, 90, 350, 26);
		contentPane.add(NomeLabel);
		
		CognomeLabel = new JLabel("Cognome:");
		CognomeLabel.setForeground(Color.WHITE);
		CognomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		CognomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		CognomeLabel.setBounds(434, 126, 350, 26);
		contentPane.add(CognomeLabel);
		
		DataNascitaLabel = new JLabel("DataNascita:");
		DataNascitaLabel.setForeground(Color.WHITE);
		DataNascitaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		DataNascitaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		DataNascitaLabel.setBounds(434, 162, 350, 25);
		contentPane.add(DataNascitaLabel);
		
		EmailLabel = new JLabel("Email:");
		EmailLabel.setForeground(Color.WHITE);
		EmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		EmailLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		EmailLabel.setBounds(434, 197, 350, 26);
		contentPane.add(EmailLabel);
		
		SessoLabel = new JLabel("Sesso:");
		SessoLabel.setForeground(Color.WHITE);
		SessoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		SessoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		SessoLabel.setBounds(434, 233, 350, 26);
		contentPane.add(SessoLabel);
		
		Citt‡Label = new JLabel("Citt\u00E0:");
		Citt‡Label.setForeground(Color.WHITE);
		Citt‡Label.setHorizontalAlignment(SwingConstants.LEFT);
		Citt‡Label.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		Citt‡Label.setBounds(434, 269, 350, 27);
		contentPane.add(Citt‡Label);
		
		ProvinciaLabel = new JLabel("Provincia:");
		ProvinciaLabel.setForeground(Color.WHITE);
		ProvinciaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ProvinciaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		ProvinciaLabel.setBounds(434, 306, 350, 31);
		contentPane.add(ProvinciaLabel);
		
		JLabel RuoloLabel = new JLabel("Ruolo:");
		RuoloLabel.setForeground(Color.WHITE);
		RuoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		RuoloLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		RuoloLabel.setBounds(434, 347, 63, 19);
		contentPane.add(RuoloLabel);
		
		CambioRuoloCB = new JComboBox();
		CambioRuoloCB.setEnabled(false);
		CambioRuoloCB.setModel(new DefaultComboBoxModel(TRuolo.values()));
		CambioRuoloCB.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		CambioRuoloCB.setBackground(new Color(255, 255, 255));
		CambioRuoloCB.setBounds(507, 344, 164, 22);
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
			public void mouseClicked(MouseEvent e){
				controller.aggiornaLabels(table.getValueAt(table.getSelectedRow(), 0).toString());
				//table.setRowSelectionInterval(0, 0);
				CambioRuoloCB.setEnabled(true);
				SalvaButton.setEnabled(true);
				EliminaButton.setEnabled(true);
			}
		});
		table.setModel(new DefaultTableModel(
			controller.getPersonale(),
			new String[] {
					"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Ruolo", "Citta", "Provincia"
			}
		));
		//table.setRowSelectionInterval(0, 0);
		//controller.aggiornaLabels(table.getValueAt(0, 0).toString());
		table.setDefaultEditor(Object.class, null);			//permette di non modificare le celle nella tabella
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
