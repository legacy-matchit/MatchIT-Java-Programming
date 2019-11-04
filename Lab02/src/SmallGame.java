import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.TimerTask;

public class SmallGame {

    //class variables
    static JLabel firstNumberLabel;
    static JLabel secondNumberLabel;
    static JLabel operationLabel;
    static JLabel equalLabel;
    static JLabel countLabel;
    static JTextArea middleTextArea;

    static JTextField valueTextField;
    static JButton checkAnswerButton;
    static JButton reStartButton;
    static JButton startButton;

    static String resultText;
    static String operation;
    static String[] operations = {"*","+","-"};

    static int firstRandomNumber,secondRandomNumber;
    static int count;
    static int correctCount;
    static int incorrectCount;

    static Timer timer;
    static TimerTask timeTask;


    /**
     * @param args
     * when program is started this method is called firstly
     */
    public static void main(String[] args){

        setUI();

        setQuizPanel();

        setData();

        setTimer();

    }

    /**
     * set Timer
     */
    public static void setTimer(){
        //register timer
        timer = new javax.swing.Timer(60, e -> {
            count--;
            countLabel.setText("left time :"+count/10);

            if(count == 0){
                timer.stop();
                showGameOver();
            }

        });
    }

    /**
     * set Data
     */
    public static void setData(){
        count = 600;
        correctCount = 0;
        incorrectCount = 0;
    }
    /**
     * set UI
     */
    public static void setUI(){

        //set window
        JFrame frame = new JFrame("SmallGame");
        frame.setBounds(100, 100, 500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //set quizPanel
        JPanel quizPanel = new JPanel();

        middleTextArea = new JTextArea("HI This is SmallGame for warming up your brain before write code ^^:");
        middleTextArea.setEnabled(false);
        firstNumberLabel = new JLabel("");
        operationLabel= new JLabel("+");
        secondNumberLabel = new JLabel("");
        equalLabel = new JLabel("=");
        valueTextField = new JTextField(10);
        firstNumberLabel.setVisible(false);
        operationLabel.setVisible(false);
        secondNumberLabel.setVisible(false);
        equalLabel.setVisible(false);
        valueTextField.setVisible(false);

        quizPanel.add(firstNumberLabel);
        quizPanel.add(operationLabel);
        quizPanel.add(secondNumberLabel);
        quizPanel.add(equalLabel);
        quizPanel.add(valueTextField);
        quizPanel.add(middleTextArea);

        //set countPanel
        JPanel countPanel = new JPanel();
        countLabel = new JLabel("");
        countPanel.add(countLabel);

        //set buttonPanel and register event
        JPanel btnPanel = new JPanel();
        checkAnswerButton = new JButton("Check");
        reStartButton = new JButton("Restart");
        startButton = new JButton("Start");

        checkAnswerButton.addActionListener(SmallGame::clickedCheckButton);
        checkAnswerButton.setVisible(false);
        reStartButton.addActionListener(SmallGame::clickedRestartButton);
        reStartButton.setVisible(false);
        startButton.addActionListener(SmallGame::clickedStartButoon);

        btnPanel.add(checkAnswerButton);
        btnPanel.add(reStartButton);
        btnPanel.add(startButton);


        frame.getContentPane().add(quizPanel,BorderLayout.CENTER);
        frame.getContentPane().add(countPanel,BorderLayout.NORTH);
        frame.getContentPane().add(btnPanel,BorderLayout.SOUTH);


    }

    /**
     *set interface for quiz
     */
    public static void setQuizPanel(){

        firstRandomNumber = getRandomNumberWithRage(20);
        secondRandomNumber = getRandomNumberWithRage(30);
        operation = operations[getRandomNumberWithRage(3)];
        firstNumberLabel.setText(""+firstRandomNumber);
        secondNumberLabel.setText(""+secondRandomNumber);
        operationLabel.setText(operation);
        valueTextField.setText("");
        valueTextField.setEnabled(true);
    }

    /**
     *set interface when game is over
     */
    public static void showGameOver(){
        valueTextField.setText("");
        valueTextField.setEnabled(false);
        countLabel.setText("GAME OVER");
        checkAnswerButton.setEnabled(false);
        reStartButton.setVisible(true);
        resultText = "Correct answer:" + correctCount + "\nIncorrect answer:" + incorrectCount;
        showTextWithString(resultText);
    }




    /**
     * @param clickedStartButton
     */
    public static void clickedStartButoon(ActionEvent clickedStartButton){
        startButton.setVisible(false);
        firstNumberLabel.setVisible(true);
        operationLabel.setVisible(true);
        secondNumberLabel.setVisible(true);
        equalLabel.setVisible(true);
        valueTextField.setVisible(true);
        checkAnswerButton.setVisible(true);
        showTextWithString("");
        timer.start();
    }

    /**
     * @param clickedRestarButton
     */
    public static void clickedRestartButton(ActionEvent clickedRestarButton){

        reStartButton.setVisible(false);
        checkAnswerButton.setEnabled(true);
        showTextWithString("");
        setData();
        setQuizPanel();
        timer.start();
    }


    /**
     * @param clickedCheckButton
     */
    public static void clickedCheckButton(ActionEvent clickedCheckButton){


        //check input value if it is correct or not
        if(valueTextField.getText().length() == 0 || !isNumber(valueTextField.getText()) ||
                isIncludeSpaceWith(valueTextField.getText())){
            valueTextField.setText("");
            showTextWithString("Invalid value\n(Plase Enter Only Number Without Space)");
            return;
        }

        //correct answer
        int answer = 0;

        //user input answer
        int inputResult = Integer.parseInt(valueTextField.getText());

        //make expression with operation
        if(operation == "*"){
            answer = firstRandomNumber * secondRandomNumber;
        }else if(operation == "+"){
            answer = firstRandomNumber + secondRandomNumber;
        }else if(operation == "-"){
            answer = firstRandomNumber - secondRandomNumber;
        }

        //check answer
        if(answer == inputResult){
            correctCount++;
            resultText = "Good Job";
        }else{
            incorrectCount++;
            resultText = "Try Again";
        }

        setQuizPanel();

        showTextWithString(resultText);
    }

    /***
     * @param str
     * @return boolean
     * check input string from user if it can change number or not
     */
    public static boolean isNumber(String str){

        boolean result = false;

        try{
            Double.parseDouble(str) ;
            result = true ;
        }catch(Exception exception){
            System.out.println(exception);
        }

        return result;
    }

    /**
     * @param message
     * show text
     */
    public static void showTextWithString(String message){
        middleTextArea.setText(message);
    }

    /**
     * @param range
     * @return int
     * get random number
     */
    public static int getRandomNumberWithRage(int range){
        Random rand = new Random();
        return rand.nextInt(range);
    }

    /**
     * @param str
     * @return boolean
     * check data if it is include space or not
     */
    public static boolean isIncludeSpaceWith(String str) {

        for(int i = 0 ; i < str.length() ; i++) {

            if(str.charAt(i) == ' '){
                return true;
            }

        }

        return false;
    }

}


