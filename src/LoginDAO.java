import java.sql.*;

public class LoginDAO {
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
    int CheckLogin(Login obj)
    {
        int check = 0;
        try
        {
            connection();
            String qry = "select * from login where username = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.username);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) 
            {
                if(obj.password.equals(rs.getString("password")))
                {
                    check = 1;
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return check;
    }
    int Insert(Login obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "insert into login values (?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.username);
            pst.setString(2, obj.password);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Update(Login obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "update login set password = ? where username= ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.password);
            pst.setString(2, obj.username);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Delete(Login obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "delete from login where username = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.username);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
}
