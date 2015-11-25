import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;


public class Board extends JPanel implements ActionListener {
	int size,pix;
	private Timer tm;
	public int destinationI,destinationJ,sourceI,sourceJ;
	Toolkit t=Toolkit.getDefaultToolkit(); 
	Image grass,wall,player,home,flag,gover,lineH,lineV,dot;
	int maze[][];
	int boyI=0,boyJ=0;
	int pathX[],pathY[];
	int sI,sJ;
	int dI,dJ;
	int c=0;
	int allpathX[],allpathY[];
	int foundC;
	public Board(int s,int array[][]){
		foundC=0;
		pathX=new int[s*s];
		pathY=new int[s*s];
		allpathX=new int[s*s];
		allpathY=new int [s*s];
		tm=new Timer(500,this);
		tm.start();
		maze=new int[s][s];
		maze=array;
		size=s;
		pix=640/size;
		grass=t.getImage("icon//grass.png");
	    wall=t.getImage("icon//wall.png"); 
	    player=t.getImage("icon//boy.png");
	    home=t.getImage("icon//bighome.png");
	    flag=t.getImage("icon//bflag.png");
	    gover=t.getImage("icon//gameover.png");
	    lineH=t.getImage("icon//gameover.png");
	    lineV=t.getImage("icon//gameover.png");
	    dot=t.getImage("icon//dot.png");
	    boyI=sourceI;
	    boyJ=sourceJ;
	   // pathX[0]=0;pathX[1]=0;pathX[2]=0;pathX[3]=1;pathX[4]=2;pathX[5]=3;pathX[6]=3;
	   //pathY[0]=0;pathY[1]=1;pathY[2]=2;pathY[3]=2;pathY[4]=2;pathY[5]=2;pathY[6]=3;
	}

	public void actionPerformed(ActionEvent e){
		if(foundC==0){
			if(allpathX[c]==0&& allpathY[c]==0 && c!=0){
				c--;
			}
			boyI=allpathX[c];
			boyJ=allpathY[c];
			c++;
		}else
		{
			if(pathX[c]==0&& pathY[c]==0 && c!=0){
				c--;
			}
			boyI=pathX[c];
			boyJ=pathY[c];
			c++;
		}
		repaint();
	}
	public void paint(Graphics g){
		super.paint(g);
		this.setBackground(Color.white);
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(maze[i][j]==0){
					g.drawImage(wall,j*pix , i*pix, pix, pix, null);
				}else{
					g.drawImage(grass,j*pix , i*pix, pix, pix, null);
				}
			}
		}
		g.drawImage(home,sJ*pix, sI*pix, pix, pix, null);
		if(foundC==1){
			g.drawImage(player,boyJ*pix, boyI*pix, pix, pix, null);	
		}
		if(foundC==0){
			//g.drawImage(player,boyJ*pix, boyI*pix, pix, pix, null);
			g.drawImage(gover,100, 100, 400, 200, null);
		}
		g.drawImage(flag,dJ*pix, dI*pix, pix, pix, null);
		g.setColor(Color.RED);
		
	}
	
}
