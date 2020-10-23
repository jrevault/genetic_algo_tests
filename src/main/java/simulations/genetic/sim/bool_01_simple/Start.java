package simulations.genetic.sim.bool_01_simple;

import simulations.genetic.base.Generation;

import java.util.List;

/**
 * Individual with highest genome sum wins
 * Genome is represented as a boolean and converted to an int
 */
public class Start {

  final static int POPULATION_SIZE = 100;
  final static int NUMBER_OF_SIMULATIONS = 1000;
  final static int FITNESS_GOAL = 8;

  public static void main( String[] args ) {


    int[] results = new int[NUMBER_OF_SIMULATIONS];
    for ( int i = 0 ; i < NUMBER_OF_SIMULATIONS ; i++ ) {
      BooleanGeneration generation = new BooleanGeneration( POPULATION_SIZE );
      // Generate initial world
      generation.generate();
      int generationNum = 0;
      // compute score of each individual and sort
      generation.getPopulation().sort( BooleanFitness.comparator );
      // display
//      System.out.println( generation.display( ) );
      // is fitness goal achived ?
      while ( ! goal_ok( generation )  ) {
        generation = ( BooleanGeneration ) generation.reproduce();
        // compute score of each individual and sort
        generation.getPopulation().sort( BooleanFitness.comparator );
        // display
//        System.out.println( generation.display( ) );
        generationNum ++;
      }
      // We have a perfect individual
//      System.out.println( "Simulation " + i + " took " + generationNum + " generations" );
      results[i] = generationNum;
    }

    int sum = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for ( int i = 0 ; i < results.length ; i++ ) {
      int generations = results[i];
      sum += generations;
      min = Math.min( min, generations );
      max = Math.max( max, generations );
//      System.out.println( "Simulation " + i + " took " + generations + " generations" );
    }

    System.out.println( "Average = " + (Math.round(sum/results.length)) + " generations" );
    System.out.println( "Min     = " + min + " generations" );
    System.out.println( "Max     = " + max + " generations" );

  }

  private static boolean goal_ok( Generation<BooleanIndividual> generation ) {
    List<BooleanIndividual> population = generation.getPopulation();
    for ( int i = 0 ; i < population.size(); i++ ) {
      for ( BooleanIndividual child : population) {
        if (child.score == FITNESS_GOAL) {
          return true;
        }
      }
    }
    return false;
  }



}
