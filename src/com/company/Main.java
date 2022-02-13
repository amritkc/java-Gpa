package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public  class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Integer totalPoints = 0;
        Integer totalCredit = 0;
        boolean moreclass = false;
        do {
            Boolean validCredit = true;
            String credit;
            String grade;
            Integer points = 0;
            do {
                System.out.println("Enter Number Of Credits:");
                credit  = scanner.nextLine();
                try {
                    validCredit = true;
                    Integer credits = Integer.parseInt(credit);
                }catch (NumberFormatException nfe){
                    System.out.println("Enter Valid Integer :(");
                    validCredit = false;
                }
            }while (!validCredit);
            Boolean validgrade = true;
            Integer gradesVal = 0;
            do {
                validgrade = true;
                System.out.println("Enter Grades:");
                grade = scanner.nextLine();
                if(grade.equalsIgnoreCase("A")){
                    gradesVal = 4;
                }else if(grade.equalsIgnoreCase("B")){
                    gradesVal = 3;

                }else if(grade.equalsIgnoreCase("C")){
                    gradesVal = 2;

                }else if(grade.equalsIgnoreCase("D")){
                    gradesVal = 1;

                }else if(grade.equalsIgnoreCase("F")){
                    gradesVal = 0;

                }else{
                    System.out.println("You Didn't Enter valid Grade :(");
                    validgrade = false;
                }

            }while (!validgrade);
            points = gradesVal * Integer.parseInt(credit);
            totalCredit += Integer.parseInt(credit);
            totalPoints += points;

            System.out.println("Would You Like to Add Another Class? (Y/N)");
            String morclassval = scanner.nextLine();
            moreclass = morclassval.equalsIgnoreCase("Y");
        }while (moreclass);

        DecimalFormat df = new DecimalFormat("0.00");
        Double gpa = Double.valueOf(totalPoints) /  Double.valueOf(totalCredit);
        System.out.println("Your Total Points is : " +totalPoints);
        System.out.println("Your Total Credit is : " +totalCredit);
        System.out.println("Your GPA is : " +df.format(gpa));
    }
}
