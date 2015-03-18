import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasketBall {

	private int width = 800;
	private int height = 385;
	private int y = height/2;
	private int x = width/2;
	private int scalex=20;
	private int scaley=15;
	int fieldleft = 100;
	int fieldright = 580;
	private int v=0;
	private int vx=2;
	private int vsx=1;
	private int r=20;
	
	public static void main(String[] args) throws IOException {
		
						
		final BasketBall b = new BasketBall();
		JPanel panel = new JPanel() {
			
			@Override
			public void paintComponent(Graphics g) {
				g.setColor(Color.ORANGE);
				g.fillOval(b.x-b.r, b.y-b.r, 2*b.r, 2*b.r);
			}
		};
		
		JFrame frame = new JFrame();
		frame.setContentPane(panel);
		panel.setSize(b.width, b.height);
   	    frame.setSize(b.width, b.height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		while (true) {
			b.simulate();
			frame.repaint();
		
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void simulate() {
		y = y + v;
		v = v + 1;
		x = x + vx;
		if(x%25==0) 
		  { 
			scalex = scalex + vsx;
			scaley = scaley + vsx;
		  }
		if ((y >= 250 && x>400) || (y >= 200 && x<=400 && x>= 250) || (y >= 150 && x<250)) {
			v = -v;
		}
		System.out.println(x+" "+y);
		if( x >= fieldright) {
			vx=-vx;
			vsx=-vsx;
		}
		if( x <= fieldleft) {
			vx=-vx;
			vsx=-vsx;
		}
	}
	
	
}














