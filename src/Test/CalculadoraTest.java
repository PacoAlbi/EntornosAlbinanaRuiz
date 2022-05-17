package Test;

import Calculadora.Calculadora;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class CalculadoraTest {

    @Test
    void CalculadoraCajaNegra1() {
        int[] datos = new int[]{4, 10, -6, 0, 100};
        Calculadora cal1 = new Calculadora("Cal1", datos);
        assertEquals(cal1, new Calculadora("Cal1", datos), "(0010) La calculadora no se ha construido correctamente.");
    }

    @Test
    void CalculadoraCajaNegraVectorVacio() {
        int[] datos = new int[]{};
        Calculadora cal1 = new Calculadora("", datos);
        assertEquals(cal1, new Calculadora("", datos), "(0020) La calculadora no se ha construido correctamente.");
    }

    @Test
    void CalculadoraNullCajaBlanca (){
        boolean salta = false;
        try {
            new Calculadora(null,null);
        } catch (Exception e) {
            salta = true;
        }
        assertTrue(salta, "(0030) La calculadora no se ha construido correctamente.");
    }

    @Test
    void multiplicarCajaNegra1() {
        Calculadora cal1 = new Calculadora("Cal1", new int[]{1,2,3,4,5,6});
        cal1.multiplicar(2);
        assertEquals(cal1, new Calculadora("Cal1", new int[]{2,4,6,8,10,12}), "(0040)No se ha multiplicado correctamente.");
    }

    @Test
    void multiplicarCajaNegra2() {
        Calculadora cal1 = new Calculadora("Cal1", new int[]{6});
        cal1.multiplicar(2);
        assertEquals(cal1, new Calculadora("Cal1", new int[]{12}), "(0050)No se ha multiplicado correctamente.");
    }

    @Test
    void multiplicarCajaNegra3() {
        Calculadora cal1 = new Calculadora("", new int[]{});
        cal1.multiplicar(3);
        assertEquals(cal1, new Calculadora("", new int[]{}), "(0060)No debería haber datos.");
    }

    @Test
    void multiplicarCajaNegra4() {
        boolean salta = false;
        try {
            Calculadora cal1 = new Calculadora(null, null);
            cal1.multiplicar(4);
        } catch (Exception e) {
            salta = true;
        }
        assertTrue(salta, "(0070)No debería haber datos.");
    }

    @Test
    void numeroRepeticionesCajaNegra1() throws Exception {
        Calculadora cal1 = new Calculadora("Cal1", new int[]{2,54,2,9,0,2,6,0});
        assertEquals(3, cal1.numeroRepeticiones(2), "(0080)Ha saltado la excepción.");
    }

    @Test
    void numeroRepeticionesCajaNegra2() {
        boolean salta = false;
        try {
            Calculadora cal1 = new Calculadora("Cal1", new int[]{2,54,2,9,0,2,6,0});
            cal1.numeroRepeticiones(7);
        } catch (Exception e) {
            salta = true;
        }
        assertTrue(salta,"(0090)La excepción no ha saltado como debiera.");
    }

    @Test
    void numeroRepeticionesCajaNegra3() {
        boolean salta = false;
        try {
            Calculadora cal1 = new Calculadora("", new int[]{});
            cal1.numeroRepeticiones(7);
        } catch (Exception e) {
            salta = true;
        }
        assertTrue(salta,"(0100)La excepción no ha saltado como debiera.");
    }

    @Test
    void numeroRepeticionesCajaNegra4() {
        boolean salta = false;
        try {
            Calculadora cal1 = new Calculadora(null, null);
            cal1.numeroRepeticiones(7);
        } catch (Exception e) {
            salta = true;
        }
        assertTrue(salta,"(0110)La excepción no ha saltado como debiera.");
    }

    @Test
    void testEqualsCajaNegra1() {
        Calculadora cal1 = new Calculadora("Cal1", new int[]{1,2,3});
        Calculadora cal2 = new Calculadora("Cal1", new int[]{1,2,3});
        assertTrue(cal1.equals(cal2), "(0120)Los objetos no son iguales.");
    }

    @Test
    void testEqualsCajaNegra2() {
        Calculadora cal1 = new Calculadora("Cal1", new int[]{1,2,3});
        Calculadora cal2 = new Calculadora("Cal2", new int[]{1,2,3});
        assertFalse(cal1.equals(cal2), "(0130)Los objetos no deberían ser iguales.");
    }

    @Test
    void testEqualsCajaNegra3() {
        Calculadora cal1 = new Calculadora("Cal1", new int[]{1,2,3});
        Calculadora cal2 = new Calculadora("Cal1", new int[]{1,2,3,9});
        assertFalse(cal1.equals(cal2), "(0140)Los objetos no deberían ser iguales.");
    }

    @Test
    void testEqualsCajaNegra4() {
        Calculadora cal1 = new Calculadora("Cal1", new int[]{1,2,3});
        Calculadora cal2 = new Calculadora("Cal2", new int[]{0,2,3,9});
        assertFalse(cal1.equals(cal2), "(0150)Los objetos no deberían ser iguales.");
    }

    @Test
    void testEqualsCajaNegra5() {
        Calculadora cal1 = new Calculadora("", new int[]{});
        Calculadora cal2 = new Calculadora("", new int[]{});
        assertTrue(cal1.equals(cal2), "(0160)Los objetos no deberían ser iguales.");
    }
}