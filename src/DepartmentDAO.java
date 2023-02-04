import java.sql.*;

public class DepartmentDAO {
    Connection con = null;
    void connection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hospitalmanagement";
            con = DriverManager.getConnection(url,"root","");
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
    int Insert(Department obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "insert into department values (?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.dept_no);
            pst.setString(2, obj.name);
            pst.setString(3, obj.description);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Update(Department obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "update department set name = ?, description = ? where dept_no= ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.name);
            pst.setString(2, obj.description);
            pst.setInt(3, obj.dept_no);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Delete(Department obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "delete from department where name = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.name);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    ResultSet SelectById(Department obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from department where dept_no = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.dept_no);
            rs = pst.executeQuery();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return rs;
    }
    ResultSet SelectByName(Department obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from department where name = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.name);
            rs = pst.executeQuery();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return rs;
    }
    ResultSet SelectAll()
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from department";
            Statement pst = con.createStatement();
            rs = pst.executeQuery(qry);
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return rs;
    }
}
