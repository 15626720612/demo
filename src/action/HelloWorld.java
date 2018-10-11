package action;

import com.opensymphony.xwork2.Action;

public class HelloWorld implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("执行Action");
		boolean f=true;
		if(f)
			return "SUCCESS";
		else
			return "ERROR";
	}

}
