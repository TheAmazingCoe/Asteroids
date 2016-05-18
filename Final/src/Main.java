import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JFrame;
public class Main extends Canvas
	{
		private static final long  serialVersionUID   =1L;
		static int wait;
		static int dimensions, parameter;
		static ArrayList <Integer> previous=new ArrayList<Integer>();
		static int x=395;
		static int y=730;
		static int bx=x+5;
		static int by=y-3;
		static boolean fired=false;
		static int m, count;
	    public Main()
	    	{
	        setSize(new Dimension(500, 500));
	        setBackground(Color.black);
	        addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                moveIt(e);
	            }
	        });
	    }
		public static void main(String[] args)
			{
				  Main canvas = new Main();
			        JFrame frame = new JFrame();
			        frame.setSize(800, 800);
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        frame.getContentPane().add(canvas).setBackground(Color.black);
			        frame.setLocationRelativeTo(null); //Sets JPanel to center of screen
			        frame.setResizable(false);
			        frame.setVisible(true);
			}
		public void paint(Graphics g) 
		{
					g.setColor(Color.white);
					for (int i=0; i<20; i++)
						{
					g.fillRect(generateNumber(),generateNumber(),2,2);
						}
			g.setColor(Color.gray);
			g.fillRect(x,y,20,20);
			g.fillRect(x+20,y+10,10,15);
			g.fillRect(x-10,y+10,10,15);
			g.setColor(Color.green);
			g.fillRect(bx, by, 10, 10);
			if (count%2==0)
				{
					g.setColor(Color.orange);
					g.fillRect(x-5, y+22, 4, 16);
					g.fillRect(x+21, y+22, 4, 16);
				}
			else
				{
					g.setColor(Color.orange);
					g.fillRect(x-5, y+22, 4, 14);
					g.fillRect(x+21, y+22, 4, 14);
				}
		}
		
		
		public void delay()
			{
	        try
					{
					Thread.sleep(5);
					} catch (InterruptedException e)
					{
					e.printStackTrace();
					}
			}
		public void moveIt(KeyEvent e)
			{
				switch(e.getKeyCode())
				{
					case KeyEvent.VK_DOWN:
						fire();
						break;
					case KeyEvent.VK_UP:
						fired=true;
						fire();
						break;
					case KeyEvent.VK_LEFT:
						x-=10;
						if (fired==false)
							{
								bx=x+5;
							}
						fire();
						break;
					case KeyEvent.VK_RIGHT:
						x+=10;
						if (fired==false)
							{
								bx=x+5;
							}
						fire();
						break;
				}
				repaint();
			}
		public static int generateNumber()
		{
			dimensions=(int)(Math.random()*790)+10;
			return dimensions;
				
		}
		public static void fire()
		{
			m=by-50;
			if (fired==false)
				{
					//m=by-1;
				}
			else
				{
					by=m;
				}
			if (by<-12)
				{
					fired=false;
					by=y-3;
					bx=x+5;
				}
			count++;
		}

	}
