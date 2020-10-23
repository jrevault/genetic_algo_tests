package simulations.genetic.sim.bool_01_simple;

import simulations.genetic.base.Individual;

import java.util.Comparator;

/**
 * Fitness is :
 * Sum of the boolean genes
 */
public class BooleanFitness {

  static Comparator<Individual> comparator = ( s1 , s2 ) -> {
    return  compute( ( BooleanIndividual ) s2 ) - compute( ( BooleanIndividual ) s1 );
  };


  // just the sum of the genes
  private static int compute( BooleanIndividual individual ) {
    String binaryString = "";
    for( Boolean gene : individual.getGenes()) {
      binaryString += gene ? "1" : "0";
    }
    individual.score = Integer.parseInt(binaryString,2);
    return individual.score;
  }


}
