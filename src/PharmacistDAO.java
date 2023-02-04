import java.sql.*;

public class PharmacistDAO {
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
    int Insert(Pharmacist obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "insert into pharmacist values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.phar_id);
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
    int Update(Pharmacist obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "update pharmacist set name = ?, cnic = ?, age = ?, gender = ?, phone_no = ?, address = ? where phar_id= ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.name);
            pst.setString(2, obj.cnic);
            pst.setInt(3, obj.age);
            pst.setString(4, obj.gender);
            pst.setString(5, obj.phone_no);
            pst.setString(6, obj.address);
            pst.setInt(7, obj.phar_id);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Delete(Pharmacist obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "delete from pharmacist where name = ?";
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
    ResultSet SelectById(Pharmacist obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from receptionist where recep_id = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.phar_id);
            rs = pst.executeQuery();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return rs;
    }
    ResultSet SelectByName(Pharmacist obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from pharmacist where name = ?";
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
            String qry = "select * from pharmacist";
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
