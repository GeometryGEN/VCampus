package message;
//接口中定义一些常量
//不同的常量值表示不同消息类型

public interface MessageType {

    int PORT = 8080;                     //端口号
    String MESSAGE_LOGIN_SUCCEED = "1";  //登录成功
    String MESSAGE_LOGIN_FAIL = "2";     //登录失败
    String MESSAGE_STUDENT_LOGIN = "3";  //学生登录
    String MESSAGE_TEACHER_LOGIN = "4";  //教师登录
    String MESSAGE_ADMIN_LOGIN = "5";    //管理员登录

    String MESSAGE_STUDENT_REGISTER = "10";             //学生注册
    String MESSAGE_STUDENT_REGISTER_SUCCEED = "11";     //学生注册成功
    String MESSAGE_STUDENT_REGISTER_FAILED = "12";     //学生注册失败
    String MESSAGE_TEACHER_REGISTER = "13";             //老师注册
    String MESSAGE_TEACHER_REGISTER_SUCCEED = "14";     //老师注册成功
    String MESSAGE_TEACHER_REGISTER_FAILED = "15";     //老师注册失败

    String TO_FIND_CERTAIN="16";
    String HAVE_FIND_CERTAIN="17";                     //找到要修改密码的用户
    String NOT_FIND_CERTAIN="18";                      //没有找到要修改密码的用户
    String RESET_PASSWORD="19";                        //开始重置密码
    String RESET_PASSWORD_FAILED = "20";               //重置密码失败
    String RESET_PASSWORD_SUCCEED = "9";              //重置密码成功

    String MESSAGE_CLIENT_EXIT = "0";     //客户端退出

    String RETURN_STUDENT_INFO="100";           //得到学籍信息
    String RETURN_STUDENT_INFO_SUCCEED="101";   //得到学籍信息成功
    String RETURN_STUDENT_INFO_FAILED="102";    //得到学籍信息失败
}
