package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed;
	boolean moveUp;
	boolean moveLeft;
	boolean moveRight;
	boolean moveDown;
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		this.moveUp = false;
		this.moveLeft = false;
		this.moveRight = false;
		this.moveDown = false;
	}
	void update() {
		super.update();
		if(moveUp == true) {
			y-=speed;
		}else if(moveLeft == true) {
			x-=speed;
		}else if(moveRight == true) {
			x+=speed;
		}else if(moveDown == true) {
			y+=speed;
		}
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketshipImg, x, y, width, height, null);
	}
	void setX(int x) {
		this.x = x;
	}
	void setY(int y) {
		this.y = y;
	}
	int getX() {
		return x;
	}
	int getY() {
		return y;
	}
	
}
