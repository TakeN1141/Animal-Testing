package fmi.informatics.extending;

import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class Professor extends Person {

	private String title;


	public Professor(String name, int egn, int iq, String relationships, int age, char gender, int height, int weight) {
		setName(name);
		setTitle(title);
		setEgn(egn);
		setIQ(iq);
		setRelationship(relationships);
		setAge(age);
		setGender(gender);
		setHeight(height);
		setWeight(weight);
	}


	@Override
	public String toString() {
		return String.format("The professor %s is with title %s", 
							 this.getName(), this.getTitle());
	}

	// Имплементация на абстрактен метод
	@Override
	protected String getTypicalDrink() {
		return "50 years Black Johny";
	}

	// Пренаписване на метод от супер клас
	@Override
	public void goBar() {
		super.goBar();
		System.out.println("After second drink the Professor is happy");
	}

	// Имплементация на методите от двата интерфейса (без getShower(), който е
	// имплементиран в абстрактният клас. Ако е необходимо getShower() може да се пренапише)
	@Override
	public void getUpEarly(Calendar hour) {
		System.out.println("The professor usually gets up at" + hour);
	}

	@Override
	public void run(int minutes) {
		// TODO Auto-generated method stub
	}

	@Override
	public void study() {
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
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	// Създаваме клас ProfessorGenerator
	public static class ProfessorGenerator {

		private static String[] Males = {"Iliqn", "Sevdalin", "Nikolai", "Stoyan", "Kaloqn", "Dimo"};
		private static String[] families = {"Dimitrov", "Nikolaev", "Karolev", "Karastoqnov", "Georgiev", "Lesov"};
		private static String[] Females = {"Ivilqna", "Elena", "Melisa", "Lora", "Nikol", "Verjaneta"};
		private static String[] titles = {"Professor", "PhD", "Asociate assisstant"};
		private static Character[] genders = {'m', 'f'};
		private static String [] relationship = {"Alone","4EverAlone","Complicated","Girlfriend","Boyfriend"};
		
		public static Professor make() {
			int arrayIndexMalesRandom = ThreadLocalRandom.current().nextInt(0, Males.length);
			String male = Males[arrayIndexMalesRandom];

			int arrayIndexFemalesRandom = ThreadLocalRandom.current().nextInt(0, Females.length);
			String female = Females[arrayIndexFemalesRandom];

			int arrayIndexFam = ThreadLocalRandom.current().nextInt(0, families.length);
			String Lname = families[arrayIndexFam];

			int arrayIndexRel = ThreadLocalRandom.current().nextInt(0, relationship.length);
			String relationships = relationship[arrayIndexRel];

			int arrayIndexTitles = ThreadLocalRandom.current().nextInt(0, titles.length);
			String title = titles[arrayIndexTitles];

			int arrayIndexGender = ThreadLocalRandom.current().nextInt(0, genders.length);
			char gender = genders[arrayIndexGender];

			int egn = ThreadLocalRandom.current().nextInt(111111, 999999);
			int IQ = ThreadLocalRandom.current().nextInt(50, 150);

			int age = ThreadLocalRandom.current().nextInt(18, 80);

			int height =  ThreadLocalRandom.current().nextInt(150, 220);
			
			int weight = ThreadLocalRandom.current().nextInt(50, 220);
			String Name;
			String FemFamily;
			if (gender == 'm'){
				Name = (male + " " + Lname);
				return new Professor(Name, egn, IQ, relationships, age, gender, height, weight);
			}else{
				FemFamily = (Lname + "a");
				Name = (female + " " + FemFamily);
				return new Professor(Name ,egn, IQ, relationships, age, gender, height, weight);
			}
		}
	}
}
