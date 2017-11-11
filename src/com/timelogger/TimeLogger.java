package com.timelogger;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rkissvincze
 */
public class TimeLogger {
    
    private List<WorkMonth> months = new ArrayList<>();

    public List<WorkMonth> getMonths() {
        return months;
    }
    
    public boolean isNewMonth(WorkMonth workMonth){
    
        return months.stream().filter(i -> i.getDate().equals( workMonth.getDate() ) ).count() == 0;
    }
    
    public void addMonth(WorkMonth workMonth) throws NotNewDateException{
    
        if( isNewMonth(workMonth) ){
        
            months.add(workMonth);
            return;
        }else{ throw new NotNewDateException(" The month (" + workMonth.toString() + ") already exists. Give an another."); }
    }
}
