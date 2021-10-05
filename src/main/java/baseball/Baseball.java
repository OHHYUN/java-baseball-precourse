package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
	static String computer;

	//문자열 입력 및 검증
	public String inputMessage() {
		String s = Console.readLine();
		//숫자이고 3글자 검증
		if (!s.matches("^[0-9]{3}$")) {
			System.out.println("[ERROR] : 3자리 숫자를 입력해주세요"); // 텍스트 상수 처리를 하면 좋을까요?
			s = inputMessage();
		}
		return s;
	}
	//고유한 숫자를 param 의 갯수만큼 뽑는다.
	public int pickUniqueNumber() {
		int num;
		//숫자가 중복이라면 반복
		do{
			num = Randoms.pickNumberInRange(100,999);
		}while(!isUnique(num));
		return num;
	}
	//유니크값인지 아닌지 확인
	public boolean isUnique(int param){
		boolean result = false;
		char[] numArr = Integer.toString(param).toCharArray();
		if(numArr[0]!=numArr[1] && numArr[0]!=numArr[1] && numArr[1]!=numArr[2]){
			result = true;
		}
		return result;
	}

	public List<String> intList() {
		//중복되는 숫자가 없도록 하는 배열
		List<String> numList = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			numList.add(Integer.toString(i));
		}
		return numList;
	}

	public String game() {
		//숫자를 고른다.
		String computer = Integer.toString(pickUniqueNumber());
		//    System.out.println("computer = " + computer);
		Judge judge = new Judge();
		//값을 입력하며 볼 스트라이크 판별
		while (judge.getStrike() < 3) {
			judge = judge(computer, judge);
			System.out.println(judge.toString());
		}
		System.out.println("게임 끝");
		String s = Console.readLine();
		return s;
	}

	public void play() {
		String s = game();
		boolean restart = s.matches("^[1]$");
		boolean exit = s.matches("^[2]$");
		//equals 로 비교하기
		while (restart) {
			s = game();
			restart = s.matches("^[1]$");
		}
	}

	public Judge judge(String computer, Judge judge) {
		String player = inputMessage();
		char[] cChar = computer.toCharArray();
		char[] pChar = player.toCharArray();
		int ball = 0;
		int strike = 0;
		//같은 수 같은자리 (스트라이크 검증)
		for (int i = 0; i < 3; i++) {
			//같은 수 다른자리 ( 볼 검증)
			for (int j = 0; j < 3; j++) {
				if (cChar[i] == pChar[j]) {
					ball++;
					if (i == j) {
						ball--;
						strike++;
					}
				}
			}
		}
		judge.setBall(ball);
		judge.setStrike(strike);
		return judge;
	}

}
