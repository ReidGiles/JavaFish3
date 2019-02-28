package UserCode.Fish;

import Framework.Interfaces.IDisplayObject;
import Framework.Interfaces.IWorld;
import Framework.Implementations.DisplayObject;
import UserCode.Movement.IMovement;
import UserCode.Movement.HorizontalSwim;
import Framework.Interfaces.IUpdatable;
import Exceptions.*;

/**
 * Write a description of class JavaFish here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JavaFish implements IUpdatable, ISpawnable
{
    // DECLARE an IDisplayObject to represent this Lion, call it _displayObject:
    private IDisplayObject _displayObject;
    
    // DECLARE a String to store the path to _displayObject's model, call it _model, and initialise it:
    String _model = "models/billboard/billboard.obj";
    
    // DECLARE a String to store the path to _displayObject texture, call it _texture, and initialise it:
    String _texture = "textures/javaFish/JavaFish.png";
    
    private IMovement _hSwim;
    private double _speed;
    private int _facingDirectionX;
    private double _startX;
    /**
     * Constructor for objects of class JavaFish
     */
    public JavaFish()
    {
        // INSTANTIATE _displayObject:
        _displayObject = new DisplayObject(_model, _texture, 0.3);
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
    public void spawn(IWorld world, double xPosn, double yPosn, double zPosn, double xOrientation, double yOrientation, double zOrientation) throws WorldDoesNotExistException
    {
        // SET position of Lion by translating _displayObject:
        _displayObject.translate(xPosn, yPosn, zPosn);
        
        // SET orientation of Lion by rotating _displayObject:
        _displayObject.rotate(xOrientation, yOrientation, zOrientation);
        
        // ADD to 3D world:
        world.addDisplayObject(_displayObject);
        
        _startX = xPosn;
        _hSwim = new HorizontalSwim(_displayObject, _startX);
    }
    
    public void update()
    {
        _hSwim.update();
    }
}
