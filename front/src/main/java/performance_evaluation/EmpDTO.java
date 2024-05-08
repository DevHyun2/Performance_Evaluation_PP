package performance_evaluation;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {
	
	private int employee_id;		//사원번호
	private String name;			//사원명
	private String birthdate;		//생년월일
	private int employee_pw;		//사원PW
	private String department;		//부서명
	private String rank;			//직급
	private Date join_date;			//입사일
	private int admin_id;			//관리자ID
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("직원정보 [사원번호= ").append(employee_id).append(", 사원명= ").append(name).append(", 생년월일= ")
				.append(birthdate).append(", 부서명= ").append(department).append(", 직급= ")
				.append(rank).append(", 입사일= ").append(join_date).append("]");
		return builder.toString();
	}
	
}
