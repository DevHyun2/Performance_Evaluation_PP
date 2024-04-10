package perfornance_evaluation;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CheckDTO {
	private int check_id;			//평가 번호
	private String department;		//부서
	private String rank;			//직급
	private String check_name;		//평가 항목
	private String description;		//평가 내용
	
	@Override
	public String toString() {
		return "[평가 번호= " + check_id + ", 부서= " + department + ", 직급= " + rank + "]" + "[평가 항목= "
				+ check_name + ", 평가 내용= " + description + "]";
	}
	
	
}
