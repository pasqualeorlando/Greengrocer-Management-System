package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

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
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLab = new JLabel("Username:");
		usernameLab.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLab.setFont(new Font("Georgia", Font.BOLD, 17));
		usernameLab.setBounds(95, 192, 128, 30);
		contentPane.add(usernameLab);
		
		JLabel passwordLab = new JLabel("Password :");
		passwordLab.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLab.setFont(new Font("Georgia", Font.BOLD, 17));
		passwordLab.setBounds(95, 232, 128, 30);
		contentPane.add(passwordLab);
		
		usernameTF = new JTextField();
		usernameTF.setFont(new Font("Georgia", Font.PLAIN, 17));
		usernameTF.setBounds(239, 192, 239, 30);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		
		passPF = new JPasswordField();
		passPF.setFont(new Font("Georgia", Font.PLAIN, 17));
		passPF.setBounds(239, 232, 239, 30);
		contentPane.add(passPF);
		
		JButton entra = new JButton("Entra");
		entra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.validaCredenziali(usernameTF.getText(), passPF.getText());
			}
		});
		entra.setForeground(new Color(178, 34, 34));
		entra.setFont(new Font("Georgia", Font.PLAIN, 16));
		entra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		entra.setBorderPainted(false);
		entra.setBackground(new Color(255, 255, 255));
		entra.setBounds(453, 309, 116, 38);
		contentPane.add(entra);
		
		JLabel foto = new JLabel("");
		foto.setIcon(new ImageIcon(LoginFrame.class.getResource("/immagini/profile.png")));
		foto.setBounds(233, 30, 128, 128);
		contentPane.add(foto);
	}
}
