package baseball.model;

public class Ball {

	private int num;
	private int strike;
	private int ball;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStrike() {
		return strike;
	}

	public void setStrike(int strike) {
		this.strike = strike;
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public Ball(int num, int strike) {
		this.num = num;
		this.strike = strike;
	}

}
