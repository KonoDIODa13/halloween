package com.example.halloween.modelo

class Persona {
    //var _nombre: String, var _edad: Int, var _altura: Double
    var nombre: String = ""
        get() {
            return field
        }
        set(nuevoNombre) {
            field=nuevoNombre
        }

    var edad: Int = 0
        get() {
            return field
        }
        set(nuevaEdad) {
            field=nuevaEdad
        }
   var altura: Double = 0.0
       get() {
            return field
        }
        set(nuevaAltura) {
            field=nuevaAltura
        }

    constructor(nombre: String, edad: Int, altura: Double) {
        this.nombre = nombre
        this.edad = edad
        this.altura = altura
    }
}