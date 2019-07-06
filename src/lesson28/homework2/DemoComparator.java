package lesson28.homework2;

import java.util.ArrayList;
import java.util.Date;

public class DemoComparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, "A", null, true, new Date());
        Capability capability2 = new Capability(1005, "B", "b", false, new Date());
        Capability capability3 = new Capability(900, "C", "c", true, new Date());
        Capability capability4 = new Capability(900, "D", "d", false, new Date());

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);

        System.out.println(capabilities);
        capabilities.sort(new FullComparator());
        System.out.println(capabilities);















    }
}
