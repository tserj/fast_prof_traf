package model.base;

/**
 * Created by tserj on 08.09.2015.
 */
public interface INonSeriazableEntity<PKType> {

    PKType getId();
    void setId(PKType id);

}
