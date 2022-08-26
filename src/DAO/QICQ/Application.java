package DAO.QICQ;

public class Application {
    String from_id;
    String from_name;
    int status; //0=waiting 1=denied 2=accepted

    public Application(String from_id, String from_name) {
        this.from_id = from_id;
        this.from_name = from_name;
        this.status = 0;
    }
}
