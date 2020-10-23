package simulations.genetic.sim.bool_life_01;

import simulations.genetic.base.Generation;

import java.util.Iterator;

/**
 * Individual with highest genome sum wins
 * Genome is represented as a boolean and converted to an int
 */
public class Start {

  final static int POPULATION_SIZE = 1000;
  final static int NUMBER_OF_SIMULATIONS = 1000;

  final static int FITNESS_FLOOR = 180; // included
  final static int FITNESS_CEIL = 200; // excluded

  public static void main( String[] args ) {

    // Result is [simulation][generations][goal] with goal dead or alive
    int[] r_generation = new int[NUMBER_OF_SIMULATIONS];
    int[] r_goal = new int[NUMBER_OF_SIMULATIONS];

    for ( int i = 0 ; i < NUMBER_OF_SIMULATIONS ; i++ ) {
      Generation<BooleanIndividual> generation = new BooleanGeneration( POPULATION_SIZE );
      // Generate initial world
      generation.generate( );
      int generationNum = 0;
      // compute score of each individual and sort
      generation.getPopulation( ).sort( BooleanFitness.comparator );
      // display
      //System.out.println( generation.display( ) );
      // is fitness goal achieved ?
      int goal = goal_ok( generation );
//      System.out.println( "Population left " + generation.getPopulation( ).size() );

      while ( goal == 2 ) {
        generation = generation.reproduce( );
        // compute score of each individual and sort
        generation.getPopulation( ).sort( BooleanFitness.comparator );
        // display
        //System.out.println( generation.display( ) );
        goal = goal_ok( generation );
        generationNum++;
      }

//      System.out.print( "Simulation over after " + generationNum + " generations : ");
//      switch ( goal ) {
//        case 0: System.out.println( "All dead" ); break;
//        case 1: System.out.println( "All alive" ); break;
//      }
      r_generation[i] = generationNum;
      r_goal[i] = goal;
    }

    int sum_gen = 0;
    int sum_dead = 0;
    int sum_alive = 0;
    for ( int i = 0 ; i < r_generation.length ; i++ ) {
      int generations = r_generation[i];
      sum_gen += generations;
      int goal = r_goal[i];
      switch ( goal ) {
        case 0: sum_dead++; break;
        case 1: sum_alive++; break;
      }
    }

    System.out.println( "Ran " + NUMBER_OF_SIMULATIONS + " simulations" );
    System.out.println( "Average = " + (Math.round(sum_gen/r_generation.length)) + " generations" );
    System.out.println( "Dead    = " + sum_dead + " generations" );
    System.out.println( "Alive   = " + sum_alive + " generations" );

  }

  /**
   * @return 1 if all survived
   * 0 if all dead or only 1 left (can't reproduce)
   * 2 otherwise
   */
  private static int goal_ok( Generation<BooleanIndividual> generation ) {
    int initialPopulation = generation.getPopulation( ).size( );
    Iterator<BooleanIndividual> population = generation.getPopulation( ).iterator( );
    while ( population.hasNext( ) ) {
      BooleanIndividual individual = population.next( );
      if ( individual.score < FITNESS_FLOOR || individual.score >= FITNESS_CEIL ) {
        // Kill individual
        population.remove( );
      }
    }
    int finalPopulation = generation.getPopulation( ).size( );
    generation.setSize( finalPopulation );
    if ( initialPopulation == finalPopulation ) {
      return 1;
    }
    else if ( finalPopulation <= 1 ) {
      return 0;
    }
    else {
      return 2;
    }
  }

}
