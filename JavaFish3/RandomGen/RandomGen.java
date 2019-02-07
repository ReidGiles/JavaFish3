package RandomGen;

import java.util.Random;

/**
 * Write a description of class RandomGen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RandomGen implements IRandomStart
{
    private Random _rndGen;
    private double _speed;
    private double _randomLow;
    private double _randomHigh;
    private double _randomLocationX;
    private double _randomLocationY;
    /**
     * Constructor for objects of class RandomGen
     */
    public RandomGen()
    {
        _rndGen = new Random();
    }
    
    public double setSpeed()
    {
        // SET _randomLow to 0.005:
        _randomLow = 0.005;
        // SET _randomHigh to 0.05:
        _randomHigh = 0.05;
        // SET speed to a random number between _randomHigh and _randomLow.:
        _speed = _randomLow + (_randomHigh - _randomLow) * _rndGen.nextDouble();
        // Return _speed:
        return _speed;
    }
    
    public double[] setLocation()
    {
        // SET _randomLocationX to a number between 1 and 10:
        _randomLocationX = (_rndGen.nextInt(9) + 1);
        // SET _randomLocationY to number between 1 and 8:
        _randomLocationY = (_rndGen.nextInt(7) + 1);
        double[] _randomLocation = {_randomLocationX, _randomLocationY};
        return _randomLocation;
    }
    
    public int setFacingDirection()
    {
        int direction = _rndGen.nextInt(1);
        if (direction == 1)
        {
            return 1;
        }
        else return -1;
    }
}
