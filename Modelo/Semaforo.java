package Modelo;


/**
 * Write a description of class Semaforo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Semaforo
{
    private int id; // 1, 2, 3 o 4
    private String color; // rojo o verde

    public Semaforo(int id) {
        this.id = id;
        this.color = "ROJO"; // Todos empiezan en rojo
    }

    public int getId() { 
        return id; 
    }
    
    public String getColor() { 
        return color; 
    }
    
    public void setColor(String color) { 
        this.color = color; 
    }
    
    
}
