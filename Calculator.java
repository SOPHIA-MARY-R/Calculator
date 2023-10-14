import javax.swing.*; //to create window based applications (light weight desktop applications)
import java.awt.*; //AWT -> Abstract Window Toolkit; API to develop GUI or window-based-applications using Java
import java.awt.event.*;

public class Calculator implements  ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    Calculator(){

    }
    public static void main(String[] args){
        Calculator calc = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e){

    }
}