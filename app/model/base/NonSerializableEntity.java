package model.base;

/**
 * Created by tserj on 08.09.2015.
 */
public abstract class NonSerializableEntity<PKType> implements INonSeriazableEntity<PKType> {

    private PKType id;

    protected NonSerializableEntity() {
    }

    protected NonSerializableEntity(PKType id) {
        this.id = id;
    }

    public PKType getId() {
        return id;
    }

    public void setId(PKType id) {
        this.id = id;
    }
}
