package sping.task1.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import sping.task1.classes.breedImpl.BreedImpl;
import sping.task1.classes.horseImpl.HorseImpl;
import sping.task1.classes.pareImpl.PareImpl;
import sping.task1.classes.raceImpl.RaceImpl;
import sping.task1.classes.riderImpl.RiderImpl;
import sping.task1.interfaces.*;

@Configuration
public class JavaConfig {

    @Bean(name="breed")
    @Scope("prototype")
    public Breed breed()
    {
        return new BreedImpl();
    }

    @Bean(name="horse")
    @Scope("prototype")
    public Horse horse()
    {
        return new HorseImpl(breed());
    }

    @Bean(name="rider")
    @Scope("prototype")
    public Rider rider()
    {
        return new RiderImpl();
    }

    @Bean(name="pare")
    @Scope("prototype")
    public Pare pare()
    {
        return new PareImpl(horse(), rider());
    }

    @Bean(name="race")
    @Scope("singleton")
    public Race race()
    {
        return new RaceImpl();
    }
}
