# JTodoList

A simple command-line Todo List application written in Java, using a file for data persistence.

## Features

- Add tasks with a name and description
- Mark tasks as completed
- Delete tasks
- View all tasks
- Save and load tasks from a file

## Project Structure

- `TodoNoGui/src/Main.java`: Main entry point (CLI)
- `TodoNoGui/src/Todo/Todo.java`: Todo list logic and file persistence
- `TodoNoGui/src/Task/Task.java`: Task model
- `TodoNoGui/todolist.txt`: Default file for storing tasks

## Usage

### Compile

Navigate to the `TodoNoGui/src` directory and compile the Java files:

```sh
javac Main.java Todo/Todo.java Task/Task.java
```

### Run

Run the application from the `src` directory:

```sh
java Main
```

### Menu Options

When running, you will see a menu:

```
1. Add
2. Complete
3. Delete
4. Show
5. Save
6. Load
0. Exit
```

- **Add**: Enter the task name and description (each on a new line).
- **Complete**: Enter the index of the task to mark as completed.
- **Delete**: Enter the index of the task to delete.
- **Show**: Display all tasks.
- **Save**: Save the current list to `todolist.txt`.
- **Load**: Load tasks from `todolist.txt`.
- **Exit**: Quit the application.

## Data Persistence

Tasks are saved in `todolist.txt` in the following format:

```
Save in DateYYYY-MM-DD
0;false;TaskName;Description
1;true;AnotherTask;Description
...
```

## Requirements

- Java 18 or compatible JDK

## License

This project is for educational purposes.
