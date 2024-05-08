package perfornance_evaluation;

import java.util.List;

public class SelfService {

		static SelfDAO selfDAO = new SelfDAO();
	//평가 점수 조회
		 static List<JoinCheckPerfDTO> scoreSearch(int empid) {
			 return selfDAO.scoreSearch(empid);
		 }
	//평균 점수
	public List<ScoreCheckDTO> scoreAvg(int employee_id) {	
		return selfDAO.scoreAvg(employee_id);
	}
}
