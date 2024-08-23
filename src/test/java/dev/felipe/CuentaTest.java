package dev.felipe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testConstructor() {
        Cuenta cuenta = new Cuenta(5000, 2);
        assertEquals(5000, cuenta.saldo, 0.001);
        assertEquals(2, cuenta.tasaAnual, 0.001);
        assertEquals(0, cuenta.numeroConsignaciones);
        assertEquals(0, cuenta.numeroRetiros);
        assertEquals(0, cuenta.comisionMensual, 0.001);
    }

    @Test
    void testConsignar() {
        Cuenta cuenta = new Cuenta(5000, 2);
        cuenta.consignar(2000);
        assertEquals(7000, cuenta.saldo, 0.001);
        assertEquals(1, cuenta.numeroConsignaciones);
    }

    @Test
    void testConsignarMontoCeroONegativo() {
        Cuenta cuenta = new Cuenta(5000, 2);
        cuenta.consignar(0);
        assertEquals(5000, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.numeroConsignaciones);

        cuenta.consignar(-500);
        assertEquals(5000, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.numeroConsignaciones);
    }

    @Test
    void testRetirar() {
        Cuenta cuenta = new Cuenta(5000, 2);
        cuenta.retirar(2000);
        assertEquals(3000, cuenta.saldo, 0.001);
        assertEquals(1, cuenta.numeroRetiros);
    }

    @Test
    void testRetirarMontoMayorQueSaldo() {
        Cuenta cuenta = new Cuenta(5000, 2);
        cuenta.retirar(6000);
        assertEquals(5000, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.numeroRetiros);
    }

    @Test
    void testCalcularInteresMensual() {
        Cuenta cuenta = new Cuenta(12000, 12);
        cuenta.calcularInteresMensual();
        assertEquals(12120, cuenta.saldo, 0.001);
    }

    @Test
    void testGenerarExtractoMensual() {
        Cuenta cuenta = new Cuenta(12000, 12);
        cuenta.generarExtractoMensual();
        assertEquals(12120, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.comisionMensual, 0.001);
    }

    @Test
    void testImprimir() {
        Cuenta cuenta = new Cuenta(12000, 12);
        String resultado = cuenta.imprimir();
        assertTrue(resultado.contains("Saldo: 12000.0"));
        assertTrue(resultado.contains("Comisión Mensual: 0.0"));
        assertTrue(resultado.contains("Número de consignaciones: 0"));
        assertTrue(resultado.contains("Número de retiros: 0"));
    }
}
