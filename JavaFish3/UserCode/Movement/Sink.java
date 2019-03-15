package UserCode.Movement;

import Exceptions.*;
import Framework.Interfaces.IDisplayObject;

/**
 * Sink is a movement behaviour returns movements values
 *
 * @author Reid Giles
 * @version 15/03/2019
 */
public class Sink implements IMovement
{
    // DECLARE a double to store object x value, call it '_x':
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
     */
    public Sink()
    {
        // INITIALISE _speed, set it to a random speed (between ''):
        _speed = 0.005;
    }
    
    /**
     * METHOD: Initialise the behaviour with a relevant displayObject and coordinates
     *
     * @param pDisplayObject Reference to the display object of the fish that should be controlled
     * @param pX Starting x cord of the fish that should be controlled
     * @param pY Starting y cord of the fish that should be controlled
     */
    public void initialise(IDisplayObject pDisplayObject, double pX, double pY)
    {
        // INITIALISE _displayObject, set it to pDisplayObject:
        _displayObject = pDisplayObject;
        // INITIALISE _X, set it to pX:
        _x = pX;
        // INITIALISE _Y, set it to pY:
        _y = pY;
    }
    
    /**
     * METHOD: Stops the fish food when it reaches the bottom of the aquarium
     *
     */
    public void bounce()
    {
        // If the fish food reaches the bottom of the aquarium:
        if (_y < 0.6)
        {
            // Movement stops:
            _speed = 0;
        }
    }
    
    /**
     * METHOD: Updates behaviour, driving object translation
     *
     */
    public void update()
    {
        // Move fish food through the aquarium:
        _displayObject.translate(0, -_speed, 0);
        // Check for collision with floor:
        bounce();
        // Keep track of position in aquarium:
        _y -= _speed;
    }
}