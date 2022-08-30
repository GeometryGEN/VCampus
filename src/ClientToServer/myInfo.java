package ClientToServer;

public class myInfo {
    static String id;
    static int type; //1-学生 2-老师 3-管理员
    static String name;

    public static String getId() {
        return id;
    }

    public static void setId(String id1) {
        id = id1;
    }

    public static int getType() {
        return type;
    }

    public static void setType(int ty) {
        type = ty;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String n1) {
        name = n1;
    }

    public static void setall(String id, int type, String name){
        setName(name);
        setId(id);
        setType(type);
    }
}
