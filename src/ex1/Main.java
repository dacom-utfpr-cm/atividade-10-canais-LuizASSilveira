package ex1;

import java.io.IOException;
import java.nio.channels.Pipe;

/**
* Implementar o problema do produtor-consumidor usando Java NIO: Pipe, Pipe.SinkChannel e Pipe.SourceChannel
 * @author luiz_
**/

public class Main {
    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();

        Thread produtor = new Thread(new Produtor(pipe));
        produtor.start();

        Thread consumidor = new Thread(new Consumidor(pipe));
        consumidor.start();

    }
}
