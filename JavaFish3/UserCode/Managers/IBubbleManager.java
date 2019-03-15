package UserCode.Managers;


/**
 * Write a description of interface IBubbleManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IBubbleManager
{
    /**
     * METHOD: Remove bubbles that leave bounds and update bubbles
     *
     */
    void update();
    /**
     * METHOD: Allows callers to request bubbles at their position
     *
     * @param pX A double for x cord
     * @param pY A double for y cord
     * @param pZ A double for z cord
     */
    void spawnBubble(double pX, double pY, double pZ);
}
