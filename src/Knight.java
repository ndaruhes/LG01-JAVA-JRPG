import java.util.Random;

public class Knight extends Character {
	private int bleedDamage;
	private int shieldDefense;
	private boolean isDefending;

	public Knight(String name, int level) {
		super(name, level);
		generateStats();
	}

	public boolean isDefending() {
		return isDefending;
	}

	public void setDefending(boolean isDefending) {
		this.isDefending = isDefending;
	}

	public int getBleedDamage() {
		return bleedDamage;
	}

	public int getShieldDefense() {
		return shieldDefense;
	}

	public void setBleedDamage(int bleedDamage) {
		this.bleedDamage = bleedDamage;
	}

	public void setShieldDefense(int shieldDefense) {
		this.shieldDefense = shieldDefense;
	}

	public void Defend(int damage) {

		if (damage < (this.getDefense() + this.getShieldDefense())) {
			System.out.println(" Knight has nullified all the Damage!");
		} else {
			System.out.println(
					" Knight has taken - " + (damage - (this.getDefense() + this.getShieldDefense())) + " Damage");
			System.out.println(
					" Knight has deflected a total of - " + (this.getDefense() + this.getShieldDefense()) + " Damage");
			this.setHealth(this.getHealth() - (damage - (this.getDefense() + this.getShieldDefense())));
		}
	}

	@Override
	public void die() {
		System.out.println(" Knight Has Died...");
		if (this.getLevel() != 1)
			this.setLevel(this.getLevel() - 1);

		this.setHealth(100);
	}

	@Override
	public int attack() {

		Random rand = new Random();

		// rumus attack = attackDamage * random(0.1 - 0.9) + bleedDamage
		int totalAttack = ((rand.nextInt(10) + 1) * this.getDamage()) / 10 + this.getBleedDamage();

		return totalAttack;
	}

	@Override
	public void takeDamage(int damage) {

		System.out.println(" Knight has taken - " + (damage - this.getDefense()) + " Damage");
		this.setHealth(this.getHealth() - (damage - this.getDefense()));
	}

	@Override
	public void generateStats() {
		Random rand = new Random();

		this.setHealth(100);
		this.setDamage((rand.nextInt(5) * this.getLevel()) + 20);
		this.setDefense((rand.nextInt(4) * this.getLevel()) + 5);
		this.setBleedDamage((rand.nextInt(2) * this.getLevel()) + 5);
		this.setShieldDefense((rand.nextInt(5) * this.getLevel()) + 20);
	}

	@Override
	public void levelUp() {
		Random rand = new Random();

		System.out.println(" You Leveled Up!");

		this.setExp(0);
		this.setLevel(this.getLevel() + 1);
		this.setHealth(100);
		this.setDamage((rand.nextInt(5) * this.getLevel()) + this.getDamage());
		this.setDefense((rand.nextInt(4) * this.getLevel()) + this.getDefense());
	}
}
