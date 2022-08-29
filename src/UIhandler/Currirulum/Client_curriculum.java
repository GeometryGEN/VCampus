package UIhandler.Currirulum;

import utils.MyObjectOutputStream;

import java.io.IOException;
import java.net.Socket;

public class Client_curriculum {

    String id;
    static MyObjectOutputStream oos=null;

    public void setId(String id) {
        this.id = id;
    }

    public static void setOos(Socket s) throws IOException {
        oos = (MyObjectOutputStream) s.getOutputStream();
    }
}
