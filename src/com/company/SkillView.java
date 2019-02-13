package com.company;

import java.util.Scanner;

public class SkillView {

    private Scanner keyboard;
    private SkillDAO skillDAO;

    public SkillView(Scanner keyboard, SkillDAO skillDAO) {
        this.keyboard = keyboard;
        this.skillDAO = skillDAO;
    }

    public void add() {


        while (true) {

            System.out.println("Add Skill");
            Skill skill = new Skill();
            System.out.println("Enter ID: ");
            skill.setId(keyboard.nextInt());
            System.out.println("Enter Name");
            skill.setName(keyboard.next());
            System.out.println("Enter Description");
            skill.setDescription(keyboard.next());

            skillDAO.insert(skill);
            System.out.println("Do you want to add more (Y/N)");

            if (keyboard.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void showAll() {
        System.out.println("Listing all skills");
        skillDAO.getAll().forEach(s -> {
            System.out.println(s.toString());
        });
    }


    public void delete() {
        System.out.println("Delete skills");
        while (true) {
            System.out.println("Enter Id to delete");
            if (skillDAO.delete(keyboard.nextInt())) {
                System.out.println("Delete Successful");
            } else {
                System.out.println("Record not found");
            }

            System.out.println("Do you want to delete more (Y/N)");

            if (keyboard.next().equalsIgnoreCase("n")) {
                break;
            }

        }
    }

    public void exit() {

        System.out.println("Do you really want to exit (Y/N");

        if (keyboard.next().equalsIgnoreCase("y")) {
            System.exit(0);

        }
    }

    public void searchById() {
        System.out.println("Search by skills");
        while (true) {
            System.out.println("Enter Id to search");

            Skill skill = skillDAO.getById(keyboard.nextInt());

            if (skill != null) {
                System.out.println(skill.toString());
            } else {
                System.out.println("Record not found");
            }
            System.out.println("Do you want to search more (Y/N)");

            if (keyboard.next().equalsIgnoreCase("n")) {
                break;
            }

        }

    }


}






