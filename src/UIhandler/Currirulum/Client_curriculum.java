package UIhandler.Currirulum;

import ClientToServer.myInfo;
import DAO.Curriculum.Course;
import DAO.Curriculum.Opencourse;
import UIviewer.SelectCourse.Check_Coustatus;
import UIviewer.SelectCourse.Choosing_Course;
import UIviewer.SelectCourse.Search_result;
import User.Student;
import message.Message;
import message.MessageType;
import utils.MyObjectOutputStream;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import static UIviewer.SelectCourse.Selcourse.cardLayout;

import static UIviewer.SelectCourse.Selcourse.panel;
import UIviewer.SelectCourse.*;

public class Client_curriculum {

    String id;
    public static String lastconsult;
    static MyObjectOutputStream oos=null;

    public void setId(String id) {
        this.id = id;
    }
    public static void arrange(Course c) throws IOException {
        Message message=new Message();
        message.setData(c);
        message.setType(MessageType.MESSAGE_CURRICULUM_ADMIN_ARRANGEMENT);
        oos.writeObject(message);
    }
    public static void setOos(MyObjectOutputStream mos) throws IOException {
        oos=mos;
    }



    public static void requireToChoose(Course curri)throws IOException{
            Message message=new Message();
            message.setData(curri);
            message.setType(MessageType.MESSAGE_CURRICULUM_CHOOSE);
            oos.writeObject(message);
    }
    public static void RequireMyChoice() throws IOException {
        Message message=new Message();
        message.setData(myInfo.getId());
        message.setType(MessageType.MESSAGE_CURRICULUM_LIST_MINE);
        oos.writeObject(message);
    }
    public static void showMyChoice(ArrayList<Course>courses){
        int n=courses.size();
        ConsultCourse_Chosen.consultCourse_chosen=new String[n][6];
        Iterator b=courses.iterator();
        int count=0;
        while(b.hasNext())
        {
            Course curri=(Course) b.next();
            ConsultCourse_Chosen.consultCourse_chosen[count][0]=curri.getId();
            ConsultCourse_Chosen.consultCourse_chosen[count][1]=curri.getName();
            ConsultCourse_Chosen.consultCourse_chosen[count][2]=curri.getTimestring();
            ConsultCourse_Chosen.consultCourse_chosen[count][3]=String.valueOf(curri.getPoint());
            ConsultCourse_Chosen.consultCourse_chosen[count][4]=curri.getTeacher();
            ConsultCourse_Chosen.consultCourse_chosen[count][5]=curri.getClassroom();
            count++;
        }
        ConsultCourse_Chosen chosen=new ConsultCourse_Chosen();
        Selcourse.panel.add(chosen,"chosen");
        Selcourse.cardLayout.show(Selcourse.panel,"chosen");
    }
    public static void showTeacherChoice(ArrayList<Course>courses){
        int n=courses.size();
        ConsultCourse_stuInfo.consult_stu=new String[n][6];
        Iterator b=courses.iterator();
        int count=0;
        while(b.hasNext())
        {
            Course curri=(Course) b.next();
            ConsultCourse_stuInfo.consult_stu[count][0]=curri.getId();
            ConsultCourse_stuInfo.consult_stu[count][1]=curri.getName();
            ConsultCourse_stuInfo.consult_stu[count][2]=String.valueOf(curri.getSize());
            ConsultCourse_stuInfo.consult_stu[count][3]=curri.getTimestring();
            ConsultCourse_stuInfo.consult_stu[count][4]=curri.getClassroom();
            ConsultCourse_stuInfo.consult_stu[count][5]="     查询";
            count++;
        }
        ConsultCourse_stuInfo tea_course=new ConsultCourse_stuInfo();
        Selcourse_teacher.panel.add(tea_course,"tea_course");
        Selcourse_teacher.cardLayout.show(Selcourse_teacher.panel,"tea_course");
    }
    //显示所有的课程进行选择
    public static void RequireallCourse()throws IOException{
        Choosing_Course.selectcourse=null;
        Message message=new Message();
        message.setType(MessageType.MESSAGE_CURRICULUM_LIST_ALL);
        oos.writeObject(message);
    }

