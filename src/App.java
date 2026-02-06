public class App { 
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        FileStuff fileStuff = new FileStuff();
        // make it do this later. also  make it take from mulitple directories
        //1 = start || 2 = view directories || 3 = change directories || 4 = help (stop deletion process by removing keyword from line1)
        // 5 = view keywords || 6 = change keywords
        fileStuff.floating();
    }
}
