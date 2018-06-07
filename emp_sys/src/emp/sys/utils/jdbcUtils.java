package emp.sys.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/**
 * Created by zy on 2018-4-13.
 */
public class jdbcUtils {
   private static DataSource dataSource=null;
    static {
        dataSource= new ComboPooledDataSource();
    }

    public static QueryRunner GetDataSource(){
        return new QueryRunner(dataSource);
    }
}
