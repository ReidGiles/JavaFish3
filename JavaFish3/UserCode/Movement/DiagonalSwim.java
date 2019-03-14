package UserCode.Movement;

import Exceptions.*;
import RandomGen.*;
import UserCode.Managers.*;
import Framework.Interfaces.IDisplayObject;
import Framework.Implementations.DisplayObject;

/**
 * DiagonalSwim is a movement behaviour returns movements values
 *
 * @author Reid Giles
 * @version 25/01/2019
 */
public class DiagonalSwim implements IMovement
{
    // DECLARE a double to store object x value, call it '_x':
    private double _x;
    // DECLARE a double to store object y value, call it '_y':
    private double _y;
    // DECLARE a double to store start speed, call it '_initialSpeed':
    private double _initialSpeed;
    // DECLARE a double to store x speed, call it '_speedX':
    private double _speedX;
    // DECLARE a double to store y speed, call it '_speedY':
    private double _speedY;
    // DECLARE an int to store _facingDirectionX, call it '_facingDirectionX':
    private int _facingDirectionX;
    // DECLARE an int to store _facingDirectionY, call it '_facingDirectionY':
    private int _facingDirectionY;
    // DECLARE a reference to an IRandomStart, call it '_rndStart':
    private IRandomStart _rndStart;
    // DECLARE a reference to an IDisplayObject, call it '_displayObject':
    private IDisplayObject _displayObject;
    private IBubbleManager _bubbleManager;
    
    /**
     * DiagonalSwim Constructor
     *
     */
    public DiagonalSwim()
    {
        // INITIALISE _rndStart:
        _rndStart = new RandomGen();
        // INITIALISE _facingDirectionX, set it to a random direction (0 or 1):
        _facingDirectionX = _rndStart.setFacingDirection();
        // INITIALISE _facingDirectionY, set it to a random direction (0 or 1):
        _facingDirectionY = _rndStart.setFacingDirection();
        // INITIALISE _initialSpeed, set it to a random speed (between ''):
        _initialSpeed = _rndStart.setSpeed();
        // INITIALISE _speedX, set it to _initialSpeed * _facingDirectionX:
        _speedX = _initialSpeed * _facingDirectionX;
        // INITIALISE _speedX, set it to _initialSpeed * _facingDirectionY:
        _speedY = _initialSpeed * _facingDirectionY;
    }
    
    /**
     * DiagonalSwim Constructor
     *
     */
    public DiagonalSwim(IBubbleManager pBubbleManager)
    {
        // INITIALISE _rndStart:
        _rndStart = new RandomGen();
        // INITIALISE _facingDirectionX, set it to a random direction (0 or 1):
        _facingDirectionX = _rndStart.setFacingDirection();
        // INITIALISE _facingDirectionY, set it to a random direction (0 or 1):
        _facingDirectionY = _rndStart.setFacingDirection();
        // INITIALISE _initialSpeed, set it to a random speed (between ''):
        _initialSpeed = _rndStart.setSpeed();
        // INITIALISE _speedX, set it to _initialSpeed * _facingDirectionX:
        _speedX = _initialSpeed * _facingDirectionX;
        // INITIALISE _speedX, set it to _initialSpeed * _facingDirectionY:
        _speedY = _initialSpeed * _facingDirectionY;
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
            _speedX *= -1;
            _displayObject.rotate(0,180,0);
        }
        if (_x > 9)
        {
            _speedX *= -1;
            _displayObject.rotate(0,180,0);
        }
        if (_y < 1)
        {
            _speedY *= -1;
        }
        if (_y > 7)
        {
            _speedY *= -1;
        }
    }
    
    public void update()
    {
        _displayObject.translate(_speedX,_speedY, 0);
        bounce();
        _x += _speedX;
        _y += _speedY;
        if (_bubbleManager != null)
        {
            _bubbleManager.spawnBubble(_x, _y, 1);
        }
    }
}