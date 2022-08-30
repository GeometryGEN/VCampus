package UIhandler.Currirulum;

import DAO.Curriculum.Course;
import DAO.Curriculum.Opencourse;
import UIviewer.SelectCourse.Check_Coustatus;
import UIviewer.SelectCourse.Choosing_Course;
import UIviewer.SelectCourse.Search_result;
import message.Message;
import message.MessageType;
import utils.MyObjectOutputStream;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import static UIviewer.SelectCourse.Selcourse.cardLayout;
import static UIviewer.SelectCourse.Selcourse.panel;

public class Client_curriculum {

    String id;
    public static String lastconsult;
    static MyObjectOutputStream oos=null;

    public void setId(String id) {
        this.id = id;
    }

    public static void setOos(MyObjectOutputStream mos) throws IOException {
        oos=mos;
    }



public static void requireChosen(Course curri)throws IOException{
        Message message=new Message();
        message.setData(curri);
        message.setType(MessageType.MESSAGE_CURRICULUM_LIST_MINE);
        oos.writeObject(message);
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
        UIviewer.SelectCourse.Selcourse.panel.add(search,"search");
        UIviewer.SelectCourse.Selcourse.cardLayout.show(UIviewer.SelectCourse.Selcourse.panel,"search");
    }
    //查询课程信息
    public static void RequireConsultResult(String consultInfo)throws IOException{
        lastconsult=consultInfo;
        Search_result search_result=null;
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
        panel.add(search,"search");
        cardLayout.show(panel,"search");

    }
    public static void apply(Opencourse course) throws IOException{
        Check_Coustatus.checkcourse_status=null;
        Message message=new Message();
        message.setType(MessageType.MESSAGE_CURRICULUM_LIST_APPLICATION);

    }
    public static void showApplyResult(String id)
    {

    }
}
