import java.sql.*;

public class DoctorDAO {
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
    int Insert(Doctor obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "insert into doctor values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.doctor_id);
            pst.setString(2, obj.name);
            pst.setString(3, obj.cnic);
            pst.setInt(4, obj.age);
            pst.setString(5, obj.gender);
            pst.setString(6, obj.department);
            pst.setString(7, obj.address);
            pst.setString(8, obj.phone_no);
            pst.setString(9, obj.joining_date);
            pst.setString(10, obj.visit_timings);
            pst.setString(11, obj.days);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Update(Doctor obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "update doctor set name = ?, cnic = ?, age = ?, gender = ?, department = ?, address = ?, phone_no = ?, joining_date = ?, visit_timings = ?, days = ? where doctor_id= ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.name);
            pst.setString(2, obj.cnic);
            pst.setInt(3, obj.age);
            pst.setString(4, obj.gender);
            pst.setString(5, obj.department);
            pst.setString(6, obj.address);
            pst.setString(7, obj.phone_no);
            pst.setString(8, obj.joining_date);
            pst.setString(9, obj.visit_timings);
            pst.setString(10, obj.days);
            pst.setInt(11, obj.doctor_id);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Delete(Doctor obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "delete from doctor where name = ?";
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
    ResultSet SelectById(Doctor obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from doctor where doctor_id = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.doctor_id);
            rs = pst.executeQuery();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return rs;
    }
    ResultSet SelectByName(Doctor obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from doctor where name = ?";
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
            String qry = "select * from doctor";
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
