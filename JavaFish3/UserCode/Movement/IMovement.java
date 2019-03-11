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
    void update();
    void initialise(IDisplayObject pDisplayObject, double pX, double pY);
}
