package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SkillView sv = new SkillView(new Scanner(System.in), new SkillDAOImpl());

        while (true) {

            sv.controller();

        }
    }
}



