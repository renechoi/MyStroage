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

}
