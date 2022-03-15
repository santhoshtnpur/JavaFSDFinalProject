package simplilearnFinalProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe {
	
	//variable stores file path
	static final String projectFilesPath="C:\\Users\\Santhosh\\Desktop\\Simplilearn\\Phase-1-Final-Project\\files";
	
	/**
	 * This Method display welcome message and menu options for end users
	 */
	public static void displayMenu() 
	{
		System.out.println("****************************************************");
		System.out.println("\t Welcome to LockedMe.com secure App");
		System.out.println("\t     Developed by : SANTHOSH M");
		System.out.println("****************************************************");
		System.out.println("\t\t 1) Display all files");
		System.out.println("\t\t 2) Add a new file");
		System.out.println("\t\t 3) Delete a file");
		System.out.println("\t\t 4) Search file");
		System.out.println("\t\t 5) Exit");
		
		System.out.println("****************************************************");
	}
	
	/**
	 * This method will retrieve all the files
	 */
	public static void getAllFiles() 
	{
		File folder = new File(projectFilesPath);
		File[] listOfFiles=folder.listFiles();
	
	    for(var l : listOfFiles) {
	      System.out.println(l.getName());
	    }
	}
	
	/**
	 * This method will read file details from user and create new file
	 * @throws IOException
	 */
	
	public static void createFiles() throws IOException {
		
		try {
			Scanner s=new Scanner(System.in);
			String fileName;
			System.out.println("Enter file name : ");
			fileName=s.nextLine();
		
			int linesCount;
			System.out.println("Enter how many lines in a file: ");
			linesCount=Integer.parseInt(s.nextLine());
		
			FileWriter fw= new FileWriter(projectFilesPath+"\\"+fileName);
		
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter file line");
				fw.write(s.nextLine()+"\n");
			}
		
			System.out.println("Files Created Sucessfully");
			fw.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	/**
	 * This method will take file name as parameter and checks 
	 * if it is present in the project folder or not
	 * @param fileName String
	 * @return boolean
	 */
	public static boolean checkFileExists(String fileName)
	{
		//Array list to store file names in a project folder
		ArrayList<String> allFilesNames = new ArrayList<String>();
		
		File folder = new File(projectFilesPath);
		File[] listOfFiles=folder.listFiles();
		
		if(listOfFiles.length>0) {
			for(var l:listOfFiles)
			{
				allFilesNames.add(l.getName());				}
		}
		
		if(allFilesNames.contains(fileName))
			return true;
		else 
			return false;
	}
	
	/**
	 * This method use to delete file in a project folder by accepting file name from user
	 */
	public static void deleteFiles() {
		
		try 
		{
			Scanner sc=new Scanner(System.in);
			String fileName;
			System.out.println("Enter the file name to be deleted: ");
			fileName= sc.nextLine();
			
			File f=new File(projectFilesPath+"\\"+fileName);
			
			if(checkFileExists(fileName))
			{
				f.delete();
				System.out.println("File Deleted Sucessfully");
			}
			else {
				System.out.println("File doesnot exist");
			}
		}
		catch(Exception Ex)
		{
			System.out.println("File Unable to delete. Contact Admin");
		}
		
		
		
	}
	
	/**
	 * This method use to search a given file in a project folder accepting file name from user
	 */
	
	public static void searchFiles() {
		try 
		{
			Scanner sc=new Scanner(System.in);
			String fileName;
			System.out.println("Enter the file name to be searched: ");
			fileName= sc.nextLine();
			
			
			if(checkFileExists(fileName))
			{
			
				System.out.println("File avilable in folder");
			}
			else {
				System.out.println("File doesnot exist");
			}
		}
		catch(Exception Ex)
		{
			System.out.println("File Unable to search. Contact Admin");
		}
		
	}

}
