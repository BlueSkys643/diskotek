 import java.util.Scanner;

class User {
    public String user_first_name;
    public String user_last_name;
    public String user_age;
    public String user_email_address;
    public String user_username;
    public String user_password;


    public User(String user_first_name,String user_last_name, String user_age, String user_email_address,String user_username, String user_password) {
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_age = user_age;
        this.user_email_address = user_email_address;
        this.user_username = user_username;
        this.user_password = user_password;

    }

    @Override
    public String toString() {
        return  "\n" +
                "FIRST NAME: " + user_first_name +
                "\n" +
                "LAST NAME: " + user_last_name +
                "\n" +
                "AGE: " + user_age +
                "\n" +
                "EMAIL: " + user_email_address +
                "\n" +
                "USERNAME: " + user_username +
                "\n" +
                "PASSWORD: " + user_password +
                "\n" +
                "User("+user_first_name+", "+user_last_name+", "+user_age+", "+user_email_address+", "+user_username+", "+user_password+")";


    }
}

public class Main {
    public static int signup_error_count;
    public static String user_password;

    public static String verify_matching_passwords() {
        System.out.print("Enter a unique password: ");
        Scanner scanner = new Scanner(System.in);
        String user_password = scanner.nextLine();

        System.out.print("Confirm your password: ");
        String user_password_confirmed = scanner.nextLine();

        if (user_password_confirmed.equals(user_password)) {
            System.out.println("\nYou did it. You actually did it. Bloody wonderful.");
            return user_password;
        } else {
            if (signup_error_count == 0) {
                System.out.println("\nHey you gotta confirm the password, okay? Try again.");
            } else if (signup_error_count == 1) {
                System.out.println("Bruh it's literally so damn easy, just retype the password.");
            } else {
                System.out.println("WHAT DID I JUST SAY, JUST RETYPE THE FUCKING PASSWORD, IT'S SO EASY");
            }

            signup_error_count++;
            return verify_matching_passwords();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean password_correct = false;

        System.out.print("Enter your first name. ");
        String user_first_name = scanner.nextLine();

        System.out.print("Enter your last name. ");
        String user_last_name = scanner.nextLine();

        System.out.print("Enter your age. ");
        String user_age = scanner.nextLine();

        System.out.print("Enter your email address. ");
        String user_email_address = scanner.nextLine();

        System.out.print("Enter a username: ");
        String user_username = scanner.nextLine();

        while (!password_correct) {
            user_password = verify_matching_passwords();
            password_correct = true;
        }

        User user = new User(user_first_name, user_last_name, user_age, user_email_address, user_username, user_password);
        System.out.println(user);
    }
}
