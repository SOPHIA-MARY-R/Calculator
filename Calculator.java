import javax.swing.*; //to create window based applications (light weight desktop applications)
import javax.swing.border.BevelBorder;
import java.awt.*; //AWT -> Abstract Window Toolkit; API to develop GUI or window-based-applications using Java
import java.awt.event.*;

public class Calculator implements  ActionListener, MouseListener{
    JFrame frame;
    //JFrame => top level container that provides a window on the screen
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    //JPanel => container that can store a group of components

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1=0, num2=0, result=0;
    char operator;

    public Calculator(){
        //FRAME
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        //by default JFrame is hidden when the user closes the window
        //so you have to define the behaviour of the application when closed

        frame.setSize(420, 550);
        frame.getContentPane().setBackground(Color.black);
        frame.setLayout(null);
        //set the layout of the container, FlowLayout, BorderLayout, GridLayout, null Layout

        //TEXT FIELD
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);//to prevent directly typing in the textField

        //FUNCTION BUTTONS
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(int i=0; i<9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].addMouseListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false); //focuses the component (focuses the text, draws an outline around text when clicked)
            functionButtons[i].setBackground(Color.orange);
            functionButtons[i].setBorder(new BevelBorder(BevelBorder.LOWERED, Color.orange, Color.orange, Color.orange, Color.orange));
        }

        //NUMBER BUTTONS
        for(int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].addMouseListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.orange);
            numberButtons[i].setBorder(new BevelBorder(BevelBorder.LOWERED, Color.orange, Color.orange, Color.orange, Color.orange));
        }

        //NEGATE BUTTON
        negButton.setBounds(50, 430, 100, 50);
        //DELETE BUTTON
        delButton.setBounds(152, 430, 100, 50);
        //CLEAR BUTTON
        clrButton.setBounds(254, 430, 100, 50);

        //PANEL
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 2, 2));
        panel.setBackground(Color.black);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(textField);
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.setVisible(true);//to make the frame appear on the screen
    }
    public static  void main(String[] args){
        Calculator calc = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    //System.out.println(num1 + " " + num2);
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i=0; i<string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == negButton){
            double num = Double.parseDouble(textField.getText());
            num *= -1;
            textField.setText(String.valueOf(num));
        }
    }

    @Override
    public void mousePressed(MouseEvent e){
        for(int i=0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                numberButtons[i].setBackground(Color.white);
                numberButtons[i].setBorder(new BevelBorder(BevelBorder.LOWERED, Color.white, Color.white, Color.white, Color.white));
            }
        }
        for(int i=0; i<9; i++){
            if(e.getSource() == functionButtons[i]){
                functionButtons[i].setBackground(Color.white);
                functionButtons[i].setBorder(new BevelBorder(BevelBorder.LOWERED, Color.white, Color.white, Color.white, Color.white));
            }
        }
        if(e.getSource() == delButton){
            delButton.setBackground(Color.white);
        }
        if(e.getSource() == clrButton){
            clrButton.setBackground(Color.white);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i=0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                numberButtons[i].setBackground(Color.white);
                numberButtons[i].setBorder(new BevelBorder(BevelBorder.LOWERED, Color.white, Color.white, Color.white, Color.white));
            }
        }
        for(int i=0; i<9; i++){
            if(e.getSource() == functionButtons[i]){
                functionButtons[i].setBackground(Color.white);
                functionButtons[i].setBorder(new BevelBorder(BevelBorder.LOWERED, Color.white, Color.white, Color.white, Color.white));
            }
        }
        if(e.getSource() == delButton){
            delButton.setBackground(Color.white);
        }
        if(e.getSource() == clrButton){
            clrButton.setBackground(Color.white);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(int i=0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                numberButtons[i].setBackground(Color.orange);
                numberButtons[i].setBorder(new BevelBorder(BevelBorder.LOWERED, Color.orange, Color.orange, Color.orange, Color.orange));
            }
        }
        for(int i=0; i<9; i++){
            if(e.getSource() == functionButtons[i]){
                functionButtons[i].setBackground(Color.orange);
                functionButtons[i].setBorder(new BevelBorder(BevelBorder.LOWERED, Color.orange, Color.orange, Color.orange, Color.orange));
            }
        }
        if(e.getSource() == delButton){
            delButton.setBackground(Color.orange);
        }
        if(e.getSource() == clrButton){
            clrButton.setBackground(Color.orange);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for(int i=0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                numberButtons[i].setBackground(Color.white);
                numberButtons[i].setBorder(new BevelBorder(BevelBorder.LOWERED, Color.white, Color.white, Color.white, Color.white));
            }
        }
        for(int i=0; i<9; i++){
            if(e.getSource() == functionButtons[i]){
                functionButtons[i].setBackground(Color.white);
                functionButtons[i].setBorder(new BevelBorder(BevelBorder.LOWERED, Color.white, Color.white, Color.white, Color.white));
            }
        }
        if(e.getSource() == delButton){
            delButton.setBackground(Color.white);
        }
        if(e.getSource() == clrButton){
            clrButton.setBackground(Color.white);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for(int i=0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                numberButtons[i].setBackground(Color.orange);
                numberButtons[i].setBorder(new BevelBorder(BevelBorder.LOWERED, Color.orange, Color.orange, Color.orange, Color.orange));
            }
        }
        for(int i=0; i<9; i++){
            if(e.getSource() == functionButtons[i]){
                functionButtons[i].setBackground(Color.orange);
                functionButtons[i].setBorder(new BevelBorder(BevelBorder.LOWERED, Color.orange, Color.orange, Color.orange, Color.orange));
            }
        }
        if(e.getSource() == delButton){
            delButton.setBackground(Color.orange);
        }
        if(e.getSource() == clrButton){
            clrButton.setBackground(Color.orange);
        }
    }
}