package simulations.genetic.sim.bool_life_01;

import simulations.genetic.base.Gene;

public class BooleanGene implements Gene {

  public boolean gene;

  public BooleanGene( boolean genes) {
    this.gene = genes;
  }


  public String display() {
    return gene ? "1" : "0";
  }
}
