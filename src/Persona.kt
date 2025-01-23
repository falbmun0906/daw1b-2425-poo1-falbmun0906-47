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

    fun esMoroso() {

    }
}