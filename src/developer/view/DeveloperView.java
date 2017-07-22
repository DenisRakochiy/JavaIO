package developer.view;


import developer.controller.DeveloperController;
import developer.model.Developer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by denis on 04-Jul-17.
 */

public class DeveloperView {

    DeveloperController developerController = new DeveloperController();

    public void save(String saveDeveloperFromString) {
        if (developerController.save(saveDeveloperFromString)) {
            System.out.println("The developer was saved to the database.");
        } else {
            System.out.println("Can't save developer to the database!");
        }
    }

    public void remove(Long id) {
        if (developerController.remove(id)){
            System.out.println("The developer was removed from database.");
        } else {
            System.out.println("Can't remove developer from database!");
        }
    }

    public void update(String saveDeveloperFromString) {
        if (developerController.update(saveDeveloperFromString)){
            System.out.println("Developer was update successful.");
        } else {
            System.out.println("Can't update developer!");
        }
    }

    public void getById(Long id) {
        Developer developer = developerController.getById(id);
        if (developer != null){
            System.out.println(developer);
        } else{
            System.out.println("Developer with id " + id + " ot found i database!");
        }
    }

    public void getAll() {
        List<Developer> developers = (List<Developer>) developerController.getAll();
        if (developers.isEmpty()){
            System.out.println("There are not developers in database");
        } else {
            for (Developer developer : developers) {
                System.out.println(developer);
            }
        }
    }

    public void showMenu() {
        System.out.println("\n1 - create Developer;");
        System.out.println("2 - get Developers by ID;");
        System.out.println("3 - update Developer;");
        System.out.println("4 - remove Developer by ID;");
        System.out.println("5 - get all Developers;");
        System.out.println("exit - to exit.");
        System.out.println("Please, make your choice");
    }
}
