package sping.task1.classes.riderImpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sping.task1.interfaces.Rider;
import sping.task1.support.RandomUtil;

import java.util.Random;

@Component("rider")
@Scope("prototype")
public class RiderImpl implements Rider{

    private Integer mastery;

    public RiderImpl(){
        mastery = RandomUtil.getRandomParam(10, 2);
    }

    @Override
    public Integer getRiderMastery() {
        return mastery;
    }
}
