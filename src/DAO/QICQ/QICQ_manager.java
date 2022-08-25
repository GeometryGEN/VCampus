package DAO.QICQ;

import java.util.HashSet;

public class QICQ_manager {
    String id;

    public QICQ_manager(String id) {
        this.id = id;
    }
    public HashSet<Friend>get_online_friends(){
        HashSet<Friend>friends=new HashSet<>();
        return friends;
    }
    public HashSet<Friend>get_offline_friend(){
        HashSet<Friend>friends=new HashSet<>();
        return friends;
    }

}
