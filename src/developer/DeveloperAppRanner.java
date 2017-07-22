package developer;


import developer.view.DeveloperView;
import javafx.beans.binding.When;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by denis on 03-Jul-17.
 */

public class DeveloperAppRanner {

    public static Long insertID(BufferedReader bufferedReader) throws IOException {
        System.out.print("Please enter ID... ");
        while (true) {
            String id = bufferedReader.readLine();
            try {
                return Long.valueOf(id);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input, please try again!");
            }
        }
    }

    public static String insertDeveloper(BufferedReader bufferedReader) throws IOException {
        System.out.println("Please enter Developer");
        String stringDeveloper = bufferedReader.readLine();
        return stringDeveloper;
    }

    public static void main(String[] args) {
        DeveloperView developerView = new DeveloperView();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String query;
            while (true){
                developerView.showMenu();
                query = bufferedReader.readLine();
                switch (query){
                    case "1":
                        developerView.save(insertDeveloper(bufferedReader));
                        break;
                    case "2":
                        developerView.getById(insertID(bufferedReader));
                        break;
                    case "3":
                        developerView.update(insertDeveloper(bufferedReader));
                        break;
                    case "4":
                        developerView.remove(insertID(bufferedReader));
                        break;
                    case "5":
                        developerView.getAll();
                        break;
                    case "exit":
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
