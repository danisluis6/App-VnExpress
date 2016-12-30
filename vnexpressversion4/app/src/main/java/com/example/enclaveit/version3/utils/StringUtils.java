package com.example.enclaveit.version3.utils;

/**
 * Created by enclaveit on 30/12/2016.
 */
@SuppressWarnings("all")
public class StringUtils {
    public static String getImageURL(String description){
        int beginIndex = 0,endIndex = 0;
        for(int index = 0;index < description.length(); index++){
            if(description.charAt(index)=='h' && description.charAt(index+1) == 't' && description.charAt(index+2) == 't' && description.charAt(index+3) == 'p' && description.charAt(index+4) == ':' && description.charAt(index+5) == '/' && description.charAt(index+6) == '/' && ((index+6) < description.length()-6)){
                beginIndex = index;
            }
        }
        for(int index = beginIndex;index < description.length(); index++) {
            if(index < description.length()-3){
                if(description.charAt(index)=='.' && description.charAt(index+1) == 'j' && description.charAt(index+2) == 'p' && description.charAt(index+3) == 'g'){
                    endIndex = index+4;
                }else if(description.charAt(index)=='.' && description.charAt(index+1) == 'j' && description.charAt(index+2) == 'p' && description.charAt(index+3) == 'e' && description.charAt(index+4) == 'g'){
                    endIndex = index+5;
                }else if (description.charAt(index)=='.' && description.charAt(index+1) == 'p' && description.charAt(index+2) == 'n' && description.charAt(index+3) == 'g'){
                    endIndex = index+4;
                }
            }
        }
        return description.substring(beginIndex, endIndex);
    }
    public static String getURL(String description){
        int beginIndex = 0,endIndex = 0;
        for(int index = 0;index < description.length(); index++){
            if(index < description.length()-5){
                if(description.charAt(index)=='.' && description.charAt(index+1) == 'h' && description.charAt(index+2) == 't' && description.charAt(index+3) == 'm' && description.charAt(index+4) == 'l'){
                    endIndex = index+5;
                }
            }
        }
        for(int index = 0;index < endIndex; index++){
            if(description.charAt(index)=='h' && description.charAt(index+1) == 't' && description.charAt(index+2) == 't' && description.charAt(index+3) == 'p' && description.charAt(index+4) == ':' && description.charAt(index+5) == '/' && description.charAt(index+6) == '/'){
                beginIndex = index;
            }
        }
        return description.substring(beginIndex, endIndex);
    }

    public static String getDescriptionNew(String description){
        int beginIndex = 0,endIndex = 0;
        for(int index = 0;index < description.length(); index++){
            if(index < description.length()-8){
                if(description.charAt(index)=='<' && description.charAt(index+1) == '/' && description.charAt(index+2) == 'a' && description.charAt(index+3) == '>' && description.charAt(index+4) == '<' && description.charAt(index+5) == '/' && description.charAt(index+6) == 'b' && description.charAt(index+7) == 'r' && description.charAt(index+8) == '>'){
                    beginIndex = index+9;
                }
            }
        }
        return description.substring(beginIndex, description.length());
    }
}
