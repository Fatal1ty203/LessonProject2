package lessons.lesson29_annotations.ex1_basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    public void init(){
        System.out.println("init");
    }

    public void print(){}


    @Test
    void sum() {
    }

    @Test
    void minus() {
    }
}