import java.sql.*;

public class PatientDAO {
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
    int Insert(Patient obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "insert into patient values (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.p_id);
            pst.setString(2, obj.name);
            pst.setString(3, obj.cnic);
            pst.setString(4, obj.phone_no);
            pst.setString(5, obj.address);
            pst.setString(6, obj.type);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Update(Patient obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "update patient set name = ?, cnic = ?, phone_no = ?, address = ?, type = ? where p_id= ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.name);
            pst.setString(2, obj.cnic);
            pst.setString(3, obj.phone_no);
            pst.setString(4, obj.address);
            pst.setString(5, obj.type);
            pst.setInt(6, obj.p_id);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Delete(Patient obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "delete from patient where name = ?";
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
    ResultSet SelectById(Patient obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from patient where p_id = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.p_id);
            rs = pst.executeQuery();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return rs;
    }
    ResultSet SelectByName(Patient obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from patient where name = ?";
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
            String qry = "select * from patient";
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
