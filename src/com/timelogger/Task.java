/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timelogger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


/**
 *
 * @author rkissvincze
 */
public class Task {
    
    private String taskID;
    private LocalTime startTime;
    private LocalTime endTime;
    private String comment;
    
   
    public Task(String taskId, String comment, LocalTime startTime, LocalTime endtime){
        
        this.taskID = taskId;
        this.comment = comment;
        this.startTime = startTime;
        this.endTime = endtime;        
    }
    
    public Task(String taskId, String comment, int startHour, int startMin, int endHour, int endMin){        
    
        this( taskId, comment, LocalTime.of(startHour, startMin), LocalTime.of(endHour, endMin));
    }
    
    public Task(String taskId, String commnet, String startTime, String endTime){
        
        this( taskId, commnet, LocalTime.parse(startTime, DateTimeFormatter.ISO_TIME), LocalTime.parse(endTime, DateTimeFormatter.ISO_TIME)  );
        
    }
    
    public Task(String taskId, String commnet, String startTime){
        
        this( taskId, commnet, LocalTime.parse(startTime, DateTimeFormatter.ISO_TIME), null  );
        
    }
    
    public Task(String taskId, String commnet, LocalTime startTime){
        
        this( taskId, commnet, startTime, null  );
        
    }
    
    public Task(String taskId){
    
        this.taskID = taskId;
    }

    public String getTaskID() {
        return taskID;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getComment() {
        return comment;
    }
    
    public long getMinPerTask(){
        
        if( startTime != null && endTime != null ) return ChronoUnit.MINUTES.between(startTime, endTime);
        return -1;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public void setStartTime(int hour, int minnute) {
        
        this.startTime = LocalTime.of(hour, minnute);
    }
    
    public void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime, DateTimeFormatter.ISO_TIME);
    }
    
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(int hour, int minnute) {
        
        this.endTime = LocalTime.of(hour, minnute);
    }
    
    public void setEndTime(String endTime) {
        
        this.endTime = LocalTime.parse(endTime, DateTimeFormatter.ISO_TIME);
    }
    
    public void setEndTime(LocalTime endTime) {
        System.out.println("Tasl endTime modifing.......");
        this.endTime = endTime;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public boolean isValidTaskId(){
    
        return taskID.matches("\\d{4}") || taskID.matches("LT-\\d{4}");
    }

    @Override
    public String toString() {
        return "Task: " + taskID + ", " + comment + ", " + startTime + ", " + endTime ;
    }
    
    
}
