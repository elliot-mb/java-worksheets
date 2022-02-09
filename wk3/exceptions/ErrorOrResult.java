import java.util.NoSuchElementException;

public class ErrorOrResult {
    // public static <T> bool equal(T a, T b)
    // equal<T>(a, b)
    // equal<Integer>(a, b)


// // // // DONT PUSH UNTIL MESSAGE JADE (WE'LL DECIDE WHICH VER TO USE

    private int x;
    private NumberFormatException e;

    ErrorOrResult(int _x){
        x = _x;
    }

    ErrorOrResult(NumberFormatException _e){
        e = _e;
    }

    // only static method (used to make object)
    static ErrorOrResult parseIntOrFail (String input){
        try{
            return new ErrorOrResult(Integer.parseInt(input));
        }catch (NumberFormatException e){
            return new ErrorOrResult(e);
        }
    }

    public boolean failed() {
        if(e == null) { return false; }
        return true;
    }

    public String error() throws NoSuchElementException {
        if (this.failed()) { return "NumberFormatException"; }
        throw new NoSuchElementException(); // if there was no error, return a different error
    }

    public int result() throws NoSuchElementException {
        if (!this.failed()) { return x; }
        throw new NoSuchElementException(); //if no number
    }
}

    
