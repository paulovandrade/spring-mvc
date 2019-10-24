package com.invillia.incubadora.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author s2it_pandrade
 * @version : $<br/>
 * : $
 * @since 24/10/19 14:43
 */
class UserTest {
    
    @Test
    public void whenCalledGetNameThenCorrect() {
        User user = new User("Julie", "julie@domain.com");
        assertThat(user.getName()).isEqualTo("Julie");
    }

    @Test
    public void whenCalledGetEmailThenCorrect() {
        User user = new User("Julie", "julie@domain.com");
        assertThat(user.getEmail()).isEqualTo("julie@domain.com");
    }

    @Test
    public void whenCalledSetNameThenCorrect() {
        User user = new User("Julie", "julie@domain.com");
        user.setName("John");
        assertThat(user.getName()).isEqualTo("John");
    }

    @Test
    public void whenCalledSetEmailThenCorrect() {
        User user = new User("Julie", "julie@domain.com");
        user.setEmail("john@domain.com");
        assertThat(user.getEmail()).isEqualTo("john@domain.com");
    }

    @Test
    public void whenCalledtoStringThenCorrect() {
        User user = new User("Julie", "julie@domain.com");
        assertThat(user.toString()).isEqualTo("User{id=0, name=Julie, email=julie@domain.com}");
    }
}
