package com.view;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务器
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(9878);
            ExecutorService service = Executors.newFixedThreadPool(20);
            while (true){
                Socket accept = socket.accept();
                ServerDataProcession sdp = new ServerDataProcession(accept);
                service.submit(sdp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
