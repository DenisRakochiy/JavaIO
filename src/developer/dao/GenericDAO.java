package developer.dao;

import developer.model.Developer;

import java.util.Collection;

/**
 * Created by denis on 03-Jul-17.
 */

public interface GenericDAO<T, ID> {

    boolean save(T entity);

    boolean remove(ID id);

    boolean update(T entity);

    T getById(ID id);

    Collection<T> getAll();
}
