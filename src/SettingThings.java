import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;

public class SettingThings {
    Path from;
    Path to;
    String keyword;
    /*todo read from properties file set the listed stuff to the sttuyfffgfgh*/
    Properties properties = new Properties(0);

    SettingThings(){
        
        try(FileInputStream inputStream = new FileInputStream("config.properties")){
            properties.load(inputStream);

            from = Paths.get(properties.getProperty("txtPath"));
            to = Paths.get(properties.getProperty("trashPath"));
            keyword = properties.getProperty("moveKeyword");

        }catch(IOException e){
            e.printStackTrace();
        }
    }


    //technically first time dong somehting with a gui
    Path selectNewDirectory(){ 
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().toPath();
        } else {
            System.out.println("You didnt pick anything lol");
        }
        return null;
    };


    
    void confirmFromDir(){

        //ask if user wants to change directory
        String yesno = "n";
        Scanner scanner = new Scanner(System.in);
            System.out.println(from);
            System.out.println("Are you sure you want to take files FROM this directory? [Y/N]");
            yesno = scanner.nextLine();
            

        if(yesno.toLowerCase().equals("n")){

            //get new directory 
            System.out.println("Selecting new directory");
            System.out.println("the dialogue is open just tab into it i dont feel like making a parent frame");
            Path newItem = selectNewDirectory(); 

            //put the new directory in from and update the properties file for next launch
            from = newItem; 
            properties.setProperty("trashPath", newItem.toString());
            try(FileOutputStream outputStream = new FileOutputStream("config.properties")){
                properties.store(outputStream, null);
            }catch(IOException e){
                System.out.println("io");
            }
            //ask again
            confirmFromDir(); //maybe dont do this
        }
            
    }

    void confirmToDir(){

         //ask if user wants to change directory
        String yesno = "n";
        Scanner scanner = new Scanner(System.in);
            System.out.println(from);
            System.out.println("Are you sure you want to bring files TO this directory? [Y/N]");
            yesno = scanner.nextLine();
            

        if(yesno.toLowerCase().equals("n")){

            //get new directory 
            System.out.println("Selecting new directory");
            System.out.println("the dialogue is open just tab into it i dont feel like making a parent frame");
            Path newItem = selectNewDirectory(); 
            
            //put the new directory in from and update the properties file for next launch
            to = newItem; 
            properties.setProperty("trashPath", newItem.toString());
            try(FileOutputStream outputStream = new FileOutputStream("config.properties")){
                properties.store(outputStream, null);
            }catch(IOException e){
                System.out.println("io.. its ok. i still love yuo.");
            }
            //ask again
            confirmToDir(); //maybe dont do this
        }
    }


    void confirmKeywords(){
        
        System.out.println("Theres only one functionality of this program\nand you cant change the word yet because this feature has a low priority.");
        
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Current keyword is '" + keyword + "'.");
            System.out.println("If this word is in the first line of your text file, it will be moved.");
            
        }
    }
}
