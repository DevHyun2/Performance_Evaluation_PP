package perfornance_evaluation;

import java.util.List;

public class CheckView {

	public static void print(List<CheckDTO> checkList, String title) {

		System.out.printf("--------%s--------\n", title);

		checkList.stream().forEach(i -> System.out.println(i));
	}

	public static void print(Object object) {
		
		System.out.printf("--------%s--------\n", object);
	}
}
