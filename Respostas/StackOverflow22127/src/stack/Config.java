
package stack;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class Config {
    private String usuario;
    private String db;
    private String website;
    private String path;
    public void setConfigPorStream(boolean flag){
        try{
            InputStream is; 
           if(flag){
                 // stack.res/conf.txt
                 is =  this.getClass().getResourceAsStream("res/conf.txt");
           }
           else{
                 //res/conf.txt
                 is = ClassLoader.getSystemResourceAsStream("res/conf.txt");
           }
            //O tamanho do arquivo provavelmente será o mesmo sempre
            // e por isso BufferedReader é desnecessário.
           byte[] b = new byte[1024];
            is.read(b);
            String config = new String(b,"UTF-8");
            this.db = parseConfig(config, "dbUrl");
            this.website = parseConfig(config, "website");
            this.usuario = parseConfig(config, "usuario");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void setConfig_PastadoJar(boolean flag) {
        URL arquivo;
        if(flag)
            arquivo = ClassLoader.getSystemResource("res/conf.txt");
        else{
            arquivo = this.getClass().getResource("res/conf.txt");
        }        
        FileInputStream fis  = null;
        try {
            fis = new FileInputStream(arquivo.getFile());
            byte[] b = new byte[1024];
            fis.read(b);
            String config = new String(b,"UTF-8");
            this.db = parseConfig(config, "dbUrl");
            this.website = parseConfig(config, "website");
            this.usuario = parseConfig(config, "usuario");
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
        public String getUsuario(){
            return this.usuario;
        }
        public String getDB(){
            return this.db;
        }
        public String getWebsite(){
            return this.website;
        }
    public static String parseConfig(String linha,String campo){
        linha = linha.replaceAll("\"","");
        int indice = linha.indexOf(campo) + 3 + campo.length();
        int ultimo_char = linha.indexOf(",", indice)!=-1?linha.indexOf(",", indice):linha.indexOf("}", indice);
        return linha.substring(indice,ultimo_char);
    }
}
