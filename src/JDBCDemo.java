import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * JDBC代码实现
 *
 *  第一步 加载驱动
 *  第二步 获得连接
 *   第三步 执行SQL
 *   第四步 释放资源
 */

public class JDBCDemo {


    public static void main(String[] args) {

        Connection conn = null;
        // 3执行sql
        // 获得执行sql的对象
        Statement statement = null;
        // 执行sql
        ResultSet rs = null;
        try {
            // 1 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2 建立连接

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqltestdb", "root", "317713");

            statement = conn.createStatement();

            // 编写sql语句
            String s = "select * from user";
            rs = statement.executeQuery(s);

            // 遍历结果集

            while (rs.next()) {

                System.out.print(rs.getInt("id") + "\t");
                System.out.print(rs.getString("username") + "\t");
                System.out.print(rs.getString("password") + "\t");
                System.out.print(rs.getString("hobby") + "\t");
                System.out.println();

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            // 4 释放资源 (后创建的先释放)

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                rs = null;
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                statement = null;
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                conn = null;

            }

        }

    }

}