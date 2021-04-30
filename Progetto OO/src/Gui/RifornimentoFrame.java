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
		
		JLabel QuantitaNegozioLabel = new JLabel("Quantit\u00E0 Negozio: " + p.getQuantitaNegozio());
		QuantitaNegozioLabel.setHorizontalAlignment(SwingConstants.LEFT);
		QuantitaNegozioLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		QuantitaNegozioLabel.setBounds(55, 69, 327, 17);
		contentPane.add(QuantitaNegozioLabel);
		
		JLabel QuantitaDepositoLabel = new JLabel("Quantit\u00E0 Deposito: " + p.getQuantitaDeposito());
		QuantitaDepositoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		QuantitaDepositoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		QuantitaDepositoLabel.setBounds(55, 106, 354, 17);
		contentPane.add(QuantitaDepositoLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0.0, 0.0, p.getQuantitaDeposito(), 0.01));
		spinner.setFont(new Font("Georgia", Font.PLAIN, 16));
		spinner.setBounds(187, 142, 53, 28);
		contentPane.add(spinner);
		
		JButton SalvaButton = new JButton("Salva");
		SalvaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.rifornisciProdotto(p, (double)spinner.getValue(), committente);
			}
		});
		SalvaButton.setForeground(Color.BLACK);
		SalvaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		SalvaButton.setEnabled(true);
		SalvaButton.setContentAreaFilled(false);
		SalvaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		SalvaButton.setBounds(269, 208, 101, 42);
		contentPane.add(SalvaButton);
		
		JButton AnnullaButton = new JButton("Annulla");
		AnnullaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.vaiProdotti(committente, attuale);
			}
		});
		AnnullaButton.setForeground(Color.BLACK);
		AnnullaButton.setFont(new Font("Georgia", Font.ITALIC, 15));
		AnnullaButton.setContentAreaFilled(false);
		AnnullaButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		AnnullaButton.setBounds(39, 208, 101, 42);
		contentPane.add(AnnullaButton);
		
		JLabel RifornimentoLabel = new JLabel("Rifornimento: ");
		RifornimentoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		RifornimentoLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		RifornimentoLabel.setBounds(55, 147, 122, 17);
		contentPane.add(RifornimentoLabel);
		
		JLabel lblModificaQuantitPer = new JLabel("Modifica quantit\u00E0 per " + p.getNome());
		lblModificaQuantitPer.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificaQuantitPer.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 16));
		lblModificaQuantitPer.setBounds(10, 21, 414, 37);
		contentPane.add(lblModificaQuantitPer);
		
	}
}
