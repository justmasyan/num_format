package ball.com.company;

public class numformat {
    private static String from_dec(int number,int format){
        StringBuilder answ = new StringBuilder();
        while(number >= format){
                if(format > 9 && number%format > 9)
                    answ.append((char)(55+number%format));
                else
                    answ.append((char)(48+number%format));

            number /= format;
        }
        if(format > 9 && number%format > 9)
            answ.append((char)(55+number%format));
        else
            answ.append((char)(48+number%format));


        return answ.reverse().toString();
    }

    public static String from_notdec(String num,int format_in,int format_out){
        int answ = 0;

        for(int i = 0;i < num.length();i++) {
            if(format_in > 9 && num.charAt(i) - 48 > 9)
                answ += (num.charAt(i) - 55) * Math.pow(format_in, num.length() - 1 - i);
            else
                answ += (num.charAt(i) - 48) * Math.pow(format_in,num.length() - 1 - i);
        }

        return from_dec(answ,format_out);
    }
}
