package dev.felipe;

public class Cuenta {
    protected float saldo;
    protected int numeroConsignaciones = 0;
    protected int numeroRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    public void consignar(float monto) {
        if (monto > 0) {
            saldo += monto;
            numeroConsignaciones++;
        }
    }

    public void retirar(float monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            numeroRetiros++;
        }
    }

    public void calcularInteresMensual() {
        float interesMensual = (saldo * (tasaAnual / 12)) / 100;
        saldo += interesMensual;
    }

    public void generarExtractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    public String imprimir() {
        return "Saldo: " + saldo + "\nComisión Mensual: " + comisionMensual +
               "\nNúmero de consignaciones: " + numeroConsignaciones +
               "\nNúmero de retiros: " + numeroRetiros;
    }
}
