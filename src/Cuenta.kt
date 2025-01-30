class Cuenta(val numeroCuenta: String, var saldo: Double = 0.0) {

    fun consultarSaldo(): String {
        return ("Saldo: $saldo")
    }

    fun recibirAbono(cantidad: Double) {
        saldo += cantidad
    }

    fun realizarPago(cantidad: Double) {
        saldo -= cantidad
    }

    fun esMoroso(persona: Persona): Boolean {
        for (cuenta in persona.listaCuentas) {
            if (cuenta != null && cuenta.saldo < 0) {
                return true
            }
        }
        return false
    }
}