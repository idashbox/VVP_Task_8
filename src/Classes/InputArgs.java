package Classes;

public class InputArgs {
    private static String inputFile;
    private static String outputFile;


    public void setInputFile(String inputFile){
        InputArgs.inputFile = inputFile;
    }

    public String getInputFile(){
        return inputFile;
    }

    public void setOutputFile(String outputFile){
        InputArgs.outputFile = outputFile;
    }

    public String getOutputFile(){
        return outputFile;
    }
}