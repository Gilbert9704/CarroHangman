package Carro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Carro extends JPanel implements ActionListener, KeyListener{
	
	private static final long serialVersionUID = 1L;
	
	private int x;
    private int y;
    private int X[] = {20, 40, 80, 100};
    private int Y[] = {40, 20, 20, 40};
    private Timer timer;
    
    Polygon poligono = new Polygon(X, Y, 4);
    
    public Carro(){
    	this.timer = new Timer(5, this);
        this.setFocusable(true);
        addKeyListener(this);
        this.timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //Ruedas
        g.setColor(Color.BLACK);
        g.fillOval(x+12, y+59, 25, 25);//x,y,ancho,alto
        g.fillOval(x+82, y+59, 25, 25);
        //Rectangulo
        g.setColor(Color.BLUE);
        g.fillRect(x+10, y+40, 100, 20);
        g.setColor(Color.GRAY);
        g.fillPolygon(poligono);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        repaint();
    }
    
    //PREGUNTAR COMO MOVER EL POLIGONO
    public void keyPressed(KeyEvent ke){
        switch (ke.getKeyCode()){
            case KeyEvent.VK_LEFT: x -= 10; break;
            case KeyEvent.VK_RIGHT: x += 10; break;
            case KeyEvent.VK_UP: x+= 30; break;
            case KeyEvent.VK_DOWN: x+= 1; break;
        }
        poligono.translate(x-1, 0); //
        repaint();
    }
    
    public void keyTyped(KeyEvent e){
        
    }

    public void keyReleased(KeyEvent e) {
            
    }
}
