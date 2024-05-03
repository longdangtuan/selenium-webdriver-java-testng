package javaTester;

import org.testng.annotations.Test;

public class Topic_12_String {
    String courseName = "Automation Testing";

    @Test
    public void TC_01(){
        char courseNameArr[] = courseName.toCharArray();
        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        for(char character : courseNameArr){
            // Uppercase
            if(character <= 'Z' && character >= 'A'){
                countUpper ++;
            }
        }
        System.out.println("number of Upper = " + countUpper);
    }

    @Test
    public void TC_02(){
        char courseNameArr[] = courseName.toCharArray();
        int count = 0;
        for (char c : courseNameArr){
            if(c == 'a'){
                count ++;
            }
        }
        System.out.println(count);
    }
}
