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
    
    public Task(String taskId, String comment, int startHour, int startMin, int endHour, int endMin){
        
        this.taskID = taskId;
        this.comment = comment;
        this.startTime = LocalTime.of(startHour, startMin);
        this.startTime = LocalTime.of(endHour, endMin);        
    }
    
    public Task(String taskId, String commnet, String startTime, String endTime){
        
        this.taskID = taskId;
        this.comment = commnet;
        this.startTime = LocalTime.parse(startTime, DateTimeFormatter.ISO_TIME);
        this.endTime = LocalTime.parse(endTime, DateTimeFormatter.ISO_TIME);
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
        
        return ChronoUnit.MINUTES.between(startTime, endTime);
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

    public void setEndTime(int hour, int minnute) {
        
        this.endTime = LocalTime.of(hour, minnute);
    }
    
    public void setEndTime(String startTime) {
        
        this.endTime = LocalTime.parse(startTime, DateTimeFormatter.ISO_TIME);
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public boolean isValidTaskId(){
    
        return taskID.matches("\\d{4}") || taskID.matches("LT-\\d{4}");
    }
    
    public boolean isMultipleQuarterHour(){
    
        return getMinPerTask() % 15 == 0;
    }
}
