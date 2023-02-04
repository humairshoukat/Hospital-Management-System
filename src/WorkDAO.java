import java.sql.*;

public class WorkDAO {
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
    int Update(Work obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "update work set type = ?, date = ?, timing = ? where work_id= ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.type);
            pst.setString(2, obj.date);
            pst.setString(3, obj.timing);
            pst.setInt(4, obj.work_id);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Delete(Work obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "delete from pharmacist where type = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.type);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    ResultSet SelectById(Work obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from work where work_id = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.work_id);
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
            String qry = "select * from work";
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
