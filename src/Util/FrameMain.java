package Util;

import Classes.ClassesForInAndOut;
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
import static Classes.MainLogicTask.readAndWriteMethod;


public class FrameMain extends JFrame{

    private JTable table1;
    private JTextField answerTextField;
    private JButton readFileBtn;
    private JButton writeFileBtn;

    private JPanel panelMain;
    private JButton прочитатьФайл2Button;
    private JButton прочитатьФайл3Button;
    private JButton прочитатьФайл5Button;
    private JButton прочитатьФайл4Button;
    private JButton button1;

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
        readAndWriteMethod(inputArgs);
        printSuccessMessage(num);
    }

    public FrameMain() throws IOException {

        runTest();

        final int[] numAnswer = {0};

        this.setTitle("Основная программа");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();



        JTableUtils.initJTableForArray(table1,40,false,false,true, true);

        //чтение файла и заполнение им таблицы
        readFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[][] arr = ClassesForInAndOut.readFile(".\\input.txt");
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
                //обработка массива
                try {
                    answer = MainLogicTask.massivVStroki(MainLogicTask.getAnswer(JTableUtils.readIntMatrixFromJTable(table1), 1));
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    ClassesForInAndOut.writeFile(".\\output.txt", answer);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                answerTextField.setText("Новый ответ " + numAnswer[0] + " будет записан в " +  Paths.get("output.txt").toAbsolutePath());
                numAnswer[0] +=1;
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int[][] arr = ClassesForInAndOut.readFile(".\\input01.txt");
                    JTableUtils.writeArrayToJTable(table1, arr);
                }catch (Exception ee){
                    SwingUtils.showErrorMessageBox(ee);
                }
            }
        });
        прочитатьФайл2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int[][] arr = ClassesForInAndOut.readFile(".\\input02.txt");
                    JTableUtils.writeArrayToJTable(table1, arr);
                }catch (Exception ee){
                    SwingUtils.showErrorMessageBox(ee);
                }
            }
        });
        прочитатьФайл3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int[][] arr = ClassesForInAndOut.readFile(".\\input03.txt");
                    JTableUtils.writeArrayToJTable(table1, arr);
                }catch (Exception ee){
                    SwingUtils.showErrorMessageBox(ee);
                }
            }
        });
        прочитатьФайл4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int[][] arr = ClassesForInAndOut.readFile(".\\input04.txt");
                    JTableUtils.writeArrayToJTable(table1, arr);
                }catch (Exception ee){
                    SwingUtils.showErrorMessageBox(ee);
                }
            }
        });
        прочитатьФайл5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int[][] arr = ClassesForInAndOut.readFile(".\\input05.txt");
                    JTableUtils.writeArrayToJTable(table1, arr);
                }catch (Exception ee){
                    SwingUtils.showErrorMessageBox(ee);
                }
            }
        });
    }
}
