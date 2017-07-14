package HomeworkChapter45_U2;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "contragent_group")
@Access(AccessType.PROPERTY)
public class ContragentGroup  implements Serializable {


    private int id;
    private String name;
    private List<Contragent> contragentList;

    // ******************************************************************************************************  constructors
    public ContragentGroup() {
    }

    public ContragentGroup(String name, List<Contragent> contragentList) {
        this.name = name;
        this.contragentList = contragentList;
    }

    // ******************************************************************************************************  getters
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gencontragentgroup")
    @SequenceGenerator(name = "gencontragentgroup",
            sequenceName = "gencontragentgroup",
            initialValue = 1,
            allocationSize = 1)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @ManyToMany
    @JoinTable(name = "contragent_group_link",
            joinColumns = @JoinColumn(name = "contragent_groupid", referencedColumnName = "id"),
            inverseJoinColumns = {@JoinColumn(name = "contragentid", referencedColumnName = "id"),
                    @JoinColumn(name = "siteid", referencedColumnName = "siteid")
            }  )
    public List<Contragent> getContragentList() {
        return contragentList;
    }
    // ******************************************************************************************************  setters
    public void setContragentList(List<Contragent> contragentList) {
        this.contragentList = contragentList;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

}