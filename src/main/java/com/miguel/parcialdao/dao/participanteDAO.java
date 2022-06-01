package com.miguel.parcialdao.dao;

import com.miguel.parcialdao.models.Participante;
import java.util.List;

public interface participanteDAO {

    public Participante getById(int id);

    public List<Participante> getAll();
}
