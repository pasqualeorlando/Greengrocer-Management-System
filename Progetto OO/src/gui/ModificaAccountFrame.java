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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SpringLayout;

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
		setBounds(100, 100, 500, 240);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel mailAttualeLabel = new JLabel("Mail attuale: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, mailAttualeLabel, 53, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, mailAttualeLabel, 46, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, mailAttualeLabel, 153, SpringLayout.WEST, contentPane);
		mailAttualeLabel.setForeground(new Color(204, 204, 102));
		mailAttualeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		mailAttualeLabel.setFont(new Font("Georgia", Font.BOLD, 15));
		contentPane.add(mailAttualeLabel);
		
		JLabel nuovaMailLabel = new JLabel("Nuova mail: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, nuovaMailLabel, 82, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, nuovaMailLabel, 46, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, nuovaMailLabel, 153, SpringLayout.WEST, contentPane);
		nuovaMailLabel.setForeground(new Color(204, 204, 102));
		nuovaMailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nuovaMailLabel.setFont(new Font("Georgia", Font.BOLD, 15));
		contentPane.add(nuovaMailLabel);
		
		mailAttualeTF = new JTextField(p.getEmail());
		sl_contentPane.putConstraint(SpringLayout.NORTH, mailAttualeTF, 45, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, mailAttualeTF, 163, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, mailAttualeTF, 72, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, mailAttualeTF, 443, SpringLayout.WEST, contentPane);
		mailAttualeTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		mailAttualeTF.setEditable(false);
		contentPane.add(mailAttualeTF);
		mailAttualeTF.setColumns(10);
		
		nuovaMailTF = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, nuovaMailTF, 82, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, nuovaMailTF, 163, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, nuovaMailTF, 109, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, nuovaMailTF, 443, SpringLayout.WEST, contentPane);
		nuovaMailTF.setFont(new Font("Georgia", Font.PLAIN, 14));
		contentPane.add(nuovaMailTF);
		nuovaMailTF.setColumns(10);
		
		JButton annullaButton = new JButton("Annulla");
		sl_contentPane.putConstraint(SpringLayout.NORTH, annullaButton, 147, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, annullaButton, 46, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, annullaButton, 182, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, annullaButton, 153, SpringLayout.WEST, contentPane);
		annullaButton.setForeground(new Color(204, 204, 102));
		annullaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiHomepage(attuale, committente);
			}
		});
		annullaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		annullaButton.setContentAreaFilled(false);
		annullaButton.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(annullaButton);
		
		JButton salvaButton = new JButton("Salva");
		sl_contentPane.putConstraint(SpringLayout.NORTH, salvaButton, 147, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, salvaButton, 336, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, salvaButton, 182, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, salvaButton, 443, SpringLayout.WEST, contentPane);
		salvaButton.setForeground(new Color(204, 204, 102));
		salvaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.salvaNuovaMail(nuovaMailTF.getText(), p, committente);
			}
		});
		salvaButton.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		salvaButton.setContentAreaFilled(false);
		salvaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		contentPane.add(salvaButton);
		
		JLabel lblNewLabel = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 120, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 210, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 182, SpringLayout.NORTH, contentPane);
		lblNewLabel.setIcon(new ImageIcon(ModificaAccountFrame.class.getResource("/immagini/melone.png")));
		contentPane.add(lblNewLabel);
	}
}
