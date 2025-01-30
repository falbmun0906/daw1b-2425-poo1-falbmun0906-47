class Persona(val dni: String, val listaCuentas: Array<Cuenta?> = arrayOfNulls(3)) {

    fun añadirCuenta(cuenta: Cuenta): Boolean {
        for (i in listaCuentas.indices) {
            if (listaCuentas[i] == null) {
                listaCuentas[i] = cuenta
                return true
            }
        }
        print("ERROR: Ya se ha alcanzado el máximo de 3 cuentas.")
        return false
    }

    fun esMoroso(): Boolean {
        for (cuenta in listaCuentas) {
            if (cuenta != null && cuenta.saldo < 0) {
                return true
            }
        }
        return false
    }

    fun transferirSaldo(persona1: Persona, persona2: Persona, numeroCuenta1: String, numeroCuenta2: String, cantidad: Double) {
        val cuenta1Existe = persona1.listaCuentas.any { it?.numeroCuenta == numeroCuenta1 }
        val cuenta2Existe = persona2.listaCuentas.any { it?.numeroCuenta == numeroCuenta2 }

        if (cuenta1Existe && cuenta2Existe) {
            val cuenta1 = persona1.listaCuentas.find { it?.numeroCuenta == numeroCuenta1 }
            val cuenta2 = persona2.listaCuentas.find { it?.numeroCuenta == numeroCuenta2 }

            if (cuenta1 != null && cuenta2 != null) {
                cuenta1.saldo -= cantidad
                cuenta2.saldo += cantidad
            }
        }
    }
}