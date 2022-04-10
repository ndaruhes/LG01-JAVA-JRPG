import java.util.Random;

public abstract class Character {
	private String name;
	private int health;
	private int defense;
	private int damage;
	private int level;
	private int exp;

	public Character(String name, int level) {
		super();
		this.name = name;
		this.level = level;
		this.exp = 0;
	}

	public abstract void die();

	public abstract int attack();

	public abstract void takeDamage(int damage);

	public abstract void generateStats();

	public void rest() {
		if (this.getHealth() >= 100) {
			System.out.println(" Hp already maxed");
			return;
		}

		if (this.getHealth() + 30 > 100) {
			System.out.println(this.getName() + " Has been Healed to max HP");
			this.setHealth(100);
		} else {
			System.out.println(this.getName() + " Has been Healed 30 Hp");
			this.setHealth(this.getHealth() + 30);
		}

	}

	public boolean checkDeath() {
		if (this.getHealth() <= 0) {
			die();
			return true;
		}
		return false;
	}

	public void printInfo() {
		System.out.println(" ==========================================================");
		System.out.println(" Name   : " + this.getName() + " Lv. " + this.getLevel());
		System.out.println(" Exp(" + this.getExp() + "/100)");
		System.out.println(" Hp     : " + this.getHealth());
		System.out.println(" Atk    : " + this.getDamage());
		System.out.println(" ==========================================================");

	}

	public abstract void levelUp();

	public void checkLevelUp() {

		if (this.getExp() >= 100) {
			levelUp();
		}

	}

	public void obtainExp() {
		Random rand = new Random();

		int extraExp = (rand.nextInt(10) + 5) * 8;

		this.setExp(this.getExp() + extraExp);

		checkLevelUp();
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getDefense() {
		return defense;
	}

	public int getDamage() {
		return damage;
	}

	public int getLevel() {
		return level;
	}

	public int getExp() {
		return exp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
}
