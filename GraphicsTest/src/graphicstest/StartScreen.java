package graphicstest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartScreen extends Screen implements KeyListener{
	int selected=2;
	Color bgS=Color.darkGray;
	Color bgUS=Color.BLACK;
	Color fS=Color.magenta;
	Color fUS=Color.white;
	Game game;
	public StartScreen(Game game) {
		super(game);
		this.game=game;
		game.addKeyListener(this);
	}
	@Override
	void paintScreen(Graphics2D g2) {
		paintLS(g2);
		g2.setFont(new Font("ComicSans", Font.PLAIN, 32));
		g2.setColor(Color.black);
		g2.drawString("Welcome to Otrio",width/3,40);
		g2.drawString("How many players?",width/3,height-220);
		g2.drawString("Otrio is an excellent 2-4 player head-to-head strategy game!", 50, 100);
		g2.drawString("The rules of Otrio are simple. Win in three different ways:", 50, 140);
		g2.drawString("- Get 3 circular pieces of your color in a row", 50, 180);
		g2.drawString("in either ascending or descending order,",50,220);
		g2.drawString("- The same sized pieces in a row,", 50, 260);
		g2.drawString("- 3 concentric pieces in the same space.", 50, 300);
		g2.drawString("Controls: ", 50, 350);
		g2.drawString("Click on a piece when it's your turn and click on an empty board ", 50, 390);
		g2.drawString("Right Click to cancel a move", 50, 430);
		g2.drawString("The game should hopefully determine if you won or not", 50, 470);
		g2.drawString("Counter-Clock wise, Player 1 is the bottom",50,510);
		
		if(selected==2) paintBox(g2,width/3,height-200,2,50,fS,bgS);
		else paintBox(g2,width/3,height-200,2,50,fUS,bgUS);
		
		if(selected==3)paintBox(g2,width/3+80,height-200,3,50,fS,bgS);
		else paintBox(g2,width/3+80,height-200,3,50,fUS,bgUS);
		
		if(selected==4)paintBox(g2,width/3+160,height-200,4,50,fS,bgS);
		else paintBox(g2,width/3+160,height-200,4,50,fUS,bgUS);
		
	}
	public void paintBox(Graphics2D g2,int x,int y,int number,int size,Color fc,Color bg){
		g2.setColor(bg);
		g2.fillRect(x, y, size, size);
		g2.setColor(fc);
		g2.drawString(""+number, x+size/3, y+(3*size/4));
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			selected++;
			if(selected==5) selected=2;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			selected--;
			if(selected==1) selected=4;
		}
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			game.players=selected;
			game.setScreen(new OtrioScreen(game));
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public KeyListener getKeyListener() {
		return this;
	}
}
