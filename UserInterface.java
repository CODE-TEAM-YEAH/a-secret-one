import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	private ArrayList<Readable> readables = new ArrayList<Readable>();
	private ArrayList<Audio> audioProducts = new ArrayList<Audio>();
	private int currentPage;
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

		}

		else if (page == 3) {

		}

		else if (page == 4) {
			
			System.out.println("No Access");
			Page1();

		} 
		
		else if (page == 5) {

		} 
		
		else if (page == 6) {

		}

		else if (page == 7) {

		} else if (page == 8) {

		} else if (page == 9) {

		} else if (page == 10) {

		}

		return page;
	}

	private void Page1() {

		System.out.println("Choose your option:	{1} Sign in\n                    	{2} Sign up");
		int choice = in.nextInt();

		if (choice == 1) {
			
			System.out.println("\nEnter your username: ");
			String userName = in.nextLine();
			boolean available = false;

			/////////////////////////////////////////////Reads in lines and compares to user's input.
			String fileName = "Users.txt";
			String line = null;

			try {
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				while ((line = bufferedReader.readLine()) != null) {
					
					if(userName == line){
					
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
			
			changeCurrentPage(2);
			
			if(available){
				System.out.println("Hello, Mr. " + userName + "!\n");
				changeCurrentPage(3);
			}
			
			else if(!available){
				
				changeCurrentPage(4);
			}
			
		}

		else if (choice == 2) {

		}
	}

	private void Page2() {

	}

	public void getReadables() {

	}

	public void getAudioProducts() {

	}

	public void showReadables() {

	}

	public void showAudioProducts() {

	}

}