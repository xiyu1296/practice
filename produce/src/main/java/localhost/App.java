package localhost;

import localhost.client.ChatEntryFrame;

import java.io.IOException;

public class App {
    public static void main(String[] args){

        try {

            new ChatEntryFrame();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}