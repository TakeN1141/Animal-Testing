package fmi.informatics.events;

import java.util.concurrent.ThreadLocalRandom;

public class Conversation implements Greetings {
    private static String[] kings = {"Аспарух", "Тервел", "Кубрат"};
    private static String[] servants = {"Николай", "Митко", "Карамфил", "Динчо", "Карапетко", "Свирчо"};
    private String SayHi = "Здравейте слуга мои !";

    @Override
    public void SayGreetings(String king) {

        System.out.println("Хан " + king + " казва: " + SayHi + "\n");
        StringBuilder phrase = new StringBuilder();

        for (int i = 0; i < servants.length; i++) {
            phrase.append(servants[i]);
            phrase.append(" казва: Здравейте Господарю! \n");
        }
        System.out.println(phrase);
    }

    @Override
    public String ChooseHuman() {
        int kingIndex = ThreadLocalRandom.current().nextInt(0, kings.length);
        String king = kings[kingIndex];
        SayGreetings(king);
        return "Здравейте слуга мои !";
    }

}
