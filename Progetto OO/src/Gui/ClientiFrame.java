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
import javax.swing.ImageIcon;

public class ClientiFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable clientiTab;
	private JLabel CFLabel, nomeLabel, cognomeLabel, dataNascitaLabel, emailLabel, sessoLabel, cittaLabel, provinciaLabel;
	private JTextField nuovoNomeTF, nuovoCognomeTF, nuovaDataNascitaTF, nuovaMailTF;
	private JComboBox nuovoSessoCB, nuovaProvinciaCB, nuovaCittaCB;
	private JButton annullaButton, eliminaButton;
	private JButton modificaMailButton;
	private JLabel venditoreLabel;
	private JLabel mangoLabel;
	private JLabel melaLabel;
	
	public ClientiFrame(Controller c, Persona p) {
		controller = c;
		JFrame attuale = this;
		
		setTitle("OrtofruttaPerTutti - Clienti");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientiFrame.class.getResource("/immagini/fruits.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel inserimentoClientiPanel = new JPanel();
		inserimentoClientiPanel.setForeground(new Color(0, 0, 0));
		inserimentoClientiPanel.setBackground(new Color(204, 153, 0));
		inserimentoClientiPanel.setBounds(10, 286, 400, 274);
		contentPane.add(inserimentoClientiPanel);
		inserimentoClientiPanel.setLayout(null);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				resetForm();
			}
		});
		resetButton.setForeground(new Color(0, 0, 0));
		resetButton.setBorderPainted(false);
		resetButton.setBackground(new Color(204, 204, 102));
		resetButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		resetButton.setBounds(28, 236, 102, 27);
		inserimentoClientiPanel.add(resetButton);
		
		JButton inserisciButton = new JButton("Inserisci");
		inserisciButton.setForeground(new Color(0, 0, 0));
		inserisciButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				boolean inserito = controller.inserisciPersona(nuovoNomeTF.getText().toUpperCase(), nuovoCognomeTF.getText().toUpperCase(), 
																nuovaDataNascitaTF.getText(), nuovaMailTF.getText(), nuovoSessoCB.getSelectedItem().toString(), 
																"", "Cliente", nuovaCittaCB.getSelectedItem().toString(), 
																nuovaProvinciaCB.getSelectedItem().toString());
				clientiTab.setModel(new DefaultTableModel(
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
		inserisciButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		inserisciButton.setBorderPainted(false);
		inserisciButton.setBackground(new Color(204, 204, 102));
		inserisciButton.setBounds(261, 236, 102, 27);
		inserimentoClientiPanel.add(inserisciButton);
		
		JLabel nuovoClienteLabel = new JLabel("Inserimento nuovo cliente");
		nuovoClienteLabel.setBackground(new Color(204, 102, 51));
		nuovoClienteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nuovoClienteLabel.setFont(new Font("Georgia", Font.BOLD, 14));
		nuovoClienteLabel.setIcon(null);
		nuovoClienteLabel.setBounds(10, 11, 380, 27);
		inserimentoClientiPanel.add(nuovoClienteLabel);
		
		JLabel nuovoNomeLabel = new JLabel("Nome:");
		nuovoNomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nuovoNomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovoNomeLabel.setBounds(7, 65, 51, 14);
		inserimentoClientiPanel.add(nuovoNomeLabel);
		
		nuovoNomeTF = new JTextField();
		nuovoNomeTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovoNomeTF.setBounds(60, 62, 149, 21);
		inserimentoClientiPanel.add(nuovoNomeTF);
		nuovoNomeTF.setColumns(10);
		
		JLabel nuovoCognomeLabel = new JLabel("Cognome:");
		nuovoCognomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nuovoCognomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovoCognomeLabel.setBounds(7, 90, 79, 17);
		inserimentoClientiPanel.add(nuovoCognomeLabel);
		
		nuovoCognomeTF = new JTextField();
		nuovoCognomeTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovoCognomeTF.setBounds(89, 88, 120, 21);
		inserimentoClientiPanel.add(nuovoCognomeTF);
		nuovoCognomeTF.setColumns(10);
		
		JLabel nuovoSessoLabel = new JLabel("Sesso:");
		nuovoSessoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nuovoSessoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovoSessoLabel.setBounds(224, 65, 61, 15);
		inserimentoClientiPanel.add(nuovoSessoLabel);
		
		nuovoSessoCB = new JComboBox();
		nuovoSessoCB.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovoSessoCB.setModel(new DefaultComboBoxModel(TSesso.values()));
		nuovoSessoCB.setBounds(298, 61, 44, 22);
		inserimentoClientiPanel.add(nuovoSessoCB);
		
		JLabel nuovaDataNascitaLabel = new JLabel("DataNascita:");
		nuovaDataNascitaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nuovaDataNascitaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovaDataNascitaLabel.setBounds(7, 118, 102, 20);
		inserimentoClientiPanel.add(nuovaDataNascitaLabel);
		
		nuovaDataNascitaTF = new JTextField();
		nuovaDataNascitaTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovaDataNascitaTF.setBounds(108, 118, 282, 21);
		inserimentoClientiPanel.add(nuovaDataNascitaTF);
		nuovaDataNascitaTF.setColumns(10);
		
		JLabel nuovaProvinciaLabel = new JLabel("Provincia:");
		nuovaProvinciaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovaProvinciaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nuovaProvinciaLabel.setBounds(7, 153, 82, 14);
		inserimentoClientiPanel.add(nuovaProvinciaLabel);
		
		String[] province = null;
		province = controller.getProvince().toArray(new String[controller.getProvince().size()]);
		nuovaProvinciaCB = new JComboBox(province);
		nuovaProvinciaCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String provincia = nuovaProvinciaCB.getSelectedItem().toString();
				String[] città = controller.getCittaFromProvincia(provincia).toArray(new String[controller.getCittaFromProvincia(provincia).size()]);
				nuovaCittaCB.setEnabled(true);
				nuovaCittaCB.setModel(new DefaultComboBoxModel(città));
			}
		});
		nuovaProvinciaCB.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovaProvinciaCB.setBounds(87, 149, 111, 22);
		inserimentoClientiPanel.add(nuovaProvinciaCB);
		
		JLabel nuovaMailLabel = new JLabel("Email:");
		nuovaMailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nuovaMailLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovaMailLabel.setBounds(10, 187, 51, 14);
		inserimentoClientiPanel.add(nuovaMailLabel);
		
		nuovaMailTF = new JTextField();
		nuovaMailTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovaMailTF.setBounds(71, 184, 319, 21);
		inserimentoClientiPanel.add(nuovaMailTF);
		nuovaMailTF.setColumns(10);
		
		JLabel nuovaCittaLabel = new JLabel("Citt\u00E0:");
		nuovaCittaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nuovaCittaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovaCittaLabel.setBounds(209, 154, 61, 14);
		inserimentoClientiPanel.add(nuovaCittaLabel);
		
		nuovaCittaCB = new JComboBox();
		nuovaCittaCB.setEnabled(true);
		nuovaCittaCB.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovaCittaCB.setSelectedIndex(-1);
		nuovaCittaCB.setModel(new DefaultComboBoxModel(controller.getCittaFromProvincia(nuovaProvinciaCB.getSelectedItem().toString()).toArray(new String[controller.getCittaFromProvincia(nuovaProvinciaCB.getSelectedItem().toString()).size()])));
		nuovaCittaCB.setBounds(280, 149, 110, 22);
		inserimentoClientiPanel.add(nuovaCittaCB);
		
		annullaButton = new JButton("Annulla");
		annullaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiHomepage(attuale, p);
			}
		});
		annullaButton.setForeground(new Color(0, 0, 0));
		annullaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		annullaButton.setContentAreaFilled(false);
		annullaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		annullaButton.setBounds(420, 518, 101, 42);
		contentPane.add(annullaButton);
		
		eliminaButton = new JButton("Elimina");
		eliminaButton.setEnabled(false);
		eliminaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int riga = clientiTab.getSelectedRow();
				boolean eliminato = controller.eliminaPersonaDaCF(clientiTab.getValueAt(riga, 0).toString(), p);
				clientiTab.setModel(new DefaultTableModel(
						controller.getClienti(),
						new String[] {
								"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Citta", "Provincia"
						}
					));
				if(eliminato) {
					controller.aggiornaLabels("", "Clienti");
					eliminaButton.setEnabled(false);
				}
				else
					clientiTab.setRowSelectionInterval(riga, riga);
			}
		});
		eliminaButton.setForeground(new Color(0, 0, 0));
		eliminaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		eliminaButton.setContentAreaFilled(false);
		eliminaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		eliminaButton.setBounds(683, 518, 101, 42);
		contentPane.add(eliminaButton);
		
		CFLabel = new JLabel("CF:");
		CFLabel.setForeground(new Color(0, 0, 0));
		CFLabel.setHorizontalAlignment(SwingConstants.LEFT);
		CFLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		CFLabel.setBounds(434, 57, 350, 23);
		contentPane.add(CFLabel);
		
		nomeLabel = new JLabel("Nome:");
		nomeLabel.setForeground(new Color(0, 0, 0));
		nomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		nomeLabel.setBounds(434, 90, 350, 26);
		contentPane.add(nomeLabel);
		
		cognomeLabel = new JLabel("Cognome:");
		cognomeLabel.setForeground(new Color(0, 0, 0));
		cognomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cognomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		cognomeLabel.setBounds(434, 126, 350, 26);
		contentPane.add(cognomeLabel);
		
		dataNascitaLabel = new JLabel("DataNascita:");
		dataNascitaLabel.setForeground(new Color(0, 0, 0));
		dataNascitaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dataNascitaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		dataNascitaLabel.setBounds(434, 162, 350, 25);
		contentPane.add(dataNascitaLabel);
		
		emailLabel = new JLabel("Email:");
		emailLabel.setForeground(new Color(0, 0, 0));
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		emailLabel.setBounds(434, 314, 350, 26);
		contentPane.add(emailLabel);
		
		sessoLabel = new JLabel("Sesso:");
		sessoLabel.setForeground(new Color(0, 0, 0));
		sessoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		sessoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		sessoLabel.setBounds(434, 198, 350, 26);
		contentPane.add(sessoLabel);
		
		cittaLabel = new JLabel("Citt\u00E0:");
		cittaLabel.setForeground(new Color(0, 0, 0));
		cittaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cittaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		cittaLabel.setBounds(434, 235, 350, 27);
		contentPane.add(cittaLabel);
		
		provinciaLabel = new JLabel("Provincia:");
		provinciaLabel.setForeground(new Color(0, 0, 0));
		provinciaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		provinciaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		provinciaLabel.setBounds(434, 273, 350, 31);
		contentPane.add(provinciaLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 10, 400, 266);
		contentPane.add(scrollPane);
		
		modificaMailButton = new JButton("Modifica");
		modificaMailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.vaiModificaAccount(attuale, p, clientiTab.getValueAt(clientiTab.getSelectedRow(), 0).toString());
			}
		});
		modificaMailButton.setForeground(new Color(0, 0, 0));
		modificaMailButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		modificaMailButton.setEnabled(false);
		modificaMailButton.setContentAreaFilled(false);
		modificaMailButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		modificaMailButton.setBounds(552, 518, 101, 42);
		contentPane.add(modificaMailButton);
		
		clientiTab = new JTable();
		clientiTab.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				controller.aggiornaLabels(clientiTab.getValueAt(clientiTab.getSelectedRow(), 0).toString(), "Clienti");
				eliminaButton.setEnabled(true);
				modificaMailButton.setEnabled(true);
			}
		});
		clientiTab.setModel(new DefaultTableModel(
			controller.getClienti(),
			new String[] {
					"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Citta", "Provincia"
			}
		));
		clientiTab.setDefaultEditor(Object.class, null);			//permette di non modificare le celle nella tabella
		clientiTab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(clientiTab);
		
		venditoreLabel = new JLabel("");
		venditoreLabel.setIcon(new ImageIcon(ClientiFrame.class.getResource("/immagini/delivery-courier.png")));
		venditoreLabel.setBounds(567, 412, 67, 72);
		contentPane.add(venditoreLabel);
		
		mangoLabel = new JLabel("");
		mangoLabel.setIcon(new ImageIcon(ClientiFrame.class.getResource("/immagini/mango.png")));
		mangoLabel.setBounds(475, 432, 46, 52);
		contentPane.add(mangoLabel);
		
		melaLabel = new JLabel("");
		melaLabel.setIcon(new ImageIcon(ClientiFrame.class.getResource("/immagini/mela.png")));
		melaLabel.setBounds(683, 432, 46, 52);
		contentPane.add(melaLabel);
	}
	public void setData(String[] etichetteAggiornate) {
		CFLabel.setText("CF: " + etichetteAggiornate[0]);
		nomeLabel.setText("Nome: " + etichetteAggiornate[1]);
		cognomeLabel.setText("Cognome: " + etichetteAggiornate[2]);
		dataNascitaLabel.setText("DataNascita: " + etichetteAggiornate[3]);
		emailLabel.setText("Email: " + etichetteAggiornate[4]);
		sessoLabel.setText("Sesso: " + etichetteAggiornate[5]);
		cittaLabel.setText("Città nascita: " + etichetteAggiornate[6]);
		provinciaLabel.setText("Provincia: " + etichetteAggiornate[7]);
	}
	
	private void resetForm() {
		nuovoNomeTF.setText("");
		nuovoCognomeTF.setText("");
		nuovaDataNascitaTF.setText("");
		nuovaMailTF.setText("");
		nuovoSessoCB.setSelectedIndex(0);
		nuovaProvinciaCB.setSelectedIndex(0);
		nuovaCittaCB.setSelectedIndex(0);
	}
}