package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baseball {
  static String computer;

  //문자열 입력 및 검증
  public String inputMessage(){
    String s = Console.readLine();
    //숫자이고 3글자 검증
    if(!s.matches("^[0-9]{3}$")){
      System.out.println("[ERROR] : 3자리 숫자를 입력해주세요");
      s = inputMessage();
    }
    return s;
  }

  //컴퓨터의 숫자를 뽑는 함수
  //3개를 뽑으면서 위에 있는 배열에 존재하면 제거한다. 존재하지 않는다면 계속 루프를 돌며 숫자를 뽑는다.
  public void pick(){
    List<String> numList = intList();
    StringBuilder sb = new StringBuilder();
    //숫자를 3개 뽑을때까지 반복
    while(sb.length()<3){
      String a = Integer.toString(Randoms.pickNumberInRange(1, 9));
      if(numList.contains(a)){
        sb.append(a);
        numList.remove(a);
      }
    }
  }
  public List<String> intList(){
    //중복되는 숫자가 없도록 하는 배열
    List<String> numList = new ArrayList<>();
    for(int i=1; i<=9; i++){
      numList.add(Integer.toString(i));
    }
    return numList;
  }
  public void play(){
//    if(!inputMessage()){
//
//    }
  }

  public String Judge(int player, int computer){
    String result = "";

    return result;
  }

}
