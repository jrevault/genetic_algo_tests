package simulations.genetic.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Individual {

  public int score = 0;

  public List<Gene> genes;

  public Individual(){
    this.genes = new ArrayList<>();
  }

  public Individual(int genesCount){
    this.genes = new ArrayList<>(genesCount);
  }

  public void add(Gene gene) {
    genes.add( gene );
  }

  public String display() {
    return genes.stream().map( el -> el.display() ).collect( Collectors.joining() );
  }
}
