package simulations.genetic.sim.bool_life_01;

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
    StringBuilder sb = new StringBuilder( );
    for ( BooleanGene gene : genes ) {
      sb.append( gene.display() );
    }
    return "" + Integer.parseInt(sb.toString(),2);
  }

}
