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


import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		
		JPanel inserimentoClientiPanel = new JPanel();
		inserimentoClientiPanel.setForeground(new Color(0, 0, 0));
		inserimentoClientiPanel.setBackground(new Color(204, 153, 0));
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
		
		CFLabel = new JLabel("CF:");
		CFLabel.setForeground(new Color(0, 0, 0));
		CFLabel.setHorizontalAlignment(SwingConstants.LEFT);
		CFLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		
		nomeLabel = new JLabel("Nome:");
		nomeLabel.setForeground(new Color(0, 0, 0));
		nomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		
		cognomeLabel = new JLabel("Cognome:");
		cognomeLabel.setForeground(new Color(0, 0, 0));
		cognomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cognomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		
		dataNascitaLabel = new JLabel("DataNascita:");
		dataNascitaLabel.setForeground(new Color(0, 0, 0));
		dataNascitaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dataNascitaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		
		emailLabel = new JLabel("Email:");
		emailLabel.setForeground(new Color(0, 0, 0));
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		
		sessoLabel = new JLabel("Sesso:");
		sessoLabel.setForeground(new Color(0, 0, 0));
		sessoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		sessoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		
		cittaLabel = new JLabel("Citt\u00E0:");
		cittaLabel.setForeground(new Color(0, 0, 0));
		cittaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cittaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		
		provinciaLabel = new JLabel("Provincia:");
		provinciaLabel.setForeground(new Color(0, 0, 0));
		provinciaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		provinciaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
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
		
		mangoLabel = new JLabel("");
		mangoLabel.setIcon(new ImageIcon(ClientiFrame.class.getResource("/immagini/mango.png")));
		
		melaLabel = new JLabel("");
		melaLabel.setIcon(new ImageIcon(ClientiFrame.class.getResource("/immagini/mela.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
						.addComponent(inserimentoClientiPanel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(CFLabel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(nomeLabel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(cognomeLabel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(dataNascitaLabel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(sessoLabel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(cittaLabel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(provinciaLabel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(mangoLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addComponent(venditoreLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(melaLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(annullaButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(modificaMailButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(eliminaButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(inserimentoClientiPanel, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addComponent(CFLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(nomeLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(cognomeLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(dataNascitaLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(sessoLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(cittaLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(provinciaLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(mangoLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addComponent(venditoreLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(melaLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(annullaButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(modificaMailButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(eliminaButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		pack();
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