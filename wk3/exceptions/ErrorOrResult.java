import java.util.NoSuchElementException;

public class ErrorOrResult {
    // public static <T> bool equal(T a, T b)
    // equal(a, b)
    // <Integer>equal(a, b)
    ErrorOrResult(){

    }

    ErrorOrResult(){

    }

    static ErrorOrResult parseIntOrFail (String input){
        try{
            int x = Integer.parseInt(input);
        }catch (NumberFormatException e){
            error(e);
        }
        return
    }
    static boolean failed() {

    }

    static String error(NumberFormatException e) throws NoSuchElementException {
        if (failed()) return "error message";
        else throw new NoSuchElementException(e);
    }

    static int result() throws NoSuchElementException {

    }


    public static void main(String[] args) {

    }
}

    
