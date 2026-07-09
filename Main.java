
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
        Carretera modelo = new Carretera();
        
        VentanaPrincipal vista = new VentanaPrincipal();
        
        ControladorCarretera controlador = new ControladorCarretera(modelo, vista);
        
        controlador.iniciarSimulacion();
    }
}
