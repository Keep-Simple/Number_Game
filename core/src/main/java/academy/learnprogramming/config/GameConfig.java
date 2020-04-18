package academy.learnprogramming.config;

import academy.learnprogramming.annotations.GuessCount;
import academy.learnprogramming.annotations.MaxNumber;
import academy.learnprogramming.annotations.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    // == fields ==
    @Value("${game.maxNumber:1000}")
    private int maxNumber;
    @Value("${game.guess:10}")
    private int guessCount;
    @Value("${game.minNumber:0}")
    private int minNumber;

    // == bean methods, using custom annotations to prevent using @Qualifier ==

    @Bean
    @MaxNumber //custom an. to directly bind factory method with fields
    //No need to worry if method and field has different names
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() { //method name is bean name
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }
}
