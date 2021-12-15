package com.letscode.jogoDaVelha;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] tabuleiro = {
                {'_', '|','_','|','_'},
                {'_', '|','_','|','_'},
                {'_', '|','_','|','_'}
        };
        int player = 1;
        boolean hasWinner = false;
        int play = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite 1 para jogar contra a CPU e 2 para jogar com outra pessoa");
        int gameChoice = scanner.nextInt();

        while(!hasWinner){
            if(play>8){
                System.out.println("Ninguém ganhou!");
                break;
            }
            play++;
            if(player==1){

                while (true) {
                    int position;
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Vez do jogador " + player);
                    position = sc.nextInt();
                    if(atualizarTabuleiro(position, player, tabuleiro,gameChoice)){

                        if(checkHorizontals('x',tabuleiro)){
                            System.out.println("ACABOU e o jogador 1 ganhou");
                            hasWinner = true;
                            break;
                        } else if(checkVerticals('x',tabuleiro)){
                            System.out.println("ACABOU e o jogador 1 ganhou");
                            hasWinner = true;
                            break;
                        } else if(checkDiagonals('x',tabuleiro)){
                            System.out.println("ACABOU e o jogador 1 ganhou");
                            hasWinner = true;
                            break;
                        }
                        player = 2;
                        break;
                    }


                }
            } else {
                while (true){
                    int position;
                    if(gameChoice>=2) {
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Vez do jogador " + player);
                        position = sc.nextInt();
                    } else {
                        position = (int)  (Math.random()*8)+1;
                    }
                    if(atualizarTabuleiro(position,2,tabuleiro,gameChoice)){
                        if(checkHorizontals('O',tabuleiro)){
                            System.out.println("ACABOU e o jogador 2 ganhou");
                            hasWinner = true;
                            break;
                        } else if(checkVerticals('O',tabuleiro)){
                            System.out.println("ACABOU e o jogador 2 ganhou");
                            hasWinner = true;
                            break;
                        } else if(checkDiagonals('O',tabuleiro)){
                            System.out.println("ACABOU e o jogador 2 ganhou");
                            hasWinner = true;
                            break;
                        }

                        player = 1;
                        break;
                    }

                }

            }
        }

    }
    public static void  printTabuleiro(char[][]tabuleiro){
        for(char[]row:tabuleiro){
            for (char column:row){
                System.out.print(column);
            }
            System.out.println();
        }
    }

    public static boolean checkHorizontals(char character,char[][]tabuleiro){
        return (tabuleiro[0][0] == character && tabuleiro[0][2] == character && tabuleiro[0][4] == character) || (tabuleiro[1][0] == character && tabuleiro[1][2] == character && tabuleiro[1][4] == character || (tabuleiro[2][0] == character && tabuleiro[2][2] == character && tabuleiro[2][4] == character));

    }

    public static boolean checkVerticals(char character,char[][]tabuleiro){
        return (tabuleiro[0][0] == character && tabuleiro[1][0] == character && tabuleiro[2][0] == character) || (tabuleiro[0][2] == character && tabuleiro[1][2] == character && tabuleiro[2][2] == character) || (tabuleiro[0][4] == character && tabuleiro[1][4] == character && tabuleiro[2][4] == character);
    }

    public static boolean checkDiagonals(char character,char[][]tabuleiro){
        return (tabuleiro[0][0] == character && tabuleiro[1][2] == character && tabuleiro[2][4] == character) || (tabuleiro[0][4] == character && tabuleiro[1][2] == character && tabuleiro[2][0] == character);
    }

    public static boolean atualizarTabuleiro(int posicao,int jogador,char[][]tabuleiro, int gameChoice){
        boolean isValid = false;
        char character;
        if(jogador==1){
            character = 'x';
        } else {
            character = 'O';
        }

        switch (posicao){
            case 1:
                if(tabuleiro[0][0]=='_') {
                    tabuleiro[0][0] = character;
                    System.out.println("SUA JOGADA");
                    printTabuleiro(tabuleiro);
                    isValid = true;
                    break;
                }
                if(jogador==1 || gameChoice>=2){
                    System.out.println("Essa não foi uma jogada válida! Escolha outra posição no tabuleiro de 1 a 9");
                }
                break;
            case 2:
                if(tabuleiro[0][2] == '_'){
                    tabuleiro[0][2] = character;
                    System.out.println("SUA JOGADA");
                    printTabuleiro(tabuleiro);
                    isValid = true;
                    break;
                }
                if(jogador==1 || gameChoice>=2){
                    System.out.println("Essa não foi uma jogada válida! Escolha outra posição no tabuleiro de 1 a 9");
                }
                break;

            case 3:
                if(tabuleiro[0][4] == '_'){
                    tabuleiro[0][4] = character;
                    System.out.println("SUA JOGADA");
                    printTabuleiro(tabuleiro);
                    isValid = true;
                    break;
                }
                if(jogador==1 || gameChoice>=2){
                    System.out.println("Essa não foi uma jogada válida! Escolha outra posição no tabuleiro de 1 a 9");
                }
                break;
            case 4:
                if(tabuleiro[1][0] == '_'){
                    tabuleiro[1][0] = character;
                    System.out.println("SUA JOGADA");
                    printTabuleiro(tabuleiro);
                    isValid = true;
                    break;
                }
                if(jogador==1 || gameChoice>=2){
                    System.out.println("Essa não foi uma jogada válida! Escolha outra posição no tabuleiro de 1 a 9");
                }
                break;

            case 5:
                if(tabuleiro[1][2] == '_') {
                    tabuleiro[1][2] = character;
                    System.out.println("SUA JOGADA");
                    printTabuleiro(tabuleiro);
                    isValid = true;
                    break;
                }
                if(jogador==1 || gameChoice>=2){
                    System.out.println("Essa não foi uma jogada válida! Escolha outra posição no tabuleiro de 1 a 9");
                }
                break;
            case 6:
                if(tabuleiro[1][4] == '_') {
                    tabuleiro[1][4] = character;
                    System.out.println("SUA JOGADA");
                    printTabuleiro(tabuleiro);
                    isValid = true;
                    break;
                }
                if(jogador==1 || gameChoice>=2){
                    System.out.println("Essa não foi uma jogada válida! Escolha outra posição no tabuleiro de 1 a 9");
                }
                break;
            case 7:
                if(tabuleiro[2][0] == '_') {
                    tabuleiro[2][0] = character;
                    System.out.println("SUA JOGADA");
                    printTabuleiro(tabuleiro);
                    isValid = true;
                    break;
                }
                if(jogador==1 || gameChoice>=2){
                    System.out.println("Essa não foi uma jogada válida! Escolha outra posição no tabuleiro de 1 a 9");
                }
                break;
            case 8:
                if(tabuleiro[2][2] == '_') {
                    tabuleiro[2][2] = character;
                    if(jogador==1){
                        System.out.println("SUA JOGADA");
                    } else {
                        System.out.println("JOGADA DO COMPUTADOR");
                    }

                    printTabuleiro(tabuleiro);
                    isValid = true;
                    break;
                }
                if(jogador==1 || gameChoice>=2){
                    System.out.println("Essa não foi uma jogada válida! Escolha outra posição no tabuleiro de 1 a 9");
                }
                break;
            case 9:
                if(tabuleiro[2][4] == '_') {
                    tabuleiro[2][4] = character;
                    System.out.println("SUA JOGADA");
                    printTabuleiro(tabuleiro);
                    isValid = true;
                    break;
                }
                if(jogador==1 || gameChoice>=2){
                    System.out.println("Essa não foi uma jogada válida! Escolha outra posição no tabuleiro de 1 a 9");
                }
                break;
            default:
                System.out.println("Essa não foi uma jogada válida! Escolha outra posição no tabuleiro de 1 a 9");
                break;
        }
        return isValid;
    }
}