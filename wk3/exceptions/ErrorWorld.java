public class ErrorWorld {
    public static void main(String[] args) {
        ErrorOrResult eor0 = ErrorOrResult.parseIntOrFail("1");
        ErrorOrResult eor1 = ErrorOrResult.parseIntOrFail("-1");
        ErrorOrResult eor2 = ErrorOrResult.parseIntOrFail("two");

        //comment out NoSuchElementException-s as needed to run all tests
        System.out.println(eor0.failed()); //false
        System.out.println(eor1.failed()); //false
        System.out.println(eor2.failed()); //true
        System.out.println(eor0.error()); //NoSuchElementException
        System.out.println(eor1.error()); //NoSuchElementException
        System.out.println(eor2.error()); //"NumberFormatException"
        System.out.println(eor0.result()); //1
        System.out.println(eor1.result()); //-1
        System.out.println(eor2.result()); //NoSuchElementException
    }
}
