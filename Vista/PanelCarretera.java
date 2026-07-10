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
        
        imgFondo = new ImageIcon("Imagenes/fondo_carretera3.png").getImage();
        imgCarro = new ImageIcon("Imagenes/carrito3.png").getImage();
        
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
        
        // mapa en base a la imagen
        g.drawImage(imgFondo, 0, 0, 800, 800, this);

        // Semaforos
        // Camino 1 (Norte)
        g.setColor(Color.DARK_GRAY);
        g.fillRect(250, 250, 65, 45); // Cajita gris de 30x30
        if (coloresSemaforos[0].equals("VERDE")) g.setColor(Color.GREEN);
        else if (coloresSemaforos[0].equals("AMARILLO")) g.setColor(Color.YELLOW);
        else g.setColor(Color.RED);
        g.fillOval(260, 255, 35, 35);
        
        // Camino 2 (Este)
        g.setColor(Color.DARK_GRAY);
        g.fillRect(520, 250, 45, 65);
        if (coloresSemaforos[1].equals("VERDE")) g.setColor(Color.GREEN);
        else if (coloresSemaforos[1].equals("AMARILLO")) g.setColor(Color.YELLOW);
        else g.setColor(Color.RED);
        g.fillOval(525, 260, 35, 35); 
        
        // Camino 3 (Sur)
        g.setColor(Color.DARK_GRAY);
        g.fillRect(500, 520, 65, 45);
        if (coloresSemaforos[2].equals("VERDE")) g.setColor(Color.GREEN);
        else if (coloresSemaforos[2].equals("AMARILLO")) g.setColor(Color.YELLOW);
        else g.setColor(Color.RED);
        g.fillOval(520, 525, 35, 35); 
        
        // Camino 4 (Oeste)
        g.setColor(Color.DARK_GRAY);
        g.fillRect(250, 500, 45, 65);
        if (coloresSemaforos[3].equals("VERDE")) g.setColor(Color.GREEN);
        else if (coloresSemaforos[3].equals("AMARILLO")) g.setColor(Color.YELLOW);
        else g.setColor(Color.RED);
        g.fillOval(255, 508, 35, 35);

        // colocarcarros
        if (coordenadasCarros != null) {
            for (int[] coord : coordenadasCarros) {
                g.drawImage(imgCarro, coord[0], coord[1], 40, 40, this);
            }
        }
    }
    
}
