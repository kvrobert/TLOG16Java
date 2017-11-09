package com.timelogger;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private Task task;
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
        
        while(true){
            System.out.println("\n::: MENU :::");
            System.out.println  ("============\n");
            IntStream.range(0, MENU.size()).forEach(index -> System.out.println(index + ". " + MENU.get(index)));
            System.out.println("\nChoose a menu, pleas!");
            selectMenu();
        }
    }
    public void selectMenu(){   
        
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

    private void exit() {
        
        System.exit(0);
    }

    private void listMonths() {
        
        System.out.println("ListMonts....");
        if( timeLogger.getMonths().size() > 0 ){
            
            IntStream.range(0, timeLogger.getMonths().size())
                    .forEach(index -> System.out.println(index+1 + ". "
                            + timeLogger.getMonths().get(index).toString()));
            return;
        }
    }

    private void listDays() {
        
        listMonths();
        selectMonth();
        if( workMonth.getDays().size() > 0){
        
            IntStream.range(0, workMonth.getDays().size())
                    .forEach(index -> System.out.println( index+1 + ". " 
                            + workMonth.getDays().get(index) ));
            return;
        }
    }

    private void selectMonth() {
        
        System.out.println("Chosse a month!");
        workMonth = timeLogger.getMonths().get(scanner.nextInt() -1);
    }
    
    private void selectDay() {
        
        System.out.println("Chosse a day!");
        workDay = workMonth.getDays().get(scanner.nextInt() - 1);
    }
    
    private void selectTask() {
        
        System.out.println("Chosse a task!");
        task = workDay.getTasks().get(scanner.nextInt() -1);
    }
      
    private void listTasks() {
        listDays();
        selectDay();
        if( workDay.getTasks().size() > 0 ){
            IntStream.range(0, workDay.getTasks().size())
                    .forEach(index -> System.out.println( index+1 + ". " 
                            + workDay.getTasks().get(index) )); 
            return;       
        }
    }

    private void addNewMonth() {
        
        System.out.println("Type the date or press enter to use this month (YYYYMM).");
        String input = scanner.next();
        if( input.equals("") ) timeLogger.addMonth(new WorkMonth());
        if( input.matches( "[1-2][0|9][0-9][0-9][01][0-2]" ) ) {
        
            timeLogger.addMonth(new WorkMonth(input));
            return;
        }
        System.out.println("NINCS HÓ BEVITEL");
    }

    private void addNewDay(boolean isEnabled) {
        boolean isWeekendEnabled = isEnabled;
        LocalDate actualDay = null;
        long requiredMin;
        listMonths();
        selectMonth();
        
        System.out.println("Type the required minute for the day or press enter for default 7.5 Hour .");
        int intInput = scanner.nextInt();
        if( intInput >= 0){
            requiredMin = intInput == 0 ? 450 : (long) (intInput * 60);
        }       
        
        System.out.println("Type the day or press enter (DD).");
        int dayInput = scanner.nextInt();
        if( dayInput > 0 && dayInput < 31 ) {
            
            actualDay = dayInput == 0 ? 
                    LocalDate.now() : LocalDate.of(workMonth.getDate().getYear(), workMonth.getDate().getMonthValue(), dayInput);
        }
        workMonth.addWorkDay(new WorkDay(intInput, actualDay), isWeekendEnabled);
    }
    
    public void addNewDay(){
    
        addNewDay(false);
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
