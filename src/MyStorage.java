import java.util.Scanner;

public class MyStorage {
	private static final String EMPTY = "없음";
	public static final int NOT_EMPTY = -1;
	public static final int NOT_FOUND = -1;

	static void showMenu() {
		System.out.println("MyStorage V2");
		System.out.println("------------");
		System.out.println("1. register item info");
		System.out.println("2. stock items (stocking)");
		System.out.println("3. release items (releasing)");
		System.out.println("4. view inventory");
		System.out.println("5. exit");
		System.out.println("------------");
	}

	static int selectMenu(Scanner scan) {
		System.out.println("Choose the menu (number) :");
		return scan.nextInt();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] products = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
		int[] counts = {0, 0, 0, 0, 0};
		while (true) {

			// 1. display menu
			showMenu();

			// 2. choose the menu
			int menu = selectMenu(scan);
			if (menu == 5) {
				System.out.println("Good bye. Program ends.");
				break;
			}

			switch (menu) {
				case 1:
					register(scan, products);
					System.out.println("Register item \n");
					break;
				case 2:
					stock(scan, products, counts);
					System.out.println("Stock item \n");
					break;
				case 3:
					withdraw(scan, products, counts);
					System.out.println("Withdraw items \n");
					break;
				case 4:
					search(products, counts);
					System.out.println("View inventory \n");
					break;
			}

		}
		scan.close();
	}

	static void register(Scanner scan, String[] products) {        // products 를 배열로 받는다. 만약 내부에서 받게 되면 함수 실행시마다 매번 초기화된다.
		System.out.println("Register a new item");
		System.out.println("Please enter the item name");

		String input = scan.next();
		int emptyIdx = NOT_EMPTY;
		for (int i = 0; i < products.length; i++) {
			String product = products[i];
			if (EMPTY.equals(product)) {
				emptyIdx = i;
				System.out.println(emptyIdx);
				break;
			}
		}

		if (emptyIdx < 0) {            // NOT_EMPTY는 -1로 설정. 즉 0보다 작다면 비어있는 슬롯이 없다는 뜻이다.
			System.out.println("Storage is full. Unable to register.");
			return;
		}

		products[emptyIdx] = input;
		System.out.println("Item's registered. The inventory includes : ");
		for (String product : products) {
			System.out.println(product);
		}
	}

	static void stock(Scanner scan, String[] products, int[] counts) {
		System.out.println("Stock the item");
		System.out.println("A List of registered item");

		for (String product : products) {
			System.out.println("> " + product);
		}

		System.out.println("Please enter the item name");
		String input = scan.next();
		int foundIdx = NOT_FOUND;
		for (int i = 0; i < products.length; i++) {
			String product = products[i];
			if (input.equals(product)) {
				foundIdx = i;
				break;
			}
		}

		if (foundIdx < 0) {
			System.out.println("Item's not registered. Unable to stock");
			return;
		}

		System.out.println("Please enter amount.");
		int count = scan.nextInt();
		counts[foundIdx] += count;

		System.out.println("Successfully stocked item. The inventory includes : ");
		for (int i = 0; i < products.length; i++) {
			System.out.println("> " + products[i] + ": " + counts[i]);

		}
	}

	static void withdraw(Scanner scan, String[] products, int[] counts) {
		System.out.println("Withdraw the item.");
		System.out.println("A List of registered item");

		for (String product : products) {
			System.out.println("> " + product);
		}

		System.out.println("Please enter the item name");
		String input = scan.next();
		int foundIdx = NOT_FOUND;
		for (int i = 0; i < products.length; ++i) {
			String product = products[i];
			if (input.equals(product)) {
				foundIdx = i;
				break;
			}
		}

		if (foundIdx < 0) {
			System.out.println("Item's not registered. Unable to stock");
			return;
		}

		System.out.println("Please enter amount");
		int cnt = scan.nextInt();
		counts[foundIdx] -= cnt;

		System.out.println("Successfully withdraw item. The inventory includes : ");
		for (int i = 0; i < products.length; ++i) {
			System.out.println("> " + products[i] + ": " + counts[i]);
		}

	}

	static void search(String[] products, int[] counts) {
		System.out.println("A List of registered item");
		for (int i = 0; i < products.length; ++i) {
			System.out.println("> " + products[i] + ": " + counts[i]);
		}
	}


}
