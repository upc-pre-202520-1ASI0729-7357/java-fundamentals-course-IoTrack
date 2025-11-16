//Bienvenidos al curso de clases en JAVA
//perro - holly, toby - nombre, raza
//atributos = clase perro - nombre, edad
//metodos(acciones) - perro - ladrar(), comer()

class Calculadora{
    int Sumar(int a, int b){
        return a + b;
    }
}



public class Main {
    public static void main(String[] args){
        Calculadora calc = new Calculadora();
        int resultado = calc.Sumar(10,4);
        System.out.println("Resultado: " + resultado);
    }
}
