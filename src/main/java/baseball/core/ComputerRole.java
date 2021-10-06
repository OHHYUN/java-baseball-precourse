package baseball.core;

import nextstep.utils.Randoms;

public class ComputerRole {

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
}
