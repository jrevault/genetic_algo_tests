package simulations.genetic.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Individual<T extends Gene> {

  protected T[] genes;

  public Individual(){
  }

  public Individual(T[] genes){
    this.genes = genes;
  }

  public abstract T[] getGenes();

  public void setGenes(T[] genes) {
    this.genes = genes;
  }

  public abstract String display();
}
