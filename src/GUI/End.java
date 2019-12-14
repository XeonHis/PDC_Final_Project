package GUI;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

/**
 * @author paulalan
 * @create 2019/12/14 11:03
 */
public class End extends JPanel
{
	private welcomePage main = welcomePage.getInstance();
	public End(String currentUserName)
	{
		setLayout(null);

		JLabel over = new JLabel("Game over!", JLabel.CENTER);
//		over.setFont(f1);
		over.setBounds(0, 50, 800, 50);

		JLabel Correct = new JLabel("Correct Number:", JLabel.RIGHT);
		Correct.setBounds(0, 100, 500, 100);
//		Correct.setFont(f1);
		JLabel CorrectNum = new JLabel("10", JLabel.LEFT);
		CorrectNum.setBounds(500, 100, 100, 100);
//		CorrectNum.setFont(f1);

		JLabel Wrong = new JLabel("Wrong Number:", JLabel.RIGHT);
		Wrong.setBounds(0, 200, 500, 100);
//		Wrong.setFont(f1);
		JLabel WrongNum = new JLabel("10", JLabel.LEFT);
		WrongNum.setBounds(500, 200, 100, 100);
//		WrongNum.setFont(f1);

		// 返回按钮
		JButton Return = new JButton("Return");
//		Return.setFont(f2);
		Return.setBounds(650, 480, 100, 60);

		// bottom
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);
		watermark.setBounds(0, 540, 800, 20);
//		watermark.setFont(f2);

		add(over);
		add(Correct);
		add(CorrectNum);
		add(Wrong);
		add(WrongNum);
		add(Return);
		add(watermark);


		// 监听
		Return.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// 我的界面
//				GUI_Mine();
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
