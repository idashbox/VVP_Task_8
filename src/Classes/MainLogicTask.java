package Classes;

import java.io.IOException;
import java.util.Arrays;

public class MainLogicTask {
    //обработка массива
    public static int[][] getAnswer(int[][] array, int n){
        int [][] array_prob = new int [array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            int [] prob = new int [array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                prob[j] = array[i][j];
            }
            array_prob[i] = prob;
        }
        int [][] array_prob2 = new int [array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            int [] prob = new int [array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                prob[j] = array[i][j];
            }
            array_prob2[i] = prob;
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if (j >= n){
                    array_prob[i][j-n] = array[i][j];
                }
                if (j < n){
                    array_prob[i][array[i].length - n + j] = array[i][j];
                }
            }
            array_prob2[(i+n)%array.length] = array_prob[i];
        }
        return array_prob2;
    }
    public static String massivVStroki(int [][] array){
        StringBuilder answer = new StringBuilder();
        for (int [] mas : array){
            for (int znach : mas){
                answer.append(znach);
                answer.append(" ");
            }
            answer.append("\n");

        }
        return answer.toString();
    }
//    .\input.txt .\output.txt
    //метод для чтения и записи результата
    public static void readAndWriteMethod(InputArgs inputArgs) throws IOException {
        int[][] arr = ClassesForInAndOut.readFile(inputArgs.getInputFile());
        String answer = MainLogicTask.massivVStroki(MainLogicTask.getAnswer(arr, 1));
        ClassesForInAndOut.writeFile(inputArgs.getOutputFile(),answer);
    }
    public static void printSuccessMessage(int num){
        if(num==0){
            System.out.println("Основная программа выполнена.");
        }else{
            System.out.println("Тест " + num + " выполнен успешно.");
        }
        System.out.println();
    }
}
