import java.util.Scanner;

class User {
    String firstName, lastName, age, email, username, password;
//defining the User object a bit
    public User(String firstName, String lastName, String age, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.username = username;
        this.password = password;
    }
//override the toString() method a bit, so it'll print out our User object at the end.
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
    //this int counts the amount of times the user has not confirmed their password.
    //idk, it's a nice metric to collect. punishing the user is fun :)
    static int errorCount;

    //the password confirmation process gets its own method, so we can loop it if we need to.

    static String verifyPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a unique password: ");
        String password = scanner.nextLine();

        System.out.print("Confirm your password: ");
        String confirmedPassword = scanner.nextLine();

        if (confirmedPassword.equals(password)) {
            //alright, everything checks out! you can say something to the user here if you want.
            return password;
        } else {
            //nope, the user failed to confirm their password.
            String errorMessage = "\nHm, no match. Please reconfirm your password.";
            //add one to the error count
            errorCount++;
            System.out.println(errorMessage);
            //loop it, bruh
            return verifyPassword();
        }
    }

    public static void main(String[] args) {

        //start the scanner
        Scanner scanner = new Scanner(System.in);

        //first name
        System.out.print("Enter your first name. ");
        String firstName = scanner.nextLine();

        //last name
        System.out.print("Enter your last name. ");
        String lastName = scanner.nextLine();

        //age
        System.out.print("Enter your age. ");
        //initialize the user age value
        int age = 0;

        while (true) {
            try {
                //if the user enters a numerical value, record it and move on.
                String input = scanner.nextLine();
                age = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                //if the user doesn't enter a number, give them a slap on the wrist.
                System.out.println("That's not a numerical value. Please verify your age.");
            }
        }

        //so now that we have the user's age, let's make sure they're 21.

        if (age < 21) {
            //oh no, they're not 21? how long will it be until then?
            int yearsLeft = 21 - age;
            System.out.println("Users must be 21 or older to continue, please return in " + yearsLeft + " years.");
            return;
            //quits the User object creation process entirely.
        }

        //if the age stuff checks out, ask the user for the email address.
        System.out.print("Enter your email address. ");
        String email = scanner.nextLine();

        //make them pick a username
        System.out.print("Enter a unique username. ");
        String username = scanner.nextLine();

        //outsource the whole password setup/confirmation to the method we defined earlier.
        String password = verifyPassword();

        //set up the User object based on all the previous input.
        User user = new User(firstName, lastName, String.valueOf(age), email, username, password);

        //ayo we did it! tell the user and then print the User object to the console.
        //You don't actually have to do this, you could at this point pass this object along to another method or something.
        //This is just an account object creation demo, after all.
        System.out.println("\nAccount created successfully! Here's the returned user object.");
        System.out.println(user.toString());

        }
        }