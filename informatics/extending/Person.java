package fmi.informatics.extending;

import fmi.informatics.interfaces.Active;
import fmi.informatics.interfaces.Adaptable;

// Променяме класа Person да бъде абстрактен. 
// Добавяме метод goBar() и абстрактният метод getTypicalDrink()
// Имплементираме интерфейсите Active, Adapdable и имплементираме абстрактните им методи.
public abstract class Person implements Active, Adaptable {
	
	private static String planet = "Earth";
	private static int variable = 0;
	private static String Vegetables = "Cucumbers";

	public static int getVariable() {
		return variable;
	}
	public static String getVegetables(){return Vegetables;}
	public static String getPlanet() {
		return planet;
	}

	private String name;
	private int egn;
	private char gender;
	private int facNumber;
	private int age;
	private int IQ;
	private String relationship;
	private int height;
	private int weight;

	public Person() {

	}

	public Person(String name, int egn) {
		this.name = name;
		this.egn = egn;
	}


	public Person(String name, boolean isMale, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	// създаваме допълнителен конструктор
	public Person(String name, int egn, int age, int height, int weight) {
		this.name = name;
		this.egn = egn;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public void walk() {
		variable++;
		System.out.println("The person is walking");
	}

	public void run() {
		variable--;
		System.out.println("The person is running");
	}

	public void move(int kmPerHour) {
		if (kmPerHour <= 5) {
			walk();
		} else {
			run();
		}
	}

	// Дефиниране на абстрактен метод -> тук няма имплементация, но класовете
	// наследници, които не са абстрактни класове са задължени да го имплементират
	protected abstract String getTypicalDrink();
	
	public void goBar() {
		System.out.println("The " + this.getClass().getSimpleName() + 
				" " + getName() + " drinking ");
		System.out.println(getTypicalDrink());
	}
	
	@Override
	public void getShower() {
		System.out.println("The person is getting shower");
	}
	
	// Getters and setters
	public String getName() {
		if (this.name == null) {
			this.name = "Default";
		}
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getEgn() {
		return egn;
	}

	public void setEgn(int egn) {
		this.egn = egn;
	}

	public void setFac(int facNumber){
		this.facNumber = facNumber;
	}

	public int getFac() {
		return facNumber;
	}

	public void setRelationship(String relationship){
		this.relationship = relationship;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setIQ(int iq){
		this.IQ = iq;
	}

	public int getIQ() {
		return IQ;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}