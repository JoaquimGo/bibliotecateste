/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.biblioteca2;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author joaquimfilho
 */
class Livro {
    String titulo;
    String autor;
    int anoPublicacao;
    boolean disponivel;

    Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Ano de Publicação: " + anoPublicacao;
    }
}

class Biblioteca {
    ArrayList<Livro> livros;

    Biblioteca() {
        livros = new ArrayList<>();
    }

    void adicionarLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o título do livro:");
        String titulo = scanner.nextLine();
        System.out.println("Informe o autor do livro:");
        String autor = scanner.nextLine();
        System.out.println("Informe o ano de publicação do livro:");
        int anoPublicacao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        Livro novoLivro = new Livro(titulo, autor, anoPublicacao);
        livros.add(novoLivro);
        System.out.println("Livro adicionado com sucesso!");
    }

    Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.titulo.equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("A biblioteca está vazia.");
        } else {
            System.out.println("Livros disponíveis na biblioteca:");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    void emprestarLivro(String titulo) {
        Livro livro = buscarLivro(titulo);
        if (livro != null && livro.disponivel) {
            livro.disponivel = false;
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro não disponível para empréstimo.");
        }
    }

    void devolverLivro(String titulo) {
        Livro livro = buscarLivro(titulo);
        if (livro != null && !livro.disponivel) {
            livro.disponivel = true;
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Livro não encontrado ou já disponível.");
        }
    }
}

public class Main {
    
    
    public static void main(String[] args) {
        Scanner menu = new Scanner (System.in);
        Biblioteca biblioteca = new Biblioteca();
        
        while (true) {  
        
         System.out.print("##-- Menu--##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Opção 1 - Adicionar Livros  |\n");
            System.out.print("| Opção 2 - Listar todos      |\n");
            System.out.print("| Opção 3 - Buscar livros     |\n");
            System.out.print("| Opção 4 - Sair              |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");
            
            int opcao = menu.nextInt();

            if (opcao == 4) {
                System.out.print("\nAté logo!");
                menu.close(); 
                break;
            }
                
        switch (opcao) {
        case 1 -> {
            // Adicionar alguns livros à biblioteca
            biblioteca.adicionarLivro();
            }


        case 2 -> // Listar todos os livros disponíveis
            biblioteca.listarLivros();

        case 3 -> {
            // Realizar buscas por título de livro
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o título do livro a ser buscado:");
            String tituloBusca = scanner.nextLine();
            Livro livroEncontrado = biblioteca.buscarLivro(tituloBusca);
                    if (livroEncontrado != null) {
                        System.out.println("Livro encontrado: " + livroEncontrado);
                    } else {
                        System.out.println("Livro não encontrado na biblioteca.");
                    }
              
                }
                  
        
        // Realizar empréstimo e devolução de livros
        //biblioteca.emprestarLivro("Título do livro para empréstimo");
        //biblioteca.devolverLivro("Título do livro para devolução");
    }
   }
  }
}
    