package developer.controller;

import developer.dao.impl.JavaIODeveloperDAOImpl;
import developer.model.Developer;

import java.util.Collection;

/**
 * Created by denis on 04-Jul-17.
 */

public class DeveloperController {

    JavaIODeveloperDAOImpl javaIODeveloperDAO = new JavaIODeveloperDAOImpl();


    public boolean save(String saveDeveloperFromString) {
        String[] splitDeveloper = saveDeveloperFromString.split(",");

        for (int i = 0; i < splitDeveloper.length; i++) {
            splitDeveloper[i] = splitDeveloper[i].trim();
        }
        try {
            long id = Long.valueOf(splitDeveloper[0]);
            String firstName = splitDeveloper[1];
            String lastName = splitDeveloper[2];
            String specialty = splitDeveloper[3];
            double salary = Double.parseDouble(splitDeveloper[4]);
            Developer developer = new Developer(id, firstName, lastName, specialty, salary);

            return javaIODeveloperDAO.save(developer);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean remove(Long id) {
        return javaIODeveloperDAO.remove(id);
    }


    public boolean update(String saveDeveloperFromString) {
        String[] splitDeveloper = saveDeveloperFromString.split(",");

        for (int i = 0; i < splitDeveloper.length; i++) {
            splitDeveloper[i] = splitDeveloper[i].trim();
        }
        try {
            long id = Long.valueOf(splitDeveloper[0]);
            String firstName = splitDeveloper[1];
            String lastName = splitDeveloper[2];
            String specialty = splitDeveloper[3];
            double salary = Double.parseDouble(splitDeveloper[4]);
            Developer developer = new Developer(id, firstName, lastName, specialty, salary);

            return javaIODeveloperDAO.save(developer);
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public Developer getById(Long id) {
        return javaIODeveloperDAO.getById(id);
    }


    public Collection<Developer> getAll() {
        return javaIODeveloperDAO.getAll();
    }
}
