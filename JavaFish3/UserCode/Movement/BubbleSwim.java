package UserCode.Movement;

import Exceptions.*;
import RandomGen.*;
import Framework.Interfaces.IDisplayObject;
import Framework.Interfaces.IBoundsCheck;
import Framework.Implementations.DisplayObject;

/**
 * Write a description of class BubbleSwim here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BubbleSwim implements IMovement, IBoundsCheck
{
    // DECLARE a double to store object x value, call it '_x':
    private double _x;
    // DECLARE a double to store object y value, call it '_y':
    private double _y;
    // DECLARE a double to store intitial speed, call it '_initialSpeed':
    private double _initialSpeed;
    // DECLARE a double to store speedX, call it '_speedX':
    private double _speedX;
    // DECLARE a double to store speedY, call it '_speedY':
    private double _speedY;
    // DECLARE an int to store _facingDirectionX, call it '_facingDirectionX':
    private int _facingDirectionX;
    // DECLARE an int to store _facingDirectionY, call it '_facingDirectionY':
    private int _facingDirectionY;
    private float _timeCounter;
    private double _rotationY;
    // DECLARE a reference to an IRandomStart, call it '_rndStart':
    private IRandomStart _rndStart;
    // DECLARE a reference to an IDisplayObject, call it '_displayObject':
    private IDisplayObject _displayObject;
    /**
     * Constructor for objects of class BubbleSwim
     */
    public BubbleSwim()
    {
        // INITIALISE _rndStart:
        _rndStart = new RandomGen();
        // INITIALISE _initialSpeed:
        _initialSpeed = 0.05;
        // INITIALISE _facingDirectionX:
        _facingDirectionX = 1;
        // INITIALISE _facingDirectionY:
        _facingDirectionY = 1;
        // INITIALISE _speedX;
        _speedX = _initialSpeed * _facingDirectionX;
        // INITIALISE _speedY:
        _speedY = _initialSpeed * _facingDirectionY;
        _rotationY = Math.cos(_timeCounter);
    }
    
    public void initialise(IDisplayObject pDisplayObject, double pX, double pY)
    {
        // INITIALISE _displayObject, set it to pDisplayObject:
        _displayObject = pDisplayObject;
        // INITIALISE _x, set it to pX:
        _x = pX;
        _y = pY;
    }
    
    /**
     * METHOD: Notifies the caller when it leaves the aquarium boundries.
     *
     * @return An int that corrosponds with the boundry that was collided with
     */
    public int boundsAlert()
    {
        if (_y > 7)
        {
            return 1;
        }
        else return 0;
    }
    
    public void update()
    {
        // Speed of rotation:
        _timeCounter += 0.15F;           
        _rotationY = Math.cos(_timeCounter);
        // Length of rotation on y axis:
        _speedY = (float)_rotationY * 0.03;
        
        _displayObject.translate(_speedY,_speedX, 0);
        boundsAlert();
        _y += _speedX;
    }
}
