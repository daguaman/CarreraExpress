package edu.incae.mba.carrera_express.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import edu.incae.mba.carrera_express.beans.UsuarioBeans;
import edu.incae.mba.carrera_express.utilitarios.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class UsuarioDao {

    UsuarioBeans usuarioBeans;

    public UsuarioDao() {
        this.usuarioBeans = new UsuarioBeans();

    }

    public UsuarioBeans mostrarCamposUsuario(String cedula) {
        try {
            String SQLSelecion = "SELECT  `usuario`.`id`,`usuario`.`user`,`usuario`.`clave`,`usuario`.`personaid_fk` FROM `persona` INNER JOIN `usuario` ON (`persona`.`persona_id` = `usuario`.`personaid_fk`) where `persona`.`cedula`=?";
            PreparedStatement st = Conexion.getConnection().prepareStatement(SQLSelecion);
            st.setString(1, cedula);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                usuarioBeans.setUsuarioId(rs.getInt("id"));
                usuarioBeans.setUser(rs.getString("user"));
                usuarioBeans.setClave(rs.getString("clave"));
                usuarioBeans.setPersonaFk(rs.getInt("personaid_fk"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en buscar usuario", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            e.printStackTrace();
        }
        return usuarioBeans;

    }

    public void registrarUsuario(UsuarioBeans usuario) {

        try {
            String SQLInsertion = "INSERT INTO usuario (user,clave,personaid_fk) VALUES (?,?,?) ";
            PreparedStatement st = Conexion.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, usuario.getUser());
            st.setString(2, usuario.getClave());
            st.setInt(3, usuario.getPersonaFk());

            st.execute();
            Conexion.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Se ha ingresado a al Usuario", "Exito", 1, new ImageIcon("imagenes/ok.png"));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public Integer doLogin(UsuarioBeans usr) {
        CallableStatement myStm = null;

        try {
            myStm = Conexion.getConnection().prepareCall("{call sp_login(?,?,?)}");

            myStm.setString(1, usr.getUser());
            myStm.setString(2, usr.getClave());

            myStm.registerOutParameter(3, Types.INTEGER);

            myStm.execute();
            Conexion.getConnection().commit();

            Integer mensaje = myStm.getInt(3);
            return mensaje;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en buscar registro", "Error", 0, new ImageIcon("imagenes/btn_sair.png"));
            ex.printStackTrace();
        }
        return null;
    }

}
