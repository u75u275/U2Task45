package HomeworkChapter45_U2;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class Main {

    private EntityManager em = EntityManagerUtilST.getEntityManager();

    public void persistEntity ( Object entyty2persist) {

        try {

            em.getTransaction().begin();
            em.persist(entyty2persist);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("-*-*-*-* persistEntity экзепшн !! Error Message: "+e.getMessage() + " Заначения полей ентити" + entyty2persist);
            em.getTransaction().rollback();
        }

    }
    /*************************** INSERT CONTRAGENT */
    public Contragent insertContragent (int id, int siteid, String name,String identycode, ContragentType typeid, List<Address> addressList, Category category,List<Account>  accountList) {

        PKContragentID tmp_pkcontragentID = new PKContragentID(id,siteid);
        Contragent tmp_contragent = new Contragent(tmp_pkcontragentID,name,identycode,typeid,addressList, category,  accountList);
        persistEntity(tmp_contragent);
        return tmp_contragent;
    }

    /*************************** INSERT CONTRAGENTGROUP */
    public ContragentGroup insertContragentGroup (String name,List<Contragent> contragentList) {

        ContragentGroup tmp_ContragentGroup = new ContragentGroup(name, contragentList);
        persistEntity(tmp_ContragentGroup);
        return tmp_ContragentGroup;
    }
    /*************************** INSERT insertContragentType */
    public ContragentType insertContragentType (char id, String name, int officialtype){
        ContragentType tmp_contragenttype = new ContragentType (id ,name, officialtype);
        persistEntity(tmp_contragenttype);
        return tmp_contragenttype;
    }

    /*************************** INSERT Address */
    public Address insertAddress (String country, String postcode, String district, String city,
                                         String street, String houseno, String flat){
        Address tmp_address = new Address(country,postcode,district,city,street,houseno,flat);
        persistEntity(tmp_address);
        return tmp_address;
    }
    /*************************** LIST */
    public void ListAllContragent() {
        try {
            em.getTransaction().begin();
            @SuppressWarnings("unchecked")
            List<Contragent> hlpСontragent = em.createQuery("select s from Contragent s").getResultList();
            for (Iterator<Contragent> iterator = hlpСontragent.iterator(); iterator.hasNext();) {
                Contragent hlp = (Contragent) iterator.next();
                System.out.println(hlp);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("-*-*-*-* ListAllContragent экзепшн "+e.getMessage());
            em.getTransaction().rollback();
        }
    }

    /*************************** MAIN ***************************/
    /************************************************************/
    public static void main(String[] args) {
        Main m = new Main();

        ArrayList<Contragent> hlp_ContragentList = new ArrayList<>();
        /******************************** данные для первого контрагента */
        ContragentType hlp_contragenttype = new ContragentType ('1',"тип перший", 99);
        Category hlp_category = new Category ("Категория перша", new Date(8888222));
         ArrayList<Address> hlp_adressslist1 = new ArrayList<>();
        hlp_adressslist1.add(new Address("ФРАНЦИЯ", "1", "1111", "11111", "111", "11",  "111"));
        hlp_adressslist1.add(new Address("ГЕРМАЦНЦИЯ", "1", "111", "111", "1111", "11",  "11111"));
        ArrayList<Account> hlp_accountlist = new ArrayList<>();
        Contragent hlp_contragent = m.insertContragent(1,300003,"ПЕРВЕНЕЦ П.П.", "111111111", hlp_contragenttype, hlp_adressslist1, hlp_category, hlp_accountlist);
        hlp_ContragentList.add(hlp_contragent);
        /******************************** данные для второго контрагента */
        ContragentType hlp_contragenttype2 = new ContragentType ('2',"тип другий", 99);
        Category hlp_category2 = new Category ("Категория друга", new Date(9999999));
        ArrayList<Address> hlp_adressslist2 = new ArrayList<>();
        hlp_adressslist2.add(new Address("BARBUDU", "2", "222", "2222222", "22", "22",  "22222"));
        hlp_adressslist2.add(new Address("KERGUDU", "2", "222", "22222", "20", "222",  "2222"));
        hlp_adressslist2.add(new Address("PAMBUDU", "2", "222", "22222", "20", "222",  "2222"));


     //   hlp_accountlist.add(new Account( new Date(), "26000023233", new Date(), new BigDecimal("12311212.11"),hlp_contragent));
        hlp_contragent = m.insertContragent(2,200002,"ВТОРОЙ В.В.", "2222222", hlp_contragenttype2, hlp_adressslist2, hlp_category2,hlp_accountlist);
        hlp_ContragentList.add(hlp_contragent);

        /****************************** создание группы КА */
        ContragentGroup hlp_ContragentGroup = m.insertContragentGroup("Первая группа",hlp_ContragentList );

    }
}
