import java.sql.*;

public class Query01Review {

        /*
            'Class.forName("org.postgresql.Driver") ifadesi, JDBC (Java Database Connectivity) kullanırken veritabanı
            sürücüsünü yüklemek için kullanılan bir yöntemdir. Bu ifade, PostgreSQL veritabanı sürücüsünün yüklenmesini sağlar
            ve bu sayede Java programı PostgreSQL veritabanına bağlanabilir.

            JDBC, veritabanlarıyla Java programları arasında bağlantı kurmayı ve veritabanı işlemlerini gerçekleştirmeyi sağlayan bir API'dir.
            Ancak, farklı veritabanı sistemleri farklı sürücüler gerektirir. Dolayısıyla, programın çalıştığı veritabanı sistemine
            bağlı olarak uygun sürücünün yüklenmesi gerekir.

            Class.forName("org.postgresql.Driver") ifadesi, PostgreSQL veritabanı için gerekli olan sürücünün yüklenmesini sağlar.
            Bu ifade, çalışma zamanında org.postgresql.Driver adlı sınıfı yüklemeyi talep eder ve eğer sınıf bulunursa ilgili sürücü yüklenir.
         */

        /*
                Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/jdbc",
                    "postgres",
                    "My22981453."
            );

            Bu kod parçası, Java programında PostgreSQL veritabanına bağlanmak için kullanılan bir bağlantı oluşturma işlemini gerçekleştirir.

            Kod parçasında kullanılan DriverManager.getConnection() metodu, Connection nesnesi döndüren bir statik metoddur ve veritabanına bağlanmayı sağlar.
            getConnection() metodu, üç parametre alır:

            Veritabanı URL'i: "jdbc:postgresql://localhost:5432/jdbc"

            "jdbc:postgresql://": JDBC'nin PostgreSQL veritabanı için kullanılacağını belirtir.
            "localhost": PostgreSQL veritabanının çalıştığı sunucunun adresi (genellikle localhost yerine IP adresi veya sunucu adı olabilir).
            "5432": PostgreSQL veritabanının çalıştığı port numarası (varsayılan olarak 5432'dir).
            "jdbc": Veritabanının adı (örnek veritabanı adı).
            Kullanıcı adı: "postgres"

            PostgreSQL veritabanına bağlanmak için kullanılacak olan veritabanı kullanıcı adıdır. Bu örnekte "postgres" kullanıcı adı kullanılmış.
            Parola: "My22981453."

            PostgreSQL veritabanına bağlanmak için kullanılacak olan veritabanı kullanıcısının parolasıdır. Bu örnekte "My22981453." parolası kullanılmış.
            Gerçek uygulamalarda parolalar güvenlik nedenleriyle doğru şekilde saklanmalıdır.
       */

        /*
            Statement st = con.createStatement();

            Bu kod parçası, Connection nesnesi üzerinden bir Statement nesnesi oluşturmayı sağlar. Statement nesnesi, SQL ifadelerini veritabanına göndermek
            ve veritabanından sonuçları almak için kullanılır.

            con.createStatement() ifadesi, con adlı Connection nesnesi üzerinden bir Statement nesnesi oluşturur. createStatement() metodu,
            SQL ifadelerini veritabanına gönderebilmek için bir Statement nesnesi döndürür.
         */

        /*
             ResultSet veri = st.executeQuery("SELECT * FROM ogrenciler");

            Bu kod parçası, Statement nesnesi üzerinden veritabanında bir SQL sorgusu çalıştırarak bir ResultSet nesnesi elde etmeyi sağlar.
            ResultSet, veritabanı sorgusunun sonuç kümesini temsil eder ve bu sonuç kümesindeki verilere erişim sağlar.

            st.executeQuery("SELECT * FROM ogrenciler") ifadesi, st adlı Statement nesnesi üzerinden "SELECT * FROM ogrenciler" SQL sorgusunu çalıştırır
            ve sonuçları
         */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        // PostgreSQL sürücüsünü yükle
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
        ResultSet veri = st.executeQuery("SELECT * FROM ogrenciler");

        System.out.println("ID    Ad Soyad            Sınıf  Cinsiyet");
        System.out.println("---------------------------------------");
        while (veri.next()) {
            int id = veri.getInt(1);
            String adSoyad = veri.getString(2);
            String sinif = veri.getString(3);
            String cinsiyet = veri.getString(4);

            System.out.printf("%-5d %-20s %-5s %-5s%n", id, adSoyad, sinif, cinsiyet);
        }

        // Bağlantıyı kapat
        veri.close();
        st.close();
        con.close();

    }
}
