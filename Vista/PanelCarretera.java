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

    private Image imgRojo;
    private Image imgVerde;
    private String[] coloresSemaforos;
    private ArrayList<int[]> coordenadasCarros; // Lista para recibir X y Y de los carros
    private Image imgFondo;
    private Image imgCarro;

    public PanelCarretera() {
        // Inicializamos los arreglos y listas
        coloresSemaforos = new String[]{"ROJO", "ROJO", "ROJO", "ROJO"};
        coordenadasCarros = new ArrayList<>();
        
        imgRojo = new ImageIcon("rojo.png").getImage();
        imgVerde = new ImageIcon("verde.png").getImage();
        
        // Cargamos el mapa y el carrito
        imgFondo = new ImageIcon("fondo_carretera.png").getImage();
        imgCarro = new ImageIcon("carrito.png").getImage();
    }

    // Método único para que el Controlador le pase toda la información visual
    public void actualizarPantalla(String s1, String s2, String s3, String s4, ArrayList<int[]> carros) {
        coloresSemaforos[0] = s1;
        coloresSemaforos[1] = s2;
        coloresSemaforos[2] = s3;
        coloresSemaforos[3] = s4;
        
        // Actualizamos la lista de carritos con las coordenadas puras
        this.coordenadasCarros = carros;
        
        // Forzamos el redibujado de la pantalla
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // 1. Fondo (Pasto verde para que resalte la carretera)
        g.setColor(new Color(34, 139, 34)); 
        g.fillRect(0, 0, 800, 800);

        // 2. Carreteras (Gris oscuro)
        g.setColor(Color.DARK_GRAY);
        // Calle vertical (x de 300 a 500, abarca todo el alto)
        g.fillRect(300, 0, 200, 800); 
        // Calle horizontal (y de 300 a 500, abarca todo el ancho)
        g.fillRect(0, 300, 800, 200); 

        // 3. Líneas divisorias amarillas punteadas
        g.setColor(Color.YELLOW);
        for (int i = 0; i < 800; i += 40) {
            // Condición para no pintar rayas amarillas en medio del cruce donde chocan los carros
            if (i < 300 || i > 480) {
                g.fillRect(395, i, 10, 20); // Línea punteada vertical
                g.fillRect(i, 395, 20, 10); // Línea punteada horizontal
            }
        }

        // 4. Semáforos (Ubicados en las 4 esquinas exteriores de la intersección)
        // 4. Semáforos (Prueba con círculos de colores puros)
        
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
        //Image sem1 = coloresSemaforos[0].equals("VERDE") ? imgVerde : imgRojo;
        //Image sem2 = coloresSemaforos[1].equals("VERDE") ? imgVerde : imgRojo;
        //Image sem3 = coloresSemaforos[2].equals("VERDE") ? imgVerde : imgRojo;
        //Image sem4 = coloresSemaforos[3].equals("VERDE") ? imgVerde : imgRojo;

        // Ajustados a 50x50 píxeles justo fuera del cuadro de 300-500
        //g.drawImage(sem1, 240, 240, 50, 50, this); // Camino 1 (Norte)
        //g.drawImage(sem2, 510, 240, 50, 50, this); // Camino 2 (Este)
        //g.drawImage(sem3, 510, 510, 50, 50, this); // Camino 3 (Sur)
        //g.drawImage(sem4, 240, 510, 50, 50, this); // Camino 4 (Oeste)

        // 5. Dibujo de Carros
        g.setColor(Color.CYAN); // Puedes cambiar el color o usar imágenes después
        if (coordenadasCarros != null) {
            for (int[] coord : coordenadasCarros) {
                // coord[0] es la posición X, coord[1] es la posición Y
                // Dibujamos el carro como un cuadrado de 40x40 píxeles
                g.fillRect(coord[0], coord[1], 40, 40); 
            }
        }
    }
}
