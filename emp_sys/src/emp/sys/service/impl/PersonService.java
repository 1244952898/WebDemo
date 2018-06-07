package emp.sys.service.impl;

import emp.sys.dao.IPersonDao;
import emp.sys.dao.impl.PersonDao;
import emp.sys.entity.person;
import emp.sys.service.IPersonService;

/**
 * Created by zy on 2018-5-25.
 */
public class PersonService implements IPersonService {
    PersonDao personDao=new PersonDao();

    public person Get(long id){
        return personDao.Get(id);
    }
}
