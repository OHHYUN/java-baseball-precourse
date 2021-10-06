package baseball.model;

public class JudgeResult {

	private int strike;
	private int ball;

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	public void addBall(int ball) {
		this.ball += ball;
	}

	public void addStrike(int strike) {
		this.strike += strike;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (strike > 0) {
			sb.append(strike + "스트라이크 ");
		}
		if (ball > 0) {
			sb.append(ball + "볼");
		}
		if (strike == 0 && ball == 0) {
			sb.append("낫싱");
		}
		return sb.toString();
	}
}
