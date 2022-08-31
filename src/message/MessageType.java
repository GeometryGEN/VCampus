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

    //图书馆

    String MESSAGE_LIBRARY_ENTER="21";   //提取用户信息 无data
    String MESSAGE_LIBRARY_ENTER_RET="21.1";//返回提取的用户信息 data类型Info
    String MESSAGE_LIBRARY_ADMIN_LIST="22"; //管理员查看图书馆内书籍 无data
    String MESSAGE_LIBRARY_ADMIN_LIST_RET="22.1";  //返回管理员看到的图书 data类型Hashset<Book_admin>
    String MESSAGE_LIBRARY_ADMIN_QUERY="22.2"; //管理员查询图书馆内书籍 data类型String
    String MESSAGE_LIBRARY_ADMIN_QUERY_RET="22.3";  //返回管理员查到的图书 data类型Hashset<Book_admin>
    String MESSAGE_LIBRARY_LIST_MY_BOOK="22.5"; //查询用户借阅的书籍 无data
    String MESSAGE_LIBRARY_LIST_MY_BOOK_RET="22.4"; //返回用户借阅的书籍  data类型Hashset<Book_borrower>
    String MESSAGE_LIBRARY_ADMIN_HANDLE="23";  //管理员处理罚单 data类型
    String MESSAGE_LIBRARY_ADMIN_ADD="23.1";  //管理员添加图书馆内书籍 data类型Book_admin
    String MESSAGE_LIBRARY_ADMIN_DELETE="23.2"; //管理员删除图书馆内书籍 data类型String，图书id
    String MESSAGE_LIBRARY_LIST_MY_TICKET="24";  //用户请求自己的罚单 无data
    String MESSAGE_LIBRARY_LIST_MY_TICKET_RET="24.1"; //返回用户看自己的罚单 data类型Hashset<Punishment>
    String MESSAGE_LIBRARY_ADMIN_LIST_TICKETS="25"; //管理员看到用户的请求 无data
    String MESSAGE_LIBRARY_ADMIN_LIST_TICKETS_RET="25.1"; //返回管理员看到的用户的请求 data类型Hashset<Punishment>
    String MESSAGE_LIBRARY_BORROW="26";   //借书请求，data类型Book_borrower
    String MESSAGE_LIBRARY_BORROW_SUCCEED="26.1"; //借书成功 无data
    String MESSAGE_LIBRARY_BORROW_FAIL_TOO_MANY="26.2";  //借书失败，超过五本的限制 无data
    String MESSAGE_LIBRARY_BORROW_FAIL_RETURN_FIRST="26.3"; //借书失败，应该先还书 无data
    String MESSAGE_LIBRARY_EXTEND="26.4";  //用户请求延长借阅 data类型Book_borrower
    String MESSAGE_LIBRARY_EXTEND_SUCCEED="26.5"; //延长借阅成功 无data
    String MESSAGE_LIBRARY_EXTEND_FAIL="26.6"; //延长借阅失败，已经延长过一次 无data
    String MESSAGE_LIBRARY_RET="27"; //用户还书，data类型Book_borrower
    String MESSAGE_LIBRARY_RET_SUCCEED="27.1" ; //用户还书成功 无data
    String MESSAGE_LIBRARY_RET_LATE="27.2";//用户还书迟了 无data
    String MESSAGE_LIBRARY_QUERY="28";   //查询书籍，data类型String
    String MESSAGE_LIBRARY_QUERY_RET="28.1"; //返回查询的书籍 data类型Hashset<Book_borrower>
    String MESSAGE_LIBRARY_ADMIN_GIVE_TICKET="29";  //用户提出申请 data类型Punishment
    String MESSAGE_LIBRARY_PAY="30";  //用户罚钱 data类型Punishment
    String MESSAGE_LIBRARY_PAY_SUCCEED="30.1"; //用户交罚款成功
    String MESSAGE_LIBRARY_PAY_FAIL="30.2";//用户交罚款失败，钱不够


    //选课
    String MESSAGE_CURRICULUM_LIST_ALL="31";  //请求所有的课程 无data
    String MESSAGE_CURRICULUM_LIST_ALL_RET="31.1"; //返回所有课程 data类型Arraylist<Course>
    String MESSAGE_CURRICULUM_LIST_MINE="31.5";  //展示用户所选课程 无data
    String MESSAGE_CURRICULUM_LIST_MINE_RET="31.6"; //返回用户所选课程 data类型Arraylist<Course>
    String MESSAGE_CURRICULUM_CHOOSE="32"; //请求选课 data类型Course
    String MESSAGE_CURRICULUM_CHOOSE_SUCCEED="32.1"; //选课成功 无data
    String MESSAGE_CURRICULUM_CHOOSE_CONFLICT="32.2";//选课失败 课程冲突 无data
    String MESSAGE_CURRICULUM_CHOOSE_FULL="32.3";//选课失败 课程已满 无data
    String MESSAGE_CURRICULUM_APPLY="33";  //教师申请 data类型Opencourse
    String MESSAGE_CURRICULUM_APPLY_SUCCEED="33.1"; //教师申请成功 无data
    String MESSAGE_CURRICULUM_APPLY_FAIL="33.2";//教师申请失败 已经有这门课程 无data
    String MESSAGE_CURRICULUM_LIST_APPLICATION="33.3"; //教师看到自己的申请，无data
    String MESSAGE_CURRICULUM_LIST_APPLICATION_RET="33.4"; //返回教师看到自己的申请，data类型Arraylist<Opencourse>
    String MESSAGE_CURRICULUM_APPLICATION_APPROVE="33.5";  //同意加课，Message包getter里写凯克课程id，data是课程Course类型
    String MESSAGE_CURRICULUM_APPLICATION_REFUSE="33.6";  //拒绝加课，Message包getter里写开课课程id，data里写原因String类型
    String MESSAGE_CURRICULUM_SHOW_STU="34";  //请求展示这门课的学生 data类型String课程id
    String MESSAGE_CURRICULUM_SHOW_STU_RET="34.1"; //返回这门课的学生 data类型Arraylist<Student>
    String MESSAGE_CURRICULUM_SHOW_SCHEDULE="35";  //请求展示课表
    String MESSAGE_CURRICULUM_SHOW_SCHEDULE_RET="35.1"; //返回课表 data类型String[17][6][14]
    String MESSAGE_CURRICULUM_DELETE="36"; //删除课 data类型String课程id
    String MESSAGE_CURRICULUM_LIST_ADMIN_APPLICATION="33.7";  //管理员展示申请
    String MESSAGE_CURRICULUM_LIST_ADMIN_APPLICATION_RET="33.8"; //返回管理员处的申请 data类型Arraylist<Opencourse>
    String MESSAGE_CURRICULUM_QUERY="37"; //课程查询 data String(名称，教师，课程号)
    String MESSAGE_CURRICULUM_QUERY_RET="37.1"; //返回课程查询的结果 data类型Arraylist<Course>
    String MESSAGE_CURRICULUM_ADMIN_ARRANGEMENT="38";//管理员排课，安排教室和时间 Data类型Course


    //站内通信
    String MESSAGE_QICQ_ADD_FRIEND="41";
    String MESSAGE_QICQ_ADD_FRIEND_FAIL_CANNOT_FIND_USER="41.2";
    String MESSAGE_QICQ_ADD_FRIEND_SUCCEED="41.5";
