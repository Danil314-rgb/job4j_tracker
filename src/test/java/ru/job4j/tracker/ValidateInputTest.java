package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void when1NoInvalid1InvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void when3InvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "1", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMinus1InvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Please enter validate data again");
        assertThat(selected, is(1));
    }

}