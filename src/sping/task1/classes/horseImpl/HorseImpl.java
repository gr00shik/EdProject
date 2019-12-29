package sping.task1.classes.horseImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sping.task1.interfaces.Breed;
import sping.task1.interfaces.Horse;
import sping.task1.support.RandomUtil;

import java.util.Random;

@Component("horse")
@Scope("prototype")
public class HorseImpl implements Horse{

    private Breed breedImpl;
    private Integer horseSpeed;

    @Autowired
    public HorseImpl(Breed breed) {
        breedImpl = breed;
        horseSpeed = 0;
    }

    public Breed getBreedImpl() {
        return breedImpl;
    }

    public void setBreedImpl(Breed breed) {
        this.breedImpl = breed;
    }

    @Override
    public Integer setHorseHeapSpeed(Integer riderMystery) {
        int maxSpeed = breedImpl.getHorseMaxSpeed();
        horseSpeed = horseSpeed + RandomUtil.getRandomParam(riderMystery, 0);

        if(horseSpeed > maxSpeed) {
            return maxSpeed;
        } else if (horseSpeed <= 0) {
            return 0;
        }

        return horseSpeed;
    }

    @Override
    public Integer getHorseMaxSpeed() {
        return breedImpl.getHorseMaxSpeed();
    }
}
