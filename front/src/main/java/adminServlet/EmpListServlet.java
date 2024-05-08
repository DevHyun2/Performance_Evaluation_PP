package adminServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import performance_evaluation.EmpDTO;
import performance_evaluation.EmpService;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/admin/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService service = new EmpService();
		List<EmpDTO> emplist = service.selectAll();
		request.setAttribute("emplist", emplist);
		
		RequestDispatcher rd = request.getRequestDispatcher("emplist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
