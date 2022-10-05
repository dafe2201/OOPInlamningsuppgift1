import Greenest.Carnivorous;
import Greenest.Plant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarnivorousTest {

    public Plant karlCarnivorous = new Carnivorous("Karl",5);
    public Carnivorous gustavCarnivorous = new Carnivorous("Gustav",9);

    @Test
    public void calculateNutritionTest(){
        assertEquals(1.1,karlCarnivorous.calculateNutrition());
        assertEquals(1.9000000000000001,gustavCarnivorous.calculateNutrition());
    }

}
