package UIhandler.StatusManagement;

import ClientToServer.ManageClientToServerThread;
import User.Student;
import message.Message;
import message.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client_status {

    static String id;
    public static boolean getphoto(String idcard) throws Exception {

        Message message = new Message();
        message.setType(MessageType.RETURN_PHOTO);
        message.setSender(idcard);
        ObjectOutputStream oos= new ObjectOutputStream(ManageClientToServerThread.getThread(id).getSocket().getOutputStream());
        oos.writeObject(message);

        ObjectInputStream ois = new ObjectInputStream(ManageClientToServerThread.getThread(id).getSocket().getInputStream());        //读取从服务端回复的Message对象
        Message ms = (Message) ois.readObject();
        if(ms.getType().equals(MessageType.RETURN_PHOTO_SUCCEED))
            return true;
        else{
            ManageClientToServerThread.getThread(id).getSocket().close();
            return false;
        }

    }

    public static Student returnStatusInfo(String idcard) throws Exception {
        Message message = new Message();
        message.setType(MessageType.RETURN_STUDENT_INFO);
        message.setSender(idcard);
        //得到Object对象
        ObjectOutputStream oos = new ObjectOutputStream(ManageClientToServerThread.getThread(id).getSocket().getOutputStream());
        //发送学生对象
        oos.writeObject(message);
        //读取从服务端回复的Message对象
        ObjectInputStream ois = new ObjectInputStream(ManageClientToServerThread.getThread(id).getSocket().getInputStream());
        Message ms = (Message) ois.readObject();
        if(ms.getType().equals(MessageType.RETURN_STUDENT_INFO_SUCCEED)){
            return (Student) ms.getData();
        }
        else{
            ManageClientToServerThread.getThread(id).getSocket().close();
            return null;
        }
    }

}
