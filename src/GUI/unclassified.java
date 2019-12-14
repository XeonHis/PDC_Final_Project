package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class unclassified extends JFrame {

	Font f1 = new Font("宋体", Font.BOLD, 30);// 加粗大字格式
	Font f2 = new Font("宋体", Font.PLAIN, 15);// 底部水印格式
	
	//背景图
	ImageIcon bg;
	JLabel bg_label;

	// 框架
	JFrame jf = new JFrame("Happy Dictionary!");
	JFrame frame = new JFrame("Happy Dictionary!");
	JPanel jp;

	// 输入
	JTextField Username_Input;
	JTextField Password_Input;

	// 水印
	JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);

	// 系统提供的账号
	JLabel AccountContent = new JLabel();

	// 时间和记录
	JLabel TimeRecord1;
	JLabel ScoreRecord1;
	JLabel TimeRecord2;
	JLabel ScoreRecord2;
	JLabel TimeRecord3;
	JLabel ScoreRecord3;
	JLabel TimeRecord4;
	JLabel ScoreRecord4;
	JLabel TimeRecord5;
	JLabel ScoreRecord5;

	// 题目数量
	int round = 0;
	
	//题目答案
	String answer = "";

	public unclassified() {
		GUI_Cover();
	}

	/**
	 * main page
	 */
	public void GUI_Cover() {
		jf.setName("Login");
		jf.getContentPane().removeAll();
		jf.setSize(800, 600);
		jp = new JPanel(null);
		
//		bg=new ImageIcon("C:\\Users\\ASUS\\Desktop\\bg.jpg");
//		
//		bg_label=new JLabel(bg);
//		bg_label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
//		jf.getLayeredPane().add(bg_label,new Integer(Integer.MIN_VALUE));
//		JPanel p=(JPanel)this.getContentPane();
//		p.setOpaque(false);


		// title
		JLabel title = new JLabel("Welcome to Happy Dictionary�?", JLabel.CENTER);
		title.setBounds(0, 150, 800, 150);
		title.setFont(f1);

		// watermark
		watermark.setBounds(0, 540, 800, 20);
		watermark.setFont(f2);

		// botton
		JButton LoginButton = new JButton("Log in");
		JButton RegisterButton = new JButton("Register");
		LoginButton.setBounds(100, 350, 200, 100);
		RegisterButton.setBounds(500, 350, 200, 100);

		jp.add(title);
		jp.add(watermark);
		jp.add(LoginButton);
		jp.add(RegisterButton);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		LoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_Login();
			}
		});
		RegisterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GUI_Register();
			}
		});
	}

	/**
	 * login
	 */
	public void GUI_Login() {
		jf.setName("Welcome to Login");
		jf.setSize(800, 600);
		jf.getContentPane().removeAll();
		jp = new JPanel(null);

		// top
		JLabel jLabel1 = new JLabel("Log in: ");
		jLabel1.setBounds(0, 0, 800, 100);
		jLabel1.setFont(f1);

		// username
		JLabel Username = new JLabel("*Username:", JLabel.RIGHT);
		Username.setBounds(0, 100, 400, 100);
		Username.setFont(f1);
		Username_Input = new JTextField();
		Username_Input.setBounds(400, 125, 300, 50);
		Username_Input.setFont(f1);

		// password
		JLabel Password = new JLabel("*Password:", JLabel.RIGHT);
		Password.setBounds(0, 200, 400, 100);
		Password.setFont(f1);
		Password_Input = new JTextField();
		Password_Input.setBounds(400, 225, 300, 50);
		Password_Input.setFont(f1);

		// Login Button
		JButton Login = new JButton("Login");
		Login.setBounds(300, 350, 150, 80);
		Login.setFont(f1);

		jp.add(jLabel1);
		jp.add(watermark);
		jp.add(Username);
		jp.add(Username_Input);
		jp.add(Password);
		jp.add(Password_Input);
		jp.add(Login);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 监听
		Login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 数据库验证账号密码是否符合

				// 正确则登陆
				GUI_Mine();

				// 密码错误提醒
				// JOptionPane.showMessageDialog(frame, "Wrong Password");

				// 用户名不存在提醒注册
				// JOptionPane.showMessageDialog(frame, "Register First");
			}
		});
	}

	/**
	 * register
	 */
	public void GUI_Register() {
		// 标题
		jf.setName("Welcome to Register");
		jf.setSize(800, 600);
		jf.getContentPane().removeAll();
		jp = new JPanel(null);
		JLabel Register = new JLabel("Register:");
		Register.setFont(f1);
		Register.setBounds(0, 0, 800, 100);

		// username
		JLabel UserName = new JLabel("*UserName:", JLabel.RIGHT);
		UserName.setBounds(0, 100, 400, 100);
		UserName.setFont(f1);
		Username_Input = new JTextField();
		Username_Input.setBounds(400, 125, 300, 50);
		Username_Input.setFont(f1);

		// password
		JLabel Password = new JLabel("*Password:", JLabel.RIGHT);
		Password.setBounds(0, 200, 400, 100);
		Password.setFont(f1);
		Password_Input = new JTextField();
		Password_Input.setBounds(400, 225, 300, 50);
		Password_Input.setFont(f1);

		// Confirm Password
		JLabel ConfirmPassword = new JLabel("*Confirm Password:", JLabel.RIGHT);
		ConfirmPassword.setBounds(0, 300, 400, 100);
		ConfirmPassword.setFont(f1);
		JTextField ConfirmPasswordInput = new JTextField();
		ConfirmPasswordInput.setBounds(400, 325, 300, 50);
		ConfirmPasswordInput.setFont(f1);

		// Button
		JButton button = new JButton("Register and Login");
		button.setBounds(200, 400, 400, 100);

		jp.add(Register);
		jp.add(watermark);
		jp.add(UserName);
		jp.add(Username_Input);
		jp.add(Password);
		jp.add(Password_Input);
		jp.add(ConfirmPassword);
		jp.add(ConfirmPasswordInput);
		jp.add(button);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 监听
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 数据库保存用户名密码,并提供账号

				// 系统分配账号：从1开始顺位，数据库保存并提供
				AccountContent.setText("");
				AccountContent.setBounds(200, 0, 200, 100);
				// 登陆
				GUI_Mine();
			}
		});
	}

	/**
	 * page while successfully login
	 */
	public void GUI_Mine() {
		jf.setName("Mine");
		jf.getContentPane().removeAll();
		jf.setSize(800, 600);
		jp = new JPanel(null);
		Font f4 = new Font("宋体", Font.PLAIN, 30);// 底部水印格式

		// 账号
		JLabel Account = new JLabel("Account:", JLabel.RIGHT);
		Account.setBounds(0, 0, 200, 100);
		Account.setFont(f4);

		// 用户名
		JLabel Username = new JLabel("UserName:", JLabel.RIGHT);
		Username.setBounds(400, 0, 200, 100);
		Username.setFont(f4);
		// 用户名设置
		JLabel UserNameContent = new JLabel(Username_Input.getText(), JLabel.LEFT);
		UserNameContent.setBounds(600, 0, 200, 100);
		UserNameContent.setFont(f4);

		// 规则按钮
		JButton Rule = new JButton("Rule");
		Rule.setFont(f1);
		Rule.setBounds(310, 100, 180, 75);

		// 历史按钮
		JButton History = new JButton("History");
		Font f3 = new Font("宋体", Font.BOLD, 26);
		History.setFont(f3);
		History.setBounds(325, 200, 150, 75);

		// 开始游戏按钮
		JButton Start = new JButton("Starting Game");
		Start.setFont(f1);
		Start.setBounds(250, 300, 300, 75);

		jp.add(Account);
		jp.add(watermark);
		jp.add(AccountContent);
		jp.add(Username);
		jp.add(UserNameContent);
		jp.add(Rule);
		jp.add(History);
		jp.add(Start);
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 监听
		Rule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 规则界面
				GUI_Rule();
			}
		});
		History.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 设置历史记录中时间和记录的值（调用数据库）
				TimeRecord1 = new JLabel("", JLabel.CENTER);
				ScoreRecord1 = new JLabel("", JLabel.CENTER);
				TimeRecord2 = new JLabel("", JLabel.CENTER);
				ScoreRecord2 = new JLabel("", JLabel.CENTER);
				TimeRecord3 = new JLabel("", JLabel.CENTER);
				ScoreRecord3 = new JLabel("", JLabel.CENTER);
				TimeRecord4 = new JLabel("", JLabel.CENTER);
				ScoreRecord4 = new JLabel("", JLabel.CENTER);
				TimeRecord5 = new JLabel("", JLabel.CENTER);
				ScoreRecord5 = new JLabel("", JLabel.CENTER);
				// 历史记录
				GUI_History();
			}
		});
		Start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 开始游戏
				GUI_Question();
			}
		});
	}

	/**
	 * provide question
	 */
	public void GUI_Question() {
		jf.setName("Question");
		jf.getContentPane().removeAll();
		jf.setSize(800, 600);
		jp = new JPanel(null);

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
		QuestionDisplay.setFont(f2);
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
		box_A.setFont(f1);
		JCheckBox box_B = new JCheckBox("B");
		box_B.setFont(f1);
		JCheckBox box_C = new JCheckBox("C");
		box_C.setFont(f1);
		JCheckBox box_D = new JCheckBox("D");
		box_D.setFont(f1);
		box.add(box_A);
		box.add(box_B);
		box.add(box_C);
		box.add(box_D);
		box.setBounds(100, 360, 600, 60);

		// 提交按钮
		JButton Submit = new JButton("Submit");
		Submit.setBounds(350, 450, 100, 60);

		jp.add(QuestionType);
		jp.add(QuestionDisplay);
//		jp.add(OptionA);
//		jp.add(OptionB);
//		jp.add(OptionC);
//		jp.add(OptionD);

		jp.add(box);
		jp.add(Submit);
		jp.add(watermark);

		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 监听
		Submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				round = round + 1;
				// 如果题数没够
				if (round < 10) {
					GUI_Question();
				} else {
					GUI_Ending();
				}
			}
		});
	}

	/**
	 * show rules
	 */
	public void GUI_Rule() {
		jf.setName("Rule");
		jf.getContentPane().removeAll();
		jf.setSize(800, 600);
		jp = new JPanel(null);

		JLabel Rule = new JLabel("Rule", JLabel.CENTER);
		Rule.setFont(f1);
		Rule.setBounds(0, 50, 800, 50);
		// 规则显示
		JTextArea RuleDisplay = new JTextArea();
		RuleDisplay.setEditable(false);
		RuleDisplay.setLineWrap(true);
		RuleDisplay.setWrapStyleWord(true);
		RuleDisplay.setFont(f2);
		RuleDisplay.setBounds(100, 110, 600, 350);
		RuleDisplay.setText("每次挑战共10题，其中1-5道为单选题，6-10道为多选题。");

		// 返回按钮
		JButton Return = new JButton("Return");
		Return.setFont(f2);
		Return.setBounds(650, 480, 100, 60);

		// bottom
		watermark.setBounds(0, 540, 800, 20);
		watermark.setFont(f2);

		jp.add(Rule);
		jp.add(RuleDisplay);
		jp.add(Return);
		jp.add(watermark);

		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 监听
		Return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 历史记录
				GUI_Mine();
			}
		});
	}

	/**
	 * History record
	 */
	public void GUI_History() {
		jf.setName("History");
		jf.getContentPane().removeAll();
		jp = new JPanel(null);

		JLabel record = new JLabel("History Record", JLabel.CENTER);
		record.setFont(f1);
		record.setBounds(0, 0, 800, 100);

		JLabel time = new JLabel("Time", JLabel.CENTER);
		time.setFont(f1);
		time.setBounds(0, 100, 400, 60);
		JLabel Score = new JLabel("Score", JLabel.CENTER);
		Score.setFont(f1);
		Score.setBounds(400, 100, 400, 60);

		// 时间+记录
		TimeRecord1.setBounds(0, 164, 400, 60);
		TimeRecord1.setFont(f1);
		ScoreRecord1.setBounds(400, 164, 400, 60);
		ScoreRecord1.setFont(f1);

		TimeRecord2 = new JLabel("123", JLabel.CENTER);
		TimeRecord2.setBounds(0, 228, 400, 60);
		TimeRecord2.setFont(f1);
		ScoreRecord2 = new JLabel("10", JLabel.CENTER);
		ScoreRecord2.setBounds(400, 228, 400, 60);
		ScoreRecord2.setFont(f1);

		TimeRecord3 = new JLabel("123", JLabel.CENTER);
		TimeRecord3.setBounds(0, 292, 400, 60);
		TimeRecord3.setFont(f1);
		ScoreRecord3 = new JLabel("10", JLabel.CENTER);
		ScoreRecord3.setBounds(400, 292, 400, 60);
		ScoreRecord3.setFont(f1);

		TimeRecord4 = new JLabel("123", JLabel.CENTER);
		TimeRecord4.setBounds(0, 356, 400, 60);
		TimeRecord4.setFont(f1);
		ScoreRecord4 = new JLabel("10", JLabel.CENTER);
		ScoreRecord4.setBounds(400, 356, 400, 60);
		ScoreRecord4.setFont(f1);

		TimeRecord5 = new JLabel("123", JLabel.CENTER);
		TimeRecord5.setBounds(0, 420, 400, 60);
		TimeRecord5.setFont(f1);
		ScoreRecord5 = new JLabel("10", JLabel.CENTER);
		ScoreRecord5.setBounds(400, 420, 400, 60);
		ScoreRecord5.setFont(f1);

		// 返回按钮
		JButton Return = new JButton("Return");
		Return.setFont(f2);
		Return.setBounds(650, 480, 100, 60);

		// bottom
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);
		watermark.setBounds(0, 540, 800, 20);
		watermark.setFont(f2);

		jp.add(record);
		jp.add(time);
		jp.add(Score);
		jp.add(Return);
		jp.add(TimeRecord1);
		jp.add(ScoreRecord1);
		jp.add(TimeRecord2);
		jp.add(ScoreRecord2);
		jp.add(TimeRecord3);
		jp.add(ScoreRecord3);
		jp.add(TimeRecord4);
		jp.add(ScoreRecord4);
		jp.add(TimeRecord5);
		jp.add(ScoreRecord5);
		jp.add(watermark);

		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 监听
		Return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 历史记录
				GUI_Mine();
			}
		});

	}

	/**
	 * end
	 */
	public void GUI_Ending() {
		jf.setName("Answer Result");
		jf.getContentPane().removeAll();
		jf.setSize(800, 600);
		jp = new JPanel(null);

		JLabel over = new JLabel("Game over!", JLabel.CENTER);
		over.setFont(f1);
		over.setBounds(0, 50, 800, 50);

		JLabel Correct = new JLabel("Correct Number:", JLabel.RIGHT);
		Correct.setBounds(0, 100, 500, 100);
		Correct.setFont(f1);
		JLabel CorrectNum = new JLabel("10", JLabel.LEFT);
		CorrectNum.setBounds(500, 100, 100, 100);
		CorrectNum.setFont(f1);

		JLabel Wrong = new JLabel("Wrong Number:", JLabel.RIGHT);
		Wrong.setBounds(0, 200, 500, 100);
		Wrong.setFont(f1);
		JLabel WrongNum = new JLabel("10", JLabel.LEFT);
		WrongNum.setBounds(500, 200, 100, 100);
		WrongNum.setFont(f1);

		// 返回按钮
		JButton Return = new JButton("Return");
		Return.setFont(f2);
		Return.setBounds(650, 480, 100, 60);

		// bottom
		JLabel watermark = new JLabel("©Happy Dictionary", JLabel.CENTER);
		watermark.setBounds(0, 540, 800, 20);
		watermark.setFont(f2);

		jp.add(over);
		jp.add(Correct);
		jp.add(CorrectNum);
		jp.add(Wrong);
		jp.add(WrongNum);
		jp.add(Return);
		jp.add(watermark);

		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 监听
		Return.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 我的界面
				GUI_Mine();
			}
		});
	}

	public static void main(String[] args) {
		unclassified unclassified = new unclassified();
	}

}
