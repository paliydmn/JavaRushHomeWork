package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
       // detectAllWords(crossword, "home", "same");
        detectAllWords(crossword, "er");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }


    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> myWord = new ArrayList<Word>();

        int test = 0;

        char[] home = words[0].toCharArray();
        for (String str : words)
        {
            char[] same = str.toCharArray();
            for (int i = 0; i < crossword.length; i++){
                for (int j = 0; j < crossword[0].length; j++){

                    //horisontal
                    boolean isTrue;
                    if ((crossword[i][j] == same[0]) && j+ str.length()-1 <= crossword.length ){
                        isTrue = true;
                        for (int a = 1; a < str.length(); a++){
                            if(crossword[i][j + a] == same[a] && isTrue)
                            {isTrue = true;}
                            else
                            {isTrue = false;}
                        }
                        if(isTrue){
                            Word sameW = new Word(str);
                            sameW.setStartPoint(j, i);
                            sameW.setEndPoint(j + same.length - 1,i);
                            myWord.add(sameW);
                            break;
                        }
                    }
                    if((crossword[i][j] == same[0]) && j - (str.length()-1) >= 0 ){
                        isTrue = true;
                        for (int a = 1; a < str.length(); a++){
                            if(crossword[i][j - a] == same[a] && isTrue)
                            {isTrue = true;}
                            else
                            {isTrue = false;}
                        }
                        if(isTrue){
                            Word sameW = new Word(str);
                            sameW.setStartPoint(j, i);
                            sameW.setEndPoint(j - same.length + 1, i);
                            myWord.add(sameW);
                            break;
                        }
                    }
                    //vertical
                    if(crossword[i][j] == same[0] && i <= crossword.length - str.length() ){
                        isTrue = true;
                        for (int a = 1; a < str.length(); a++){
                            if(crossword[i + a ][j] == same[a] && isTrue)
                            {isTrue = true;}
                            else
                            {isTrue = false;}
                        }
                        if(isTrue){
                            Word sameW = new Word(str);
                            sameW.setStartPoint(j, i);
                            sameW.setEndPoint(j, i + same.length - 1);
                            myWord.add(sameW);
                            break;

                        }
                    }
                    if((crossword[i][j] == same[0]) && i - (str.length()-1) >= 0 ){
                        isTrue = true;
                        for (int a = 1; a < str.length(); a++){
                            if (crossword[i-a][j] == same[a] && isTrue){
                                isTrue = true;
                            } else
                            {
                                isTrue = false;
                            }
                        }
                        if (isTrue){
                            Word sameW = new Word(str);
                            sameW.setStartPoint(j, i);
                            sameW.setEndPoint(j, i - same.length + 1);
                            myWord.add(sameW);
                            break;

                        }
                    }


                    //diagonal #1
                    if((crossword[i][j] == same[0]) &&  i <= crossword.length - str.length() &&  j+ str.length()-1 <= crossword.length  ){
                        isTrue = true;
                        for (int a = 1; a < str.length(); a++){
                            if(crossword[i + a ][j + a] == same[a] && isTrue)
                            {isTrue = true;}
                            else
                            {isTrue = false;}
                        }
                        if(isTrue){
                            Word sameW = new Word(str);
                            sameW.setStartPoint(j, i);
                            sameW.setEndPoint( j + same.length - 1, i + same.length - 1);
                            myWord.add(sameW);
                            break;

                        }
                    }
                     if((crossword[i][j] == same[0]) &&   i - (str.length()-1) >= 0   && j - (str.length()-1) >= 0  ){
                        isTrue = true;
                        for (int a = 1; a < str.length(); a++){
                            if(crossword[i - a ][j - a] == same[a] && isTrue)
                            {isTrue = true;}
                            else
                            {isTrue = false;}
                        }
                        if(isTrue){
                            Word sameW = new Word(str);
                            sameW.setStartPoint(j, i);
                            sameW.setEndPoint(j-str.length()+1, i- str.length()+1);
                            myWord.add(sameW);
                            break;
                        }
                    }
                    //diagonal #2  // need to continue
                    //System.out.println((char) crossword[i][j]);

                    if((crossword[i][j] == same[0]) &&  i + (str.length() ) <= crossword[i].length && j - (str.length()-1 ) >= 0 ){
                          isTrue = true;

                       /* System.out.println("test " + (str.length()-1) );
                        System.out.println(i + "  " + j);*/

// should be  -   a = 1
                        for (int a = 0; a <= str.length()-1; a++){

                          if(crossword[i + a ][j - a] == same[a] && isTrue)
                            {
                                System.out.println(i + "  " + j);

                                isTrue = true;}
                            else
                            {isTrue = false;}
                        }
                        if(isTrue){
                            Word sameW = new Word(str);
                            sameW.setStartPoint(j, i);
                            sameW.setEndPoint( j - same.length +1, i + same.length - 1);
                            myWord.add(sameW);
                            break;
                        }
                    }
                    if((crossword[i][j] == same[0]) &&   i - (str.length()-1) >= 0   && j + (str.length()-1) >= 0
                            && 0>= j-(str.length()-1) && 0>= i -(str.length()-1)){
                        isTrue = true;

                      //  test++;


                            for (int a = 1; a < str.length()-1; a++){
                                if(i-a !=0 && j+a <=5)
                                {
                                    if(crossword[i - a ][j + a] == same[a] && isTrue)
                                {isTrue = true;}
                                else
                                {isTrue = false;}
                            }
                            if(isTrue){
                                Word sameW = new Word(str);
                                sameW.setStartPoint(j, i);
                                sameW.setEndPoint(j+str.length()-1, i- str.length()+1);
                                myWord.add(sameW);
                                break;
                            }
                        }
                    }


                }
            }
        }
     //   System.out.println(test);
        System.out.println(myWord);
        return myWord;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
