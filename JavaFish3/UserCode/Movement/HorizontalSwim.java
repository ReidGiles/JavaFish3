package UserCode.Movement;

import Exceptions.*;
import RandomGen.*;
import UserCode.Managers.*;
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
    // DECLARE a reference to an IRandomStart, call it '_rndStart':
    private IRandomStart _rndStart;
    // DECLARE a reference to an IDisplayObject, call it '_displayObject':
    private IDisplayObject _displayObject;
    private IBubbleManager _bubbleManager;
    
    /**
     * HorizontalSwim Constructor
     *
     */
    public HorizontalSwim()
    {
        // INITIALISE _rndStart:
        _rndStart = new RandomGen();
        // INITIALISE _facingDirectionX, set it to a random direction (0 or 1):
        _facingDirectionX = _rndStart.setFacingDirection();
        // INITIALISE _speed, set it to a random speed (between ''):
        _speed = _rndStart.setSpeed();
        // Multiply speed by _facingDirectionX:
        _speed *= _facingDirectionX;
    }
    
    /**
     * HorizontalSwim Constructor
     *
     */
    public HorizontalSwim(IBubbleManager pBubbleManager)
    {
        // INITIALISE _rndStart:
        _rndStart = new RandomGen();
        // INITIALISE _facingDirectionX, set it to a random direction (0 or 1):
        _facingDirectionX = _rndStart.setFacingDirection();
        // INITIALISE _speed, set it to a random speed (between ''):
        _speed = _rndStart.setSpeed();
        // Multiply speed by _facingDirectionX:
        _speed *= _facingDirectionX;
        // INITIALISE _bubbleManager, set it to pBubbleManager:
        _bubbleManager = pBubbleManager;
    }
    
    public void initialise(IDisplayObject pDisplayObject, double pX, double pY)
    {
        // INITIALISE _displayObject, set it to pDisplayObject:
        _displayObject = pDisplayObject;
        // INITIALISE _x, set it to pX:
        _x = pX;
        _y = pY;
        // Set initial rotation based on outcome of _facingDirectionX initialisation:
        if (_facingDirectionX == 1)
        {
            _displayObject.rotate(0,180,0);
        }
    }
    
    /**
     * METHOD: Notifies the caller when it leaves the aquarium boundries.
     *
     * @return An int that corrosponds with the boundry that was collided with
     */
    public void bounce()
    {
        if (_x < 1)
        {
            _speed *= -1;
            _displayObject.rotate(0,180,0);
        }
        else if (_x > 9)
        {
            _speed *= -1;
            _displayObject.rotate(0,180,0);
        }
    }
    
    public void update()
    {
        _displayObject.translate(_speed,0, 0);
        bounce();
        _x += _speed;
        if (_bubbleManager != null)
        {
            _bubbleManager.spawnBubble(_x, _y, 1);
        }
    }
}