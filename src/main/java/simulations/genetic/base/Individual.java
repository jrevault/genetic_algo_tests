package simulations.genetic.base;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Individual<T> {

  protected T[] genes;

  public Individual(){
  }

  public Individual(T[] genes){
    this.genes = genes;
  }

  public T[] getGenes() {
    return genes;
  }

  public void setGenes(T[] genes) {
    this.genes = genes;
  }

  public String display() {
    return Arrays.stream( genes ).map( el -> el.toString() ).collect( Collectors.joining() );
  }
}
