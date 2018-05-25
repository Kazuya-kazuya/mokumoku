package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ListoutBean;



@WebServlet("/ListoutServlet")
public class ListoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;


    public ListoutServlet(){}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			ListoutBean bean = service.KaiinService.doListout();
			request.setAttribute("bean", bean);
			RequestDispatcher disp = request.getRequestDispatcher("/Listout.jsp");
			disp.forward(request, response);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
