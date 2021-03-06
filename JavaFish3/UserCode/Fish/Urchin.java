package UserCode.Fish;

import Framework.Interfaces.IDisplayObject;
import Framework.Interfaces.IWorld;
import Framework.Implementations.DisplayObject;
import UserCode.Movement.IMovement;
import UserCode.Movement.HorizontalSwim;
import UserCode.Managers.*;
import Framework.Interfaces.IUpdatable;
import Exceptions.*;

/**
 * Urchin Class
 *
 * @author Reid Giles and Marc Price
 * @version 15/103/2019
 */
public class Urchin implements IUpdatable, ISpawnable
{
    // DECLARE an IDisplayObject to represent this Urchin, call it _displayObject:
    private IDisplayObject _displayObject;
    
    // DECLARE a String to store the path to _displayObject's model, call it _model, and initialise it:
    String _model = "models/billboard/billboard.obj";
    
    // DECLARE a String to store the path to _displayObject texture, call it _texture, and initialise it:
    String _texture = "textures/javaFish/Urchin.png";
    
    // DECLARE an IMovement to control the fish, call it '_mind':
    private IMovement _mind;
    
    // DECLARE a double to store the fish starting x position, call it '_startX':
    private double _startX;
    
    // DECLARE a double to store the fish starting y position, call it '_startY':
    private double _startY;
    /**
     * Constructor for objects of class Urchin
     */
    public Urchin()
    {
        // INSTANTIATE _displayObject:
        _displayObject = new DisplayObject(_model, _texture, 0.25);
    }
    
    /**
     * METHOD: spawn the Urchin at the given position/orientation
     * @param world IWorld representing the 3D world.
     * @param Positionn double giving the position coordinates (x,y,z).
     * @param yPosn double giving the position along y axis.
     * @param zPosn double giving position along z axis.
     * @param xOrientation double giving the orientation about x axis.
     * @param yOrientation double giving the orientation about y axis.
     * @param zOrientation double giving orientation about z axis.
     * @param pMind IMovement giving movement behaviour.
     */
    public void spawn(IWorld world, double xPosn, double yPosn, double zPosn, double xOrientation, double yOrientation, double zOrientation) throws WorldDoesNotExistException
    {
        // SET position of Urchin by translating _displayObject:
        _displayObject.translate(xPosn, yPosn, zPosn);
        
        // SET orientation of Urchin by rotating _displayObject:
        _displayObject.rotate(xOrientation, yOrientation, zOrientation);
        
        // ADD to 3D world:
        world.addDisplayObject(_displayObject);
        
        _startX = xPosn;
        _startY = yPosn;
    }
    
    /**
     * METHOD: Sets a new mind
     *
     * @param pMind An IMind to be set
     */
    public void deployMind(IMovement pMind)
    {
        _mind = pMind;
        _mind.initialise(_displayObject, _startX, _startY);
    }
    
    /**
     * METHOD: to set the next frame of the simulation, called on each pass of the simulation
     *
     */
    public void update()
    {
        _mind.update();
    }
}
