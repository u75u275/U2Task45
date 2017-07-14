package HomeworkChapter45_U2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "contragent")
public class Contragent implements Serializable {

    private PKContragentID contragentPK;
    private String name;
    private String identycode;
    private ContragentType typeid;
    private List<ContragentGroup> groupList;
    private List<Address> addressList;
    private List<Account> accountList;
    private Category category;



    // ******************************************************************************************************  constructors
    public Contragent(){}

    public Contragent(PKContragentID contragentPK, String name, String identycode, ContragentType typeid, List<Address> addressList, Category category,List<Account>  accountList) {
        this.contragentPK = contragentPK;
        this.name = name;
        this.identycode = identycode;
        this.typeid = typeid;
        this.addressList = addressList;
        this.category = category;
        this.accountList = accountList;
    }

    // ******************************************************************************************************  getters

    @EmbeddedId
    public PKContragentID getContragentPK() {
        return contragentPK;
    }
    @Column(name = "name",nullable = false,length = 200)
    public String getName() {
        return name;
    }

    @Column(name = "identycode",length = 10 )
    public String getIdentycode() {
        return identycode;
    }

    @OneToOne(targetEntity = ContragentType.class,cascade = {CascadeType.PERSIST})
    @JoinColumn(name="typeid")
    public ContragentType getTypeid ()
    {return typeid;}

    @OneToOne (targetEntity = Category.class,cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn (name = "categoryid")
    public Category getCategory() {
        return category;
    }

    @OneToMany(targetEntity = Address.class,cascade = {CascadeType.PERSIST})
    @JoinColumns({
            @JoinColumn(name="contragentid", referencedColumnName="id"),
            @JoinColumn(name="siteid", referencedColumnName="siteid")
    })
    public List<Address> getAddressList() {
        return addressList;
    }

    @OneToMany(targetEntity = Account.class,cascade = {CascadeType.PERSIST})
    @PrimaryKeyJoinColumns({
            @PrimaryKeyJoinColumn(name="contragentid", referencedColumnName="id"),
            @PrimaryKeyJoinColumn(name="siteid", referencedColumnName="siteid")
    })
    public List<Account> getAccountList() {
        return accountList;
    }

    @ManyToMany(mappedBy = "contragentList")
    public List<ContragentGroup> getGroupList() {
        return groupList;
    }

    // ******************************************************************************************************  setters
    public void setContragentPK(PKContragentID contragentPK) {
        this.contragentPK = contragentPK;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdentycode(String identycode) {
        this.identycode = identycode;
    }

    public void setTypeid(ContragentType typeid) {
        this.typeid = typeid;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public void setGroupList(List<ContragentGroup> groupList) {
        this.groupList = groupList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "Сontragent{" +
                "Contragentid=" + contragentPK +
                ", name='" + name + '\'' +
                ", identycode='" + identycode + '\'' +
                '}';
    }
}
