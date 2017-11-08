package com.timelogger;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import sun.util.calendar.BaseCalendar;

/**
 *
 * @author rkissvincze
 */
public class WorkDay {
    private List<Task> tasks = new ArrayList<>();
    private long requiredMinPerDay = (long) (7.5 * 60);
    private LocalDate actualDay = LocalDate.now();
    private long sumPerDay;
    
    public WorkDay(){}
    
    public WorkDay(long requiredMinperDay, LocalDate actualDay){
    
        this.requiredMinPerDay = requiredMinperDay;
        this.actualDay = actualDay;
    }
    
    public WorkDay(long requiredMinperDay, int year, int month, int day){
    
        new WorkDay(requiredMinperDay, LocalDate.of(year, month, day));
    }
    
    public WorkDay(String requiredMinperDay, String actualDay){
        
        int year = Integer.parseInt(actualDay.substring(0, 4));
        int mont = Integer.parseInt(actualDay.substring(4, 6));
        int day = Integer.parseInt(actualDay.substring(6, 8));
        
        new WorkDay(Long.parseLong(requiredMinperDay), year, mont, day);
    }

    public long getRequiredMinPerDay() {
        return requiredMinPerDay;
    }

    public long getSumPerDay() {
        
        if( sumPerDay != 0 ) return sumPerDay;
        return tasks.stream().mapToLong(Task::getMinPerTask).sum();
    }

    public LocalDate getActualDay() {
        return actualDay;
    }    
    
    public long getExtraMinPerDay(){
    
        return getSumPerDay() - getRequiredMinPerDay();
    }
    
    public boolean isSeparatedTime(Task task){
        
        return tasks.stream().filter( i -> i.getEndTime().isAfter(task.getStartTime())  ).count() != 0;              
    }
    
    public void addTask(Task task){
    
        if( task.isMultipleQuarterHour() && !isSeparatedTime(task) ){
        
            tasks.add(task);
            sumPerDay = 0;
            return;
        }
        return;            
    }
    
    public boolean isWeekDay(){
    
        return actualDay.getDayOfWeek() != DayOfWeek.SATURDAY || actualDay.getDayOfWeek() != DayOfWeek.SUNDAY; 
    }
}
