package developer.dao.impl;

import developer.dao.DeveloperDAO;
import developer.model.Developer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by denis on 03-Jul-17.
 */

public class JavaIODeveloperDAOImpl implements DeveloperDAO {

    private File file = new File("C:\\Users\\denis\\IdeaProjects\\JavaIO\\src\\developer\\Developer.dat");

    @Override
    public boolean save(Developer developer) {

        List<Developer> developers = (List<Developer>) getAll();

        for (Developer currentDeveloper : developers) {
            if (currentDeveloper.getId() == developer.getId()) {
                currentDeveloper.setFirstName(developer.getFirstName());
                currentDeveloper.setLastName(developer.getLastName());
                currentDeveloper.setSpecialty(developer.getSpecialty());
                currentDeveloper.setSalary(developer.getSalary());
                return collectionToFile(developers);
            }
        }
        System.out.println(developer + " successfully saved.");
        developers.add(developer);
        return collectionToFile(developers);
    }

    @Override
    public boolean remove(Long id) {
        List<Developer> developers = (List<Developer>) getAll();

        return developers.removeIf(developer -> developer.getId() == id) && collectionToFile(developers);
    }

    private boolean collectionToFile(List<Developer> developers) {
        try (FileWriter fw = new FileWriter(file, false)) {
            for (Developer developer : developers) {
                fw.write(developer.getId() + "," +
                        developer.getFirstName() + "," +
                        developer.getLastName() + "," +
                        developer.getSpecialty() + "," +
                        developer.getSalary() +
                        System.lineSeparator());
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Developer developer) {

        if (developer.getId() == null) {
            System.out.println("Developer not found...");
        } else {
            remove(developer.getId());
            save(developer);
        }
        return false;
    }

    @Override
    public Developer getById(Long id) {
        Developer developer = new Developer();

        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String buffer;

            while ((buffer = bufferedReader.readLine()) != null) {
                if (buffer.isEmpty()) {
                    continue;
                }

                String[] arrayOfSplitDeveloper = buffer.split(",");
                if ((Long.parseLong(arrayOfSplitDeveloper[0])) == id) {
                    developer.setId(Long.parseLong(arrayOfSplitDeveloper[0]));
                    developer.setFirstName(arrayOfSplitDeveloper[1]);
                    developer.setLastName(arrayOfSplitDeveloper[2]);
                    developer.setSpecialty(arrayOfSplitDeveloper[3]);
                    developer.setSalary(Double.parseDouble(arrayOfSplitDeveloper[4]));
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public Collection<Developer> getAll() {
        List<Developer> developers = new ArrayList<>();

        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String buffer;

            while ((buffer = bufferedReader.readLine()) != null) {
                if (buffer.isEmpty()) {
                    continue;
                }
                Developer tempDeveloper = new Developer();

                String[] arrayOfSplitDeveloper = buffer.split(",");

                tempDeveloper.setId(Long.parseLong(arrayOfSplitDeveloper[0]));
                tempDeveloper.setFirstName(arrayOfSplitDeveloper[1]);
                tempDeveloper.setLastName(arrayOfSplitDeveloper[2]);
                tempDeveloper.setSpecialty(arrayOfSplitDeveloper[3]);
                tempDeveloper.setSalary(Double.parseDouble(arrayOfSplitDeveloper[4]));

                developers.add(tempDeveloper);
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return developers;
    }
}
