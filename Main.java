package com.company;

public class Main {
    public static void main(String[] args) {
        String input = "This is cisco interview";

        long startTime = System.nanoTime();
        String output = tranform(input);
        assert output == "This iS CiScO inTeRvieW";
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(output);
        System.out.println("Time Taken "+duration);

        startTime = System.nanoTime();
        String outputFast = transformFast(input);
        endTime = System.nanoTime();
        assert outputFast == "This iS CiScO inTeRvieW";
        duration = (endTime - startTime);
        System.out.println(outputFast);
        System.out.println("Time Taken "+duration);

        input = "iitBiT";
        outputFast = transformFast(input);
        assert outputFast == "iiTbit";

        input = "iti";
        outputFast = transformFast(input);
        System.out.println(outputFast);
        assert outputFast == "iti";

        input = "aBcDe";
        outputFast = transformFast(input);
        System.out.println(outputFast);
        assert outputFast == "AbCdE";

        input = "aBcD";
        outputFast = transformFast(input);
        System.out.println(outputFast);
        assert outputFast == "AbCd";
    }

    /**
     *  It transforms stream of characters into a every alternate character as lower to upper
     *  ( It assumes empty character as also character stream .)
     * @param word
     * @return
     */
    public static String tranform(String word){

        int len = word.length();
        StringBuffer accumulator = new StringBuffer();

        for (int i = 0; i <len ; i++) {
            char c =  word.charAt(i);
            if(i%2 == 0 && c!='i'){
                accumulator.append(Character.toUpperCase(c));
            }else {
                accumulator.append(Character.toLowerCase(c));
            }
        }
        return  accumulator.toString();
    }

    /**
     *  It transforms stream of characters into a every alternate character as lower to upper
     *  ( It assumes empty character as also character stream .)
     * @param word
     * @return
     */
    public static String transformFast(String word){
        int len = word.length();
        char[] accumulator = new char[len];

        for (int i = 0,j=len-1; i <= j; i++,j--) {
            char left =  word.charAt(i);
            char right = word.charAt(j);
            accumulator[i]= Character.toLowerCase(left);
            accumulator[j]= Character.toLowerCase(right);
            if(left != 'i' && i%2 == 0){
                accumulator[i]= Character.toUpperCase(left);
            }
            if(right != 'i' && j%2 == 0){
                accumulator[j]= Character.toUpperCase(right);
            }
        }
        return String.valueOf(accumulator);
    }

}
