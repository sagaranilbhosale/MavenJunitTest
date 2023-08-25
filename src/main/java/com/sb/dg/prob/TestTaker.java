package com.sb.dg.prob;

public class TestTaker {
    public static String output( String[] input ) {
        StringBuilder buffer = new StringBuilder();

        for(String str: input) {
            buffer.append(str);
        }
        String output = buffer.toString().replaceAll("[0-9]","");
        return capitalizeFirstChar(output);
    }

    private static String capitalizeFirstChar(String output) {
        if(output.length() == 0)
            return output;
        StringBuffer buffer = new StringBuffer();
        if(Character.isLetter(output.charAt(0))) {
            buffer.append(Character.toUpperCase(output.charAt(0)));
        } else {
            buffer.append(output.charAt(0));
        }
        for(int i = 0; i < output.length()-1; i++) {
            if(!Character.isLetter(output.charAt(i)) && Character.isLetter(output.charAt(i+1))) {
                buffer.append(Character.toUpperCase(output.charAt(i+1)));
            } else {
                buffer.append(output.charAt(i+1));
            }
        }
        return buffer.toString();
    }
}