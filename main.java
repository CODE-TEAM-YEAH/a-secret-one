import java.util.Scanner;
import java.io.*;
	
public class main {
	
		public static void main(String[] args) {
			Boolean correctInput = false;
			int ChoiceP1 = 0;
			int CurrentPage = 0;
			String username = "";
			
			////////////////////////////////////////////////

			//Gets path of 'Users.txt' file.
			String filePath = new File("Users.txt").getAbsolutePath();
			
			String fileName = filePath;
	        String line = null;

	        try {
	            FileReader fileReader = 
	                new FileReader(fileName);

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
				CurrentPage = 1;
				System.out.println("Choose your option:	{1} Sign in\n                    	{2} Sign up");
				Scanner in1 = new Scanner(System.in);
				Scanner in2 = new Scanner(System.in);
				ChoiceP1 = in1.nextInt();
			
				if(ChoiceP1 == 1){
					//....................
					correctInput = true;
					System.out.println("Enter your username: ");
					username = in2.nextLine();
				}
				else if (ChoiceP1 == 2){
					//....................
					CurrentPage = 2;
					correctInput = true;
					System.out.println("Choose your username: ");
					username = in2.nextLine();
					System.out.println("Hello, Mr. " + username + "!"); 
					
					
				}
				else{
					System.out.println("\nInvalid output, please enter again.\n");
				}
			}
		}
}
