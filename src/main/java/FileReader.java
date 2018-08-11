import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static Collection <String[]> getTestData(String filename)
            throws IndexOutOfBoundsException, IOException {
        List<String[]> credentials = new ArrayList<String[]>();
        BufferedReader file = new BufferedReader(new java.io.FileReader(filename));
        String pair = file.readLine();
        while (pair != null) {
            String namePassword[] = pair.split(";");
            credentials.add(namePassword);
        }
        file.close();
        return credentials;

    }


    public static String getTestDataGame(String filename)
            throws IndexOutOfBoundsException, IOException {
        Scanner file = new Scanner (new BufferedReader(new java.io.FileReader(filename)));
        String gameName = file.nextLine();
        file.close();
        return gameName;
    }
}

