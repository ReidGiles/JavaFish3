package UserCode.ObjectCreation;

import Framework.Interfaces.IUpdatable;


/**
 * Write a description of interface IUpdatableFactory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IUpdatableFactory
{
    /**
     * Create a new IUpdatable instance and return it.
     * 
     * @param rqdClass the implementation type of IUpdatable to be instantiated
     * @return the new IUpdatable instance
     */
    <T extends IUpdatable> IUpdatable create(Class<T> rqdClass) throws Exception;
}
