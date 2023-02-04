import java.sql.*;

public class ReceptionistDAO {
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
    int Insert(Receptionist obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "insert into receptionist values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.recep_id);
            pst.setString(2, obj.name);
            pst.setString(3, obj.cnic);
            pst.setInt(4, obj.age);
            pst.setString(5, obj.gender);
            pst.setString(6, obj.phone_no);
            pst.setString(7, obj.address);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Update(Receptionist obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "update receptionist set name = ?, cnic = ?, age = ?, gender = ?, phone_no = ?, address = ? where recep_id= ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.name);
            pst.setString(2, obj.cnic);
            pst.setInt(3, obj.age);
            pst.setString(4, obj.gender);
            pst.setString(5, obj.phone_no);
            pst.setString(6, obj.address);
            pst.setInt(7, obj.recep_id);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Delete(Receptionist obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "delete from receptionist where name = ?";
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
    ResultSet SelectById(Receptionist obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from receptionist where recep_id = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.recep_id);
            rs = pst.executeQuery();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return rs;
    }
    ResultSet SelectByName(Receptionist obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from receptionist where name = ?";
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
            String qry = "select * from receptionist";
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
