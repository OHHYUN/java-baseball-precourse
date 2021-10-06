package baseball.message;

public enum Message {

	ERROR_THREE_DIGIT("[ERROR] : 3자리 숫자를 입력해주세요"),
	END_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 끝"),
	WHEATHER_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
	ERROR_RESTART("[ERROR] 1이나 2를 입력해주세요.");
	// public static final String ERROR_THREE_DIGIT = "[ERROR] : 3자리 숫자를 입력해주세요";
	// public static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
	// public static final String WHETHER_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	// public static final String ERROR_RESTART = ;

	private final String msg;

	Message(String msg){
		this.msg = msg;
	}
	public String getMsg(){
		return this.msg;
	}
}
