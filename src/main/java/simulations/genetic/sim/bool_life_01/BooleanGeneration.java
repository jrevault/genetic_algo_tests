package simulations.genetic.sim.bool_life_01;

import simulations.genetic.base.Generation;
import simulations.genetic.base.Individual;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class BooleanGeneration extends Generation<BooleanIndividual> {

  public BooleanGeneration( int size ) {
    super( size );
  }

  @Override
  public void generate() {
    for ( int i = 0 ; i < getSize( ) ; i++ ) {
      this.add(generateIndividual());
    }
  }

  /**
   * Only the best reproduces
   * Last are randoms
   */
  @Override
  public BooleanGeneration reproduce() {
    BooleanGeneration pop_child = new BooleanGeneration( getSize( ) );
    while (pop_child.getPopulation().size() < getSize( ) ) {
      BooleanIndividual parent_1 = getPopulation().get( ThreadLocalRandom.current().nextInt( 0 , getPopulation().size() ));
      BooleanIndividual parent_2 = getPopulation().get( ThreadLocalRandom.current().nextInt( 0 , getPopulation().size() ));
      BooleanIndividual individual = cross_over( parent_1 , parent_2 );
      pop_child.add( individual );
    }
    pop_child.mutate();
    return pop_child;
  }

  public String display() {
    int[] index = { 1 };
    return population.stream().map( el -> index[0]++ + ": " + el.display() + "\n" ).collect( Collectors.joining() );
  }


  // ********************************************
  // ********************************************

  public static BooleanIndividual generateIndividual() {
    BooleanIndividual individu = new BooleanIndividual();
    Boolean[] genes = new Boolean[8];
    for ( int i = 0 ; i < genes.length ; i++ ) {
      genes[i] = ThreadLocalRandom.current().nextBoolean();
    }
    individu.setGenes( genes );
    return individu;
  }

  /**
   * Simple cross
   * 4 MSB from parent 1, 4 LSB from parent 2
   */
  private BooleanIndividual cross_over( Individual<Boolean> parent_1, Individual<Boolean> parent_2) {
    int geneLength = parent_1.getGenes().length;
    BooleanIndividual children = new BooleanIndividual();
    Boolean[] genes = new Boolean[geneLength];
    for ( int i = 0 ; i < geneLength ; i++ ) {
      if (i < geneLength / 2) {
        genes[i] = parent_2.getGenes()[i];
      }
      else {
        genes[i] = parent_1.getGenes()[i];
      }
    }
    children.setGenes( genes );
    return children;
  }

  /**
   * For each individual change 1 gene sometimes not always
   */
  public void mutate() {
    for ( BooleanIndividual child : population ) {
      // 1/2 times mutation
      if (ThreadLocalRandom.current().nextBoolean()) {
        // Mutate 1 random gene
        int geneNumber = ThreadLocalRandom.current( ).nextInt( 0 , child.getGenes( ).length );
        child.getGenes( )[ geneNumber ] = ! child.getGenes( )[ geneNumber ];
      }
    }
  }
}
