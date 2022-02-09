import java.util.NoSuchElementException;

public class ErrorOrResult {

    static ErrorOrResult parseIntOrFail (String input){
        try{
            int x = Integer.parseInt(input);
            return ;
        }catch (NumberFormatException e){
            error(e);
        }
    }
    static boolean failed() {

    }
    static String error(String e) throws NoSuchElementException { }
    static int result() throws NoSuchElementException {return -1;}

    public static void main(String[] args) {

    }
    
}