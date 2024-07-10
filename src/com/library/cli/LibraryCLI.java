package com.library.cli;

import com.library.model.Book;
import com.library.service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class LibraryCLI {
    private LibraryService service = new LibraryService();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Buscar Livros");
            System.out.println("2. Emprestar Livros");
            System.out.println("3. Devolver Livros");
            System.out.println("4. Consultar Informações de Livros");
            System.out.println("5. Consultar Informações de Usuários");
            System.out.println("6. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (choice) {
                case 1:
                    // Implementar buscar livros
                    searchBooks(scanner);
                    break;
                case 2:
                    // Implementar emprestar livros
                    break;
                case 3:
                    // Implementar devolver livros
                    break;
                case 4:
                    // Implementar consultar informações de livros
                    break;
                case 5:
                    // Implementar consultar informações de usuários
                    break;
                case 6:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private void searchBooks(Scanner scanner) {
        System.out.println("Digite o título ou autor do livro:");
        String keyword = scanner.nextLine();
        List<Book> books = service.searchBooks(keyword);
        if (books.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            System.out.println("Livros encontrados:");
            for (Book book : books) {
                System.out.println("ID: " + book.getId() + ", Título: " + book.getTitle() + ", Autor: " + book.getAuthor());
            }
        }
    }

    public static void main(String[] args) {
        LibraryCLI cli = new LibraryCLI();
        cli.start();
    }

}
