package Vista;
import javax.swing.JFrame;


/**
 * Write a description of class VentanaPrincipal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class VentanaPrincipal extends JFrame
{
    private PanelCarretera panelCarretera;

    public VentanaPrincipal() {
        // 1. Configuración básica de la ventana
        this.setTitle("Simulador de Carretera con Hilos");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Es importante bloquear el redimensionamiento para que las coordenadas (x,y)
        // de los semáforos y los carros siempre cuadren exactamente igual.
        this.setResizable(false); 
        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla al abrirse

        // 2. Inicializar el panel y agregarlo a la ventana principal
        panelCarretera = new PanelCarretera();
        this.add(panelCarretera);
        
        // 3. Hacer visible la ventana (se recomienda hacer esto al final del constructor)
        this.setVisible(true);
    }

    // --- GETTER PARA EL CONTROLADOR ---
    // Este método es crucial. Permite que el ControladorCarretera llame al método
    // actualizarPantalla() que programaste en el paso anterior.
    public PanelCarretera getPanelCarretera() {
        return panelCarretera;
    }
}
