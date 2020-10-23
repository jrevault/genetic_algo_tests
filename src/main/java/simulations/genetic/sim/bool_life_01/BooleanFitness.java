package simulations.genetic.sim.bool_life_01;

import simulations.genetic.base.Individual;

import java.util.Comparator;

/**
 * Fitness is :
 * As 8 bits is min 0 and max 255, keep only individuals with genes between 2 numbers
 */
public class BooleanFitness {

  // Sort is useless in this scenario but nice for outputs
  static Comparator<Individual> comparator = ( s1 , s2 ) -> {
    return  compute( ( BooleanIndividual ) s2 ) - compute( ( BooleanIndividual ) s1 );
  };


  // just the sum of the genes
  private static int compute( BooleanIndividual individual ) {
    String binaryString = "";
    for( Boolean gene : individual.getGenes()) {
      binaryString += gene? "1" : "0";
    }
    individual.score = Integer.parseInt(binaryString,2);
    return individual.score;
  }


}
