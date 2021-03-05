package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classi.CittaItaliana;
import Classi.Persona;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Enum.*;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ClientiFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable table;
	private JLabel CFLabel, NomeLabel, CognomeLabel, DataNascitaLabel, EmailLabel, SessoLabel, Citt‡Label, ProvinciaLabel;
	private JTextField NuovoNomeTF, NuovoCognomeTF, NuovaDataNascitaTF, NuovaMailTF;
	private JComboBox NuovoSessoCB, NuovaProvinciaCB, NuovaCittaCB;
	private JButton AnnullaButton, EliminaButton;
	
	public ClientiFrame(Controller c, Persona p) {
		controller = c;
		JFrame attuale = this;
		
		setTitle("OrtofruttaPerTutti - Clienti");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientiFrame.class.getResource("/immagini/fruits.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel InserimentoClientiPanel = new JPanel();
		InserimentoClientiPanel.setBackground(new Color(255, 255, 255));
		InserimentoClientiPanel.setBounds(10, 286, 400, 274);
		contentPane.add(InserimentoClientiPanel);
		InserimentoClientiPanel.setLayout(null);
		
		JButton ResetButton = new JButton("Reset");
		ResetButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				resetForm();
			}
		});
		ResetButton.setForeground(new Color(255, 255, 255));
		ResetButton.setBorderPainted(false);
		ResetButton.setBackground(new Color(165, 42, 42));
		ResetButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		ResetButton.setBounds(28, 236, 102, 27);
		InserimentoClientiPanel.add(ResetButton);
		
		JButton InserisciButton = new JButton("Inserisci");
		InserisciButton.setForeground(new Color(255, 255, 255));
		InserisciButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				boolean inserito = controller.inserisciPersona(NuovoNomeTF.getText().toUpperCase(), NuovoCognomeTF.getText().toUpperCase(), 
																NuovaDataNascitaTF.getText(), NuovaMailTF.getText(), NuovoSessoCB.getSelectedItem().toString(), 
																"", "Cliente", NuovaCittaCB.getSelectedItem().toString(), 
																NuovaProvinciaCB.getSelectedItem().toString());
				table.setModel(new DefaultTableModel(
						controller.getClienti(),
						new String[] {
								"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Citta", "Provincia"
						}
					));
				if(inserito) {
					controller.aggiornaLabels("", "Clienti");
					resetForm();
				}
			}
		});
		InserisciButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		InserisciButton.setBorderPainted(false);
		InserisciButton.setBackground(new Color(165, 42, 42));
		InserisciButton.setBounds(261, 236, 102, 27);
		InserimentoClientiPanel.add(InserisciButton);
		
		JLabel NuovoClienteLabel = new JLabel("Inserimento nuovo personale");
		NuovoClienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NuovoClienteLabel.setFont(new Font("Georgia", Font.BOLD, 14));
		NuovoClienteLabel.setIcon(null);
		NuovoClienteLabel.setBounds(10, 11, 380, 27);
		InserimentoClientiPanel.add(NuovoClienteLabel);
		
		JLabel NuovoNomeLabel = new JLabel("Nome:");
		NuovoNomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NuovoNomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		NuovoNomeLabel.setBounds(7, 65, 51, 14);
		InserimentoClientiPanel.add(NuovoNomeLabel);
		
		NuovoNomeTF = new JTextField();
		NuovoNomeTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		NuovoNomeTF.setBounds(60, 62, 149, 21);
		InserimentoClientiPanel.add(NuovoNomeTF);
		NuovoNomeTF.setColumns(10);
		
		JLabel NuovoCognomeLabel = new JLabel("Cognome:");
		NuovoCognomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NuovoCognomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		NuovoCognomeLabel.setBounds(7, 90, 79, 17);
		InserimentoClientiPanel.add(NuovoCognomeLabel);
		
		NuovoCognomeTF = new JTextField();
		NuovoCognomeTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		NuovoCognomeTF.setBounds(89, 88, 120, 21);
		InserimentoClientiPanel.add(NuovoCognomeTF);
		NuovoCognomeTF.setColumns(10);
		
		JLabel NuovoSessoLabel = new JLabel("Sesso:");
		NuovoSessoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		NuovoSessoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		NuovoSessoLabel.setBounds(224, 65, 61, 15);
		InserimentoClientiPanel.add(NuovoSessoLabel);
		
		NuovoSessoCB = new JComboBox();
		NuovoSessoCB.setFont(new Font("Georgia", Font.PLAIN, 14));
		NuovoSessoCB.setModel(new DefaultComboBoxModel(TSesso.values()));
		NuovoSessoCB.setBounds(298, 61, 44, 22);
		InserimentoClientiPanel.add(NuovoSessoCB);
		
		JLabel NuovaDataNascitaLabel = new JLabel("DataNascita:");
		NuovaDataNascitaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NuovaDataNascitaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		NuovaDataNascitaLabel.setBounds(7, 118, 102, 20);
		InserimentoClientiPanel.add(NuovaDataNascitaLabel);
		
		NuovaDataNascitaTF = new JTextField();
		NuovaDataNascitaTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		NuovaDataNascitaTF.setBounds(108, 118, 282, 21);
		InserimentoClientiPanel.add(NuovaDataNascitaTF);
		NuovaDataNascitaTF.setColumns(10);
		
		JLabel NuovaProvinciaLabel = new JLabel("Provincia:");
		NuovaProvinciaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		NuovaProvinciaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NuovaProvinciaLabel.setBounds(7, 153, 82, 14);
		InserimentoClientiPanel.add(NuovaProvinciaLabel);
		
		String[] province = null;
		province = controller.getProvince().toArray(new String[controller.getProvince().size()]);
		NuovaProvinciaCB = new JComboBox(province);
		NuovaProvinciaCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String provincia = NuovaProvinciaCB.getSelectedItem().toString();
				String[] citt‡ = controller.getCittaFromProvincia(provincia).toArray(new String[controller.getCittaFromProvincia(provincia).size()]);
				NuovaCittaCB.setEnabled(true);
				NuovaCittaCB.setModel(new DefaultComboBoxModel(citt‡));
			}
		});
		NuovaProvinciaCB.setFont(new Font("Georgia", Font.PLAIN, 14));
		NuovaProvinciaCB.setBounds(87, 149, 111, 22);
		InserimentoClientiPanel.add(NuovaProvinciaCB);
		
		JLabel NuovaMailLabel = new JLabel("Email:");
		NuovaMailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NuovaMailLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		NuovaMailLabel.setBounds(10, 187, 51, 14);
		InserimentoClientiPanel.add(NuovaMailLabel);
		
		NuovaMailTF = new JTextField();
		NuovaMailTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		NuovaMailTF.setBounds(71, 184, 319, 21);
		InserimentoClientiPanel.add(NuovaMailTF);
		NuovaMailTF.setColumns(10);
		
		JLabel NuovaCittaLabel = new JLabel("Citt\u00E0:");
		NuovaCittaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		NuovaCittaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		NuovaCittaLabel.setBounds(209, 154, 61, 14);
		InserimentoClientiPanel.add(NuovaCittaLabel);
		
		NuovaCittaCB = new JComboBox();
		NuovaCittaCB.setEnabled(true);
		NuovaCittaCB.setFont(new Font("Georgia", Font.PLAIN, 14));
		NuovaCittaCB.setSelectedIndex(-1);
		NuovaCittaCB.setModel(new DefaultComboBoxModel(controller.getCittaFromProvincia(NuovaProvinciaCB.getSelectedItem().toString()).toArray(new String[controller.getCittaFromProvincia(NuovaProvinciaCB.getSelectedItem().toString()).size()])));
		NuovaCittaCB.setBounds(280, 149, 110, 22);
		InserimentoClientiPanel.add(NuovaCittaCB);
		
		AnnullaButton = new JButton("Annulla");
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
		
		EliminaButton = new JButton("Elimina");
		EliminaButton.setEnabled(false);
		EliminaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int riga = table.getSelectedRow();
				boolean eliminato = controller.eliminaPersonaDaCF(table.getValueAt(riga, 0).toString(), p);
				table.setModel(new DefaultTableModel(
						controller.getClienti(),
						new String[] {
								"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Citta", "Provincia"
						}
					));
				if(eliminato) {
					controller.aggiornaLabels("", "Clienti");
					EliminaButton.setEnabled(false);
				}
				else
					table.setRowSelectionInterval(riga, riga);
			}
		});
		EliminaButton.setForeground(Color.BLACK);
		EliminaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		EliminaButton.setContentAreaFilled(false);
		EliminaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		EliminaButton.setBounds(683, 518, 101, 42);
		contentPane.add(EliminaButton);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 10, 400, 266);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				controller.aggiornaLabels(table.getValueAt(table.getSelectedRow(), 0).toString(), "Clienti");
				EliminaButton.setEnabled(true);
			}
		});
		table.setModel(new DefaultTableModel(
			controller.getClienti(),
			new String[] {
					"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Citta", "Provincia"
			}
		));
		table.setDefaultEditor(Object.class, null);			//permette di non modificare le celle nella tabella
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		
	}
	public void setData(String[] etichetteAggiornate) {
		CFLabel.setText("CF: " + etichetteAggiornate[0]);
		NomeLabel.setText("Nome: " + etichetteAggiornate[1]);
		CognomeLabel.setText("Cognome: " + etichetteAggiornate[2]);
		DataNascitaLabel.setText("DataNascita: " + etichetteAggiornate[3]);
		EmailLabel.setText("Email: " + etichetteAggiornate[4]);
		SessoLabel.setText("Sesso: " + etichetteAggiornate[5]);
		Citt‡Label.setText("Citt‡ nascita: " + etichetteAggiornate[6]);
		ProvinciaLabel.setText("Provincia: " + etichetteAggiornate[7]);
	}
	
	private void resetForm() {
		NuovoNomeTF.setText("");
		NuovoCognomeTF.setText("");
		NuovaDataNascitaTF.setText("");
		NuovaMailTF.setText("");
		NuovoSessoCB.setSelectedIndex(0);
		NuovaProvinciaCB.setSelectedIndex(0);
		NuovaCittaCB.setSelectedIndex(0);
	}
}