package mvc.view;

import Question.Question;
import mvc.others.updateInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

/**
 * @author paulalan
 * @create 2019/12/17 17:03
 */
public class itDicView extends JFrame implements Observer
{
	private HashMap<Integer, JCheckBox> checkBoxHashMap = new HashMap<>();

	private JLabel watermark;
	public JButton loginButton;
	public JButton registerButton;
	public JTextField userNameInput;
	public JTextField passwordInput;
	private JPanel mainContainer = new JPanel(null);

	public JButton ruleButton = new JButton();
	public JButton historyButton = new JButton();
	public JButton startButton = new JButton();
	private JPanel index = new JPanel(null);

	public JButton returnButton = new JButton("Return");
	private JPanel rulePanel = new JPanel(null);

	private JPanel historyPanel = new JPanel(null);

	private int questionType = -1;
	private int answerNum = -1;
	public HashSet<String> customAnswer;
	private JTextArea questionDisplay = new JTextArea();
	private JButton submitButton = new JButton("Submit");
	private JPanel multipleBox=new JPanel(null);
	private JPanel startPanel = new JPanel(null);

	private JPanel endPanel = new JPanel(null);

	public itDicView() throws HeadlessException
	{
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);
		watermark.setBounds(0, 540, 800, 20);

		JLabel welcomeLabel =
				new JLabel("Welcome to Happy Dictionary", JLabel.CENTER);
		welcomeLabel.setBounds(0, 0, 800, 150);


		JLabel loginLabel = new JLabel("Log in: ");
		loginLabel.setBounds(200, 0, 800, 100);


		JLabel userNameLabel = new JLabel("* Username:", JLabel.RIGHT);
		userNameLabel.setBounds(0, 100, 400, 100);
		userNameInput = new JTextField();
		userNameInput.setBounds(400, 125, 300, 50);

		JLabel passwordLable = new JLabel("* Password:", JLabel.RIGHT);
		passwordLable.setBounds(0, 200, 400, 100);
		passwordInput = new JTextField();
		passwordInput.setBounds(400, 225, 300, 50);

		loginButton = new JButton("Log in");
		registerButton = new JButton("Register");
		loginButton.setBounds(100, 350, 200, 100);
		registerButton.setBounds(500, 350, 200, 100);

		mainContainer.add(welcomeLabel);
		mainContainer.add(watermark);
		mainContainer.add(loginButton);
		mainContainer.add(registerButton);
		mainContainer.add(userNameLabel);
		mainContainer.add(userNameInput);
		mainContainer.add(passwordLable);
		mainContainer.add(passwordInput);
		add(mainContainer);

		setVisible(true);
		setTitle("IT Dictionary!");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void index(int id, String currentUserName)
	{
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);
		JLabel AccountContent = new JLabel();

		JLabel Account = new JLabel("Account: " + id, JLabel.RIGHT);
		Account.setBounds(0, 0, 200, 100);

		JLabel Username = new JLabel("UserName: " + currentUserName, JLabel.RIGHT);
		Username.setBounds(400, 0, 200, 100);

		JLabel UserNameContent = new JLabel("", JLabel.LEFT);
		UserNameContent.setBounds(600, 0, 200, 100);


		ruleButton.setText("Rule");
		ruleButton.setBounds(310, 100, 180, 75);

		historyButton.setText("History");
		historyButton.setBounds(325, 200, 150, 75);

		startButton.setText("Starting Game");
		startButton.setBounds(250, 300, 300, 75);

		index.add(Account);
		index.add(watermark);
		index.add(AccountContent);
		index.add(Username);
		index.add(UserNameContent);
		index.add(ruleButton);
		index.add(historyButton);
		index.add(startButton);

		getContentPane().removeAll();
		index.setVisible(true);
		add(index);
		setVisible(true);
		revalidate();
		repaint();

	}

	public void history()
	{

	}

	public void rule()
	{
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);

		JLabel Rule = new JLabel("Rule", JLabel.CENTER);
		Rule.setBounds(0, 50, 800, 50);

		JTextArea RuleDisplay = new JTextArea();
		RuleDisplay.setEditable(false);
		RuleDisplay.setLineWrap(true);
		RuleDisplay.setWrapStyleWord(true);

		RuleDisplay.setBounds(100, 110, 600, 350);
		RuleDisplay.setText("每次挑战共10题，其中1-5道为单选题，6-10道为多选题。");

		returnButton.setBounds(650, 480, 100, 60);

		watermark.setBounds(0, 540, 800, 20);

		rulePanel.add(Rule);
		rulePanel.add(RuleDisplay);
		rulePanel.add(returnButton);
		rulePanel.add(watermark);

		getContentPane().removeAll();
		rulePanel.setVisible(true);
		add(rulePanel);
		revalidate();
		repaint();
	}

	public void startQuestion()
	{
		JLabel questionTypeLabel = new JLabel();
		questionTypeLabel.setBounds(0, 25, 800, 25);

		watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);


		if (questionType == 1)
		{
			questionTypeLabel.setText("Multiple Choice:");
		} else
		{
			questionTypeLabel.setText("Single Choice:");
		}

		// 问题显示
		questionDisplay.setEditable(false);
		questionDisplay.setLineWrap(true);
		questionDisplay.setWrapStyleWord(true);
		questionDisplay.setBounds(50, 75, 700, 250);

		// 数据库提供题目和答案
		customAnswer = new HashSet<>();

		// 多选按钮
