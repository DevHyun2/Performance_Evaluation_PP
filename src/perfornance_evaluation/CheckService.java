package perfornance_evaluation;

import java.util.List;

public class CheckService {
	
	CheckDAO checkDAO = new CheckDAO();
	
	//전체 평가 항목 조회
	public List<CheckDTO> selectAll() {
		
		return checkDAO.selectAll();
	}
		
	//직급별 항목 조회
	public List<CheckDTO> rankCheck(String ran) {
		return checkDAO.rankCheck(ran);
	}
	
	//직급별 항목 조회
	public List<CheckDTO> deptCheck(String dept) {
		return checkDAO.deptCheck(dept);
	}
	
	//평가 항목 생성(Insert)
	public int insertCheck(CheckDTO check) {
		return checkDAO.insertCheck(check);
	}
	
	//평가 항목 제거(Delete)
	int deleteCheck(int checkid) {
		return checkDAO.deleteCheck(checkid);
	}
	
	//평가 하기(Insert)
	public int scoreInsert(PerformancesDTO perfDTO) {
		return checkDAO.scoreInsert(perfDTO);
	}
	
	//평가 수정(Update)
	public int scoreUpdate(int reviewid, int score) {
		return checkDAO.scoreUpdate(reviewid, score);
	}
	
	//평가 점수 조회
	public List<JoinCheckPerfDTO> scoreCheck(int empid) {
		// TODO Auto-generated method stub
		return checkDAO.scoreCheck(empid);
	}
	
	//평가 항목 제거
	int scoreDelete(int reviewid) {
		return checkDAO.scoreDelete(reviewid);
	}
}
