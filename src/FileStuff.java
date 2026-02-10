import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;  


public class FileStuff extends SettingThings{
//^ is inheriting this really needed lol //yes

String txtPath = from.toString(); 
String trashPath = to.toString(); 
String moveKeyword = keyword; 

//make file list at the directory of the txts and turn trashpath back into a path... skull emoji
File txts = new File(txtPath);
File[] fileList = txts.listFiles(); 
Path trashDir = Paths.get(trashPath);


void moveDaFilesAsynchronously(){ //self explanatory
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(fileList.length);
        for(int i = 0; i < fileList.length; i++){
            ses.schedule(new Moving(fileList[i]), 0, TimeUnit.SECONDS);
        }
        ses.shutdown(); 
    } //THIS IS SO EXCITING I LOVE THIS


public class Moving implements Runnable{
    int index = 0;
    File fileWereOn;

    public Moving(File fileWereOn){
        this.fileWereOn = fileWereOn;
    }
    public Moving(int index, File fileWereOn){// ...just in case
    this.index = index; this.fileWereOn = fileWereOn;
    }

    String lineOne; 
    public void run(){

        //makes a duplicate path version of our File
        Path from = fileWereOn.toPath();

        //reset line one
        lineOne = null;

        //make a new file reader for our specific fileWereOn. get first line of file. destroy reader when were done.
        try(BufferedReader reader = new BufferedReader(new FileReader(fileWereOn))){
            lineOne = reader.readLine();
            if (lineOne == null){
                throw new IOException(); //cry about it
            }
        } catch(IOException e){
            System.out.println("Skipped "+fileWereOn.getName()+" 'io' forgiveo youo");

        }

        if(lineOne.contains(moveKeyword)){
            //make path in trash folder to put the moved file in
            Path to = trashDir.resolve(fileWereOn.getName());

            //sigh. move.
            System.out.println("attempting to move file in 15 seconds");
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace(); System.out.println(" ...:( ?");
            }

            try {
                Files.move(from, to);
                System.out.println("MOVED " + fileWereOn.getName());
            } catch (IOException ex) {
                System.out.println("io skipped " + fileWereOn.getName());
            }

            //YAY!!! 
        }
    } 

    



}


}
