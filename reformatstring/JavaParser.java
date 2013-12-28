/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reformatstring;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Vlad
 */
public class JavaParser {
    private String _javaCode;
    private final String[] operators = {
        "=", "+", "-", "*", "/", "!", "^", "|", "&", "<", ">"
    };
    private final String[] compOperators = {
        "> =", "< =", "* =", "/ =", "+ =", "! =", "- =", "= =", "| |", "& &", "* /", "/ *", "- -", "+ +"
    };
    private final String[] annotations = {
        "@Override", "@Deprecated", "@SupressWarnings", "@Documented", "@Inherited", "@Interface"
    };
    private final String notBetweenQuotes = "(?=([^\\\"']*[\\\"'][^\\\"']*[\\\"'])*[^\\\"']*$)", notBetweenParentheses = "(?=[^()]*(\\(|$))";
        
    private void Normalize(){
        /* Remove new lines from source code */
        _javaCode = _javaCode.replaceAll("\n", " ");
        
        /* Replace operators with correct spacing */
        for(String op : operators)
            _javaCode = _javaCode.replaceAll("\\" + op + notBetweenQuotes, " " + op + " ");
        
        /* Normalize code spacing */
        
        _javaCode = _javaCode.replaceAll("\\s+" + notBetweenQuotes, " ");
        
        /* Correct spacing between composed operators */
        for(String op : compOperators){
            String[] o = op.split(" ");
            _javaCode = _javaCode.replaceAll("\\" + o[0] + " " + "\\" + o[1] + notBetweenQuotes, op.replace(" ", ""));
        }
        
        /*  indent code */
        //_javaCode = _javaCode.replace("/" , "*/\n");
        //_javaCode = _javaCode.replace("/*", "\n/*");
        _javaCode = _javaCode.replaceAll(";" + notBetweenQuotes + notBetweenParentheses, ";\n");
        _javaCode = _javaCode.replaceAll("[)](?=[^;a-zA-Z{.])" + notBetweenQuotes + notBetweenParentheses, ")\n\t");
        _javaCode = _javaCode.replace(")\n\t throws", ") throws");
        for(String anno:annotations)
            _javaCode = _javaCode.replaceAll(anno + notBetweenQuotes, anno + "\n");
        _javaCode = _javaCode.replaceAll("[*]/" + notBetweenQuotes, "*/\n");
        _javaCode = _javaCode.replaceAll("[{]" + notBetweenQuotes, "{\n");
        _javaCode = _javaCode.replaceAll("[}]" + notBetweenQuotes, "}\n\n");
        _javaCode = _javaCode.replaceAll("}\n\n;" + notBetweenQuotes, "\n};");
        
        String[] lines = _javaCode.split("\n");
        _javaCode = "";
        int tab = 0;
        
        for(String line : lines){
            String tabs = "";

            if(line.matches(".*[}]" + notBetweenQuotes + ".*"))
                tab--;    
            
            for(int i = 0; i < tab; i++)
                tabs += "\t";
            
            _javaCode += tabs + line + "\n";
            
            if(line.matches(".*[{]" + notBetweenQuotes))
                tab++;        
        }
        System.gc();
    }
    
    public JavaParser(){
        _javaCode = "";
    }
    
    public JavaParser(String sourceCode){
        _javaCode = sourceCode;
        Normalize();            
    }
    
    @Override
    public String toString(){
        return _javaCode;
    }
    
    public void ParseFromFile(String fileName) throws FileNotFoundException, IOException{
        _javaCode = (new StreamReader(fileName)).ReadToEnd();
        Normalize();
    }
    
}
