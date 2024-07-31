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

    @Test
    public void testAddByIndexNumbers() {
        NeonArrayList<Integer> expected = new NeonArrayList<>();
        expected.addAll(Arrays.asList(136, 17, 265, 99, 74, 203, 8, 843, 92));
        NeonArrayList<Integer> actual = numbers;
        actual.add(3, 99);
        assertThat(actual.get(2)).isEqualTo(expected.get(2));
        assertThat(actual.get(3)).isEqualTo(expected.get(3));
        assertThat(actual.get(4)).isEqualTo(expected.get(4));
        init();
    }

    @Test
    public void testAddByIndexLines() {
        NeonArrayList<String> expected = new NeonArrayList<>(4);
        expected.addAll(Arrays.asList("first", "second", "something new", "fourth"));
        NeonArrayList<String> actual = lines;
        actual.add(2, "something new");
        assertThat(actual.get(1)).isEqualTo(expected.get(1));
        assertThat(actual.get(2)).isEqualTo(expected.get(2));
        assertThat(actual.get(3)).isEqualTo(expected.get(3));
        init();
    }

    @Test
    public void testClearNumbers() {
        numbers.clear();
        assertThat(numbers.size()).isEqualTo(0);
        assertThat(numbers.isEmpty()).isTrue();
        init();
    }

    @Test
    public void testClearLines() {
        lines.clear();
        assertThat(lines.size()).isEqualTo(0);
        assertThat(lines.isEmpty()).isTrue();
        init();
    }

    @Test
    public void testRemoveByIndexNumbers() {
        NeonArrayList<Integer> expected = new NeonArrayList<>();
        expected.addAll(Arrays.asList(136, 17, 265, 74, 203, 8, 843, 92));
        NeonArrayList<Integer> actual = numbers;
        actual.remove(3);
        assertThat(actual.get(2)).isEqualTo(expected.get(2));
        assertThat(actual.get(3)).isEqualTo(expected.get(3));
        assertThat(actual.get(4)).isEqualTo(expected.get(4));
        init();
    }

    @Test
    public void testRemoveByObjectLines() {
        NeonArrayList<String> expected = new NeonArrayList<>(4);
        expected.addAll(Arrays.asList("first", "second", "fourth"));
        NeonArrayList<String> actual = lines;
        actual.remove("third");
        assertThat(actual.get(0)).isEqualTo(expected.get(0));
        assertThat(actual.get(1)).isEqualTo(expected.get(1));
        assertThat(actual.get(2)).isEqualTo(expected.get(2));
        init();
    }

    @Test
    public void testSortNumbers() {
        NeonArrayList<Integer> expected = new NeonArrayList<>();
        expected.addAll(Arrays.asList(8, 17, 74, 92, 136, 203, 265, 843, 893));
        NeonArrayList<Integer> actual = numbers;
        actual.sort();
        assertThat(actual.get(2)).isEqualTo(expected.get(2));
        assertThat(actual.get(3)).isEqualTo(expected.get(3));
        assertThat(actual.get(4)).isEqualTo(expected.get(4));
        init();
    }
}
