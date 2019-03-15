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
