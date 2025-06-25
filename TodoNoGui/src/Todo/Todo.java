package Todo;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import Task.Task;

import java.util.List;
public class Todo {
    private List<Task>listOfTask = new ArrayList<>();
    private String pathOfPermanenceFile;
    LocalDate localDate = LocalDate.now();

    public String getPathOfPermanenceFile() {
        return pathOfPermanenceFile;
    }

    public void setPathOfPermanenceFile(String pathOfPermanenceFile) {
        this.pathOfPermanenceFile = pathOfPermanenceFile;
    }

    public boolean addTask(String taskName, String description){
        return listOfTask.add(new Task(taskName, description ));
    }
    public List<Task> getListOfTask(){
        return listOfTask;
    }

    public boolean saveListOfTaskOnFile(String filePath){

        try( BufferedWriter bw = new BufferedWriter(new FileWriter(filePath)))
        {
            bw.write("Save in Date"+localDate );
            bw.newLine();
            for (Task task : listOfTask) {
                bw.write(listOfTask.indexOf(task)+";"+task.isCompleted()+";"+task.getTaskName()+";"+task.getDescription());
                bw.newLine();
            }
            return true;
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
            return false;
        }
    }

    public boolean fillListFromFile(String filePath) {
        this.listOfTask.clear(); // Always clean the list

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";", -1); // -1 per includere tutti i campi anche se vuoti

                if (parts.length < 4) {
                    System.out.println("Linea malformata: " + line);
                    continue; // oppure return false;
                }

                String completedStr = parts[1].trim();
                String title = parts[2].trim();
                String description = parts[3].trim();

                Task t = new Task(title, description);

                if (Boolean.parseBoolean(completedStr)) {
                    t.complete();
                }

                listOfTask.add(t);
            }
            return true;
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
            return false;
        }
    }

    public void printListOfTask(){
        System.out.println("List Of uncompleted tasks:");
        listOfTask.forEach(task -> System.out.println(task.toString()));
    }

    public boolean elimina(int indice,String filepath)
    {

        this.listOfTask.remove(indice);
        try {
            removeFromFile(indice,filepath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public boolean removeFromFile(int indice, String filepath) throws IOException {
        File inputFile = new File(filepath);
        File tempFile = new File(filepath + ".tmp");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

        String line;
        String target = String.valueOf(indice).trim();
        while ((line = reader.readLine()) != null) {
            if (!line.trim().equals(target)) {
                writer.println(line);
            }
        }

        reader.close();
        writer.close();

        // Sovrascrivi il file originale con quello temporaneo
        if (!inputFile.delete()) {
            return false;
        }
        if (!tempFile.renameTo(inputFile)) {
            return false;
        }

        return true;
    }

    public void completa(int indice){
        this.listOfTask.get(indice).complete();
    }


}
