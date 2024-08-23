package dev.felipe;
public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    @Override
    public void retirar(float monto) {
        if (monto > 0) {
            if (monto <= saldo) {
                saldo -= monto;
            } else {
                sobregiro += (monto - saldo);
                saldo = 0;
            }
            numeroRetiros++;
        }
    }

    @Override
    public void consignar(float monto) {
        if (monto > 0) {
            if (sobregiro > 0) {
                if (monto >= sobregiro) {
                    monto -= sobregiro;
                    sobregiro = 0;
                } else {
                    sobregiro -= monto;
                    monto = 0;
                }
            }
            saldo += monto;
            numeroConsignaciones++;
        }
    }

    public float getSobregiro() {
        return sobregiro;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\nSobregiro: " + sobregiro;
    }
}
