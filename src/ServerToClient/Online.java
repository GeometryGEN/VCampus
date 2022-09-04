package ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * 在线列表
 *
 * @author Shuheng_Gu
 * @date 2022/09/03
 */
public class Online implements Serializable {
    /**
     * 用户id
     */
    private String id;
    /**
     * 用户类型 0=student,1=teacher,2=admin
     */
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
