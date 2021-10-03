package baseball;

import nextstep.utils.Console;

import java.util.Scanner;

public class Baseball {
  static String computer;
  public String inputMessage(){
    String s = Console.readLine();
    //숫자이고 3글자 검증
    if(!s.matches("^[0-9]{3}$")){
      System.out.println("[ERROR] : 3자리 숫자를 입력해주세요");
      s = inputMessage();
    }
    return s;
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
