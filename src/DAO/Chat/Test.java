//package DAO.Chat;
//
//import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
//import org.apache.hc.client5.http.impl.classic.HttpClients;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class Test {
//    public static void main(String[] args) throws IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        String apiKey = "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";
//        CustomChatGpt customChatGpt = new CustomChatGpt(apiKey);
//        // 根据自己的网络设置吧
//        customChatGpt.setResponseTimeout(200000);
//        while (true) {
//            System.out.print("\n请输入问题(q退出)：");
//            String question = new Scanner(System.in).nextLine();
//            if ("q".equals(question)) break;
//            long start = System.currentTimeMillis();
//            String answer = customChatGpt.getAnswer(httpClient, question);
//            long end = System.currentTimeMillis();
//            System.out.println("该回答花费时间为：" + (end - start) / 1000.0 + "秒");
//            System.out.println(answer);
//        }
//        httpClient.close();
//    }
//}
