package emp.sys.dao.impl;

import emp.sys.dao.IBaseDao;
import emp.sys.utils.jdbcUtils;
import emp.sys.zhujie.Column;
import emp.sys.zhujie.ID;
import emp.sys.zhujie.tableName;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 2018-5-22.
 */
public class BaseDao<T> implements IBaseDao {
    public Class clazz;
    public String tblName;
    public String tblId;

    public BaseDao() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        Type[] types = pt.getActualTypeArguments();
        clazz = (Class<T>) types[0];
        tableName tn = (tableName) clazz.getAnnotation(tableName.class);
        tblName = tn.value();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            // 设置强制访问
            f.setAccessible(true);
            ID id = f.getAnnotation(ID.class);
            if (id != null) {
                Column clmn = f.getAnnotation(Column.class);
                tblId = clmn.ColnumName();
                break;
            }
        }
        System.out.println(tblName);
        System.out.println(tblId);
    }

    @Override
    public boolean Add(Object o) {
//        String sql="insert into "+tableName+"("+""+") values";
//        return jdbcUtils.GetDataSource().query(sql,new BeanHandler<T>(clazz));
        return false;
    }

    @Override
    public boolean Delete(long id) {
        String sql = "delete from " + tblName + " where " + tblId + "=@id";
        try {
            jdbcUtils.GetDataSource().query(sql, new BeanHandler<T>(clazz), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public boolean Update(Object o) {

        return false;
    }

    @Override
    public T Get(long id) {
        String sql = "select * from " + tblName + " where " + tblId + "=?";
        try {
            return jdbcUtils.GetDataSource().query(sql, new MyBeanHandler<T>(clazz), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    class MyBeanListHandler<T> implements ResultSetHandler<List<T>> {
        private Class<T> clazz;

        public MyBeanListHandler(Class<T> clazz) {
            this.clazz = clazz;
        }

        @Override
        public List<T> handle(ResultSet resultSet) throws SQLException {
            List<T> array = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    T t = clazz.newInstance();
                    Field[] fs = clazz.getDeclaredFields();
                    for (Field field : fs) {
                        field.setAccessible(true);
                        String colnumName = field.getAnnotation(Column.class).ColnumName();
                        Object colnukValue = resultSet.getObject(colnumName);
                        String className = field.getName();
                        BeanUtils.copyProperty(t, className, colnukValue);
                    }
                    array.add(t);
                }
                return array;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    class MyBeanHandler<T> implements ResultSetHandler<T> {
        private Class<T> clazz;

        public MyBeanHandler(Class<T> clazz) {
            this.clazz = clazz;
        }

        @Override
        public T handle(ResultSet resultSet) throws SQLException {
            try {
                T t = (T) clazz.newInstance();
                if (resultSet.next()) {

                    Field[] fields = clazz.getDeclaredFields();
                    for (Field f :
                            fields) {
                        String columnName = f.getAnnotation(Column.class).ColnumName();
                        Object value = resultSet.getObject(columnName);
                        String className = f.getName();
                        BeanUtils.setProperty(t, className, value);
                    }
                    return t;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }
}

