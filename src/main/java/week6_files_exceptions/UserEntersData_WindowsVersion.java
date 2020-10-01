package week6_files_exceptions;

import java.util.List;

import static input.InputUtils.intInput;
import static input.InputUtils.stringInput;

/**
 * Validation with a while loop
 */
public class UserEntersData_WindowsVersion {

    public static void main(String[] args) {

        // Example: enter your version of Windows. Only "XP", "7", "8" and "10" are acceptable.

        List<String> windowsVersions = List.of("XP", "7", "8", "10");
        String windowsVersionsString = String.join(", ", windowsVersions);   // "XP, 7, 8, 10"

        String version = stringInput("Enter your version of Windows from these choices: " + windowsVersionsString).toUpperCase();

        while (!windowsVersions.contains(version)) {
            version = stringInput("Not a recognized version. " +
                    "Enter your version of Windows from these choices: " + windowsVersionsString).toUpperCase();
        }

        System.out.println("Thanks, your Windows version is " + version);
    }
}


