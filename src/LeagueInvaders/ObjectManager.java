package LeagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocketship;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer;
	int enemySpawnTime = 1750;
	int score;
	ObjectManager(Rocketship rocketship) {
		this.rocketship = rocketship;
	}
	void update() {
		rocketship.update();
		for (Projectile projectile : projectiles) {
			projectile.update();
		}
		for (Alien alien : aliens) {
			alien.update();
		}
	}
	void draw(Graphics g) {
		rocketship.draw(g);
		for (Projectile projectile : projectiles) {
			projectile.draw(g);
		}
		for (Alien alien : aliens) {
			alien.draw(g);
		}
	}
	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}
	void addAlien(Alien alien) {
		aliens.add(alien);
	}
	public void manageEnemies() {
		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(500), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}
	}
	void purgeObjects() {
		if(rocketship.isAlive == false) {
			System.out.println("hello");
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).isAlive == false) {
				projectiles.remove(projectiles.get(i));
			}
		}
		for (int i = 0; i < aliens.size(); i++) {
			if(aliens.get(i).isAlive == false) {
				aliens.remove(aliens.get(i));
			}
		}
	}
	void checkCollision() {
		for(Alien alien: aliens) {
			if(rocketship.collisionBox.intersects(alien.collisionBox)) {
				rocketship.isAlive = false;
			}
		}
		for (Projectile projectile : projectiles) {
			for (Alien alien : aliens) {
				if(projectile.collisionBox.intersects(alien.collisionBox)) {
					projectile.isAlive = false;
					alien.isAlive = false;
					score++;
				}
			}
		}
	}
	int getScore() {
		return score;
	}
}
