package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Persona;
import Controller.Controller;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class VisualizzaFornitureFrame extends JFrame {

	private JPanel contentPane;
	private JTable fornitureTab;
	private Controller controller;
	private JTextField dataInizioTF;
	private JTextField dataFineTF;
	private JButton indietroButton;
	
	public VisualizzaFornitureFrame(Controller c, Persona p) {
		controller = c;
		JFrame attuale = this;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizzaFornitureFrame.class.getResource("/immagini/fruits.png")));
		setTitle("OrtofruttaPerTutti - Forniture");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(109, 74, 530, 320);
		contentPane.add(scrollPane);
		
		fornitureTab = new JTable();
		fornitureTab.setModel(new DefaultTableModel(
			controller.getForniture("", "").toArray(new Object[controller.getForniture("", "").size()][]),
			new String[] {
					"Fornitore", "Data fornitura", "Prezzo", "Quantit�", "Nome prodotto"
			}
		));
		fornitureTab.setDefaultEditor(Object.class, null);			//permette di non modificare le celle nella tabella
		fornitureTab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(fornitureTab);		
		
		JLabel visualizzaFornitureLabel = new JLabel("Visualizza forniture dal:");
		visualizzaFornitureLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		visualizzaFornitureLabel.setBounds(117, 42, 190, 18);
		contentPane.add(visualizzaFornitureLabel);
		
		dataInizioTF = new JTextField();
		dataInizioTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		dataInizioTF.setBounds(305, 43, 96, 18);
		contentPane.add(dataInizioTF);
		dataInizioTF.setColumns(10);
		
		JLabel alLabel = new JLabel("al:");
		alLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
		alLabel.setBounds(406, 42, 31, 18);
		contentPane.add(alLabel);
		
		dataFineTF = new JTextField();
		dataFineTF.setFont(new Font("Georgia", Font.PLAIN, 15));
		dataFineTF.setColumns(10);
		dataFineTF.setBounds(431, 43, 96, 18);
		contentPane.add(dataFineTF);
		
		indietroButton = new JButton("Indietro");
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
		indietroButton.setBounds(36, 428, 101, 42);
		contentPane.add(indietroButton);
		
		JButton ResetButton = new JButton("Reset");
		ResetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fornitureTab.setModel(new DefaultTableModel(
						controller.getForniture("", "").toArray(new Object[controller.getForniture("", "").size()][]),
						new String[] {
								"Fornitore", "Data fornitura", "Prezzo", "Quantit�", "Nome prodotto"
						}
				));
				dataInizioTF.setText("");
				dataFineTF.setText("");
			}
		});
		ResetButton.setForeground(Color.BLACK);
		ResetButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		ResetButton.setContentAreaFilled(false);
		ResetButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		ResetButton.setBounds(641, 428, 101, 42);
		contentPane.add(ResetButton);
		
		JButton btnCerca = new JButton("Cerca");
		btnCerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fornitureTab.setModel(new DefaultTableModel(
						controller.getForniture(dataInizioTF.getText(), dataFineTF.getText()).toArray(new Object[controller.getForniture(dataInizioTF.getText(), dataFineTF.getText()).size()][]),
						new String[] {
								"Fornitore", "Data fornitura", "Prezzo", "Quantit�", "Nome prodotto"
						}
				));
			}
		});
		btnCerca.setForeground(Color.BLACK);
		btnCerca.setFont(new Font("Georgia", Font.ITALIC, 15));
		btnCerca.setContentAreaFilled(false);
		btnCerca.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		btnCerca.setBounds(540, 40, 78, 24);
		contentPane.add(btnCerca);
		
	}
}