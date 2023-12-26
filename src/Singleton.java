


public class Singleton {

    private static final Object object = new Object();
    private static volatile Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        System.out.println("onCreate = ins = " + instance);
        if (instance != null) {
            return instance;
        }

        synchronized (object) {
            if (instance == null) {
                instance = new Singleton();
            }

            return instance;
        }
    }

    public void test() {
        System.out.println("test object = " + object);
    }
}
