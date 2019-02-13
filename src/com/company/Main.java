package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        SkillDAO skillDAO = new SkillDAOImpl();

        Scanner keyboard = new Scanner(System.in);

        SkillView sv = new SkillView(keyboard, skillDAO);

        while (true) {
            menu();

            switch (keyboard.nextInt()) {

                case 1:
                    sv.add();
                    break;


                case 2:
                    sv.showAll();
                    break;

                case 3:
                    sv.searchById();
                    break;

                case 4:
                    sv.delete();
                    break;

                case 7:
                    sv.exit();
                    break;

            }
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

