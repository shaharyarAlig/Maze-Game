import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.File;

public class paint extends JPanel implements ActionListener  {
	private Timer tm;
	int size;
	int pix;
	ImageIcon i;
	public int posX,posY;
	public int maze[][];
	 Font font;
	 int temp;
	 public int destinationI,destinationJ,sourceI,sourceJ;
	Toolkit t=Toolkit.getDefaultToolkit(); 
	Image imgS,imgD,imgP;
	public paint(int s){
		tm=new Timer(5,this);
		tm.start();
		size=s;
		maze=new int[size][size];
		pix=400/size;
		i=new ImageIcon("icon\\block.png");
		posX=0;
		posY=0;
		temp=320/size;
	    font = new Font("Serif", Font.PLAIN, temp);
	    sourceI=0;
	    sourceJ=0;
	    destinationI=size-1;
	    destinationJ=size-1;
	     imgS=t.getImage("icon//home.png");
	     imgD=t.getImage("icon//flag.png"); 
	     imgP=t.getImage("icon//pointer.png");
	}

	public void actionPerformed(ActionEvent e){
		repaint();
	}
	public void paint(Graphics g){
		super.paint(g);
		this.setBackground(Color.WHITE);
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				g.setColor(Color.black);
				g.drawRect(j*pix, i*pix, pix, pix);
				g.setFont(font);
				g.drawString(Integer.toString(maze[i][j]), (j)*pix, (i+1)*pix);
				g.drawImage(imgD,destinationJ*pix , destinationI*pix, pix, pix, null);
				g.drawImage(imgS,sourceJ*pix , sourceI*pix, pix, pix, null);
			}
		}
		
		//i.paintIcon(this, g, 0, 0);
		//g.setColor(Color.RED);
		//g.fillOval(posX*pix,posY*pix,pix, pix);
		g.drawImage(imgP,posX*pix , posY*pix, pix, pix, null);
	}
	
}
