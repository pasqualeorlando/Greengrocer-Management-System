package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;

import controller.Controller;
import javax.swing.SpringLayout;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTF;
	private JPasswordField passPF;
	private Controller controller;

	/**
	 * Create the frame.
	 */
	public LoginFrame(Controller c) {
		controller = c;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/immagini/fruits.png")));
		setTitle("OrtofruttaPerTutti - Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 511);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.setBackground(new Color(0, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(100, 233, 128, 30);
		usernameLabel.setForeground(new Color(255, 255, 255));
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setFont(new Font("Georgia", Font.BOLD, 17));
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password :");
		passwordLabel.setBounds(100, 273, 128, 30);
		passwordLabel.setForeground(new Color(255, 255, 255));
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setFont(new Font("Georgia", Font.BOLD, 17));
		contentPane.add(passwordLabel);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(244, 233, 239, 30);
		usernameTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					controller.validaCredenziali(usernameTF.getText(), passPF.getText());

			}
		});
		usernameTF.setFont(new Font("Georgia", Font.PLAIN, 17));
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		
		passPF = new JPasswordField();
		passPF.setBounds(244, 273, 239, 30);
		passPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					controller.validaCredenziali(usernameTF.getText(), passPF.getText());
			}
		});
		passPF.setFont(new Font("Georgia", Font.PLAIN, 17));
		contentPane.add(passPF);
		
		JButton entraButton = new JButton("Entra");
		entraButton.setBounds(255, 326, 101, 38);
		entraButton.setContentAreaFilled(false);
		entraButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		entraButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.validaCredenziali(usernameTF.getText(), passPF.getText());
			}
		});
		entraButton.setForeground(Color.WHITE);
		entraButton.setFont(new Font("Georgia", Font.ITALIC, 16));
		entraButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		entraButton.setBackground(new Color(255, 255, 255));
		contentPane.add(entraButton);
		
		JLabel foto = new JLabel("");
		foto.setBounds(244, 72, 128, 128);
		foto.setIcon(new ImageIcon(LoginFrame.class.getResource("/immagini/profile.png")));
		contentPane.add(foto);
		
		JLabel titoloLabel = new JLabel("");
		titoloLabel.setBounds(54, 16, 497, 51);
		titoloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titoloLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/immagini/logo login.png")));
		contentPane.add(titoloLabel);
		
		JLabel corniceSxLabel = new JLabel("");
		corniceSxLabel.setBounds(-62, 392, 390, 128);
		corniceSxLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/immagini/boh.png")));
		contentPane.add(corniceSxLabel);
		
		JLabel corniceDxLabel = new JLabel("");
		corniceDxLabel.setBounds(241, 291, 431, 248);
		corniceDxLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/immagini/frutta.png")));
		contentPane.add(corniceDxLabel);
	}
}
