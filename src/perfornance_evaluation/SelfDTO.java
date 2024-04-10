package perfornance_evaluation;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SelfDTO {
	private int self_id;		//자기 평가 번호
	private int employee_id;	//사원 번호
	private int check_id;		//평가 번호
	private int score;			//점수
	private int self_year;		//자기 평가 년도
	
	
}
