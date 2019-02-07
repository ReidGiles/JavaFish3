package UserCode.Fish;

import Framework.Interfaces.IDisplayObject;
import Framework.Implementations.DisplayObject;
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
    private IMovement _hSwim;
    private double _speed;
    private int _facingDirectionX;        
    /**
     * Constructor for objects of class JavaFish
     */
    public JavaFish(IDisplayObject pDisplayObject)
    {
        _displayObject = pDisplayObject;
        _displayObject.translate(7,6,1);
        _displayObject.rotate(0,90,0);
        _speed = 0.05;
        _facingDirectionX = -1;
    }
    public void update()
    {
    }
}
