package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EndBean;
import bean.KaiinBean;
import bean.ListoutBean;
import bean.RegistBean;
import bean.SearchBean;
import dao.Dao;
import domain.Sex;
import vo.KaiinVo;

public class KaiinService
{
    public static EndBean doEnd()
    {
        EndBean bean = new EndBean();
        bean.setMessege("終了します");
        return bean;
    }
    public static RegistBean doRegist(int id, String name, Sex sex)
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
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static SearchBean doSearch(int id)
    {
        SearchBean bean = new SearchBean();

        try
        (
            Connection connection = Dao.getConnection();
        )
        {
            dao.KaiinManager kaiinManager = new dao.KaiinManager(connection);
            KaiinVo kaiin = kaiinManager.doSearch(id);
            bean.setId(kaiin.getId());
            bean.setName(kaiin.getName());
            bean.setDate(kaiin.getDate());
            bean.setSex(kaiin.getSex());
            bean.setMessege("検索しました");
            return bean;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static ListoutBean doListout()
    {
        ListoutBean bean = new ListoutBean();

        try
        (
            Connection connection = Dao.getConnection();
        )
        {
            dao.KaiinManager kaiinManager = new dao.KaiinManager(connection);
            List<KaiinVo> voList = kaiinManager.doListout();
            List<KaiinBean> beanList = new ArrayList<KaiinBean>();
            for(KaiinVo kaiinVo : voList)
            {
                KaiinBean kaiinBean = new KaiinBean();
                kaiinBean.setId(kaiinVo.getId());
                kaiinBean.setName(kaiinVo.getName());
                kaiinBean.setDate(kaiinVo.getDate());
                kaiinBean.setSex(kaiinVo.getSex());
                beanList.add(kaiinBean);
            }
            bean.setList(beanList);
            bean.setMessage("会員リストです");
            return bean;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
