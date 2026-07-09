package Vista;


/**
 * Write a description of class PanelCarretera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

public class PanelCarretera extends JPanel
{

    private Image imgFondo;
    private Image imgCarro;
    private String[] coloresSemaforos;
    private ArrayList<int[]> coordenadasCarros;

    public PanelCarretera() {
        // Inicializamos
        coloresSemaforos = new String[]{"ROJO", "ROJO", "ROJO", "ROJO"};
        coordenadasCarros = new ArrayList<>();
        
        imgFondo = new ImageIcon("Imagenes/fondo_carretera.png").getImage();
        imgCarro = new ImageIcon("Imagenes/carrito.png").getImage();
    }
    

    //Controlador le pasa toda la información visual
    public void actualizarPantalla(String s1, String s2, String s3, String s4, ArrayList<int[]> carros) {
        coloresSemaforos[0] = s1;
        coloresSemaforos[1] = s2;
        coloresSemaforos[2] = s3;
        coloresSemaforos[3] = s4;
        
        // Actualizamos la lista de carritos con las coordenadas
        this.coordenadasCarros = carros;
        
        //redibujado de pantalla
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // 1. dibuja el mapa en base a la imagen
        g.drawImage(imgFondo, 0, 0, 800, 800, this);

        // Semaforos
        // Camino 1 (Norte)
        g.setColor(coloresSemaforos[0].equals("VERDE") ? Color.GREEN : Color.RED);
        g.fillOval(240, 240, 50, 50); 
        
        // Camino 2 (Este)
        g.setColor(coloresSemaforos[1].equals("VERDE") ? Color.GREEN : Color.RED);
        g.fillOval(510, 240, 50, 50); 
        
        // Camino 3 (Sur)
        g.setColor(coloresSemaforos[2].equals("VERDE") ? Color.GREEN : Color.RED);
        g.fillOval(510, 510, 50, 50); 
        
        // Camino 4 (Oeste)
        g.setColor(coloresSemaforos[3].equals("VERDE") ? Color.GREEN : Color.RED);
        g.fillOval(240, 510, 50, 50); 

        // 3. colocando los carros
        if (coordenadasCarros != null) {
            for (int[] coord : coordenadasCarros) {
                
                g.drawImage(imgCarro, coord[0], coord[1], 40, 40, this); 
            }
        }
    }
    
}
