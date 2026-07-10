package Vista;
import javax.swing.JFrame;
import java.awt.BorderLayout;

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
        //Configuracion de la ventana
        this.setTitle("Simulador de Carretera con Hilos");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setResizable(true); 
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());
        
        
        panelCarretera = new PanelCarretera();
        this.add(panelCarretera);
        
        this.setVisible(true);
    }

    //Permite que el ControladorCarretera llame al método actualizarPantalla()
    public PanelCarretera getPanelCarretera() {
        return panelCarretera;
    }
}
