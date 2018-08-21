import java.util.Random;
import java.util.Scanner;

public class pwdGenerator {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        Random random = new Random();
        String alphabetLower = "abcdefghijklmnopqrstuvxyw";
        char[] lowerABC = alphabetLower.toCharArray();
        char[] upperABC = alphabetLower.toUpperCase().toCharArray();
        String specialCharacters = "@%+/'!#$^?:,(){}[]~-_.&*+;<>=|`";
        char[] specialChars = specialCharacters.toCharArray();
        Boolean upperRequired = false;
        Boolean numberRequired = false;
        Boolean specialRequired = false;


        System.out.println("How long is the required password?");
        Integer pwdLength = userInput.nextInt();

        System.out.println("Does the password require Uppercase characters?");
        String upperCaseYN = userInput.next();
        if ((upperCaseYN.equals("yes")) || (upperCaseYN.equals("Yes")) || (upperCaseYN.equals("y")) || (upperCaseYN.equals("Y"))) {
            upperRequired = true;
        }

        System.out.println("Does the password require Numerical characters?");
        String numberYN = userInput.next();
        if ((numberYN.equals("yes")) || (numberYN.equals("Yes")) || (numberYN.equals("y")) || (numberYN.equals("Y"))) {
            numberRequired = true;
        }

        System.out.println("Does the password require Special characters?");
        String specialYN = userInput.next();
        if ((specialYN.equals("yes")) || (specialYN.equals("Yes")) || (specialYN.equals("y")) || (specialYN.equals("Y"))) {
            specialRequired = true;
        }
        boolean acceptablePwd = false;
        String password = "A";
        while (!acceptablePwd) {
            boolean containsLower = false;
            boolean containsUpper = false;
            boolean containsNumber = false;
            boolean containsSpecial = false;
            for (int i = 0; i < pwdLength; i++) {

                boolean acceptableChoice = false;
                int choiceNo;
                Integer pwdOptions = 1;
                while (!acceptableChoice) {
                    pwdOptions = random.nextInt(4);
                    if ((upperRequired == false) && (pwdOptions == 1)) {
                        acceptableChoice = false;
                    } else if ((numberRequired == false) && (pwdOptions == 2)) {
                        acceptableChoice = false;
                    } else if ((specialRequired == false) && (pwdOptions == 3)) {
                        acceptableChoice = false;
                    } else {
                        acceptableChoice = true;
                    }
                }
                switch (pwdOptions) {
                    case 0:
                        choiceNo = random.nextInt(25);
                        char passwordChoice = lowerABC[choiceNo];
                        if (i == 0) {
                            password = Character.toString(passwordChoice);
                        } else {
                            password = password + Character.toString(passwordChoice);
                        }
                        containsLower = true;

                        break;
                    case 1:
                        choiceNo = random.nextInt(25);
                        passwordChoice = upperABC[choiceNo];
                        if (i == 0) {
                            password = Character.toString(passwordChoice);
                        } else {
                            password = password + Character.toString(passwordChoice);
                        }
                        containsUpper = true;

                        break;

                    case 2:
                        choiceNo = random.nextInt(10);
                        if (i == 0) {
                            password = Integer.toString(choiceNo);
                        } else {
                            password = password + Integer.toString(choiceNo);
                        }
                        containsNumber = true;
                        break;

                    case 3:
                        choiceNo = random.nextInt(31);
                        passwordChoice = specialChars[choiceNo];
                        if (i == 0) {
                            password = Character.toString(passwordChoice);
                        } else {
                            password = password + Character.toString(passwordChoice);
                        }
                        containsSpecial = true;
                        break;

                    default:
                        System.out.print(pwdOptions + " is not defined in the pwdGenerator class, main method.");

                }

            }

            if ((!containsLower) || ((upperRequired) && (!containsUpper)) || ((numberRequired) && (!containsNumber)) || ((specialRequired) && (!containsSpecial))) {
                acceptablePwd = false;
            } else {
                acceptablePwd = true;
            }
        }

        System.out.print(password);

    }
}