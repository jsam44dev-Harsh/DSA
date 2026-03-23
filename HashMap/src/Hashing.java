import java.util.*;

public class Hashing{
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("India",150);
        map.put("China",180);
        map.put("US",200);
        System.out.println(map.get("US"));
        System.out.println(map);

    }
}