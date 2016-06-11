package graphicstest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JFrame{public Game() {
	// TODO Auto-generated constructor stub
}	public static final int BORDER_BUFFER=8;
	public static final int TITLE_BUFFER=31;
	static int players=0;
	int screenWidth;
	int screenHeight;
	BufferedImage screen;
	Screen newScreen;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game(1080,920);
	}
	public Game(int width,int height){
		this.screenWidth=width;
		this.screenHeight=height;
		centerFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reset();
		this.setResizable(false);
		setVisible(true);
		Timer timer = new Timer(30, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newScreen.update();
				Game.this.repaint();
			}
		});
		timer.start();
	}
	public void centerFrame(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int monitorWidth = (int) screenSize.getWidth();
		int monitorHeight = (int) screenSize.getHeight();
		setSize(screenWidth,screenHeight);
		int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
	    int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
	    setLocation(x, y);
	}
	public void paint(Graphics g){
		screen=new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) screen.getGraphics();
		BufferedImage img=newScreen.getImage();
		g2.drawImage(img, 0,0, screenWidth, screenHeight,null);
		g.drawImage(screen, 0, TITLE_BUFFER-10, null);
	}
	public int getWidth(){
		return screenWidth;
	}
	public int getHeight(){
		return screenHeight;
	}
	public void reset(){
		Screen screen=new StartScreen(this);
		setScreen(screen);
		screen.update();
		repaint();
	}
	public void setScreen(Screen screen){
		newScreen=screen;
	}
}
