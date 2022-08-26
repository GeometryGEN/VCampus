package DAO.Curriculum;

import java.io.Serializable;

public class Course implements Serializable {
    int [][][]class_time=new int[17][6][14];   //上课时间
    String name,teacher,id,classroom,timestring;
    double point;   //学分
    int size;

    public int[][][] getClass_time() {
        return class_time;
    }

    public void setClass_time(int[][][] class_time) {
        this.class_time = class_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getTimestring() {
        return timestring;
    }

    public void setTimestring(String timestring) {
        this.timestring = timestring;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
