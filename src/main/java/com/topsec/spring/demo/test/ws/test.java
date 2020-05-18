package com.topsec.spring.demo.test.ws;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ：zz
 * @date ：Created in 2020/5/14 9:00
 */
public class test {
    public static void main(String[] args) throws IOException {

        WebSocket webSocket = new WebSocket();

        CopyOnWriteArraySet<WebSocket> webSocketSet = WebSocket.webSocketSet;
        webSocket.onOpen(webSocket.session);

    }
}
