package test.java.server;

public class Actor
{
	private boolean visible;
    protected int x;
    protected int y;
    protected boolean dying;
    protected int hp;
    
    public Actor()
    { 
        visible = true;
    }
    public void die()
    {  
        visible = false;
    }
    public boolean isVisible()
    {
        return visible;
    }
    protected void setVisible(boolean visible)
    {        
        this.visible = visible;
    }
    public void setX(int x)
    {  
        this.x = x;
    }
    public void setY(int y)
    { 
        this.y = y;
    }
    public int getY()
    {    
        return y;
    }
    public int getX()
    {   
        return x;
    }
    public void setDying(boolean dying)
    {
        this.dying = dying;
    }
    public boolean isDying()
    {    
        return this.dying;
    }
}
