package baseball.core;

import static baseball.util.msgUtil.printMsg;

import baseball.message.Message;
import baseball.model.Ball;
import baseball.model.JudgeResult;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class BaseballGame {

	private static final int GAME_END_CONDITION = 3;
	private static final String RESTART_GAME = "1";
	private static final String END_GAME = "2";

	private PlayerRole playerRole;
	private ComputerRole computerRole;
	private JudgeRole judgeRole;

	public BaseballGame() {
		computerRole = new ComputerRole();
		judgeRole = new JudgeRole();
		playerRole = new PlayerRole();
	}

	public String startGame() {
		// 숫자를 고른다.
		String comNums = Integer.toString(computerRole.pickUniqueNumber());
		int strikeCnt = 0;
		// 스트라이크가 3이라면 경기를 종료합니다.
		while (strikeCnt < GAME_END_CONDITION) {
			String playerNums = playerRole.inputMessage();
			JudgeResult judgeResult = judgeRole.judgeBall(comNums, playerNums);
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


}
