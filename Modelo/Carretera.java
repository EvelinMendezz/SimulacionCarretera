package Modelo;


/**
 * Write a description of class Carretera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;

import java.util.concurrent.CopyOnWriteArrayList;

public class Carretera
{
    private ArrayList<Semaforo> semaforos;
    private CopyOnWriteArrayList<Carro> carrosCamino1;
    private CopyOnWriteArrayList<Carro> carrosCamino2;
    private CopyOnWriteArrayList<Carro> carrosCamino3;
    private CopyOnWriteArrayList<Carro> carrosCamino4;

    public Carretera() {
        semaforos = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            semaforos.add(new Semaforo(i));
        }
        
        carrosCamino1 = new CopyOnWriteArrayList<>();
        carrosCamino2 = new CopyOnWriteArrayList<>();
        carrosCamino3 = new CopyOnWriteArrayList<>();
        carrosCamino4 = new CopyOnWriteArrayList<>();
    }
    //GETTERS

    public ArrayList<Semaforo> getSemaforos() {
        return semaforos;
    }

    public CopyOnWriteArrayList<Carro> getCarrosCamino1() { 
        return carrosCamino1; 
    }
    
    public CopyOnWriteArrayList<Carro> getCarrosCamino2() { 
        return carrosCamino2; 
    }
    
    public CopyOnWriteArrayList<Carro> getCarrosCamino3() { 
        return carrosCamino3; 
    }
    
    public CopyOnWriteArrayList<Carro> getCarrosCamino4() { 
        return carrosCamino4; 
    }
    
    //SETTERS
    
    public void setSemaforos(ArrayList<Semaforo> semaforos) {
        this.semaforos = semaforos;
    }

    public void setCarrosCamino1(CopyOnWriteArrayList<Carro> carrosCamino1) {
        this.carrosCamino1 = carrosCamino1;
    }

    public void setCarrosCamino2(CopyOnWriteArrayList<Carro> carrosCamino2) {
        this.carrosCamino2 = carrosCamino2;
    }

    public void setCarrosCamino3(CopyOnWriteArrayList<Carro> carrosCamino3) {
        this.carrosCamino3 = carrosCamino3;
    }

    public void setCarrosCamino4(CopyOnWriteArrayList<Carro> carrosCamino4) {
        this.carrosCamino4 = carrosCamino4;
    }
}
