
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class FinalGame extends Canvas
	{
		private static final long  serialVersionUID   =1L;
		
		static int x=230, y=230;

	    public FinalGame()
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
		public void paint(Graphics g)
			{
				
				g.setColor(Color.white);
				g.fillRect(x,y,20,20);
			}
		
		public void moveIt(KeyEvent e)
			{
				switch(e.getKeyCode())
				{
					case KeyEvent.VK_DOWN:
						y += 5;
						break;
					case KeyEvent.VK_UP:
						y-= 5;
						break;
					case KeyEvent.VK_LEFT:
						x-=5;
						break;
					case KeyEvent.VK_RIGHT:
						x+=5;
						break;
				}
				repaint();
			}
		public static void main(String[] args)
			{
					JFrame frame = new JFrame("Basic Game");
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    
			        FinalGame ex = new FinalGame();
			        frame.getContentPane().add(ex);
			        frame.pack();
			        frame.setResizable(false);
			        frame.setVisible(true);
			        ex.requestFocus();
			
		    
			}
	}