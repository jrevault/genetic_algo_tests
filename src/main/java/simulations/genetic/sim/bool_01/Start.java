package simulations.genetic.sim.bool_01;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Individual with highest genome sum wins
 */
public class Start {

  final static int POPULATION_SIZE = 8;
  final static int GENOME_SIZE = 8;
  final static int FITNESS_GOAL = 8;

  public static void main( String[] args ) {

    World world = null;
    int generation = 0;
    do {
      generation ++;
      // Generate initial world
      world = new_generation( world );
      // compute score of each individual and sort
      world.population.sort( fitnessComparator );
      // display
      System.out.println( world.display( ) );
    }
    // is fitness goal achived ?
    while ( goal_ok( world ) == false  );

    // We have a perfect individual
    System.out.println("Took " + generation + " generations" );
  }

  static boolean goal_ok( World world ) {
    for ( int i = 0 ; i < world.population.size(); i++ ) {
      for ( Individual child : world.population) {
        if (child.score == FITNESS_GOAL) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Initial generation
   */
  static World new_generation() {
    return new_generation( null );
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
      mutation( pop_child );
      return pop_child;
    }
  }

  /**
   * Only the best reproduces
   * Last are randoms
   */
  private static World reproduction( World pop_parent ) {
    World pop_child = new World( POPULATION_SIZE );
    pop_child.add( pop_parent.population.get( 0 ) ); // Keep first (some kind of parthenogenese yess..)
    pop_child.add( cross_over( pop_parent.population.get( 0 ), pop_parent.population.get( 1 ) ) ); // Cross best characteristics
    pop_child.add( cross_over( pop_parent.population.get( 0 ), pop_parent.population.get( 2 ) ) ); // Cross best characteristics
    pop_child.add( cross_over( pop_parent.population.get( 1 ), pop_parent.population.get( 2 ) ) ); // Cross best characteristics
    // Generate only the remaining
    for ( int i = pop_child.population.size() ; i < POPULATION_SIZE ; i++ ) {
      pop_child.add( generate_individual());
    }
    return pop_child;
  }

  /**
   * Simple cross over take half booleanGenes from each
   */
  static Individual cross_over( Individual parent_1, Individual parent_2) {
    Individual crossed = new Individual();
    for ( int i = 0 ; i < GENOME_SIZE ; i++ ) {
      if (i < Math.round( GENOME_SIZE / 2 )) {
        crossed.genes.add( parent_1.genes.get( i ) );
      }
      else {
        crossed.genes.add( parent_2.genes.get( i ) );
      }
    }
    return crossed;
  }

  /**
   * For each individual change 1 gene
   */
  static void mutation( World world ) {
    for ( int i = 0 ; i < world.population.size(); i++ ) {
      for ( Individual child : world.population) {
        // Mutate 1 gene
        Gene gene = child.genes.get( ThreadLocalRandom.current().nextInt(0, child.genes.size()) );
        if (gene.level == 0) {
          gene.level = 1;
        }
        else {
          gene.level = 0;
        }
      }
    }
  }

  static Comparator<Individual> fitnessComparator = new Comparator<Individual>() {
    @Override
    public int compare( Individual s1 , Individual s2 ) {
      compute_fitness(s2);
      compute_fitness(s1);
      return  s2.score - s1.score;
    }
  };


  public static int compute_fitness( Individual individual) {
    int score = 0;
    for( Gene gene : individual.genes) {
      score += gene.level;
    }
    individual.score = score;
    return score;
  }

  public static Individual generate_individual() {
    Individual individu = new Individual( GENOME_SIZE );
    for ( int i = 0 ; i < GENOME_SIZE ; i++ ) {
      individu.add( new Gene(Math.random() >= 0.5 ? 1:0));
    }
    return individu;
  }

//  public static BooleanGeneration generate_population(long duration) {
//    long end = System.currentTimeMillis() + duration;
//    BooleanGeneration population = new BooleanGeneration();
//    while ( System.currentTimeMillis() < end ) {
//      population.add(generate_individual());
//    }
//    return population;
//  }

  public static World generate_population( int counter) {
    World world = new World();
    for ( int i = 0 ; i < counter ; i++ ) {
      world.add(generate_individual());
    }
    return world;
  }
}
