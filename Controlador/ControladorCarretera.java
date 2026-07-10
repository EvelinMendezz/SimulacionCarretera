package Controlador;


/**
 * Write a description of class ControladorCarretera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import Modelo.Carretera;
import Modelo.Carro;
import Vista.VentanaPrincipal;

public class ControladorCarretera
{
    private Carretera modelo;
    private VentanaPrincipal vista;
    private Object candado;
    private Object candadoAnimacion;
    private int turnoActual;

    public ControladorCarretera(Carretera modelo, VentanaPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.candado = new Object();
        this.candadoAnimacion = new Object();
        this.turnoActual = 1;
    }

    public void iniciarSimulacion() {
        // Creamos y arrancamos los 4 hilos, uno para cada camino
        for (int i = 1; i <= 4; i++) {
            Thread hiloCamino = new Thread(new HiloCamino(i));
            hiloCamino.start();
            new Thread(new HiloAnimador()).start();
        }
    }

    //comportamiento de cada hilo
    private class HiloCamino implements Runnable {
        private int idCamino;

        public HiloCamino(int idCamino) {
            this.idCamino = idCamino;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (candado) {
                    // Si no es el turno de este camino el hilo se duerme
                    while (turnoActual != idCamino) {
                        try {
                            candado.wait(); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //INICIA EL TURNO
                    //System.out.println("Camino " + idCamino + " en VERDE.");
                    modelo.getSemaforos().get(idCamino - 1).setColor("VERDE");
                    
                    //crear los 3 carros
                    for (int i = 0; i < 3; i++) {
                        //dependerán del idCamino. 
                        //variables temporales (0, 0)
                        int coordX = 0; 
                        int coordY = 0;
                        
                        switch (idCamino) {
                            case 1: coordX = 430; coordY = 200; break; 
                            case 2: coordX = 550; coordY = 330; break; 
                            case 3: coordX = 330; coordY = 550; break; 
                            case 4: coordX = 200; coordY = 430; break; 
                        }
                        
                        String direccionAleatoria = (Math.random() > 0.5) ? "DERECHO" : "DERECHA";
                        
                        // Mandamos la dirección al constructor
                        Carro nuevoCarro = new Carro(coordX, coordY, 5, idCamino, direccionAleatoria);
                        nuevoCarro.setEstado("CRUZANDO");
                        
                        // Guardamos el carro en la lista correcta del modelo
                        if(idCamino == 1) modelo.getCarrosCamino1().add(nuevoCarro);
                        if(idCamino == 2) modelo.getCarrosCamino2().add(nuevoCarro);
                        if(idCamino == 3) modelo.getCarrosCamino3().add(nuevoCarro);
                        if(idCamino == 4) modelo.getCarrosCamino4().add(nuevoCarro);
                        
                        try {
                            candado.wait(1500); 
                        } catch (InterruptedException e) {}
                    }

                    try { candado.wait(2500); } catch (InterruptedException e) {}
                    
                    modelo.getSemaforos().get(idCamino - 1).setColor("AMARILLO");
                    try { candado.wait(3000); } catch (InterruptedException e) {}
                    
                    modelo.getSemaforos().get(idCamino - 1).setColor("ROJO");
                    
                    // Extraemos los estados actuales para mandarlos a la vista
                    String c1 = modelo.getSemaforos().get(0).getColor();
                    String c2 = modelo.getSemaforos().get(1).getColor();
                    String c3 = modelo.getSemaforos().get(2).getColor();
                    String c4 = modelo.getSemaforos().get(3).getColor();

                    // Le ordenamos a la vista que actualice las imágenes
                    vista.getPanelCarretera().actualizarPantalla(c1, c2, c3, c4, null);

                    modelo.getSemaforos().get(idCamino - 1).setColor("ROJO");

                    // Se repite la extracción para actualizar la vista a rojo antes de ceder el turno
                    c1 = modelo.getSemaforos().get(0).getColor();
                    //obtener c2, c3, c4 igual que arriba
                    vista.getPanelCarretera().actualizarPantalla(c1, c2, c3, c4, null);

                    turnoActual = (turnoActual % 4) + 1;
                    candado.notifyAll();
                }
                
            }
            
        }
        
    }
    
    // Hilo dedicado a mover carros y redibujar
    private class HiloAnimador implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (candadoAnimacion) {
                    //Movemos todos los carros del modelo
                    for (Carro c : modelo.getCarrosCamino1()) c.avanzar();
                    for (Carro c : modelo.getCarrosCamino2()) c.avanzar();
                    for (Carro c : modelo.getCarrosCamino3()) c.avanzar();
                    for (Carro c : modelo.getCarrosCamino4()) c.avanzar();

                    //preparamos la lista de coordenadas para la Vista
                    java.util.ArrayList<int[]> listaCoordenadas = new java.util.ArrayList<>();
                    
                    // Juntamos todos los carros en una sola lista temporal de coordenadas
                    for (Carro c : modelo.getCarrosCamino1()) listaCoordenadas.add(new int[]{c.getX(), c.getY()});
                    for (Carro c : modelo.getCarrosCamino2()) listaCoordenadas.add(new int[]{c.getX(), c.getY()});
                    for (Carro c : modelo.getCarrosCamino3()) listaCoordenadas.add(new int[]{c.getX(), c.getY()});
                    for (Carro c : modelo.getCarrosCamino4()) listaCoordenadas.add(new int[]{c.getX(), c.getY()});

                    //Extraemos los colores actuales de los semáforos
                    String c1 = modelo.getSemaforos().get(0).getColor();
                    String c2 = modelo.getSemaforos().get(1).getColor();
                    String c3 = modelo.getSemaforos().get(2).getColor();
                    String c4 = modelo.getSemaforos().get(3).getColor();

                    //mandamos todo a la pantalla de un solo golpe
                    vista.getPanelCarretera().actualizarPantalla(c1, c2, c3, c4, listaCoordenadas);

                    //pausa de 50 milisegundos para que se vea fluido
                    try {
                        candadoAnimacion.wait(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    
}
