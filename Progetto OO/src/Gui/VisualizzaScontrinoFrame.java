package Gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Classi.Persona;
import Controller.Controller;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VisualizzaScontrinoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;

	
	public VisualizzaScontrinoFrame(Controller c, Persona p, int idAcquisto, float pagato, float resto) {
		controller = c;
		JFrame attuale = this;
		
		setTitle("OrtofruttaPerTutti - Scontrino");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzaScontrinoFrame.class.getResource("/immagini/fruits.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 749);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*JLabel scontrinoLabel = new JLabel(controller.generaScontrino(idAcquisto));
		scontrinoLabel.setVerticalAlignment(SwingConstants.TOP);
		scontrinoLabel.setBounds(10, 10, 426, 623);
		contentPane.add(scontrinoLabel);*/
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(null);
		textPane.setEditable(false);
		textPane.setContentType("text/html");
		textPane.setText(controller.generaScontrino(idAcquisto, pagato, resto));
		textPane.setBounds(10, 10, 426, 623);
		JScrollPane scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 10, 441, 623);
		contentPane.add(scrollPane);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiHomepage(attuale, p);
			}
		});
		btnIndietro.setForeground(Color.BLACK);
		btnIndietro.setFont(new Font("Georgia", Font.ITALIC, 15));
		btnIndietro.setContentAreaFilled(false);
		btnIndietro.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));
		btnIndietro.setBounds(10, 669, 101, 42);
		contentPane.add(btnIndietro);
	}
}
