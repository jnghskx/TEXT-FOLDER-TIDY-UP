import java.nio.file.Path;
import java.util.*;
import javax.swing.*;

public class SettingThings {
    Path from;
    Path to;
    String keyword;
    /*todo read from config file set the listed stuff to the sttuyfffgfgh*/



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
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.println(from);
            System.out.println("Are you sure you want to take files FROM this directory? [Y/N]");
            String yesno = scanner.next();

            if(!yesno.toLowerCase().equals("y")){
                from = selectNewDirectory();
            }
        }

        confirmFromDir();
    }

    void confirmToDir(){
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println(to);
            System.out.println("Are you sure you want to send files TO this directory? [Y/N]");
            //System.out.println("Also write [just delete them] if u wanna just delete them");
            String yesno = scanner.next();

            if(!yesno.toLowerCase().equals("y")){
                to = selectNewDirectory();
            }

            confirmToDir();
        }
    }

    void confirmKeywords(){
        System.out.println("Current keyword is '" + keyword + "'.");
        System.out.println("Theres only one functionality of this program\nand you cant change the word yet because this feature has a low priority.");
    }
}
