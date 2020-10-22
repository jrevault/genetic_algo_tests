package simulations.genetic.base;

/**
 * Fitness that needs to caompute the score
 */
public interface Fitness {

  public int compute( Individual individual );

}
