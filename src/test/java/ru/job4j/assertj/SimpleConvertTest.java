package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert
                .toList("first", "second", "three", "four", "five", "second");
        assertThat(list)
                .containsExactlyInAnyOrder("first", "second", "second", "three", "four", "five")
                .containsSequence("five", "second")
                .first().isEqualTo("first");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert
                .toSet("first", "second", "three", "four", "five", "second");
        assertThat(set)
                .containsExactlyInAnyOrder("first", "second", "three", "four", "five")
                .allSatisfy(e -> {
                    assertThat(e.length()).isLessThan(7);
                    assertThat(e.length()).isGreaterThan(3);
                })
                .containsAnyOf("first", "seven");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("001", "002", "003", "004");
        assertThat(map)
                .containsKey("003")
                .containsValues(0, 1, 2, 3)
                .containsEntry("004", 3);
    }
}