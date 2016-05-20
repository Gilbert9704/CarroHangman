package HangMan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class HangMan extends JPanel implements ActionListener, KeyListener{
	
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private Timer timer;
	
	public HangMan(){
		this.timer = new Timer(5, this);
        this.setFocusable(true);
        addKeyListener(this);
        this.timer.start();
	}
	
	@Override
    protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//Cabeza
		//x,y,ancho(x),alto(y)
		g.drawOval(200, 20, 70, 70);
		g.drawLine(235, 90, 235, 250);
		g.drawLine(235, 250, 160, 350);
		g.drawLine(235, 250, 300, 350);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
