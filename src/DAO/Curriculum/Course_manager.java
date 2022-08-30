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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
//gsh
public class Course_manager {
    private String id;
    private static Connection conn;
    private int type;
    public Course_manager(String id) {
        this.id = id;
        try {
            conn= JDBC_Connector.ConnectMySQL();
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
    public ArrayList<Course> query_courses(String s) throws SQLException {
        ArrayList<Course> courses = new ArrayList<Course>();
        String sql="select * from curriculum where id like ? or name like ? or teacher like ? order by id;";
        String parse="%"+s+"%";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,parse);
        st.setString(2,parse);
        st.setString(3,parse);
        ResultSet rs=st.executeQuery();
        while (rs.next()){
            Course x=new Course();
            x.name=rs.getString("name");
            x.teacher=rs.getString("teacher");
            x.classroom=rs.getString("classroom");
            x.point=rs.getDouble("point");
            x.size=rs.getInt("size");
            x.id=rs.getString("id");
            x.class_time=change(rs.getString("time"));
            courses.add(x);
        }
        return courses;
    }
    public ArrayList<Course> list_all_courses() throws SQLException {
        ArrayList<Course> courses = new ArrayList<Course>();
        String sql="select * from curriculum order by id;";
        PreparedStatement st=conn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
            Course x=new Course();
            x.name=rs.getString("name");
            x.teacher=rs.getString("teacher");
            x.classroom=rs.getString("classroom");
            x.point=rs.getDouble("point");
            x.size=rs.getInt("size");
            x.id=rs.getString("id");
            x.class_time=change(rs.getString("time"));
            courses.add(x);
        }
        return courses;
    }
    public ArrayList<Course> list_my_courses() throws SQLException {
        ArrayList<Course> courses = new ArrayList<Course>();
        String sql="select * from elective where stu_id=? or tea_id=? order by course_id;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,id);
        st.setString(2,id);
        ResultSet rs=st.executeQuery();
        while(rs.next())
        {
            String course_id=rs.getString("course_id");
            sql="select * from curriculum where stu_id=?;";
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
        ArrayList<Course> courses = list_my_courses();
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
        String sql="select * from curriculum where id=?;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,c.id);
        ResultSet rs=st.executeQuery();
        int size=0;
        while (rs.next()) size=rs.getInt("size");
        sql="select count(*) total from elective where course_id=?;";
        st=conn.prepareStatement(sql);
        st.setString(1,c.id);
        rs=st.executeQuery();
        if(rs.getInt("total")==size){
            message.setType(MessageType.MESSAGE_CURRICULUM_CHOOSE_FULL);
            return message;
        }
        message.setType(MessageType.MESSAGE_CURRICULUM_CHOOSE_SUCCEED);
        sql="insert into elective(course_id,stu_id) value(?,?);";
        st=conn.prepareStatement(sql);
        st.setString(1,c.id);
        st.setString(1,id);
        st.executeUpdate();
        return message;
    }
    public void drop(String s) throws SQLException {
        String sql="delete from curriculum where course_id=? and (stu_id=? or tea_id=?);";
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
        String sql="delete from curriculum where id=?;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,s);
        st.executeUpdate();
    }
    public String[][][] schedule() throws SQLException {
        String [][][]ans=new String[17][14][6];
        ArrayList<Course>courses=list_my_courses();
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
        String sql="select * from curriculum where name=?;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,c.name);
        ResultSet rs=st.executeQuery();
        Message message=new Message();
        if(rs.next()){
            message.setType(MessageType.MESSAGE_CURRICULUM_APPLY_SUCCEED);
            sql="select count(*) from opencourse;";
            st= conn.prepareStatement(sql);
            rs=st.executeQuery();
            String newid=String.valueOf(rs.getInt(1));
            //ServerToClient.add_opencourse(c);
            sql="insert into opencourse(name,teacher_name,teacher_id,point,size,status,id) values(?,?,?,?,?,0,?);";
            st= conn.prepareStatement(sql);
            st.setString(1,c.getName());
            st.setString(2,c.getTeacher_id());
            st.setString(3,c.getTeacher());
            st.setDouble(4,c.getPoint());
            st.setInt(5,c.getSize());
            st.setString(6,newid);
            st.executeUpdate();
        }
        else{
            message.setType(MessageType.MESSAGE_CURRICULUM_APPLY_FAIL);
        }
        return message;
    }
    public void refuse(String course_id,String reason) throws IOException, SQLException {
        String sql="update opencourse set status=1, comment=? where id=?;";
        PreparedStatement st= conn.prepareStatement(sql);
        st.setString(1,reason);
        st.setString(2,course_id);
        st.executeUpdate();

    }
    public void approve(String course_id,Course c) throws SQLException {
        String sql="update opencourse set status=2, comment=? where id=?;";
        PreparedStatement st= conn.prepareStatement(sql);
        st.setString(1,"同意开课");
        st.setString(2,course_id);
        st.executeUpdate();
        sql="insert into curriculum(name,time,point,teacher,size,id,classroom) values(?,?,?,?,?,?,?);";
        st= conn.prepareStatement(sql);
        st.setString(1,c.name);
        st.setString(2,c.timestring);
        st.setDouble(3,c.point);
        st.setString(4,c.teacher);
        st.setInt(5,c.size);
        st.setString(6,c.id);
        st.setString(7,c.classroom);
        st.executeUpdate();
    }
    public ArrayList<Opencourse> list_tea_opencourse(String id) throws SQLException{
        ArrayList<Opencourse>opencourses=new ArrayList<>();
        String sql="select * from opencourse where teacher_id=?";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,id);
        ResultSet rs=st.executeQuery();
        while(rs.next()){
            Opencourse c=new Opencourse();
            c.setName(rs.getString("name"));
            c.setTeacher(rs.getString("teacher_name"));
            c.setPoint(rs.getDouble("point"));
            c.setSize(rs.getInt("size"));
            c.status=rs.getInt("status");
            c.result=rs.getString("comment");
            c.setTeacher_id(rs.getString("teacher_id"));
            opencourses.add(c);
        }
        return opencourses;
    }
    public Message admin_list_application() throws SQLException {
        Message message=new Message();
        message.setType(MessageType.MESSAGE_CURRICULUM_LIST_ADMIN_APPLICATION_RET);
        ArrayList<Opencourse>opencourses=new ArrayList<>();
        String sql="select * from opencourse where status=0";
        PreparedStatement st=conn.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        while(rs.next()){
            Opencourse c=new Opencourse();
            c.setName(rs.getString("name"));
            c.setTeacher(rs.getString("teacher_name"));
            c.setPoint(rs.getDouble("point"));
            c.setSize(rs.getInt("size"));
            c.status=rs.getInt("status");
            c.result=rs.getString("comment");
            c.setTeacher_id(rs.getString("teacher_id"));
            opencourses.add(c);
        }
        message.setData(opencourses);
        return message;
    }
    public ArrayList<Student>get_student(String s) throws SQLException {
        ArrayList<Student>res=new ArrayList<Student>();
        String sql="select * from curriculum where name=? or id=?;";
        PreparedStatement st=conn.prepareStatement(sql);
        st.setString(1,s);
        st.setString(2,s);
        ResultSet rs=st.executeQuery();
        if(rs.next()){
            String id=rs.getString("id");
            sql="select * from elective where course_id=? order by stu_id;";
            st=conn.prepareStatement(sql);
            st.setString(1,id);
            rs=st.executeQuery();
            while(rs.next()){
                sql="select * from students where Student_idcard=?;";
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
    public void admin_arrange(Course c) throws SQLException {
        String sql="update curriculum set classroom=?, time=?, size=? where id=?";
        PreparedStatement st= conn.prepareStatement(sql);
        st.setString(1,c.classroom);
        st.setString(2,c.timestring);
        st.setInt(3,c.size);
        st.setString(4,c.id);
        st.executeUpdate();
    }
}
