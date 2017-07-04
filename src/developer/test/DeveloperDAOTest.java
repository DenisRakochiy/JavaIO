package developer.test;

import developer.dao.DeveloperDAO;
import developer.dao.impl.JavaIODeveloperDAOImpl;

/**
 * Created by denis on 03-Jul-17.
 */

public class DeveloperDAOTest {
    public static void main(String[] args) {
        DeveloperDAO developerDAO = new JavaIODeveloperDAOImpl();

//        Developer developer = new Developer();
//        developer.setId(12L);
//        developer.setFirstName("Nikolay");
//        developer.setLastName("AEsdafsdf");
//        developer.setSpecialty("PHP developer");
//        developer.setSalary(5_000.0);
//        developerDAO.save(developer);


        System.out.println(developerDAO.getById(12L));


//        System.out.println(developerDAO.getAll());


//        developerDAO.remove(13L);

    }
}
