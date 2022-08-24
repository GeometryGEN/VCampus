package DAO.Curriculum;


import ClientToServer.ManageClientToServerThread;
import ServerToClient.ServerToClient;
import User.Student;
import connection.JDBC_Connector;
import message.Message;
import message.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
//gsh
public class Course_manager {
    private String id;
    private Connection conn;
    private int type;
    public Course_manager(String id) {
        this.id = id;
        try {
            Connection conn= JDBC_Connector.ConnectMySQL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int[][][] change(String s){
        int[][][] a = new int[17][6][14];
        int week_l,week_r,day,sec_l,sec_r;
        String ss[]=s.split(",");
        for(int i=0;i<ss.length;i++){
            int index=ss[i].indexOf("星期");
            switch (ss[i].substring(index+2, index+3)){
                case "一":
                    day=1;
                    break;
                case "二":
                    day=2;
                    break;
                case "三":
                    day=3;
                    break;
                case "四":
                    day=4;
                    break;
                default:
                    day=5;
                    break;
            }
            int index1=ss[i].indexOf("-");
            week_l=Integer.parseInt(ss[i].substring(0,index1));
            int index2=ss[i].indexOf("周");
            week_r=Integer.parseInt(ss[i].substring(index1+1,index2));

            int index3=ss[i].indexOf("-",index+1);
            sec_l=Integer.parseInt(ss[i].substring(index+4,index3));
            int index4=ss[i].indexOf("节");
            sec_r=Integer.parseInt(ss[i].substring(index3+1,index4));

            for(int p=week_l;p<=week_r;p++){
                for(int q=sec_l;q<=sec_r;q++){
                    a[p][day][q]=1;
                }
            }
        }
        return a;
    }
    public HashSet<Course> query_courses(String s) throws SQLException {
        HashSet<Course> courses = new HashSet<Course>();
        String sql="select * from curriculum where id='%?%' or name='%?%' or teacher='%?%';";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,s);
        st.setString(2,s);
        st.setString(3,s);
        ResultSet rs=st.executeQuery();
        while (rs.next()){
            Course x=new Course();
            x.name=rs.getString("name");
            x.teacher=rs.getString("teacher");
            x.classroom=rs.getString("author");
            x.point=rs.getDouble("point");
            x.size=rs.getInt("size");
            x.id=rs.getString("id");
            x.class_time=change(rs.getString("time"));
            courses.add(x);
        }
        return courses;
    }
    public HashSet<Course> list_all_courses() throws SQLException {
        HashSet<Course> courses = new HashSet<Course>();
        String sql="select * from curriculum;";
        PreparedStatement st=conn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
            Course x=new Course();
            x.name=rs.getString("name");
            x.teacher=rs.getString("teacher");
            x.classroom=rs.getString("author");
            x.point=rs.getDouble("point");
            x.size=rs.getInt("size");
            x.id=rs.getString("id");
            x.class_time=change(rs.getString("time"));
            courses.add(x);
        }
        return courses;
    }
    public HashSet<Course> list_my_courses() throws SQLException {
        HashSet<Course> courses = new HashSet<Course>();
        String sql="select * from elective where stu_id='?' or tea_id='?';";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,id);
        st.setString(2,id);
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
            String course_id=rs.getString("course_id");
            sql="select * from curriculum where stu_id='?';";
            st=conn.prepareStatement(sql);
            st.setString(1,course_id);
            ResultSet rs1=st.executeQuery();
            while(rs1.next()){
                Course x=new Course();
                x.name=rs.getString("name");
                x.teacher=rs.getString("teacher");
                x.classroom=rs.getString("author");
                x.point=rs.getDouble("point");
                x.size=rs.getInt("size");
                x.id=rs.getString("id");
                x.class_time=change(rs.getString("time"));
                courses.add(x);
            }
        }
        return courses;
    }
    public Message choose(Course c) throws SQLException {
        HashSet<Course> courses = list_my_courses();
        int [][][]a=new int[17][6][14];
        Iterator it = courses.iterator();
        while(it.hasNext()){
            Course cc=(Course) it.next();
            for(int p=1;p<=16;p++){
                for(int q=1;q<=5;q++){
                    for(int r=1;r<=13;r++){
                        a[p][q][r]|=cc.class_time[p][q][r];
                    }
                }
            }
        }
        int confict=0;
        for(int p=1;p<=16;p++){
            for(int q=1;q<=5;q++){
                for(int r=1;r<=13;r++){
                    if(a[p][q][r]==1&&c.class_time[p][q][r]==1){
                        confict=1;
                        break;
                    }
                }
            }
        }
        Message message=new Message();
        if(confict==1)
        {
            message.setType(MessageType.MESSAGE_CURRICULUM_CHOOSE_CONFLICT);
            return message;
        }
        String sql="select * from curriculum where id='?';";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,c.id);
        ResultSet rs=st.executeQuery();
        int size=0;
        while (rs.next()) size=rs.getInt("size");
        sql="select count(*) total from elective where course_id='?';";
        st=conn.prepareStatement(sql);
        st.setString(1,c.id);
        rs=st.executeQuery();
        if(rs.getInt("total")==size){
            message.setType(MessageType.MESSAGE_CURRICULUM_CHOOSE_FULL);
            return message;
        }
        message.setType(MessageType.MESSAGE_LIBRARY_PAY_SUCCEED);
        sql="insert into elective(course_id,stu_id) value(?,?);";
        st=conn.prepareStatement(sql);
        st.setString(1,c.id);
        st.setString(1,id);
        st.executeUpdate();
        return message;
    }
    public void drop(String s) throws SQLException {
        String sql="delete from curriculum where course_id='?' and (stu_id='?' or tea_id='?');";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,s);
        st.setString(2,id);
        st.setString(3,id);
        st.executeUpdate();
    }
    public void add(Course c) throws SQLException {
        String sql="insert into curriculum(name,time,point,teacher,size,id,classroom) values(?,?,?,?,?,?,?,?);";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,c.name);
        st.setString(2,c.timestring);
        st.setDouble(3,c.point);
        st.setString(4,c.teacher);
        st.setInt(5,c.size);
        st.setString(6,c.id);
        st.setString(7,c.classroom);
        st.executeUpdate();
    }
    public void delete(String s) throws SQLException {
        String sql="delete from curriculum where id='?';";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,s);
        st.executeUpdate();
    }
    public String[][][] schedule(String id) throws SQLException {
        String [][][]ans=new String[17][14][6];
        HashSet<Course>courses=list_my_courses();
        Iterator it = courses.iterator();
        while(it.hasNext()){
            Course cc=(Course) it.next();
            for(int p=1;p<=16;p++){
                for(int q=1;q<=5;q++){
                    for(int r=1;r<=13;r++){
                        if(cc.class_time[p][q][r]==1) ans[p][q][r]=cc.name;
                    }
                }
            }
        }
        return ans;
    }
    public Message apply(Opencourse c) throws SQLException {
        String sql="select * from curriculum where name='?';";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,c.name);
        ResultSet rs=st.executeQuery();
        Message message=new Message();
        if(rs.next()){
            message.setType(MessageType.MESSAGE_CURRICULUM_APPLY_SUCCEED);
            ServerToClient.add_opencourse(c);
            return message;
        }
        else{
            message.setType(MessageType.MESSAGE_CURRICULUM_APPLY_FAIL);
            return message;
        }
    }
    public void refuse(String id,String reason) throws IOException {
        Iterator it=ServerToClient.getOpencourses().iterator();
        while(it.hasNext()){
            Opencourse c=(Opencourse)it.next();
            ServerToClient.getOpencourses().remove(c);
            if(c.id==id)
            {
                c.result=reason;
                c.status=1;
            }
            ServerToClient.getOpencourses().add(c);
        }
        return;
    }
    public void approve(String id,Course course) throws SQLException {
        Iterator it=ServerToClient.getOpencourses().iterator();
        while(it.hasNext()){
            Opencourse c=(Opencourse)it.next();
            ServerToClient.getOpencourses().remove(c);
            if(c.id==id)
            {
                c.result="已通过";
                c.status=2;
            }
            ServerToClient.getOpencourses().add(c);
        }
        add(course);
        return;
    }
    public HashSet<Opencourse>list_tea_opencourse(String id) throws SQLException{
        HashSet<Opencourse>opencourses=new HashSet<Opencourse>();
        Iterator it=ServerToClient.getOpencourses().iterator();
        while(it.hasNext()){
            Opencourse c=(Opencourse)it.next();
            if(c.id==id) opencourses.add(c);
        }
        return opencourses;
    }
    public Message admin_list_application(){
        Message message=new Message();
        message.setType(MessageType.MESSAGE_CURRICULUM_LIST_ADMIN_APPLICATION_RET);
        message.setData(ServerToClient.getOpencourses());
        return message;
    }
    public HashSet<Student>get_student(String s) throws SQLException {
        HashSet<Student>res=new HashSet<Student>();
        String sql="select * from curriculum where name='?' or id='?';";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,s);
        st.setString(2,s);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            String id=rs.getString("id");
            sql="select * from elective where course_id='?';";
            st=conn.prepareStatement(sql);
            st.setString(1,id);
            rs=st.executeQuery();
            while(rs.next()){
                sql="select * from students where Student_idcard='?';";
                st=conn.prepareStatement(sql);
                st.setString(1,id);
                ResultSet rs1=st.executeQuery();
                Student student = new Student();
                student.setStudent_name(rs1.getString("Student_name"));
                student.setStudent_id(rs1.getString("Student_id"));
                res.add(student);
            }
        }
        return res;
    }
}
