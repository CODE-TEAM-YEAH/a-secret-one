import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	private ArrayList<Readable> readables = new ArrayList<Readable>();
	private ArrayList<Audio> audioProducts = new ArrayList<Audio>();
	private int currentPage;
	String userName = "";
	private Scanner in = new Scanner(System.in);

	public int changeCurrentPage(int page) {

		currentPage = page;
		return getCurrentPage(page);
	}

	public int getCurrentPage(int page) {

		if (page == 1) {

			Page1();

		}

		else if (page == 2) {

			System.out.println("Username Successfully added");
			Page1();
		}

		else if (page == 3) {

			System.out.println("Hello, Mr. " + userName + "!\n");
			Page5();
		}

		else if (page == 4) {

			System.out.println("No Access");
			Page1();

		}

		else if (page == 5) {

			Page5();
		}

		else if (page == 6) {

			Page6();
		}

		else if (page == 7) {

			Page7();

		}

		else if (page == 8) {

			Page8();

		} else if (page == 9) {

			Page9();

		} else if (page == 10) {

		}

		return page;
	}

	private void Page1() {

		readables.clear();
		audioProducts.clear();
		getReadables();
		getAudioProducts();

		System.out.println("Choose your option:	{1} Sign in\n                    	{2} Sign up");
		int choice = in.nextInt();

		if (choice == 1) {

			System.out.println("\nEnter your username: ");
			userName = in.next();
			boolean available = false;

			///////////////////////////////////////////// Reads in lines and
			///////////////////////////////////////////// compares to user's
			///////////////////////////////////////////// input.
			String fileName = "Users.txt";
			String line = null;

			try {
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				while ((line = bufferedReader.readLine()) != null) {
					// System.out.println(line + " and the username " +
					// userName);
					if (userName.equals(line)) {

						available = true;
					}

				}
				bufferedReader.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException ex) {
				System.out.println("Error reading file '" + fileName + "'");
			}
			/////////////////////////////////////////////

			if (available) {
				changeCurrentPage(3);
			}

			else if (!available) {

				changeCurrentPage(4);
			}

		}

		else if (choice == 2) {

			System.out.println("\nChoose your username: ");
			userName = in.next();
			/////////////////////////////////////////////
			String fileName = "Users.txt";

			try {
				FileWriter fileWriter = new FileWriter(fileName, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write("\n" + userName);
				bufferedWriter.close();

			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException ex) {
				System.out.println("Error reading file '" + fileName + "'");
			}
			/////////////////////////////////////////////

			changeCurrentPage(2);
		}
	}

	private void Page5() {
		System.out.println("{1} View Items by Category\n{2} View Shopping Cart\n{3} Sign Out\nChoose your option:");
		int choice2 = in.nextInt();

		if (choice2 == 1) {

			changeCurrentPage(6);
		}

		else if (choice2 == 2) {

			changeCurrentPage(7);
		}

		else if (choice2 == 3) {

			changeCurrentPage(1);
		}
	}

	private void Page6() {

		System.out.println(
				"\n{1} Readables\n{2} Audio\nChoose your option:\n(Press -1 to go back to the previous menue)");
		int choice3 = in.nextInt();

		if (choice3 == 1) {

			changeCurrentPage(8);
		}

		else if (choice3 == 2) {

			changeCurrentPage(9);
		}

		else if (choice3 == -1) {

			changeCurrentPage(5);
		}

	}

	private void Page7() {
		
	}

	private void Page8() {

		System.out.println("Readables:\nS.No" + "   " + "Name of the Book" + "   " + "Author" + "   " + "Price($)"
				+ "   " + "Quantity in Store" + "   " + "Type");
		showReadables();
		System.out.println("\nPress -1 to return to previous menu.");
		if(in.nextInt() == -1){
			changeCurrentPage(6);
		}
	}

	private void Page9() {

		System.out.println("Audio:\nS.No" + "   " + "Name of the Book" + "   " + "Artist" + "   " + "Price($)"
				+ "   " + "Quantity in Store" + "   " + "Type");
		showAudioProducts();
		System.out.println("\nPress -1 to return to previous menu.");
		if(in.nextInt() == -1){
			changeCurrentPage(6);
		}
	}

	public void getReadables() { /// +

		///////////////////////////////////////////// input
		String fileName = "Books.txt";
		String line;

		try {
			FileReader fileReader2 = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader2);

			while ((line = bufferedReader.readLine()) != null) {

				String info[] = line.split(", ");
				readables.add(new Book(info));
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		/////////////////////////////////////////////
		String fileName2 = "Ebooks.txt";
		String line2;

		try {
			FileReader fileReader3 = new FileReader(fileName2);
			BufferedReader bufferedReader2 = new BufferedReader(fileReader3);

			while ((line2 = bufferedReader2.readLine()) != null) {

				
				String info2[] = line2.split(", ");
				readables.add(new eBook(info2));
			}
			bufferedReader2.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName2 + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName2 + "'");
		}

	}

	public void getAudioProducts() { /// +

		///////////////////////////////////////////// input
		String fileName = "CDs.txt";
		String line;

		try {
			FileReader fileReader2 = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader2);

			while ((line = bufferedReader.readLine()) != null) {

				String info[] = line.split(", ");
				audioProducts.add(new CD(info));
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		/////////////////////////////////////////////
		String fileName2 = "MP3.txt";
		String line2;

		try {
			FileReader fileReader3 = new FileReader(fileName2);
			BufferedReader bufferedReader2 = new BufferedReader(fileReader3);

			while ((line2 = bufferedReader2.readLine()) != null) {

				String info2[] = line2.split(", ");
				audioProducts.add(new MP3(info2));
			}
			bufferedReader2.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName2 + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName2 + "'");
		}
	}

	public String fmtProducts(int space, String data) {
		int l = data.length();
		String k;
		if (l > space) {
			k = data.substring(0, space - 3) + "...";
		} else {
			String m = "";
			for (int j = 0; j < (space - l); j++) {
				m += " ";
			}
			k = data + m;
		}
		return k;
	}

	public void showReadables() {
		String[] read;
		for (Readable i : readables) {
			read = i.getInfo().split("///");

			System.out.println(" " + fmtProducts(5, read[0]) + "  " + fmtProducts(17, read[1]) + "  "
					+ fmtProducts(7, read[2]) + "  " + fmtProducts(9, read[3]) + "  " + fmtProducts(18, read[4]) + "  "
					+ fmtProducts(5, read[5]));
		}
	}

	public void showAudioProducts() {

		String[] read;
		for (Audio i : audioProducts) {
			read = i.getInfo().split("///");

			System.out.println(" " + fmtProducts(5, read[0]) + "  " + fmtProducts(17, read[1]) + "  "
					+ fmtProducts(7, read[2]) + "  " + fmtProducts(9, read[3]) + "  " + fmtProducts(18, read[4]) + "  "
					+ fmtProducts(5, read[5]));
		}

	}

}