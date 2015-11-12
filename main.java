import java.util.Scanner;
import java.io.*;
	
public class main {
	
		public static void main(String[] args) {
			Boolean correctInput = false;
			int ChoiceP1 = 0;
			int ChoiceP2 = 0;
			int ChoiceP3 = 0;
			int CurrentPage = 0;
			String username = "";
			
////////////////////////////////////////////////

			//Gets path of 'Users.txt' file.
			String filePath = new File("Users.txt").getAbsolutePath();
			
			String fileName = filePath;
	        String line = null;

	        try {
	            FileReader fileReader = new FileReader(fileName);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);

	            while((line = bufferedReader.readLine()) != null) {
	                System.out.println(line);
	            }   
	            bufferedReader.close();  
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");    
	        }
				
////////////////////////////////////////////////
			
			
			while (correctInput == false){
				
				Boolean correctInput2 = false;
				Boolean correctInput3 = false;
				
				CurrentPage = 1;
				System.out.println("Choose your option:	{1} Sign in\n                    	{2} Sign up");
				Scanner in1 = new Scanner(System.in);
				Scanner in2 = new Scanner(System.in);
				Scanner in3 = new Scanner(System.in);
				Scanner in4 = new Scanner(System.in);
				ChoiceP1 = in1.nextInt();
			
				if(ChoiceP1 == 1){
					//....................
					correctInput = true;
					System.out.println("\nEnter your username: ");
					username = in2.nextLine();
				}
				else if (ChoiceP1 == 2){
					//....................
					CurrentPage = 2;
					correctInput = true;
					System.out.println("\nChoose your username: ");
					username = in2.nextLine();
					System.out.println("Hello, Mr. " + username + "!\n"); 
					
					while (correctInput2 == false){
						
						CurrentPage = 5;
						System.out.println("{1} View Items by Category\n{2} View Shopping Cart\n{3} Sign Out\nChoose your option:");
						ChoiceP2 = in3.nextInt();
					
						if(ChoiceP2 == 1){
							correctInput2 = true;
							
							while (correctInput3 == false){
							
								CurrentPage = 6;
								System.out.println("\n{1} Readables\n{2} Audio\nChoose your option:\n(Press -1 to go back to the previous menue)");
								ChoiceP3 = in4.nextInt();
							
								if(ChoiceP3 == 1){
									correctInput3 = true;
									//....................SHOW READABLES TEXT FILE
									CurrentPage = 8;
								}
								
								else if(ChoiceP3 == 2){
									correctInput3 = true;
									//.................SHOW AUDIO TEXT FILE
									CurrentPage = 9;
								}
								
								else{
									System.out.println("\nInvalid output, please enter again.\n");
								}
							}
						}
						else if (ChoiceP2 == 2){
							correctInput2 = true;
							//.................SHOW SHOPPING CART TEXT FILE
							CurrentPage = 7;
						}
						else if (ChoiceP2 == 3){
							correctInput2 = true;
							correctInput = false;
							//.................
							CurrentPage = 1;
						}
						else{
							System.out.println("\nInvalid output, please enter again.\n");
						}
					}
					
				}
				else{
					System.out.println("\nInvalid output, please enter again.\n");
				}
			}
		}
}
