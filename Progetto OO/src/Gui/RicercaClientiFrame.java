package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Persona;
import Controller.Controller;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RicercaClientiFrame extends JFrame {

	private Controller controller;
	private JPanel contentPane;
	private JTable clientiTab;
	

	public RicercaClientiFrame(Controller c, Persona p) {
		controller = c; 
		JFrame attuale = this; 
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RicercaClientiFrame.class.getResource("/immagini/fruits.png")));
		setTitle("OrtofruttaPerTutti - Ricerca Clienti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ricercaClienteLabel = new JLabel("Ricerca cliente per: ");
		ricercaClienteLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		ricercaClienteLabel.setBounds(162, 28, 164, 18);
		contentPane.add(ricercaClienteLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Georgia", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tipologia prodotto", "Punti "}));
		comboBox.setBounds(321, 25, 160, 25);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(22, 72, 316, 255);
		contentPane.add(scrollPane);
		
		JButton indietroButton = new JButton("Indietro");
		indietroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiHomepage(attuale, p);
			}
		});
		indietroButton.setForeground(Color.BLACK);
		indietroButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		indietroButton.setContentAreaFilled(false);
		indietroButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		indietroButton.setBounds(553, 348, 101, 42);
		contentPane.add(indietroButton);
		
		
	}
}
