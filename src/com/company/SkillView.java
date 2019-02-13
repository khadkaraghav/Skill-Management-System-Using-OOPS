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


    public void search() {
        System.out.println("Search skills");
        while (true) {
            skillDAO.search(keyboard.next()).forEach(s -> {
                System.out.println(s.toString());
            });
            System.out.println("Do you want to search more (Y/N)");

            if (keyboard.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }


    public void controller() {

        menu();

        switch (keyboard.nextInt()) {

            case 1:
                add();
                break;


            case 2:
                showAll();
                break;

            case 3:
                searchById();
                break;

            case 4:
                delete();
                break;

            case 5:
                System.out.println("You have total of " + skillDAO.count() + " skills");
                break;

            case 6:
                search();
                break;

            case 7:
                exit();
                break;

        }
    }

    public static void menu() {

        System.out.println("==================================");
        System.out.println("Welcome to Skill Manager");
        System.out.println("===================================");

        System.out.println("1. Add Skill");
        System.out.println("2. Show All Skills");
        System.out.println("3. Search By Id");
        System.out.println("4. Delete");
        System.out.println("5. Count");
        System.out.println("6. Search");
        System.out.println("Enter your choice [1-7]");


    }
}









