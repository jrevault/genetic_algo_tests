package simulations.genetic.base;

public class Gene {

  public Gene(int level) {
    this.level = level;
  }

  public int level;

  public String display() {
    return "" + level;
  }
}
