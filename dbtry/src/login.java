import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @program: OJhomework
 * @description
 * @author: 李星泽
 * @create: 2021-04-07 18:35
 **/
public class login {

    ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    private String dbDriver = bundle.getString("dbDriver");
    private String dbUrl = bundle.getString("dbUrl");
    private String dbUser = bundle.getString("dbUser");
    private String dbPassword = bundle.getString("dbPass");

    public Connection getConnect() {
        Connection connection = null;
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int creatAccount(String accountNumber, String Password) {
        int number = 0;
        String sql = "insert into person values (?,?)";
        Connection connection = getConnect();
        if (connection == null) {
            System.out.println("连接器获取失败");
            return 0;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setString(2, Password);
            number = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return number;
    }

    public int deleteAccount(String accountNumber, String Password) {
        int number = 0;
        String sql = "delete from person where accountName = ? and password = ?";
        Connection connection = getConnect();
        if (connection == null) {
            System.out.println("连接器获取失败");
            return 0;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setString(2, Password);
            number = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return number;
    }

    public int changePass(String accountNumber, String Password) {
        int number = 0;
        String sql = "update person set password = ? where accountName = ?";
        Connection connection = getConnect();
        if (connection == null) {
            System.out.println("连接器获取失败");
            return 0;
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.setString(1, Password);
            number = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return number;
    }

    public static void main(String[] args) {
        login login = new login();
        Scanner in = new Scanner(System.in);
        String password = in.next();
        String accountName = in.next();
        int ifsuccess = login.deleteAccount(accountName, password);
        if (ifsuccess == 1) System.out.println("修改成功");
        else System.out.println("未修改成功");

    }

}

class person {
    private String password;
    private String accountName;

    public person(String password, String accountName) {
        this.password = password;
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "person{" +
                "password='" + password + '\'' +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}
