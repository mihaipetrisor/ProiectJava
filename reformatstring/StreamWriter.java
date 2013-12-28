/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reformatstring;

import java.io.*;

public class StreamWriter {
    BufferedWriter _buffer;

    public StreamWriter(BufferedWriter buffer) {
        _buffer = buffer;
    }

    public StreamWriter(String FilePath) throws FileNotFoundException, IOException {
        File temp = new File(FilePath);
        if (!temp.exists())
            temp.createNewFile();
        _buffer = new BufferedWriter(new FileWriter(FilePath));
    }

    public StreamWriter(String FilePath, Boolean appendToFile) throws FileNotFoundException, IOException {
        File temp = new File(FilePath);
        if (!temp.exists())
            temp.createNewFile();
        _buffer = new BufferedWriter(new FileWriter(FilePath, appendToFile));
    }

    public void Write(String str) throws IOException {
        _buffer.write(str);
    }

    public void Write(int num) throws IOException {
        _buffer.write(Integer.toString(num));
    }

    public void Write(double num) throws IOException {
        _buffer.write(Double.toString(num));
    }

    public void Write(float num) throws IOException {
        _buffer.write(Float.toString(num));
    }

    public void Write(byte num) throws IOException {
        _buffer.write(Byte.toString(num));
    }

    public void Write(boolean num) throws IOException {
        _buffer.write(Boolean.toString(num));
    }

    public void Write(Object obj) throws IOException {
        _buffer.write(obj.toString());
    }

    public void Write(char chr) throws IOException {
        _buffer.write(chr);
    }

    public void Write(short num) throws IOException {
        _buffer.write(Short.toString(num));
    }

    public void WriteLine(String str) throws IOException {
        _buffer.write(str );
        _buffer.newLine();
    }

    public void WriteLine(int num) throws IOException {
        _buffer.write(Integer.toString(num) );
        _buffer.newLine();
    }

    public void WriteLine(double num) throws IOException {
        _buffer.write(Double.toString(num) );
        _buffer.newLine();
    }

    public void WriteLine(float num) throws IOException {
        _buffer.write(Float.toString(num));
        _buffer.newLine();
    }

    public void WriteLine(byte num) throws IOException {
        _buffer.write(Byte.toString(num) );
        _buffer.newLine();
    }

    public void WriteLine(boolean num) throws IOException {
        _buffer.write(Boolean.toString(num) );
        _buffer.newLine();
    }

    public void WriteLine(Object obj) throws IOException {
        _buffer.write(obj.toString() );
        _buffer.newLine();
    }

    public void WriteLine(char chr) throws IOException {
        _buffer.write(chr );
        _buffer.newLine();
    }

    public void WriteLine(short num) throws IOException {
        _buffer.write(Short.toString(num) );
        _buffer.newLine();
    }

    public void Close()     throws IOException
    {
        _buffer.close();
    }
}

