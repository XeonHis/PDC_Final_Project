package Communication;

//import GUI.Client;
import Question.Question;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @author paulalan
 * @create 2019/11/13 20:32
 */
public class Communication implements Runnable
{
//	private Client client = Client.getInstance();
	private String hostname;
	private int port;
	private Socket s;
	private ObjectOutputStream oos;
	Question questionDetail;

	public Communication(String hostname, int port)
	{
		this.hostname = hostname;
		this.port = port;
//		client.setCommunication(this);
	}

	@Override
	public void run()
	{

		try
		{
			s = new Socket(hostname, port);
			System.out.println("Socket creates successfully!");
			oos = new ObjectOutputStream(s.getOutputStream());
			System.out.println("oos creates successfully!");
//			ois = new ObjectInputStream(s.getInputStream());


			connect();

			while (s.isConnected())
			{
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Question acquiredQuestionDetail = (Question) ois.readObject();
				System.out.println(acquiredQuestionDetail);

				System.out.println("id = " + acquiredQuestionDetail.getId() + "\nquestion = " + acquiredQuestionDetail.getQuestion() +
						"\nanswer = " + acquiredQuestionDetail.getAnswer() + "\ntype = " + acquiredQuestionDetail.getType() +
						"\nanswerNum = " + acquiredQuestionDetail.getAnswerNum());
//				client.setAcquiredQuestion(acquiredQuestionDetail);
			}
		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}

	public void connect()
	{
		System.out.println("Start connect activity.");
		//create question class
		acquireQuestion();
		//send
//		send(questionDetail);
	}

	public void send(Question question)
	{
		try
		{
			System.out.println("Message sends successfully." + new Date());
			oos.writeObject(question);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public Question getQuestion()
	{
		return questionDetail;
	}

	public void acquireQuestion()
	{
		//create question class
		questionDetail = new Question();
		questionDetail.setFlag("acquire");
		//send
		send(questionDetail);
	}

	public void checkAnswer()
	{
		questionDetail = new Question();
		questionDetail.setFlag("check");
		send(questionDetail);
	}
}
