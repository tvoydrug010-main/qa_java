import com.example.*;
//import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionTest {
private static Stream<Arguments> isDoesHasManeData(){
    try {
        return Stream.of(
                Arguments.of(new Lion("Самец"),true),
                Arguments.of(new Lion("Самка"),false)
        );
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

    @Mock
    private Feline felineMock;
    @Test
    public void getKittensShouldReturnCount() throws Exception {
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        Lion lion = new Lion(felineMock);
        int actual = lion.getKittens();
        assertEquals(1, actual);
    }
    @ParameterizedTest()
    @MethodSource("isDoesHasManeData")
    public void doesHasManeTrue(Lion lion, boolean expected){
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void getFoodShouldReturnListOfMeat() throws Exception {
        List <String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion(felineMock);
        List <String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood, "Вернул вид животных. Успех");
    }
}
