package simulations.genetic.sim.bool_01_simple;

import simulations.genetic.base.Generation;

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
  public Generation reproduce() {
    Generation pop_child = new BooleanGeneration( getSize( ) );
    pop_child.add( population.get( 0 ) ); // Keep first
    pop_child.add( cross_over( population.get( 0 ), population.get( 1 ) ) ); // Cross best characteristics
    pop_child.add( cross_over( population.get( 0 ), population.get( 2 ) ) ); // Cross best characteristics
    pop_child.add( cross_over( population.get( 1 ), population.get( 2 ) ) ); // Cross best characteristics
    // Generate only the remaining
    for ( int i = pop_child.getPopulation().size() ; i < getSize( ) ; i++ ) {
      pop_child.add( generateIndividual());
    }
    // apply  some mutations
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
      genes[i] = Math.random() >= 0.5;
    }
    individu.setGenes( genes );
    return individu;
  }

  /**
   * Simple cross over take half booleanGenes from each
   */
  private BooleanIndividual cross_over( BooleanIndividual parent_1, BooleanIndividual parent_2) {
    int geneLength = parent_1.getGenes().length;
    BooleanIndividual children = new BooleanIndividual();
    Boolean[] genes = new Boolean[geneLength];
    for ( int i = 0 ; i < geneLength ; i++ ) {
      if (i < geneLength / 2) {
        // 0 to 3
        genes[i] = parent_2.getGenes()[i];
      }
      else {
        // 4 to 7
        genes[i] = parent_1.getGenes()[i];
      }
    }
    children.setGenes( genes );
    return children;
  }

  /**
   * For each individual change 1 gene
   */
  public void mutate() {
    for ( BooleanIndividual child : population ) {
      // Mutate 1 booleanGene
      int geneNumber = ThreadLocalRandom.current( ).nextInt( 0 , child.getGenes( ).length );
      // reverting 1 gene
      child.getGenes( )[ geneNumber ] = !child.getGenes( )[ geneNumber ];
    }
  }
}
