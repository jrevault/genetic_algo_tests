package simulations.genetic.rabbitcat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class World {

  List<Individual> population;

  public World(){
    this.population = new ArrayList<>();
  }

  public World( int size){
    this.population = new ArrayList<>(size);
  }


  public void add(Individual individual) {
    population.add( individual );
  }

  public void remove(Individual individual) {
    population.remove( individual );
  }

  public String display() {
    int[] index = { 1 };
    return population.stream().map( el -> index[0]++ + ": " + el.display() + "\n" ).collect( Collectors.joining() );
  }

}
