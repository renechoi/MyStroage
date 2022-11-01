import java.util.Scanner;

public class MyStorage {
	static void showMenu(){
		System.out.println("MyStorage V1");
		System.out.println("------------");
		System.out.println("1. register item info");
		System.out.println("2. stock items (stocking)");
		System.out.println("3. release items (releasing)");
		System.out.println("4. view inventory");
		System.out.println("5. exit");
		System.out.println("------------");
	}

	static int selectMenu(Scanner scan){
		System.out.println("Choose the menu (number) :");
		int select = scan.nextInt();
		return select;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {

			// 1. display menu
			showMenu();

			// 2. choose the menu
			int menu = selectMenu(scan);
			if (menu == 5) {
				System.out.println("Good bye. Program ends.");
				break;
			}

			switch (menu){
				case 1:
					System.out.println("register items \n");
					break;
				case 2 :
					System.out.println("stock items \n");
					break;
				case 3:
					System.out.println("withdraw items \n");
					break;
				case 4:
					System.out.println("view inventory \n");
					break;
			}

		}
		scan.close();
	}
}
