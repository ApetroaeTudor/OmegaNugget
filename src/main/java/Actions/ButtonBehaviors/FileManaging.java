package Actions.ButtonBehaviors;
import Buttons.AlphaNumButton;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class FileManaging {
    private static String file_Name="src/main/java/Main/data.txt";

    public static void WriteToFile(String fn,ArrayList<AlphaNumButton> list) {
        try {
            File file=new File(getFile_Name());
            FileWriter fr=new FileWriter(file);
            for(AlphaNumButton i:list) {
                fr.write(Integer.toString(i.getAlphanum_ID())+"\n");
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> make_StringFromFile() {
        try {
            return Files.readAllLines(Paths.get(getFile_Name()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFile_Name() {
        return file_Name;
    }
}
