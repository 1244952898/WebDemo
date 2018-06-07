package emp.sys.dao;

/**
 * Created by zy on 2018-5-22.
 */
public interface IBaseDao<T> {
    public boolean Add(T t);
    public boolean Delete(long id);
    public boolean Update(T t);
    public T Get(long id);
}
