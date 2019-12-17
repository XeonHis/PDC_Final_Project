package mvc.control;

import mvc.model.itDicModel;
import mvc.view.itDicView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author paulalan
 * @create 2019/12/17 17:03
 */
public class itDicControl implements ActionListener
{
	private itDicView itDicView;
	private itDicModel itDicModel;

	public itDicControl(mvc.view.itDicView theView, mvc.model.itDicModel theModel)
	{
		this.itDicView = theView;
		this.itDicModel = theModel;
		itDicView.setController(this);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		try
		{
			String eventString = event.getActionCommand();
			System.out.println("[Control] event string is " + eventString);
			if (eventString.compareTo("Log in") == 0)
			{
				String un = itDicView.userNameInput.getText();
				String pwd = itDicView.passwordInput.getText();
				itDicModel.checkLogin(un, pwd);
			} else if (eventString.compareTo("Register") == 0)
			{
				String un = itDicView.userNameInput.getText();
				String pwd = itDicView.passwordInput.getText();
				itDicModel.register(un, pwd);
			} else if (eventString.compareTo("Rule") == 0)
			{
				itDicModel.showRule();
			} else if (eventString.compareTo("Return") == 0)
			{
				itDicModel.returnBack();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
