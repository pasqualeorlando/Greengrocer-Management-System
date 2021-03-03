package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import Classi.*;
import Controller.Controller;

import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomepageFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;

	
	public HomepageFrame(Controller c, Persona p) {
		controller = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomepageFrame.class.getResource("/immagini/fruits.png")));
		setTitle("OrtofruttaPerTutti - Homepage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(0, 0, 269, 571);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel SalutoLabel = new JLabel("Ciao " + p.getNome() + "!");
		SalutoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SalutoLabel.setForeground(new Color(255, 255, 255));
		SalutoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 25));
		SalutoLabel.setBounds(21, 60, 225, 54);
		panel.add(SalutoLabel);
		
		JLabel NomeLabel = new JLabel("Nome: " + p.getNome());
		NomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NomeLabel.setForeground(new Color(255, 255, 255));
		NomeLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		NomeLabel.setBounds(10, 221, 225, 21);
		panel.add(NomeLabel);
		
		JLabel CognomeLabel = new JLabel("Cognome: " + p.getCognome());
		CognomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		CognomeLabel.setForeground(Color.WHITE);
		CognomeLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		CognomeLabel.setBounds(10, 266, 225, 21);
		panel.add(CognomeLabel);
		
		JLabel RuoloLabel = new JLabel("Ruolo: " + p.getRuolo());
		RuoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		RuoloLabel.setForeground(Color.WHITE);
		RuoloLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		RuoloLabel.setBounds(10, 313, 225, 21);
		panel.add(RuoloLabel);
		
		JButton EsciButton = new JButton("Esci");
		EsciButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.exit();
			}
		});
		EsciButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		EsciButton.setContentAreaFilled(false);
		EsciButton.setForeground(new Color(255, 255, 255));
		EsciButton.setFont(new Font("Georgia", Font.PLAIN, 17));
		EsciButton.setBounds(170, 520, 89, 40);
		panel.add(EsciButton);
		
		JButton ModificaAccButton = new JButton("<html><center>Modifica<br>Account</center></html>");
		ModificaAccButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiModificaAccount(p);
			}
		});
		ModificaAccButton.setForeground(Color.WHITE);
		ModificaAccButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		ModificaAccButton.setContentAreaFilled(false);
		ModificaAccButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		ModificaAccButton.setBounds(10, 520, 125, 40);
		panel.add(ModificaAccButton);
		
		JButton PersonaleButton = new JButton("Personale");
		PersonaleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiPersonale();
			}
		});
		PersonaleButton.setContentAreaFilled(false);
		PersonaleButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/personale.png")));
		PersonaleButton.setFont(new Font("Georgia", Font.BOLD, 15));
		PersonaleButton.setForeground(new Color(178, 34, 34));
		PersonaleButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		PersonaleButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		PersonaleButton.setBackground(new Color(178, 34, 34));
		PersonaleButton.setBounds(304, 11, 135, 165);
		PersonaleButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		PersonaleButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(PersonaleButton);
		
		JButton ClientiButton = new JButton("Clienti");
		ClientiButton.setContentAreaFilled(false);
		ClientiButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/clienti.png")));
		ClientiButton.setFont(new Font("Georgia", Font.BOLD, 15));
		ClientiButton.setForeground(new Color(178, 34, 34));
		ClientiButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		ClientiButton.setBackground(new Color(178, 34, 34));
		ClientiButton.setBounds(466, 11, 135, 165);
		ClientiButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		ClientiButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(ClientiButton);
		
		JButton ProdottiButton = new JButton("Prodotti");
		ProdottiButton.setContentAreaFilled(false);
		ProdottiButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/prodotti.png")));
		ProdottiButton.setFont(new Font("Georgia", Font.BOLD, 15));
		ProdottiButton.setForeground(new Color(178, 34, 34));
		ProdottiButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		ProdottiButton.setBackground(new Color(153, 51, 51));
		ProdottiButton.setBounds(626, 11, 135, 165);
		ProdottiButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		ProdottiButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(ProdottiButton);
		
		JButton RicercaClientiButton = new JButton("<html><center>Ricerca<br>Clienti</center></html>");
		RicercaClientiButton.setContentAreaFilled(false);
		RicercaClientiButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/ricercaclienti.png")));
		RicercaClientiButton.setFont(new Font("Georgia", Font.BOLD, 15));
		RicercaClientiButton.setForeground(new Color(178, 34, 34));
		RicercaClientiButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		RicercaClientiButton.setBackground(new Color(153, 51, 51));
		RicercaClientiButton.setBounds(304, 395, 135, 165);
		RicercaClientiButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		RicercaClientiButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(RicercaClientiButton);
		
		JButton AcquistiButton = new JButton("<html><center>Visualizza<br>Acquisti</center></html>");
		AcquistiButton.setContentAreaFilled(false);
		AcquistiButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/visualizzacquisto.png")));
		AcquistiButton.setFont(new Font("Georgia", Font.BOLD, 15));
		AcquistiButton.setForeground(new Color(178, 34, 34));
		AcquistiButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		AcquistiButton.setBackground(new Color(153, 51, 51));
		AcquistiButton.setBounds(466, 395, 135, 165);
		AcquistiButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		AcquistiButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(AcquistiButton);
		
		JButton FornitureButton = new JButton("<html><center>Visualizza<br>Forniture</center></html>");
		FornitureButton.setContentAreaFilled(false);
		FornitureButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/visualizzaforniture.png")));
		FornitureButton.setFont(new Font("Georgia", Font.BOLD, 15));
		FornitureButton.setForeground(new Color(178, 34, 34));
		FornitureButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		FornitureButton.setBackground(new Color(153, 51, 51));
		FornitureButton.setBounds(626, 395, 135, 165);
		FornitureButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		FornitureButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(FornitureButton);
		
		JButton RifornimentoButton = new JButton("<html><center>Rifornisci<br>Negozio</center></html>");
		RifornimentoButton.setContentAreaFilled(false);
		RifornimentoButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/rifornimento.png")));
		RifornimentoButton.setFont(new Font("Georgia", Font.BOLD, 15));
		RifornimentoButton.setForeground(new Color(178, 34, 34));
		RifornimentoButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		RifornimentoButton.setBackground(new Color(153, 51, 51));
		RifornimentoButton.setBounds(304, 199, 135, 165);
		RifornimentoButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		RifornimentoButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(RifornimentoButton);
		
		JButton NuovoAcquistoButton = new JButton("<html><center>Effettua<br>Acquisto</center></html>");
		NuovoAcquistoButton.setContentAreaFilled(false);
		NuovoAcquistoButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/acquisto.png")));
		NuovoAcquistoButton.setFont(new Font("Georgia", Font.BOLD, 15));
		NuovoAcquistoButton.setForeground(new Color(178, 34, 34));
		NuovoAcquistoButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		NuovoAcquistoButton.setBackground(new Color(153, 51, 51));
		NuovoAcquistoButton.setBounds(626, 199, 135, 165);
		NuovoAcquistoButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		NuovoAcquistoButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(NuovoAcquistoButton);
		
		JButton NuovaFornituraButton = new JButton("<html><center>Nuova<br>Fornitura</center></html>");
		NuovaFornituraButton.setContentAreaFilled(false);
		NuovaFornituraButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		NuovaFornituraButton.setBackground(new Color(178, 34, 34));
		NuovaFornituraButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		NuovaFornituraButton.setForeground(new Color(178, 34, 34));
		NuovaFornituraButton.setFont(new Font("Georgia", Font.BOLD, 15));
		NuovaFornituraButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/piu.png")));
		NuovaFornituraButton.setBounds(466, 199, 135, 165);
		NuovaFornituraButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		NuovaFornituraButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(NuovaFornituraButton);
	}
}
