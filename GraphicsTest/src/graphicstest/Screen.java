package graphicstest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public abstract class Screen{
	BufferedImage screenImage;
	int width;
	int height;
	public Screen(Game game){
		this.width=game.getWidth();
		this.height=game.getHeight();
		screenImage=new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) screenImage.getGraphics();
	}
	BufferedImage getImage(){
		return screenImage;
	}
	abstract void paintScreen(Graphics2D g2);
	public void update(){
		Graphics2D g2 = (Graphics2D) screenImage.getGraphics();
		paintScreen(g2);
	}
	public void paintLS(Graphics2D g2){
		g2.setColor(Color.gray);
		g2.fillRect(0,0,width,height);
	}
}
