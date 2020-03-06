package sample.Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductosDAO {

    private int idProducto;
    private String nomProducto;
    private float costo;
    private float precio;
    private int existencia;
    private boolean vigente;
    private int idProveedor;

    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public String getNomProducto() {
        return nomProducto;
    }
    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }
    public float getCosto() {
        return costo;
    }
    public void setCosto(float costo) {
        this.costo = costo;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public int getExistencia() {
        return existencia;
    }
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    public boolean isVigente() {
        return vigente;
    }
    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    public int getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    private Connection con;
    public ProductosDAO(){
        con = Conexion.con;
    }

    public void insProducto(){

        String query = "insert into tbl_Productos " +
                "(nomProducto,costo,precio,existencia,vigente,idProveedor) " +
                "values('"+nomProducto+"',"+costo+","+precio+","+existencia+","+vigente+","+idProveedor+")";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updProducto(){
        String query = "update tbl_Productos nomProducto='"+nomProducto+"'" +
                ",costo="+costo+",precio="+precio+",existencia="+existencia+"," +
                "vigente='"+vigente+"',idProveedor="+idProveedor+" where " +
                "idProducto="+idProducto;
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){}
    }

    public void delProducto(){
        String query = "delete from tbl_Productos where idProducto="+idProducto;
        try{
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){}
    }

    public ObservableList<ProductosDAO> selAllProducto(){

        ObservableList<ProductosDAO> listaP = FXCollections.observableArrayList();
        ProductosDAO objP = null;
        String query = "select * from tbl_Productos order by nomProducto";
        try{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                objP = new ProductosDAO();
                objP.setIdProducto(res.getInt("idProducto"));
                objP.setNomProducto(res.getString("nomProducto"));
                objP.setCosto(res.getFloat("costo"));
                objP.setPrecio(res.getFloat("precio"));
                objP.setExistencia(res.getInt("existencia"));
                objP.setVigente(res.getBoolean("vigente"));
                objP.setIdProveedor(res.getInt("idProveedor"));
                listaP.add(objP);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listaP;
    }

    public void selByIdProducto(){}
}
