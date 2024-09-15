package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenEmptyFile() {
        String path = "./data/pair_empty_file.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isNull();
    }

    @Test
    void whenWithoutKey() {
        String path = "./data/pair_without_key.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenWithoutValue() {
        String path = "./data/pair_without_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenWithoutEquals() {
        String path = "./data/pair_without_equals.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenOnlyEquals() {
        String path = "./data/pair_only_equals.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenTwoEquals() {
        String path = "./data/pair_with_two_equals.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("ключ")).isEqualTo("значение=");
    }

}