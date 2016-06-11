package graphicstest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class OtrioScreen extends Screen implements MouseListener, KeyListener{
	String GAME_STATE="PLAYING";
	String holding="NOTHING";
	Set holdSet=null;
	Game game;
	String s="";
	int players=0;
	int whoseTurn=0;
	Set p1S1=new Set(310,680,150,true,Color.MAGENTA,true);
	Set p1S2=new Set(470,680,150,true,Color.MAGENTA,true);
	Set p1S3=new Set(630,680,150,true,Color.MAGENTA,true);
	///////////////
	Set p2S1=new Set(790,200,150,true,Color.cyan,true);
	Set p2S2=new Set(790,360,150,true,Color.cyan,true);
	Set p2S3=new Set(790,520,150,true,Color.cyan,true);
	///////////////
	Set p3S1=new Set(310,40,150,true,Color.GREEN,true);
	Set p3S2=new Set(470,40,150,true,Color.GREEN,true);
	Set p3S3=new Set(630,40,150,true,Color.GREEN,true);
	///////////////
	Set p4S1=new Set(150,200,150,true,Color.red,true);
	Set p4S2=new Set(150,360,150,true,Color.red,true);
	Set p4S3=new Set(150,520,150,true,Color.red,true);
	///////////////
	Set a1=new Set(310,200,150,false,Color.black,false);
	Set a2=new Set(310,360,150,false,Color.black,false);
	Set a3=new Set(310,520,150,false,Color.black,false);
	Set a4=new Set(470,200,150,false,Color.black,false);
	Set a5=new Set(470,360,150,false,Color.black,false);
	Set a6=new Set(470,520,150,false,Color.black,false);
	Set a7=new Set(630,200,150,false,Color.black,false);
	Set a8=new Set(630,360,150,false,Color.black,false);
	Set a9=new Set(630,520,150,false,Color.black,false);
	///////////////
	Set[] gameBoard={a1,a2,a3,a4,a5,a6,a7,a8,a9};
	Set[] p1={p1S1,p1S2,p1S3};;
	Set[] p2={p2S1,p2S2,p2S3};
	Set[] p3={p3S1,p3S2,p3S3};
	Set[] p4={p4S1,p4S2,p4S3};
	Set[][] allP={p1,p2,p3,p4};
	public OtrioScreen(Game game) {
		super(game);
		this.game=game;
		game.addMouseListener(this);
		game.addKeyListener(this);
		players=Game.players;
	}
	public int[] centOf(int[][] arr){
		int[] array=new int[2];
		array[0]=arr[0][2]/2+arr[0][0];
		array[1]=arr[0][2]/2+arr[0][1];
		return array;
	}
	void pCircle(Graphics2D g2,int x1,int y1,int d,Set s,int index){
		g2.setColor(s.color[index]);
		g2.fillOval(x1, y1, d, d);
		g2.setColor(Color.gray);
		g2.fillOval(x1+25, y1+25, d-50, d-50);
	}
	void pndCircle(Graphics2D g2,Set s){
		if(s.boolS[0])	pCircle(g2,s.intS[0][0],s.intS[0][1],s.intS[0][2],s,0);
		if(s.boolS[1])	pCircle(g2,s.intS[1][0],s.intS[1][1],s.intS[1][2],s,1);
		if(s.boolS[2])	pCircle(g2,s.intS[2][0],s.intS[2][1],s.intS[2][2],s,2);
		g2.setColor(Color.black);
		g2.drawOval(s.intS[0][0], s.intS[0][1], s.intS[0][2],s.intS[0][2]);
		g2.drawOval(s.intS[1][0], s.intS[1][1], s.intS[1][2],s.intS[1][2]);
		g2.drawOval(s.intS[2][0], s.intS[2][1], s.intS[2][2],s.intS[2][2]);
	}
	@Override
	void paintScreen(Graphics2D g2) {
		g2.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		paintLS(g2);
		drawBoard(g2);
		for(int i=0;i<players;i++){
			for(int j=0;j<3;j++){
				pndCircle(g2,allP[i][j]);
			}
		}
		for(Set s: gameBoard){
			pndCircle(g2,s);
		}
		//g2.drawString(s,15,31);	
		g2.drawString("Current Player: "+(whoseTurn+1), 15, 72);
		if(GAME_STATE.equals("WON")){
			g2.drawString("PLAYER "+(whoseTurn+1)+" has won", height-120, 72);
			g2.drawString("Press R to restart", height-120, 108);
		}
		//		checkInCircle(g2,250,p1);
		//		checkInCircle(g2,520,a1);
		//		checkInCircle(g2,800,p2);

	}
	public void drawBoard(Graphics2D g2){
		g2.setColor(new Color(210,180,140));
		g2.fillRoundRect(305, 35, 480, 800, 25, 25);
		g2.fillRoundRect(145, 195, 800, 480, 25, 25);
		g2.setColor(Color.black);
		g2.drawRoundRect(305, 35, 480, 800, 25, 25);
		g2.drawRoundRect(145, 195, 800, 480, 25, 25);
		
	}
	void checkInCircle(Graphics2D g2,int x,Set s){
		g2.drawString("big circle? "+s.boolS[0], x,400);
		g2.drawString("mid circle? "+s.boolS[1], x,450);
		g2.drawString("sml circle? "+s.boolS[2], x,500);
		g2.drawString("Center: "+centOf(s.intS)[0]+" , "+centOf(s.intS)[1],x,350);
		g2.drawString("Holding "+holding, x, 200);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(GAME_STATE.equals("PLAYING")){
			String str="X: "+getMX(e)+"   Y: "+getMY(e);
			s=str;
			for(int i=0;i<players;i++){
				for(int j=0;j<3;j++){
					if(i==whoseTurn){
						checkDist(calcDist(centOf(allP[i][j].intS)[0],centOf(allP[i][j].intS)[1],getMX(e),getMY(e)),allP[i][j],e);
					}
				}
			}
			for(Set s: gameBoard){
				checkDist(calcDist(centOf(s.intS)[0],centOf(s.intS)[1],getMX(e),getMY(e)),s,e);
			}
		}
		//		prevClick[0]=currClick[0];
		//		prevClick[1]=currClick[1];
		//		currClick[0]=getMX(e);
		//		currClick[1]=getMY(e);
	}
	public void checkDist(double dist,Set s, MouseEvent e){
		if(dist<=s.intS[0][2]/2 && dist>s.intS[1][2]/2){
			if(e.getButton()==1 && holding.equals("BIG")){
				if(!s.boolS[0] && !s.player){
					s.color[0]=holdSet.color[0];
					holding="NOTHING";
					s.boolS[0]=true;
					checkWin();
					if(GAME_STATE.equals("PLAYING")) whoseTurn=(whoseTurn+1)%players;
				}
			}
			else{
				if(checkGameBoard(s)){
					if(e.getButton()==1 && holding.equals("NOTHING")){
						if(s.boolS[0]){
							holdSet=s;
							holding="BIG";
							s.boolS[0]=false;
						}
					}
				}
			}
		}
		if(e.getButton()==3 && holding.equals("BIG")){
			holding="NOTHING";
			holdSet.boolS[0]=true;
		}
		if(dist<=s.intS[1][2]/2 && dist>s.intS[2][2]/2){
			if(e.getButton()==1 && holding.equals("MID")){
				if(!s.boolS[1] && !s.player){
					s.color[1]=holdSet.color[1];
					holding="NOTHING";
					s.boolS[1]=true;
					checkWin();
					if(GAME_STATE.equals("PLAYING")) whoseTurn=(whoseTurn+1)%players;
				}
			}
			else{
				if(checkGameBoard(s)){
					if(e.getButton()==1 && holding.equals("NOTHING")){
						if(s.boolS[1]){
							holdSet=s;
							holding="MID";
							s.boolS[1]=false;
						}
					}
				}
			}
		}
		if(e.getButton()==3 && holding.equals("MID")){
			holding="NOTHING";
			holdSet.boolS[1]=true;
		}
		if(dist<=s.intS[2][2]/2){
			if(e.getButton()==1 && holding.equals("SMALL")){
				if(!s.boolS[2] && !s.player){
					s.color[2]=holdSet.color[2];
					holding="NOTHING";
					s.boolS[2]=true;
					checkWin();
					if(GAME_STATE.equals("PLAYING")) whoseTurn=(whoseTurn+1)%players;
				}
			}
			else{
				if(checkGameBoard(s)){
					if(e.getButton()==1 && holding.equals("NOTHING")){
						if(s.boolS[2]){
							holdSet=s;
							holding="SMALL";
							s.boolS[2]=false;
						}

					}
				}
			}
		}
		if(e.getButton()==3 && holding.equals("SMALL")){
			holding="NOTHING";
			holdSet.boolS[2]=true;
		}
	}
	public boolean checkGameBoard(Set s){
		boolean setCheck=true;
		for(Set set:gameBoard){
			System.out.println("SET: "+s.intS);
			System.out.println(set.intS);
			if(s.intS==set.intS) setCheck=false;
		}
		return setCheck;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public double calcDist(int x1, int y1, int x2,int y2){
		return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
	}
	public int getMX(MouseEvent e){
		return e.getX()-game.BORDER_BUFFER;
	}
	public int getMY(MouseEvent e){
		return e.getY()-game.TITLE_BUFFER;
	}
	public void checkWin(){
		for(Set s:gameBoard){
			int discC=1;
			int sizeC=1;
			Color c=s.color[0];
			for(int i=1;i<3;i++){
				if(s.color[i]==c && s.color[i]!=Color.black) discC++;
			}
			if(discC==3){
				GAME_STATE="WON";
				return;
			}
			else discC=0;
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(gameBoard[i].color[j]!=Color.black && gameBoard[i+3].color[j]!=Color.black && gameBoard[i+6].color[j]!=Color.black ){
					if(gameBoard[i].color[j]==gameBoard[i+3].color[j] && gameBoard[i+6].color[j]==gameBoard[i+3].color[j]){
						GAME_STATE="WON";
						return;
					}
				}
				if(gameBoard[3*i].color[j]!=Color.black && gameBoard[3*i+1].color[j]!=Color.black && gameBoard[3*i+2].color[j]!=Color.black ){
					if(gameBoard[3*i].color[j]==gameBoard[3*i+1].color[j] && gameBoard[3*i+2].color[j]==gameBoard[3*i+1].color[j]){
						GAME_STATE="WON";
						return;
					}
				}
			}
			if(gameBoard[3*i+1].color[1]!=Color.black){
				if((gameBoard[3*i].color[0]==gameBoard[3*i+1].color[1] || gameBoard[3*i].color[2]==gameBoard[3*i+1].color[1])&&
					(gameBoard[3*i+2].color[0]==gameBoard[3*i+1].color[1] || gameBoard[3*i+2].color[2]==gameBoard[3*i+1].color[1])){
					GAME_STATE="WON";
					return;
				}
			}
			if(gameBoard[i+3].color[1]!=Color.black){
				if((gameBoard[i].color[0]==gameBoard[i+3].color[1] || gameBoard[i].color[2]==gameBoard[i+3].color[1])&&
					(gameBoard[i+6].color[0]==gameBoard[i+3].color[1] || gameBoard[i+6].color[2]==gameBoard[i+3].color[1])){
					GAME_STATE="WON";
					return;
				}
			}
		}
		for(int i=0;i<3;i+=2){
			for(int j=0;j<3;j++){
				if(gameBoard[i].color[j]!=Color.black && gameBoard[4].color[j]!=Color.black && gameBoard[(-i+8)].color[j]!=Color.black ){
					if(gameBoard[i].color[j]==gameBoard[4].color[j] && gameBoard[(-i+8)].color[j]==gameBoard[4].color[j]){
						GAME_STATE="WON";
						return;
					}
				}
			}
			if(gameBoard[4].color[1]!=Color.black){
				if((gameBoard[i].color[0]==gameBoard[4].color[1] || gameBoard[i].color[2]==gameBoard[4].color[1])&&
					(gameBoard[(-i+8)].color[0]==gameBoard[4].color[1] || gameBoard[(-i+8)].color[2]==gameBoard[4].color[1])){
					GAME_STATE="WON";
					return;
				}
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==e.VK_R){
			if(GAME_STATE.equals("WON")) game.setScreen(new StartScreen(game));
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
