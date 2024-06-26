package performance_evaluation;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class JoinCheckPerfDTO{
	private int review_id;
	private String rank;			//직급
	private String department;		//부서
	private int employee_id;
	private String description;		//평가 내용
	private int review_year;
	private int score;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[점수평가 번호= ").append(review_id).append(", 직급= ").append(rank)
				.append(", 부서명= ").append(department).append(", 사원번호= ").append(employee_id)
				.append("], [평가내용= ").append(description).append(", 평가년도= ").append(review_year)
				.append(", 점수= ").append(score).append("]");
		return builder.toString();
	}

}
