package proba1;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ButtonPanel extends JPanel{//класс отвечающий за фрейм
JTextField textField=new JTextField(20);
JTextArea textArea=new JTextArea(10,30);
public ButtonPanel(){ //конструктор панелиadd(textField);

JButton yellowButton=new JButton("yellow");//создаем кнопки(в качестве параметра текст отображаемы на кнопке)
JButton blueButton=new JButton("blue");
JButton redButton=new JButton("red");
add(yellowButton);//добавляем кнопки на панель
add(blueButton);
add(redButton);
ColorAction yellowAction=new ColorAction(Color.yellow);//создаем событие для каждого цвета(параметр-цвет)
ColorAction blueAction=new ColorAction(Color.blue);
ColorAction redAction=new ColorAction(Color.red);
yellowButton.addActionListener(yellowAction);//передаем каждое событие соответствующей кнопке
blueButton.addActionListener(blueAction);
redButton.addActionListener(redAction);

add(textArea);
textArea.setLineWrap(true);

}

}