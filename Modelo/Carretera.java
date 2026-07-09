package Modelo;


/**
 * Write a description of class Carretera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class Carretera
{
    private ArrayList<Semaforo> semaforos;
    private ArrayList<Carro> carrosCamino1;
    private ArrayList<Carro> carrosCamino2;
    private ArrayList<Carro> carrosCamino3;
    private ArrayList<Carro> carrosCamino4;

    public Carretera() {
        semaforos = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            semaforos.add(new Semaforo(i));
        }
        carrosCamino1 = new ArrayList<>();
        carrosCamino2 = new ArrayList<>();
        carrosCamino3 = new ArrayList<>();
        carrosCamino4 = new ArrayList<>();
    }

    // --- GETTERS ---

    public ArrayList<Semaforo> getSemaforos() {
        return semaforos;
    }

    public ArrayList<Carro> getCarrosCamino1() {
        return carrosCamino1;
    }

    public ArrayList<Carro> getCarrosCamino2() {
        return carrosCamino2;
    }

    public ArrayList<Carro> getCarrosCamino3() {
        return carrosCamino3;
    }

    public ArrayList<Carro> getCarrosCamino4() {
        return carrosCamino4;
    }
    
    // --- SETTERS (Opcionales, por si necesitan reescribir la lista completa) ---
    
    public void setSemaforos(ArrayList<Semaforo> semaforos) {
        this.semaforos = semaforos;
    }

    public void setCarrosCamino1(ArrayList<Carro> carrosCamino1) {
        this.carrosCamino1 = carrosCamino1;
    }

    public void setCarrosCamino2(ArrayList<Carro> carrosCamino2) {
        this.carrosCamino2 = carrosCamino2;
    }

    public void setCarrosCamino3(ArrayList<Carro> carrosCamino3) {
        this.carrosCamino3 = carrosCamino3;
    }

    public void setCarrosCamino4(ArrayList<Carro> carrosCamino4) {
        this.carrosCamino4 = carrosCamino4;
    }
}
