package baseball.core;

import baseball.model.Ball;
import baseball.model.JudgeResult;

public class JudgeRole {

	public JudgeResult judgeBall(String comNums, String playerNums) {
		JudgeResult judgeResult = new JudgeResult();
		// 사용자가 입력값을 입력한다.
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
	public int isEqualNum(int playerNum, char comNum) {
		int result = 0;
		if (playerNum == comNum) {
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
