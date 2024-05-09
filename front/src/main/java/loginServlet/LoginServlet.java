package loginServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import performance_evaluation.EmpDTO;
import performance_evaluation.EmpService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/log/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인창 보여주기
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext app = getServletContext();
		EmpService service = new EmpService();
		
		int empId = Integer.parseInt(request.getParameter("userId"));
		int emppw = Integer.parseInt(request.getParameter("userPw"));
		
		String radio = request.getParameter("logoption");
		
		if("admin".equals(radio)) {
			int admin = service.selectAdminLog(empId, emppw);
			if(admin == 1) {
//				request.getRequestDispatcher("../admin/emplist.do").forward(request, response);
				response.sendRedirect("../admin/emplist.do");
			}
		}else {
			int emp = service.selectEmpLog(empId, emppw);
			if(emp == 1) {
				response.sendRedirect("../empinfo/myinfo.do");
			}
		}

	}

}
