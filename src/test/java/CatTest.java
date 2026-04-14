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
public class CatTest {
    @Mock
    private Feline felineMock;
    @Test
    public void getSoundShouldReturnMeow(){
        Cat cat = new Cat(felineMock);
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals(expected, actual, "Вернул - Мяу. Успех");
    }
    @Test
    public void getFoodShouldReturnListOfMeat() throws Exception {
        List <String> expectedFood = List.of("Говядина","Курица");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(felineMock);
        List <String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood, "Вернул список мяса. Успех");
    }
}
