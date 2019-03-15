package UserCode.Movement;
import Framework.Interfaces.IDisplayObject;
import Framework.Implementations.DisplayObject;


/**
 * The IMovement instance provides functionality to allow objects to receive x and y cords for various movement patterns, receive notification if the fish hits a boundry and update the movement
 * class with the x and y location of the method caller.
 * 
 * @author Reid Giles
 * @version 25/01/2019
 */
public interface IMovement
{
    /**
     * METHOD: Updates behaviour, driving object translation
     *
     */
    void update();
    /**
     * METHOD: Initialise the behaviour with a relevant displayObject and coordinates
     *
     * @param pDisplayObject Reference to the display object of the fish that should be controlled
     * @param pX Starting x cord of the fish that should be controlled
     * @param pY Starting y cord of the fish that should be controlled
     */
    void initialise(IDisplayObject pDisplayObject, double pX, double pY);
}
