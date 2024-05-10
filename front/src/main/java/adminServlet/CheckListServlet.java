package adminServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import performance_evaluation.CheckDTO;
import performance_evaluation.CheckService;

/**
 * Servlet implementation class CheckListServlet
 */
@WebServlet("/check/checklist.do")
public class CheckListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckService service = new CheckService();
		List<CheckDTO> checklist = service.selectAll();
		request.setAttribute("checklist", checklist);
		
		RequestDispatcher rd = request.getRequestDispatcher("checklist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
