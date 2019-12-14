package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author paulalan
 * @create 2019/12/14 11:00
 */
public class startQuestion extends JPanel
{
	private welcomePage main = welcomePage.getInstance();
	private static int round = 0;

	public startQuestion()
	{
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);

		setLayout(null);

		Font f3 = new Font("宋体", Font.BOLD, 20);// 底部水印格式

		// 单选
		JLabel Single = new JLabel("Single Choice:");
		Single.setBounds(0, 25, 800, 25);
		Single.setFont(f3);

		// 多选
		JLabel Multiple = new JLabel("Multiple Choice:");
		Multiple.setBounds(0, 25, 800, 25);
		Single.setFont(f3);

		// 根据数据库随机产生的题目判断是哪种类型的题
		JLabel QuestionType = new JLabel();
		// 问题显示
		JTextArea QuestionDisplay = new JTextArea();
		QuestionDisplay.setEditable(false);
		QuestionDisplay.setLineWrap(true);
		QuestionDisplay.setWrapStyleWord(true);
//		QuestionDisplay.setFont(f2);
		QuestionDisplay.setBounds(50, 75, 700, 250);

		// 数据库提供题目和答案
		QuestionDisplay.setText("11111");
		//answer = ？

		// 单选按钮（数量根据数据库决定）
		JButton OptionA = new JButton("A");
		OptionA.setBounds(100, 360, 100, 60);
		JButton OptionB = new JButton("B");
		OptionB.setBounds(267, 360, 100, 60);
		JButton OptionC = new JButton("C");
		OptionC.setBounds(434, 360, 100, 60);
		JButton OptionD = new JButton("D");
		OptionD.setBounds(600, 360, 100, 60);

		// 多选按钮
		JPanel box = new JPanel();
		JCheckBox box_A = new JCheckBox("A");
//		box_A.setFont(f1);
		JCheckBox box_B = new JCheckBox("B");
//		box_B.setFont(f1);
		JCheckBox box_C = new JCheckBox("C");
//		box_C.setFont(f1);
		JCheckBox box_D = new JCheckBox("D");
//		box_D.setFont(f1);
		box.add(box_A);
		box.add(box_B);
		box.add(box_C);
		box.add(box_D);
		box.setBounds(100, 360, 600, 60);

		// 提交按钮
		JButton Submit = new JButton("Submit");
		Submit.setBounds(350, 450, 100, 60);

		add(QuestionType);
		add(QuestionDisplay);


		add(box);
		add(Submit);
		add(watermark);

		// 监听
		Submit.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				round = round + 1;
				// 如果题数没够
				if (round < 10)
				{
//					GUI_Question();
					main.setTitle("IT Dictionary!");
					main.getContentPane().removeAll();
					startQuestion startQuestion = new startQuestion();
					main.setContentPane(startQuestion);
					startQuestion.setVisible(false);
					startQuestion.setVisible(true);
				} else
				{
					main.setTitle("Answer Result");
					main.getContentPane().removeAll();
					End end = new End();
					main.setContentPane(end);
					end.setVisible(false);
					end.setVisible(true);
				}
			}
		});
	}
}
