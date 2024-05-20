package ru.job4j.generics;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenRoleTeacher() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Teacher"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Teacher");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Teacher"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleIsTeacher() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Teacher"));
        store.add(new Role("1", "Nurse"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Teacher");
    }

    @Test
    void whenReplaceThenRoleIsNurse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Teacher"));
        store.replace("1", new Role("1", "Nurse"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Nurse");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Teacher"));
        store.replace("10", new Role("10", "Nurse"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Teacher");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Teacher"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleNameIsTeacher() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Teacher"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Teacher");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Teacher"));
        boolean result = store.replace("1", new Role("1", "Nurse"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Teacher"));
        boolean result = store.replace("10", new Role("10", "Nurse"));
        assertThat(result).isFalse();
    }
}