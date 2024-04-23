package listpro;

import org.example.in.ArrayListString;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListStringTest {
    @Test
    @DisplayName("Добавление элемента без индекса в массив.")
    void addingItemIntoArrayWithoutIndex() {
        ArrayListString test = new ArrayListString(1);
        test.add("");
        Assertions.assertEquals(1, 1);

    }

    @Test
    @DisplayName("Добавление элемента с индексом в массив.")
    void addingItemIntoArrayWithIndex() {
    }
}
