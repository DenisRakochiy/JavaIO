package developer.test;

import developer.dao.DeveloperDAO;
import developer.dao.impl.JavaIODeveloperDAOImpl;
import developer.model.Developer;

/**
 * Created by denis on 03-Jul-17.
 */

public class DeveloperDAOTest {
    public static void main(String[] args) {
        DeveloperDAO developerDAO = new JavaIODeveloperDAOImpl();

        Developer developer = new Developer();
        developer.setId(7L);
        developer.setFirstName("Denis");
        developer.setLastName("Vladimirov");
        developer.setSpecialty("Java developer");
        developer.setSalary(555_000.0);
        developerDAO.save(developer);

        developer.setFirstName("Vladimir");
        developerDAO.update(developer);


        System.out.println(developerDAO.getById(7L));



        System.out.println(developerDAO.getAll());


        developerDAO.remove(7L);

    }
}
