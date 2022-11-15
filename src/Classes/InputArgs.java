package Classes;

public class InputArgs {
    private static String inputFile;
    private static String outputFile;
    //устанавливаем входной файл
    public void setInputFile(String inputFile){
        InputArgs.inputFile = inputFile;
    }
    //получаем его
    public String getInputFile(){
        return inputFile;
    }
    //устанавливаем выходной файл
    public void setOutputFile(String outputFile){
        InputArgs.outputFile = outputFile;
    }
    //получаем его
    public String getOutputFile(){
        return outputFile;
    }
}