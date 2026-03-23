import java.util.HashSet;
import java.util.Iterator;

public class set {
    public static void main(String[] args) {
        HashSet<Integer> set= new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(3);
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.contains(1));
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.print(it.next());
        }
        System.out.println();
        set.clear();
//
//        for (Integer integer : set) {
//            System.out.print(integer);
//        }
        System.out.println(set);
    }
}
