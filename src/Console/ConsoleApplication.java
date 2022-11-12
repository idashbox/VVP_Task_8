package Console;



import Classes.InputArgs;
import Classes.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Classes.MainLogicTask.printSuccessMessage;
import static Classes.MainLogicTask.readWriteMethod;


public class ConsoleApplication {

    static InputArgs inputArgs = new InputArgs();

    //метод чтения из консоли строки и преобразование её в набор строковых аргументов
    public static String[] readConsoleLineParameters(){
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

    //парсинг введённых в консоль данных
    public static InputArgs parseCmdArgs(String[] args) {
        System.out.println("ok");
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

    //запуск решения на основе адресов файлов
    public static void runSolution(String[] pathsTest, int num) throws IOException {
        //метод задания адресов для чтения/записи файлов
        if(num==0){
            //случай когда выполняется консольный (не тестовый ввод)
            inputArgs=parseCmdArgs(pathsTest);
        }else{
            //случай для тестов
            inputArgs.setInputFile(pathsTest[0]);
            inputArgs.setOutputFile(pathsTest[1]);
        }
        //метод чтения файлов по заданным адресам
        readWriteMethod(inputArgs);
        printSuccessMessage(num);
    }



    //запуск тестов для консольного приложения
    public static void runTestConsole() throws IOException {
        Test test = new Test();

        //первый тест
        String[] pathsTest1 = {test.testPath1In, test.testPath1Out};
        runSolution(pathsTest1,1);

        //второй тест
        String[] pathsTest2 = {test.testPath2In, test.testPath2Out};
        runSolution(pathsTest2,2);

        //третий тест
        String[] pathsTest3 = {test.testPath3In, test.testPath3Out};
        runSolution(pathsTest3,3);

        //четвёртый тест
        String[] pathsTest4 = {test.testPath4In, test.testPath4Out};
        runSolution(pathsTest4,4);

        //пятый тест
        String[] pathsTest5 = {test.testPath5In, test.testPath5Out};
        runSolution(pathsTest5,5);
    }

    public static void main(String[] args) throws IOException {
        System.out.println();
        //тестовая часть
        runTestConsole();

        System.out.println();
        System.out.print("Please, enter your path: ");

        //создание заготовки строки для дальнейшего парсинга
        String[] argsCmd = readConsoleLineParameters();
        //решение
        runSolution(argsCmd,0);
    }
}
