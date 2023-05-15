import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<String> getSocialSecurityNumbersFromFile(String filename) {
        ArrayList<String> securityNumbers = new ArrayList<>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                securityNumbers.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return securityNumbers;
    }

    public static <localDateTime> void main(String[] args) {
        ArrayList<String> socialSecurityNumbers = getSocialSecurityNumbersFromFile("CNP.txt");


        for (int i = 0; i < socialSecurityNumbers.size(); i++) {
            String cnp = socialSecurityNumbers.get(i);
            //System.out.println(cnp.charAt(0));
            // In Romania, the first character of the social security number
            // represents the biological sex of a person.
            // Below, we take from the social security number the first character
            // and check whether they are male or female.
            char gender = ' ';
            switch (cnp.charAt(0)) {
                case '1', '3', '5', '7' -> gender = 'M';
                case '2', '4', '6', '8' -> gender = 'F';
            }
            //To find the exact age of the social number owner we take the second and 3-th
            //caracter and whe add the prefix to render the entire year of birth not just the last two numbers.
            String prefix = "";
            switch (cnp.charAt(0)) {
                case '1', '2' -> prefix = "19";
                case '3', '4' -> prefix = "18";
                case '5', '6' -> prefix = "20";
            }
            int year = Integer.parseInt(prefix + cnp.substring(1, 3));
            int month = Integer.parseInt(cnp.substring(3, 5));
            int day = Integer.parseInt(cnp.substring(5, 7));
            String birthDate = year + "-" + month + "-" + day;


            // Here we take the current date and time and whe calculate exact age of the social security number owner
            LocalDateTime now = LocalDateTime.now();
            int currentYear = now.getYear();
            int currentMonth = now.getMonthValue();
            int currentDay = now.getDayOfMonth();
            int age = currentYear - year;

            if (month > currentMonth) {
                --age;
            } else if (month == currentMonth) {
                if (day > currentDay) {
                    --age;
                }
            }


            //The 7-th and the 8-th caracter from social secutrity number
            // represent the county of birth.
            int county = Integer.parseInt(cnp.substring(7, 9));
            String stringCounty = "";
            switch (county) {
                case 1 -> stringCounty = "Alba";
                case 2 -> stringCounty = "Arad";
                case 3 -> stringCounty = "Arges";
                case 4 -> stringCounty = "Bacau";
                case 5 -> stringCounty = "Bihor";
                case 6 -> stringCounty = "Bistrita";
                case 7 -> stringCounty = "Botosani";
                case 8 -> stringCounty = "Brasov";
                case 9 -> stringCounty = "Braila";
                case 10 -> stringCounty = "Buzau";
                case 11 -> stringCounty = "Caras Severin";
                case 12 -> stringCounty = "Cluj";
                case 13 -> stringCounty = "Constanta";
                case 14 -> stringCounty = "Covasna";
                case 15 -> stringCounty = "Dambovita";
                case 16 -> stringCounty = "Dolj";
                case 17 -> stringCounty = "Galati";
                case 18 -> stringCounty = "Gorj";
                case 19 -> stringCounty = "Harghita";
                case 20 -> stringCounty = "Hunedoara";
                case 21 -> stringCounty = "Ialomita";
                case 22 -> stringCounty = "Iasi";
                case 23 -> stringCounty = "Ilfov";
                case 24 -> stringCounty = "Maramures";
                case 25 -> stringCounty = "Mehedinti";
                case 26 -> stringCounty = "Mures";
                case 27 -> stringCounty = "Neamt";
                case 28 -> stringCounty = "Olt";
                case 29 -> stringCounty = "Prahova";
                case 30 -> stringCounty = "Satu Mare";
                case 31 -> stringCounty = "Salaj";
                case 32 -> stringCounty = "Sibiu";
                case 33 -> stringCounty = "Suceava";
                case 34 -> stringCounty = "Teleorman";
                case 35 -> stringCounty = "Timis";
                case 36 -> stringCounty = "Tulcea";
                case 37 -> stringCounty = "Vaslui";
                case 38 -> stringCounty = "Valcea";
                case 39 -> stringCounty = "Vrancea";
                case 40 -> stringCounty = "Bucuresti";
                case 41 -> stringCounty = "Bucuresti sector 1";
                case 42 -> stringCounty = "Bucuresti sector 2";
                case 43 -> stringCounty = "Bucuresti sector 3";
                case 44 -> stringCounty = "Bucuresti sector 4";
                case 45 -> stringCounty = "Bucuresti sector 5";
                case 46 -> stringCounty = "Bucuresti sector 6";
                case 51 -> stringCounty = "Calarasi";
                case 52 -> stringCounty = "Giurgiu";
            }

            System.out.println("Your CNP is: " + cnp);
            System.out.println("Gender: " + gender);
            System.out.println("Birt date: " + birthDate);
            System.out.println("Age: " + age);
            System.out.println("County: " + stringCounty);

        }
    }
}