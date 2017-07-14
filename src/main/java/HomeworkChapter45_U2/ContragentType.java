package HomeworkChapter45_U2;


import javax.persistence.*;

@Entity
@Table(name = "contragent_type")
@Access(AccessType.FIELD)
public class ContragentType  implements java.io.Serializable {
    @Id
    @Column(name="cid")
    public char id;

    public String name;

    @Column(name = "official_type",columnDefinition = "default 0")
    public int officialtype;

    @OneToOne(mappedBy = "typeid")
    private Contragent contragent;

    public ContragentType() {}

    public ContragentType(char id, String name, int officialtype) {
        this.id = id;
        this.name = name;
      //  this.officialtype = officialtype;
    }

    @Override
    public String toString() {
        return "ContragentType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", officialtype=" + officialtype +
                '}';
    }
}
