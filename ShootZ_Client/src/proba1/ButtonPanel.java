package proba1;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ButtonPanel extends JPanel{//����� ���������� �� �����
JTextField textField=new JTextField(20);
JTextArea textArea=new JTextArea(10,30);
public ButtonPanel(){ //����������� ������add(textField);

JButton yellowButton=new JButton("yellow");//������� ������(� �������� ��������� ����� ����������� �� ������)
JButton blueButton=new JButton("blue");
JButton redButton=new JButton("red");
add(yellowButton);//��������� ������ �� ������
add(blueButton);
add(redButton);
ColorAction yellowAction=new ColorAction(Color.yellow);//������� ������� ��� ������� �����(��������-����)
ColorAction blueAction=new ColorAction(Color.blue);
ColorAction redAction=new ColorAction(Color.red);
yellowButton.addActionListener(yellowAction);//�������� ������ ������� ��������������� ������
blueButton.addActionListener(blueAction);
redButton.addActionListener(redAction);

add(textArea);
textArea.setLineWrap(true);

}

}