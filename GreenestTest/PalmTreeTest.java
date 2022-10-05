import Greenest.PalmTree;
import Greenest.Plant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalmTreeTest {

    public Plant palmOlof = new PalmTree("Olof",2);
    public PalmTree palmBertil = new PalmTree("Bertil",123);



    @Test
    public final void calculateNutritionTest(){
        assertEquals(1,palmOlof.calculateNutrition());
        assertEquals(61.5,palmBertil.calculateNutrition());
    }

}
