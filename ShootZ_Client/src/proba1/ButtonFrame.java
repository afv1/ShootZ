package proba1;

import javax.swing.JFrame;

public class ButtonFrame extends JFrame
{
		//������� ����� ���������� �� �����
		public ButtonFrame(){//����������� ������� �����
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHE);//������� ������
		setTitle("Button");//�������� ������
		ButtonPanel panel=new ButtonPanel();//������� ������
		add(panel);//��������� ������ �� �����
		}
		public static final int DEFAULT_WIDTH=300;
		public static final int DEFAULT_HEIGHE=200;
}
