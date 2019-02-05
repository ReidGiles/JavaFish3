package UserCode.Fish;

import Framework.IDisplayObject;
import Framework.DisplayObject;
import UserCode.Movement.IMovement;
import UserCode.Movement.HorizontalSwim;

/**
 * Write a description of class JavaFish here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JavaFish implements IFish
{
    private IDisplayObject _displayObject;
    private double _speed;
    private int _facingDirectionX;    
    private IMovement _hSwim;
    /**
     * Constructor for objects of class JavaFish
     */
    public JavaFish()
    {
        _displayObject = new DisplayObject("models/billboard/billboard.obj", "textures/javaFish/JavaFish.png", 0.4);
        _displayObject.translate(7,6,1);
        _displayObject.rotate(0,90,0);
        _speed = 0.05;
        _facingDirectionX = -1;
    }
    public IDisplayObject getDisplayObject()
    {
        return _displayObject;
    }
    public void update()
    {
    }
}
