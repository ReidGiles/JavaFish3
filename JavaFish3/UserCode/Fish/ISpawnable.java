package UserCode.Fish;

import Framework.Interfaces.IWorld;
import Exceptions.*;


/**
 * Write a description of interface ISpawnable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ISpawnable
{
    /**
     * METHOD: spawn the ISpawnable at the given position/orientation
     * @param world IWorld representing the 3D world.
     * @param xPosn double giving the position along x axis.
     * @param yPosn double giving the position along y axis.
     * @param zPosn double giving position along z axis.
     * @param xOrientation double giving the orientation about x axis.
     * @param yOrientation double giving the orientation about y axis.
     * @param zOrientation double giving orientation about z axis.
     */
    void spawn(IWorld world, double xPosn, double yPosn, double zPosn, double xOrientation, double yOrientation, double zOrientation) throws WorldDoesNotExistException;
}
