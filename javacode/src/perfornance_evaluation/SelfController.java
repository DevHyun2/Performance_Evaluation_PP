package perfornance_evaluation;

import java.util.Scanner;

public class SelfController {
	static Scanner sc = new Scanner(System.in);
	static SelfService selfService = new SelfService();
	
	//평가 점수 조회
	static void scoreSearch(int employee_id) {
		SelfService.scoreSearch(employee_id);
		CheckView.print2(selfService.scoreSearch(employee_id), "점수 조회");
		scoreAvg(employee_id);
	}
	
	//평균 점수
	public static void scoreAvg(int employee_id) {
		//CheckView.print3(employee_id, "평균점수");
		CheckView.print4(selfService.scoreAvg(employee_id), "평균점수");
	}
	
	//자기 평가 항목 조회
	static void selfSearch() {
		// TODO Auto-generated method stub
		
	}
	
	//자기 평가 항목 생성
	static void selfInsert() {
		// TODO Auto-generated method stub
		
	}
	
	//자기 평가 항목 제거
	static void selfDelete() {
		// TODO Auto-generated method stub
		
	}
	
	//자기 평가 하기
	public void selfUpdate() {
		// TODO Auto-generated method stub
		
	}

}
