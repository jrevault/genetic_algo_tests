package simulations.genetic.sim.rabbitcat;

/**
 * A world of 100 x 100
 * predators moves randomly slowly
 * predator can smell rabbits
 * predator runs toward rabbits
 *
 */
public class Simulator {

  int WORLD_SIZE = 100;
  int PREDATORS = 10;
  int PREDATOR_WALK = 2;
  int PREDATOR_RUNS = 5;
  int PREDATOR_SENSE = 8; // ditance of smelling

  int earth[][] = new int[WORLD_SIZE][WORLD_SIZE];


  public static void run( World world ) {
    // init world with random predators
    // init world with rabbits
    // make rabbit move radomly
    // make predator move randomly
    // If predator smells a rabbit
    //    runs toward rabbit
    // If rabbit sees predator
    //    runs fast in opposite direction
    // if predator touches rabbit
    //    rabbit dies
  }
}
