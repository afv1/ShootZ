package proba1;

import javax.swing.JFrame;

public class ButtonFrame extends JFrame
{
		//создаем класс отвечающий за фрейм
		public ButtonFrame(){//конструктор данного класа
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHE);//размеры фрейма
		setTitle("Button");//название фрейма
		ButtonPanel panel=new ButtonPanel();//создаем панель
		add(panel);//добавляем панель на фрейм
		}
		public static final int DEFAULT_WIDTH=300;
		public static final int DEFAULT_HEIGHE=200;
}
