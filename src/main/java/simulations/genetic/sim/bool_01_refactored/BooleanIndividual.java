package simulations.genetic.sim.bool_01_refactored;

import simulations.genetic.base.Individual;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BooleanIndividual extends Individual<BooleanGene> {

  public int score = 0;

  @Override
  public BooleanGene[] getGenes() {
    return genes;
  }

  @Override
  public String display() {
    return Arrays.stream( genes ).map( gene -> gene.display( ) ).collect( Collectors.joining() );
  }

}