    public static void showallCourse(ArrayList<Course>allchoosing)throws IOException{
        int n=allchoosing.size();
        Choosing_Course.selectcourse=new String[n][6];
        Iterator b=allchoosing.iterator();
        int count=0;
        while(b.hasNext())
        {
            Course course=(Course) b.next();
            Choosing_Course.selectcourse[count][0]=course.getId();
            Choosing_Course.selectcourse[count][1]=course.getName();
            Choosing_Course.selectcourse[count][2]=course.getTimestring();
            Choosing_Course.selectcourse[count][3]=course.getTeacher();
            Choosing_Course.selectcourse[count][4]=course.getClassroom();
            Choosing_Course.selectcourse[count][5]="     选择";
            count++;
        }
        Choosing_Course search=new Choosing_Course();
        Selcourse.panel.add(search,"search");
        Selcourse.cardLayout.show(Selcourse.panel,"search");
    }
    public static void admin_all_course(ArrayList<Course>allchoosing)throws IOException{
        int n=allchoosing.size();
        Scheduling.courses=new String[n][6];
        Iterator b=allchoosing.iterator();
        int count=0;
        while(b.hasNext())
        {
            Course course=(Course) b.next();
            Scheduling.courses[count][0]=course.getId();
            Scheduling.courses[count][1]=course.getName();
            Scheduling.courses[count][2]=course.getTeacher();
            Scheduling.courses[count][2]=String.valueOf(course.getSize());
            Scheduling.courses[count][4]=course.getTimestring();
            Scheduling.courses[count][5]=course.getClassroom();
            count++;
        }
        Scheduling sch=new Scheduling();
        Selcourse_director.panel.add(sch,"scheduling");
        Selcourse_director.cardLayout.show(Selcourse_director.panel,"scheduling");
    }
    //查询课程信息
    public static void RequireConsultResult(String consultInfo)throws IOException{
        lastconsult=consultInfo;
        Message message=new Message();
        message.setData(consultInfo);
        message.setType(MessageType.MESSAGE_CURRICULUM_QUERY);
        oos.writeObject(message);
    }
    public static void showConsultResult(ArrayList<Course> course)throws IOException{
        int n=course.size();
        Search_result.search_result=new String[n][6];
        Iterator b=course.iterator();
        int count=0;
        while(b.hasNext())
        {
            Course curri=(Course) b.next();
            Search_result.search_result[count][0]=curri.getId();
            Search_result.search_result[count][1]=curri.getName();
            Search_result.search_result[count][2]=curri.getTimestring();
            Search_result.search_result[count][3]=String.valueOf(curri.getPoint());
            Search_result.search_result[count][4]=curri.getTeacher();
            Search_result.search_result[count][5]=curri.getClassroom();
            count++;
        }
        Search_result search=new Search_result();
        if(myInfo.getType()==1)
        {panel.add(search,"search");
            cardLayout.show(panel,"search");}
        if(myInfo.getType()==2)
        {Selcourse_teacher.panel.add(search,"search");
            Selcourse_teacher.cardLayout.show(Selcourse_teacher.panel,"search");}
    }

