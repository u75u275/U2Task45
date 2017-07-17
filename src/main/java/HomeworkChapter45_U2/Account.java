package HomeworkChapter45_U2;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "account")
@Access(AccessType.PROPERTY)
public class Account {

    private int id;
    private Date timeChange;
    private String accountno;
    private Date date_open;
    private BigDecimal summanow;
    private Contragent contragent;

    // ******************************************************************************************************  constructors

    public Account() {}

    public Account(Date timeChange, String accountno, Date dateopen, BigDecimal summanow,Contragent contragent) {
        this.timeChange = timeChange;
        this.accountno = accountno;
        this.date_open = dateopen;
        this.summanow = summanow;
        this.contragent = contragent;
    }

    // ******************************************************************************************************  getters

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
    @SequenceGenerator(name = "seq1",
            sequenceName = "genaccount",
            initialValue = 1,
            allocationSize = 1)
    public int getId() {
        return id;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "synctimestamp", nullable = false)
    public Date getTimeChange() {
        return timeChange;
    }

    @Column(nullable = false)
    public String getAccountno() {
        return accountno;
    }

    public Date getDate_open() {
        return date_open;
    }

    @Column(name = "summanow", nullable = false)
    public BigDecimal getSummanow() {
        return summanow;
    }

    @ManyToOne
    @JoinColumns(
            {@JoinColumn(name = "CONTRAGENTID", referencedColumnName = "ID"),
                    @JoinColumn(name = "SITEID", referencedColumnName = "SITEID")
            }
    )
    public Contragent getContragent() {
        return contragent;
    }

    // ******************************************************************************************************  setters


    public void setTimeChange(Date timeChange) {
        this.timeChange = timeChange;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public void setDate_open(Date date_open) {
        this.date_open = date_open;
    }

    public void setSummanow(BigDecimal summanow) {
        this.summanow = summanow;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContragent(Contragent contragent) {
        this.contragent = contragent;
    }
}