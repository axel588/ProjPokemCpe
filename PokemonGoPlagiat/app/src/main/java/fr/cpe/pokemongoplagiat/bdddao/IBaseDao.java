package fr.cpe.pokemongoplagiat.bdddao;

import fr.cpe.pokemongoplagiat.bddmodels.*;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Update;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.BaseModel;
import kotlin.jvm.JvmSuppressWildcards;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/*
@Dao
public abstract class IBaseDao<T extends BaseModel> {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long save(T obj);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract public long[] save(T... objs);


    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long insert(T obj);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    @JvmSuppressWildcards
    abstract public long[] insert(T... objs);

    @JvmSuppressWildcards
    public void deleteThem(List<Long> ids) {
        StringBuilder queryBuilder = new StringBuilder("DELETE FROM ")
                .append(getTableName())
                .append(" WHERE id IN (");
        for (int i = 0; i < ids.size(); i++) {
            queryBuilder.append("?");
            if (i < ids.size() - 1) {
                queryBuilder.append(",");
            }
        }
        queryBuilder.append(")");

        String query = queryBuilder.toString();
        SimpleSQLiteQuery simpleSQLiteQuery = new SimpleSQLiteQuery(query, ids.toArray());
        doDeleteAll(simpleSQLiteQuery);
    }


    @Delete
    @JvmSuppressWildcards
    abstract public void delete(T obj);

    @JvmSuppressWildcards
    public int deleteAll() {
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "delete from " + getTableName()
        );
        return doDeleteAll(query);
    }

    @JvmSuppressWildcards
    public List<T> findAllValid() {
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "select * from " + getTableName() + " where deleteFlag = 0 order by sortKey"
        );
        return doFindAllValid(query);
    }

    @JvmSuppressWildcards
    public List<T> findAll() {
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "select * from " + getTableName()
        );
        return doFindAllValid(query);
    }

    @JvmSuppressWildcards
    public int delete(long id) {
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "DELETE * from " + getTableName() + " where deleteFlag = 0 and id = "+id,
                new Object[]{id}
        );
        return doDeleteAll(query);
    }

    @JvmSuppressWildcards
    public T find(long id) {
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "select * from " + getTableName() + " where deleteFlag = 0 and id = ?",
                new Object[]{id}
        );
        return doFind(query);
    }

    @JvmSuppressWildcards
    public String getTableName() {

        Class clazz = (Class)
                ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
        // tableName = StringUtil.toSnakeCase(clazz.getSimpleName());
        String tableName = clazz.getSimpleName();
        return tableName;
    }

    @RawQuery
    @JvmSuppressWildcards
    protected abstract List<T> doFindAllValid(SupportSQLiteQuery query);

    @RawQuery
    @JvmSuppressWildcards
    protected abstract T doFind(SupportSQLiteQuery query);

    @RawQuery
    @JvmSuppressWildcards
    protected abstract int doDeleteAll(SupportSQLiteQuery query);
}*/