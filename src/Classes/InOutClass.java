package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class InOutClass {

    //парсинг входного/выходного пути (избавление
    private static String parsePath(String str){
        String path = "";
        for(int i=2;i<str.length();i++){
            path+=str.charAt(i);
        }
        return path;
    }

    public static int[][] getIntArr(List<String> list){
        int rows = list.size();
        int columns = (list.get(0).split("\\s")).length;
        int[][] arr = new int[rows][columns];
        for(int i=0;i<rows;i++){
            String[] row = list.get(i).split("\\s");
            for(int j=0;j<columns;j++){
                arr[i][j]= Integer.parseInt(row[j]);
            }
        }
        return arr;
    }

    public static int[][] readFile(String inputPath) throws IOException {
        Path path = Paths.get(parsePath(inputPath)).toAbsolutePath();
        System.out.println("Input file path: " + path);
        List<String> list = Files.readAllLines(path);
        return getIntArr(list);
    }

    public static void writeFile(String outputPath, String answer) throws FileNotFoundException {
        File file = new File(parsePath(outputPath));
        PrintWriter pw = new PrintWriter(file);
        pw.println(answer);
        pw.close();
        System.out.println("Output file path: " + Paths.get(parsePath(outputPath)).toAbsolutePath());
    }
}
