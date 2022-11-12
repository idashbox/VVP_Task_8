package Classes;

import java.io.IOException;

public class MainLogicTask {

    //обработка массива (основная логика)
    public static String getAnswer(int[][] array, int n){
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
        return "Eth is OK";
    }

    //метод чтения и записи результата
    public static void readWriteMethod(InputArgs inputArgs) throws IOException {
        int[][] arr = InOutClass.readFile(inputArgs.getInputFile());
        String answer = MainLogicTask.getAnswer(arr, 1);
        InOutClass.writeFile(inputArgs.getOutputFile(),answer);
    }

    //печать сообщения успешной работы
    public static void printSuccessMessage(int num){
        if(num==0){
            System.out.println("The main program is done");
        }else{
            System.out.println("Test " + num + " is done");
        }
        System.out.println();
    }
}
