import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
//mouse events
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
//random generator packages.
import java.util.Random;
// packages to get the Jframe at the center of the screen.
import java.awt.Toolkit;
import java.awt.Dimension;
//msgs to the user packages.
import javax.swing.JOptionPane;

public class Xo extends JFrame {

	String game = "notOver";

	int imgBackValue;
	String imgBack = "base.png";
	String winPng = "";

	int turn = 1; 

	int sym; // first turn X or O made it random...

	public void randomSymbolGen(){

		Random rn = new Random();
        sym = rn.nextInt() % 2;
        //System.out.println("SYMBOL  = " + sym);
        if(sym == -1)
				randomSymbolGen();
	}

	public void randomBackground(){
		Random rn = new Random();
		imgBackValue = rn.nextInt() % 9;
		//System.out.println("BackgroundImage = " + imgBackValue);


		if(imgBackValue < 0)
			randomBackground();

		switch(imgBackValue){
			case 0: imgBack  = "base.png";break;
			case 1: imgBack  = "base2.png";break;
			case 2: imgBack  = "base3.png";break;
			case 3: imgBack  = "base4.png";break;
			case 4: imgBack  = "base5.png";break;
			case 5: imgBack  = "base6.png";break;
			case 6: imgBack  = "base7.png";break;
			case 7: imgBack  = "base8.png";break;
			default: imgBack = "default.png";
		}


	}

	public void genWin(){
		            setLayout(new BorderLayout());

					ImageIcon icon2 = new ImageIcon("winSlash/"+winPng+".png"); 
   		            JLabel thumb2 = new JLabel();
                    thumb2.setIcon(icon2);
                    winPanel.add(thumb2);

                    add(winPanel);

                    setVisible(true);
	}


	JButton b1;
	JLabel l1;

	    JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        JPanel p8 = new JPanel();
        JPanel p9 = new JPanel();

        JPanel winPanel = new JPanel();


    int clickedPanel1 = 0;
    int clickedPanel2 = 0;
    int clickedPanel3 = 0;
    int clickedPanel4 = 0;
    int clickedPanel5 = 0;
    int clickedPanel6 = 0;
    int clickedPanel7 = 0;
    int clickedPanel8 = 0;
    int clickedPanel9 = 0;


    int cell1 = 0;
    int cell2 = 0;
    int cell3 = 0;
    int cell4 = 0;
    int cell5 = 0;
    int cell6 = 0;
    int cell7 = 0;
    int cell8 = 0;
    int cell9 = 0;

