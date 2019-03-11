package UserCode.Fish;

import Framework.Interfaces.IDisplayObject;
import Framework.Interfaces.IWorld;
import Framework.Implementations.DisplayObject;
import UserCode.Movement.IMovement;
import UserCode.Movement.Sink;
import Framework.Interfaces.IUpdatable;
import Exceptions.*;

/**
 * Write a description of class FishFood here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FishFood implements IUpdatable, ISpawnable
{
    // DECLARE an IDisplayObject to represent this fish food, call it _displayObject:
    private IDisplayObject _displayObject;
    
    // DECLARE a String to store the path to _displayObject's model, call it _model, and initialise it:
    String _model = "sphere";
    
    // DECLARE a String to store the path to _displayObject texture, call it _texture, and initialise it:
    String _texture = "textures/javaFish/FishFood.png";
    
    private IMovement _sink;
    private double _speed;
    private double _startX;
    private double _startY;
    /**
     * Constructor for objects of class FishFood
     */
    public FishFood()
    {
        // INSTANTIATE _displayObject:
        _displayObject = new DisplayObject(_model, _texture, 0.15);
        _speed = 0.05;
    }
    
    /**
     * METHOD: spawn the FishFood at the given position/orientation
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
        // SET position of fish food by translating _displayObject:
        _displayObject.translate(xPosn, yPosn, zPosn);
        
        // SET orientation of fish food by rotating _displayObject:
        _displayObject.rotate(xOrientation, yOrientation, zOrientation);
        
        // ADD to 3D world:
        world.addDisplayObject(_displayObject);
        
        _startX = xPosn;
        _startY = yPosn;
        _sink = pMind;
        pMind.initialise(_displayObject, _startX, _startY);
    }
    
    public void update()
    {
        _sink.update();
    }
}
