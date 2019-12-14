package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

/**
 * @author paulalan
 * @create 2019/12/14 10:29
 */
public class mainEnter extends JPanel
{
	private welcomePage main = welcomePage.getInstance();


	public mainEnter(String currentUserName) throws SQLException
	{
		int id = main.getCommunication().getAccountDetail(currentUserName);
		setLayout(null);
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);
		JLabel AccountContent = new JLabel();


		// 账号
		JLabel Account = new JLabel("Account: " + id, JLabel.RIGHT);
		Account.setBounds(0, 0, 200, 100);
//		Account.setFont(f4);

		// 用户名
		JLabel Username = new JLabel("UserName: " + currentUserName, JLabel.RIGHT);
		Username.setBounds(400, 0, 200, 100);
//		Username.setFont(f4);
		// 用户名设置
		JLabel UserNameContent = new JLabel("", JLabel.LEFT);
		UserNameContent.setBounds(600, 0, 200, 100);
//		UserNameContent.setFont(f4);

		// 规则按钮
		JButton Rule = new JButton("Rule");
//		Rule.setFont(f1);
		Rule.setBounds(310, 100, 180, 75);

		// 历史按钮
		JButton History = new JButton("History");
		Font f3 = new Font("宋体", Font.BOLD, 26);
		History.setFont(f3);
		History.setBounds(325, 200, 150, 75);

		// 开始游戏按钮
		JButton Start = new JButton("Starting Game");
//		Start.setFont(f1);
		Start.setBounds(250, 300, 300, 75);

		add(Account);
		add(watermark);
		add(AccountContent);
		add(Username);
		add(UserNameContent);
		add(Rule);
		add(History);
		add(Start);


		// 监听
		Rule.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// 规则界面
				main.setTitle("IT Dictionary!");
				main.getContentPane().removeAll();
				Rule rule = new Rule(currentUserName);
				main.setContentPane(rule);
				rule.setVisible(true);
			}
		});
		History.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// 设置历史记录中时间和记录的值（调用数据库）
//				TimeRecord1 = new JLabel("", JLabel.CENTER);
//				ScoreRecord1 = new JLabel("", JLabel.CENTER);
//				TimeRecord2 = new JLabel("", JLabel.CENTER);
//				ScoreRecord2 = new JLabel("", JLabel.CENTER);
//				TimeRecord3 = new JLabel("", JLabel.CENTER);
//				ScoreRecord3 = new JLabel("", JLabel.CENTER);
//				TimeRecord4 = new JLabel("", JLabel.CENTER);
//				ScoreRecord4 = new JLabel("", JLabel.CENTER);
//				TimeRecord5 = new JLabel("", JLabel.CENTER);
//				ScoreRecord5 = new JLabel("", JLabel.CENTER);
				// 历史记录
//				GUI_History();
				main.setTitle("IT Dictionary!");
				main.getContentPane().removeAll();
				GUI.History historyPanel = new History(currentUserName);
				main.setContentPane(historyPanel);
				historyPanel.setVisible(false);
				historyPanel.setVisible(true);
			}
		});
		Start.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// 开始游戏
//				GUI_Question();
				main.setTitle("Question");
				main.getContentPane().removeAll();
				startQuestion startQuestion = null;
				try
				{
					startQuestion = new startQuestion(currentUserName);
					main.setContentPane(startQuestion);
					startQuestion.setVisible(false);
					startQuestion.setVisible(true);
				} catch (SQLException ex)
				{
					ex.printStackTrace();
				}

			}
		});
	}
}
