package UserCode.Fish;

import Framework.IDisplayObject;
import Framework.DisplayObject;

/**
 * Write a description of class OrangeFish here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrangeFish implements IFish
{
    private IDisplayObject _displayObject;
    private double _speed;
    private int _facingDirectionX; 
    /**
     * Constructor for objects of class OrangeFish
     */
    public OrangeFish()
    {
        _displayObject = new DisplayObject("models/billboard/billboard.obj", "textures/javaFish/Orange_Fish.png", 0.4);
        _displayObject.translate(7,5,1);
        _displayObject.rotate(0,90,0);
        _speed = 0.05;
        _facingDirectionX = -1;
    }
    public IDisplayObject getDisplayObject()
    {
        return _displayObject;
    }
}
