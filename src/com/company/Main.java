package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        int port = 3000;
        ServerSocket servidor = new ServerSocket(port);
        System.out.println("Servidor Aguardando conexão do Cliente.");
        Socket socketServidor = servidor.accept();
        System.out.println("Cliente conectado a porta: "+port);

        DataInputStream servidorRecebe = new DataInputStream(socketServidor.getInputStream());
        DataOutputStream servidorEnvia = new DataOutputStream(socketServidor.getOutputStream());

        String msgCliente = servidorRecebe.readUTF();
        int respostaServidor = msgCliente.length();
        servidorEnvia.writeInt(respostaServidor);

        System.out.println("Cliente enviou esta mensagem: "+msgCliente);
        System.out.println("@@@@@--Servidor configurado para contar a quantidade de Caracteres enviada pelo Cliente--@@@@@");
        System.out.println("Resposta enviada para o cliente");
        System.out.println(respostaServidor);

        servidorRecebe.close();
        servidorEnvia.close();
        socketServidor.close();


    }
}
