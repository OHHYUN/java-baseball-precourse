package baseball.util;

import baseball.message.Message;

public class msgUtil {
	//메세지를 출력하기 위한 메소드
	public static void printMsg(Message... args){
		for(Message msg : args){
			System.out.println(msg.getMsg());
		}
	}
}
