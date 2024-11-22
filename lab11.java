import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.Scanner;

public class lab11 {
	try (
		DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
		DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));
			) {
			while(true) {
				int age = input.readInt();
				output.writeInt(age);
				System.out.println(age);
				String name = input.readUTF();
				output.writeUTF(name);
				System.out.println(name);
				String Address = input.readUTF();
				output.writeUTF(Address);
				System.out.println(Address);
				int zipCode = input.readInt();
				output.writeInt(zipCode);
				System.out.println(zipCode);
				double salary = input.readDouble();
				output.writeDouble(salary);
				System.out.println(salary);
			}
		} catch (EOFException e) {
			System.out.println("End of File exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
}
