package gui;

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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import classi.Persona;
import controller.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class NuovoFornitoreFrame extends JFrame {

	private JPanel contentPane;
	private JTextField pIvaTF;
	private JTextField nomeSocietaTF;
	private JTextField nomeTitolareTF;
	private JTextField cognomeTitolareTF;
	private Controller controller;

	
	public NuovoFornitoreFrame(Controller c, Persona p) {
		setResizable(false);
		controller = c;
		JFrame attuale = this; 
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(NuovoFornitoreFrame.class.getResource("/immagini/fruits.png")));
		setTitle("OrtofruttaPerTutti - Nuovo Fornitore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nuovoFornitoreLabel = new JLabel("Inserimento nuovo fornitore:");
		nuovoFornitoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nuovoFornitoreLabel.setFont(new Font("Georgia", Font.BOLD, 17));
		nuovoFornitoreLabel.setBounds(76, 11, 271, 33);
		contentPane.add(nuovoFornitoreLabel);
		
		JLabel pIvaLabel = new JLabel("PIva:");
		pIvaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pIvaLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
		pIvaLabel.setBounds(10, 55, 130, 33);
		contentPane.add(pIvaLabel);
		
		JLabel nomeSocietaLabel = new JLabel("Nome Societ\u00E0:");
		nomeSocietaLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeSocietaLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
		nomeSocietaLabel.setBounds(10, 99, 130, 33);
		contentPane.add(nomeSocietaLabel);
		
		JLabel nomeTitolareLabel = new JLabel("Nome Titolare:");
		nomeTitolareLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nomeTitolareLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
		nomeTitolareLabel.setBounds(10, 143, 130, 33);
		contentPane.add(nomeTitolareLabel);
		
		JLabel cognomeTitolareLabel = new JLabel("Cognome Titolare:");
		cognomeTitolareLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cognomeTitolareLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
		cognomeTitolareLabel.setBounds(10, 187, 130, 33);
		contentPane.add(cognomeTitolareLabel);
		
		pIvaTF = new JTextField();
		pIvaTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		pIvaTF.setBounds(155, 59, 130, 27);
		contentPane.add(pIvaTF);
		pIvaTF.setColumns(10);
		
		nomeSocietaTF = new JTextField();
		nomeSocietaTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		nomeSocietaTF.setColumns(10);
		nomeSocietaTF.setBounds(155, 99, 130, 27);
		contentPane.add(nomeSocietaTF);
		
		nomeTitolareTF = new JTextField();
		nomeTitolareTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		nomeTitolareTF.setColumns(10);
		nomeTitolareTF.setBounds(155, 143, 130, 27);
		contentPane.add(nomeTitolareTF);
		
		cognomeTitolareTF = new JTextField();
		cognomeTitolareTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		cognomeTitolareTF.setColumns(10);
		cognomeTitolareTF.setBounds(155, 187, 130, 27);
		contentPane.add(cognomeTitolareTF);
		
		JButton annullaButton = new JButton("Annulla");
		annullaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiHomepage(attuale, p);
			}
		});
		annullaButton.setForeground(Color.BLACK);
		annullaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		annullaButton.setContentAreaFilled(false);
		annullaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		annullaButton.setBounds(33, 271, 101, 42);
		contentPane.add(annullaButton);
		
		JButton inserisciButton = new JButton("Inserisci");
		inserisciButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.inserisciFornitore(pIvaTF.getText(), nomeSocietaTF.getText(), nomeTitolareTF.getText(), cognomeTitolareTF.getText());
			}
		});
		inserisciButton.setForeground(Color.BLACK);
		inserisciButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		inserisciButton.setContentAreaFilled(false);
		inserisciButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		inserisciButton.setBounds(293, 271, 101, 42);
		contentPane.add(inserisciButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NuovoFornitoreFrame.class.getResource("/immagini/box.png")));
		lblNewLabel.setBounds(306, 73, 116, 129);
		contentPane.add(lblNewLabel);
	}
}
