package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.EndBean;



@WebServlet("/EndServlet")
public class EndServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;


    public EndServlet(){}


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        EndBean end = service.KaiinService.doEnd();
        request.setAttribute("bean", end);
        RequestDispatcher disp = request.getRequestDispatcher("/End.jsp");
        disp.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

}
