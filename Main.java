package com.company;

public class Main {
    /**
     *  It transforms stream of characters into a every alternate character as lower to upper
     *  ( It assumes empty character as also character stream .)
     *  Time Complexity O(n/2)
     * @param word
     * @return
     */
    public static String transformFast(String word){
        int len = word.length();
        char[] accumulator = new char[len];

        for (int i = 0,j=len-1; i <= j; i++,j--) {
            char left =  word.charAt(i);
            char right = word.charAt(j);
            boolean isLeftI = (left =='i' || left == 'I');
            boolean isRightI = (right =='i' || right == 'I');
            accumulator[i]=  isLeftI ? left:Character.toLowerCase(left);
            accumulator[j]=  isRightI ? right : Character.toLowerCase(right);
            if( !isLeftI && i%2 == 0){
                accumulator[i]= Character.toUpperCase(left);
            }
            if( !isRightI && j%2 == 0){
                accumulator[j]= Character.toUpperCase(right);
            }
        }
        return String.valueOf(accumulator);
    }
    /**
     *  It transforms stream of characters into a every alternate character as lower to upper
     *  ( It assumes empty character as also character stream .)
     *  Time Complexity O(n/2)
     * @param word
     * @return
     */
    public static String tranform(String word){

        int len = word.length();
        StringBuffer accumulator = new StringBuffer();

        for (int i = 0; i <len ; i++) {
            char c =  word.charAt(i);
            if(c=='i' || c == 'I'){
                accumulator.append(c);
                continue;
            }
            if(i%2 == 0 ){
                accumulator.append(Character.toUpperCase(c));
            }else {
                accumulator.append(Character.toLowerCase(c));
            }
        }
        return  accumulator.toString();
    }

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
}
