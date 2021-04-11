import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Db {

    ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
    private String dbDriver = bundle.getString("dbDriver");
    private String dbUrl = bundle.getString("dbUrl");//根据实际情况变化
    private String dbUser = bundle.getString("dbUser");
    private String dbPass = bundle.getString("dbPass");

    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);//注意是三个参数
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public int insert() {
        int i = 0;
        String sql = "insert into emp(empno, ename, job, hiredate, sal) values(?,?,?,?,?)";
        Connection cnn = getConn();

        try {
            PreparedStatement preStmt = cnn.prepareStatement(sql);
            preStmt.setInt(1, 3212);
            preStmt.setString(2, "Christian");//或者：preStmt.setInt(1,值);
            preStmt.setString(3, "Director");
            preStmt.setString(4, "2001-10-05");
            preStmt.setFloat(5, (float) 2000.3);
            i = preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;//返回影响的行数，1为执行成功
    }


    public int update() {
        int i = 0;
        String sql = "update emp set sal = ? where ename = ?";//注意要有where条件
        Connection cnn = getConn();


        try {
            PreparedStatement preStmt = cnn.prepareStatement(sql);
            preStmt.setFloat(1, (float) 5000.0);
            preStmt.setString(2, "Jack");//或者：preStmt.setInt(1,值);
            i = preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;//返回影响的行数，1为执行成功
    }

    public void select() {
        String sql = "select * from emp";
        Connection cnn = getConn();//此处为通过自己写的方法getConn()获得连接
        try {
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("------------------------------------------------");
            System.out.println("执行结果如下所示:");
            System.out.println("------------------------------------------------");
            System.out.println("员工号" + " \t" + "姓名" + " \t" + "职称" + "\t\t" + "工资");
            System.out.println("------------------------------------------------");

            String job = null;
            String id = null;
            String no = null;
            String sal = null;

            while (rs.next()) {
                no = rs.getString("empno");
                job = rs.getString("job");
                id = rs.getString("ename");
                sal = rs.getString("sal");
                //输出结果
                System.out.println(no + " \t" + id + "\t" + job + "\t\t" + sal);
            }
            System.out.println("------------------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int delete() {
        String sql = "delete from emp where sal > ";
        int i = 0;
        Connection conn = getConn();
        try {
            sql = sql + "4500";
            Statement stmt = conn.createStatement();
            System.out.println(sql);
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;//如果返回的是1，则执行成功;
    }

    public static void main(String[] args) {
        Db database = new Db();
        //database.select();
//		database.insert();
        database.select();
        database.update();
    }

}

