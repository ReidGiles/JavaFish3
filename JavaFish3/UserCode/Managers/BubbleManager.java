package UserCode.Managers;

import Framework.Interfaces.*;
import Framework.Implementations.*;
import UserCode.Fish.Bubble;
import UserCode.Fish.ISpawnable;
import UserCode.ObjectCreation.*;
import Exceptions.*;
import java.util.ArrayList;

/**
 * Write a description of class BubbleManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BubbleManager implements IBubbleManager
{
    private IWorld _world;
    private ISpawnable _bubble;
    private ArrayList<ISpawnable> _bubbles;
    private IUpdatableFactory _factory;
    /**
     * Constructor for objects of class BubbleManager
     */
    public BubbleManager(IWorld pWorld)
    {
        _world = pWorld;
        _bubbles = new ArrayList<ISpawnable>();
        _factory = new UpdatableFactory();
    }
    
    public void spawnBubble(double pX, double pY)
    {
        _bubble = new Bubble(pX, pY);
        _bubbles.add(_bubble);
        try
        {
            _world.addDisplayObject( (IDisplayObject) _bubble);
        }
        catch (Exception e)
        {
            // Do nothing
        }
    }
    
    public void update()
    {
    }
}
