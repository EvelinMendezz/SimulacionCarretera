
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import Modelo.Carretera;
import Vista.VentanaPrincipal;
import Controlador.ControladorCarretera;

public class Main {
    public static void main(String[] args) {
        
        // 1. Instanciamos los datos puros (Modelo)
        Carretera modelo = new Carretera();
        
        // 2. Instanciamos la interfaz gráfica (Vista)
        VentanaPrincipal vista = new VentanaPrincipal();
        
        // 3. Instanciamos el cerebro y le inyectamos las dependencias (Controlador)
        ControladorCarretera controlador = new ControladorCarretera(modelo, vista);
        
        // 4. Damos la orden de arrancar la simulación y los hilos
        controlador.iniciarSimulacion();
    }
}
