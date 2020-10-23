package simulations.genetic.sim.bool_01_simple;

public class BooleanGene  {

  public int level;

  public BooleanGene( int level) {
    this.level = level;
  }


  public String display() {
    return "" + level;
  }
}
