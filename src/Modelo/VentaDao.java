
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int IdVenta(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM ventas";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }
    
    public int RegistrarVenta(Venta v){
        String sql = "INSERT INTO ventas (vendedor, total, fecha) VALUES (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getVendedor());
            ps.setDouble(2, v.getTotal());
            ps.setString(3, v.getFecha());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    public int RegistrarDetalle(Detalle Dv){
       String sql = "INSERT INTO detalle (id_pro, cantidad, precio, id_venta) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Dv.getId_pro());
            ps.setInt(2, Dv.getCantidad());
            ps.setDouble(3, Dv.getPrecio());
            ps.setInt(4, Dv.getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    public boolean ActualizarStock(int cant, int id){
        String sql = "UPDATE productos SET stock = ? WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,cant);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List Listarventas(){
       List<Venta> ListaVenta = new ArrayList();
       String sql = "SELECT * FROM ventas";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Venta vent = new Venta();
               vent.setId(rs.getInt("id"));
               vent.setVendedor(rs.getString("vendedor"));
               vent.setTotal(rs.getDouble("total"));
               ListaVenta.add(vent);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListaVenta;
   }
    public Venta BuscarVenta(int id){
        Venta cl = new Venta();
        String sql = "SELECT * FROM ventas WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl.setId(rs.getInt("id"));
                cl.setTotal(rs.getDouble("total"));
                cl.setVendedor(rs.getString("vendedor"));
                cl.setFecha(rs.getString("fecha"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cl;
    }
    
}
