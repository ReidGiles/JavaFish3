package UserCode.Movement;


/**
 * The IMovement instance provides functionality to allow objects to receive x and y cords for various movement patterns, receive notification if the fish hits a boundry and update the movement
 * class with the x and y location of the method caller.
 * 
 * @author Reid Giles
 * @version 25/01/2019
 */
public interface IMovement
{
    // Receive x axis speed from the movement class:
    double updateX();
    // Receive y axis speed from the movement class:
    double updateY();
    // Give x a y location to the movement class:
    void updateLocation(double x, double y);
    // Determine if the display object has made contact with a screen border:
    int bounce();
}
