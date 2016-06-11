package graphicstest;

import java.awt.Color;

public class Set {
	int[][] intS=new int[3][3];
	boolean[] boolS=new boolean[3];
	Color[] color;
	boolean player;
	public Set(int x1,int y1,int d,boolean value,Color c,boolean player){
		color=new Color[]{c,c,c};
		setIntS();
		intS[0]=new int[]{x1,y1,d};
		intS[1]=new int[]{intS[0][0]+25,intS[0][1]+25,intS[0][2]-50};
		intS[2]=new int[]{intS[1][0]+25,intS[1][1]+25,intS[1][2]-50};
		setBoolS(value);
		this.player=player;
	}
	public void setBoolS(boolean value){
		for(int i=0;i<boolS.length;i++){
			boolS[i]=value;
		}
	}
	public void setIntS(){
		for(int i=0;i<intS.length;i++){
			for(int j=0;j<intS[0].length;j++){
				intS[i][j]=0;
			}
		}
	}
}
