package cg.utils;

public class Coord {
  public final int x;
  public final int y;

  public Coord(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Coord( Vector v) {
    this.x = (int) v.x;
    this.y = (int) v.y;
  }

  /** Euclidian distance : square root of ( x² + y² ) */
  public double distance(Coord coord) {
    return Math.sqrt(distanceSquare(coord));
  }

  /** Distance between two coords ( x² + y² ) */
  public long distanceSquare(Coord coord) {
    long dist_x = coord.x - x;
    long dist_y = coord.y - y;
    return dist_x * dist_x + dist_y * dist_y;
  }

  /** Adds the coord of the current, with the one in parameter, into a new Coord */
  public Coord add(Coord coord) {
    return new Coord(x + coord.x, y + coord.y);
  }

  /**
   * Inverse of Add method
   */
  public Coord minus(Coord coord) {
    return new Coord(x - coord.x, y - coord.y);
  }

  @Override
  public boolean equals( Object o ) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Coord t = (Coord) o;
    return (t.x == this.x && t.y == this.y);
  }

  @Override
  public int hashCode() {
    {
      int hashCode = 0;
      hashCode = (hashCode * 397) ^ this.x;
      hashCode = (hashCode * 397) ^ this.y;
      return hashCode;
    }
  }

  @Override
  public String toString() {
    return "[x:" + x + ", y:" + y + "]";
  }

}