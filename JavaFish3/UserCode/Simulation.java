
package UserCode;
///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////
import env3d.Env;
import Framework.Interfaces.*;
import Framework.Implementations.*;
import Exceptions.*;
import RandomGen.*;
import UserCode.Fish.*;
import UserCode.Movement.*;
import UserCode.ObjectCreation.*;
import UserCode.Managers.*;
import UserCode.InputHandling.*;
import java.util.ArrayList;

/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * @author (your name here!) and Marc Price
 * @version 0.6
 */
public class Simulation implements IInputListener
{
    // instance variables:
    // DECLARE a reference to the IWorld, call it '_world':
    private IWorld _world;
    
    // DECLARE a reference to the IInput, call it '_input':
    private IInput _input;
    
    // DECLARE a reference to the IInputPublisher, call it '_inputPublisher':
    private IInputPublisher _inputPublisher;
        
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;
    
    private boolean _newFishFood = false;
    
    //DECLARE an ArrayList of type IFish, call it '_iFish':
    private ArrayList<IUpdatable> _updatables;
    
    //DECLARE an ArrayList of type IDisplayObject, call it '_displayObjects':
    private ArrayList<IDisplayObject> _displayObjects;     
    
    private IDisplayObject _displayObject;
    
    // DECLARE an int, call it '_javaFishSpawn':
    private int _javaFishSpawn;
    
    // DECLARE an int, call it '_orangeFishSpawn':
    private int _orangeFishSpawn;
    
    // DECLARE a reference to an IUpdatableFactory, call it '_factory':
    private IUpdatableFactory _factory;
    
    // DECLARE a reference to an IRandomStart, call it '_rndStart':
    private IRandomStart _rndStart;
    
    // DECLARE an int array, to store any mouse input to, initialise it to {-1,-1}, call it _mouseVal:
    private int[] _mouseVal = {-1,-1};
    
    BubbleManager _bubbleManager;
    
    /**
     * Constructor for objects of class Simulation
     */
    public Simulation()
    {
        // INITIALISE instance variables:
        // _factory
        _factory = new UpdatableFactory();
        
        // _updatables:
        _updatables = new ArrayList<IUpdatable>();
        try
        {
            // _world:
            _world = new Core();
            
            // _bubbleManager:
            _bubbleManager = new BubbleManager(_world);
            
            // _input:
            _input = (IInput) _world;
            
            // _inputPublisher:
            // (INSTANTIATE):
            _inputPublisher = ((IInputPublisher) _factory.create(MouseHandler.class));
            
            // (INITIALISE):
            _inputPublisher.Initialise(_input);
        }
        catch (Exception e)
        {
        }
        // ADD _inputPublisher implementation to _updatables:
        _updatables.add((IUpdatable) _inputPublisher);
        
        _updatables.add((IUpdatable) _bubbleManager);
        
        // SUBSCRIBE this as listener to _inputPublisher:
        _inputPublisher.subscribe(this);
        
        // _displayObjects:
        _displayObjects = new ArrayList<IDisplayObject>();
        
        // INITIALISE _javaFishSpawn:
        _javaFishSpawn = 2;
        
        // INITIALISE _orangeFishSpawn:
        _orangeFishSpawn = 2;
        
        // INITIALISE _rndStart:
        _rndStart = new RandomGen();
    }
    
    /**
     * METHOD: Main
     *
     */
    public static void main()
    {
        Simulation sim = new Simulation();
        // Call the populate() method, spawns fish into the environment:
        sim.populate();
        sim.run();
    }
    
    public void populate()
    {
        for (int i=0; i<_javaFishSpawn; i++)
        {
            try
            {
                IUpdatable javaFish = _factory.create(JavaFish.class);
                _updatables.add(javaFish);
            }
            catch (Exception e)
            {
                System.out.println("Fail");
            }
        }
        for (int i=0; i<_orangeFishSpawn; i++)
        {
            try
            {
                IUpdatable orangeFish = _factory.create(OrangeFish.class);
                _updatables.add(orangeFish);
            }
            catch (Exception e)
            {
                System.out.println("Fail");
            }
        }
        
    }
    
    /**
     * METHOD: handle an input event
     * 
     * @param data an array of integers containing the input data
     * 
     */
    public void onInput(int ...data)
    {
        // SET _newLion to flag that a new lion needs to be spawned:
        _newFishFood = true;
        
        // SET _mouseVal to data:
        _mouseVal = data;
    }

    /**
     * METHOD: Run the simulation loop.  User presses escape to exit.
     *
     */
    public void run()
    {
        // Create the 3D world:
        _world.create();
        
        // User try - catch to ensure 3D world was successfully created:
        try
        {
            // ADD Objects to 3D world?:
            // Add each updatable in updatable to the aquarium:
            for (IUpdatable updatable : _updatables)
            {
                if (updatable instanceof JavaFish)
                {
                    IMovement mind = new HorizontalSwim(_bubbleManager);
                    ((ISpawnable) updatable).spawn(_world, _rndStart.setLocation()[0], _rndStart.setLocation()[1], 1, 0, 90, 0, mind);
                }
                if (updatable instanceof OrangeFish)
                {
                    IMovement mind = new HorizontalSwim();
                    ((ISpawnable) updatable).spawn(_world, _rndStart.setLocation()[0], _rndStart.setLocation()[1], 1, 0, 90, 0, mind);
                }
            }
            _bubbleManager.spawnBubble(2,5,1);
            // Start simulation loop:
            while (!endSim)
            {
                // UPDATE STAGE:
                // IF: user has requested simulation loop exit (ie escape pressed):
                if (_input.getKey() == 1)
                {
                    // SET: render loop exit condition
                    endSim = true;
                }
                
                // ADD fish food when requested via mouse input...                
                // CHECK if a new fish food has been requested:
                if (_newFishFood)
                {
                    // RESET _newFishFood to false:
                    _newFishFood = false;
                    
                    // COMPUTE the position/orientation for the new fish food from mouseVal:
                    Double posn[] = {_mouseVal[0]*0.0077, _mouseVal[1]*0.0077, 1.0};
                    Double angle[]= {0.0,90.0,0.0};
                    try
                    {
                        // INSTANTIATE the new fish food as an IUpdatable, call it 'lion':
                        IUpdatable fishFood = _factory.create(FishFood.class);
                        
                        // ADD fish food to _updatables:
                        _updatables.add(fishFood);
                        
                        // SPAWN fish food in 3D world:
                        IMovement mind = new Sink();
                        ((ISpawnable) fishFood).spawn(_world, posn[0], posn[1], posn[2], angle[0], angle[1], angle[2], mind);
                    }
                    catch (Exception e)
                    {
                        // do nothing
                    }        
                }
                        
                // UPDATE Objects in 3D world:
                for (IUpdatable updatable : _updatables)
                {
                    updatable.update();
                }
                // UPDATE 3D World:
                _world.update();
            }
        
            // EXIT: cleanly by closing-down the environment:
            _world.destroy();
        }
        catch (WorldDoesNotExistException e)
        {
            System.out.println(e.getMessage());
        }

    }

}
