package nl.koetsier;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    @Test
    public void testMain() {
        String s = Main.helloWorld();

        assertThat(s).isEqualTo("Hello, World!");
    }
}
