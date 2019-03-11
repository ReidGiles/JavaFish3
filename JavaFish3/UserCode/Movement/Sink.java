package UserCode.Movement;

import Exceptions.*;
import Framework.Interfaces.IDisplayObject;
import Framework.Implementations.DisplayObject;

/**
 * Sink is a movement behaviour returns movements values
 *
 * @author Reid Giles
 * @version 25/01/2019
 */
public class Sink implements IMovement
{
    private double _x;
    // DECLARE a double to store object y value, call it '_y':
    private double _y;
    // DECLARE a double to store speed, call it '_speed':
    private double _speed;
    // DECLARE a reference to an IDisplayObject, call it '_displayObject':
    private IDisplayObject _displayObject;
    /**
     * Sink Constructor
     *
     * @param pSpeed Passed speed
     * @param pFacingDirectionX Passed facingDirectionX
     */
    public Sink()
    {
        // INITIALISE _displayObject, set it to pDisplayObject:
        //_displayObject = pDisplayObject;
        // INITIALISE _speed, set it to a random speed (between ''):
        _speed = 0.005;
        // INITIALISE _y, set it to pY:
        //_y = pY;
    }
    
    public void initialise(IDisplayObject pDisplayObject, double pX, double pY)
    {
        // INITIALISE _displayObject, set it to pDisplayObject:
        _displayObject = pDisplayObject;
        _x = pX;
        // INITIALISE _x, set it to pX:
        _y = pY;
    }
    
    /**
     * METHOD: Notifies the caller when it leaves the aquarium boundries.
     *
     * @return An int that corrosponds with the boundry that was collided with
     */
    public void bounce()
    {
        if (_y < 0.7)
        {
            _speed = 0;
        }
    }
    
    public void update()
    {
        _displayObject.translate(0, -_speed, 0);
        bounce();
        _y -= _speed;
    }
}