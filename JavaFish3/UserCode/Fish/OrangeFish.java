package UserCode.Fish;

import Framework.Interfaces.IDisplayObject;
import Framework.Implementations.DisplayObject;
import UserCode.Movement.IMovement;
import UserCode.Movement.HorizontalSwim;
import Framework.Interfaces.IUpdatable;

/**
 * Write a description of class OrangeFish here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrangeFish implements IUpdatable
{
    private IDisplayObject _displayObject;
    private double _speed;
    private int _facingDirectionX;
    /**
     * Constructor for objects of class OrangeFish
     */
    public OrangeFish(IDisplayObject pDisplayObject)
    {
        _displayObject = pDisplayObject;
        _displayObject.translate(7,5,1);
        _displayObject.rotate(0,90,0);
        _speed = 0.05;
        _facingDirectionX = -1;
    }
    public void update()
    {
    }
}
