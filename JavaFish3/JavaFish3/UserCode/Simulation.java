package UserCode;

///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////
import env3d.Env;
import Framework.*;
import Exceptions.*;
import UserCode.Fish.*;
import java.util.ArrayList;

/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * @author (your name here!) and Marc Price
 * @version 0.6
 */
public class Simulation
{
    // instance variables:
    // DECLARE a reference to the IWorld, call it '_world':
    private IWorld _world;
    
    // DECLARE a reference to the IInput, call it '_input':
    private IInput _input;
        
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;
    
    //DECLARE an ArrayList of type IDisplayObject, call it '_displayObjects':
    private ArrayList<IDisplayObject> _displayObjects;
    
    /**
     * Constructor for objects of class Simulation
     */
    public Simulation()
    {
        // INITIALISE instance variables:
        // _world:
        _world = new Core();
        
        // _input:
        _input = (IInput) _world;
        
        // _displayObjects:
        _displayObjects = new ArrayList<IDisplayObject>();
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
        //_displayObjects.add(new JavaFish());
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
            // ADD Tokens to 3D world?:
        
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
                        
                // UPDATE Objects in 3D world:
            
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
