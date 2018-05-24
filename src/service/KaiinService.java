package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.RegistBean;
import bean.SearchBean;
import dao.Dao;
import domain.Sex;
import vo.KaiinVo;

public class KaiinService {
	public static RegistBean doRegist(int id, String name, Sex sex) throws ClassNotFoundException, SQLException {
		KaiinVo kaiin = new KaiinVo(id, name, sex);
		Connection connection = Dao.getConnection();
		dao.KaiinManager kaiinManager = new dao.KaiinManager(connection);
		kaiinManager.doRegist(kaiin);
		RegistBean bean = new RegistBean();
		return bean;
	}
	public static SearchBean doSearch(int id) throws ClassNotFoundException, SQLException {
		Connection connection = Dao.getConnection();
		dao.KaiinManager kaiinManager = new dao.KaiinManager(connection);
		SearchBean bean = kaiinManager.doSearch(id);
		return bean;
	}
}
