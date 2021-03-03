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
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.ScrollPane;

public class PersonaleFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	
	public PersonaleFrame(Controller c) {
		controller = c;
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
		AnnullaButton.setForeground(new Color(0, 0, 0));
		AnnullaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		AnnullaButton.setContentAreaFilled(false);
		AnnullaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		AnnullaButton.setBounds(420, 518, 101, 42);
		contentPane.add(AnnullaButton);
		
		JButton EliminaButton = new JButton("Elimina");
		EliminaButton.setForeground(Color.BLACK);
		EliminaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		EliminaButton.setContentAreaFilled(false);
		EliminaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		EliminaButton.setBounds(551, 518, 101, 42);
		contentPane.add(EliminaButton);
		
		JButton SalvaButton = new JButton("Salva");
		SalvaButton.setForeground(Color.BLACK);
		SalvaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		SalvaButton.setContentAreaFilled(false);
		SalvaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		SalvaButton.setBounds(683, 518, 101, 42);
		contentPane.add(SalvaButton);
		
		JLabel CFLabel = new JLabel("CF:");
		CFLabel.setHorizontalAlignment(SwingConstants.LEFT);
		CFLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		CFLabel.setBounds(444, 37, 46, 14);
		contentPane.add(CFLabel);
		
		JLabel NomeLabel = new JLabel("Nome:");
		NomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		NomeLabel.setBounds(444, 70, 63, 14);
		contentPane.add(NomeLabel);
		
		JLabel CognomeLabel = new JLabel("Cognome:");
		CognomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		CognomeLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		CognomeLabel.setBounds(444, 106, 79, 14);
		contentPane.add(CognomeLabel);
		
		JLabel DataNascitaLabel = new JLabel("DataNascita:");
		DataNascitaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		DataNascitaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		DataNascitaLabel.setBounds(444, 142, 109, 14);
		contentPane.add(DataNascitaLabel);
		
		JLabel EmailLabel = new JLabel("Email:");
		EmailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		EmailLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		EmailLabel.setBounds(444, 177, 63, 14);
		contentPane.add(EmailLabel);
		
		JLabel SessoLabel = new JLabel("Sesso:");
		SessoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		SessoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		SessoLabel.setBounds(444, 213, 63, 14);
		contentPane.add(SessoLabel);
		
		JLabel Citt‡Label = new JLabel("Citt\u00E0:");
		Citt‡Label.setHorizontalAlignment(SwingConstants.LEFT);
		Citt‡Label.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		Citt‡Label.setBounds(444, 249, 46, 14);
		contentPane.add(Citt‡Label);
		
		JLabel ProvinciaLabel = new JLabel("Provincia:");
		ProvinciaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ProvinciaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		ProvinciaLabel.setBounds(444, 286, 92, 14);
		contentPane.add(ProvinciaLabel);
		
		JLabel RuoloLabel = new JLabel("Ruolo:");
		RuoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		RuoloLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		RuoloLabel.setBounds(444, 327, 63, 14);
		contentPane.add(RuoloLabel);
		
		JComboBox CambioRuoloCB = new JComboBox();
		CambioRuoloCB.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 15));
		CambioRuoloCB.setBackground(new Color(255, 255, 255));
		CambioRuoloCB.setBounds(517, 324, 164, 22);
		contentPane.add(CambioRuoloCB);
		
		JPanel panel = new JPanel();
		Object[][] data = controller.getPersonale();
		String title[] = {"CF", "Nome", "Cognome", "DataNascita", "Email", "Sesso", "Ruolo", "Citta", "Provincia"};
		JTable table = new JTable(data, title);
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.yellow);
		JScrollPane pane = new JScrollPane(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel.add(pane);
		contentPane.add(panel);
	}
}
