import java.util.NoSuchElementException;

public class ErrorOrResult {
    // public static <T> bool equal(T a, T b)
    // equal(a, b)
    // <Integer>equal(a, b)
    ErrorOrResult(){

<<<<<<< HEAD
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
=======
    //don't push until msg Elliot
    static ErrorOrResult parseIntOrFail (String input){
        ErrorOrResult err = new ErrorOrResult();
>>>>>>> cb1aa62 (Resolve conflict)
    }
    static boolean failed() {

    }

<<<<<<< HEAD
    static String error(NumberFormatException e) throws NoSuchElementException {
=======
    static String error() throws NoSuchElementException {
>>>>>>> cb1aa62 (Resolve conflict)
        if (failed()) return "error message";
        else throw new NoSuchElementException(e);
    }

    static int result() throws NoSuchElementException {

    }


    public static void main(String[] args) {

    }
}

    
