package com.miguel.parcialdao.dao;

import com.miguel.parcialdao.models.Participante;
import com.miguel.parcialdao.models.Seminario;
import com.miguel.parcialdao.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class participanteDAOImplement {

    public Participante getById(int id) {
        return null;
    }

    public List<Participante> getAll() {
        String SQL = "SELECT p.id as id, p.apellidos as apellidos, p.nombres as nombres, p.id_seminario as id_seminario, p.confirmado as confirmado, s.titulo as titulo FROM participantes p INNER JOIN seminarios s ON (p.id_seminario = s.id) ORDER BY apellidos asc ";
        //creamos la lista para albergar los datos
        List<Participante> lista = new ArrayList<Participante>();
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement st = connection.prepareStatement(SQL);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Participante participante = new Participante(rs.getInt("id"), rs.getInt("id_seminario"), rs.getInt("confirmado"), rs.getString("nombres"), rs.getString("apellidos"));
                Seminario seminario = new Seminario();
                seminario.setTitulo(rs.getString("titulo"));
                participante.setSeminario(seminario);
                lista.add(participante);
            }
            connection.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió al problema al devolver todos los datos de los seminarios");
        } finally {
            return lista;
        }
    }
}
