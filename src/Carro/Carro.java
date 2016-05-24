package Carro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Carro extends JPanel implements ActionListener, KeyListener{
	
	private static final long serialVersionUID = 1L;
	
	private int x;
    private int y;
    
    private Timer timer;
    
    
    public Carro(){
    	this.timer = new Timer(5, this);
        this.setFocusable(true);
        addKeyListener(this);
        this.timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //Poligono
        Polygon poligono = new Polygon();
        g.setColor(Color.GRAY);
        poligono.addPoint(20 + this.x, 40 + this.y);
        poligono.addPoint(40 + this.x, 20 + this.y);
        poligono.addPoint(80 + this.x, 20 + this.y);
        poligono.addPoint(100 + this.x, 40 + this.y);
        g.fillPolygon(poligono);
        //Ruedas
        g.setColor(Color.BLACK);
        g.fillOval(x+12, y+59, 25, 25);//x,y,ancho,alto
        g.fillOval(x+82, y+59, 25, 25);
        //Rectangulo
        g.setColor(Color.BLUE);
        g.fillRect(x+10, y+40, 100, 20);
        
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
            case KeyEvent.VK_UP: y -= 10 ; break;
            case KeyEvent.VK_DOWN: y += 10; break;
        }
        repaint();
    }
    
    public void keyTyped(KeyEvent e){}

    public void keyReleased(KeyEvent e) {}
    
}
