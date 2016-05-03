package ca.ubc.cpsc210.todo.model;

import java.util.Date;

/**
 * Created by Mengyu on 2015/10/4.
 */
public class ScheduledTodoItem extends TodoItem{
    public Date date;
    public ScheduledTodoItem(String title, String description, Date dueDate) {
        super(title, description);

    }
    public Date getDueDate(){
        return date;
    }
    public void setDueDate(Date dueDate){
        date=dueDate;
    }
    public boolean isCompleted(){
        this.date =new Date();
        return false;
    }
    public boolean isHighPriority(){
        return false;
    }
}
