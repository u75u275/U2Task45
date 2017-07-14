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
    private Date dateopen;
    private BigDecimal summanow;
    private Contragent contragent;

    // ******************************************************************************************************  constructors

    public Account() {}

    public Account(Date timeChange, String accountno, Date dateopen, BigDecimal summa, Contragent contragent) {
        this.timeChange = timeChange;
        this.accountno = accountno;
        this.dateopen = dateopen;
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

    public Contragent getContragent() {
        return contragent;
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

    public Date getDateopen() {
        return dateopen;
    }

    @Column(name = "summanow", nullable = false)
    public BigDecimal getSummanow() {
        return summanow;
    }

    // ******************************************************************************************************  setters


    public void setTimeChange(Date timeChange) {
        this.timeChange = timeChange;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public void setDateopen(Date dateopen) {
        this.dateopen = dateopen;
    }

    public void setSummanow(BigDecimal summanow) {
        this.summanow = summanow;
    }

    public void setContragent(Contragent contragent) {
        this.contragent = contragent;
    }

    public void setId(int id) {
        this.id = id;
    }
}