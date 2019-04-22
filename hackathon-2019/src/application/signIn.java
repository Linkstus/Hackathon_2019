package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class signIn {
	
	
	@SuppressWarnings("resource")
	public void createUser(String userName, String email, String password) {
		File file = new File("C:\\Users\\socce\\Desktop\\hackathon 2019\\hackathon-2019\\src\\application\\users.txt");
		try {
			Scanner scan = new Scanner(file);
			FileWriter fw = new FileWriter(file,true);
	    	BufferedWriter bw = new BufferedWriter(fw);
	    	PrintWriter pw = new PrintWriter(bw);
			boolean found = false;
			
			
			while(scan.hasNextLine() || found == true) {
				if(userName.equals(scan.next()) || email.equals(scan.next())) {
					found = true;
				}
			}
			
			if(!found) {
				pw.println(userName + " " + email + " " + password);
			}else if(found) {
				throw new Exception("already a username/email with used");
			}
			
			scan.close();
			pw.close();
		}catch(Exception e) {
			System.out.println("Winner of the most failed!");
			
		}
	}
	
	
}
