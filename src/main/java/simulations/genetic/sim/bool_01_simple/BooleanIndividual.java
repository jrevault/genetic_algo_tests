package simulations.genetic.sim.bool_01_simple;

import simulations.genetic.base.Individual;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BooleanIndividual extends Individual<Boolean> {

  public int score = 0;

  public Boolean[] getGenes() {
    return genes;
  }

  @Override
  public String display() {
    return Arrays.stream( genes ).map( el -> el == true ? "1" : "0" ).collect( Collectors.joining() );
  }

}
