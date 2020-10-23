package simulations.genetic.base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Generation<T extends Individual> {

  private int size;

  protected List<T> population;

  public Generation( int size){
    this.setSize( size );
    this.population = new ArrayList<>(size);
  }

  public int getSize() {
    return size;
  }

  public void setSize( int size ) {
    this.size = size;
  }

  public String display() {
    int[] index = { 1 };
    return population.stream().map( individual -> index[0]++ + ": " + individual.display() + "\n" ).collect( Collectors.joining() );
  }

  /** Generates individuals ex-nihilo */
  public List<T> getPopulation() {
    return population;
  }

  public void add(T individual) {
    population.add( individual );
  }

  /** Generates individuals ex-nihilo */
  public abstract void generate();

  /** Reproduction between individuals (cross over, mutations..) */
  public abstract Generation reproduce();

  public abstract void mutate();

}
