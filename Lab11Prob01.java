/**
 * File: Lab11Prob01.java
 * Class: CSCI 1302
 * Authors: Eli McHugh, Rendy Jenkins
 * Last Modified: November 22, 2024
 * Description: Read people.dat and print to a copy file as well as the console
 */
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Lab11Prob01 { 
	public static void main(String args[]) {
		try (
			DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
			DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));
			) {
			while(true) {
				int age = input.readInt();
				output.writeInt(age);
				String name = input.readUTF();
				output.writeUTF(name);
		        String Address = input.readUTF();
				output.writeUTF(Address);
				int zipCode = input.readInt();
				output.writeInt(zipCode);
				double salary = input.readDouble();
				output.writeDouble(salary);
				System.out.printf("%d %s %s %d %.2f%n", age, name, Address, zipCode, salary);
			}
		} catch (EOFException e) {
			System.out.print("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
