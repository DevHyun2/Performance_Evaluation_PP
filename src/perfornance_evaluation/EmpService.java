package perfornance_evaluation;

import java.util.List;

public class EmpService {
	
	EmpDAO empDAO = new EmpDAO();
	
	//관리자 로그인
	public int selectAdminLog(int adminid, int emppw) {
		return empDAO.selectAdminLog(adminid, emppw);
	}

	//사원 로그인
		public int selectEmpLog(int empid, int emppw) {
			return empDAO.selectEmpLog(empid, emppw);
		}
	
	// 특정 직원 1명 조회
	public EmpDTO empidCheck(int empid) {
		return empDAO.empidCheck(empid);
	}
		
	//부서별 사원 조회
	public List<EmpDTO> deptCheck(String dept) {
		return empDAO.deptCheck(dept);
	}
	
	//직급별 사원 조회
		public List<EmpDTO> rankCheck(String rank) {
			return empDAO.rankCheck(rank);
		}
}
