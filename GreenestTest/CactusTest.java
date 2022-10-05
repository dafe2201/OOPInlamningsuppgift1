import Greenest.Cactus;
import Greenest.Plant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CactusTest {

    public Plant karlCactus = new Cactus("Karl",5);
    public Cactus gustavCactus = new Cactus("Gustav",9);


    @Test
     public void calculateNutritionTest(){
        assertEquals(0.02,karlCactus.calculateNutrition());
        assertEquals(0.02,gustavCactus.calculateNutrition());
    }

}
