package dev.felipe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaAhorrosTest {

    @Test
    void testConstructor() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 2);
        assertTrue(cuenta.activa);
        assertEquals(15000, cuenta.saldo, 0.001);
    }

    @Test
    void testConsignar() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 2);
        cuenta.consignar(5000);
        assertEquals(20000, cuenta.saldo, 0.001);
    }

    @Test
    void testConsignarEnCuentaInactiva() {
        CuentaAhorros cuenta = new CuentaAhorros(5000, 2);
        cuenta.consignar(5000);
        assertEquals(5000, cuenta.saldo, 0.001);  
    }

    @Test
    void testRetirar() {
        CuentaAhorros cuenta = new CuentaAhorros(15000, 2);
        cuenta.retirar(5000);
        assertEquals(10000, cuenta.saldo, 0.001);
    }

    @Test
    void testRetirarEnCuentaInactiva() {
        CuentaAhorros cuenta = new CuentaAhorros(5000, 2);
        cuenta.retirar(1000);
        assertEquals(5000, cuenta.saldo, 0.001);   
    }

    @Test
        CuentaAhorros cuenta = new CuentaAhorros(15000, 2);
        cuenta.retirar(6000);
        cuenta.retirar(1000);
        cuenta.retirar(500);
        cuenta.retirar(500);
        cuenta.retirar(500); 
        cuenta.generarExtractoMensual();

        assertEquals(6594.0, cuenta.saldo, 0.001); 
        assertFalse(cuenta.activa);  
    }

    @Test
    void testImprimir() {
        CuentaAhorros cuenta = new CuentaAhorros(12000, 2);
        String resultado = cuenta.imprimir();
        assertTrue(resultado.contains("Saldo: 12000.0"));
        assertTrue(resultado.contains("Comisión Mensual: 0.0"));
        assertTrue(resultado.contains("Número de consignaciones: 0"));
        assertTrue(resultado.contains("Número de retiros: 0"));
        assertTrue(resultado.contains("Activa: true"));
    }
}
