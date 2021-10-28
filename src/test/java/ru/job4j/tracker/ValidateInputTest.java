package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void when1NoValid1InvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void when3ValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "2", "4"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected1, is(1));
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2, is(2));
        int selected4 = input.askInt("Enter menu:");
        assertThat(selected4, is(4));
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1" }
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Please enter validate data again");
        assertThat(selected, is(-1));
    }

}