package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.ListoutBean;
import bean.RegistBean;
import bean.SearchBean;
import dao.Dao;
import domain.Sex;
import vo.KaiinVo;

public class KaiinService
{
	public static RegistBean doRegist(int id, String name, Sex sex) throws ClassNotFoundException
	{
		KaiinVo kaiin = new KaiinVo(id, name, sex);

		try
		(
			Connection connection = Dao.getConnection();
		)
		{
			dao.KaiinManager kaiinManager = new dao.KaiinManager(connection);
			kaiinManager.doRegist(kaiin);
			RegistBean bean = new RegistBean();
			bean.setMessege("登録しました");
			return bean;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static SearchBean doSearch(int id) throws ClassNotFoundException
	{
		SearchBean bean = new SearchBean();

		try
		(
			Connection connection = Dao.getConnection();
		)
		{
			dao.KaiinManager kaiinManager = new dao.KaiinManager(connection);
			bean = kaiinManager.doSearch(id);
			return bean;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static ListoutBean doListout() throws ClassNotFoundException
	{
		ListoutBean bean = new ListoutBean();

		try
		(
			Connection connection = Dao.getConnection();
		)
		{
			dao.KaiinManager kaiinManager = new dao.KaiinManager(connection);
			bean = kaiinManager.doListout();
			return bean;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