//    String MESSAGE_QICQ_ADD_FRIEND_START="41.3";
    String MESSAGE_QICQ_SEND_MSG="42";
    String MESSAGE_QICQ_SEND_FILE="42.5";
    String MESSAGE_QICQ_GET_ANNOUNCEMENT="43";
    String MESSAGE_QICQ_GET_ANNOUNCEMENT_RET="43.1";
    String MESSAGE_QICQ_GET_MESSAGE="43.3";
    String MESSAGE_QICQ_GET_MESSAGE_RET="43.4";
    String MESSAGE_QICQ_ADD_ANNOUNCEMENT="43.2";
    String MESSAGE_QICQ_LIST_APPLICATION="44";  //请求展示出我发送的好友申请
    String MESSAGE_QICQ_LIST_APPLICATION_RET="44.1";
    String MESSAGE_QICQ_LIST_APPLICATION_HANDLE="44.2";  //请求展示出我收到的好友申请
    String MESSAGE_QICQ_LIST_APPLICATION_HANDLE_RET="44.3";
    String MESSAGE_QICQ_LIST_FRIENDS="45";
    String MESSAGE_QICQ_LIST_FRIENDS_RET="45.1";
    String MESSAGE_QICQ_ACCEPT_NEW_FRIEND="46";
    String MESSAGE_QICQ_DENY_NEW_FRIEND="46.5";
    String MESSAGE_QICQ_RECERIVE_MESSAGE="47";
    String MESSAGE_QICQ_RECERIVE_FILE="47.5";
    String MESSAGE_QICQ_FRIEND_ONLINE="48";
    String MESSAGE_QICQ_FRIEND_ONLINE_RET="48.5";
    String MESSAGE_QICQ_FRIEND_OFFLINE="48.2";
    String MESSAGE_QICQ_FRIEND_OFFLINE_RET="48.6";

