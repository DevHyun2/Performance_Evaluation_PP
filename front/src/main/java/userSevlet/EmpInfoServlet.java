package userSevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import performance_evaluation.JoinCheckPerfDTO;
import performance_evaluation.ScoreCheckDTO;
import performance_evaluation.SelfService;



/**
 * Servlet implementation class EmpInfoServlet
 */
@WebServlet("/empinfo/myinfo.do")
public class EmpInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SelfService service = new SelfService();
		HttpSession session = request.getSession();
		
		int userid = (int)session.getAttribute("userid");
		
		List<JoinCheckPerfDTO> search = service.scoreSearch(userid);
		List<ScoreCheckDTO> score = service.scoreAvg(userid);
		request.setAttribute("search", search);
		request.setAttribute("score", score);
		
		request.getRequestDispatcher("myinfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		
//		
//		int userid = (int)session.getAttribute("userid");
		
	}

}
