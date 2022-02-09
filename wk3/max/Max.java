public class Max {

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(max(new int[]{1, 2, 3}));
    }

    public static int max(int[] xs) throws IllegalAccessException{
        if (!(xs.equals(null) || xs.length == 0)){
            int largest = Integer.MIN_VALUE;
            for(int x : xs) largest = x > largest ? x : largest;
            return largest;
        }else throw new IllegalAccessException();
   }
}
