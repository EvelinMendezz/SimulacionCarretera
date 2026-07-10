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
    private int caminoId;
    private String estado; // "ESPERANDO", "CRUZANDO", "PASADO"
    
    private String direccion;

    public Carro(int x, int y, int velocidad, int caminoId, String direccion) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        this.caminoId = caminoId;
        this.estado = "ESPERANDO";
        this.direccion= direccion;
    }

    public void avanzar() {
        // Solo avanza si su estado se lo permite
        if (estado.equals("CRUZANDO")) {
            switch (caminoId) {
                case 1: // Viene del Norte, baja hacia el Sur
                    if (direccion.equals("DERECHA") && y >= 330) {
                        x -= velocidad; // Gira hacia el Oeste
                    } else {
                        y += velocidad; // Sigue derecho al Sur
                    }
                    break;
                case 2: // Viene del Este, va hacia el Oeste
                    if (direccion.equals("DERECHA") && x <= 430) {
                        y -= velocidad; // Gira hacia el Norte
                    } else { 
                        x -= velocidad; // Sigue derecho al Oeste
                    }
                    break;
                case 3: // Viene del Sur, sube hacia el Norte
                    if (direccion.equals("DERECHA") && y <= 430) {
                        x += velocidad; // Gira hacia el Este
                    } else {
                        y -= velocidad; // Sigue derecho al Norte
                    }
                    break;
                case 4: // Viene del Oeste, va hacia el Este
                    if (direccion.equals("DERECHA") && x >= 330) {
                        y += velocidad; // Gira hacia el Sur
                    } else {
                        x += velocidad; // Sigue derecho al Este
                    }
                    break;
            }
        }
    }

    // Getters y Setters
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
    
    public String getDireccion() { 
        return direccion; 
    }
    
    public void setDireccion(String direccion) { 
        this.direccion = direccion; 
    }
}
