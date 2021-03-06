package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SearchBean;



@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;


    public SearchServlet(){}


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String idstr = request.getParameter("searchId");
            int id = Integer.parseInt(idstr);

            SearchBean bean = service.KaiinService.doSearch(id);
            request.setAttribute("bean", bean);
            RequestDispatcher disp = request.getRequestDispatcher("/Search.jsp");
            disp.forward(request, response);
        }
        catch(NumberFormatException e)
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
