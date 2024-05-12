package performance_evaluation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreCheckDTO {
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
