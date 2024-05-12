package performance_evaluation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SelfDTO {
	private int self_id;		//자기 평가 번호
	private int employee_id;	//사원 번호
	private int check_id;		//평가 번호
	private int score;			//점수
	private int self_year;		//자기 평가 년도
	
	
	
}