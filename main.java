import java.util.Scanner;

public class HWK4_angelodp {
	
	public static void main(String[] args) {
		Boolean correctInput = false;
		int ChoiceP1 = 0;
		
		while (correctInput == false){
			System.out.println("Choose your option:	{1} Sign in\n                    	{2} Sign up ");
			Scanner in = new Scanner(System.in);
			ChoiceP1 = in.nextInt();
		
			if(ChoiceP1 == 1){
				//....................
				correctInput = true;
			}
			else if (ChoiceP1 == 2){
				//....................
				correctInput = true;
			}
			else{
				System.out.println("\nInvalid output, please enter again.\n");
			}
		}
	}

}
