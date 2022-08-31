/**
 * @author : [Tongwei_L]
 * @version : [v1.0]
 * @description : [一句话描述该类的功能]
 * @createTime : [2022.08.31 08:30]
 */
import java.util.HashMap;
public class tests {

        public static void main(String[] args) {

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("tony", "13962349564");
            map.put("kevin","18615479975");
            map.put("Vivian","15948759694");

            System.out.println(map.get("tony"));
            System.out.println(map.get("tocny"));
    }

}
