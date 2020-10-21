package simulations.genetic.rabbitcat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Individual {

  public int velocity;
  public int smell;

  public Individual(int velocity, int smell){
    this.velocity = velocity;
    this.smell = smell;
  }

//  public String display() {
//    return genes.stream().map( Gene::display ).collect( Collectors.joining() );
//  }

  public String display() {
    return "v:" + velocity + ", s: " + smell;
  }

}
