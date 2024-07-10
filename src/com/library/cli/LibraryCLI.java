package com.library.cli;

import com.library.config.ConfigurationManager;
import com.library.facade.LibraryFacade;
import com.library.model.*;
import com.library.model.composite.BookCategoryComposite;

import java.util.List;
import java.util.Scanner;

public class LibraryCLI {
    private LibraryFacade facade = new LibraryFacade();
    ConfigurationManager configManager = ConfigurationManager.getInstance();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String libraryName = configManager.getLibraryName();
        while (true) {
            clearScreen();
            System.out.println("Bem vindo a " + libraryName);
            System.out.println("Escolha uma opção:");
            System.out.println("1. Buscar Livros");
            System.out.println("2. Emprestar Livros");
            System.out.println("3. Devolver Livros");
            System.out.println("4. Consultar Informações de Livros");
            System.out.println("5. Consultar Informações de Usuários");
            System.out.println("6. Gerenciar Categorias de Livros");
            System.out.println("7. Adicionar Livros");
            System.out.println("8. Adicionar Usuarios");
            System.out.println("9. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    searchBooks(scanner);
                    break;
                case 2:
                    borrowBook(scanner);
                    break;
                case 3:
                    returnBook(scanner);
                    break;
                case 4:
                    getBookInfo(scanner);
                    break;
                case 5:
                    getUserInfo(scanner);
                    break;
                case 6:
                    manageCategories(scanner);
                    break;
                case 7:
                    addBooks(scanner);
                    break;
                case 8:
                    addUser(scanner);
                    break;
                case 9:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private void addUser(Scanner scanner) {
        boolean aux = true;
        while (aux) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Adicionar Professor");
            System.out.println("3. Adicionar Funcionario");
            System.out.println("4. Cancelar");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    aux = false;
                    break;
                case 2:
                    addTeacher(scanner);
                    aux = false;
                    break;
                case 3:
                    addStaff(scanner);
                    aux = false;
                    break;
                case 4:
                    System.out.println("Cancelando...");
                    aux = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private void addTeacher(Scanner scanner) {
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite o email:");
        String email = scanner.nextLine();

        TeacherUserType teacherUserType = new TeacherUserType(
                nome,
                email
        );

        boolean success = facade.addUser(teacherUserType);
        if (success) {
            System.out.println("Usuario criado com sucesso.");
        } else {
            System.out.println("Não foi possível criar o usuario.");
        }
    }

    private void addStaff(Scanner scanner) {
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite o email:");
        String email = scanner.nextLine();

        StaffUserType staffUserType = new StaffUserType(
            nome,
            email
        );

        boolean success = facade.addUser(staffUserType);
        if (success) {
            System.out.println("Usuario criado com sucesso.");
        } else {
            System.out.println("Não foi possível criar o usuario.");
        }
    }

    private void addStudent(Scanner scanner) {
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite o email:");
        String email = scanner.nextLine();

        StudentUserType studentUserType = new StudentUserType(
            nome,
            email
        );

        boolean success = facade.addUser(studentUserType);
        if (success) {
            System.out.println("Usuario criado com sucesso.");
        } else {
            System.out.println("Não foi possível criar o usuario.");
        }
    }

    private void addBooks(Scanner scanner) {
        System.out.println("Digite o ID do usuário:");
        String userId = scanner.nextLine();
        System.out.println("Digite o titulo:");
        String title = scanner.nextLine();
        System.out.println("Digite o nome do author:");
        String author = scanner.nextLine();
        System.out.println("Digite o ID da categoria:");
        String category = scanner.nextLine();

        Book book = new Book(
                title,
                author,
                category,
                false
        );

        boolean success = facade.addBook(book, userId);
        if (success) {
            System.out.println("Livro criado com sucesso.");
        } else {
            System.out.println("Não foi possível criar o livro.");
        }
    }



    private void searchBooks(Scanner scanner) {
        System.out.println("Digite o título ou autor do livro:");
        String keyword = scanner.nextLine();
        List<Book> books = facade.searchBooks(keyword);
        if (books.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            System.out.println("Livros encontrados:");
            for (Book book : books) {
                BookCategoryComposite category = facade.getCategoryInfo(book.getCategoryId());
                System.out.println("ID: " + book.getId() + ", Título: " + book.getTitle() + ", Autor: " + book.getAuthor() + ", Categoria: " + category.getName());
            }
        }
    }

    private void borrowBook(Scanner scanner) {
        System.out.println("Digite o ID do livro:");
        String bookId = scanner.nextLine();
        System.out.println("Digite o ID do usuário:");
        String userId = scanner.nextLine();
        boolean success = facade.borrowBook(bookId, userId);
        if (success) {
            System.out.println("Livro emprestado com sucesso.");
        } else {
            System.out.println("Não foi possível emprestar o livro.");
        }
    }

    private void returnBook(Scanner scanner) {
        System.out.println("Digite o ID do livro:");
        String bookId = scanner.nextLine();
        System.out.println("Digite o ID do usuário:");
        String userId = scanner.nextLine();
        boolean success = facade.returnBook(bookId, userId);
        if (success) {
            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("Devolução falhou. Verifique se o livro foi realmente emprestado.");
        }
    }

    private void getBookInfo(Scanner scanner) {
        System.out.println("Digite o ID do livro:");
        String bookId = scanner.nextLine();
        Book book = facade.getBookInfo(bookId);
        if (book != null) {
            BookCategoryComposite category = facade.getCategoryInfo(book.getCategoryId());
            System.out.println("ID: " + book.getId() + ", Título: " + book.getTitle() + ", Autor: " + book.getAuthor() + ", Categoria: " + category.getName() + ", Emprestado: " + book.isBorrowed());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private void getUserInfo(Scanner scanner) {
        System.out.println("Digite o ID do usuário:");
        String userId = scanner.nextLine();
        User user = facade.getUserInfo(userId);
        if (user != null) {
            System.out.println("ID: " + user.getId() + ", Nome: " + user.getName());
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private void manageCategories(Scanner scanner) {
        BookCategoryComposite rootCategory = facade.getRootCategory();
        printCategory(rootCategory, 0);
    }

    private void printCategory(BookCategoryComposite category, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.println(category.getName());
        for (BookCategoryComposite subCategory : category.getSubCategories()) {
            printCategory(subCategory, indent + 1);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        LibraryCLI cli = new LibraryCLI();
        cli.start();
    }
}
