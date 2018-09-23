package Data.Contestant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * This class can read in a list of names and subsequently generate random names.
 */

public class NameGenerator {
    private String maleNamesText = "D:\\Users\\TNEEFJES\\Documents\\Software Engineering Track\\maleNames.txt";
    private String femaleNamesText = "D:\\Users\\TNEEFJES\\Documents\\Software Engineering Track\\femaleNames.txt";
    private List<String> maleNamesList;
    private List<String> femaleNamesList;

    public NameGenerator() {
        maleNamesList = textToList(maleNamesText);
        femaleNamesList = textToList(femaleNamesText);
    }

    private List<String> textToList(String inputFile) {
        List<String> returnList = new ArrayList<>();
        BufferedReader reader = null;
        {
            try {
                reader = new BufferedReader(new FileReader(inputFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        boolean endOfFile = false;
        String line = null;
        String name;
        do {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line != null) {
                name = line.substring(0, line.indexOf(' '));
                returnList.add(name);
            } else {
                endOfFile = true;
            }
        } while (!endOfFile);
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnList;
    }

    String GenerateName(Gender gender) {
        return (gender == Gender.MALE) ? maleNamesList.get((int)(Math.random()*maleNamesList.size())) :
                femaleNamesList.get((int)(Math.random()*femaleNamesList.size()));
    }
}
