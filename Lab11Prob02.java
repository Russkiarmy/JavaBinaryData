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

public class Person<E> implements Comparable<E> {

	int age;
	String name;
	String Address;
	int zipCode;
	double salary;
	
	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String Address) {
		this.Address = Address;
	}
	
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public double getSalary() {
		return salary;
	}

}
