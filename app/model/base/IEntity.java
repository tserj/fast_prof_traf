package model.base;

import java.io.Serializable;

/**
 * Created by tserj on 08.09.2015.
 */
public interface IEntity<PKType extends Serializable> extends Serializable {

    PKType getId();
    void setId(PKType id);

}
