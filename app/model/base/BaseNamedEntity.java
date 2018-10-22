package model.base;

/**
 * Created by tserj on 08.09.2015.
 */
public class BaseNamedEntity extends NonSerializableEntity<String> {

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

}
