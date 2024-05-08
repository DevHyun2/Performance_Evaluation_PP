package perfornance_evaluation;

import java.util.List;

public class EmpView {

	public static void print(List<EmpDTO> emplist, String title) {

		System.out.printf("--------%s--------\n", title);

		emplist.stream().forEach(emp -> System.out.println(emp));
	}

	public static void print(EmpDTO empidCheck, String title) {
		
		System.out.printf("--------%s--------\n", title);
		System.out.println(empidCheck);
	}
}
