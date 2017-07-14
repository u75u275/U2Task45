package HomeworkChapter45_U2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtilST {
    private static  EntityManagerFactory entityManagerFactorySingleton;
    static {
        try {
            System.out.println("Эндофины пошлии");
            entityManagerFactorySingleton = Persistence.createEntityManagerFactory("test");

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed. ERRMESS : " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactorySingleton.createEntityManager();

    }
}