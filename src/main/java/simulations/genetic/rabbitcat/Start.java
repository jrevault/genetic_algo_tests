package simulations.genetic.rabbitcat;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Individual with highest genome sum wins
 */
public class Start {

  final static int POPULATION_SIZE = 20;
  final static int FITNESS_GOAL = 8;

  public static void main( String[] args ) {

    World world = null;
    int generation = 0;
    do {
      generation ++;
      // Generate initial world
      world = new_generation( world );

      // run simulation
      Simulator.run(world);
      // display
      System.out.println( world.display( ) );
    }
    // is fitness goal achived ?
    while ( ! goal_ok( world ) );

    // We have a perfect individual
    System.out.println("Took " + generation + " generations" );
  }

  /**
   * Fitness goal is keep X rabbits alive
   * @param world
   * @return
   */
  static boolean goal_ok( World world ) {
    return world.population.size() <= FITNESS_GOAL;
  }

  /**
   * All parents reproduces
   * cross_over + mutations
   */
  static World new_generation( World pop_parent) {
    if (pop_parent == null) {
      return generate_population( POPULATION_SIZE );
    }
    else {
      World pop_child = reproduction( pop_parent );
      return pop_child;
    }
  }

  /**
   * Only the best reproduces
   * Last are randoms
   */
  private static World reproduction( World pop_parent ) {
    World pop_child = new World( POPULATION_SIZE );
    // random reproduction between rabbits
    while (pop_child.population.size() < POPULATION_SIZE) {
      int i1 = ThreadLocalRandom.current().nextInt( 0 , pop_parent.population.size() );
      int i2 = ThreadLocalRandom.current().nextInt( 0 , pop_parent.population.size() );
      Individual individual = cross_over( pop_parent.population.get( i1 ) , pop_parent.population.get( i2 ) );
      mutation( individual );
      pop_child.add( individual );
    }

    // Should we generate a random part of the population ?
//    for ( int i = pop_child.population.size() ; i < POPULATION_SIZE ; i++ ) {
//      pop_child.add( generate_individual());
//    }
    return pop_child;
  }

  /**
   * Simple cross over take half genes from each
   */
  static Individual cross_over( Individual parent_1, Individual parent_2) {
    return new Individual(parent_1.velocity, parent_2.smell);
  }

  /**
   * For each individual change 1 gene
   */
  static void mutation( Individual individual ) {
    // Mutate 1 gene
    if (ThreadLocalRandom.current().nextBoolean()) {
      individual.velocity += ThreadLocalRandom.current().nextInt(-1, 2); // 1, 0 or -1)
    }
    else {
      individual.smell += ThreadLocalRandom.current().nextInt(-1, 2); // 1, 0 or -1)
    }
  }

  public static Individual generate_individual() {
    int velocity = ThreadLocalRandom.current().nextInt(1, 11);
    int smell = ThreadLocalRandom.current().nextInt(1, 11);
    return new Individual( velocity, smell );
  }


  public static World generate_population( int counter) {
    World world = new World();
    for ( int i = 0 ; i < counter ; i++ ) {
      world.add(generate_individual());
    }
    return world;
  }
}
