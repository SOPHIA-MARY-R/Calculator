import javax.swing.*; //to create window based applications (light weight desktop applications)
import java.awt.*; //AWT -> Abstract Window Toolkit; API to develop GUI or window-based-applications using Java
import java.awt.event.*;

public class Calculator implements  ActionListener{

    JFrame frame;
    //JFrame => top level container that provides a window on the screen
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;
    //JPanel => container that can store a group of components

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1=0, num2=0, result=0;
    char operator;

    public Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        //by default JFrame is hidden when the user closes the window
        //so you have to define the behaviour of the application when closed

        frame.setSize(420, 550);
        frame.setLayout(null);
        //set the layout of the container, FlowLayout, BorderLayout, GridLayout, null Layout

        //TEXT FIELD
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);//to prevent directly typing in the textField
        //

        //FUNCTION BUTTONS
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for(int i=0; i<8; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            //functionButtons[i].setFocusable(false); //focuses the component
        }

        //NUMBER BUTTONS
        for(int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        //DELETE BUTTON
        delButton.setBounds(50, 430, 145, 50);
        //CLEAR BUTTON
        clrButton.setBounds(205, 430, 145, 50);

        frame.add(textField);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);//to make the frame appear on the screen
    }
    public static  void main(String[] args){
        Calculator calc = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e){

    }
}