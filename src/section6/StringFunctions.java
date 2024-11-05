package section6;

import java.util.regex.Pattern;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringFunctions {


    public static boolean isValidEmail(String email) {

        String regex = "[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                       "[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,7})";
        

        if (email == null) {
            System.out.println("Error: Email is null.");
            return false;
        }

        if (email.trim().isEmpty()) {
            System.out.println("Error: Email is empty.");
            return false;
        }

        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter email addresses to check for validity:");

        while (true) {
            System.out.print("Enter email (or type 'exit' to quit): ");
            String email = scanner.nextLine();

            if (email.equalsIgnoreCase("exit")) {
                break;
            }

            if (isValidEmail(email)) {
                System.out.println("The email '" + email + "' is valid.");
            } else {
                System.out.println("The email '" + email + "' is invalid.");
            }
        }

        scanner.close();
    }
}


