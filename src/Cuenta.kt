class Cuenta(val numeroCuenta: String, var saldo: Double) {

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

    /*fun transferirSaldo(persona1: Persona, persona2: Persona, numeroCuenta1: String, numeroCuenta2: String) {
        persona1.
    }*/
}