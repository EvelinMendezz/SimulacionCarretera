package Modelo;


/**
 * Write a description of class Carro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carro
{
    private int x;
    private int y;
    private int velocidad;
    private int caminoId; // A qué camino pertenece (1 al 4)
    private String estado; // "ESPERANDO", "CRUZANDO", "PASADO"

    public Carro(int x, int y, int velocidad, int caminoId) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        this.caminoId = caminoId;
        this.estado = "ESPERANDO";
    }

    public void avanzar() {
        // Solo avanza si su estado se lo permite
        if (estado.equals("CRUZANDO")) {
            switch (caminoId) {
                case 1: // Viene del Norte, baja hacia el Sur
                    y += velocidad;
                    break;
                case 2: // Viene del Este, va hacia el Oeste
                    x -= velocidad;
                    break;
                case 3: // Viene del Sur, sube hacia el Norte
                    y -= velocidad;
                    break;
                case 4: // Viene del Oeste, va hacia el Este
                    x += velocidad;
                    break;
            }
        }
    }

    // Getters y Setters necesarios
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getCaminoId() {
        return caminoId;
    }

    public void setCaminoId(int caminoId) {
        this.caminoId = caminoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
