package com.company;

import java.util.ArrayList;

public class SkillDAOImpl implements SkillDAO {


    private ArrayList<Skill> skillList;

    public SkillDAOImpl() {

        skillList = new ArrayList<Skill>();
    }

    @Override
    public void insert(Skill skill) {
        skillList.add(skill);

    }

    @Override
    public boolean delete(int id) {
        boolean hasDelete = false;
        for (Skill skill : skillList) {
            if (skill.getId() == id) {
                skillList.remove(skill);
                hasDelete = true;
                break;
            }
        }
        return hasDelete;
    }


    @Override
    public Skill getById(int id) {
        for (Skill skill : skillList) {
            if (skill.getId() == id) {
                return skill;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Skill> getAll() {
        return skillList;
    }

    @Override
    public ArrayList<Skill> search(String param) {
        ArrayList<Skill> skills = new ArrayList<>();
        for (Skill skill : skillList) {
            String name = skill.getName().toLowerCase();
            String desc = skill.getDescription().toLowerCase();
            param = param.toLowerCase();
            if (name.contains(param) || (desc.contains(param))) {
                skills.add(skill);
            }
        }
        return skills;

    }

    @Override
    public int count() {
        return skillList.size();
    }
}
