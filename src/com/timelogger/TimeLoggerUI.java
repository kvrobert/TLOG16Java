package com.timelogger;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author rkissvincze
 */
public class TimeLoggerUI {
    
    
    private Scanner scanner = new Scanner(System.in);
    private TimeLogger timeLogger;
    private WorkDay workDay;
    private WorkMonth workMonth;
    private final List<String> MENU = Arrays.asList("Exit",
                                                    "List the months",
                                                    "List the days",
                                                    "List the tasks",
                                                    "Add a new month",
                                                    "Add a new day",
                                                    "Start a task",
                                                    "Finish a task",
                                                    "Delete a task",
                                                    "Modify a task",
                                                    "Statistics");
    
    public TimeLoggerUI(TimeLogger timeLogger){
        this.timeLogger = timeLogger;
    }
    
    public void printMenu(){
        System.out.println("\n::: MENU :::");
        System.out.println  ("============\n");
        IntStream.range(0, MENU.size()).forEach(index -> System.out.println(index + ". " + MENU.get(index)));
        System.out.println("\nChoose a menu, pleas!");
    }
    
    public void selectMenu(){
    
        while(true){
        
            switch(scanner.nextInt())
            {
                case 0: exit(); break;
                case 1: listMonths(); break;
                case 2: listDays(); break;
                case 3: listTasks(); break;
                case 4: addNewMonth(); break;
                case 5: addNewDay(); break;
                case 6: createNewTask(); break;
                case 7: finishATask(); break;
                case 8: deleteATask(); break;
                case 9: modifyATask(); break;
                case 10: statistics(); break;
                default: System.out.println("Wrong menu! Please choose a correct menu!"); break;
            }
        }
    }

    private void exit() {
        System.exit(0);
    }

    private void listMonths() {
        System.out.println("ListMonts....");
        if( timeLogger.getMonths().size() > 0 ){
            IntStream.range(0, timeLogger.getMonths().size()).forEach(index -> System.out.println(index+1 + ". " + timeLogger.getMonths().get(index).toString()));
        }
    }

    private void listDays() {
        System.out.println("listDays");
    }
    
    private void listTasks() {
        System.out.println("listTasks");
    }
    
    private void addNewMonth() {
        System.out.println("addNewMonth");
    }

    private void addNewDay() {
     
    }

    private void createNewTask() {
    
    }

    private void finishATask() {
    
    }

    private void deleteATask() {
    
    }

    private void modifyATask() {
    
    }

    private void statistics() {
    
    }
    
    
}
