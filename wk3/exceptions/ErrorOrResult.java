public class ErrorOrResult {

    boolean failed() {return false;}
    String error() throws NoSuchElementException {}
    int result() throws NoSuchElementException {return -1;}

    public static void main(String[] args) {

    }
    
}