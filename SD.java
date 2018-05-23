import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import javax.sound.sampled.*;
import java.util.Scanner;

import MethodsDL.*;

public class SD
{
	//Sound
    static File file; 
    static AudioInputStream stream; 
    static Clip music;
	
	public static void main(String...args) throws Exception
	{
		JFrame j = new JFrame("Space Defenders");
		try {
		    j.setIconImage(ImageIO.read(new File("Ship.png")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}
		MyPanel4 m = new MyPanel4();
		j.setSize(m.getSize());
		j.add(m);

		j.setVisible(true);

		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MyPanel4 extends JPanel implements ActionListener, KeyListener, MouseListener // extends JPanel to support the swing framework
{
	
	private Timer time;
	int y1,y2,y1Temp,y2Temp,laserSpeed,missleSpeed;
	double radian;
	private int add;
	int left;
	Graphics g1;
	static int gameState = 0;
	int whichPower;
	static int health = 5;
	static int score = 0;
	int[] starX = new int[50];
	int[] starY = new int[50];
	int iterations = 0;
	
	//Music
	static File titleMusicFile;
    static AudioInputStream titleMusicStream;
    static Clip titleMusic;
	
	//Explosion Sound
    static File explosionFile;
    static AudioInputStream explosionStream;
    static Clip explosionClip;
    
    //Power Up Sound
    static File powerUpFile;
    static AudioInputStream powerUpStream;
    static Clip powerUpClip;
    
    //Images
    static Image spaceBackground, gameOverImage;
	
	//Class Variables
	int missleX1 = 1200;
	int missleX2 = 1200;
	int missleY1 = (int) (Math.random() * 650 + 300);
	int missleY2 = (int) (Math.random() * 400 + 100);
	
	int healthX = (int) (Math.random() * 650 + 300);
	int healthY = (int) (Math.random() * 400 + 100);
	
	int lightX = (int) (Math.random() * 650 + 300);
	int lightY = (int) (Math.random() * 400 + 100);
	
	int clockX = (int) (Math.random() * 650 + 300);
	int clockY = (int) (Math.random() * 400 + 100);
	
	int rainX = (int) (Math.random() * 650 + 300);
	int rainY = (int) (Math.random() * 400 + 100);
	
	int coinX = (int) (Math.random() * 650 + 300);
	int coinY = (int) (Math.random() * 400 + 100);
	
	int laserX1 = 40;
	int laserX2 = 40;
	int laserY1 = MouseInfo.getPointerInfo().getLocation().y - 25;
	int laserY2 = MouseInfo.getPointerInfo().getLocation().y - 25;
	
	char powerUps = 'N';
	MyPanel4()
	{
		y1 = 250;
		y2 = 350;
		laserSpeed = 10;
		missleSpeed = 6;
		
		time = new Timer(15, this);
		setSize(1200, 600);
		setVisible(true);
		time.start();
		addMouseListener(this);
		setFocusable(true);
		addKeyListener(this);
		
		//Sound
		titleMusicFile = new File("test.au");
		explosionFile = new File("Explosion.wav");
		powerUpFile = new File("Power Up.wav");
		try {
			//Title Music
			titleMusicStream = AudioSystem.getAudioInputStream(titleMusicFile);
			titleMusic = AudioSystem.getClip();
			titleMusic.open(titleMusicStream);
			//Explosion
			explosionStream = AudioSystem.getAudioInputStream(explosionFile);
			explosionClip = AudioSystem.getClip();
			explosionClip.open(explosionStream);
			//Power Up
			powerUpStream = AudioSystem.getAudioInputStream(powerUpFile);
			powerUpClip = AudioSystem.getClip();
			powerUpClip.open(powerUpStream);
		} catch (Exception ex) {}
		
		titleMusic.start();
		titleMusic.loop(Clip.LOOP_CONTINUOUSLY);
		
		//Images
		try {
		    spaceBackground = ImageIO.read(new File("Space Background.jpg"));
		    gameOverImage = ImageIO.read(new File("GameOver.png"));
		} catch (IOException e) {}
	}



	public void paintComponent(Graphics g)
	{
		//Plays the explosion
		try {
			
			if (!explosionClip.isRunning()) {
				explosionClip.stop();
				explosionClip.open(explosionStream);
			}
		} catch (Exception ex) {}
		
		//Which Screen is shown
		g1=g;
		if (gameState == 0) {
			TitleScreen(g);
		} else if (gameState == 1) {
			ActiveGame(g);
			titleMusic.stop();
		} else if (gameState == 2) {
			GameOver(g);
		} else if (gameState > 2) {
			gameState = 0;
			TitleScreen(g);
		} else {
			System.out.println("UMMM... SERIOUS ERROR WITH gameState");
		}
			
	}

	public void actionPerformed(ActionEvent e)
	{
		y1 = MouseInfo.getPointerInfo().getLocation().y;

		repaint();
	}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_UP)
			y2-=5;
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
			y2+=5;
		repaint();
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e){}
	
	//Player One Laser
	public void mouseClicked(MouseEvent e){
     	if (gameState != 1) {
			gameState++;
		}
		
		repaint();
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

	public void TitleScreen(Graphics g)
	{	
		//background	
		g.setColor(new Color(0,204,102));
		g.fillRect(0,0,1200,600);
		g.setColor(new Color(102,255,102));
		int x=10; int y=10;
		for (int i=0;i<50;i++)
		{
			int tempx=x;
			for (int j=0;j<39;j++)
			{
				g.fillOval(x,y,20,20);
				x+=30;
			}
			y+=30;
			if (i%2==0)
				x=20;
			if (i%2==1)
				x=10;
		}
		
		//arcade box
		g.setColor(Color.black);
		Font authors = new Font("Arial", 1, 30);
		g.setFont(authors);
		g.setColor(new Color(0,204,102));
		g.fillRect(0,0,1200,40);
		g.setColor(Color.black);
		g.drawString("Authors: Damian Lall and Kathryn Phung                        Topic: Space Themed Game",5,30);
		g.setColor(Color.black);
		int machineX=100; int machineY=50;
		g.setColor(Color.black);
		g.fillRect(100,50,1000,450);
		g.setColor(new Color(102,102,255));
		int [] machine={machineX+50,machineX+75,machineX+100,machineX+125,machineX+75,machineX+75,machineX+85,machineX+125,
						machineX+875,machineX+915,machineX+925,machineX+925,machineX+875,machineX+900,machineX+925,machineX+950};
		int [] machine2={0+machineY,50+machineY,75+machineY,325+machineY,375+machineY,400+machineY,425+machineY,450+machineY,
						 450+machineY,425+machineY,400+machineY,375+machineY,325+machineY,75+machineY,50+machineY,0+machineY};
		g.fillPolygon(machine,machine2,16);
		g.setColor(Color.black);
		int [] screen={125+machineX,140+machineX,150+machineX,150+machineX,850+machineX,850+machineX,860+machineX,875+machineX};
		int [] screen2={75+machineY,125+machineY,175+machineY,300+machineY,300+machineY,175+machineY,125+machineY,75+machineY};
		g.fillPolygon(screen,screen2,8);
		g.setColor(new Color(15,15,15));
		int [] desk={150+machineX,125+machineX,875+machineX,850+machineX};
		int [] desk2={340+machineY,375+machineY,375+machineY,340+machineY};
		g.fillPolygon(desk,desk2,4);
		g.setColor(Color.black);
		
		//coin slot
		g.fillArc(machineX+195,machineY+415,10,70,0,180);
		
		//rainbow buttons
		int test=5;
		
		//red
		for (int i=0;i<5;i++)
		{
			g.setColor(new Color (255,00,0));
			g.fillOval(machineX+175,machineY+350+test,40,10);
			test--;
		}
		g.setColor(new Color(255,102,102));
		g.fillOval(machineX+175,machineY+350,40,10);
		test=5;
		
		//orange
		for (int i=0;i<5;i++)
		{
			g.setColor(new Color (255,128,0));
			g.fillOval(machineX+175+50,machineY+350+test,40,10);
			test--;
		}
		g.setColor(new Color(255,153,51));
		g.fillOval(machineX+175+50,machineY+350,40,10);
		test=5;
		
		//yellow
		for (int i=0;i<5;i++)
		{
			g.setColor(new Color (204,204,0));
			g.fillOval(machineX+175+100,machineY+350+test,40,10);
			test--;
		}
		g.setColor(new Color(255,255,0));
		g.fillOval(machineX+175+100,machineY+350,40,10);
		test=5;
		
		//green
		for (int i=0;i<5;i++)
		{
			g.setColor(new Color (0,255,0));
			g.fillOval(machineX+175+150,machineY+350+test,40,10);
			test--;
		}
		g.setColor(new Color(102,255,102));
		g.fillOval(machineX+175+150,machineY+350,40,10);
		test=5;
		
		//blue
		for (int i=0;i<5;i++)
		{
			g.setColor(new Color (0,128,255));
			g.fillOval(machineX+175+200,machineY+350+test,40,10);
			test--;
		}
		g.setColor(new Color(51,153,255));
		g.fillOval(machineX+175+200,machineY+350,40,10);
		test=5;
		
		//purple
		for (int i=0;i<5;i++)
		{
			g.setColor(new Color (102, 0, 204));
			g.fillOval(machineX+175+250,machineY+350+test,40,10);
			test--;
		}
		g.setColor(new Color(153,51,255));
		g.fillOval(machineX+175+250,machineY+350,40,10);
		
		//Click to Continue
		Font continueFont = new Font("Arial", 1, 25);
		g.setFont(continueFont);
		g.setColor(Color.white);
		g.drawString("Click to Continue",625,420);
		
		//title
		g.setColor(new Color(102,255,255));
		Font myF = new Font("SHOWCARD GOTHIC",Font.BOLD,68);
		g.setFont(myF); 
		g.drawString("Space Defenders!",250,120);
		
		//joystick
		g.setColor(Color.red);
		g.fillArc(machineX+800,machineY+275,25,50,0,180);
		int [] joystick={800+machineX,825+machineX,815+machineX,810+machineX};
		int [] joystick2={300+machineY,300+machineY,325+machineY,325+machineY};
		g.fillPolygon(joystick,joystick2,4);
		
		//instructions or description
		g.setColor(new Color(180,180,180));
		g.fillRect(machineX+810,machineY+325,5,40);
		Font myF2= new Font("Garamond",Font.BOLD,19);
		g.setFont(myF2);
		g.drawString("Objective: Defend your base from oncoming missiles by shooting at them with lasers. ",machineX+160,machineY+100);
		g.drawString("Player one uses the mouse to control their rocket while player two uses the arrow ",
		machineX+170,machineY+130);
		g.drawString("keys on the keyboard. To obtain powerups, shoot the following objects.",machineX+180,machineY+160);
		Font myF3= new Font("Garamond",Font.BOLD,15);
		g.setFont(myF3);
		
		//heart powerup & description
		int p=270; int h=220;
		g.setColor(Color.white);
		g.fillOval(p,h,50,50);
		g.setColor(Color.pink);
		g.fillOval(p+5,h+5,40,40);
		g.setColor(Color.red);
		int [] heart={p+12,p+25,p+38};
		int [] heart1={h+25,h+38,h+25};
		g.fillPolygon(heart,heart1,3);
		g.fillArc(p+10,h+17,15,15,0,180);
		g.fillArc(p+24,h+17,15,15,0,180);
		g.setColor(new Color(220,220,220));
		g.drawString("Heart powerup: Refills health ",machineX+225,machineY+200);		
		
		//lightning powerup & description
		int boltX=20; int boltY=40;
		g.setColor(Color.white);
		g.fillOval(boltX+250,boltY+250,50,50);
		g.setColor(new Color(255,255,185));
		g.fillOval(boltX+255,boltY+255,40,40);
		int [] bolt={boltX+272,boltX+282,boltX+278,boltX+282,boltX+276,boltX+280,boltX+268,boltX+272,boltX+269,boltX+272,boltX+269};
		int [] bolt2={boltY+262,boltY+262,boltY+268,boltY+268,boltY+275,boltY+275,boltY+294,boltY+280,boltY+280,boltY+272,boltY+272};
		g.setColor(Color.orange);
		g.fillPolygon(bolt,bolt2,11);
		g.setColor(new Color(220,220,220));
		g.drawString("Lightning powerup: Quickens lasers",machineX+225,machineY+270);
		
		//clock powerup & description
		int clockX=533; int clockY=172;
		g.setColor(Color.white);
		g.fillOval(clockX+50,clockY+50,50,50);
		g.setColor(new Color(153,255,255));
		g.fillOval(clockX+52,clockY+52,46,46);
		g.setColor(Color.blue);
		g.fillOval(clockX+56,clockY+56,38,38);
		g.setColor(Color.white);
		g.fillOval(clockX+60,clockY+60,30,30);
		g.setColor(Color.black);
		g.fillOval(clockX+73,clockY+73,4,4);
		g.fillRect(clockX+74,clockY+65,2,10);
		g.fillRect(clockX+75,clockY+75,10,2);
		g.setColor(new Color(180,180,180));
		g.fillOval(clockX+74,clockY+84,3,3);
		g.fillOval(clockX+62,clockY+74,3,3);
		g.setColor(new Color(220,220,220));
		g.drawString("Clock powerup: Temporarily slows missiles ",machineX+540,machineY+200);
		
		//rainbow powerup & description
		int rainX=-210;; int rainY=-98;
		g.setColor(Color.white);
		g.fillOval(rainX+793,rainY+387,51,51);
		g.setColor(new Color(153,204,255));
		g.fillOval(rainX+797,rainY+391,43,43);
		g.setColor(Color.red);
		g.fillArc(rainX+800,rainY+400,38,38,0,180);
		g.setColor(new Color(255,128,0));
		g.fillArc(rainX+803,rainY+403,32,32,0,180);
		g.setColor(Color.yellow);
		g.fillArc(rainX+806,rainY+406,26,26,0,180);
		g.setColor(Color.green);
		g.fillArc(rainX+809,rainY+409,20,20,0,180);
		g.setColor(Color.blue);
		g.fillArc(rainX+812,rainY+412,14,14,0,180);
		g.setColor(new Color (127,0,255));
		g.fillArc(rainX+815,rainY+415,8,8,0,180);
		g.setColor(new Color(220,220,220));
		g.drawString("Rainbow powerup: Random powerup ",machineX+540,machineY+270);
		
		//coins
		int coinX=350-50; int coinY=465-62;
		int count=0;
		for (int j=0;j<12;j++)
		{
			//shading
			int y2=75;
			for (int i=0;i<10;i++)
			{
			g.setColor(new Color (160,160,160));
			g.fillOval(coinX+50,coinY+y2,100,25);
			y2--;
			}
			//ridges
			g.setColor(new Color(140,140,140));
			g.drawLine(coinX+55,coinY+70,coinX+55,coinY+92);
			g.drawLine(coinX+60,coinY+70,coinX+60,coinY+93);
			g.drawLine(coinX+65,coinY+70,coinX+65,coinY+95);
			g.drawLine(coinX+70,coinY+70,coinX+70,coinY+97);
			g.drawLine(coinX+75,coinY+70,coinX+75,coinY+98);
			g.drawLine(coinX+80,coinY+70,coinX+80,coinY+99);
			g.drawLine(coinX+85,coinY+70,coinX+85,coinY+99);
			g.drawLine(coinX+90,coinY+70,coinX+90,coinY+99);
			g.drawLine(coinX+95,coinY+70,coinX+95,coinY+99);
			g.drawLine(coinX+100,coinY+70,coinX+100,coinY+99);
			g.drawLine(coinX+105,coinY+70,coinX+105,coinY+99);
			g.drawLine(coinX+110,coinY+70,coinX+110,coinY+99);
			g.drawLine(coinX+115,coinY+70,coinX+115,coinY+99);
			g.drawLine(coinX+120,coinY+70,coinX+120,coinY+99);
			g.drawLine(coinX+125,coinY+70,coinX+125,coinY+99);
			g.drawLine(coinX+130,coinY+70,coinX+130,coinY+97);
			g.drawLine(coinX+135,coinY+70,coinX+135,coinY+95);
			g.drawLine(coinX+140,coinY+70,coinX+140,coinY+93);
			g.drawLine(coinX+145,coinY+70,coinX+145,coinY+92);
			g.setColor(new Color(180,180,180));
			g.fillOval(coinX+50,coinY+62,100,25);
			g.setColor(new Color(100,100,100));
			//cent symbol
			Font myFont = new Font("Rockwell Extra Bold",Font.BOLD,25);
			g.setFont(myFont);
			g.drawString("(¢)",coinX+80,coinY+80);
			coinX+=100;
			count++;
			//second row
			if (count%6==0)
				{
				coinY-=20;
				coinX=325;
				}
			}
	}
	
	public static void GameOver(Graphics g)
	{
		health = 5;
		g.drawImage(gameOverImage,0,14,null);
		Font font2 = new Font("SHOWCARD GOTHIC", Font.BOLD, 50);
		g.setFont(font2);
		g.setColor(Color.red);
		g.drawString("Score: " + score, 450 ,100);
		

	}

	public void InitialGame(Graphics g)
	{
		
		if (gameState == 1) {
			//Background
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 1200, 600);
			
			//Stars
			
			for (int i = 0; i < 50; i++) {
				starX[i] = (int) (Math.random() * 1200);
				starY[i] = (int) (Math.random() * 600);
			}
			
			
			//Whether or not there are power ups
			if (powerUps == 'Y') {
				//Chooses which Power Up to display
				int whichPower = (int) (Math.random() * 4 + 1);
				
				switch (whichPower) {
					//HealthPack
					case 1:
						healthX = (int) (Math.random() * 650 + 300);
						healthY = (int) (Math.random() * 400 + 100);
						break;
					//Lightning
					case 2:
						lightX = (int) (Math.random() * 650 + 300);
						lightY = (int) (Math.random() * 400 + 100);
						break;
					//Clock
					case 3:
						clockX = (int) (Math.random() * 650 + 300);
						clockY = (int) (Math.random() * 400 + 100);
						break;
					//Rainbow
					case 4:
						rainX = (int) (Math.random() * 650 + 300);
						rainY = (int) (Math.random() * 400 + 100);
						break;		
				}
			} else {
				//Health X+Y
			 	healthX = 1300;
				healthY = 700;
				//Lightning X+Y
				lightX = 1400;
				lightY = 700;
				//Clock X+Y
				clockX = 1300;
				clockY = 800;
				//Rainbow X+Y
				rainX = 1400;
				rainY = 800;
			}
			
			
		 	ActiveGame(g);
		}
	}

	public void ActiveGame(Graphics g)
	{
		iterations++;
			g.drawImage(spaceBackground, 0, 0, null);			
			
			titleMusic.stop();
			
			if (laserSpeed > 10) {
				if (iterations % 10 == 0)
					laserSpeed--;
			}
			if (missleSpeed < 6) {
				if (iterations % 10 == 0)
					missleSpeed++;
			}
			
			//Initialize Ship Class
			Ship player1 = new Ship(g,y1);
		 	Ship player2 = new Ship(g,y2);
		 	
		 	Health bar = new Health(g, health);
		 	
		 	HealthPack h1 = new HealthPack(g, healthX, healthY);
		 	Lightning li1 = new Lightning(g, lightX, lightY);
		 	Clock c1 = new Clock(g, clockX, clockY);
		 	Rainbow rain1 = new Rainbow(g, rainX, rainY);
		 	
			//Continous Laser
			if (laserX1 >= 1200) {
				laserX1 = 200;
				y1Temp = y1;
			} else {
				laserX1 += laserSpeed;
			}
			
			if (laserX2 >= 1200) {
				laserX2 = 200;
				y2Temp = y2;
			} else {
				laserX2 += laserSpeed;
			}	
					
			laserY1 = y1Temp + 80;
			Laser l1 = new Laser(g, laserX1, laserY1);
					
			laserY2 = y2Temp + 80;
			Laser l2 = new Laser(g, laserX2, laserY2);
			
			
			//Continous Missles
			
			if (missleX1 <= 0) {
				missleX1 = 1200;
				missleY1 = (int) (Math.random() * 400 + 100);
				health--;
			} else {
				missleX1 -= missleSpeed;
			}
			
			if (missleX2 <= 0) {
				missleX2 = 1200;
				missleY2 = (int) (Math.random() * 400 + 100);
				health--;
			} else {
				missleX2 -= missleSpeed;
			}
			
			Missle m1 = new Missle(g, missleX1, missleY1);
			Missle m2 = new Missle(g, missleX2, missleY2);
			
			//Checks if the laser hitbox intersects the missle hitbox
			try {
				if (getBounds(laserX1, laserY1, 70, 20).intersects(missleX1, missleY1, 95, 50)) {
					laserX1 = 1200;
					missleX1 += 1200;
					missleY1 = (int) (Math.random() * 400 + 100);
					explosionClip.stop();
					explosionClip.setFramePosition(0);
					explosionClip.start();
					score++;
					ASCIIDL.ASCII("Hit!", false);
					System.out.println("Score: " + score);
				}
				if (getBounds(laserX1, laserY1, 70, 20).intersects(missleX2, missleY2, 95, 50)) {
					laserX1 = 1200;
					missleX2 += 1200;
					missleY2 = (int) (Math.random() * 400 + 100);
					explosionClip.stop();
					explosionClip.setFramePosition(0);
					explosionClip.start();
					score++;
					ASCIIDL.ASCII("Hit!", false);
					System.out.println("Score: " + score);
				}
				if (getBounds(laserX2, laserY2, 70, 20).intersects(missleX1, missleY1, 95, 50)) {
					laserX2 = 1200;
					missleX1 += 1200;
					missleY1 = (int) (Math.random() * 400 + 100);
					explosionClip.stop();
					explosionClip.setFramePosition(0);
					explosionClip.start();
					score++;
					ASCIIDL.ASCII("Hit!", false);
					System.out.println("Score: " + score);
				}
				if (getBounds(laserX2, laserY2, 70, 20).intersects(missleX2, missleY2, 95, 50)) {
					laserX2 = 1200;
					missleX2 += 1200;
					missleY2 = (int) (Math.random() * 400 + 100);
					explosionClip.stop();
					explosionClip.setFramePosition(0);
					explosionClip.start();
					score++;
					ASCIIDL.ASCII("Hit!", false);
					System.out.println("Score: " + score);
				}
			} catch (Exception ex) {}
			
			//Check Powerup Collisions
			
			//HealthPack
			if (getBounds(laserX1, laserY1, 70, 20).intersects(healthX, healthY, 50, 50)) {
				//Object Coords
				laserX1 = 1200;
				healthX = (int) (Math.random() * 650 + 300);
				healthY = (int) (Math.random() * 400 + 100);
				//Sound
				powerUpClip.stop();
				powerUpClip.setFramePosition(0);
				powerUpClip.start();
				//Function
				int whichPower = (int) (Math.random() * 4 + 1);
				health = 5;
				repaint();
			}
			if (getBounds(laserX2, laserY2, 70, 20).intersects(healthX, healthY, 50, 50)) {
				//Object Coords
				laserX2 = 1200;
				healthX = (int) (Math.random() * 650 + 300);
				healthY = (int) (Math.random() * 400 + 100);
				//Sound
				powerUpClip.stop();
				powerUpClip.setFramePosition(0);
				powerUpClip.start();
				//Function
				int whichPower = (int) (Math.random() * 4 + 1);
				health = 5;
				repaint();
			}
			
			//Lightning
			if (getBounds(laserX1, laserY1, 70, 20).intersects(lightX, lightY, 50, 50)) {
				//Object Coords
				laserX1 = 1200;
				lightX = (int) (Math.random() * 650 + 300);
				lightY = (int) (Math.random() * 400 + 100);
				//Sound
				powerUpClip.stop();
				powerUpClip.setFramePosition(0);
				powerUpClip.start();
				//Function
				int whichPower = (int) (Math.random() * 4 + 1);
				laserSpeed = 20;
			}
			if (getBounds(laserX2, laserY2, 70, 20).intersects(lightX, lightY, 50, 50)) {
				//Object Coords
				laserX2 = 1200;
				lightX = (int) (Math.random() * 650 + 300);
				lightY = (int) (Math.random() * 400 + 100);
				//Sound
				powerUpClip.stop();
				powerUpClip.setFramePosition(0);
				powerUpClip.start();
				//Function
				int whichPower = (int) (Math.random() * 4 + 1);
				laserSpeed = 20;
			}
			
			//Clock
			if (getBounds(laserX1, laserY1, 70, 20).intersects(clockX, clockY, 50, 50)) {
				//Object Coords
				laserX1 = 1200;
				clockX = (int) (Math.random() * 650 + 300);
				clockY = (int) (Math.random() * 400 + 100);
				//Sound
				powerUpClip.stop();
				powerUpClip.setFramePosition(0);
				powerUpClip.start();
				//Function
				int whichPower = (int) (Math.random() * 4 + 1);
				missleSpeed = 2;
			}
			if (getBounds(laserX2, laserY2, 70, 20).intersects(clockX, clockY, 50, 50)) {
				//Object Coords
				laserX2 = 1200;
				clockX = (int) (Math.random() * 650 + 300);
				clockY = (int) (Math.random() * 400 + 100);
				//Sound
				powerUpClip.stop();
				powerUpClip.setFramePosition(0);
				powerUpClip.start();
				//Function
				int whichPower = (int) (Math.random() * 4 + 1);
				missleSpeed = 2;
			}
			
			//Rainbow
			if (getBounds(laserX1, laserY1, 70, 20).intersects(rainX, rainY, 50, 50)) {
				//Object Coords
				laserX1 = 1200;
				rainX = (int) (Math.random() * 650 + 300);
				rainY = (int) (Math.random() * 400 + 100);
				//Sound
				powerUpClip.stop();
				powerUpClip.setFramePosition(0);
				powerUpClip.start();
				//Function
				int whichPower = (int) (Math.random() * 4 + 1);
				int choose = (int) (Math.random() * 3 + 1);
				switch (choose) {
					//Health
					case 1:
						health = 5;
						break;
					//Lightning
					case 2:
						//Function
						laserSpeed = 20;
					//Clock
					case 3:
						//Function
						missleSpeed = 2;						
				}
				repaint();
			}
			if (getBounds(laserX2, laserY2, 70, 20).intersects(rainX, rainY, 50, 50)) {
				//Object Coords
				laserX2 = 1200;
				rainX = (int) (Math.random() * 650 + 300);
				rainY = (int) (Math.random() * 400 + 100);
				//Sound
				powerUpClip.stop();
				powerUpClip.setFramePosition(0);
				powerUpClip.start();
				//Function
				int whichPower = (int) (Math.random() * 4 + 1);
				int choose = (int) (Math.random() * 3 + 1);
				switch (choose) {
					//Health
					case 1:
						health = 5;
						break;
					//Lightning
					case 2:
						laserSpeed = 20;
					//Clock
					case 3:
						missleSpeed = 2;						
				}
				repaint();
			}
		
	}
	
	//Creates a rectangle to act as a sprite's hitbox/boundaries
	public Rectangle getBounds(int x, int y, int width, int height) {
		return new Rectangle(x, y, width, height);
	}
	
}
 
class Ship
{
	int d = 300;
	
	Ship (Graphics g, int y)
	{
		int yTemp = y;
		int c=100;
		int d=y;
		g.setColor(new Color(180,180,180));
		int [] body={c+25,c+29,c+125,c+125,c+29,c+25};
		int [] body2={d+79,d+75,d+75,d+125,d+125,d+121};
		g.fillPolygon(body,body2,6);
		g.fillOval(c+100,d+75,50,50);
		int [] wing1={c+35,c+25,c+50,c+75};
		int [] wing2={d+75,d+50,d+50,d+75};
		g.setColor(Color.red);
		g.fillPolygon(wing1,wing2,4);
		int [] wing3={d+125,d+150,d+150,d+125};
		g.fillPolygon(wing1,wing3,4);
		g.setColor(new Color(255,153,51));
		g.fillOval(c-15,d+80,40,40);
		int [] flametriangle={c-23,c-8,c-8};
		int [] flametri2={d+100,d+85,d+115};
		g.fillPolygon(flametriangle,flametri2,3);
		g.setColor(new Color(225,225,0));
		g.fillOval(c,d+88,24,24);
		int [] flametri3={c-2,c+3,c+3};
		int [] flametri4={d+100,d+92,d+108};
		g.fillPolygon(flametri3,flametri4,3);
		
		g.setColor(new Color(180,180,180));
		int [] tip={c+146,c+146,c+141};
		int [] tip2={d+85,d+115,d+100};
		g.fillPolygon(tip,tip2,3);
		
		int [] back={c+25,c+15,c+15,c+25};
		int [] back2={d+85,d+75,d+125,d+115};
		g.fillPolygon(back,back2,4);
		g.setColor(new Color(150,150,150));
		g.fillOval(c+82,d+84,32,32);
		g.setColor(new Color (153,255,255));
		g.fillOval(c+84,d+86,28,28);
		
	}

}

class Missle
{
	
	Missle (Graphics g, int x, int y)
	{
		//Draw
		Color navy= new Color (0,61,154);
		g.setColor(new Color(180,180,180));
		int [] polygon1= {x-20,x-30,x-80,x-95,x-80,x-30,x-20};
		int [] polygon2= {y,y+15,y+15,y+25,y+35,y+35,y+50};
		g.fillPolygon(polygon1,polygon2,7);
		g.setColor(navy);
		g.drawPolygon(polygon1,polygon2,7);
		int [] mid1= {x-25,x-75,x-85,x-75,x-25};
		int [] mid2= {y+20,y+20,y+25,y+30,y+30};
		g.fillPolygon(mid1,mid2,5);
		int [] triangle1= {x-23,x-27,x-22};
		int [] triangle2= {y+8,y+15,y+15};
		g.fillPolygon(triangle1,triangle2,3);
		int [] triangle3= {x-23,x-27,x-22};
		int [] triangle4= {y+35,y+35,y+42};
		g.fillPolygon(triangle3,triangle4,3);
		g.setColor(Color.black);
		g.drawRect(x-15,y+20,5,5);
		g.setColor(Color.gray);
		g.fillRect(x-15,y+20,5,5);
		g.setColor(Color.black);
		g.drawRect(x-15,y+25,5,5);
		g.setColor(Color.gray);
		g.fillRect(x-15,y+25,5,5);
		g.setColor(Color.orange);
		int [] flame1= {x-15,x-5,x-10,x,x-5,x,x-5,x-5,x-15};
		int [] flame2= {y+20,y+15,y+20,y+22,y+25,y+28,y+30,y+33,y+30};
		g.fillPolygon(flame1,flame2,9);
		
	}

}

class Laser
{
	
	
	Laser (Graphics g, int laserX, int laserY)
	{
		
		//Draw
		Graphics2D g2d = (Graphics2D)g;
		Color s2 = new Color(255,0,0);
		Color e1 = Color.white;
		GradientPaint gradient1 = new GradientPaint(10,10,s2,10,33,e1,true);
		g2d.setPaint(gradient1);
		g2d.fillRect(laserX,laserY,70,20);
		
		//Move
		laserX -= 100;
		
		if (laserX < 0)
			laserX = 40;
	}

}

class Health
{
	
	Health (Graphics g, int health)
	{
		int barX=-280; int barY=-130;
		
		//Bar + Heart
		if (health==5)
		{
			g.setColor(new Color(102,255,102));
			g.fillRect(barX+320,barY+158,105,16);
		}
		if (health==4)
		{
			g.setColor(new Color(102,255,102));
			g.fillRect(barX+320,barY+158,84,16);
		}
		if (health==3)
		{
			g.setColor(new Color(102,255,102));
			g.fillRect(barX+320,barY+158,63,16);
		}
		if (health==2)
		{
			g.setColor(Color.orange);
			g.fillRect(barX+320,barY+158,42,16);
		}
		if (health==1)
		{
			g.setColor(Color.red);
			g.fillRect(barX+320,barY+158,21,16);
		}
		g.setColor(new Color(180,180,180));
		g.drawRect(barX+320,barY+158,105,16);
		g.setColor(Color.pink);
		g.fillOval(barX+295,barY+144,40,40);
		g.setColor(Color.red);
		int [] newheart={barX+305,barX+315,barX+325};
		int [] newheart2={barY+165,barY+175,barY+165};
		g.fillPolygon(newheart,newheart2,3);
		g.fillOval(barX+303,barY+155,12,12);
		g.fillOval(barX+314,barY+155,12,12);
		
		//Number
		Font healthNum = new Font("Monospaced", 1, 25);
		g.setFont(healthNum);
		g.setColor(Color.WHITE);
		g.drawString(String.valueOf(health), 149, 45);
		
		//Checks for Game Over
		if (health < 1) {
			MyPanel4.gameState++;
		}
	}

}

class HealthPack
{
	
	HealthPack (Graphics g, int x, int y)
	{
		//Draw
		g.setColor(Color.white);
		g.fillOval(x,y,50,50);
		g.setColor(Color.pink);
		g.fillOval(x+5,y+5,40,40);
		g.setColor(Color.red);
		int [] heart={x+12,x+25,x+38};
		int [] heart1={y+25,y+38,y+25};
		g.fillPolygon(heart,heart1,3);
		g.fillArc(x+10,y+17,15,15,0,180);
		g.fillArc(x+24,y+17,15,15,0,180);
	}

}

class Lightning
{
	
	Lightning (Graphics g, int x, int y)
	{
		//Draw
		int boltX=x; int boltY=y;
		g.setColor(Color.white);
		g.fillOval(boltX,boltY,50,50);
		g.setColor(new Color(255,255,185));
		g.fillOval(boltX+5,boltY+5,40,40);
		int [] bolt={boltX+22,boltX+32,boltX+28,boltX+32,boltX+26,boltX+30,boltX+18,boltX+22,boltX+19,boltX+22,boltX+19};
		int [] bolt2={boltY+12,boltY+12,boltY+18,boltY+18,boltY+25,boltY+25,boltY+38,boltY+30,boltY+30,boltY+22,boltY+22};
		g.setColor(Color.orange);
		g.fillPolygon(bolt,bolt2,11);
	}

}

class Clock
{
	
	Clock (Graphics g, int clockX, int clockY)
	{
		//Draw
		g.setColor(Color.white);
		g.fillOval(clockX,clockY,50,50);
		g.setColor(new Color(153,255,255));
		g.fillOval(clockX+2,clockY+2,46,46);
		g.setColor(Color.blue);
		g.fillOval(clockX+6,clockY+6,38,38);
		g.setColor(Color.white);
		g.fillOval(clockX+10,clockY+10,30,30);
		g.setColor(Color.black);
		g.fillOval(clockX+23,clockY+23,4,4);
		g.fillRect(clockX+24,clockY+15,2,10);
		g.fillRect(clockX+25,clockY+25,10,2);
		g.setColor(new Color(180,180,180));
		g.fillOval(clockX+24,clockY+34,3,3);
		g.fillOval(clockX+12,clockY+24,3,3);
	}

}

class Rainbow
{
	
	Rainbow (Graphics g, int rainX, int rainY)
	{
		//Draw
		g.setColor(Color.white);
		g.fillOval(rainX,rainY,50,50);
		g.setColor(new Color(153,204,255));
		g.fillOval(rainX+4,rainY+391-387,43,43);
		g.setColor(Color.red);
		g.fillArc(rainX+7,rainY+400-387,38,38,0,180);
		g.setColor(new Color(255,128,0));
		g.fillArc(rainX+10,rainY+403-387,32,32,0,180);
		g.setColor(Color.yellow);
		g.fillArc(rainX+13,rainY+406-387,26,26,0,180);
		g.setColor(Color.green);
		g.fillArc(rainX+16,rainY+409-387,20,20,0,180);
		g.setColor(Color.blue);
		g.fillArc(rainX+19,rainY+412-387,14,14,0,180);
		g.setColor(new Color (127,0,255));
		g.fillArc(rainX+21,rainY+415-387,8,8,0,180);
	}

}