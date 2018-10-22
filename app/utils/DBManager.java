package utils;

import model.base.IEntity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import play.db.DB;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by tserj on 08.09.2015.
 */
public final class DBManager {


// !!! Ensure that all new methods will be thread-safe !!!

    private static final DataSource DS = DB.getDataSource("fastproftraf");

    public static void execute(String query) throws Exception {
        QueryRunner run = new QueryRunner(DS);
        run.update(query);
    }


   /* Just an example of join query
    @SuppressWarnings("unchecked")
    public static List<Referral> getReferrals(Long userId) throws RpcException {
        String queryPattern = "SELECT u.id AS userId, login, register, parent FROM `user` as u INNER JOIN ".concat(
                "(SELECT * FROM `referrals` WHERE userId = %s) as ref ON ref.referralId = u.id");
        List<Referral> result = (List<Referral>) getEntities(Referral.class, String.format(queryPattern, userId));
        LOG.debug("referrals count:{}", result.size());
        return result;
    }*/

    public static IEntity getEntityById(Class clazz, String table, String id) throws Exception {
        return getEntity(clazz, table,  "id='".concat(id).concat("'"));
    }

    public static List<? extends IEntity> getEntitiesById(Class clazz, String table, String id) throws Exception {
        return getEntities(clazz, table,  "id='".concat(id).concat("'"));
    }

    @SuppressWarnings("unchecked")
    public static IEntity getEntity(Class clazz, String table, String param) throws Exception {
        IEntity result;
        QueryRunner run = new QueryRunner(DS);
        ResultSetHandler<IEntity> h = new BeanHandler<IEntity>(clazz);
        if (param != null) {
            result = run.query(String.format("SELECT * FROM %s WHERE %s", table, param), h);
        } else {
            result = run.query(String.format("SELECT * FROM %s", table), h);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static List<? extends IEntity> getEntities(Class clazz, String table, String param) throws Exception  {
        List<? extends IEntity> result;
        QueryRunner run = new QueryRunner(DS);
        ResultSetHandler<List<IEntity>> h = new BeanListHandler<IEntity>(clazz);
        if (param != null) {
            result = run.query(String.format("SELECT * FROM %s WHERE %s", table, param), h);
        } else {
            result = run.query(String.format("SELECT * FROM %s", table), h);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static List<? extends IEntity> getEntities(Class clazz, String query) throws Exception {
        List<? extends IEntity> result;
        QueryRunner run = new QueryRunner(DS);
        ResultSetHandler<List<IEntity>> h = new BeanListHandler<IEntity>(clazz);
            result = run.query(query, h);
        return result;
    }

}
