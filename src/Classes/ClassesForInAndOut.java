package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ClassesForInAndOut {
    private static String getPut(String str){
        String put = "";
        for(int i=2;i<str.length();i++){
            put+=str.charAt(i);
        }
        return put;
    }
    public static int[][] getIntArr(List<String> list){
        int stroki = list.size();
        int stolbzi = (list.get(0).split("\\s")).length;
        int[][] arr = new int[stroki][stolbzi];
        for(int i=0;i<stroki;i++){
            String[] row = list.get(i).split("\\s");
            for(int j=0;j<stolbzi;j++){
                arr[i][j]= Integer.parseInt(row[j]);
            }
        }
        return arr;
    }
    public static int[][] readFile(String inputPath) throws IOException {
        Path path = Paths.get(getPut(inputPath)).toAbsolutePath();
        System.out.println("Входной файл: " + path);
        List<String> list = Files.readAllLines(path);
        return getIntArr(list);
    }
    public static void writeFile(String outputPath, String answer) throws FileNotFoundException {
        File file = new File(getPut(outputPath));
        PrintWriter pw = new PrintWriter(file);
        pw.println(answer);
        pw.close();
        System.out.println("Выходной файл: " + Paths.get(getPut(outputPath)).toAbsolutePath());
    }
}
