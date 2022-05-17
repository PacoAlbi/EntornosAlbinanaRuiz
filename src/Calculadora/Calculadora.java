/*
Diseñe el código y las pruebas de caja negra y blanca para una clase Calculadora,
que tendrá los siguientes atributos y métodos: ( 6 puntos)
- public string nombreCalculadora;
- public int[] números;
- public Calculadora(string nombre, int[] números): constructor que inicia el nombre y los
números que tendrá para los cálculos.
- public void multiplicar(int x): cada dato interno lo modifica multiplicándolo por x.
- public int númeroRepeticiones(int número): devuelve las veces que aparece el número dentro del vector.
Si no aparece, produce una excepción.
- Sobreescribir el método equals. Dos calculadoras son iguales si tienen el mismo nombre y los mismos datos.
 */
package Calculadora;

import java.util.Arrays;

public class Calculadora {

    public String nombreCalculadora;
    public int[] numeros;

    public Calculadora(String nombreCalculadora, int[] numeros) {
        this.nombreCalculadora = nombreCalculadora;
        this.numeros = numeros.clone();
    }

    public void multiplicar(int x) {
        for (int i = 0; i < this.numeros.length; i++) {
            this.numeros[i] *= x;
        }
    }

    public int numeroRepeticiones(int numero) throws Exception {
        int veces = 0;
        for (int i = 0; i < this.numeros.length; i++) {
            if (this.numeros[i] == numero) {
                veces++;
            }
        }
        if (veces == 0){
            throw new Exception("El número no existe.");
        }
        return veces;
    }

    @Override
    public boolean equals(Object o) {
        boolean iguales = this == o;
        assert o instanceof Calculadora;
        Calculadora cal1 = (Calculadora) o;
        if (this.nombreCalculadora.equals(((Calculadora) o).nombreCalculadora) &&
                Arrays.equals(numeros, cal1.numeros)){
            iguales = true;
        }
        return iguales;
    }
}
