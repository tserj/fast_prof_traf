package model.base;

/**
 * Created by tserj on 08.09.2015.
 */
public class BaseEntity extends Entity<Long> {

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public String getStringId() {
        return this.getId().toString();
    }

}
