package mvc.others;

import Question.Question;

/**
 * @author paulalan
 * @create 2019/12/17 17:33
 */
public class updateInfo
{
	public boolean loginFlag = false;
	public boolean registerFlag = false;
	public boolean endFlag = false;
	public boolean ruleFlag = false;
	public boolean historyFlag = false;
	public boolean startQuestionFlag = false;
	public int currentCorrectNum=0;
	public int currentQuestionNum = 0;
	public Question currentQuestion = new Question();
	private String currentUser = null;

	public Question getCurrentQuestion()
	{
		return currentQuestion;
	}

	public void setCurrentQuestion(Question currentQuestion)
	{
		this.currentQuestion = currentQuestion;
	}

	private int id = 0;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getCurrentUser()
	{
		return currentUser;
	}

	public void setCurrentUser(String currentUser)
	{
		this.currentUser = currentUser;
	}
}
