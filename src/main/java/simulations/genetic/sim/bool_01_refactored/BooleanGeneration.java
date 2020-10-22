package simulations.genetic.sim.bool_01_refactored;

import simulations.genetic.base.Gene;
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
    for ( int i = 0 ; i < size ; i++ ) {
      this.add(generateIndividual());
    }
  }

  /**
   * Only the best reproduces
   * Last are randoms
   */
  @Override
  public Generation reproduce() {
    Generation pop_child = new BooleanGeneration( size );
    pop_child.add( population.get( 0 ) ); // Keep first
    pop_child.add( cross_over( population.get( 0 ), population.get( 1 ) ) ); // Cross best characteristics
    pop_child.add( cross_over( population.get( 0 ), population.get( 2 ) ) ); // Cross best characteristics
    pop_child.add( cross_over( population.get( 1 ), population.get( 2 ) ) ); // Cross best characteristics
    // Generate only the remaining
    for ( int i = pop_child.getPopulation().size() ; i < size ; i++ ) {
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
    BooleanGene[] genes = new BooleanGene[8];
    for ( int i = 0 ; i < genes.length ; i++ ) {
      genes[i] = new BooleanGene(Math.random() >= 0.5 ? 1:0);
    }
    individu.setGenes( genes );
    return individu;
  }

  /**
   * Simple cross over take half booleanGenes from each
   */
  private BooleanIndividual cross_over( Individual parent_1, Individual parent_2) {
    int geneLength = parent_1.getGenes().length;
    BooleanIndividual children = new BooleanIndividual();
    Gene[] genes = new BooleanGene[geneLength];
    for ( int i = 0 ; i < geneLength ; i++ ) {
      if (i < Math.round( geneLength / 2 )) {
        genes[i] = parent_2.getGenes()[i];
      }
      else {
        genes[i] = parent_1.getGenes()[i];
      }
    }
    children.setGenes( ( BooleanGene[] ) genes );
    return children;
  }

  /**
   * For each individual change 1 gene
   */
  public void mutate() {
    for ( int i = 0 ; i < population.size(); i++ ) {
      BooleanIndividual child = population.get( i );
      // Mutate 1 booleanGene
      int geneNumber = ThreadLocalRandom.current( ).nextInt( 0 , child.getGenes().length );
      BooleanGene booleanGene = child.getGenes()[geneNumber];
      if ( booleanGene.level == 0 ) {
        booleanGene.level = 1;
      }
      else {
        booleanGene.level = 0;
      }
    }
  }
}
