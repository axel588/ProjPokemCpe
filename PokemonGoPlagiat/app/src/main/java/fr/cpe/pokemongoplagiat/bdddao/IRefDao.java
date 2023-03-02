package fr.cpe.pokemongoplagiat.bdddao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.HealStation;
import kotlin.jvm.JvmSuppressWildcards;

public interface IRefDao<M> {

/*
    public abstract List<M> loadAllByIds(long[] attackIds);
    @Query("SELECT * FROM "+getTableName())
    public abstract List<M> getAll();
    @Insert
    public abstract void insertAll(M... attacks);

    public abstract void delete(M attack);

    abstract public long save(M obj);


    abstract public long[] save(M... objs);


    abstract public long insert(M obj);

    abstract public long[] insert(M... objs);

    abstract String getTableName();*/

}
