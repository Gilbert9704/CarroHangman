package Carro;

import java.awt.Dimension;
import javax.swing.JFrame;

public class PrincipalCarro {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
        frame.setTitle("Carro");
        frame.setSize(new Dimension(1000, 700));
        frame.add(new Carro());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
