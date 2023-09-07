package DAO.Chat;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;
import java.util.Scanner;

public class AskQuestion {
    public static CloseableHttpClient httpClient;
    public String apiKey;
    public static CustomChatGpt customChatGpt;

    AskQuestion(){
        httpClient = HttpClients.createDefault();
        apiKey = "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";
        customChatGpt = new CustomChatGpt(apiKey);
        customChatGpt.setResponseTimeout(200000);
    }
    public QuestionModule Ask(String question){
        long start = System.currentTimeMillis();
        String answer = customChatGpt.getAnswer(httpClient, question);
        long end = System.currentTimeMillis();
        double timeConsuming = (end-start)/1000.0;
        QuestionModule questionModule = new QuestionModule(timeConsuming,answer);
        return questionModule;
    }

    public void finish() throws IOException {
        httpClient.close();
    }
    public static void main(String[] args) throws IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        String apiKey = "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";
//        CustomChatGpt customChatGpt = new CustomChatGpt(apiKey);
//        customChatGpt.setResponseTimeout(200000);
        while (true) {
            System.out.print("\n你有什么想问我的嘛？如果想退出系统，请输入‘q’哦！^_^\n");
            String question = new Scanner(System.in).nextLine();
            if ("q".equals(question)) break;
            long start = System.currentTimeMillis();
            String answer = customChatGpt.getAnswer(httpClient, question);
            long end = System.currentTimeMillis();
            System.out.println("本次回答花费：" + (end - start) / 1000.0 + "秒。虽然有点慢，但我尽力了呢~ ^.^");
            System.out.println(answer);
        }
        httpClient.close();
    }
}
