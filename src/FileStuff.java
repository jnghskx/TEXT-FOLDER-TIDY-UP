import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileStuff {
String txtPath = "C:\\Users\\bestb\\Desktop\\this folder is far away from the project"; //can be local too
String trashPath = "C:\\Users\\bestb\\Photos\\what are these  doing all the way over here"; 
//do later these should be brought in with the constructor and made into paths there. 

File txts = new File(txtPath);
//BufferedReader reader = new BufferedReader(new FileReader(txtPath+"/1.txt"));

File[] fileList = txts.listFiles(); //also in the constructor check if this is empty/ !dir and throw an error if there is


Path trashDir = Paths.get(trashPath);




void floating() throws IOException{
    System.out.println(new File(txtPath).getAbsolutePath());

    System.out.println(Arrays.toString(fileList)); 

    Files.createDirectories(trashDir);

    for(File filepath: fileList){

        Path from = filepath.toPath();
        Path to = trashDir.resolve(filepath.getName());
        

        String lineOne = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){

            lineOne = reader.readLine(); 
        } catch (Exception e) { //placeholder im gunna deal with null first lines and wrong directories later
            System.out.println("Skipped: " + filepath.getName());
        }

        if (lineOne != null && lineOne.contains("temp")) {
            Files.move(from, to);
            System.out.println("Moved: " + filepath.getName());
            }  
    }
}
}
