package mvc.others;

/**
 * @author paulalan
 * @create 2019/12/17 17:33
 */
public class updateInfo
{
	public boolean loginFlag = false;
	public boolean registerFlag = false;
	public boolean quitFlag = true;
	public boolean ruleFlag = false;
	public boolean historyFlag = false;
	public int currentCorrectNum = 0;
	private String currentUser = null;
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
