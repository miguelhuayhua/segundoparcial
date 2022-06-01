package com.miguel.parcialdao.dao;

import com.miguel.parcialdao.models.Seminario;
import java.util.List;

public interface seminarioDAO {

    public Seminario getById(int id);

    public List<Seminario> getAll();

    public void updateSeminario(Seminario seminario);
}
