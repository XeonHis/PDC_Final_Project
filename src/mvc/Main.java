package mvc;


import mvc.control.itDicControl;
import mvc.model.itDicModel;
import mvc.view.itDicView;

/**
 * @author paulalan
 * @create 2019/12/17 17:13
 */
public class Main
{
	public static void main(String[] args)
	{
		itDicView itDicView=new itDicView();
		itDicModel itDicModel=new itDicModel();
		itDicControl itDicControl=new itDicControl(itDicView,itDicModel);
		itDicModel.addObserver(itDicView);
	}
}
