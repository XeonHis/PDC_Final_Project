package GUI;

import Communication.Communication;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

/**
 * @author paulalan
 * @create 2019/12/14 11:09
 */
public class Register extends JPanel
{
	private welcomePage main = welcomePage.getInstance();
	private JTextField usernameInput;
	private JTextField passwordInput;
	JTextField confirmPasswordInput;

	public Register()
	{
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);

		// 标题
		setLayout(null);
		JLabel Register = new JLabel("Register:");
//		Register.setFont(f1);
		Register.setBounds(0, 0, 800, 100);

		// username
		JLabel UserName = new JLabel("*UserName:", JLabel.RIGHT);
		UserName.setBounds(0, 100, 400, 100);
//		UserName.setFont(f1);
		usernameInput = new JTextField();
		usernameInput.setBounds(400, 125, 300, 50);
//		Username_Input.setFont(f1);

		// password
		JLabel Password = new JLabel("*Password:", JLabel.RIGHT);
		Password.setBounds(0, 200, 400, 100);
//		Password.setFont(f1);
		passwordInput = new JTextField();
		passwordInput.setBounds(400, 225, 300, 50);
//		Password_Input.setFont(f1);

		// Confirm Password
		JLabel ConfirmPassword = new JLabel("*Confirm Password:", JLabel.RIGHT);
		ConfirmPassword.setBounds(0, 300, 400, 100);
//		ConfirmPassword.setFont(f1);
		confirmPasswordInput = new JTextField();
		confirmPasswordInput.setBounds(400, 325, 300, 50);
//		ConfirmPasswordInput.setFont(f1);

		// Button
		JButton button = new JButton("Register and Login");
		button.setBounds(200, 400, 400, 100);

		add(Register);
		add(watermark);
		add(UserName);
		add(usernameInput);
		add(Password);
		add(passwordInput);
		add(ConfirmPassword);
		add(confirmPasswordInput);
		add(button);


		// 监听
		button.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (check(usernameInput, passwordInput, confirmPasswordInput))
				{
					// 数据库保存用户名密码,并提供账号
					try
					{
						Communication temp = main.getCommunication();
						boolean registerFlag = temp.register(usernameInput.getText(), passwordInput.getText());
						if (registerFlag)
						{
							main.setTitle("IT Dictionary!");
							main.getContentPane().removeAll();
							mainEnter mainEnter = new mainEnter(usernameInput.getText());
							main.setContentPane(mainEnter);
							mainEnter.setVisible(false);
							mainEnter.setVisible(true);
						} else
						{
							JOptionPane.showMessageDialog(null,
									"Register fail!");
						}
					} catch (SQLException ex)
					{
						ex.printStackTrace();
					}

					// 系统分配账号：从1开始顺位，数据库保存并提供
//				AccountContent.setText("");
//				AccountContent.setBounds(200, 0, 200, 100);
					// 登陆
				} else
				{
					JOptionPane.showMessageDialog(null,
							"Register fail!");
				}
			}
		});
	}

	private boolean check(JTextField userName, JTextField pwd, JTextField pwdCfm)
	{
		if (!userName.getText().equals("") &&
				!pwd.getText().equals("") && !pwd.getText().equals(""))
		{
			return pwd.getText().equals(pwdCfm.getText());
		}
		return false;

	}
}
