package com.company;

import java.util.ArrayList;

public interface SkillDAO {

    void insert (Skill skill);
    boolean delete (int id);
    Skill getById (int id);
    ArrayList<Skill> getAll();
    ArrayList<Skill> search(String param);
    int count();
}
