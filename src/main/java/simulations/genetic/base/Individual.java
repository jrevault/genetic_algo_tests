package simulations.genetic.base;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Individual<G> {

  protected G[] genes;

  public Individual(){
  }

  public Individual(G[] genes){
    this.genes = genes;
  }

  public G[] getGenes() {
    return genes;
  }

  public void setGenes(G[] genes) {
    this.genes = genes;
  }

  public String display() {
    return Arrays.stream( genes ).map( el -> el.toString() ).collect( Collectors.joining() );
  }
}
