package stack;

public class Principal {
    public static void main(String[] args) {
        //Dinâmico
        A a = new A();
        B b = new B();
        a.getClasse();
        b.getClasse();
        //Estático
        A.getStaticClasse();
        B.getStaticClasse();
    }
}