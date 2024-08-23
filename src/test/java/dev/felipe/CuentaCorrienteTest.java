package dev.felipe;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaCorrienteTest {

    @Test
    void testConstructor() {
        CuentaCorriente cuenta = new CuentaCorriente(10000, 2);
        assertEquals(10000, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.getSobregiro(), 0.001);
    }

    @Test
    void testRetiroConSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(10000, 2);
        cuenta.retirar(15000);
        assertEquals(0, cuenta.saldo, 0.001);
        assertEquals(5000, cuenta.getSobregiro(), 0.001);
    }

    @Test
    void testRetirarSinSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(10000, 2);
        cuenta.retirar(5000);
        assertEquals(5000, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.getSobregiro(), 0.001);
    }

    @Test
    void testConsignarParaCubrirSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(10000, 2);
        cuenta.retirar(15000);
        cuenta.consignar(6000);
        assertEquals(1000, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.getSobregiro(), 0.001);
    }

    @Test
    void testConsignarSinSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(10000, 2);
        cuenta.consignar(5000);
        assertEquals(15000, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.getSobregiro(), 0.001);
    }

    @Test
    void testGenerarExtractoMensual() {
        CuentaCorriente cuenta = new CuentaCorriente(10000, 2);
        cuenta.retirar(15000);
        cuenta.generarExtractoMensual();
        assertEquals(0, cuenta.saldo, 0.001);
        assertEquals(5000, cuenta.getSobregiro(), 0.001);
    }

    @Test
    void testImprimir() {
        CuentaCorriente cuenta = new CuentaCorriente(12000, 2);
        String resultado = cuenta.imprimir();
        assertTrue(resultado.contains("Saldo: 12000.0"));
        assertTrue(resultado.contains("Comisión Mensual: 0.0"));
        assertTrue(resultado.contains("Número de consignaciones: 0"));
        assertTrue(resultado.contains("Número de retiros: 0"));
        assertTrue(resultado.contains("Sobregiro: 0.0"));
    }
}
