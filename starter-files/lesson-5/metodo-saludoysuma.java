//Bienvenidos al curso de metodos en JAVA
//metodo sumar() = cuatro
//metodo restar()
//metodo multipicar()
//metodo dividir()
//metodo int, void, string
public class Main {
     public static void saludo(String nombre){
        System.out.println("Aprendiendo mi primer metodo con " + nombre);
    }
    
    public static int sumar(int a, int b){
        return a+b;
    }
    
    public static void main(String[] args){
        saludo("Axel");
        int resultado = sumar(5,3);
        System.out.println("La respuesta de mi metodo suma es: "+ resultado);
    }
    
}
