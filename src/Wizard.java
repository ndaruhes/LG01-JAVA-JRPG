import java.util.Random;

public class Wizard extends Character {
	private int mana;

	public Wizard(String name, int level) {
		super(name, level);
		generateStats();
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public boolean checkMana() {
		if (this.getMana() < 50 / this.getLevel()) {
			return false;
		}
		return true;
	}

	public void heal() {
		Random rand = new Random();

		int totalHeal = (((rand.nextInt(10) + 1)) * this.getDamage()) / 10;
		this.setHealth(this.getHealth() + totalHeal);

		int consumedMana = 50 / this.getLevel();
		mana -= consumedMana;

		System.out.println(" Wizard consumed - " + consumedMana + " Mana");
		System.out.println(" Wizard healed - " + totalHeal + " Hp");
	}

	@Override
	public void die() {
		System.out.println(" Wizard Has Died");
		if (this.getLevel() != 1)
			this.setLevel(this.getLevel() - 1);
		this.setHealth(100);
	}

	@Override
	public int attack() {
		Random rand = new Random();

		// rumus attack = attackDamage * random(0.1 - 0.9) + bleedDamage
		int totalAttack = (((rand.nextInt(5) + 5)) * this.getDamage()) / 10;
		return totalAttack;
	}

	@Override
	public void takeDamage(int damage) {
		System.out.println(" Wizard has taken - " + (damage - this.getDefense()) + " Damage");
		this.setHealth(this.getHealth() - (damage - this.getDefense()));
	}

	@Override
	public void generateStats() {
		Random rand = new Random();

		this.setHealth(100);
		this.setDamage((rand.nextInt(3) * this.getLevel()) + 25);
		this.setDefense((rand.nextInt(3) * this.getLevel()) + 3);
		this.setMana((rand.nextInt(5) * this.getLevel()) + 100);
	}

	@Override
	public void levelUp() {
		Random rand = new Random();

		System.out.println("You Leveled Up!");

		this.setExp(0);
		this.setLevel(this.getLevel() + 1);
		this.setHealth(100);
		this.setDamage((rand.nextInt(3) * this.getLevel()) + this.getDamage());
		this.setDefense((rand.nextInt(3) * this.getLevel()) + this.getDefense());
		this.setMana((rand.nextInt(5) * this.getLevel()) + 100);
	}
}
