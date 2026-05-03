import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FelineTest {
    @Test
    public void getFamilyShouldReturnFeline(){
        Feline feline = new Feline();
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual, "Вернул - Кошачьи. Успех");
    }
    @Test
    public void getKittensShouldReturnCount(){
        Feline feline = new Feline();
        int actualCount = feline.getKittens(1);
        assertEquals(1, actualCount, "Вернул - 1. Успех");
    }
    @Test
    public void getKittensAlternativeShouldReturnCount(){
        Feline feline = new Feline();
        int actualCount = feline.getKittens();
        assertEquals(1, actualCount, "Вернул - 1. Успех");
    }

    @Test
    public void getFoodShouldReturnListOfMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Feline feline = new Feline();
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood, "Вернул - Животные, Птицы, Рыба. Успех");
    }
}
