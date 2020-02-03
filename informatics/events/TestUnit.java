package fmi.informatics.events;


public abstract class TestUnit extends Conversation {
    public static void main(String[] args) {
        String expectedResult = "Здравейте слуга мои !";
        Conversation ServantsAnswering = new Conversation();
        String result = ServantsAnswering.ChooseHuman();

        getServantsAnswering(expectedResult,result);
    }

    public static void getServantsAnswering(String expectedResult, String result){
        if (stringComparison(expectedResult, result)) {
            System.out.println("Method ChooseHuman() from class Conversation returns what is expected");
        } else {
            System.err.println(
                    "Method ChooseHuman() from class Conversation returns: " +
                            result + ", but the expected result is: " +
                            expectedResult
            );
        }

    }

    public static boolean stringComparison(String expectedResult, String result) {
        return result.equals(expectedResult);
    }


}
