package simulations.genetic.rabbitcat;

public class Gene {

  public int velocity;
  public int smell;

  public Gene(int velocity, int smell) {
    this.velocity = velocity;
    this.smell = smell;
  }

  public String display() {
    return "v:" + velocity + ", s: " + smell;
  }
}
