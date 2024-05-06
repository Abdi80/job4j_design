package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isNotEmpty()
                .isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 4);
        String name = box.whatsThis();
        assertThat(name)
                .startsWithIgnoringCase("t")
                .isEqualTo("Tetrahedron");
    }

    @Test
    void whenNumberOfVertices0() {
        Box box = new Box(0, 10);
        int quantity = box.getNumberOfVertices();
        assertThat(quantity)
                .isLessThan(1)
                .isEqualTo(0);
    }

    @Test
    void whenNumberOfVertices4() {
        Box box = new Box(4, 4);
        int quantity = box.getNumberOfVertices();
        assertThat(quantity)
                .isEven()
                .isEqualTo(4);
    }

    @Test
    void whenExist() {
        Box box = new Box(8, 12);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void whenNotExistByVertex() {
        Box box = new Box(3, 12);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void whenNotExistByEdge() {
        Box box = new Box(4, 0);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void areaWhenTetrahedron() {
        Box box = new Box(4, 5);
        double area = box.getArea();
        assertThat(area)
                .isGreaterThan(43d)
                .isCloseTo(43.30, withPrecision(0.01));
    }

    @Test
    void areaWhenCube() {
        Box box = new Box(8, 6);
        double area = box.getArea();
        assertThat(area)
                .isLessThan(216.1)
                .isCloseTo(216d, withPrecision(0.01));
    }

    @Test
    void areaWhenSphere() {
        Box box = new Box(0, 4);
        double area = box.getArea();
        assertThat(area)
                .isCloseTo(201.06, withPrecision(0.01))
                .isCloseTo(201.06, Percentage.withPercentage(1.0));
    }
}