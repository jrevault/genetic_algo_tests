package simulations.genetic.sim.bool_01_refactored;

import simulations.genetic.base.Individual;

import java.util.Comparator;

/**
 * Fitnessis :
 * Sum of the boolean genes
 */
public class BooleanFitness {

  static Comparator<Individual> comparator = ( s1 , s2 ) -> {
    return  compute( ( BooleanIndividual ) s2 ) - compute( ( BooleanIndividual ) s1 );
  };


  // just the sum of the genes
  private static int compute( BooleanIndividual individual ) {
    int score = 0;
    for(BooleanGene gene : individual.getGenes()) {
      score += gene.level;
    }
    //int decimal=Integer.parseInt(binaryString,2);
    individual.score = score;
    return score;
  }


}
