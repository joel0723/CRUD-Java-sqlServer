package javaapplication3;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DataBase {

    private PreparedStatement ps;
    private Connection con;
    private ResultSet rs;
    private Statement stmnt;
    private String serverName;
    private String port = "1433";
    private String dataBaseName;
    private String userName;
    private String password;
    private DefaultTableModel DT;

    public DataBase() {

    }

    private DefaultTableModel setTitulo() {
        DT = new DefaultTableModel();
        DT.addColumn("ID");
        DT.addColumn("Nombre");
        DT.addColumn("Apellido");
        DT.addColumn("Compañia");
        DT.addColumn("Posicion");
        DT.addColumn("Email");
        DT.addColumn("Telefono");
        DT.addColumn("Notas");

        return DT;
    }

    public void connect(String serverName, String dataBaseName,
            String userName, String password) throws SQLException {

        this.serverName = serverName;
        this.dataBaseName = dataBaseName;
        this.userName = userName;
        this.password = password;

        String url = "jdbc:sqlserver://" + serverName + ":" + port + ";databaseName=" + dataBaseName + ";user=" + userName + ";password=" + password + ";";

        con = DriverManager.getConnection(url);

     
    }

    public void disconnet() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            System.out.print("Se Desconecto");
        }
    }

    public int add(Cliente cliente) {
       int v =0;
        String query = "Insert into clientes(Nombre, Apellido, Compañia, Posicion, Email, Telefono, Notas)" + "Values('"
                + cliente.getNombre() + "', '"
                + cliente.getApellido() + "', '"
                + cliente.getCompañia() + "', '"
                + cliente.getPosicion() + "', '"
                + cliente.getEmail() + "', '"
                + cliente.getTelefono() + "', '"
                + cliente.getNotas() + "')";
        try {
            if (con != null) {
                stmnt = con.createStatement();
               v = stmnt.executeUpdate(query);
               if(v > 0){
                JOptionPane.showMessageDialog(null, "Registro Guardado Correctamente");
               }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return v;
    }

    public DefaultTableModel getDatos() {
        String SQL_SELECT = "select * from clientes";
        try {
            setTitulo();
            if (con != null) {
               
                stmnt = con.createStatement();
                rs = stmnt.executeQuery(SQL_SELECT);
                Object[] fila = new Object[8];
                while (rs.next()) {
                    fila[0] = rs.getString(1);
                    fila[1] = rs.getString(2);
                    fila[2] = rs.getString(3);
                    fila[3] = rs.getString(4);
                    fila[4] = rs.getString(5);
                    fila[5] = rs.getString(6);
                    fila[6] = rs.getString(7);
                    fila[7] = rs.getString(8);
                    DT.addRow(fila);

                }
            }

        } catch (SQLException e) {

            System.out.println("error al listar los datos: " + e.getMessage());

        } finally {
            stmnt = null;
            rs = null;
            disconnet();
        }

        return DT;
    }
    public DefaultTableModel getData(int crt, String par) {
        String SQL;       
        switch (crt) {
            case 0:
                SQL = "select * from clientes where ID =  " + "'" + par + "'";
                break;
            case 1:
                SQL = "select * from clientes where Nombre = " +  "'" + par + "'";
                break;
            case 2:
                SQL = "select * from clientes where Apellido = " +  "'" + par + "'";
                break;
            default:
                SQL = "select * from clientes where Nombre = " +  "'" + par + "'" + " and " + " Apellido = " + "'" + par + "'";
                break;     
        }
        
        try {
            setTitulo();
            if (con != null) {
               
                stmnt = con.createStatement();
                rs = stmnt.executeQuery(SQL);
                Object[] fila = new Object[8];
                while (rs.next()) {
                    fila[0] = rs.getString(1);
                    fila[1] = rs.getString(2);
                    fila[2] = rs.getString(3);
                    fila[3] = rs.getString(4);
                    fila[4] = rs.getString(5);
                    fila[5] = rs.getString(6);
                    fila[6] = rs.getString(7);
                    fila[7] = rs.getString(8);
                    DT.addRow(fila);

                }
            }

        } catch (SQLException e) {

            System.out.println("error al listar los datos: " + e.getMessage());

        } finally {
            stmnt = null;
            rs = null;
            disconnet();
        }

        return DT;
    }
    public int modificar(Cliente cliente) {
       int v =0;
        String query = "Update clientes set Nombre='"
                +cliente.getNombre() + "',Apellido='"
                +cliente.getApellido() + "',Compañia='"
                +cliente.getCompañia()+ "',Posicion='"
                +cliente.getPosicion()+ "',Email='"
                +cliente.getEmail()+"',Telefono='"
                +cliente.getTelefono()+"',Notas='"
                +cliente.getNotas() + "' where ID = "
                + cliente.getID();

        try {
            if (con != null) {
                stmnt = con.createStatement();
               v = stmnt.executeUpdate(query);
               if(v > 0){
                JOptionPane.showMessageDialog(null, "Registro Modificado");
               }
            }

        } catch (SQLException ex) {
            System.out.println("error al modificar: " + ex);
        }
        return v;
    }
     public int eliminar(Cliente cliente) {
       int v =0;
       
        String query = "delete from clientes where ID=" + cliente.getID();
                

        try {
            if (con != null) {
                stmnt = con.createStatement();
               v = stmnt.executeUpdate(query);
               if(v > 0){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
               }
            }

        } catch (SQLException ex) {
            System.out.println("error al Eliminar: " + ex);
        }
        return v;
    }

}
