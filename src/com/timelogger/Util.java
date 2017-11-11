package com.timelogger;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author rkissvincze
 */
public class Util {
    
    public static LocalTime roundToMultipleQuarterHour( LocalTime startTime, LocalTime endTime ){
    
        long duration = ChronoUnit.MINUTES.between(startTime, endTime);
        long minutes = duration % 15 < 8 ? duration / 15 * 15 : ( duration / 15 + 1 ) * 15;
        return startTime.plusMinutes(minutes);
    }

    public static boolean isMultipleQuarterHour(Task task) {
        return task.getMinPerTask() % 15 == 0;
       /* int endT = task.getEndTime() == null ? 0 : task.getEndTime().getMinute() % 15;
        return task.getStartTime().getMinute() % 15 == 0 && endT == 0;  */
    }

    public static boolean isWeekDay(WorkDay workDay) {
        return workDay.getActualDay().getDayOfWeek() != DayOfWeek.SATURDAY || workDay.getActualDay().getDayOfWeek() != DayOfWeek.SUNDAY;
    }

    public static boolean isSeparatedTime(Task task, WorkDay workDay) {
    //    return workDay.getTasks().stream().filter( i -> i.getEndTime().isAfter(task.getStartTime()) 
    //                    || i.getEndTime().equals(task.getStartTime())  ).count() > 0;
        if( workDay.getTasks().isEmpty() ) return false;
        return workDay.getLastTaskEndTime().isAfter(task.getStartTime());
    }
    
    public static boolean isCorrectTimeOrder(Task task){
        if( task.getEndTime() == null ) return true;
        return task.getStartTime().isBefore(task.getEndTime());
    }

    static boolean isTimeNull( Task task ) {
        return task.getStartTime() == null || task.getEndTime() == null;      
    }
    
    static  boolean isFutureDay(WorkDay workDay){
        return workDay.getActualDay().isAfter(LocalDate.now());
    }
}
