public class App { 
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
       // FileStuff fileStuff = new FileStuff("x","y","z"); // can filestutuff just take in the properites file?
        // make it do this later. also  make it take from mulitple directories
        //1 = start || 2 = view directories || 3 = change directories || 4 = help (stop deletion process by removing keyword from line1)
        // 5 = view keywords || 6 = change keywords
        //fileStuff.floating();
        SettingThings settings = new SettingThings();
        FileStuff filestuff = new FileStuff();

        settings.confirmFromDir();
        settings.confirmToDir();
        filestuff.moveDaFilesAsynchronously();
    }


}
