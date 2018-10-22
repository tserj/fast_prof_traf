package model.base;

import java.io.Serializable;

/**
 * Created by tserj on 08.09.2015.
 */
public abstract class Entity<PKType extends Serializable> implements IEntity<PKType> {

    private PKType id;

    protected Entity() {
    }

    protected Entity(PKType id) {
        this.id = id;
    }

    public PKType getId() {
        return id;
    }

    public void setId(PKType id) {
        this.id = id;
    }
}
