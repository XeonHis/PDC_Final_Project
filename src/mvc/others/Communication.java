package mvc.others;


import Other.JDBCUtil;
import Question.Question;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/**
 * @author paulalan
 * @create 2019/11/13 20:32
 */
public class Communication
{
//	private GUI.welcomePage welcomePage = GUI.welcomePage.getInstance();
	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;

	private static int id = -1;
	private static int randomID;
	private static String question = "";
	private static String answer = "";
	private static int type = -1;
	private static int answerNum = -1;


//	public Communication()
//	{
////		welcomePage.setCommunication(this);
//	}


	public Question generateQuestion() throws SQLException
	{
		Question questionDetail = new Question();
		randomID = createRandomID();
		conn = JDBCUtil.getConn();
		String detail = "select * from myTest where id=?";
		ps = conn.prepareStatement(detail);
		ps.setString(1, String.valueOf(randomID));
		rs = ps.executeQuery();
		while (rs.next())
		{
			id = rs.getInt("id");
			question = rs.getString("question");
			answer = rs.getString("answer");
			type = rs.getInt("type");
			answerNum = rs.getInt("answerNum");
		}
		JDBCUtil.release(conn, ps, rs);
		System.out.println("id = " + id + "\nquestion = " + question + "\nanswer = " + answer +
				"\ntype = " + type + "\nanswerNum = " + answerNum);
		questionDetail.setItems(id, question, answer, type, answerNum);
		return questionDetail;
	}

	public boolean checkLogin(String userName, String password) throws SQLException
	{
		conn = JDBCUtil.getConn();
		String sql = "select * from user_detail where user_name=? and password=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, password);
		rs = ps.executeQuery();
		boolean flag = rs.next();
		JDBCUtil.release(conn, ps, rs);
		return flag;
	}

	public boolean register(String userName, String password) throws SQLException
	{
		if (!checkUserExist(userName))
		{
			conn = JDBCUtil.getConn();
			String sql = "insert user_detail(user_name,password,create_time) values (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.setString(3, new Date().toString());
			int result = ps.executeUpdate();
			if (result > 0)
			{
				System.out.println("Register successfully");
				JDBCUtil.release(conn, ps);
				return true;
			} else
			{
				JDBCUtil.release(conn, ps);
				return false;
			}
		} else
		{
			return false;
		}
	}


	public int createRandomID()
	{
		return (int) (Math.random() * 200);
	}


	private boolean checkUserExist(String userName) throws SQLException
	{
		conn = JDBCUtil.getConn();
		String sql = "select * from user_detail where user_name=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		rs = ps.executeQuery();
		boolean flag = rs.next();
		JDBCUtil.release(conn, ps, rs);
		return flag;
	}

	public int getAccountDetail(String userName) throws SQLException
	{
		conn = JDBCUtil.getConn();
		String sql = "select id from user_detail where user_name=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		rs = ps.executeQuery();
		int id = 0;
		while (rs.next())
		{
			id = rs.getInt("id");
		}

		return id;
	}

	public void updateAnswerDetail(String userName, int correctCount) throws SQLException
	{
		conn = JDBCUtil.getConn();
		String sql = "insert answer_detail(user_name,create_time,correct_count) values (?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ps.setString(2, new Date().toString());
		ps.setString(3, String.valueOf(correctCount));
		int result = ps.executeUpdate();
		if (result > 0)
		{
			System.out.println("Update successfully");
		}
		JDBCUtil.release(conn, ps);
	}

//	@Test
//	public void test() throws SQLException
//	{
//		boolean flag = login("test1", "123456");
//		System.out.println(flag);
//	}

}
