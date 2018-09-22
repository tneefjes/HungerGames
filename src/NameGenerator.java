import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/*
 * This class can read in a list of names and subsequently generate random names.
 */

public class NameGenerator {
    private String maleNamesText = "D:\\Users\\TNEEFJES\\Documents\\Software Engineering Track\\maleNames.txt";
    private String femaleNamesText = "D:\\Users\\TNEEFJES\\Documents\\Software Engineering Track\\femaleNames.txt";
    private List<String> maleNamesList = new ArrayList<String>();
    private List<String> femaleNamesList = new ArrayList<String>();

    public NameGenerator() {
        maleNamesList = textToList(maleNamesText);
        femaleNamesList = textToList(femaleNamesText);
    }

    private List<String> textToList(String inputFile) {
        List<String> returnList = new ArrayList<String>();
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
        do {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line != null) {
                String name = line.substring(0,line.indexOf(' '));
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

    public String GenerateName(Gender gender) {
        String name = null;
        if (gender == gender.MALE) {
            name = maleNamesList.get((int)(Math.random()*maleNamesList.size()));
        } else {
            name = femaleNamesList.get((int)(Math.random()*femaleNamesList.size()));
        }
        return name;
    }
}
