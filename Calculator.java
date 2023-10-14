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

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        //by default JFrame is hidden when the user closes the window
        //so you have to define the behaviour of the application when closed

        frame.setSize(420, 550);
        frame.setLayout(null);
        //set the layout of the container, FlowLayout, BorderLayout, GridLayout, null Layout

        frame.setVisible(true);//to make the frame appear on the screen
    }
    public static void main(String[] args){
        Calculator calc = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e){

    }
}