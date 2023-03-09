package BaiTapTinhKetQuaFizzBuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void readFizzBuzz3() {
        int number = 3;
        String expected = "Fizz";

        String result = FizzBuzz.readFizzBuzz(number);
        assertEquals(expected,result);
    }

    @Test
    void readFizzBuzz5() {
        int number = 5;
        String expected = "Buzz";

        String result = FizzBuzz.readFizzBuzz(number);
        assertEquals(expected,result);
    }

    @Test
    void readFizzBuzz15() {
        int number = 15;
        String expected = "FizzBuzz";

        String result = FizzBuzz.readFizzBuzz(number);
        assertEquals(expected,result);
    }

    @Test
    void readFizzBuzz31() {
        int number = 31;
        String expected = "Fizz";

        String result = FizzBuzz.readFizzBuzz(number);
        assertEquals(expected,result);
    }

    @Test
    void readFizzBuzz17() {
        int number = 17;
        String expected = "mười bảy";

        String result = FizzBuzz.readFizzBuzz(number);
        assertEquals(expected,result);
    }

    @Test
    void readFizzBuzz45() {
        int number = 45;
        String expected = "FizzBuzz";

        String result = FizzBuzz.readFizzBuzz(number);
        assertEquals(expected,result);
    }

    @Test
    void readFizzBuzz98() {
        int number = 98;
        String expected = "chín tám";

        String result = FizzBuzz.readFizzBuzz(number);
        assertEquals(expected,result);
    }

    @Test
    void readFizzBuzz103() {
        int number = 103;
        String expected = "Số bạn nhập không đúng!";

        String result = FizzBuzz.readFizzBuzz(number);
        assertEquals(expected,result);
    }

    @Test
    void readFizzBuzz52() {
        int number = 52;
        String expected = "Buzz";

        String result = FizzBuzz.readFizzBuzz(number);
        assertEquals(expected,result);
    }



}