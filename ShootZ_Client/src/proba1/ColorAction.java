package proba1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorAction extends ButtonPanel implements ActionListener
{//��������� ��������� ���������� �� �������
public ColorAction(Color c )
{//����������� �������� ���� � �������� ���������
backgroundColor=c;
s=c.toString();

}
public void actionPerformed(ActionEvent event)
{//������� �� ������� ������-����� ����� ������
setBackground(backgroundColor);
textField.setText(s);
textArea.append(s+ "\n");
}
private Color backgroundColor;
private String s;
}