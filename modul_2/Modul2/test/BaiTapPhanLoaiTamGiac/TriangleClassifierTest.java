package BaiTapPhanLoaiTamGiac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void readTriangle2and2and2() {
        int sideA = 2;
        int sideB = 2;
        int sideC = 2;

        String expected = "Tam giác đều";

        String result = TriangleClassifier.readTriangle(sideA, sideB, sideC);
        assertEquals(expected, result);

    }

    @Test
    void readTriangle2and2and3() {
        int sideA = 2;
        int sideB = 2;
        int sideC = 3;

        String expected = "Tam giác cân";

        String result = TriangleClassifier.readTriangle(sideA, sideB, sideC);
        assertEquals(expected, result);


    }

    @Test
    void readTriangle3and4and5(){
        int sideA = 3;
        int sideB = 4;
        int sideC = 5;

        String expected = "Tam giác thường";

        String result = TriangleClassifier.readTriangle(sideA , sideB, sideC);
        assertEquals(expected,result);


    }

    @Test
    void readTriangle8and2and3(){
        int sideA = 8;
        int sideB = 2;
        int sideC = 3;

        String expected = "Không phải tam giác";

        String result = TriangleClassifier.readTriangle(sideA , sideB, sideC);
        assertEquals(expected,result);

    }

    @Test
    void readTriangleNegative1and2and1(){
        int sideA = -1;
        int sideB = 2;
        int sideC = 1;

        String expected = "Không phải tam giác";

        String result = TriangleClassifier.readTriangle(sideA , sideB, sideC);
        assertEquals(expected,result);
    }

    @Test
    void readTriangle0and1and1(){
        int sideA = 0;
        int sideB = 1;
        int sideC = 1;

        String expected = "Không phải tam giác";

        String result = TriangleClassifier.readTriangle(sideA , sideB, sideC);
        assertEquals(expected,result);


    }

    @Test
    void readTriangle4and5and10(){
        int sideA = 4;
        int sideB = 5;
        int sideC = 10;

        String expected = "Không phải tam giác";

        String result = TriangleClassifier.readTriangle(sideA , sideB, sideC);
        assertEquals(expected,result);

    }


}