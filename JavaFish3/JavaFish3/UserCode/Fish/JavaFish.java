package UserCode.Fish;

import Framework.IDisplayObject;
import Framework.DisplayObject;

/**
 * Write a description of class JavaFish here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JavaFish
{
    private IDisplayObject _displayObject;
    private double _speed;
    private int _facingDirectionX;    
    /**
     * Constructor for objects of class JavaFish
     */
    public JavaFish()
    {
        _displayObject = new DisplayObject("models/billboard/billboard.obj", "textures/javaFish/JavaFish.png", 0.4);
        _speed = 0.05;
        _facingDirectionX = -1;
    }
}
