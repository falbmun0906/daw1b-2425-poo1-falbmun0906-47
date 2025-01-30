fun mostrarSaldo(persona: Persona) {
    for (cuenta in persona.listaCuentas) {
        if (cuenta != null) {
            println("Saldo cuenta ${cuenta.numeroCuenta}: ${cuenta.saldo}")
        }
    }
    print("\n")
}

fun main() {
    val persona1: Persona = Persona("2006776644Q", arrayOf(null, Cuenta("0001"), Cuenta("0002", 700.0)))

    mostrarSaldo(persona1)

    println("Ingresando 1100€ en la cuenta '0001' y pagando 750€ desde cuenta '0002'...")
    persona1.listaCuentas.find {it?.numeroCuenta == "0001"}?.recibirAbono(1100.0)
    persona1.listaCuentas.find {it?.numeroCuenta == "0002"}?.realizarPago(750.0)

    mostrarSaldo(persona1)
    if (persona1.esMoroso()) {
        println("La persona 1 es morosa.")
    } else println("La persona 1 NO es morosa.")
    print("\n")

    println("Transfiriendo 800€ de la cuenta '0001' a la cuenta '0002'...")
    persona1.transferirSaldo(persona1, persona1, "0001", "0002", 800.0)

    for (cuenta in persona1.listaCuentas) {
        if (cuenta != null) {
            println("Saldo cuenta ${cuenta.numeroCuenta}: ${cuenta.saldo}")
        }
    }
}