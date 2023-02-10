import java.util.Scanner;

class User {
    String firstName, lastName, age, email, username, password;

    public User(String firstName, String lastName, String age, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "\nfirstName: " + firstName +
                "\nlastName: " + lastName +
                "\nage: " + age +
                "\nemail: " + email +
                "\nusername: " + username +
                "\npassword: " + password +
                "\n\nUser(" + firstName + ", " + lastName + ", " + age + ", " + email + ", " + username + ", " + password + ")";
    }
}

public class Main {
    static int errorCount;

    static String verifyPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a unique password: ");
        String password = scanner.nextLine();

        System.out.print("Confirm your password: ");
        String confirmedPassword = scanner.nextLine();

        if (confirmedPassword.equals(password)) {
            return password;
        } else {
            String errorMessage;
            errorMessage = "\nHm, no match. Please reconfirm your password.";
            errorCount++;
            System.out.println(errorMessage);
            return verifyPassword();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name. ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name. ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your age. ");
        int age = 0;

        while (true) {
            try {
                String input = scanner.nextLine();
                age = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("That's not a numerical value. Please verify your age.");
            }
        }

        if (age < 21) {
            int yearsLeft = 21 - age;
            System.out.println("Users must be 21 or older to continue, please return in " + yearsLeft + " years.");
            return;
        }

        System.out.print("Enter your email address. ");
        String email = scanner.nextLine();

        System.out.print("Enter a unique username. ");
        String username = scanner.nextLine();

        String password = verifyPassword();

        User user = new User(firstName, lastName, String.valueOf(age), email, username, password);
        System.out.println("\nAccount created successfully! Here's the returned user object.");
        System.out.println(user.toString());
        }
        }