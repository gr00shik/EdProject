package sping.task1.classes.breedImpl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sping.task1.interfaces.Breed;
import sping.task1.support.RandomUtil;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component("breed")
@Scope("prototype")
public class BreedImpl implements Breed {

    private int horseMaxSpeed;

    public BreedImpl() {
        this.horseMaxSpeed = RandomUtil.getRandomParam(10, 2);
    }

    @Override
    public Integer getHorseMaxSpeed() {
        return horseMaxSpeed;
    }

    @PostConstruct
    private void construct(){
        System.out.println("this is construct");
    }

    @PreDestroy
    private void destroyM(){
        System.out.println("this is destroy, poriadok eto otstoi");
    }
}
