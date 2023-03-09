package Coach;

import java.util.Comparator;

public class ComparatorCoach implements Comparator<Coach> {

    @Override
    public int compare(Coach o1, Coach o2) {
        if ( o1.getPriceOfSeat() < o2.getPriceOfSeat()){
            return -1;
        } else if (o1.getPriceOfSeat() > o2.getPriceOfSeat()) {
            return 1;
        }else
            return 0;
    }
}
