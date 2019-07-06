package lesson28.homework2;

import java.util.Comparator;

public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        if((o1.getDateCreated() != null && o2.getDateCreated() != null && o1.getDateCreated().getTime() > o2.getDateCreated().getTime())
            || (o2.getDateCreated() == null))
            return -1;
        else if((o1.getDateCreated() != null && o2.getDateCreated() != null && o1.getDateCreated().equals(o2.getDateCreated()))
                || (o1.getDateCreated() == null && o2.getDateCreated() == null))
            return 0;
        else
            return 1;
    }
}
