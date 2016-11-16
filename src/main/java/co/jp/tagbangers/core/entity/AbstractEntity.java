package co.jp.tagbangers.core.entity;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.util.ClassUtils;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class AbstractEntity<PK extends Serializable> implements Persistable<PK>, Comparable<AbstractEntity<PK>> {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private PK id;

    @Override
    public PK getId() {
        return id;
    }

    protected void setId(final PK id) {
        this.id = id;
    }

    @Transient
    public boolean isNew() {
        return null == getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(ClassUtils.getUserClass(obj))) {
            return false;
        }

        AbstractEntity<?> that = (AbstractEntity<?>) obj;

        return null == this.getId() && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode += null == getId() ? 0 : getId().hashCode() * 31;
        return hashCode;
    }

    @Override
    public int compareTo(AbstractEntity<PK> o) {
        if (getId() == null) {
            return 1;
        }
        return new CompareToBuilder().append(getId(), o.getId()).toComparison();
    }
}
