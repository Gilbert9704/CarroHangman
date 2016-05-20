package HangMan;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class HangManPanel extends JPanel{

    
	private static final long serialVersionUID = 1L;
	int palindromeRadius = 150;
    int radioCirculo = 10;
    int anguloIzq = 120;
    int anguloDer = 60;
    int angulo = anguloIzq; // empieza desde el angulo izquierdo
    int anguloOscl = 1; // intervalo de oscilacion
    int delay = 100;
    
    Timer timer = new Timer(delay, new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		repaint();
    	}
    });
    
    //Constructor
    public HangManPanel() {
    	timer.start();
      
     	this.addKeyListener(new KeyAdapter() {
        
     	public void keyPressed(KeyEvent e) {
     		switch (e.getKeyCode()) {
     			case KeyEvent.VK_DOWN: delay += 10; break;
     			case KeyEvent.VK_UP: delay -= 10; break;
     			case KeyEvent.VK_S: timer.stop(); break;
     			case KeyEvent.VK_R: timer.start(); break;
     		}

        if (delay < 0){
        	delay = 10; // el retardo no puede ser negativo
        }
        timer.setDelay(delay);
     	}});
      
     	setFocusable(true);
    }
    
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      //g.drawArc(20, 200, 80, 40, 0, 180); // Base  
      g.drawRect(20, 200, 80, 20);
      g.drawLine(60, 200, 60, 20); // Tallo 
      g.drawLine(60, 20, 160, 20); // Barra superior 

      if (angulo < anguloDer)
        anguloOscl = 1; // oscila a la izquierda
      else if (angulo > anguloIzq)
        anguloOscl = -1; // oscila a la derecha
            
      angulo += anguloOscl;
      
      int x2;
      int y2;
      int x3;
      int y3;
      int x1 = 160;
      int y1 = 20;
      int radio = 20;
      int x = x1 + (int)(radio * Math.cos(Math.toRadians(angulo)));
      int y = y1 + (int)(radio * Math.sin(Math.toRadians(angulo)));
      double angulo1;
      g.drawLine(160, 20, x, y); // Dibuja lo que sostiene al muñeco

      // Dibuja el circulo (La Cabeza)
      double longitud = 40;
      x = x1 + (int)(longitud * Math.cos(Math.toRadians(angulo)));
      y = y1 + (int)(longitud * Math.sin(Math.toRadians(angulo)));      
      g.drawOval(x - radio, y - radio, 2 * radio, 2 * radio);

      // Dibuja el cuerpo
      longitud = 60;
      x2 = x1 + (int)(longitud * Math.cos(Math.toRadians(angulo)));
      y2 = y1 + (int)(longitud * Math.sin(Math.toRadians(angulo)));
      
      longitud = 120;
      x3 = x1 + (int)(longitud * Math.cos(Math.toRadians(angulo)));
      y3 = y1 + (int)(longitud * Math.sin(Math.toRadians(angulo)));
      
      g.drawLine(x2, y2, x3, y3);//
      
      // Dibuja la pierna izquierda
      longitud = distance(x1, y1, 120, radio + 160);     
      angulo1 = Math.toDegrees(Math.asin(40.0 / longitud));
      int x4 = x1 + (int)(longitud * Math.cos(Math.toRadians(angulo + angulo1)));
      int y4 = y1 + (int)(longitud * Math.sin(Math.toRadians(angulo + angulo1)));
      
      g.drawLine(x3, y3, x4, y4);//

      // Dibuja la pierna derecha
      angulo1 = -Math.toDegrees(Math.asin(40.0 / longitud));
      x4 = x1 + (int)(longitud * Math.cos(Math.toRadians(angulo + angulo1)));
      y4 = y1 + (int)(longitud * Math.sin(Math.toRadians(angulo + angulo1)));    
      
      g.drawLine(x3, y3, x4, y4);//
      
      // Dibuja el brazo izquierdo       
      longitud = (int)distance(x1, y1, 100, radio + 100);
      angulo1 = Math.toDegrees(Math.asin(60 / longitud));//Math.toDegrees(Math.asin(radio * Math.cos(Math.toRadians(45)) / longitud));
      x3 = x1 + (int)(longitud * Math.cos(Math.toRadians(angulo + angulo1)));
      y3 = y1 + (int)(longitud * Math.sin(Math.toRadians(angulo + angulo1)));           
     
      g.drawLine(x2, y2, x3, y3);//
      
      // Dibuja el brazo derecho    
      longitud = (int)distance(x1, y1, 220, radio + 100);
      angulo1 = - Math.toDegrees(Math.asin(60 / longitud));
      x3 = x1 + (int)(longitud * Math.cos(Math.toRadians(angulo + angulo1)));
      y3 = y1 + (int)(longitud * Math.sin(Math.toRadians(angulo + angulo1))); 
      
      g.drawLine(x2, y2, x3, y3);//   
    }

    /** Calcula la distancia entre dos puntos (x1, y1) y (x2, y2)*/
    public static double distance(double x1, double y1, double x2, double y2) {
      return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}