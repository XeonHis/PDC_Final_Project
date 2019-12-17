package mvc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * @author paulalan
 * @create 2019/12/17 17:03
 */
public class itDicView extends JFrame implements Observer
{
	JButton loginButton;
	JButton registerButton;

	public itDicView() throws HeadlessException
	{
		getContentPane().removeAll();

		JPanel mainContainer = new JPanel(null);
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);
		watermark.setBounds(0, 540, 800, 20);

		JLabel welcomeLabel =
				new JLabel("Welcome to Happy Dictionary", JLabel.CENTER);
		welcomeLabel.setBounds(0, 150, 800, 150);

		loginButton = new JButton("Log in");
		registerButton = new JButton("Register");
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
	}

	public void setController(ActionListener ctrl)
	{
		loginButton.addActionListener(ctrl);
		registerButton.addActionListener(ctrl);
	}

	@Override
	public void update(Observable observable, Object o)
	{

	}
}
