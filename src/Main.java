import java.util.Random;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	Character player;

	public void printMenu() {
		System.out.println(" Welcome to The Game!");
		System.out.println("======================");
		System.out.println(" 1. Play");
		System.out.println(" 2. Exit");
		System.out.print(" >> ");
	}

	public void cls() {
		for (int i = 0; i < 40; i++) {
			System.out.println("");
		}
	};

	public void printChooseMenu() {
		System.out.println("Choose a Side");
		System.out.println("======================");
		System.out.println(" 1. Knights");
		System.out.println(" 2. Wizards");
		System.out.print(" >>");
	}

	public void choose() {

		while (true) {
			cls();
			printChooseMenu();
			int input = scan.nextInt();
			scan.nextLine();
			if (input == 1) {
				player = new Knight("Knight", 1);
				break;
			} else if (input == 2) {
				player = new Wizard("Wizard", 1);
				break;
			}
		}
		System.out.println(" Successfully created new player");
		System.out.println(" Press enter to continue...");
		scan.nextLine();
	}

	public void printPlayMenu() {
		System.out.println(" 1. Enter a Fight");
		System.out.println(" 2. Rest");
		System.out.println(" 3. End Game");
		System.out.print(" >> ");
	}

	public void fight() {
		Character enemy;
		if (player instanceof Knight) {
			enemy = new Wizard("Wizard", player.getLevel());
		} else {
			enemy = new Knight("Knight", player.getLevel());
		}

		while (!player.checkDeath() && !enemy.checkDeath()) {
			cls();
			System.out.println(" BATTLE ARENA");
			System.out.println(" ==========================================================");
			player.printInfo();
			if (player instanceof Knight) {
				while (true) {
					System.out.println(" Choose your move: ");
					System.out.println(" 1. Attack");
					System.out.println(" 2. Defend");
					System.out.print(" >> ");
					int input = scan.nextInt();
					scan.nextLine();

					if (input == 1) {

						int attackDamage = player.attack();
						enemy.takeDamage(attackDamage);
						if (enemy.checkDeath() == true) {
							player.obtainExp();
							System.out.println(" You gained Exp !");
							System.out.println(" Press enter to continue...");
							scan.nextLine();
							return;
						}
						break;
					} else if (input == 2) {
						((Knight) player).setDefending(true);
						break;
					}
				}
				enemy.printInfo();
				Random rand = new Random();
				int randomMove = rand.nextInt(100);
				if (randomMove > 50 && ((Wizard) enemy).checkMana()) {
					((Wizard) enemy).heal();
				} else {
					int enemyAttackDamage = enemy.attack();
					if (((Knight) player).isDefending()) {
						((Knight) player).Defend(enemyAttackDamage);
						((Knight) player).setDefending(false);
					} else {
						player.takeDamage(enemyAttackDamage);
					}
				}
				System.out.println(" Press enter to continue...");
				scan.nextLine();

			} else {
				while (true) {
					System.out.println(" Choose your move: ");
					System.out.println(" 1. Attack");
					System.out.println(" 2. Heal");
					System.out.print(" >> ");
					int input = scan.nextInt();
					scan.nextLine();

					if (input == 1) {

						int attackDamage = player.attack();
						if (((Knight) enemy).isDefending()) {
							((Knight) enemy).Defend(attackDamage);
							((Knight) enemy).setDefending(false);
						} else {
							enemy.takeDamage(attackDamage);
						}

						if (enemy.checkDeath() == true) {
							player.obtainExp();
							System.out.println(" You gained Exp !");
							System.out.println(" Press enter to continue...");
							scan.nextLine();
							return;
						}
						break;
					} else if (input == 2) {
						if (!((Wizard) player).checkMana()) {
							System.out.println(" Mana is not enough!!");
							System.out.println(" Press enter to continue...");
							scan.nextLine();
							continue;
						}
						((Wizard) player).heal();
						break;
					}
				}
				enemy.printInfo();
				Random rand = new Random();
				int randomMove = rand.nextInt(100);
				if (randomMove > 50 && !((Knight) enemy).isDefending()) {
					((Knight) enemy).setDefending(true);
				} else {
					int enemyAttackDamage = enemy.attack();
					player.takeDamage(enemyAttackDamage);
				}
				System.out.println(" Press enter to continue...");
				scan.nextLine();
			}
		}

		System.out.println("You died...");
		System.out.println("Press enter to go back to the main menu...");

		scan.nextLine();
	}

	public void play() {
		while (true) {
			cls();
			player.printInfo();
			printPlayMenu();
			int input = scan.nextInt();
			scan.nextLine();

			if (input == 1) {
				fight();
			} else if (input == 2) {
				player.rest();
				System.out.println(" Press enter to continue...");
				scan.nextLine();

			} else if (input == 3) {
				System.out.println(" Thanks for playing the game..");
				System.out.println(" Press enter to exit..");
				scan.nextLine();
				return;
			}
		}

	}

	public void menu() {
		while (true) {
			cls();
			printMenu();
			int input = scan.nextInt();
			scan.nextLine();
			if (input == 1) {
				choose();
				play();
			} else if (input == 2) {
				return;
			}
		}

	}

	public Main() {
		menu();
	}

	public static void main(String[] args) {
		new Main();

	}
}
