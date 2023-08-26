import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.GeneralSecurityException;

public class Main {
    public static void main(String[] args) throws MessagingException, GeneralSecurityException {
        test04();
    }
    public static void test01() {
        Address a = new Address();
        a.test01();
    }
    public static void test02(){
        MyServer tcp = new MyServer();
        tcp.start();
    }

    public static void test03() {
        MyClient client = new MyClient();

    }

    public static void test04() throws MessagingException, GeneralSecurityException {
        Mail mail = new Mail();
        mail.SendEmail();
    }
}