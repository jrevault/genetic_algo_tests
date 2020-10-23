package simulations.genetic.sim.bool_life_01;

import simulations.genetic.base.Individual;

public class BooleanIndividual extends Individual<Boolean> {

  public int score = 0;

  @Override
  public Boolean[] getGenes() {
    return genes;
  }

  @Override
  public String display() {
    StringBuilder sb = new StringBuilder( );
    for ( Boolean gene : genes ) {
      sb.append( gene ? "1":"0" );
    }
    return sb.toString();
  }

}
