package view;

import controller.UnicodeOrShift;
import controller.WriteReadFile;
import static controller.WriteReadFile.readFile;
import static controller.WriteReadFile.writeFile;

/**
 *
 * @author Luis
 */
public class EncDec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] data = null;
        int shift = 0;
        String mode = "enc";
        boolean isOutput = false;
        String pathOutput = "";
        String alg = "shift";
        String pathInput = "";

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-data":
                    data = args[i + 1].toCharArray();
                    break;
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    shift = Integer.parseInt(args[i + 1]);
                    break;
                case "-out":
                    isOutput = true;
                    pathOutput = args[i + 1];
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
                case "-in":
                    pathInput = args[i + 1];
                    data = readFile(pathInput);
                    break;
            }

        }

        UnicodeOrShift us = new UnicodeOrShift();
        if (isOutput) {
            switch (mode) {
                case "dec":
                    writeFile(pathOutput, us.decrypt(data, shift, alg));
                    break;
                case "enc":
                    writeFile(pathOutput, us.encrypt(data, shift, alg));
                    break;
            }
        } else {
            switch (mode) {
                case "dec":
                    System.out.println(us.decrypt(data, shift, alg));
                    break;
                case "enc":
                    System.out.println(us.encrypt(data, shift, alg));
                    break;
            }
        }
    }

}
