package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	int speed;
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 10;
	}
	void update() {
		super.update();
		y-=speed;
		if(y < 0) {
			isAlive = false;
		}
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.projectileImg, x, y, width, height, null);
	}
}
