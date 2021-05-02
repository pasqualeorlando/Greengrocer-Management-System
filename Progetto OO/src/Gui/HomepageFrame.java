package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
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
		JFrame attuale = this;
		
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
		
		JLabel salutoLabel = new JLabel("Ciao " + p.getNome() + "!");
		salutoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salutoLabel.setForeground(new Color(255, 255, 255));
		salutoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 25));
		salutoLabel.setBounds(21, 60, 225, 54);
		panel.add(salutoLabel);
		
		JLabel nomeLabel = new JLabel("Nome: " + p.getNome());
		nomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nomeLabel.setForeground(new Color(255, 255, 255));
		nomeLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		nomeLabel.setBounds(10, 221, 225, 21);
		panel.add(nomeLabel);
		
		JLabel cognomeLabel = new JLabel("Cognome: " + p.getCognome());
		cognomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cognomeLabel.setForeground(Color.WHITE);
		cognomeLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		cognomeLabel.setBounds(10, 266, 225, 21);
		panel.add(cognomeLabel);
		
		JLabel ruoloLabel = new JLabel("Ruolo: " + p.getRuolo());
		ruoloLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ruoloLabel.setForeground(Color.WHITE);
		ruoloLabel.setFont(new Font("Georgia", Font.PLAIN, 18));
		ruoloLabel.setBounds(10, 313, 225, 21);
		panel.add(ruoloLabel);
		
		JButton esciButton = new JButton("Esci");
		esciButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.exit();
			}
		});
		esciButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		esciButton.setContentAreaFilled(false);
		esciButton.setForeground(new Color(255, 255, 255));
		esciButton.setFont(new Font("Georgia", Font.PLAIN, 17));
		esciButton.setBounds(170, 520, 89, 40);
		panel.add(esciButton);
		
		JButton modificaAccButton = new JButton("<html><center>Modifica<br>Account</center></html>");
		modificaAccButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiModificaAccount(attuale, p, p.getCF());
			}
		});
		modificaAccButton.setForeground(Color.WHITE);
		modificaAccButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		modificaAccButton.setContentAreaFilled(false);
		modificaAccButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		modificaAccButton.setBounds(10, 520, 125, 40);
		panel.add(modificaAccButton);
		
		JButton personaleButton = new JButton("Personale");
		personaleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiPersonale(p);
			}
		});
		personaleButton.setContentAreaFilled(false);
		personaleButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/personale.png")));
		personaleButton.setFont(new Font("Georgia", Font.BOLD, 15));
		personaleButton.setForeground(new Color(178, 34, 34));
		personaleButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		personaleButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		personaleButton.setBackground(new Color(178, 34, 34));
		personaleButton.setBounds(304, 11, 135, 165);
		personaleButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		personaleButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(personaleButton);
		
		JButton clientiButton = new JButton("Clienti");
		clientiButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.vaiClienti(p);
			}
		});
		clientiButton.setContentAreaFilled(false);
		clientiButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/clienti.png")));
		clientiButton.setFont(new Font("Georgia", Font.BOLD, 15));
		clientiButton.setForeground(new Color(178, 34, 34));
		clientiButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		clientiButton.setBackground(new Color(178, 34, 34));
		clientiButton.setBounds(466, 11, 135, 165);
		clientiButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		clientiButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(clientiButton);
		
		JButton prodottiButton = new JButton("Prodotti");
		prodottiButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiProdotti(p, attuale);
			}
		});
		prodottiButton.setContentAreaFilled(false);
		prodottiButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/prodotti.png")));
		prodottiButton.setFont(new Font("Georgia", Font.BOLD, 15));
		prodottiButton.setForeground(new Color(178, 34, 34));
		prodottiButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		prodottiButton.setBackground(new Color(153, 51, 51));
		prodottiButton.setBounds(626, 11, 135, 165);
		prodottiButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		prodottiButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(prodottiButton);
		
		JButton ricercaClientiButton = new JButton("<html><center>Ricerca<br>Clienti</center></html>");
		ricercaClientiButton.setContentAreaFilled(false);
		ricercaClientiButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/ricercaclienti.png")));
		ricercaClientiButton.setFont(new Font("Georgia", Font.BOLD, 15));
		ricercaClientiButton.setForeground(new Color(178, 34, 34));
		ricercaClientiButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		ricercaClientiButton.setBackground(new Color(153, 51, 51));
		ricercaClientiButton.setBounds(304, 395, 135, 165);
		ricercaClientiButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		ricercaClientiButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(ricercaClientiButton);
		
		JButton acquistiButton = new JButton("<html><center>Visualizza<br>Acquisti</center></html>");
		acquistiButton.setContentAreaFilled(false);
		acquistiButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/visualizzacquisto.png")));
		acquistiButton.setFont(new Font("Georgia", Font.BOLD, 15));
		acquistiButton.setForeground(new Color(178, 34, 34));
		acquistiButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		acquistiButton.setBackground(new Color(153, 51, 51));
		acquistiButton.setBounds(466, 395, 135, 165);
		acquistiButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		acquistiButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(acquistiButton);
		
		JButton fornitureButton = new JButton("<html><center>Visualizza<br>Forniture</center></html>");
		fornitureButton.setContentAreaFilled(false);
		fornitureButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/visualizzaforniture.png")));
		fornitureButton.setFont(new Font("Georgia", Font.BOLD, 15));
		fornitureButton.setForeground(new Color(178, 34, 34));
		fornitureButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		fornitureButton.setBackground(new Color(153, 51, 51));
		fornitureButton.setBounds(626, 395, 135, 165);
		fornitureButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		fornitureButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(fornitureButton);
		
		JButton nuovoAcquistoButton = new JButton("<html><center>Effettua<br>Acquisto</center></html>");
		nuovoAcquistoButton.setContentAreaFilled(false);
		nuovoAcquistoButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/acquisto.png")));
		nuovoAcquistoButton.setFont(new Font("Georgia", Font.BOLD, 15));
		nuovoAcquistoButton.setForeground(new Color(178, 34, 34));
		nuovoAcquistoButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		nuovoAcquistoButton.setBackground(new Color(153, 51, 51));
		nuovoAcquistoButton.setBounds(626, 199, 135, 165);
		nuovoAcquistoButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		nuovoAcquistoButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(nuovoAcquistoButton);
		
		JButton nuovaFornituraButton = new JButton("<html><center>Nuova<br>Fornitura</center></html>");
		nuovaFornituraButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiNuovaFornitura(p);
			}
		});
		nuovaFornituraButton.setContentAreaFilled(false);
		nuovaFornituraButton.setBackground(new Color(178, 34, 34));
		nuovaFornituraButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		nuovaFornituraButton.setForeground(new Color(178, 34, 34));
		nuovaFornituraButton.setFont(new Font("Georgia", Font.BOLD, 15));
		nuovaFornituraButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/piu.png")));
		nuovaFornituraButton.setBounds(466, 199, 135, 165);
		nuovaFornituraButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		nuovaFornituraButton.setHorizontalTextPosition(SwingConstants.CENTER);
		contentPane.add(nuovaFornituraButton);
		
		JButton NuovoFornitoreButton = new JButton("<html><center>Nuovo<br>Fornitore</center></html>");
		NuovoFornitoreButton.setIcon(new ImageIcon(HomepageFrame.class.getResource("/immagini/inventario.png")));
		NuovoFornitoreButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		NuovoFornitoreButton.setHorizontalTextPosition(SwingConstants.CENTER);
		NuovoFornitoreButton.setForeground(new Color(178, 34, 34));
		NuovoFornitoreButton.setFont(new Font("Georgia", Font.BOLD, 15));
		NuovoFornitoreButton.setContentAreaFilled(false);
		NuovoFornitoreButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
		NuovoFornitoreButton.setBackground(new Color(178, 34, 34));
		NuovoFornitoreButton.setBounds(304, 199, 135, 165);
		contentPane.add(NuovoFornitoreButton);
	}
}
