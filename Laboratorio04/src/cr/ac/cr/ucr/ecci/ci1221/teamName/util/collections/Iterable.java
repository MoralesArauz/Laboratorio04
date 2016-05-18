package cr.ac.cr.ucr.ecci.ci1221.teamName.util.collections;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Interface for all collection that can be iterated.
 *
 * @param <T> the type of the elements over which the iterator will iterate.
 */
public interface Iterable<T> {

  /**
   * Returns an iterator over elements of type {@code T}.
   *
   * @return an Iterator.
   */
  Iterator<T> iterator();
}
