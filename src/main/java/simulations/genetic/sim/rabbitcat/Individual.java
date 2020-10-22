package simulations.genetic.sim.rabbitcat;

public class Individual {

  public int velocity;
  public int smell;

  public Individual(int velocity, int smell){
    this.velocity = velocity;
    this.smell = smell;
  }

//  public String display() {
//    return booleanGenes.stream().map( BooleanGene::display ).collect( Collectors.joining() );
//  }

  public String display() {
    return "v:" + velocity + ", s: " + smell;
  }

}
