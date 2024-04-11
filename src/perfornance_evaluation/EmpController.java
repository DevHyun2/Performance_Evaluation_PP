package perfornance_evaluation;

import java.util.List;
import java.util.Scanner;
public class EmpController {

	static Scanner sc = new Scanner(System.in);
	static EmpService empService = new EmpService();
	static CheckController checkController = new CheckController();
	static SelfController selfController = new SelfController();
	static int employee_id = 0;
	//메인 시작 메뉴
	public static void main(String[] args) {

		boolean isStop = false;

		while (!isStop) {
			int selectJob = menuDisplay();

			switch (selectJob) {
			case 1 -> {
				System.out.println("----ID와 PW를 입력해 주세요----");
				System.out.print("ID : ");
				int adminid = sc.nextInt();
				System.out.print("PW : ");
				int emppw = sc.nextInt();

				boolean loginSuccess = adminLogin(sc, empService, adminid, emppw);
				if (loginSuccess) {
				    // 로그인 성공한 경우의 처리
					handleSubMenu(sc);
				} else {
				    // 로그인 실패한 경우의 처리
					System.out.println("프로그램을 종료합니다.");
					isStop = true;
				}
				
			}

			case 2 -> {
				System.out.println("--------사원 로그인---------");
				System.out.println("----ID와 PW를 입력해 주세요----");
				System.out.print("ID : ");
				int empid = sc.nextInt();
				System.out.print("PW : ");
				int emppw = sc.nextInt();
				boolean loginSuccess = empLogin(sc, empService, empid, emppw);
				if (loginSuccess) {
				    // 로그인 성공한 경우의 처리
					employee_id = empid;
					handleSubMenu2(sc);
				} else {
				    // 로그인 실패한 경우의 처리
					System.out.println("프로그램을 종료합니다.");
					isStop = true;
				}
			}

			case 3 -> {
				isStop = true;
			}

			default -> {
				System.out.println("없는 번호 입니다. 다시 선택해 주세요.");
			}

			}
			System.out.println("----------인사평가 프로그램 종료---------\n");
		}
	}

	//시작 메뉴
	private static int menuDisplay() {
		System.out.println("----------[신한DS 인사평가]----------");
		System.out.println("---------서비스를 선택해주세요---------\n");
		System.out.println("1.관리자 로그인 | 2.사원 로그인 | 3. 종료\n");
		System.out.println("----------------------------------");
		System.out.print("작업선택 > ");
		int job = sc.nextInt();
		return job;
	}
	
	//adminlogin
	public static boolean adminLogin(Scanner sc, EmpService empService, int adminid, int emppw) {
		int count = 0;
		boolean loginSuccess = false;
		while (count < 3) {
			int select = empService.selectAdminLog(adminid, emppw);
			if (select == 1) {
				System.out.println("-------로그인 성공-------\n");
				loginSuccess = true;
				break;
			} else {
				count++;
				System.out.printf("남은 로그인 기회 : %d\n", 3 - count);
				System.out.println("----ID와 PW를 다시 입력해 주세요----");
				System.out.print("ID : ");
				adminid = sc.nextInt();
				System.out.print("PW : ");
				emppw = sc.nextInt();
			}
		}
		if (!loginSuccess) {
			System.out.println("로그인 기회를 모두 사용하셨습니다.");
		}
		return loginSuccess;
	}
	
	//관리자 로그인 성공시
	private static void handleSubMenu(Scanner sc) {
		boolean isSubMenuStop = false;
		while (!isSubMenuStop) {
			// 새로운 메뉴 표시
			int subMenuSelect = subMenuDisplay();
			switch (subMenuSelect) {
			case 1 -> {
				handleSubMenu3();
				}
			
			case 2 -> {
				checkController.checkLists();
				}
			
			case 3 -> {
				checkController.insertCheck();
			}
			
			case 4 -> {
				checkController.deleteCheck();
			}
			
			case 5 -> {
				Check();
			}
			
			case 6 -> {isSubMenuStop = true;}
			
			default -> {
				System.out.println("없는 번호 입니다. 다시 선택해 주세요.");
			}
			
			}
		}
	}
	//관리자 점수 메뉴
	private static void Check() {
		boolean isSubMenuStop = false;
		while (!isSubMenuStop) {
			int subMenuSelect = subCheckDisplay();
			switch(subMenuSelect) {
			case 1 -> {
				checkController.scoreCheck();
			}
			
			case 2 -> {
				checkController.scoreInsert();
			}
			
			case 3 -> {
				checkController.scoreUpdate();
			}
			
			case 4 -> {
				checkController.scoreDelete();
			}
			
			case 5 -> {
				isSubMenuStop = true;
			}
			
			default -> {
				System.out.println("없는 번호 입니다. 다시 선택해 주세요.");
			}
			
			}
		}
		
	}

