package fmi.informatics.extending;

public abstract class UnitTestStudents extends Person {
    public static void VeganTest(String expectedResult, String result){
        if (ComparisonTest(expectedResult, result)) {
            System.out.println("getVegetables() from class Person returns what is expected");
        } else {
            System.err.println("getVegetables() from class Person returns: " + result + ", but the expected result is: " + expectedResult);
        }

    }

    public static void main(String[] args) {
        String expectedResult = "Cucumbers";
        String result = getVegetables();

        VeganTest(expectedResult,result);
    }


    public static boolean ComparisonTest(String expectedResult, String result) {
        return result.equals(expectedResult);
    }


}


