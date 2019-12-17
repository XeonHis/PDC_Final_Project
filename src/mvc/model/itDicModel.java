package mvc.model;

import Other.JDBCUtil;
import mvc.others.Communication;
import mvc.others.updateInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Observable;

/**
 * @author paulalan
 * @create 2019/12/17 17:26
 */
public class itDicModel extends Observable
{
	private updateInfo updateInfo;
	private String userName;
	private String password;
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	Communication communication;

	public itDicModel()
	{
		updateInfo = new updateInfo();
		communication = new Communication();
	}

	public void checkLogin(String un, String pwd) throws SQLException
	{
		this.userName = un;
		this.password = pwd;
		updateInfo.registerFlag = true;
		if (communication.checkLogin(userName, password))
		{
			updateInfo.loginFlag = true;
			updateInfo.setCurrentUser(userName);
			getUserDetail(userName);
		}
		setChanged();
		notifyObservers(updateInfo);
		System.out.println("[Model] Login handled!");
	}

	public void register(String un, String pwd) throws SQLException
	{
		this.userName = un;
		this.password = pwd;
		if (communication.register(userName, password))
		{
			updateInfo.registerFlag = true;
			updateInfo.loginFlag = true;
			updateInfo.setCurrentUser(userName);
			getUserDetail(userName);
		}
		setChanged();
		notifyObservers(updateInfo);
		System.out.println("[Model] Register handled");
	}

	public void getUserDetail(String un) throws SQLException
	{
		this.userName = un;
		updateInfo.setId(communication.getAccountDetail(un));
//		setChanged();
//		notifyObservers(updateInfo);
		System.out.println("[Model] Get ID handled");
	}

	public void showRule()
	{
		updateInfo.ruleFlag = true;
		setChanged();
		notifyObservers(updateInfo);
		System.out.println("[Model] Rule show handled");
	}

	public void returnBack()
	{
		updateInfo.ruleFlag = false;
		updateInfo.historyFlag = false;
		updateInfo.endFlag = false;
		setChanged();
		notifyObservers(updateInfo);
		System.out.println("[Model] Rule un-show handled");
	}

	public void generateQuestion() throws SQLException
	{
		if (updateInfo.currentQuestionNum < 10)
		{
			updateInfo.startQuestionFlag = true;
			updateInfo.currentQuestionNum++;
			updateInfo.setCurrentQuestion(communication.generateQuestion());
		} else
		{
			updateInfo.startQuestionFlag = false;
			updateInfo.currentQuestionNum = 0;
			updateInfo.endFlag = true;
		}
		setChanged();
		notifyObservers(updateInfo);
		System.out.println("[Model] Question generated");
	}

}
