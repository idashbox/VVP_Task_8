package Util;

import Classes.InOutClass;
import Classes.InputArgs;
import Classes.MainLogicTask;
import Classes.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;

import static Classes.MainLogicTask.printSuccessMessage;
import static Classes.MainLogicTask.readWriteMethod;


public class FrameMain extends JFrame{

    private JTable table1;
    private JTextField answerTextField;
    private JButton readFileBtn;
    private JButton writeFileBtn;

    private JPanel panelMain;

    static InputArgs inputArgs = new InputArgs();

    public static void runTest() throws IOException {
        Test test = new Test();
        //первый тест
        String[] pathsTest1 = {test.testPath1In, test.testPath1Out};
        runSolutionTest(pathsTest1,1);

        //второй тест
        String[] pathsTest2 = {test.testPath2In, test.testPath2Out};
        runSolutionTest(pathsTest2,2);

        //третий тест
        String[] pathsTest3 = {test.testPath3In, test.testPath3Out};
        runSolutionTest(pathsTest3,3);

        //четвёртый тест
        String[] pathsTest4 = {test.testPath4In, test.testPath4Out};
        runSolutionTest(pathsTest4,4);

        //пятый тест
        String[] pathsTest5 = {test.testPath5In, test.testPath5Out};
        runSolutionTest(pathsTest5,5);
    }

    public static void runSolutionTest(String[] pathArgs, int num) throws IOException {
        inputArgs.setInputFile(pathArgs[0]);
        inputArgs.setOutputFile(pathArgs[1]);
        readWriteMethod(inputArgs);
        printSuccessMessage(num);
    }

    public FrameMain() throws IOException {

        runTest();

        final int[] numAnswer = {0};

        this.setTitle("Main program");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();



        JTableUtils.initJTableForArray(table1,40,false,false,true, true);

        //чтение файла и заполнение его в таблицу
        readFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[][] arr = InOutClass.readFile(".\\input.txt");
                    JTableUtils.writeArrayToJTable(table1, arr);
                }catch (Exception e){
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        //записываем ответ в данные
        writeFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = "Null";
                //обработка нашего массива
                try {
                    answer = MainLogicTask.getAnswer(JTableUtils.readIntMatrixFromJTable(table1), 1);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    InOutClass.writeFile(".\\output.txt", answer);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                answerTextField.setText("New answer " + numAnswer[0] + " is been written in" +  Paths.get("output.txt").toAbsolutePath());
                numAnswer[0] +=1;
            }
        });
    }
}
