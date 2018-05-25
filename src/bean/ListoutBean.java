package bean;

import java.util.ArrayList;
import java.util.List;

public class ListoutBean
{
	List<KaiinBean> list;
	String message;


	public ListoutBean()
	{
		this.list = new ArrayList<KaiinBean>();
	}


	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public List<KaiinBean> getList()
	{
		return list;
	}

	public void setList(List<KaiinBean> list)
	{
		this.list = list;
	}
}
