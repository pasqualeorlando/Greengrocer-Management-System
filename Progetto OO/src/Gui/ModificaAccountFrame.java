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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import Classi.Persona;
import Controller.Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificaAccountFrame extends JFrame {

	private JPanel contentPane;
	private JTextField mailAttualeTF;
	private JTextField nuovaMailTF;
	private Controller controller;

	

	
	public ModificaAccountFrame(Controller c, Persona p, Persona committente) {
		controller = c;
		JFrame attuale = this;
		
		setResizable(false);
		setTitle("OrtofruttaPerTutti - Modifica Account");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificaAccountFrame.class.getResource("/immagini/fruits.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 224);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mailAttualeLabel = new JLabel("Mail attuale: ");
		mailAttualeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mailAttualeLabel.setFont(new Font("Georgia", Font.BOLD, 15));
		mailAttualeLabel.setBounds(68, 55, 107, 18);
		contentPane.add(mailAttualeLabel);
		
		JLabel nuovaMailLabel = new JLabel("Nuova mail: ");
		nuovaMailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nuovaMailLabel.setFont(new Font("Georgia", Font.BOLD, 15));
		nuovaMailLabel.setBounds(68, 84, 107, 18);
		contentPane.add(nuovaMailLabel);
		
		mailAttualeTF = new JTextField(p.getEmail());
		mailAttualeTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		mailAttualeTF.setEditable(false);
		mailAttualeTF.setBounds(185, 47, 280, 27);
		contentPane.add(mailAttualeTF);
		mailAttualeTF.setColumns(10);
		
		nuovaMailTF = new JTextField();
		nuovaMailTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		nuovaMailTF.setBounds(185, 84, 280, 27);
		contentPane.add(nuovaMailTF);
		nuovaMailTF.setColumns(10);
		
		JButton annullaButton = new JButton("Annulla");
		annullaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiHomepage(attuale, committente);
			}
		});
		annullaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		annullaButton.setContentAreaFilled(false);
		annullaButton.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		annullaButton.setBounds(68, 149, 107, 35);
		contentPane.add(annullaButton);
		
		JButton salvaButton = new JButton("Salva");
		salvaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.salvaNuovaMail(nuovaMailTF.getText(), p, committente);
			}
		});
		salvaButton.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		salvaButton.setContentAreaFilled(false);
		salvaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		salvaButton.setBounds(314, 149, 107, 35);
		contentPane.add(salvaButton);
	}
}
