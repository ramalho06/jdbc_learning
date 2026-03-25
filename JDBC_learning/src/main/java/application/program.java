package application;

import com.sun.source.tree.TryTree;
import com.sun.source.tree.WhileLoopTree;
import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class program {

    public static void main(String[] args) {

//        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Scanner sc = new Scanner(System.in);
        int rowsAffected = 0;

        try (Connection conn = DB.getConnection()) {
            System.out.println("1 - Seleção | 2 - Inserção | 3 - Atualização | 4 - Deleção: ");

            int n = sc.nextInt();
            switch (n) {

                //SELECT
                case 1:
                    st = conn.createStatement();
                    rs = st.executeQuery("SELECT * FROM department");
                    while (rs.next()) {
                        System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
                    }
                    break;

                //INSERT
                case 2:
                    ps = conn.prepareStatement(
                            "INSERT INTO seller" +
                                    "(Name, Email, BirthDate, BaseSalary, DepartmentID)" +
                                    "VALUES " +
                                    "(?, ?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
                    ps.setString(1, "Carl Purple");
                    ps.setString(2, "carl@gmail.com");
                    //Maneira legada que o curso passa
                    // -> ps.setDate(3, java.sql.Date.valueOf(LocalDate.of(1985, 4, 22)));
                    ps.setObject(3, LocalDate.of(1985, 4, 22));
                    ps.setDouble(4, 3000.0);
                    ps.setInt(5, 4);
                    rowsAffected = ps.executeUpdate();
                    if (rowsAffected > 0) {
                        rs = ps.getGeneratedKeys();
                        while (rs.next()) {
                            int id = rs.getInt(1);
                            System.out.println("Done! Id = " + id);
                        }
                    } else {
                        System.out.println("No rows affected");
                    }
                    break;
                //UPDATE
                case 3:
                    ps = conn.prepareStatement("UPDATE seller" +
                            " SET BaseSalary = BaseSalary + ? " +
                            "WHERE (DepartmentId = ?)");
                    ps.setDouble(1, 200.0);
                    ps.setInt(2, 2);
                    rowsAffected = ps.executeUpdate();
                    System.out.println("Done! Rows affected = " + rowsAffected);
                    break;
                //DELETE
                case 4:
                    try {
                        ps = conn.prepareStatement("DELETE FROM department WHERE id = ?");
                        ps.setInt(1, 5);
                        rowsAffected = ps.executeUpdate();
                        System.out.println("Done! Rows affected = " + rowsAffected);
                    }
                    catch (SQLException e){
                        throw new DbIntegrityException(e.getMessage());
                    }
                    break;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closePreparedStatment(ps);
        }

        DB.closeConnection();
    }

}