    public static void Require_show_my_students(String Id)throws IOException{
        Message message=new Message();
        message.setData(Id);
        message.setType(MessageType.MESSAGE_CURRICULUM_SHOW_STU);
        oos.writeObject(message);

    }
    public static void apply(Opencourse course) throws IOException{
        Check_Coustatus.checkcourse_status=null;
        Message message=new Message();
        message.setData(course);
        message.setType(MessageType.MESSAGE_CURRICULUM_APPLY);
        oos.writeObject(message);
    }
    public static void show_my_students(ArrayList<Student>students){
        int n=students.size();
        My_students.students=new String[n][2];
        Iterator b=students.iterator();
        int count=0;
        while(b.hasNext())
        {
            Student s=(Student) b.next();
            My_students.students[count][0]=s.getStudent_idcard();
            My_students.students[count][1]=s.getStudent_name();
            count++;
        }
        My_students stuInfo=new My_students();
        Selcourse_teacher.panel.add(stuInfo,"stuInfo");
        Selcourse_teacher.cardLayout.show(Selcourse_teacher.panel,"stuInfo");
    }
    public static void showApplyResult(ArrayList<Opencourse>opencourses) {
        int n=opencourses.size();
        Check_Coustatus.checkcourse_status=new String[n][5];
        Iterator b=opencourses.iterator();
        int count=0;
        while(b.hasNext())
        {
            Opencourse curri=(Opencourse) b.next();
            Check_Coustatus.checkcourse_status[count][0]=curri.getId();
            Check_Coustatus.checkcourse_status[count][1]=curri.getName();
            Check_Coustatus.checkcourse_status[count][2]=String.valueOf(curri.getPoint());
            if(curri.getStatus()==0){
                Check_Coustatus.checkcourse_status[count][3]="审核中...";
                Check_Coustatus.checkcourse_status[count][4]="审核中...";
            } else if (curri.getStatus()==1) {
                Check_Coustatus.checkcourse_status[count][3]="已退回";
                Check_Coustatus.checkcourse_status[count][4]=curri.getResult();
            }
            else{
                Check_Coustatus.checkcourse_status[count][3]="已通过";
                Check_Coustatus.checkcourse_status[count][4]="审核通过";
            }
            count++;
        }
        Check_Coustatus cc =new Check_Coustatus();
        Selcourse_teacher.panel.add(cc,"apply");
        Selcourse_teacher.cardLayout.show(Selcourse_teacher.panel,"apply");

    }
    public static void Require_my_apply() throws IOException {

        Message message=new Message();
        message.setData(myInfo.getId());
        message.setType(MessageType.MESSAGE_CURRICULUM_LIST_APPLICATION);
        oos.writeObject(message);
    }
    public static void show_my_schedule(String [][][]schedule){
        My_Coursetable.tableDate=new String[17][13][6];
        for(int i=0;i<16;i++)
        {
            for(int j=0;j<13;j++){
                for(int k=1;k<=5;k++){
                    My_Coursetable.tableDate[i][j][k]=schedule[i+1][k][j+1];
                  //  if(i==0) System.out.print(My_Coursetable.tableDate[i][j][k]);
                }
               // if(i==0) System.out.println();
            }
        }
        My_Coursetable table=new My_Coursetable(1);
        Selcourse.panel.add(table,"schedule");
        Selcourse.cardLayout.show(Selcourse.panel,"schedule");
    }
    public static void RequireSchedule() throws IOException {
        Message message=new Message();
        message.setData(myInfo.getId());
        message.setType(MessageType.MESSAGE_CURRICULUM_SHOW_SCHEDULE);
        oos.writeObject(message);
    }
    public static void RequireTeaSchedule() throws IOException {
        Message message=new Message();
        message.setData(myInfo.getId());
        message.setType(MessageType.MESSAGE_CURRICULUM_SHOW_SCHEDULE);
        oos.writeObject(message);
    }
    public static void show_tea_schedule(String [][][]schedule){
        My_Coursetable.tableDate=new String[17][13][6];
        for(int i=0;i<16;i++)
        {
            for(int j=0;j<13;j++){
                for(int k=1;k<=5;k++){
                    My_Coursetable.tableDate[i][j][k]=schedule[i+1][k][j+1];
                    //  if(i==0) System.out.print(My_Coursetable.tableDate[i][j][k]);
                }
                // if(i==0) System.out.println();
            }
        }
        My_Coursetable table=new My_Coursetable(1);
        Selcourse_teacher.panel.add(table,"schedule");
        Selcourse_teacher.cardLayout.show(Selcourse_teacher.panel,"schedule");
    }
    public static void show_all_application(ArrayList<Opencourse>opencourses){
        int n=opencourses.size();
        Check_Course.checkcourse=new String[n][7];
        Iterator b=opencourses.iterator();
        int count=0;
        while(b.hasNext())
        {
            Opencourse curri=(Opencourse) b.next();
            Check_Course.checkcourse[count][0]=curri.getId();
            Check_Course.checkcourse[count][1]=curri.getName();
            Check_Course.checkcourse[count][2]=curri.getTeacher();
            Check_Course.checkcourse[count][3]=String.valueOf(curri.getPoint());
            Check_Course.checkcourse[count][4]=String.valueOf(curri.getSize());
            Check_Course.checkcourse[count][5]="      通过";
            Check_Course.checkcourse[count][6]="      退回";
            count++;
        }
        Check_Course f =new Check_Course();
        Selcourse_director.panel.add(f,"application");
        Selcourse_director.cardLayout.show(Selcourse_director.panel,"application");

    }
    public static void Require_all_application() throws IOException {
        Message message=new Message();
        message.setType(MessageType.MESSAGE_CURRICULUM_LIST_ADMIN_APPLICATION);
        oos.writeObject(message);
    }

    public static void Require_deleteCourse(String deleteID) throws IOException {
        Message message=new Message();
        message.setData(deleteID);
        message.setType(MessageType.MESSAGE_CURRICULUM_DELETE);
        oos.writeObject(message);
    }

    public static void Require_AgreeAddCourse(Course c) throws IOException {
        Message message=new Message();
        message.setData(c);
        message.setType(MessageType.MESSAGE_CURRICULUM_APPLY_SUCCEED);
        oos.writeObject(message);
    }

    public static void Require_RefuseAddCourse(String reason) throws IOException {
        Message message=new Message();
        message.setData(reason);
        message.setType(MessageType.MESSAGE_CURRICULUM_APPLY_FAIL);
        oos.writeObject(message);
    }
    //public
}
