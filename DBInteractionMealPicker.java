package mealpicker;

import java.sql.*;

public class DBInteractionMealPicker {

    public static Connection connectToDBMealPicker() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/MealPicker", "root", "abc12345");

            return con;


        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static Statement createStatement() {
        try {
            Statement stmt = connectToDBMealPicker().createStatement();
            return stmt;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void randomForAll(String season, String mealTime){
        try {
            ResultSet rs = createStatement().executeQuery("SELECT * FROM MealPicker WHERE "+season+"=true AND  "+mealTime+"=true order by rand() limit 1");

            while (rs.next()) {
                System.out.printf("You should eat %s for "+mealTime+"", rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

