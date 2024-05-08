package performance_evaluation;

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

@Getter@Setter
class ScoreCheckDTO {
	private int employee_id;
	private int review_year;
	private int average_score;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("평가 점수[사원번호= ").append(employee_id).append(", 평가년도= ").append(review_year)
				.append(", 평균점수= ").append(average_score).append("]");
		return builder.toString();
	}
	
	
}