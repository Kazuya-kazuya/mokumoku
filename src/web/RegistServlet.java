package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RegistBean;
import domain.Sex;



@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;


    public RegistServlet(){}


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String idstr = request.getParameter("registId");
            int id = Integer.parseInt(idstr);
            String name = request.getParameter("registName");
            Sex sex = Sex.valueOf(request.getParameter("registSex"));

            if(name.equals(""))
            {
                throw new NoTextException();
            }

            RegistBean bean;
            bean = service.KaiinService.doRegist(id, name, sex);
            request.setAttribute("bean", bean);
            RequestDispatcher disp = request.getRequestDispatcher("/Regist.jsp");
            disp.forward(request, response);
        }
        catch(NumberFormatException | NoTextException e)
        {
            RequestDispatcher disp = request.getRequestDispatcher("/index.html");
            disp.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
