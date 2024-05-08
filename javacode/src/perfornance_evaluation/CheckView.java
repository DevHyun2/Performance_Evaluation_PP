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

	public static void print2(List<JoinCheckPerfDTO> scoreCheck, String title) {
		System.out.printf("--------%s--------\n", title);

		scoreCheck.stream().forEach(i -> System.out.println(i));
	}

	public static void print2(JoinCheckPerfDTO scoreCheck, String title) {
		System.out.printf("--------%s--------\n", title);

		System.out.println(scoreCheck);
	}

	public static void print3(int scoreDelete, String title) {
		System.out.printf("--------%s--------\n", title);
	}

	public static void print4(List<ScoreCheckDTO> empid, String title) {
		// TODO Auto-generated method stub
		System.out.printf("--------%s--------\n", title);
		empid.stream().forEach(i -> System.out.println(i));
	}


}
