package ca.ubc.cpsc210.todo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Manages the to-do item list. Handles searches, additions and edits
 */
public class TodoList {

	private ArrayList<TodoItem> todoItems;

	// Constructs TodoList by initializing fields. Creates a new list if todoItems.
	public TodoList() {
		 todoItems=new ArrayList<TodoItem>();
	}

	// MODIFIES: this
	// EFFECTS: a new todoItem is created and added to the to-do list
	public void addTodoItem(String title, String description, Date dueDate) {
		TodoItem t=new TodoItem(title,description,dueDate);
		todoItems.add(t);
	}

	// EFFECTS: returns the to-do list
	public List<TodoItem> getAllTodoItems() {
		return todoItems;
	}

	// REQUIRES: index is a non-negative integer that is less than the number of
	// to-do items
	// EFFECTS: returns the to-do item at the specified position
	public TodoItem getTodoItemByIndex(int index) {
		return todoItems.get(index);
	}

	// EFFECTS: returns the to-do item with the specified id or null
	// if no item with that id exists
	public TodoItem getTodoItemById(String idOfItemToFind) {
		for (TodoItem t:todoItems){
 	if (t.getId().equals(idOfItemToFind)){
		return t;
	}
		}
		return null;
	}

	// REQUIRES: idToFind is an id for an item in the to-do list
	// MODIFIES: this
	// EFFECTS: updates the to-do item with the specified id in the to-do list
	public void updateTodoItem(String idToFind, String title,
			String description, Date dueDate) {
		TodoItem t=getTodoItemById(idToFind);
		t.setTitle(title);
		t.setDescription(description);
		t.setDueDate(dueDate);
	}

	// EFFECTS: returns a list of incomplete to-do items
	public List<TodoItem> filterTodoItemsByIncompletion() {
		List<TodoItem> list = new ArrayList<TodoItem>();
		for (TodoItem t : todoItems) {
			if (!t.isCompleted()) {
				list.add(t);
			}
		}
			return list;
		}
public boolean notcontain(TodoItem t,List<TodoItem> list){
	for (TodoItem t1 : list) {
		if (t1==t){
			return false;
		}
	}
	return true;
	}

	// EFFECTS: returns a list of to-do items whose title and/or description
	// contains the search parameter
	// Note: String comparisons are case sensitive
	public List<TodoItem> filterTodoItemsBySearchTerm(String searchString) {
		List<TodoItem> list = new ArrayList<TodoItem>();
		for (TodoItem t : todoItems) {
			if (t.getTitle().toLowerCase().contains(searchString.toLowerCase())&&notcontain(t, list)) {
				list.add(t);
			}
		}
		for (TodoItem t : todoItems) {
			if (t.getDescription().toLowerCase().contains(searchString.toLowerCase())&&notcontain(t, list)) {
				list.add(t);
			}
		}
		return list;
	}
}
