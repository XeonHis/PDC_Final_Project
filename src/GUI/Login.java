package GUI;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

/**
 * @author paulalan
 * @create 2019/12/13 23:56
 */
public class Login extends JPanel
{
	private welcomePage main = welcomePage.getInstance();

	public Login()
	{
		setLayout(null);
		JTextField usernameInput;
		JTextField passwordInput;
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);
//		watermark.setSize(200,50);


		// top
		JLabel jLabel1 = new JLabel("Log in: ");
		jLabel1.setBounds(200, 0, 800, 100);
//		jLabel1.setFont(f1);

		// username
		JLabel Username = new JLabel("* Username:", JLabel.RIGHT);
		Username.setBounds(0, 100, 400, 100);
//		Username.setFont(f1);
		usernameInput = new JTextField();
		usernameInput.setBounds(400, 125, 300, 50);
//		usernameInput.setFont(f1);

		// password
		JLabel Password = new JLabel("* Password:", JLabel.RIGHT);
		Password.setBounds(0, 200, 400, 100);
//		Password.setFont(f1);
		passwordInput = new JTextField();
		passwordInput.setBounds(400, 225, 300, 50);
//		passwordInput.setFont(f1);

		// Login Button
		JButton Login = new JButton("Login");
		Login.setBounds(300, 350, 150, 80);
//		Login.setFont(f1);

		add(jLabel1);
		add(watermark);
		add(Username);
		add(usernameInput);
		add(Password);
		add(passwordInput);
		add(Login);


		// 监听
		Login.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// 数据库验证账号密码是否符合

				try
				{
					boolean loginFlag = main.getCommunication().login(
							usernameInput.getText(), passwordInput.getText());
					if (loginFlag)
					{
						main.setTitle("IT Dictionary!");
						main.getContentPane().removeAll();
						mainEnter mainEnter = new mainEnter();
						main.setContentPane(mainEnter);
						mainEnter.setVisible(false);
						mainEnter.setVisible(true);

					} else
					{
						JOptionPane.showMessageDialog(null,
								"Login fail");
						passwordInput.setText("");
					}
				} catch (SQLException ex)
				{
					ex.printStackTrace();
				}
				// 正确则登陆
//				GUI_Mine();


				// 密码错误提醒
				// JOptionPane.showMessageDialog(frame, "Wrong Password");

				// 用户名不存在提醒注册
				// JOptionPane.showMessageDialog(frame, "Register First");
			}
		});
	}

}
