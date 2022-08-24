package ServerToClient;

public class Online {
    private String id;
    private int type; //0=student,1=teacher,2=admin

    public Online(String id, int type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
