import java.sql.*;

public class Query02Review {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1) Driver Tanımla
        Class.forName("org.postgresql.Driver");

        // Veritabanına bağlan
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "My22981453."
        );

        // Statement oluştur.
        Statement st = con.createStatement();

        // Veritabanından verileri çek
        String sql01 = "select country_name from countries where region_id=1";
        ResultSet veri01 = st.executeQuery(sql01);

        while (veri01.next()) {
            System.out.println(veri01.getString(1));
        }

        String sql02 = "select country_id, country_name from countries where region_id>2";
        ResultSet veri02 = st.executeQuery(sql02);

        while (veri02.next()){
            System.out.println(veri02.getString("country_id")
                    + "   " +veri02.getString("country_name"));
        }

        // Bağlantıyı kapat
        veri01.close();
        st.close();
        con.close();
        veri02.close();
    }
}
