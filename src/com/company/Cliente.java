package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {

        Socket cliente = new Socket("10.0.0.100", 3000);
        System.out.println("Conexão executada!!!!");
        DataInputStream clienteRecebe = new DataInputStream(cliente.getInputStream());
        DataOutputStream clienteEnvia = new DataOutputStream(cliente.getOutputStream());

        System.out.println("Digite sua mensagem para o Servidor");
        Scanner input = new Scanner(System.in);
        String msg = input.nextLine();
        clienteEnvia.writeUTF(msg);
        System.out.println("Você enviou para o servidor: ");
        System.out.println(msg);

        int resServidor = clienteRecebe.readInt();
        System.out.println("O servidor respondeu: ");
        System.out.println(resServidor);

        clienteRecebe.close();
        clienteEnvia.close();
        cliente.close();
    }
}
