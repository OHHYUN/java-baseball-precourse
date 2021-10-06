package baseball;

import baseball.message.Message;
import baseball.model.Ball;
import baseball.model.JudgeResult;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Baseball {

	private static final int GAME_END_CONDITION = 3;
	private static final String RESTART_GAME = "1";
	private static final String END_GAME = "2";

	// 문자열 입력 및 검증
	public String inputMessage() {
		String inputVal = Console.readLine();
		// 숫자이고 3글자 검증
		if (!inputVal.matches("^[0-9]{3}$")) {
			printMsg(Message.ERROR_THREE_DIGIT);
			// System.out.println("[ERROR] : 3자리 숫자를 입력해주세요"); // 텍스트 상수 처리를 하면 좋을까요?
			inputVal = inputMessage();
		}
		return inputVal;
	}

	// 고유한 숫자를 param 의 갯수만큼 뽑는다.
	public int pickUniqueNumber() {
		int num;
		// 숫자가 중복이라면 반복
		do {
			num = Randoms.pickNumberInRange(100, 999);
		} while (!isUnique(num));
		return num;
	}

	// 유니크값인지 아닌지 확인
	public boolean isUnique(int param) {
		boolean result = false;
		char[] numArr = Integer.toString(param).toCharArray();
		if (numArr[0] != numArr[1] && numArr[0] != numArr[1] && numArr[1] != numArr[2]) {
			result = true;
		}
		return result;
	}

	public String startGame() {
		// 숫자를 고른다.
		String computer = Integer.toString(pickUniqueNumber());
		int strikeCnt = 0;
		// 스트라이크가 3이라면 경기를 종료합니다.
		while (strikeCnt < GAME_END_CONDITION) {
			JudgeResult judgeResult = new JudgeResult();
			judgeResult = judgeBall(computer, judgeResult);
			strikeCnt = judgeResult.getStrike();
			System.out.println(judgeResult.toString());
		}
		printMsg(Message.END_GAME, Message.WHEATHER_RESTART);
		return whetherRestart();
	}

	//재시작 할지 말지 정하는 메소드
	public String whetherRestart(){
		String result = Console.readLine();
		if(!result.equals(RESTART_GAME) && !result.equals(END_GAME)){
			printMsg(Message.ERROR_RESTART);
			result = whetherRestart();
		}
		return result;
	}
	public void playGame() {
		String condition;
		do {
			condition = startGame();
		} while (condition.equals(RESTART_GAME));
	}

	public JudgeResult judgeBall(String comNums, JudgeResult judgeResult) {
		// 사용자가 입력값을 입력한다.
		String playerNums = inputMessage();
		char[] comNum = comNums.toCharArray();
		char[] playerNum = playerNums.toCharArray();
		for (int i = 0; i < 3; i++) {
			Ball ball = new Ball(comNum[i], isEqualNum(comNum[i], playerNum[i])); //스트라이크 검증
			ball.setBall(isBall(ball, playerNum)); //볼 검증
			judgeResult.addStrike(ball.getStrike());
			judgeResult.addBall(ball.getBall());
		}
		return judgeResult;
	}

	// 숫자가 일치여부, 스트라이크 여부 확인과 볼 검증 여부에서 사용한다.
	public int isEqualNum(int player, char computer) {
		int result = 0;
		if (player == computer) {
			result = 1;
		}
		return result;
	}

	// 볼인지 아닌지 확인하는 메소드 스트라이크 값이 있다면 0을 리턴합니다.
	public int isBall(Ball ball, char[] computer) {
		int result = 0;
		if (ball.getStrike() > 0) {
			return 0;
		}
		for (int i = 0; i < 3; i++) {
			result += isEqualNum(ball.getNum(), computer[i]);
		}
		return result;
	}

	//메세지를 출력하기 위한 메소드
	public void printMsg(Message... args){
		for(Message msg : args){
			System.out.println(msg.getMsg());
		}
	}
}
