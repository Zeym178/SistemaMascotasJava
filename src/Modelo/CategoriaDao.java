
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    public boolean RegistrarCategoria(Categoria pr){
        String sql = "INSERT INTO categoria(nombre, descripcion) VALUES (?,?)";
        try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, pr.getNombre());
           ps.setString(2, pr.getDescripcion());
           ps.execute();
           return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public List ListarCategoria(){
        List<Categoria> Listapr = new ArrayList();
        String sql = "SELECT * FROM categoria";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Categoria pr = new Categoria();
                pr.setId(rs.getInt("id"));
                pr.setNombre(rs.getString("nombre"));
                pr.setDescripcion(rs.getString("descripcion"));
                Listapr.add(pr);
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Listapr;
    }
    
    public boolean EliminarCategoria(int id){
        String sql = "DELETE FROM categoria WHERE id = ? ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public boolean ModificarCategoria(Categoria pr){
        String sql = "UPDATE categoria SET nombre=?, descripcion=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNombre());
            ps.setString(2, pr.getDescripcion());
            ps.setInt(3, pr.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
