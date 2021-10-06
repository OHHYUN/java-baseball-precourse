package baseball.core;

import static baseball.util.msgUtil.*;

import baseball.message.Message;
import nextstep.utils.Console;

public class PlayerRole {

	// 문자열 입력 및 검증 사용자 입력값
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


}
