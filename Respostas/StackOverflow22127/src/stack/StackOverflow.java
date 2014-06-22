package stack;
public class StackOverflow{

	public static void main(String[] args) {
            Config conf = new Config();
            System.out.println("-----------------------\n\tPasta onde está o jar\n-----------------------\n");
            conf.setConfig_PastadoJar(true);
            printConfig(conf);
            System.out.println("");
            conf.setConfig_PastadoJar(false);
            printConfig(conf);
            System.out.println("-----------------------\n\tDentro do jar\n-----------------------\n");
            conf.setConfigPorStream(false);
            System.out.println("StackOverflow.jar\\!res\\conf.txt");
            printConfig(conf);
            System.out.println("");
            System.out.println("StackOverflow.jar\\!stack\\res\\conf.txt");
            conf.setConfigPorStream(true);
            printConfig(conf);
        }
        public static void printConfig(Config c){
            System.out.println("Usuario: " + c.getUsuario());
            System.out.println("DB: " + c.getDB());
            System.out.println("Website: " + c.getWebsite());
        }
        


}
