Based on bool_01_refactored

Population
- 8 bits genes
Fitness
- only the population with genes sum > 20 && < 55 is selected for reproduction

At each generation a predator kills individuals that does not pass fitness
Reproduction 
- done randomly between the survivors in order to keep existing population of previous generation
- child gets the 4 MSB from parent 1 and 4 LSB from parent 2

End of simulation once all individuals of a generation are alive or dead (can take a while) 
