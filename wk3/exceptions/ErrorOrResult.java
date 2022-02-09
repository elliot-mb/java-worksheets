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

    String error() throws NoSuchElementException {
        if (failed()) return "error message";
        else throw new NoSuchElementException();
    }
    int result() throws NoSuchElementException {return -1;}


    public static void main(String[] args) {

    }
}

    
