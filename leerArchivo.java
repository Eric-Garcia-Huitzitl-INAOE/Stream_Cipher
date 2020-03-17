import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class leerArchivo {
    FileReader fr;
    //Constructor leer archivo
    leerArchivo(String nomArch) throws FileNotFoundException{
           //Abrimos archivo
            fr = new FileReader(nomArch);
    }

    //Métodos
   String convToString() throws IOException{
       //Convertimos un texto a un string
      String texto = "";
      int caract = 0;
      while(caract != -1) {
    //Hacer algo con el carácter leído
      caract = fr.read();
      if (caract!=-1) {
        texto = texto + (char)caract;
      }
    }
      return texto;
    }
}
