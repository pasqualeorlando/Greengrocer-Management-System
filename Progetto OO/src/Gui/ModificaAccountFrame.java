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
	private JTextField MailAttualeTF;
	private JTextField NuovaMailTF;
	private Controller controller;

	

	
	public ModificaAccountFrame(Controller c, Persona p) {
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
		
		JLabel MailAttualeLabel = new JLabel("Mail attuale: ");
		MailAttualeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		MailAttualeLabel.setFont(new Font("Georgia", Font.BOLD, 15));
		MailAttualeLabel.setBounds(68, 55, 107, 18);
		contentPane.add(MailAttualeLabel);
		
		JLabel NuovaMailLabel = new JLabel("Nuova mail: ");
		NuovaMailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		NuovaMailLabel.setFont(new Font("Georgia", Font.BOLD, 15));
		NuovaMailLabel.setBounds(68, 84, 107, 18);
		contentPane.add(NuovaMailLabel);
		
		MailAttualeTF = new JTextField(p.getEmail());
		MailAttualeTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		MailAttualeTF.setEditable(false);
		MailAttualeTF.setBounds(185, 47, 280, 27);
		contentPane.add(MailAttualeTF);
		MailAttualeTF.setColumns(10);
		
		NuovaMailTF = new JTextField();
		NuovaMailTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		NuovaMailTF.setBounds(185, 84, 280, 27);
		contentPane.add(NuovaMailTF);
		NuovaMailTF.setColumns(10);
		
		JButton AnnullaButton = new JButton("Annulla");
		AnnullaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiHomepage(attuale, p);
			}
		});
		AnnullaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		AnnullaButton.setContentAreaFilled(false);
		AnnullaButton.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		AnnullaButton.setBounds(68, 149, 107, 35);
		contentPane.add(AnnullaButton);
		
		JButton SalvaButton = new JButton("Salva");
		SalvaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.salvaNuovaMail(NuovaMailTF.getText(), p);
			}
		});
		SalvaButton.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		SalvaButton.setContentAreaFilled(false);
		SalvaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		SalvaButton.setBounds(314, 149, 107, 35);
		contentPane.add(SalvaButton);
	}
}
