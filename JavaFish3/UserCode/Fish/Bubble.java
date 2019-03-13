package UserCode.Fish;

import Framework.Interfaces.IDisplayObject;
import Framework.Interfaces.IWorld;
import Framework.Interfaces.IBoundsCheck;
import Framework.Interfaces.IRemovable;
import Framework.Implementations.DisplayObject;
import UserCode.Movement.IMovement;
import UserCode.Movement.HorizontalSwim;
import Framework.Interfaces.IUpdatable;
import Exceptions.*;

/**
 * Write a description of class Bubble here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bubble implements IUpdatable, ISpawnable, IRemovable, IBoundsCheck
{
    // DECLARE an IDisplayObject to represent this JavaFish, call it _displayObject:
    private IDisplayObject _displayObject;
    
    // DECLARE a String to store the path to _displayObject's model, call it _model, and initialise it:
    String _model = "sphere";
    
    // DECLARE a String to store the path to _displayObject texture, call it _texture, and initialise it:
    String _texture = "textures/javaFish/Bubble.png";
    
    private IMovement _mind;
    private double _speed;
    private int _facingDirectionX;
    private double _startX;
    private double _startY;
    /**
     * Constructor for objects of class Bubble
     */
    public Bubble()
    {
        _displayObject = new DisplayObject(_model, _texture, 0.15);
        _speed = 0.05;
        _facingDirectionX = -1;
    }
    
    /**
     * METHOD: spawn the JavaFish at the given position/orientation
     * @param world IWorld representing the 3D world.
     * @param Positionn double giving the position coordinates (x,y,z).
     * @param yPosn double giving the position along y axis.
     * @param zPosn double giving position along z axis.
     * @param xOrientation double giving the orientation about x axis.
     * @param yOrientation double giving the orientation about y axis.
     * @param zOrientation double giving orientation about z axis.
     */
    public void spawn(IWorld world, double xPosn, double yPosn, double zPosn, double xOrientation, double yOrientation, double zOrientation, IMovement pMind) throws WorldDoesNotExistException
    {
        // SET position of JavaFish by translating _displayObject:
        _displayObject.translate(xPosn, yPosn, zPosn);
        
        // SET orientation of JavaFish by rotating _displayObject:
        _displayObject.rotate(xOrientation, yOrientation, zOrientation);
        
        // ADD to 3D world:
        world.addDisplayObject(_displayObject);
        
        _startX = xPosn;
        _startY = yPosn;
        //_hSwim = new HorizontalSwim(_displayObject, _startX);
        _mind = pMind;
        _mind.initialise(_displayObject, _startX, _startY);
    }
    
    public void remove(IWorld pWorld)
    {
        try
        {
            pWorld.removeDisplayObject(_displayObject);
        }
        catch (Exception e)
        {
        }
    }
    
    public int boundsAlert()
    {
        if (( (IBoundsCheck) _mind).boundsAlert() == 1 )
        {
            return 1;
        }
        else return 0;
    }
    
    public void update()
    {
        _mind.update();
    }
}
