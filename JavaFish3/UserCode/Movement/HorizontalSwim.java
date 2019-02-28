package UserCode.Movement;

import Exceptions.*;
import RandomGen.*;
import Framework.Interfaces.IDisplayObject;
import Framework.Implementations.DisplayObject;

/**
 * HorizontalSwim is a movement behaviour returns movements values
 *
 * @author Reid Giles
 * @version 25/01/2019
 */
public class HorizontalSwim implements IMovement
{
    // DECLARE a double to store object x value, call it '_x':
    private double _x;
    // DECLARE a double to store object y value, call it '_y':
    private double _y;
    // DECLARE a double to store speed, call it '_speed':
    private double _speed;
    // DECLARE an int to store _facingDirectionX, call it '_facingDirectionX':
    private int _facingDirectionX;
    private IRandomStart _rndStart;
    private IDisplayObject _displayObject;
    /**
     * HorizontalSwim Constructor
     *
     * @param pSpeed Passed speed
     * @param pFacingDirectionX Passed facingDirectionX
     */
    public HorizontalSwim(IDisplayObject pDisplayObject, double pX)
    {
        // Randomise speed and facing direction
        _rndStart = new RandomGen();
        _facingDirectionX = _rndStart.setFacingDirection();
        _speed = _rndStart.setSpeed();
        _speed *= _facingDirectionX;
        _displayObject = pDisplayObject;
        _x = pX;
    }
    
    /**
     * METHOD: Notifies the caller when it leaves the aquarium boundries.
     *
     * @return An int that corrosponds with the boundry that was collided with
     */
    public void bounce()
    {
        if (_x <= 1)
        {
            _speed *= -1;
        }
        else if (_x >= 9)
        {
            _speed *= -1;
        }
    }
    
    public void update()
    {
        _displayObject.translate(_speed,0, 0);
        bounce();
        _x += _speed;
    }
}