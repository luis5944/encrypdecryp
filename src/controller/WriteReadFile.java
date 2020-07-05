package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class WriteReadFile {

    public static void writeFile(String fileOutput, String text) {
        try (FileWriter fw = new FileWriter(fileOutput)) {
            fw.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static char[] readFile(String filePath) {
        char[] data = null;
        File file = new File(filePath);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    data = scanner.nextLine().toCharArray();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
