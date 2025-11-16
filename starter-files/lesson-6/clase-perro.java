//Bienvenidos al curso de clases en JAVA
//perro - holly, toby - nombre, raza
//atributos = clase perro - nombre, edad
//metodos(acciones) - perro - ladrar(), comer()

class Perro{
    //atributos - caracteristicas
    String nombre;
    int edad;
    
    //metodos - acciones
    void ladrar(){
        System.out.println(nombre + " esta ladrando ¡Guau Guau!");
    }
}



public class Main {
    public static void main(String[] args){
        //Crear un objeto perro
        Perro miPerro = new Perro();
        miPerro.nombre = "Holly";
        miPerro.edad = 5;
        
        miPerro.ladrar();
    }
}





