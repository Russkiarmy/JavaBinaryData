import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Lab11Prob02 { 
	public static void main(String args[]) {
		ArrayList<Person> personArrayList = new ArrayList<Person>();
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
				//System.out.printf("%d %s %s %d %.2f%n", age, name, Address, zipCode, salary);
				personArrayList.add(new Person(age, name, Address, zipCode, salary));
			}
		} catch (EOFException e) {
			System.out.print("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (DataOutputStream outdata = new DataOutputStream(new FileOutputStream("src/people-salary-sorted.dat"));
				){
			java.util.Collections.sort(personArrayList);
			for (int i = 0; i < personArrayList.size(); i++) {
				outdata.writeString(personArrayList.get(i).toString());
				System.out.println(personArrayList.get(i).toString());
			}
		} catch (EOFException e) {
			System.out.print("");
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
}
class Person implements Comparable<Person> {
	
	private int age;
	private String name;
	private String address;
	private int zipCode;
	private double salary;
	
	//default constructor
	public Person() {
		setAge(20);
		setName("John Doe");
		setAddress("123 Main St");
		setZipCode(12345);
		setSalary(63000.3);
	}
	//convenience constructor
	public Person(int age, String name, String address, int zipCode, double salary) {
		setAge(age);
		setName(name);
		setAddress(address);
		setZipCode(zipCode);
		setSalary(salary);
		
	}

	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
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
		return address;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public double getSalary() {
		return salary;
	}

		
	public String toString() {
		return String.format("%d %s %s %d %.2f", age, name, address, zipCode, salary);
		
	}
	
	@Override
	public int compareTo(Person o) {
		if (this.salary == o.salary) {
			return 0;
		} else {
			if(this.salary > o.salary) {
			return -1;
		} else {
			return 1;
			}
		}
	}
}
