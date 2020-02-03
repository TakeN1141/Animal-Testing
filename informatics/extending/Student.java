package fmi.informatics.extending;

import java.util.Calendar;

import java.util.concurrent.ThreadLocalRandom;

// Дефиниране на клас Student, който разширява абстрактния клас Person.
// Като наследник притежава всички характеристики и методи на класа родител
public class Student extends Person {

	private String university;
	private String speciality;
	private int facNumber;



	public Student(String name, int egn, int iq, String relationships, String university, String speciality, int facNumber, int age, char gender, int height, int weight) {
		setName(name);
		setEgn(egn);
		setUniversity(university);
		setSpeciality(speciality);
		setFac(facNumber);
		setIQ(iq);
		setRelationship(relationships);
		setAge(age);
		setGender(gender);
		setHeight(height);
		setWeight(weight);

	}


	/*
	 * Пренаписване на метод от клас родител. В runtime всички обекти от тип Student ще
	 * извикват само пренаписаният метод, дори и да са дефинирани като обекти от базовият тип
	 */
	@Override
	public void run() {
		System.out.println("The student is running");
	}
	
	@Override
	public String toString() {
		return String.format("The student %s is learning in %s speciality", 
							 this.getName(), this.getSpeciality());
	}

	public void study() {
		System.out.println("The student is studying");
	}

	public void takeExam() {
		System.out.println("The student passed the exam");
	}

	public void goBar(String drink) {
		System.out.println("The student " + getName() +  " drinking " + drink);
	}
	
	// Имплементация на абстрактен метод от супер клас
	@Override
	protected String getTypicalDrink() {
		return "Vodka";
	}
	
	// Имплементация на методите от двата интерфейса (без getShower(), който е
	// имплементиран в абстрактният клас. Ако е необходимо getShower() може да се пренапишe)
	@SuppressWarnings("static-access")
	@Override
	public void getUpEarly(Calendar hour) {
		System.out.println("The student usually gets up at " + hour.HOUR);
	}

	@Override
	public void run(int minutes) {
		// TODO Auto-generated method stub
	}

	@Override
	public void think() {
		// TODO Auto-generated method stub
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
	}
	
	// Getters and setters
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getFacNumber() {
		return facNumber;
	}

	public void setFacNumber(int facNumber) {
		this.facNumber = facNumber;
	}
	
	// Пример за статичен вложен клас
	// Добавяме в класа Student помощен клас за произволно създаване на студенти - StudentGenerator
	public static class StudentGenerator {
		private static String[] Males = {"Iliqn", "Sevdalin", "Nikolai", "Stoyan", "Kaloqn", "Dimo"};
		private static String[] families = {"Dimitrov", "Nikolaev", "Karolev", "Karastoqnov", "Georgiev", "Lesov"};
		private static String[] Females = {"Ivilqna", "Elena", "Melisa", "Lora", "Nikol", "Verjaneta"};

		private static String[] specialities = {"Informatics", "BIT", "STD", "Mathematics","Business Mathematics"};
		private static String[] universities = {"SU","NBU","PU", "UHT","VUSI"};
		private static Character[] genders = {'m', 'f'};
		private static String [] relationship = {"Alone","4EverAlone","Complicated","Girlfriend","Boyfriend"};


		public static Student make() {
			int arrayIndexMalesRandom = ThreadLocalRandom.current().nextInt(0, Males.length);
			String male = Males[arrayIndexMalesRandom];

			int arrayIndexFemalesRandom = ThreadLocalRandom.current().nextInt(0, Females.length);
			String female = Females[arrayIndexFemalesRandom];

			int arrayIndexFam = ThreadLocalRandom.current().nextInt(0, families.length);
			String Lname = families[arrayIndexFam];

			int arrayIndexSpec = ThreadLocalRandom.current().nextInt(0, specialities.length);
			String speciality = specialities[arrayIndexSpec];

			int arrayIndexUni = ThreadLocalRandom.current().nextInt(0, universities.length);
			String university = universities[arrayIndexUni];

			int arrayIndexRel = ThreadLocalRandom.current().nextInt(0, relationship.length);
			String relationships = relationship[arrayIndexRel];

			int arrayIndexGender = ThreadLocalRandom.current().nextInt(0, genders.length);
			char gender = genders[arrayIndexGender];

			int facNumber = ThreadLocalRandom.current().nextInt(111111, 999999);
			
			int egn = ThreadLocalRandom.current().nextInt(111111, 999999);

			int IQ = ThreadLocalRandom.current().nextInt(50, 150);

			// добавяме генериране на години, височина и тегло
			int age = ThreadLocalRandom.current().nextInt(18, 30);
			
			int height =  ThreadLocalRandom.current().nextInt(150, 220);
			
			int weight = ThreadLocalRandom.current().nextInt(50, 220);
			String Name;
			String FemFamily;
			if (gender == 'm'){
				Name = (male + " " + Lname);
				return new Student(Name, egn, IQ, relationships, university, speciality, facNumber, age, gender, height, weight);
			}else{
				FemFamily = (Lname + "a");
				Name = (female + " " + FemFamily);
				return new Student(Name,egn, IQ, relationships, university, speciality, facNumber, age, gender, height, weight);
			}

		}
	}
}