package HangMan;

import java.awt.Dimension;
import javax.swing.JFrame;

public class PrincipalHangMan {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("HangMan");
		frame.setSize(new Dimension(500, 500));
		frame.add(new HangMan());
		frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
