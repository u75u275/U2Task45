package HomeworkChapter45_U2;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by u2 on 07.07.2017.
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class PKContragentID implements Serializable {
    private int id;
    private int siteid;

    // ---- constructors
    public PKContragentID() {} ;

    public PKContragentID(int id, int siteid) {
        this.id = id;
        this.siteid = siteid;
    }

    // ---- getters
    public int getId() {
        return id;
    }

    public int getSiteid() {
        return siteid;
    }

    // ---- setters

    public void setId(int id) {
        this.id = id;
    }

    public void setSiteid(int siteid) {
        this.siteid = siteid;
    }

    // -- equals,hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PKContragentID)) return false;

        PKContragentID that = (PKContragentID) o;

        if (id != that.id) return false;
        return siteid == that.siteid;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + siteid;
        return result;
    }

    // ---- toString
    @Override
    public String toString() {
        return "PKContragentID{" +
                "id='" + id + '\'' +
                ", siteid='" + siteid + '\'' +
                '}';
    }
}
