import java.util.Scanner;

public class PrintDay {

    /**
     * Checks if month is valid and returns true or false
     * @param month
     * @return true/false
     */
    public static boolean isValidMonth(int month) {
        return (month >= 1 && month <= 12);
    }

    /**
     * checks if day is valid and returns true or false
     * @param day
     * @param month
     */
    public static boolean isValidDay(int day, int month) {
        boolean isValid = false;
        switch (month) {
            case 1: isValid = (day >= 1 && day <= 31); break; // jan 31
            case 2: isValid = (day >= 1 && day <= 29); break; // feb 29
            case 3: isValid = (day >= 1 && day <= 31); break; // mar 31
            case 4: isValid = (day >= 1 && day <= 30); break; // apr 30
            case 5: isValid = (day >= 1 && day <= 31); break; // may 31
            case 6: isValid = (day >= 1 && day <= 30); break; // jun 30
            case 7: isValid = (day >= 1 && day <= 31); break; // jul 31
            case 8: isValid = (day >= 1 && day <= 31); break; // aug 31
            case 9: isValid = (day >= 1 && day <= 30); break; // sep 30
            case 10: isValid = (day >= 1 && day <= 31); break; // oct 31
            case 11: isValid = (day >= 1 && day <= 30); break; // nov 30
            case 12: isValid = (day >= 1 && day <= 31); break; // dec 31
        }

        return isValid;
    }

    /**
     * Takes in day and month of the year 2024 and returns day of the week with 1st Jan, 2024, Monday as reference
     * @param day
     * @param month
     * @return
     */
    public static String dayOfTheWeek(int day, int month) {
        String dotw = "";
        int dateDiff = day - 1; // difference in date from January 1st

        // adding the month days in cascading order
        switch (month) {
            case 12: dateDiff += 30; // adding nov
            case 11: dateDiff += 31; // adding oct
            case 10: dateDiff += 30; // adding sep
            case 9: dateDiff += 31; // adding aug
            case 8: dateDiff += 31; // adding jul
            case 7: dateDiff += 30; // adding jun
            case 6: dateDiff += 31; // adding may
            case 5: dateDiff += 30; // adding apr
            case 4: dateDiff += 31; // adding mar
            case 3: dateDiff += 29; // adding feb
            case 2: dateDiff += 31; // adding jan
            case 1: break;
        }

        // using switch to select day of the week

        switch ((dateDiff % 7)) {
            case 0: dotw = "Monday"; break;
            case 1: dotw = "Tuesday"; break;
            case 2: dotw = "Wednesday"; break;
            case 3: dotw = "Thursday"; break;
            case 4: dotw = "Friday"; break;
            case 5: dotw = "Saturday"; break;
            case 6: dotw = "Sunday"; break;
        }

        return dotw;
    }

    /**
     * Main driver code
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Day and Month: ");
        int day = sc.nextInt(), month = sc.nextInt(); // main input
        sc.nextLine(); // reading till line end

        // checking input validity
        if (!(isValidMonth(month) && isValidDay(day, month))) {
            System.out.println("You entered an invalid date.....Exiting");
        } else {
            System.out.printf("%d/%d/2024 is %s\n", day, month, dayOfTheWeek(day, month));
        }

        sc.close();
    }
}