import java.util.Random;
import java.lang.Math;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class stream_cipher{

public static void main(String[] args) throws FileNotFoundException, IOException {

String resultado = "";
String resultado2 = "";
String cadBinary = "";
leerArchivo a  = new leerArchivo("alice29.txt");
String prueba = a.convToString();
System.out.println("\n\nCadena original:\n"+prueba);
System.out.println("Cadena binaria:");
cadBinary=convertStringtoBinary(prueba);
System.out.println(cadBinary+"\n\n");
String key_t=generateKey(cadBinary.length());
System.out.println("Llave: \n"+key_t);
resultado = cipher(cadBinary,key_t);
System.out.println("\n\nTexto Cifrado: \n"+resultado);
resultado2 = decipher(resultado,key_t);
System.out.println("\n\nDescifrado: \n"+resultado2);

String af []= convertSubstrings(resultado2); // Convertimos a subcadenas de 7

double res[] = convBinarytoDecimal(af);
System.out.println("\nTexto Descifrado:");
for (int i =0;i<res.length ;i++ ) {
    System.out.print((char)res[i]);
}
System.out.println("\n\n");
}

public static String convertStringtoBinary(String cad){
      String n,cadBinary="";
      int x=0;
      for (int i=0; i<cad.length(); i++){
      x=cad.charAt(i);
      n=Integer.toBinaryString(x); //tiene la cadena

      n=String.format("%08d",Integer.parseInt(n));
      cadBinary=cadBinary.concat(n);
      //System.out.println(cad.charAt(i));
      //System.out.println(x); //this is integer
      //System.out.println(n+"\n"); //this is binary
        }
return cadBinary;
}

public static String Xor(char cad, char key){
    int cadT = Integer.parseInt(Character.toString(cad));
    int keyT = Integer.parseInt(Character.toString(key));
    return String.valueOf(cadT^keyT);
}

public static String generateKey(int size){
String cad="";
for (int i = 0 ;i<size;i++) {
  Random r = new Random();
  int value=r.nextInt(12);
  value = value%2;
  cad=cad.concat(String.valueOf(value));
}
return cad;
}
public static String cipher(String cadBinary,String key_t){
  String resultado="";
  for (int i = 0;i<cadBinary.length();i++){
  resultado = resultado.concat(Xor(cadBinary.charAt(i),key_t.charAt(i)));
  }
  return resultado;
}
public static String decipher(String cadBinary,String key_t){
  String resultado="";
  for (int i = 0;i<cadBinary.length();i++){
  resultado = resultado.concat(Xor(cadBinary.charAt(i),key_t.charAt(i)));
  }
  return resultado;
}

public static String [] convertSubstrings(String cad){
  String [] arreglo = new String[cad.length()/8];
  int x =0 , y = 7;
  for (int i = 0;i<cad.length()/8 ;i++) {
    arreglo[i]=cad.substring(x,y+1);
    //System.out.println(arreglo[i]);
    x = x+8;
    y= y+8;
  }
  return arreglo;
}
public static double[] convBinarytoDecimal(String[] cad){
  int x=0,y=0;
  int pot=0;
  double resultado[] = new double[cad.length];
    for (int i = 0 ;i<cad.length ;i++) {
      for (int j = cad[i].length()-1;j>=0 ;j--) {
        resultado[i] = resultado[i]+(Integer.parseInt(Character.toString(cad[i].charAt(j)))*Math.pow(2,y));
        y++;
      }
      y=0;
    }
    return resultado;
}
}
