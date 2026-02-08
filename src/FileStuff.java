import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileStuff {
String txtPath = "C:\\Users\\bestb\\Desktop\\this folder is far away from the project"; 
String trashPath = "C:\\Users\\bestb\\Photos\\what are these  doing all the way over here"; 
String moveKeyword = "temp";
//do later these should be brought in with the constructor

FileStuff(String txtPath, String trashPath, String moveKeyword){
    this.txtPath = txtPath;
    this.trashPath = trashPath;
    this.moveKeyword = moveKeyword;
}



File txts = new File(txtPath);
File[] fileList = txts.listFiles(); //also in the constructor check if this is empty/ !dir and throw an error if there is
Path trashDir = Paths.get(trashPath);




void fiftyMethodsInATrenchcoat() throws IOException{
    //print path of text folder & its contents for testing purposes
    System.out.println(new File(txtPath).getAbsolutePath());
    System.out.println(Arrays.toString(fileList)); 

    //i forgot what this does
    Files.createDirectories(trashDir);

    //go through every file in your list and check if the first line contains moveKeyword (temp rn) if it does move it to the trash folder
    for(File fileWereOn: fileList){

        //puts the file into a handy little variable and turn it into an abstract pathname
        Path from = fileWereOn.toPath();
        
        
        //reset the first line
        String lineOne = null; //could be declared outside foreach

        //read the first line of the fileWereOn with a filereader, put it in lineOne, and then kill it violently 
        try(BufferedReader reader = new BufferedReader(new FileReader(fileWereOn))){
            lineOne = reader.readLine(); 
        } catch (IOException e) { 
            System.out.println("Skipped " + fileWereOn.getName());
        }

        //move the file
        if (lineOne != null && lineOne.contains(moveKeyword)) {
            //path of the potential moved file of the same name
            Path to = trashDir.resolve(fileWereOn.getName()); 
            Files.move(from, to);
            System.out.println("MOVED " + fileWereOn.getName());
            }  else {
                System.out.println("Skipped " + fileWereOn.getName());
            }
    }
}
}
