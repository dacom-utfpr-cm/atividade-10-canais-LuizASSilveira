package ex1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;


public class Produtor extends Thread {
    private Pipe pipe;
    private Pipe.SinkChannel sinkChannel;
    private ByteBuffer buf;

    public Produtor(Pipe pipe) {
        this.pipe = pipe;
        this.sinkChannel = pipe.sink();
        this.buf = ByteBuffer.allocate(48);
    }

    @Override
    public void run() {
        String newData = "Mensagem Produtor 1";
        this.buf.clear();
        this.buf.put(newData.getBytes());
        this.buf.flip();

        while (this.buf.hasRemaining()){
            try {
                sinkChannel.write(this.buf);
            } catch (IOException e) { e.printStackTrace(); }
        }


    }
}
