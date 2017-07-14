package HomeworkChapter45_U2;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "category")
@Access(AccessType.FIELD)
public class Category implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    @SequenceGenerator(name = "category_sequence",
            sequenceName = "category_sequence",
            initialValue = 1,
            allocationSize = 1)
    private int id;

    @Column(name = "category_name")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_create", nullable = false)
    private Date synctimestamp;

    public Category() {
    }

    public Category(String name, Date synctimestamp) {
        this.name = name;
        this.synctimestamp = synctimestamp;
    }


}