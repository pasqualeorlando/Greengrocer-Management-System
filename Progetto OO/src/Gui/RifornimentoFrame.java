package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import Classi.Persona;
import Classi.Prodotto;
import Controller.Controller;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RifornimentoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;

	public RifornimentoFrame(Controller c, Prodotto p, Persona committente) {
		setResizable(false);
		controller = c;
		JFrame attuale = this;
		
		setTitle("OrtofruttaPerTutti - Rifornimento");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RifornimentoFrame.class.getResource("/immagini/fruits.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel quantitaNegozioLabel = new JLabel("Quantit\u00E0 Negozio: " + p.getQuantitaNegozio());
		quantitaNegozioLabel.setHorizontalAlignment(SwingConstants.LEFT);
		quantitaNegozioLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		quantitaNegozioLabel.setBounds(55, 69, 327, 17);
		contentPane.add(quantitaNegozioLabel);
		
		JLabel quantitaDepositoLabel = new JLabel("Quantit\u00E0 Deposito: " + p.getQuantitaDeposito());
		quantitaDepositoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		quantitaDepositoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		quantitaDepositoLabel.setBounds(55, 106, 354, 17);
		contentPane.add(quantitaDepositoLabel);
		
		JSpinner rifornimentoSpinner = new JSpinner();
		rifornimentoSpinner.setModel(new SpinnerNumberModel(0.0, 0.0, p.getQuantitaDeposito(), 0.01));
		rifornimentoSpinner.setFont(new Font("Georgia", Font.PLAIN, 16));
		rifornimentoSpinner.setBounds(187, 142, 53, 28);
		contentPane.add(rifornimentoSpinner);
		
		JButton salvaButton = new JButton("Salva");
		salvaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.rifornisciProdotto(p, (double)rifornimentoSpinner.getValue(), committente);
			}
		});
		salvaButton.setForeground(Color.BLACK);
		salvaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		salvaButton.setEnabled(true);
		salvaButton.setContentAreaFilled(false);
		salvaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		salvaButton.setBounds(269, 208, 101, 42);
		contentPane.add(salvaButton);
		
		JButton annullaButton = new JButton("Annulla");
		annullaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiProdotti(committente, attuale);
			}
		});
		annullaButton.setForeground(Color.BLACK);
		annullaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		annullaButton.setContentAreaFilled(false);
		annullaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		annullaButton.setBounds(39, 208, 101, 42);
		contentPane.add(annullaButton);
		
		JLabel rifornimentoLabel = new JLabel("Rifornimento: ");
		rifornimentoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rifornimentoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		rifornimentoLabel.setBounds(55, 147, 122, 17);
		contentPane.add(rifornimentoLabel);
		
		JLabel modificaQuantitaLabel = new JLabel("Modifica quantit\u00E0 per " + p.getNome());
		modificaQuantitaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		modificaQuantitaLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		modificaQuantitaLabel.setBounds(10, 21, 414, 37);
		contentPane.add(modificaQuantitaLabel);
		
	}
}