	public Xo(){
		setTitle("Game (Player-1 to play)");
		setSize(603,603);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		randomSymbolGen();

		/*background image random chooser*/

		randomBackground();

		//test a background
		//imgBack = "base7.png";

		/*background image setup*/

		setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon(imgBack)));

        /*background image setup*/


        /*display the frame at the center of the screen */

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    
       
        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p4.setOpaque(false);
        p5.setOpaque(false);
        p6.setOpaque(false);
        p7.setOpaque(false);
        p8.setOpaque(false);
        p9.setOpaque(false);


        winPanel.setOpaque(false);

        
        setLayout(new GridLayout(3,3));
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        add(p7);
        add(p8);
        add(p9);
       

		setVisible(true);
	
		
		p1.addMouseListener(new InnerClassTest(this));
		p2.addMouseListener(new InnerClassTest(this));
		p3.addMouseListener(new InnerClassTest(this));
		p4.addMouseListener(new InnerClassTest(this));
		p5.addMouseListener(new InnerClassTest(this));
		p6.addMouseListener(new InnerClassTest(this));
		p7.addMouseListener(new InnerClassTest(this));
		p8.addMouseListener(new InnerClassTest(this));
		p9.addMouseListener(new InnerClassTest(this));
		addMouseMotionListener(new InnerClassTest(this));
		
	}

	/*public void paint(Graphics g){
		g.drawImage(img,0,0,this);

		drawO(g,0,201);
	}*/

	public void startSymbolSet(JPanel p){
		if(sym == 1){
				ImageIcon icon = new ImageIcon("x.png"); 
   		        JLabel thumb = new JLabel();
                thumb.setIcon(icon);
                p.add(thumb);

                setVisible(true);
                sym = 0;


			}
			
			else{
				ImageIcon icon = new ImageIcon("o.png"); 
   		        JLabel thumb = new JLabel();
                thumb.setIcon(icon);
                p.add(thumb);

                setVisible(true);
                sym = 1;
			}


			if(turn % 2 == 1){
				if(sym == 0)
			      setTitle("Game (Player-1(o) to play");
		        else
			      setTitle("Game (Player-1(x) to play");
			}
			else{
				
			    if(sym == 0)
			      setTitle("Game (Player-2(o) to play");
			
		        else
			      setTitle("Game (Player-2(x) to play");
			}


			if(turn > 10){
					setTitle("GameOver - DRAW!");

					JOptionPane.showMessageDialog(null,"DRAW","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
     	    }

	}

	/*_________________________MOUSE EVENTS STARTED__________________*/

class InnerClassTest extends MouseAdapter{

		Xo outerClassVariable;

		public InnerClassTest(Xo outerClassVariable){
			this.outerClassVariable = outerClassVariable;
		}
	public void mousePressed(MouseEvent me){

	 //System.out.println("this Turn: " + turn);
	 if( game != "Over"){

		if(me.getSource() == p1){
			
			if(clickedPanel1 == 0){
				if(turn % 2 == 1)
				cell1 = 1;
			else
				cell1 = 2;
				turn++;
			   //System.out.println("CELL _ 1");
			   startSymbolSet(p1);
			   clickedPanel1 = 1;

			}
			   
		}

		if(me.getSource() == p2){
			
			if(clickedPanel2 == 0){
				if(turn % 2 == 1)
				cell2 = 1;
			else
				cell2 = 2;
				turn++;
			   //System.out.println("CELL _ 2");
			   startSymbolSet(p2);
			   clickedPanel2 = 1;

			}


		}

		if(me.getSource() == p3){
			if(clickedPanel3 == 0){
				if(turn % 2 == 1)
				cell3 = 1;
			else
				cell3 = 2;
				turn++;
			    //System.out.println("CELL _ 3");
			    startSymbolSet(p3);	
			    clickedPanel3 = 1;

			}
		}

		if(me.getSource() == p4){
			
			if(clickedPanel4 == 0){
				if(turn % 2 == 1)
				 cell4 = 1;
			    else
				 cell4 = 2;
				turn++;
			    //System.out.println("CELL _ 4");
			    startSymbolSet(p4);	
			    clickedPanel4 = 1;

			}		
		}

		if(me.getSource() == p5){
			
			if(clickedPanel5 == 0){
				if(turn % 2 == 1)
				cell5 = 1;
			else
				cell5 = 2;
				turn++;
			   //System.out.println("CELL _ 5");
			   startSymbolSet(p5);
			   clickedPanel5 = 1;

			}
		}

		if(me.getSource() == p6){
			
			if(clickedPanel6 == 0){
				if(turn % 2 == 1)
				cell6 = 1;
			else
				cell6 = 2;
				turn++;
			   //System.out.println("CELL _ 6");
			   startSymbolSet(p6);	
			   clickedPanel6 = 1;

			}
		}

		if(me.getSource() == p7){
			
			if(clickedPanel7 == 0){
				if(turn % 2 == 1)
				cell7 = 1;
			else
				cell7 = 2;
				turn++;
			    //System.out.println("CELL _ 7");
		     	startSymbolSet(p7);
		     	clickedPanel7 = 1;

			}
		}

		if(me.getSource() == p8){
			
			if(clickedPanel8 == 0){
				if(turn % 2 == 1)
				cell8 = 1;
			else
				cell8 = 2;
			turn++;
			   //System.out.println("CELL _ 8");
			   startSymbolSet(p8);
			   clickedPanel8 = 1;

			}
		}

		if(me.getSource() == p9){
			
			if(clickedPanel9 == 0){
				if(turn % 2 == 1)
				cell9 = 1;
			else
				cell9 = 2;
			   turn++;
			   //System.out.println("CELL _ 9");
			   startSymbolSet(p9);
			   clickedPanel9 = 1;
			   
			}
		}
		
     }

     
	}

	public void mouseReleased(MouseEvent me){

		if(turn >= 5){

			// checking win for player - 1 ##################

				if(cell1 == 1 && cell2 == 1 && cell3 == 1){
					//System.out.println("Player-1 WINS!");
					setTitle("GameOver!");
					winPng = "topHori";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-1 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";

				}

				else if(cell1 == 1 && cell4 == 1 && cell7 == 1 ){
					//System.out.println("Player-1 WINS!");
					setTitle("GameOver!");
					winPng = "leftVert";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-1 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";

				}

				else if(cell1 == 1 && cell5 == 1 && cell9 == 1){
					//System.out.println("Player-1 WINS!");
					setTitle("GameOver!");
					winPng = "backSlash";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-1 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";
				}

				else if(cell2 == 1 && cell5 == 1 && cell8 == 1){
					//System.out.println("Player-1 WINS!");
					setTitle("GameOver!");
					winPng = "midVert";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-1 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";
				}

				else if(cell3 == 1 && cell6 == 1 && cell9 == 1){
					//System.out.println("Player-1 WINS!");
					setTitle("GameOver!");
					winPng = "rightVert";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-1 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";
				}

				else if(cell3 == 1 && cell5 == 1 && cell7 == 1){
					//System.out.println("Player-1 WINS!");
					setTitle("GameOver!");
					winPng = "forwardSlash";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-1 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";
				}


				else if(cell4 == 1 && cell5 == 1 && cell6 == 1){
					//System.out.println("Player-1 WINS!");
					setTitle("GameOver!");
					winPng = "midHori";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-1 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";
				}

				else if(cell7 == 1 && cell8 == 1 && cell9 == 1){
					//System.out.println("Player-1 WINS!");
					setTitle("GameOver!");
					winPng = "downHori";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-1 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";
				}



				// checking win for player - 2 ###########################################################

				else if(cell1 == 2 && cell2 == 2 && cell3 == 2){
					//System.out.println("Player-2 WINS!");
					setTitle("GameOver!");
					winPng = "topHori";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-2 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";

				}

				else if(cell1 == 2 && cell4 == 2 && cell7 == 2 ){
					//System.out.println("Player-2 WINS!");
					setTitle("GameOver!");
					winPng = "leftVert";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-2 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";

				}

				else if(cell1 == 2 && cell5 == 2 && cell9 == 2){
					//System.out.println("Player-2 WINS!");
					setTitle("GameOver!");
					winPng = "backSlash";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-2 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";
				}

				else if(cell2 == 2 && cell5 == 2 && cell8 == 2){
					//System.out.println("Player-2 WINS!");
					setTitle("GameOver!");
					winPng = "midVert";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-2 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";
				}

				else if(cell3 == 2 && cell6 == 2 && cell9 == 2){
					//System.out.println("Player-2 WINS!");
					setTitle("GameOver!");
					winPng = "rightVert";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-2 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";
				}

				else if(cell3 == 2 && cell5 == 2 && cell7 == 2){
					//System.out.println("Player-2 WINS!");
					setTitle("GameOver!");
					winPng = "forwardSlash";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-2 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";
				}


				else if(cell4 == 2 && cell5 == 2 && cell6 == 2){
					//System.out.println("Player-2 WINS!");
					setTitle("GameOver!");
					winPng = "midHori";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-2 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";
				}

				else if(cell7 == 2 && cell8 == 2 && cell9 == 2){
					//System.out.println("Player-2 WINS!");
					setTitle("GameOver!");
					winPng = "downHori";
					genWin();
					JOptionPane.showMessageDialog(null,"Player-2 WINS the game!!!","GAME OVER!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";
				}


				///// checking DRAW ###########################################################

				else if(clickedPanel9 == 1 && clickedPanel8 == 1 && clickedPanel7 == 1 && clickedPanel6 == 1 
					&& clickedPanel5 == 1 && clickedPanel4 == 1 && clickedPanel3 == 1 && clickedPanel2 == 1 && clickedPanel1 == 1){
					
					JOptionPane.showMessageDialog(null,"DRAW!!","GAME OVER!!",JOptionPane.INFORMATION_MESSAGE);
					game = "Over";

				}

				if(game == "Over"){
					Xo.this.setVisible(false);
      			    Xo.this.dispose();
       				main();
				}

			}
		
	}

}
	/*_________________________MOUSE EVENTS ENDED__________________*/

	public static void main(String... arg){
		new Xo();
	}
}
