package UserCode.Managers;

import Framework.Interfaces.*;
import Framework.Implementations.*;
import UserCode.Fish.Bubble;
import UserCode.Fish.ISpawnable;
import UserCode.ObjectCreation.*;
import UserCode.Movement.*;
import Exceptions.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Bubble Manager
 *
 * @author Reid Giles and Marc Price
 * @version 15/103/2019
 */
public class BubbleManager implements IBubbleManager, IUpdatable
{
    private IWorld _world;
    private ISpawnable _bubble;
    private ArrayList<IUpdatable> _bubbles;
    private IUpdatableFactory _factory;
    private Random _rndGen;
    /**
     * Constructor for objects of class BubbleManager
     */
    public BubbleManager(IWorld pWorld)
    {
        _world = pWorld;
        _bubbles = new ArrayList<IUpdatable>();
        _factory = new UpdatableFactory();
        _rndGen = new Random();
    }
    
    /**
     * METHOD: Allows callers to request bubbles at their position
     *
     * @param pX A double for x cord
     * @param pY A double for y cord
     * @param pZ A double for z cord
     */
    public void spawnBubble(double pX, double pY, double pZ)
    {
        try
        {
            if (_rndGen.nextInt(60) == 1)
            {
                _bubble = new Bubble();
                _bubbles.add( (IUpdatable) _bubble);
                IMovement mind = new BubbleSwim();
                ((ISpawnable) _bubble).spawn(_world, pX, pY, pZ, 0, 90, 0);
                ((ISpawnable) _bubble).deployMind(mind);
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception: Bubble spawn failed");
        }
    }
    
    /**
     * METHOD: Remove bubbles that leave bounds and update bubbles
     *
     */
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
