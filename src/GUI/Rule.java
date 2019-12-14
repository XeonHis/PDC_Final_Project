package GUI;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

/**
 * @author paulalan
 * @create 2019/12/14 10:43
 */
public class Rule extends JPanel
{
	private welcomePage main = welcomePage.getInstance();
	public Rule(String currentUserName)
	{
		setLayout(null);
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);


		JLabel Rule = new JLabel("Rule", JLabel.CENTER);
//		Rule.setFont(f1);
		Rule.setBounds(0, 50, 800, 50);
		// 规则显示
		JTextArea RuleDisplay = new JTextArea();
		RuleDisplay.setEditable(false);
		RuleDisplay.setLineWrap(true);
		RuleDisplay.setWrapStyleWord(true);
//		RuleDisplay.setFont(f2);
		RuleDisplay.setBounds(100, 110, 600, 350);
		RuleDisplay.setText("每次挑战共10题，其中1-5道为单选题，6-10道为多选题。");

		// 返回按钮
		JButton Return = new JButton("Return");
//		Return.setFont(f2);
		Return.setBounds(650, 480, 100, 60);

		// bottom
		watermark.setBounds(0, 540, 800, 20);
//		watermark.setFont(f2);

		add(Rule);
		add(RuleDisplay);
		add(Return);
		add(watermark);

		// 监听
		Return.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// 历史记录
				try
				{
					main.setTitle("IT Dictionary!");
					main.getContentPane().removeAll();
					mainEnter mainEnter=new mainEnter(currentUserName);
					main.setContentPane(mainEnter);
					mainEnter.setVisible(false);
					mainEnter.setVisible(true);
				} catch (SQLException ex)
				{
					ex.printStackTrace();
				}
			}
		});
	}
}
