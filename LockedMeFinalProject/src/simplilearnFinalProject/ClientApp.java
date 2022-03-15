package simplilearnFinalProject;

import java.io.IOException;
import java.util.Scanner;

public class ClientApp {

	public static void main(String[] args) throws IOException 
	{
		Scanner sc=new Scanner(System.in);
		//variable to read choice from user
		int ch;
		
		do {
			//Method to display user menu options
			LockedMe.displayMenu();
			System.out.println("Enter your choice: ");
			ch=Integer.parseInt(sc.nextLine());
			
			switch(ch)
			{
				//Method to retrieve files
				case 1:LockedMe.getAllFiles();
						break;
				//Method to create new file
				case 2:LockedMe.createFiles();
						break;
				//Method to delete file
				case 3:LockedMe.deleteFiles();
						break;
				//Method to search file
				case 4:LockedMe.searchFiles();
						break;
				case 5:System.exit(0);
						break;
				default:System.out.println("Invalid Option");
						break;
			}
		}while(ch>0);
		
		sc.nextLine();
		sc.close();
	}

}
