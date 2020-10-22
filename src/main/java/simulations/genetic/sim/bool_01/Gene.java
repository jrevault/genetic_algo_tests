package simulations.genetic.sim.bool_01;

public class Gene {

  public Gene(int level) {
    this.level = level;
  }

  public int level;

  public String display() {
    return "" + level;
  }
}
