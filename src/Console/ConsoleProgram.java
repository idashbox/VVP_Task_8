package Console;



import Classes.InputArgs;
import Classes.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Classes.MainLogicTask.printSuccessMessage;
import static Classes.MainLogicTask.readAndWriteMethod;


public class ConsoleProgram {
    static InputArgs inputArgs = new InputArgs();
    //метод чтения из консоли строки и преобразование её в набор строковых аргументов
    public static String[] readConsoleParameters(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String cmdLine = null;
        try{
            cmdLine=bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert cmdLine != null;
        return cmdLine.split("\\s");
    }
    public static InputArgs razborCmdArgs(String[] args) {
        String inputFilePathVar, outputFilePathVar;
        if(args.length==2){
            inputFilePathVar = args[0];
            outputFilePathVar = args[1];
        }else{
            inputFilePathVar = args[1];
            outputFilePathVar = args[3];
        }
        inputArgs.setInputFile(inputFilePathVar);
        inputArgs.setOutputFile(outputFilePathVar);
        return inputArgs;
    }
    public static void runSolution(String[] pathsTest, int num) throws IOException {
        //чтение/запись
        if(num==0){
            inputArgs= razborCmdArgs(pathsTest);
        }else{
            inputArgs.setInputFile(pathsTest[0]);
            inputArgs.setOutputFile(pathsTest[1]);
        }
        //метод чтения файлов по заданным адресам
        readAndWriteMethod(inputArgs);
        printSuccessMessage(num);
    }
    public static void runTestToConsole() throws IOException {
        Test test = new Test();
        String[] pathsTest1 = {test.testPath1In, test.testPath1Out};
        runSolution(pathsTest1,1);
        String[] pathsTest2 = {test.testPath2In, test.testPath2Out};
        runSolution(pathsTest2,2);
        String[] pathsTest3 = {test.testPath3In, test.testPath3Out};
        runSolution(pathsTest3,3);
        String[] pathsTest4 = {test.testPath4In, test.testPath4Out};
        runSolution(pathsTest4,4);
        String[] pathsTest5 = {test.testPath5In, test.testPath5Out};
        runSolution(pathsTest5,5);
    }
    public static void main(String[] args) throws IOException {
        System.out.println();
        //тестовая часть
        runTestToConsole();
        System.out.println();
        System.out.print("Введите путь файла: ");
        //создание заготовки строки для дальнейшего разбора пути
        String[] argsCmd = readConsoleParameters();
        //задаём нетестовый массив
        runSolution(argsCmd,0);
    }
}
