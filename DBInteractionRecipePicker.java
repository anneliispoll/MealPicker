package mealpicker;

import java.sql.*;

public class DBInteractionRecipePicker {

    public static Connection connectToDBRecipePicker() {

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
            Statement stmt = connectToDBRecipePicker().createStatement();
            return stmt;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static boolean randomForRecipe(String season, String mealTime){
        try {
            ResultSet rs = createStatement().executeQuery("SELECT * FROM RecipePicker WHERE "+season+"=true AND  "+mealTime+"=true order by rand() limit 1");

            if(!rs.next()){
                System.out.println("********************************************");
                System.out.println("Oops! Recipe missing for these criteria.");
                System.out.println("********************************************");
            } else {
                System.out.printf("You should eat %s for "+mealTime+"", rs.getString(2));
                System.out.println();
                System.out.printf("Find the instructions: %s", rs.getURL(10));
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return false;
    }

    public static void insertData (String RecipeName, int breakfast, int lunch, int dinner, int winter, int spring, int summer, int autumn, String instructions) throws SQLException{

        String sql = "INSERT INTO RecipePicker (RecipeName, breakfast, lunch, dinner, winter, spring, summer, autumn, instructions) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connectToDBRecipePicker().prepareStatement(sql);
        stmt.setString(1, RecipeName);
        stmt.setInt(2, breakfast);
        stmt.setInt(3, lunch);
        stmt.setInt(4, dinner);
        stmt.setInt(5, winter);
        stmt.setInt(6, spring);
        stmt.setInt(7, summer);
        stmt.setInt(8, autumn);
        stmt.setString(9, instructions);

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Recipe added successfully!");
        } else {
            System.out.println("Oops! Something went wrong!");
        }
    }
}
