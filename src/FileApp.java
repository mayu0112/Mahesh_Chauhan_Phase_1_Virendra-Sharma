import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileApp {
	
	static String Parent_folder = "C://Project";
	
	public static void main(String[] args) throws Exception {
		// Welcome Screen
		System.out.println("*************************************************************");
		System.out.println("*****        Welcome to Lockers Pvt. Ltd.               *****");
		System.out.println("*****  This application provides file Management System *****");
		System.out.println("*****  It has below options:                            *****");
		System.out.println("*****  1: List of current files in ascending order      *****");
		System.out.println("*****  2: File handling (Add, Delete, Search)           *****");
		System.out.println("*****                    - Developed by Mahesh Chauhan  *****");
		System.out.println("*************************************************************");
		
		//Create Parent Folder for storing files.
		File file = new File(Parent_folder);
		if (!file.exists()) {
            file.mkdir();
        }
		
		// Take initial input from users.
		int i = 0;
		while (i == 0) {
			System.out.println("Please enter the option from below list:");
			System.out.println("1 : To list the current list of files " );
			System.out.println("2 : To perform further action on files ");
			System.out.println("3 : Exit from the Application");
			try {
				Scanner scan = new Scanner(System.in);
				int Initial_input  = scan.nextInt();
				switch(Initial_input) {
				case 1:
					fileList();
					break;
				case 2:
					System.out.println("*** File Handling Mode ***");
					fileHanding();
					break;
				case 3:
					System.out.println("Exiting the application");
					i = 1;
					System.exit(0);
				default:
					System.out.println("Enter Valid Option");
					
				}
				
			}
			catch (Exception e) {
				System.out.println("Enter Valid Numeric Option");
			}

		}
		 
	}
	
	// ** Level 1 - Functions for initial input ** 
	
	// Option 1 : Function to display the current list of files 
	static void fileList() {
		File file = new File(Parent_folder);
		if (file.list().length == 0) {
			System.out.println("No Files in Current Directory");
		}
		else {
			System.out.println("Current list of files");
			String[] file_lists = file.list();
			for (String files : file_lists) {
				System.out.println(files);
			}
		}
		System.out.println(" ");
	}
	
	// Option 2 : File Handing Function
	static void fileHanding() throws Exception {
		int j = 0;
		while (j == 0) {
			System.out.println("Please select the option for file handling: ");
			System.out.println("1: To Add a file" );
			System.out.println("2: To Delete a file");
			System.out.println("3: To Search a specific file");
			System.out.println("4: To Exit File Handling Mode");
			try {
				Scanner scan = new Scanner(System.in);
				int file_input  = scan.nextInt();

				switch(file_input) {
				case 1:
					System.out.println("Please enter the file name for addition:");
					String add_file = scan.next().toString();
					addition(add_file);
					System.out.println(" ");
					break;
				case 2:
					System.out.println("Please enter the file name for Delete:");
					String delete_file = scan.next().toString();
					deletion(delete_file);
					System.out.println(" ");
					break;
				case 3:
					System.out.println("Please enter the file name you want to Search:");
					String search_file = scan.next().toString();
					search(search_file);
					System.out.println(" ");
					break;
				case 4:
					System.out.println("** Exiting the file handling mode **");
					System.out.println(" ");
					j = 1;
					break;
				default:
					System.out.println("Enter Valid Option");
				}
			}
			catch (Exception e) {
				System.out.println("Enter Valid Numeric Option");
			}
				
		}

	}
	
	
	
	// ** Level 2 - Functions for file handling **
	
	// File Addition Function
	static void addition(String add_file) {
		String path = Parent_folder + "//" + add_file;
		try {
			File file = new File(path);
			
			if (file.createNewFile() ) {
				System.out.println("New File Added : " + add_file);
			}
			else {
				if (file.exists()) {
					System.out.println("File already Exist");
				}
			}
		}
		catch (IOException e) {
			System.out.println();
			e.printStackTrace();
		}
	}
	
	
	// File Deletion Function
	static void deletion(String delete_file) throws IOException {
		
		String del_file = delete_file;
		File p_file = new File(Parent_folder);
		if (p_file.list().length == 0) {
			System.out.println("No file for deletion");
		} 
		else {
			String[] file_lists = p_file.list();
			for (String files : file_lists) {
				if (delete_file.toLowerCase().equals(files.toLowerCase()) ) {
					del_file = files;
					break;
				}
			}
		}
			
		String path = Parent_folder + "//" + del_file;
		File file = new File(path);

		boolean b = file.delete();
		if (b==true) {
			System.out.println("File Deleted Succesfully : " + del_file);
		}
		else {
			System.out.println("File Not Found");	
		}
			
	}
	
	
	// File Search Function
	static void search(String search_file) throws IOException {
		
		
		String find_file = null;
		File p_file = new File(Parent_folder);
		if (p_file.list().length == 0) {
			System.out.println("No file for deletion");
		} 
		else {
			String[] file_lists = p_file.list();
			for (String files : file_lists) {
					if (search_file.toLowerCase().equals(files.toLowerCase()) ) {
					find_file = files;
					System.out.println("File Found Succesfully : " + files);
					break;
				}
			}
		}
		
		if (find_file == null) {
			System.out.println("No matching file found as per search criteria");
		}
	}
	
}
