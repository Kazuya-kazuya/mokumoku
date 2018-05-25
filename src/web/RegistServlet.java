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
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idstr = request.getParameter("registId");
		int id = Integer.parseInt(idstr);
		String name = request.getParameter("registName");
		String sexstr = request.getParameter("registSex");
		Sex sex;
		if(sexstr.equals("Man")) {
			sex = Sex.Man;
		}else {
			sex = Sex.Woman;
		}


		RegistBean regist;

		regist = service.KaiinService.doRegist(id, name, sex);
		request.setAttribute("bean", regist);
		RequestDispatcher disp = request.getRequestDispatcher("/Regist.jsp");
		disp.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
