package DAO.Chat;

import java.io.IOException;
import java.util.Scanner;

public class QuestionModule {
    QuestionModule(double timeConsuming,String answer){
        this.timeConsuming = timeConsuming;
        this.answer = answer;
    }
    public double timeConsuming;
    public String answer;

    public static void main(String[] args) throws IOException {
        AskQuestion askQuestion = new AskQuestion();
        QuestionModule questionModule;
        while (true) {
            System.out.print("\n你有什么想问我的嘛？如果想退出系统，请输入‘q’哦！^_^\n");
            String question = new Scanner(System.in).nextLine();
            if(question.equals("q")){
                break;
            }
            questionModule = askQuestion.Ask(question);
            System.out.println("本次回答花费：" + questionModule.timeConsuming + "秒。虽然有点慢，但我尽力了呢~ ^.^");
            System.out.println(questionModule.answer);
        }

    }

}
