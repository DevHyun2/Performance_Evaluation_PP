package adminServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import performance_evaluation.CheckDTO;
import performance_evaluation.CheckService;
import performance_evaluation.EmpDTO;
import performance_evaluation.EmpService;

/**
 * Servlet implementation class CheckEmpServlet
 */
@WebServlet("/check/checkemp.do")
public class CheckEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	CheckService checkService = new CheckService();
	 	EmpService empService = new EmpService();
	 	
	 	int empid = Integer.parseInt(request.getParameter("empid"));
		
	 	List<CheckDTO> checkemp = checkService.checkEmp(empid);
	 	EmpDTO emplist = empService.empidCheck(empid);
	 	
	 	request.setAttribute("emplist", emplist);
		request.setAttribute("checkemp", checkemp);
		
		request.getRequestDispatcher("checkemp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
