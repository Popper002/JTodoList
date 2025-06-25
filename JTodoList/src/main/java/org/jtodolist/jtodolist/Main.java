package org.jtodolist.jtodolist;

import Todo.Todo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Todo lista = new Todo();
        Scanner scanner = new Scanner(System.in);
        String scelta;

        while (true) {
            System.out.println("\n1. Aggiungi\n2. Completa\n3. Elimina\n4. Mostra\n5. Salva\n6. Carica\n0. Esci");
            scelta = scanner.nextLine();

            try {
                switch (scelta) {
                    case "1":
                        System.out.print("Descrizione: ");
                        lista.addTask(scanner.nextLine(), scanner.nextLine());
                        break;
                    case "2":
                        System.out.print("Indice da completare: ");
                        lista.printListOfTask();
                        lista.completa(Integer.parseInt(scanner.nextLine()));
                        break;
                    case "3":
                        System.out.print("Indice da eliminare: ");
                        lista.printListOfTask();
                        lista.elimina(Integer.parseInt(scanner.nextLine()),"todolist.txt");
                        break;
                    case "4":
                        lista.printListOfTask();
                        break;
                    case "5":
                        lista.saveListOfTaskOnFile("todolist.txt");
                        System.out.println("Salvato.");
                        break;
                    case "6":
                        lista.fillListFromFile("todolist.txt");
                        System.out.println("Caricato.");
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Scelta non valida.");
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
    }
}