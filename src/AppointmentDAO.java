import java.sql.*;

public class AppointmentDAO {
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
    int Insert(Appointment obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "insert into appointment values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.p_id);
            pst.setString(2, obj.p_name);
            pst.setInt(3, obj.doctor_id);
            pst.setString(4, obj.doctor_name);
            pst.setString(5, obj.date);
            pst.setString(6, obj.timing);
            pst.setString(7, obj.problem);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Update(Appointment obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "update appointment set p_name = ?, doctor_id = ?, doctor_name = ?, date = ?, timing = ?, problem = ? where p_id= ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.p_name);
            pst.setInt(2, obj.doctor_id);
            pst.setString(3, obj.doctor_name);
            pst.setString(4, obj.date);
            pst.setString(5, obj.timing);
            pst.setString(6, obj.problem);
            pst.setInt(7, obj.p_id);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Delete(Appointment obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "delete from appointment where p_name = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.p_name);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    ResultSet SelectById(Appointment obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from appointment where p_id = ?";
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
    ResultSet SelectByName(Appointment obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from appointment where p_name = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.p_name);
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
            String qry = "select * from appointment";
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
