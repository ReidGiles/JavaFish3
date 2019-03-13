package UserCode.Managers;

import Framework.Interfaces.*;
import Framework.Implementations.*;
import UserCode.Fish.Bubble;
import UserCode.Fish.ISpawnable;
import UserCode.ObjectCreation.*;
import UserCode.Movement.*;
import Exceptions.*;
import java.util.ArrayList;

/**
 * Write a description of class BubbleManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BubbleManager implements IBubbleManager, IUpdatable
{
    private IWorld _world;
    private ISpawnable _bubble;
    private ArrayList<IUpdatable> _bubbles;
    private IUpdatableFactory _factory;
    /**
     * Constructor for objects of class BubbleManager
     */
    public BubbleManager(IWorld pWorld)
    {
        _world = pWorld;
        _bubbles = new ArrayList<IUpdatable>();
        _factory = new UpdatableFactory();
    }
    
    public void spawnBubble(double pX, double pY, double pZ)
    {
        _bubble = new Bubble();
        _bubbles.add( (IUpdatable) _bubble);
        try
        {
            IMovement mind = new BubbleSwim();
            ((ISpawnable) _bubble).spawn(_world, pX, pY, pZ, 0, 90, 0, mind);
        }
        catch (Exception e)
        {
            System.out.println("Exception: Bubble spawn failed");
        }
    }
    
    public void update()
    {
        for (IUpdatable updatable : _bubbles)
        {
            try
            {
                if (( (IBoundsCheck) updatable).boundsAlert() == 1)
                {
                    ((IRemovable)updatable).remove(_world);
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            updatable.update();
        }
    }
}
