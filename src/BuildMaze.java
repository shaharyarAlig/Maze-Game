import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class BuildMaze extends JFrame{
	bgmusic obj_music;
	JFrame f1,f2,f3;
	JComboBox box = new JComboBox();
	JLabel lb1,lb2,lb3;
	JButton bt1;
	JButton bt2,bt3,bt4,bt5,start,s,d;
	JButton value;
	int size=4;
	int maze[][];
	int posX=0,posY=0;
	int vtoggle=0;
	Font font = new Font("SansSerif", Font.BOLD, 30);
	paint pobj;
	Board bobj;
	int destinationI,destinationJ,sourceI,sourceJ;
	int pathX[],pathY[]; // storing the path 
	int cX=0,cY=0; // counter 
	int cAllx=0,cAlly=0;
	public BuildMaze(){
		loadBox();
		f1=new JFrame();
		f1.setTitle("MAZE GAME");
		f1.setSize(600, 400);
		f1.setLocationRelativeTo(null);
		f1.setLayout(null);
		f1.setVisible(true);
		f1.setResizable(false);
		box.setBounds(200, 125, 80, 30);
		lb1.setBounds(150, 10, 300, 80);
		lb2.setBounds(50,120,100, 50);
		lb3.setBounds(20,200,400,100);
		bt1.setBounds(320, 110, 215, 58);
		bt1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String value=box.getSelectedItem().toString();
				size=Integer.parseInt(value);
				//lb3.setText(value);
				load2();
				f2.setVisible(true);
				f1.setVisible(false);
				
			}
		});
		f1.add(box);
		f1.add(lb1);
		f1.add(lb2);
		f1.add(bt1);
		f1.add(lb3);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.revalidate();
	}
	
	public void loadBox(){
		lb1=new JLabel();
		lb2=new JLabel();
		lb3=new JLabel();
		bt1=new JButton();
		for(int i=0;i<=12;i++){
			box.addItem(Integer.toString(i+4));
		}
		lb1.setIcon(new ImageIcon("icon//maze.png"));
		lb2.setIcon(new ImageIcon("icon//mazesize.png"));
		bt1.setIcon(new ImageIcon("icon//next.png"));
	}
	public void load2(){
		pobj=new paint(size);
		maze=new int[size][size];
		sourceI=0;
	    sourceJ=0;
	    destinationI=size-1;
	    destinationJ=size-1;
		f2=new JFrame();
		f2.setTitle("MAZE GAME");
		f2.setSize(800, 600);
		f2.setLocationRelativeTo(null);
		f2.setLayout(null);
		f2.setVisible(true);
		f2.setResizable(false);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bt2=new JButton();bt3=new JButton();bt4=new JButton();bt5=new JButton();
		bt2.setIcon(new ImageIcon("icon//up.png"));
		bt3.setIcon(new ImageIcon("icon//down.png"));
		bt4.setIcon(new ImageIcon("icon//left.png"));
		bt5.setIcon(new ImageIcon("icon//right.png"));
		bt2.setBounds(110, 179, 80, 82);
		bt3.setBounds(110, 339, 80, 82);
		bt4.setBounds(30, 261, 80, 78);
		bt5.setBounds(190, 261, 80, 78);
		value=new JButton();
		value.setIcon(new ImageIcon("icon//0.png"));
		final JLabel ljb1=new JLabel();
		final JLabel ljb2=new JLabel();
		final JLabel ljb3=new JLabel();
		final JLabel ljb4=new JLabel(Integer.toString(posX));
		final JLabel ljb5=new JLabel(Integer.toString(posY));
		ljb1.setIcon(new ImageIcon("icon//row.png"));
		ljb2.setIcon(new ImageIcon("icon//column.png"));
		ljb3.setIcon(new ImageIcon("icon//value.png"));
		ljb1.setBounds(10, 10, 80, 50);
		ljb2.setBounds(90, 10, 220, 50);
		ljb3.setBounds(220, 10, 100, 50);
		ljb4.setBounds(25, 60, 50, 50);
		ljb5.setBounds(130, 60, 50, 50);
		value.setBounds(245, 60, 50, 38);
		ljb4.setFont(font);
		ljb5.setFont(font);
		bt2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				posY--;
				pobj.posY=posY;
				if(posY<0){
					posY=0;
					pobj.posY=0;
				}
				ljb4.setText(Integer.toString(posY));
				ljb5.setText(Integer.toString(posX));
				if(maze[posY][posX]==0){
					value.setIcon(new ImageIcon("icon//0.png"));
				}else{
					value.setIcon(new ImageIcon("icon//1.png"));
				}
			}
		});
		bt3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				posY++;
				pobj.posY=posY;
				if(posY>size-1){
					posY=size-1;
					pobj.posY=posY;
				}
				ljb4.setText(Integer.toString(posY));
				ljb5.setText(Integer.toString(posX));
				if(maze[posY][posX]==0){
					value.setIcon(new ImageIcon("icon//0.png"));
				}else{
					value.setIcon(new ImageIcon("icon//1.png"));
				}
			}
		});
		bt4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				posX--;
				pobj.posX=posX;
				if(posX<0){
					posX=0;
					pobj.posX=0;
				}
				ljb4.setText(Integer.toString(posY));
				ljb5.setText(Integer.toString(posX));
				if(maze[posY][posX]==0){
					value.setIcon(new ImageIcon("icon//0.png"));
				}else{
					value.setIcon(new ImageIcon("icon//1.png"));
				}
			}
		});
		bt5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				posX++;
				pobj.posX=posX;
				if(posX>size-1){
					posX=size-1;
					pobj.posX=posX;
				}
				ljb4.setText(Integer.toString(posY));
				ljb5.setText(Integer.toString(posX));
				if(maze[posY][posX]==0){
					value.setIcon(new ImageIcon("icon//0.png"));
				}else{
					value.setIcon(new ImageIcon("icon//1.png"));
				}
			}
		});
		value.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				vtoggle++;
				//vtoggle=vtoggle%2;
				if(vtoggle>1){
					vtoggle=0;
				}
				maze[posY][posX]=vtoggle;
				pobj.maze[posY][posX]=vtoggle;
				if(vtoggle==0){
					value.setIcon(new ImageIcon("icon//0.png"));
				}else{
					value.setIcon(new ImageIcon("icon//1.png"));
				}
				
			}
		});
		pobj.setBounds(340, 50, 410, 410);
		start=new JButton();
		start.setIcon(new ImageIcon("icon\\start.png"));
		start.setBounds(300, 480, 169, 65);
		start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				bobj=new Board(size,maze);
				bobj.boyI=sourceI;
				bobj.boyJ=sourceJ;
				bobj.dI=destinationI;
				bobj.dJ=destinationJ;
				bobj.sI=sourceI;
				bobj.sJ=sourceJ;
				solveMaze(maze,size);
				load3();
				f2.dispose();
				f3.setVisible(true);
				obj_music=new bgmusic();
				Thread t_music=new Thread(obj_music);
				t_music.start();
				
			}
		});
		s=new JButton();
		s.setIcon(new ImageIcon("icon\\s.png"));
		s.setBounds(20, 480, 130, 65);
		s.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sourceI=posY;
			    sourceJ=posX;
			    pobj.sourceI=sourceI;
			    pobj.sourceJ=sourceJ;
			    
			}
		});
		d=new JButton();
		d.setIcon(new ImageIcon("icon\\d.png"));
		d.setBounds(600, 480, 130, 65);
		d.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				destinationI=posY;
				destinationJ=posX;
				pobj.destinationI=destinationI;
				pobj.destinationJ=destinationJ;
			}
		});
		f2.add(pobj);
		f2.add(bt2);
		f2.add(bt3);
		f2.add(bt4);
		f2.add(bt5);
		f2.add(ljb1);
		f2.add(ljb2);
		f2.add(ljb3);
		f2.add(ljb4);
		f2.add(ljb5);
		f2.add(value);
		f2.add(start);
		f2.add(d);
		f2.add(s);
		f2.revalidate();
	}
	public void load3(){
		f3=new JFrame();
		f3.setTitle("Maze Game by Shahatyar");
		f3.setSize(1000, 700);
		f3.setLocationRelativeTo(null);
		f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bobj.setBounds(0, 0, 640, 640);
		f3.add(bobj);
		f3.revalidate();
		
	}
	
	// algorithm of maze
	
	static boolean isSafe(int maze[][], int x, int y, int size){
		// if (x,y outside maze) return false
	    if(x >= 0 && x <size && y >= 0 && y < size && maze[x][y] == 1){
	    	
	    	return true;
	    }
		return false;
	}
	boolean solveMaze(int maze[][],int size){
		
		pathX=new int[size*size];
		pathY=new int[size*size];
		 if(solveMazeUtil(maze, sourceI, sourceJ,size) == false)// sourceI,sourceJ
		    {
		        System.out.println("Solution doesn't exist");
		        return false;
		    }
		 
		    
		    return true;
	}
	 boolean solveMazeUtil(int maze[][],int x,int y,int size){
			//goal base condition
			if(x == destinationI && y == destinationJ)//destinationI,destinationJ
		    {
		       
		        pathX[cX]=x;
		        pathY[cY]=y;
		        bobj.pathX[cX]=x;
		        bobj.pathY[cY]=y;
		        bobj.foundC=1;
		        return true;
		    }
			// Check if maze[x][y] is valid
		    if(isSafe(maze, x, y,size) == true)
		    {
		        
		        pathX[cX]=x;
		        bobj.pathX[cX]=x;
		        bobj.allpathX[cAllx]=x;
		        cX++;
		        cAllx++;
		        pathY[cY]=y;
		        bobj.pathY[cY]=y;
		        bobj.allpathY[cAlly]=y;
		        cAlly++;
		        cY++;
		 
		        /* Move forward in x direction */
		        if (solveMazeUtil(maze, x+1, y, size) == true)
		            return true;
		 
		        
		        //   Move down in y direction  */
		        if (solveMazeUtil(maze, x, y+1, size) == true)
		            return true;
		 
		       
		        cX--;
		        pathX[cX]=0;
		        bobj.pathX[cX]=0;
		        cY--;
		        pathY[cY]=0;
		        bobj.pathY[cY]=0;
		        return false;
		    }   
			return false;
		}
	


	public static void main(String ars[]){
		new BuildMaze();
	}
}
