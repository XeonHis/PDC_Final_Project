package GUI;

import Question.Question;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

/**
 * @author paulalan
 * @create 2019/12/14 11:00
 */
public class startQuestion extends JPanel
{
	private welcomePage main = welcomePage.getInstance();
	private static int count = 0;
	private static int correctCount = 0;

	public startQuestion(String currentUserName) throws SQLException
	{
		setLayout(null);

		Font f3 = new Font("宋体", Font.BOLD, 20);// 底部水印格式
		Question currentQuestion = main.getCommunication().generateQuestion();

		JLabel questionType = new JLabel();
		questionType.setBounds(0, 25, 800, 25);

		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);


		if (currentQuestion.getType() == 1)
		{
			questionType.setText("Multiple Choice:");
		} else
		{
			questionType.setText("Single Choice:");
		}


		// 问题显示
		JTextArea QuestionDisplay = new JTextArea();
		QuestionDisplay.setEditable(false);
		QuestionDisplay.setLineWrap(true);
		QuestionDisplay.setWrapStyleWord(true);
//		QuestionDisplay.setFont(f2);
		QuestionDisplay.setBounds(50, 75, 700, 250);

		// 数据库提供题目和答案
		QuestionDisplay.setText(currentQuestion.getQuestion());
		String currentQuestionAnswer = currentQuestion.getAnswer();
		HashSet<String> customAnswer = new HashSet<>();

		int answerNum = currentQuestion.getAnswerNum();
		// 多选按钮
		JPanel multipleBox = new JPanel();
		for (int i = 0; i < answerNum; i++)
		{
			JCheckBox temp = new JCheckBox(String.valueOf((char) (i + 65)));
			temp.addChangeListener(new ChangeListener()
			{
				@Override
				public void stateChanged(ChangeEvent changeEvent)
				{
					if (temp.isSelected())
					{
						customAnswer.add(temp.getText());
						System.out.println(customAnswer);
					} else
					{
						customAnswer.remove(temp.getText());
					}
				}
			});
			multipleBox.add(temp);
		}
		multipleBox.setBounds(100, 360, 600, 60);

		// 提交按钮
		JButton Submit = new JButton("Submit");
		Submit.setBounds(350, 450, 100, 60);

		add(questionType);
		add(QuestionDisplay);
		add(multipleBox);
		add(Submit);
		add(watermark);

		// 监听
		Submit.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("submit answer: " + customAnswer);
				if (customAnswer.contains(currentQuestionAnswer))
				{
					System.out.println("Right");
					correctCount++;
				} else
				{
					System.out.println("false");
				}
				count = count + 1;
				// 如果题数没够
				if (count < 10)
				{
//					GUI_Question();
					main.setTitle("IT Dictionary!");
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

				} else
				{
					try
					{
						main.getCommunication().updateAnswerDetail(currentUserName, correctCount);
						main.setTitle("Answer Result");
						main.getContentPane().removeAll();
						End end = new End(currentUserName);
						main.setContentPane(end);
						end.setVisible(false);
						end.setVisible(true);
					} catch (SQLException ex)
					{
						ex.printStackTrace();
					}
				}
			}
		});
	}
}
