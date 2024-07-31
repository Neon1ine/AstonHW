package code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NeonArrayListTest {

    private static NeonArrayList<Integer> numbers;
    private static NeonArrayList<String> lines;

    @BeforeAll
    public static void init() {
        numbers = new NeonArrayList<>();
        numbers.addAll(Arrays.asList(136, 17, 265, 893, 74, 203, 8, 843, 92));
        lines = new NeonArrayList<>(3);
        lines.add("first");
        lines.add("second");
        lines.add("third");
        lines.add("fourth");
    }

    @Test
    public void testSizeNumbers() {
        assertThat(numbers.size()).isEqualTo(9);
    }

    @Test
    public void testSizeLines() {
        assertThat(lines.size()).isEqualTo(4);
    }
}
