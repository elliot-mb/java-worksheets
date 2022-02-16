public class ROT13Formatter implements Formatter{
    //ROT13Formatter(){}

    public String format(String s){
        char[] chars = s.toCharArray();
        String result = "";
        for(char c : chars){
            result += c + 13;
        }
        return result;
    }
}
