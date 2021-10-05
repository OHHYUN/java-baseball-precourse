package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Baseball {
	static String computer;

	// 문자열 입력 및 검증
	public String inputMessage() {
		String s = Console.readLine();
		// 숫자이고 3글자 검증
		if (!s.matches("^[0-9]{3}$")) {
			System.out.println("[ERROR] : 3자리 숫자를 입력해주세요"); // 텍스트 상수 처리를 하면 좋을까요?
			s = inputMessage();
		}
		return s;
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
		System.out.println("computer = " + computer);
		JudgeResult judgeResult = new JudgeResult();
		// 스트라이크가 3이라면 경기를 종료합니다.
		while (judgeResult.getStrike() < 3) {
			judgeResult = new JudgeResult();
			judgeResult = judgeBall(computer, judgeResult);
			System.out.println(judgeResult.toString());
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String s = whetherRestart();
		return s;
	}

	//재시작 할지 말지 정하는 메소드
	public String whetherRestart(){
		String result = Console.readLine();
		boolean restart = result.matches("^[1]$");
		boolean exit = result.matches("^[2]$");

		if(!restart && !exit){
			System.out.println("[ERROR] : 1이나 2를 입력해주세요");
			result = whetherRestart();
		}
		return result;
	}
	public void playGame() {
		String s;
		do {
			s = startGame();
		} while (s.equals("1"));
	}

	public JudgeResult judgeBall(String computer, JudgeResult judgeResult) {
		// 사용자가 입력값을 입력한다.
		String player = inputMessage();
		char[] cChar = computer.toCharArray();
		char[] pChar = player.toCharArray();
		for (int i = 0; i < 3; i++) {
			Ball ball = new Ball(cChar[i], isEqualNum(cChar[i], pChar[i])); //스트라이크 검증
			ball.setBall(isBall(ball, pChar)); //볼 검증
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

}
