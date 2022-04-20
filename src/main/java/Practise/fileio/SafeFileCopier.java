package Practise.fileio;

import java.io.*;

public class SafeFileCopier {
    public static void main(String[] args) {

    }

    public static void copy(File inFile, File outFile) throws IOException {
        if(inFile.getCanonicalPath().equals(outFile.getCanonicalPath())){
            //no copying required since both files are same
            return;
        }
        InputStream in = null;
        OutputStream out = null;

        try{
            in= new BufferedInputStream(new FileInputStream(inFile));
            out = new BufferedOutputStream(new FileOutputStream(outFile));
            for(int i = in.read();i!=-1;i= in.read()){
                out.write(i);
            }
        }finally {
           if(in != null) in.close();
           if(out != null) out.close();
        }
    }
}
