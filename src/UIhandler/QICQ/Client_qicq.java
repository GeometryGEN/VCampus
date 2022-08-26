package UIhandler.QICQ;

import ClientToServer.ManageClientToServerThread;
import DAO.QICQ.Filetrans;
import message.Message;
import message.MessageType;

import java.io.*;

public class Client_qicq {
    public void send_file(String src,String sender,String getter){
        Message message=new Message();
        message.setSender(sender);
        message.setGetter(getter);
        message.setType(MessageType.MESSAGE_QICQ_SEND_FILE);
        FileInputStream fileInputStream=null;
        byte[] filebytes=new byte[(int)new File(src).length()];
        try {
            fileInputStream =new FileInputStream(src);
            fileInputStream.read(filebytes);
            Filetrans file=new Filetrans();
            file.setContent(filebytes);
            message.setData(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(ManageClientToServerThread.getThread(sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
