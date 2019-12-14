package GUI;

import Communication.Communication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author paulalan
 * @create 2019/12/13 23:49
 */
public class welcomePage extends JFrame
{
	private static welcomePage instance;
	private Communication communication;

	public void setCommunication(Communication communication)
	{
		this.communication = communication;
	}

	public Communication getCommunication()
	{
		return communication;
	}

	public static welcomePage getInstance()
	{
		return instance;
	}

	public welcomePage() throws HeadlessException
	{
		instance = this;
		setCommunication(new Communication());
	}

	public static void main(String[] args)
	{
		welcomePage welcomePage = new welcomePage();
		welcomePage.welcomePage();
	}

	public void welcomePage()
	{
//		JFrame jf = new JFrame();

		getContentPane().removeAll();

		JPanel mainContainer = new JPanel(null);
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);
//		watermark.setSize(200,50);


		// welcomeLabel
		JLabel welcomeLabel =
				new JLabel("Welcome to Happy Dictionary", JLabel.CENTER);
		welcomeLabel.setBounds(0, 150, 800, 150);
//		welcomeLabel.setFont(f1);

		// watermark
		watermark.setBounds(0, 540, 800, 20);
//		watermark.setFont(f2);

		// botton
		JButton loginButton = new JButton("Log in");
		JButton registerButton = new JButton("Register");
		loginButton.setBounds(100, 350, 200, 100);
		registerButton.setBounds(500, 350, 200, 100);

		mainContainer.add(welcomeLabel);
		mainContainer.add(watermark);
		mainContainer.add(loginButton);
		mainContainer.add(registerButton);
		add(mainContainer);

		setVisible(true);
		setTitle("IT Dictionary!");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		loginButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				setTitle("Login");
				getContentPane().removeAll();
				Login login = new Login();
				setContentPane(login);
				login.setVisible(false);
				login.setVisible(true);
			}
		});
		registerButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
//				GUI_Register();
				setTitle("Register");
				getContentPane().removeAll();
				Register register=new Register();
				setContentPane(register);
				register.setVisible(false);
				register.setVisible(true);
			}
		});
	}
}
