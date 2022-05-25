package com.example.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
@Configuration
public class Encryption {

    private Map<Character, String> codeMap;
    private String englishChars;
    private ArrayList<Integer> changeIndex;
    public SimpleDateFormat sdf;

    /**
     * 根据时间加密
     * @param date date()类型时间
     * */
    public String enTimeCode(Date enDate){
        String dataStr = null;
        try{
            dataStr = this.getSdf().format(enDate);
            String enStr = "";
            for(int i=0; i<dataStr.length(); i++){
                String transLetter = this.getCodeMap().get(dataStr.charAt(i));
                enStr = enStr + transLetter;
            }
            int changeCusor = 0;
            StringBuffer retStr = new StringBuffer(generateRandString(21));
            for(int i=0; i<retStr.length(); i++){
                if(this.getChangeIndex().contains(i)){
                    retStr.setCharAt(i, enStr.charAt(changeCusor));
                    changeCusor++;
                }
            }
            return retStr.toString();
        }catch(Exception e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
            return "";
        }
    }


    private Map<Character, String> getCodeMap() {
        if(codeMap == null){
            codeMap = new HashMap<Character, String>();
            codeMap.put('0', "I");
            codeMap.put('1', "L");
            codeMap.put('2', "O");
            codeMap.put('3', "V");
            codeMap.put('4', "E");
            codeMap.put('5', "M");
            codeMap.put('6', "Y");
            codeMap.put('7', "D");
            codeMap.put('8', "N");
            codeMap.put('9', "S");
        }
        return codeMap;
    }

    private static ArrayList<Character> valueGetKey(Map<Character, String> map, String value) {
        Set<Map.Entry<Character, String>> set = map.entrySet();
        ArrayList<Character> arr = new ArrayList<Character>();
        Iterator<Map.Entry<Character, String>> it = set.iterator();
        while(it.hasNext()) {
            Map.Entry<Character, String> entry = (Map.Entry<Character, String>)it.next();
            if(entry.getValue().equals(value)) {
                char s = (char)entry.getKey();
                arr.add(s);
            }
        }
        return arr;
    }


    private String getEnglishChars() {
        if(englishChars == null){
            englishChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        return englishChars;
    }

    private SimpleDateFormat getSdf() {
        if(sdf == null){
            sdf = new SimpleDateFormat("yyyyMMdd");
        }
        return sdf;
    }

    public ArrayList<Integer> getChangeIndex() {
        if(changeIndex == null){
            changeIndex = new ArrayList<Integer>();
            changeIndex.add(1);
            changeIndex.add(6);
            changeIndex.add(9);
            changeIndex.add(13);
            changeIndex.add(14);
            changeIndex.add(17);
            changeIndex.add(19);
            changeIndex.add(20);
        }
        return changeIndex;
    }

    private String generateRandString(int bits){
        String retStr = "";
        for(int i=0; i<bits; i++){
            retStr = retStr + this.getEnglishChars().charAt((int)(Math.random() * 26));
        }
        return retStr;
    }
}
