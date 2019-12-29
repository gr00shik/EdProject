package sping.task1.support;

import java.util.Random;

public class RandomUtil {

    private RandomUtil(){}

    public static int getRandomParam(Integer bound, Integer min) {
        Random rand = new Random();
        return (rand.nextInt(bound)) + min;
    }
}
