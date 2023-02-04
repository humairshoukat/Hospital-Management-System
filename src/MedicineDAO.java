import java.sql.*;

public class MedicineDAO {
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
    int Insert(Medicine obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "insert into medicine values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, obj.name);
            pst.setInt(2, obj.ref_no);
            pst.setString(3, obj.dailydose);
            pst.setInt(4, obj.dosemg);
            pst.setString(5, obj.issue_date);
            pst.setString(6, obj.exp_date);
            pst.setString(7, obj.c_name);
            pst.setInt(8, obj.price);
            pst.setInt(9, obj.quantity);  
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Update(Medicine obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "update pharmacist set ref_no = ?, dailydose = ?, dosemg = ?, issue_date = ?, exp_date = ?, c_name = ?, price = ?, quantity = ? where name= ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.ref_no);
            pst.setString(2, obj.dailydose);
            pst.setInt(3, obj.dosemg);
            pst.setString(4, obj.issue_date);
            pst.setString(5, obj.exp_date);
            pst.setString(6, obj.c_name);
            pst.setInt(7, obj.price);
            pst.setInt(8, obj.quantity);
            pst.setString(9, obj.name);
            res = pst.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return res;
    }
    int Delete(Medicine obj)
    {
        int res = 0;
        try
        {
            connection();
            String qry = "delete from medicine where name = ?";
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
    ResultSet SelectById(Medicine obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from medicine where ref_no = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, obj.ref_no);
            rs = pst.executeQuery();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        return rs;
    }
    ResultSet SelectByName(Medicine obj)
    {
        ResultSet rs = null;
        try
        {
            connection();
            String qry = "select * from medicine where name = ?";
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
            String qry = "select * from medicine";
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
