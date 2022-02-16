public class ROT13Formatter implements Formatter{
    //ROT13Formatter(){}

    private final int rot = 13;

    public String format(String s){
        char[] chars = s.toCharArray();
        String result = "";
        for(char c : chars){
            if(c > 64 && c < 91){
                result += (char) (((c - 65 + this.rot) % 26) + 65);
            }
            else if(c > 96 && c < 123){
                result += (char) (((c - 97 + this.rot) % 26) + 97);
            }else{ result += c; }
        }
        return result;
    }
}
