package GUI;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

/**
 * @author paulalan
 * @create 2019/12/14 10:52
 */
public class History extends JPanel
{
	private welcomePage main = welcomePage.getInstance();
	public History(String currentUserName)
	{
		setLayout(null);

		JLabel record = new JLabel("History Record", JLabel.CENTER);
//		record.setFont(f1);
		record.setBounds(0, 0, 800, 100);

		JLabel time = new JLabel("Time", JLabel.CENTER);
//		time.setFont(f1);
		time.setBounds(0, 100, 400, 60);
		JLabel Score = new JLabel("Score", JLabel.CENTER);
//		Score.setFont(f1);
		Score.setBounds(400, 100, 400, 60);

//		// 时间+记录
//		TimeRecord1.setBounds(0, 164, 400, 60);
//		TimeRecord1.setFont(f1);
//		ScoreRecord1.setBounds(400, 164, 400, 60);
//		ScoreRecord1.setFont(f1);
//
//		TimeRecord2 = new JLabel("123", JLabel.CENTER);
//		TimeRecord2.setBounds(0, 228, 400, 60);
//		TimeRecord2.setFont(f1);
//		ScoreRecord2 = new JLabel("10", JLabel.CENTER);
//		ScoreRecord2.setBounds(400, 228, 400, 60);
//		ScoreRecord2.setFont(f1);
//
//		TimeRecord3 = new JLabel("123", JLabel.CENTER);
//		TimeRecord3.setBounds(0, 292, 400, 60);
//		TimeRecord3.setFont(f1);
//		ScoreRecord3 = new JLabel("10", JLabel.CENTER);
//		ScoreRecord3.setBounds(400, 292, 400, 60);
//		ScoreRecord3.setFont(f1);
//
//		TimeRecord4 = new JLabel("123", JLabel.CENTER);
//		TimeRecord4.setBounds(0, 356, 400, 60);
//		TimeRecord4.setFont(f1);
//		ScoreRecord4 = new JLabel("10", JLabel.CENTER);
//		ScoreRecord4.setBounds(400, 356, 400, 60);
//		ScoreRecord4.setFont(f1);
//
//		TimeRecord5 = new JLabel("123", JLabel.CENTER);
//		TimeRecord5.setBounds(0, 420, 400, 60);
//		TimeRecord5.setFont(f1);
//		ScoreRecord5 = new JLabel("10", JLabel.CENTER);
//		ScoreRecord5.setBounds(400, 420, 400, 60);
//		ScoreRecord5.setFont(f1);

		// 返回按钮
		JButton Return = new JButton("Return");
//		Return.setFont(f2);
		Return.setBounds(650, 480, 100, 60);

		// bottom
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);
		watermark.setBounds(0, 540, 800, 20);
//		watermark.setFont(f2);

		add(record);
		add(time);
		add(Score);
		add(Return);
//		add(TimeRecord1);
//		add(ScoreRecord1);
//		add(TimeRecord2);
//		add(ScoreRecord2);
//		add(TimeRecord3);
//		add(ScoreRecord3);
//		add(TimeRecord4);
//		add(ScoreRecord4);
//		add(TimeRecord5);
//		add(ScoreRecord5);
		add(watermark);


		// 监听
		Return.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// 历史记录
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
