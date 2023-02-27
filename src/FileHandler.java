//start of filehandler class

import javax.swing.*;
import java.io.*;
import java.util.*;
public class FileHandler {

    //handles all file-based methods


    public static void filewriter(String temptext){
        try {
                FileWriter fw = new FileWriter("MovieFile.txt");

                //dummy file is a fragment from a previous version
            //FileWriter df = new FileWriter("dummyfile.txt");
            //df.write("dummy program lol\n");
            //df.write("boy what the hell \n");
            //df.flush();
            //df.close();
                fw.write(temptext+"\n");
                fw.flush();
                fw.close();
                System.out.println("Successfully written to file");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

    public static void filereader(JLabel MovieLabel, File file){
        try {
            Scanner reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        FileReader fr;

    }
    }

//end of filehandler class