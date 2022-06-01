package com.miguel.parcialdao.dao;

import com.miguel.parcialdao.models.Seminario;
import com.miguel.parcialdao.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class seminarioDAOImplement implements seminarioDAO {

    @Override
    public Seminario getById(int id) {
        String SQL = "SELECT * FROM seminarios WHERE id = ?";
        Seminario seminario = new Seminario();
        seminario.setTitulo("");
        seminario.setCupo(0);
        seminario.setFecha("");
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(SQL);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                seminario.setId(rs.getInt("id"));
                seminario.setTitulo(rs.getString("titulo"));
                seminario.setFecha(rs.getString("fecha"));
                seminario.setCupo(rs.getInt("cupo"));
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió al problema al devolver todos los datos de los seminarios");
        } finally {

            return seminario;
        }
    }

    @Override
    public List<Seminario> getAll() {
        String SQL = "SELECT * FROM seminarios";
        //creamos la lista para albergar los datos
        List<Seminario> lista = new ArrayList<Seminario>();
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Seminario seminario = new Seminario();
                seminario.setId(rs.getInt("id"));
                seminario.setTitulo(rs.getString("titulo"));
                seminario.setFecha(rs.getString("fecha"));
                seminario.setCupo(rs.getInt("cupo"));
                lista.add(seminario);
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió al problema al devolver todos los datos de los seminarios");
        } finally {

            return lista;
        }
    }

    public void updateSeminario(Seminario seminario) {
        String SQL = "UPDATE seminarios SET titulo = ?, fecha = ?, cupo = ? WHERE id = ?";
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(SQL);
            st.setInt(4, seminario.getId());
            st.setString(1, seminario.getTitulo());
            st.setString(2, seminario.getFecha());
            st.setInt(3, seminario.getCupo());
            st.executeUpdate();
            connection.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió al problema al actualizar los datos del seminario");
        }
    }

}
