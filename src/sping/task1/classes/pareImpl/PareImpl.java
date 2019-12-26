package sping.task1.classes.pareImpl;

import sping.task1.interfaces.Horse;
import sping.task1.interfaces.Pare;
import sping.task1.interfaces.Rider;

public class PareImpl implements Pare{

    private Horse horse;
    private Rider rider;

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

}