//		multipleBox = new JPanel();

		if (checkBoxHashMap.size() < answerNum)
		{
			for (int i = checkBoxHashMap.size(); i < answerNum; i++)
			{
				JCheckBox temp = new JCheckBox(String.valueOf((char) (i + 65)));
				temp.addChangeListener(changeEvent ->
				{
					if (temp.isSelected())
					{
						customAnswer.add(temp.getText());
						System.out.println(customAnswer);
					} else
					{
						customAnswer.remove(temp.getText());
					}
				});
				checkBoxHashMap.put(i, temp);
			}
		}
		for (int i = 0; i < answerNum; i++)
		{
			multipleBox.add(checkBoxHashMap.get(i));
		}
		multipleBox.setBounds(100, 360, 600, 60);

		// 提交按钮
		submitButton.setBounds(350, 450, 100, 60);

		startPanel.add(questionTypeLabel);
		startPanel.add(questionDisplay);
		startPanel.add(multipleBox);
		startPanel.add(submitButton);
		startPanel.add(watermark);

		getContentPane().removeAll();
		startPanel.setVisible(true);
		add(startPanel);
		validate();
		repaint();
	}

	public void end()
	{
		JLabel over = new JLabel("Game over!", JLabel.CENTER);
		over.setBounds(0, 50, 800, 50);

		JLabel Correct = new JLabel("Correct Number:", JLabel.RIGHT);
		Correct.setBounds(0, 100, 500, 100);

		JLabel CorrectNum = new JLabel("10", JLabel.LEFT);
		CorrectNum.setBounds(500, 100, 100, 100);

		JLabel Wrong = new JLabel("Wrong Number:", JLabel.RIGHT);
		Wrong.setBounds(0, 200, 500, 100);

		JLabel WrongNum = new JLabel("10", JLabel.LEFT);
		WrongNum.setBounds(500, 200, 100, 100);

		returnButton.setBounds(650, 480, 100, 60);

		// bottom
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);
		watermark.setBounds(0, 540, 800, 20);

		endPanel.add(over);
		endPanel.add(Correct);
		endPanel.add(CorrectNum);
		endPanel.add(Wrong);
		endPanel.add(WrongNum);
		endPanel.add(returnButton);
		endPanel.add(watermark);

		getContentPane().removeAll();
		endPanel.setVisible(true);
		add(endPanel);
		validate();
		repaint();
	}

	public void setNewQuestion(Question question)
	{
		questionDisplay.setText(question.getQuestion());
		questionType = question.getType();
		answerNum = question.getAnswerNum();

	}

	public void setController(ActionListener ctrl)
	{
		loginButton.addActionListener(ctrl);
		registerButton.addActionListener(ctrl);
		ruleButton.addActionListener(ctrl);
		historyButton.addActionListener(ctrl);
		startButton.addActionListener(ctrl);
		returnButton.addActionListener(ctrl);
		submitButton.addActionListener(ctrl);
	}

	@Override
	public void update(Observable observable, Object o)
	{
		int tempID;
		String tempCurrentUser;
		updateInfo updateInfo = (mvc.others.updateInfo) o;
		if (!updateInfo.registerFlag)
		{
			System.out.println("[View] Register fail");
			JOptionPane.showMessageDialog(null,
					"Register fail!");
		} else
		{
			if (!updateInfo.loginFlag)
			{
				System.out.println("[View] Wrong username or password");
				JOptionPane.showMessageDialog(null,
						"Wrong username or password!");
				passwordInput.setText("");
				mainContainer.repaint();
			} else
			{
				tempID = updateInfo.getId();
				tempCurrentUser = updateInfo.getCurrentUser();
				index(tempID, tempCurrentUser);
				System.out.println("[View] Login successful");

				if (updateInfo.ruleFlag)
				{
					rule();
					System.out.println("[View] Rule show!");
				} else
				{
					index(tempID, tempCurrentUser);
				}

				if (updateInfo.startQuestionFlag)
				{
					setNewQuestion(updateInfo.currentQuestion);
					startQuestion();
					startPanel.repaint();
					System.out.println("[View] Question generated!");
				}
				if (updateInfo.endFlag)
				{
					end();
				}
			}

		}

	}
}
