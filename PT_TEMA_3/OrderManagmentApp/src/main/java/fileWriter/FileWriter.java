package fileWriter;

import java.io.File;
import java.io.IOException;

public class FileWriter {
    private File logFile;

    public FileWriter() {
        createLog();
    }
//creeaza fisierul
    public void createLog(){
        try {
            logFile = new File("./LogOfEvents.txt");
            if (logFile.createNewFile()) {
                System.out.println("File created: " + logFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//scrie in el ce se intampla cu facturile
    public void writeLog(String log){
        try {
            java.io.FileWriter myWriter = new java.io.FileWriter("./LogOfEvents.txt", true);
            myWriter.append(log);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
