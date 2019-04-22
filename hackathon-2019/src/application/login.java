package application;

import java.io.*;
import java.util.Scanner;

public class login {
	
	
	public void createStuff(String username, String email, String password) {
		
		File file = new File("\"C:\\Users\\socce\\Desktop\\hackathon 2019\\hackathon-2019\\src\\application\\users.txt\"");
		try {		
		Scanner scan = new Scanner(file);
		
		
		String temp[] = new String[3];
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			line.split(" ");
			for(int i = 1; i < temp.length; ) {
				if(temp[1].equals(username)) {
					System.out.println("Words");
				}
			}
		}
		}catch(Exception e) {
			System.out.println("broke");
		}
	}
}
