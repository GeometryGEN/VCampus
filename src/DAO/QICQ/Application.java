package DAO.QICQ;

import java.io.Serializable;

public class Application implements Serializable {
    String from_id;
    String from_name;
    int status; //0=waiting 1=denied 2=accepted
    String to_id;
    String to_name;
    String group;
    public Application(String from_id, String from_name) {
        this.from_id = from_id;
        this.from_name = from_name;
        this.status = 0;
    }
    public Application() {
    }
    public String getTo_id() {
        return to_id;
    }

    public void setTo_id(String to_id) {
        this.to_id = to_id;
    }

    public String getTo_name() {
        return to_name;
    }

    public void setTo_name(String to_name) {
        this.to_name = to_name;
    }

}
