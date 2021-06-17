package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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

import classi.Persona;
import controller.Controller;
import enumerazioni.TSesso;
import enumerazioni.TRuolo;


import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;

public class PersonaleFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTable personaleTab;
	private JLabel CFLabel, nomeLabel, cognomeLabel, dataNascitaLabel, emailLabel, sessoLabel, citt‡Label, provinciaLabel;
	private JComboBox cambioRuoloCB;
	private JTextField nuovoNomeTF, nuovoCognomeTF, nuovaDataNascitaTF, nuovaMailTF;
	private JComboBox nuovoSessoCB, nuovoRuoloCB, nuovaProvinciaCB, nuovaCittaCB;
	private JButton annullaButton, eliminaButton, salvaButton;
	private JLabel venditoreLabel;
	private JLabel fragolaLabel;
	private JLabel pescaLabel;
	
	public PersonaleFrame(Controller c, Persona p) {
		controller = c;
		JFrame attuale = this;
		
		setTitle("OrtofruttaPerTutti - Personale");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonaleFrame.class.getResource("/immagini/fruits.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel inserimentoPersonalePanel = new JPanel();
		inserimentoPersonalePanel.setBackground(new Color(0, 102, 0));
		inserimentoPersonalePanel.setBounds(10, 286, 400, 274);
		contentPane.add(inserimentoPersonalePanel);
		inserimentoPersonalePanel.setLayout(null);
		
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
		inserimentoPersonalePanel.add(resetButton);
		
		JButton inserisciButton = new JButton("Inserisci");
		inserisciButton.setForeground(new Color(0, 0, 0));
		inserisciButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				boolean inserito = controller.inserisciPersona(nuovoNomeTF.getText().toUpperCase(), nuovoCognomeTF.getText().toUpperCase(), 
																nuovaDataNascitaTF.getText(), nuovaMailTF.getText(), nuovoSessoCB.getSelectedItem().toString(), 
																nuovoRuoloCB.getSelectedItem().toString(), "Personale", nuovaCittaCB.getSelectedItem().toString(), 
																nuovaProvinciaCB.getSelectedItem().toString());
				personaleTab.setModel(new DefaultTableModel(
						controller.getPersonale(),
						new String[] {
								"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Ruolo", "Citta", "Provincia"
						}
					));
				if(inserito) {
					controller.aggiornaLabels("", "Personale");
					cambioRuoloCB.setEnabled(false);
					resetForm();
				}
			}
		});
		inserisciButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		inserisciButton.setBorderPainted(false);
		inserisciButton.setBackground(new Color(204, 204, 102));
		inserisciButton.setBounds(261, 236, 102, 27);
		inserimentoPersonalePanel.add(inserisciButton);
		
		JLabel nuovoPersonaleLabel = new JLabel("Inserimento nuovo personale");
		nuovoPersonaleLabel.setForeground(new Color(204, 204, 102));
		nuovoPersonaleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nuovoPersonaleLabel.setFont(new Font("Georgia", Font.BOLD, 14));
		nuovoPersonaleLabel.setIcon(null);
		nuovoPersonaleLabel.setBounds(10, 11, 380, 27);
		inserimentoPersonalePanel.add(nuovoPersonaleLabel);
		
		JLabel nuovoNomeLabel = new JLabel("Nome:");
		nuovoNomeLabel.setForeground(new Color(204, 204, 102));
		nuovoNomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nuovoNomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovoNomeLabel.setBounds(7, 65, 51, 14);
		inserimentoPersonalePanel.add(nuovoNomeLabel);
		
		nuovoNomeTF = new JTextField();
		nuovoNomeTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovoNomeTF.setBounds(60, 62, 149, 21);
		inserimentoPersonalePanel.add(nuovoNomeTF);
		nuovoNomeTF.setColumns(10);
		
		JLabel nuovoCognomeLabel = new JLabel("Cognome:");
		nuovoCognomeLabel.setForeground(new Color(204, 204, 102));
		nuovoCognomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nuovoCognomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovoCognomeLabel.setBounds(7, 90, 79, 17);
		inserimentoPersonalePanel.add(nuovoCognomeLabel);
		
		nuovoCognomeTF = new JTextField();
		nuovoCognomeTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovoCognomeTF.setBounds(89, 88, 120, 21);
		inserimentoPersonalePanel.add(nuovoCognomeTF);
		nuovoCognomeTF.setColumns(10);
		
		JLabel nuovoSessoLabel = new JLabel("Sesso:");
		nuovoSessoLabel.setForeground(new Color(204, 204, 102));
		nuovoSessoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nuovoSessoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovoSessoLabel.setBounds(224, 65, 61, 15);
		inserimentoPersonalePanel.add(nuovoSessoLabel);
		
		nuovoSessoCB = new JComboBox();
		nuovoSessoCB.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovoSessoCB.setModel(new DefaultComboBoxModel(TSesso.values()));
		nuovoSessoCB.setBounds(298, 61, 44, 22);
		inserimentoPersonalePanel.add(nuovoSessoCB);
		
		JLabel nuovoRuoloLabel = new JLabel("Ruolo:");
		nuovoRuoloLabel.setForeground(new Color(204, 204, 102));
		nuovoRuoloLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nuovoRuoloLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovoRuoloLabel.setBounds(234, 91, 51, 14);
		inserimentoPersonalePanel.add(nuovoRuoloLabel);
		
		nuovoRuoloCB = new JComboBox();
		nuovoRuoloCB.setModel(new DefaultComboBoxModel(TRuolo.values()));
		nuovoRuoloCB.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovoRuoloCB.setBounds(298, 87, 92, 22);
		inserimentoPersonalePanel.add(nuovoRuoloCB);
		
		JLabel nuovaDataNascitaLabel = new JLabel("DataNascita:");
		nuovaDataNascitaLabel.setForeground(new Color(204, 204, 102));
		nuovaDataNascitaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nuovaDataNascitaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovaDataNascitaLabel.setBounds(7, 118, 102, 20);
		inserimentoPersonalePanel.add(nuovaDataNascitaLabel);
		
		nuovaDataNascitaTF = new JTextField();
		nuovaDataNascitaTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovaDataNascitaTF.setBounds(108, 118, 282, 21);
		inserimentoPersonalePanel.add(nuovaDataNascitaTF);
		nuovaDataNascitaTF.setColumns(10);
		
		JLabel nuovaProvinciaLabel = new JLabel("Provincia:");
		nuovaProvinciaLabel.setForeground(new Color(204, 204, 102));
		nuovaProvinciaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovaProvinciaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nuovaProvinciaLabel.setBounds(7, 153, 82, 14);
		inserimentoPersonalePanel.add(nuovaProvinciaLabel);
		
		String[] province = null;
		province = controller.getProvince().toArray(new String[controller.getProvince().size()]);
		nuovaProvinciaCB = new JComboBox(province);
		nuovaProvinciaCB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String provincia = nuovaProvinciaCB.getSelectedItem().toString();
				String[] citt‡ = controller.getCittaFromProvincia(provincia).toArray(new String[controller.getCittaFromProvincia(provincia).size()]);
				nuovaCittaCB.setEnabled(true);
				nuovaCittaCB.setModel(new DefaultComboBoxModel(citt‡));
			}
		});
		nuovaProvinciaCB.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovaProvinciaCB.setBounds(87, 149, 111, 22);
		inserimentoPersonalePanel.add(nuovaProvinciaCB);
		
		JLabel nuovaMailLabel = new JLabel("Email:");
		nuovaMailLabel.setForeground(new Color(204, 204, 102));
		nuovaMailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nuovaMailLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovaMailLabel.setBounds(10, 187, 51, 14);
		inserimentoPersonalePanel.add(nuovaMailLabel);
		
		nuovaMailTF = new JTextField();
		nuovaMailTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovaMailTF.setBounds(71, 184, 319, 21);
		inserimentoPersonalePanel.add(nuovaMailTF);
		nuovaMailTF.setColumns(10);
		
		JLabel nuovaCittaLabel = new JLabel("Citt\u00E0:");
		nuovaCittaLabel.setForeground(new Color(204, 204, 102));
		nuovaCittaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nuovaCittaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		nuovaCittaLabel.setBounds(209, 154, 61, 14);
		inserimentoPersonalePanel.add(nuovaCittaLabel);
		
		nuovaCittaCB = new JComboBox();
		nuovaCittaCB.setEnabled(true);
		nuovaCittaCB.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovaCittaCB.setSelectedIndex(-1);
		nuovaCittaCB.setModel(new DefaultComboBoxModel(controller.getCittaFromProvincia(nuovaProvinciaCB.getSelectedItem().toString()).toArray(new String[controller.getCittaFromProvincia(nuovaProvinciaCB.getSelectedItem().toString()).size()])));
		nuovaCittaCB.setBounds(280, 149, 110, 22);
		inserimentoPersonalePanel.add(nuovaCittaCB);
		
		annullaButton = new JButton("Annulla");
		annullaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiHomepage(attuale, p);
			}
		});
		annullaButton.setForeground(new Color(0, 0, 0));
		annullaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 102, 0)));
		annullaButton.setContentAreaFilled(false);
		annullaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		annullaButton.setBounds(420, 518, 101, 42);
		contentPane.add(annullaButton);
		
		eliminaButton = new JButton("Elimina");
		eliminaButton.setEnabled(false);
		eliminaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int riga = personaleTab.getSelectedRow();
				boolean eliminato = controller.eliminaPersonaDaCF(personaleTab.getValueAt(riga, 0).toString(), p);
				personaleTab.setModel(new DefaultTableModel(
						controller.getPersonale(),
						new String[] {
								"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Ruolo", "Citta", "Provincia"
						}
					));
				if(eliminato) {
					controller.aggiornaLabels("", "Personale");
					eliminaButton.setEnabled(false);
					salvaButton.setEnabled(false);
					cambioRuoloCB.setEnabled(false);
				}
				else
					personaleTab.setRowSelectionInterval(riga, riga);
			}
		});
		eliminaButton.setForeground(Color.BLACK);
		eliminaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		eliminaButton.setContentAreaFilled(false);
		eliminaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 102, 0)));
		eliminaButton.setBounds(551, 518, 101, 42);
		contentPane.add(eliminaButton);
		
		salvaButton = new JButton("Salva");
		salvaButton.setEnabled(false);
		salvaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int riga = personaleTab.getSelectedRow();
				controller.modificaRuoloDaCF(cambioRuoloCB.getSelectedItem().toString(), p, personaleTab.getValueAt(personaleTab.getSelectedRow(), 0).toString());
				personaleTab.setModel(new DefaultTableModel(
						controller.getPersonale(),
						new String[] {
								"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Ruolo", "Citta", "Provincia"
						}
				));
				personaleTab.setRowSelectionInterval(riga, riga);
				controller.aggiornaLabels(personaleTab.getValueAt(personaleTab.getSelectedRow(), 0).toString(), "Personale");
			}
		});
		salvaButton.setForeground(Color.BLACK);
		salvaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		salvaButton.setContentAreaFilled(false);
		salvaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 102, 0)));
		salvaButton.setBounds(683, 518, 101, 42);
		contentPane.add(salvaButton);
		
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
		emailLabel.setBounds(434, 197, 350, 26);
		contentPane.add(emailLabel);
		
		sessoLabel = new JLabel("Sesso:");
		sessoLabel.setForeground(new Color(0, 0, 0));
		sessoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		sessoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		sessoLabel.setBounds(434, 233, 350, 26);
		contentPane.add(sessoLabel);
		
		citt‡Label = new JLabel("Citt\u00E0:");
		citt‡Label.setForeground(new Color(0, 0, 0));
		citt‡Label.setHorizontalAlignment(SwingConstants.LEFT);
		citt‡Label.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		citt‡Label.setBounds(434, 269, 350, 27);
		contentPane.add(citt‡Label);
		
		provinciaLabel = new JLabel("Provincia:");
		provinciaLabel.setForeground(new Color(0, 0, 0));
		provinciaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		provinciaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		provinciaLabel.setBounds(434, 306, 350, 31);
		contentPane.add(provinciaLabel);
		
		JLabel ruoloLabel = new JLabel("Ruolo:");
		ruoloLabel.setForeground(new Color(0, 0, 0));
		ruoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ruoloLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		ruoloLabel.setBounds(434, 347, 63, 19);
		contentPane.add(ruoloLabel);
		
		cambioRuoloCB = new JComboBox();
		cambioRuoloCB.setEnabled(false);
		cambioRuoloCB.setModel(new DefaultComboBoxModel(TRuolo.values()));
		cambioRuoloCB.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		cambioRuoloCB.setBackground(new Color(255, 255, 255));
		cambioRuoloCB.setBounds(507, 344, 164, 22);
		cambioRuoloCB.setSelectedIndex(-1);
		contentPane.add(cambioRuoloCB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 10, 400, 266);
		contentPane.add(scrollPane);
		
		personaleTab = new JTable();
		personaleTab.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				controller.aggiornaLabels(personaleTab.getValueAt(personaleTab.getSelectedRow(), 0).toString(), "Personale");
				cambioRuoloCB.setEnabled(true);
				salvaButton.setEnabled(true);
				eliminaButton.setEnabled(true);
			}
		});
		personaleTab.setModel(new DefaultTableModel(
			controller.getPersonale(),
			new String[] {
					"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Ruolo", "Citta", "Provincia"
			}
		));
		personaleTab.setDefaultEditor(Object.class, null);			//permette di non modificare le celle nella tabella
		personaleTab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(personaleTab);
		
		venditoreLabel = new JLabel("");
		venditoreLabel.setIcon(new ImageIcon(PersonaleFrame.class.getResource("/immagini/delivery-courier.png")));
		venditoreLabel.setBounds(563, 398, 77, 80);
		contentPane.add(venditoreLabel);
		
		fragolaLabel = new JLabel("");
		fragolaLabel.setIcon(new ImageIcon(PersonaleFrame.class.getResource("/immagini/fragola.png")));
		fragolaLabel.setBounds(480, 436, 41, 42);
		contentPane.add(fragolaLabel);
		
		pescaLabel = new JLabel("");
		pescaLabel.setIcon(new ImageIcon(PersonaleFrame.class.getResource("/immagini/pesca.png")));
		pescaLabel.setBounds(683, 436, 41, 42);
		contentPane.add(pescaLabel);
		
		
	}
	public void setData(String[] etichetteAggiornate, int index) {
		CFLabel.setText("CF: " + etichetteAggiornate[0]);
		nomeLabel.setText("Nome: " + etichetteAggiornate[1]);
		cognomeLabel.setText("Cognome: " + etichetteAggiornate[2]);
		dataNascitaLabel.setText("DataNascita: " + etichetteAggiornate[3]);
		emailLabel.setText("Email: " + etichetteAggiornate[4]);
		sessoLabel.setText("Sesso: " + etichetteAggiornate[5]);
		citt‡Label.setText("Citt‡ nascita: " + etichetteAggiornate[6]);
		provinciaLabel.setText("Provincia: " + etichetteAggiornate[7]);
		cambioRuoloCB.setSelectedIndex(index);
	}
	
	private void resetForm() {
		nuovoNomeTF.setText("");
		nuovoCognomeTF.setText("");
		nuovaDataNascitaTF.setText("");
		nuovaMailTF.setText("");
		nuovoSessoCB.setSelectedIndex(0);
		nuovoRuoloCB.setSelectedIndex(0);
		nuovaProvinciaCB.setSelectedIndex(0);
		nuovaCittaCB.setSelectedIndex(0);
	}
}