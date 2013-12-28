/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reformatstring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StreamReader {
    BufferedReader _buffer;

    public StreamReader(BufferedReader stream) {
        _buffer = stream;
    }

    public StreamReader(String FilePath) throws FileNotFoundException {
        _buffer = new BufferedReader(new FileReader(FilePath));
    }

    public int Read() throws IOException {
        return _buffer.read();
    }

    public int Read(char[] buffer, int index, int count) throws IOException {
        return _buffer.read(buffer, index, count);
    }

    public String ReadLine() throws IOException {
        return _buffer.readLine();
    }

    public String ReadToEnd() throws IOException {
        String data = "", line;
        while ((line = _buffer.readLine()) != null)
            data += line + "\n";
        _buffer.close();
        return data;
    }

    public String ToString() {
        return _buffer.toString();
    }

    public void Close() throws IOException {
        _buffer.close();
    }
}
