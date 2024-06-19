package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAfterLast() {
        ListUtils.addAfter(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 3, 2);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addAfter(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenRemoveIfFirst() {
        ListUtils.removeIf(input, integer -> integer.equals(1));
        assertThat(input).hasSize(1).containsSequence(3);
    }

    @Test
    void whenRemoveIfLast() {
        ListUtils.removeIf(input, integer -> integer.equals(3));
        assertThat(input).hasSize(1).containsSequence(1);
    }

    @Test
    void whenRemoveIfMultiple() {
        ListUtils.addBefore(input, 1, 2);
        ListUtils.addAfter(input, 2, 3);
        ListUtils.removeIf(input, integer -> integer.equals(3));
        assertThat(input).hasSize(2).containsSequence(1, 2);
    }

    @Test
    void whenReplaceIf() {
        ListUtils.replaceIf(input, integer -> integer.equals(3), 7);
        assertThat(input).hasSize(2).containsSequence(1, 7);
    }

    @Test
    void whenReplaceIfMultiple() {
        ListUtils.addBefore(input, 1, 1);
        ListUtils.replaceIf(input, integer -> integer.equals(1), 7);
        assertThat(input).hasSize(3).containsSequence(7, 7, 3);
    }

    @Test
    void whenRemoveAll() {
        List<Integer> outer = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3));
        List<Integer> inner = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.removeAll(outer, inner);
        assertThat(outer).hasSize(5).containsSequence(3, 4, 5, 6, 3);
    }

    @Test
    void whenRemoveAllLast() {
        List<Integer> outer = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> inner = new ArrayList<>(Arrays.asList(6));
        ListUtils.removeAll(outer, inner);
        assertThat(outer).hasSize(5).containsSequence(1, 2, 3, 4, 5);
    }

    @Test
    void whenRemoveAllEmptyOuter() {
        List<Integer> outer = new ArrayList<>(Arrays.asList());
        List<Integer> inner = new ArrayList<>(Arrays.asList(6));
        ListUtils.removeAll(outer, inner);
        assertThat(outer).hasSize(0).containsSequence();
    }

    @Test
    void whenRemoveAllEmptyInner() {
        List<Integer> outer = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> inner = new ArrayList<>(Arrays.asList());
        ListUtils.removeAll(outer, inner);
        assertThat(outer).hasSize(6).containsSequence(1, 2, 3, 4, 5, 6);
    }
}