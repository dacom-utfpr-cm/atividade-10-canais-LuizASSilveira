package ex1;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;


public class Consumidor extends Thread{
    private Pipe pipe;

    public Consumidor(Pipe pipe) {
        this.pipe = pipe;
    }

    @Override
    public void run(){
        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer buf = ByteBuffer.allocate(48);
        try {
            int bytesRead = sourceChannel.read(buf);
            System.out.println(bytesRead);
            
        } catch (IOException e) { e.printStackTrace(); }
    }
}