	//관리자 점수 메뉴
	private static int subCheckDisplay() {
		System.out.println("----------서비스를 선택해주세요----------\n");
		System.out.println("(1)평가 점수 조회\n(2)평가 하기\n(3)평가 수정\n(4)평가 삭제\n(5)뒤로가기\n");
		System.out.println("------------------------------------");
		System.out.print("작업선택 > ");
		int job = sc.nextInt();
		return job;
	}

	//관리자 서비스
	private static int subMenuDisplay() {
		System.out.println("----------서비스를 선택해주세요----------\n");
		System.out.println("(1)사원 조회\n(2)평가 항목 조회\n(3)인사평가 항목 생성\n(4)평가항목 제거\n(5)평가\n(6)로그아웃\n");
		System.out.println("------------------------------------");
		System.out.print("작업선택 > ");
		int job = sc.nextInt();
		return job;
	}
		
	//관리자 사원 서비스
	private static void handleSubMenu3() {
		boolean isSubMenuStop = false;
		while (!isSubMenuStop) {
			// 새로운 메뉴 표시
			int subMenuSelect = subMenuDisplay3();
			switch (subMenuSelect) {
			case 1 -> {
				System.out.print("조회할 직원번호 >> ");
				int empid = sc.nextInt();
				EmpDTO employee = empService.empidCheck(empid);
				if (employee != null) {
				    EmpView.print(employee, empid + "번 사원 조회");
				} else {
				    System.out.println(empid + "번 사원이 존재하지 않습니다");
				}
			}
			
			case 2 -> {
				System.out.print("조회할 부서명 >> ");
				String dept = sc.next();
				List<EmpDTO> resultList = empService.deptCheck(dept);
				if (!resultList.isEmpty()) {
				    EmpView.print(resultList, dept + "조회");
				} else {
				    System.out.println(dept + " 부서가 존재하지 않습니다");
				}			}
			
			case 3 -> {
				System.out.print("조회할 직급 >> ");
				String rank = sc.next();
				List<EmpDTO> resultList = empService.rankCheck(rank);
				if (!resultList.isEmpty()) {
				    EmpView.print(resultList, rank + "조회");
				} else {
				    System.out.println(rank + " 직급에 해당하는 사원이 존재하지 않습니다");
				}
			}
			
			case 4 -> {isSubMenuStop = true;}
			
			default -> {
				System.out.println("없는 번호 입니다. 다시 선택해 주세요.");
			}
			
			}
		}
	}
	//관리자 사원조회 서비스
	private static int subMenuDisplay3() {
		System.out.println("----------조회할 항목을 선택해주세요----------\n");
		System.out.println("(1)사원 조회\n(2)부서 조회\n(3)직급 조회\n(4)뒤로가기\n");
		System.out.println("------------------------------------");
		System.out.print("작업선택 > ");
		int job = sc.nextInt();
		return job;
	}
		
	//emplogin
	private static boolean empLogin(Scanner sc, EmpService empService, int empid, int emppw) {
		int count = 0;
		boolean loginSuccess = false;
		while (count < 3) {
			int select = empService.selectEmpLog(empid, emppw);
			if (select == 1) {
				System.out.println("-------로그인 성공-------\n");
				loginSuccess = true;
				break;
			} else {
				count++;
				System.out.printf("남은 로그인 기회 : %d\n", 3 - count);
				System.out.println("----ID와 PW를 다시 입력해 주세요----");
				System.out.print("ID : ");
				empid = sc.nextInt();
				System.out.print("PW : ");
				emppw = sc.nextInt();
			}
		}
		if (!loginSuccess) {
			System.out.println("로그인 기회를 모두 사용하셨습니다.");
		}
		return loginSuccess;
	}

	//사원 로그인 성공시
	private static void handleSubMenu2(Scanner sc) {
		boolean isSubMenuStop = false;
		while (!isSubMenuStop) {
			// 새로운 메뉴 표시
			int subMenuSelect = subMenuDisplay2();
			switch (subMenuSelect) {
			case 1 -> {
				selfController.scoreSearch(employee_id);
			}
			/*
			case 2 -> {
				selfController.selfSearch();
			}
			
			case 3 -> {
				selfController.selfInsert();
			}
			
			case 4 -> {
				selfController.selfDelete();
			}
			
			case 5 -> {
				selfController.selfUpdate();
			}
			*/
			case 2 -> {isSubMenuStop = true;}
			
			default -> {
				System.out.println("없는 번호 입니다. 다시 선택해 주세요.");
			}
			
			}
		}
	}
	
	//사원 서비스
	private static int subMenuDisplay2() {
		System.out.println("------------서비스를 선택해주세요------------\n");
		System.out.println("(1)평가 점수 조회\n(2)로그아웃\n");
		System.out.println("----------------------------------------");
		System.out.print("작업선택 > ");
		int job = sc.nextInt();
		return job;
	}
}
