package test.java.server;

public interface Commons
{
	public static final int MAX_W = 200;          //размер карты	/Заменить на разрешение экрана по X
    public static final int MAX_H = 200;          //размер карты	/Заменить на разрешение экрана по Y
    public static final int MIN_W = 0;         	  //размер карты
    public static final int MIN_H = 0;            //размер карты
    public static final int P_S = 3;              //размер игрока и зомби
    public static final int B_S = 5;              //размер зомби босса
    public static final int Z_HP = 30;            //жизни зомби
    public static final int P_HP = 100;           //жизни игрока и зомби босса
    public static final int Z_DMG = 5;            //урон зомби
    public static final int B_DMG = 20;           //урон зомби босса
    public static final int PM_DMG = 6;           //урон ПМ
    public static final int AK_DMG = 10;          //урон АК
    public static final int PM_AMMO = 8;          //обойма ПМ
    public static final int AK_AMMO = 30;         //обойма АК
    public static final int P_SPEED = 5;          //скорость игрока
    public static final int Z_SPEED = 3;          //скорость зомби
    public static final int B_SPEED = 2;          //скорость зомби босса
    public static final int PM_R = 20;            //дальность полёта пули ПМ
    public static final int AK_R = 50;            //дальность полёта пули АК
}
