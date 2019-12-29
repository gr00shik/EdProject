package sping.task1.classes.pareImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sping.task1.interfaces.Horse;
import sping.task1.interfaces.Pare;
import sping.task1.interfaces.Rider;

@Component("pare")
@Scope("prototype")
public class PareImpl implements Pare{

    private Horse horse;
    private Rider rider;
    private Integer parePosition;

    public PareImpl () {
        parePosition = 0;
    }

    public PareImpl(Horse horse, Rider rider) {
        this.rider = rider;
        this.horse = horse;
        parePosition = 0;
    }

    @Override
    public Horse getHorse() {
        return horse;
    }

    @Autowired
    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    @Override
    public Rider getRider() {
        return rider;
    }

    @Autowired
    public void setRider(Rider rider) {
        this.rider = rider;
    }

    @Override
    public Integer pareHeap() {
        return parePosition += horse.setHorseHeapSpeed(rider.getRiderMastery());
    }


}
