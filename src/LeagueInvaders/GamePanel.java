package LeagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font subtitleFont;
	Rocketship rocketship;
	ObjectManager objectmanager;
	GamePanel(){
		timer = new Timer(1000/60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subtitleFont = new Font("Arial", Font.PLAIN, 30);
		rocketship = new Rocketship(250, 700, 50, 50);
		objectmanager = new ObjectManager(rocketship);
	}
	void startGame() {
		timer.start();
	}
	void updateMenuState() {
			
	}
	void updateGameState() {
		objectmanager.update();
		objectmanager.manageEnemies();
		objectmanager.checkCollision();
		objectmanager.purgeObjects();
		if(rocketship.isAlive == false) {
			currentState++;
		}
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 15, 200);
		g.setFont(subtitleFont);
		g.drawString("Press ENTER to Start", 30, 400);
		g.drawString("Press SPACE for Instructions", 30, 500);
	}
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		objectmanager.draw(g);
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 15, 200);
		g.setFont(subtitleFont);
		g.drawString("You Killed 0 Enemies", 30, 400);
		g.drawString("Press ENTER To Restart", 30, 500);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
		if(currentState == MENU_STATE) {
			updateMenuState();
		}else if(currentState == GAME_STATE) {
			updateGameState();
		}else if(currentState == END_STATE) {
			updateEndState();
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		if(currentState == MENU_STATE) {
			drawMenuState(g);
		}else if(currentState == GAME_STATE) {
			drawGameState(g);
		}else if(currentState == END_STATE) {
			drawEndState(g);
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if(currentState > END_STATE) {
				currentState = MENU_STATE;
			}else if(rocketship.isAlive == false && currentState == END_STATE) {
				rocketship = new Rocketship(250, 700, 50, 50);
				rocketship.isAlive = true;
				objectmanager = new ObjectManager(rocketship);
			}
			System.out.println(currentState);
		}
		if(arg0.getKeyCode() == KeyEvent.VK_UP) {
			rocketship.moveUp = true;
		}else if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			rocketship.moveLeft = true;
		}else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocketship.moveRight = true;
		}else if(arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			rocketship.moveDown = true;
		}
		if(arg0.getKeyCode() == KeyEvent.VK_SPACE) {
			objectmanager.addProjectile(new Projectile(rocketship.getX() + 20, rocketship.getY() + 20, 10, 10));
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_UP) {
			rocketship.moveUp = false;
		}else if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			rocketship.moveLeft = false;
		}else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocketship.moveRight = false;
		}else if(arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			rocketship.moveDown = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}
