package simulations.genetic.sim.bool_01_refactored;

import simulations.genetic.base.Gene;

public class BooleanGene implements Gene {

  public int level;

  public BooleanGene( int level) {
    this.level = level;
  }


  public String display() {
    return "" + level;
  }
}