/*    String RETURN_STUDENT_INFO="100";           //得到学籍信息
    String RETURN_STUDENT_INFO_SUCCEED="101";   //得到学籍信息成功
    String RETURN_STUDENT_INFO_FAILED="102";    //得到学籍信息失败

    String RETURN_PHOTO="103";          //得到图片
    String RETURN_PHOTO_SUCCEED="104";  //得到图片成功
    String RETURN_PHOTO_FAILED="105";   //得到图片失败

    String ADMIN_RETURN_STUDENT_INFO="100.1";           //管理员得到学籍信息
    String ADMIN_RETURN_STUDENT_INFO_SUCCEED="101.1";   //管理员得到学籍信息成功
    String ADMIN_RETURN_STUDENT_INFO_FAILED="102.1";    //管理员得到学籍信息失败

    String RENEW_STUDENT_INFO="100.11";           //RENEW学籍信息
    String RENEW_STUDENT_INFO_SUCCEED="101.11";   //RENEW学籍信息成功
    String RENEW_STUDENT_INFO_FAILED="102.11";    //RENEW学籍信息失败*/


    String RETURN_ALL_PRODUCT="106";          //请求得到所有商品
    String RETURN_ALL_PRODUCT_SUCCEED="107";  //成功
    String RETURN_ALL_PRODUCT_FAILED="108";   //失败

    String FIND_PRODUCT="106.5";          //请求模糊查找商品
    String FIND_PRODUCT_SUCCEED="110.5";        //成功
    String FIND_PRODUCT_SUCCEED_ZERO="110.0";  //成功且为0
    String FIND_PRODUCT_FAILED="111.5";         //失败

    String DELETE_PRODUCT="109";          //请求删除特定商品
    String DELETE_PRODUCT_SUCCEED="110";  //成功
    String DELETE_PRODUCT_FAILED="111";   //失败


    String FIND_TYPE_PRODUCT="112";             //查找商品根据分类
    String FIND_TYPE_PRODUCT_SUCCEED="113";     //成功
    String FIND_TYPE_PRODUCT_FAILED="114";      //成功且为0

    String ADD_PRODUCT="115";             //add商品
    String ADD_PRODUCT_SUCCEED="116";     //成功
    String ADD_PRODUCT_FAILED="117";      //失败

    String CHECK_BUYED_PRODUCT="118";
    String CHECK_BUYED_PRODUCT_SUCCEED="119";     //成功
    String CHECK_BUYED_PRODUCT_FAILED="120";      //失败


    String CHECK_READYTOBUY_PRODUCT="118.1";
    String CHECK_READYTOBUY_PRODUCT_SUCCEED="118.2";     //成功
    String CHECK_READYTOBUY_PRODUCT_FAILED="118.3";      //失败


    String CHECK_CERTAIN_PRODUCT="118.11";
    String CHECK_CERTAIN__PRODUCT_SUCCEED="118.21";     //成功
    String CHECK_CERTAIN__PRODUCT_FAILED="118.31";      //失败

    String BUY_CERTAIN_PRODUCT="130.1.1";
    String BUY_CERTAIN__PRODUCT_SUCCEED="131.1.1";     //成功
    String BUY_CERTAIN__PRODUCT_FAILED="132.1.1";      //失败

    String DELETE_READYTPBUY_PRODUCT="130.1.1Q";
    String DELETE_READYTPBUY_PRODUCT_SUCCEED="131.1.1Q";     //成功
    String DELETE_READYTPBUY_PRODUCT_FAILED="132.1.1Q";      //失败

    String MESSAGE_STATUS_STU_ENTER="200";
    String MESSAGE_STATUS_STU_ENTER_RET="200.5";
    String MESSAGE_STATUS_ADMIN_QUERY="201.6";
    String MESSAGE_STATUS_ADMIN_QUERY_RET="201.8";
    String MESSAGE_STATUS_ADMIN_QUERY_FAIL="201.9";
    String MESSAGE_STATUS_CONFIRM="202";
    String MESSAGE_STATUS_CONFIRM_RET="202.5";

}
