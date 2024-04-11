package perfornance_evaluation;

import java.util.List;
import java.util.Scanner;

public class CheckController {

	static Scanner sc = new Scanner(System.in);
	static CheckService checkService = new CheckService();
	static EmpController empController = new EmpController();

	static void checkLists() {
		
		
		boolean isStop = false;
		
		while(!isStop) {
			int selectJob = menuSubDisplay();
			
			switch(selectJob) {
			case 1 -> {
				List<CheckDTO> checklist = checkService.selectAll();
				CheckView.print(checklist, "모든 평가 항목 조회");
			}
			
			case 2 -> {
				System.out.print("조회할 부서명 >> ");
				String dept = sc.next();
				List<CheckDTO> resultList = checkService.deptCheck(dept);
				if(resultList.isEmpty()) {
					System.out.println("조회할 부서가 존재하지 않습니다.");
				} else {
					CheckView.print(checkService.deptCheck(dept), dept + "조회");
				}
			}
			
			case 3 -> {
				System.out.print("조회할 직급 >> ");
				String rank = sc.next();
				List<CheckDTO> resultList = checkService.rankCheck(rank);
				if (resultList.isEmpty()) {
				    System.out.println("조회할 직급이 존재하지 않습니다.");
				} else {
				    CheckView.print(resultList, rank + " 조회");
				}
			}
			
			case 4 -> {isStop = true;}
			
			default -> {
				System.out.println("없는 번호 입니다. 다시 선택해 주세요.");
			}
			
			
			}
		}
	}

	private static int menuSubDisplay() {
		System.out.println("----------조회할 항목을 선택해주세요----------\n");
		System.out.println("(1)전체 항목 조회\n(2)부서별 항목 조회\n(3)직급별 항목 조회\n(4)뒤로가기\n");
		System.out.println("------------------------------------");
		System.out.print("작업선택 > ");
		int job = sc.nextInt();
		return job;
	}
	
	//평가 항목 생성
	static void insertCheck() {
		CheckDTO check =  insertMenu();
		int result = checkService.insertCheck(check);
		CheckView.print(result > 0? "생성완료":"생성실패");
	}

	private static CheckDTO insertMenu() {
		System.out.print("평가 부서 >> ");
		String checkdept = sc.nextLine();
		System.out.print("평가 직급 >> ");
		String rank = sc.nextLine();
		System.out.print("평가 항목 >> ");
		String checkName = sc.nextLine();
		System.out.print("평가 내용 >> ");
		String descrip = sc.nextLine();
		
		CheckDTO check = new CheckDTO();
		check.setDepartment(checkdept);
		check.setRank(rank);
		check.setCheck_name(checkName);
		check.setDescription(descrip);
		
		return check;
	}
	
	//평가 항목 제거
	static void deleteCheck() {
		System.out.print("삭제할 평가 문항 >> ");
		int checkid = sc.nextInt();
		int result = checkService.deleteCheck(checkid);
		CheckView.print(result > 0? "삭제완료":"삭제실패");
	}
	
	//평가 하기
	public static void scoreInsert() {
		PerformancesDTO perf = insertScore();
		int result = checkService.scoreInsert(perf);
		CheckView.print(result > 0? "평가완료":"평가실패");
	}
	
	private static PerformancesDTO insertScore() {
		System.out.print("평가 할 사원번호 >> ");
		int empid = sc.nextInt();
		System.out.print("평가 할 항목번호 >> ");
		int checkNum = sc.nextInt();
		System.out.print("평가 점수 >> ");
		int score = sc.nextInt();
		System.out.print("평가 년도 >> ");
		int year = sc.nextInt();
		PerformancesDTO perfDTO = new PerformancesDTO();
		perfDTO.setEmployee_id(empid);
		perfDTO.setCheck_id(checkNum);
		perfDTO.setScore(score);
		perfDTO.setReview_year(year);
		
		return perfDTO;
	}

	//평가 수정
	public void scoreUpdate() {
		System.out.print("수정 할 평가점수 번호 >> ");
		int reviewid = sc.nextInt();
		System.out.print("수정 할 점수 >> ");
		int score = sc.nextInt();
		int result = checkService.scoreUpdate(reviewid, score);
		CheckView.print(result > 0?"수정완료":"수정실패");
		
	}

	//평가 점수 조회
	public void scoreCheck() {
		System.out.print("조회 할 사원번호 >> ");
		int empid = sc.nextInt();
		List<JoinCheckPerfDTO> resultList = checkService.scoreCheck(empid);
		if (resultList.isEmpty()) {
		    System.out.println("조회할 사원 번호가 존재하지 않습니다.");
		} else {
		    CheckView.print2(resultList, empid + "번 사원 평가점수 조회");
		}
	}
	//평가 점수 삭제
	public void scoreDelete() {
		System.out.print("삭제 할 평가점수 번호 >> ");
		int reviewid = sc.nextInt();
		int deletedRows = checkService.scoreDelete(reviewid);
		if (deletedRows > 0) {
		    System.out.println(reviewid + "번 평가 삭제 완료");
		} else {
		    System.out.println("삭제할 평가 번호가 존재하지 않습니다.");
		}
	}
	
	
}
