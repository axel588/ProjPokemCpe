package fr.cpe.pokemongoplagiat.bdddao.relationdao;

import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import fr.cpe.pokemongoplagiat.bdddao.IBaseDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.WildPokemonPokemon;
import kotlin.jvm.JvmSuppressWildcards;

public abstract class IBaseRelationDao<O,F,T>/* extends IBaseDao<T>*/ {

    private Class<F> classF;
    private Class<T> classT;
    private Class<O> classO;

    public static String camelToSnake(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                // Convert uppercase character to lowercase and add underscore
                result.append("_").append(Character.toLowerCase(currentChar));
            } else {
                // Leave lowercase characters and digits as is
                result.append(currentChar);
            }
        }
        return result.toString().toLowerCase();
    }

    public IBaseRelationDao(Class<O> classO, Class<F> classF, Class<T> classT) {
        this.classF = classF;
        this.classT = classT;
        this.classO = classO;
    }

    @RawQuery
    @JvmSuppressWildcards
    protected abstract List<T> doFindAllValid(SupportSQLiteQuery query);

    public List<T> findAllFromSecond() {
        List<String> names = getTablesNames();
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "select * from " + names.get(1) + " INNER JOIN "+names.get(2)
                + " ON "+ names.get(1) + ".id_"+camelToSnake(names.get(2))+ " = "+names.get(2)+".id"
        );
        return doFindAllValid(query);
    }


    public List<T> findAllFromSecondByFirstId(long id) {
        List<String> names = getTablesNames();
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "select * from " + names.get(1) + " INNER JOIN "+names.get(2)
                        + " ON "+ names.get(1) + ".id_"+camelToSnake(names.get(2))+ " = "+names.get(2)+".id"
                + " WHERE "+ names.get(1) + ".id = "+id
        );
        return doFindAllValid(query);
    }

    public List<T> findAllFromSecondBySecondId(long id) {
        List<String> names = getTablesNames();
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "select * from " + names.get(1) + " INNER JOIN "+names.get(2)
                        + " ON "+ names.get(1) + ".id_"+camelToSnake(names.get(2))+ " = "+names.get(2)+".id"
                        + " WHERE "+ names.get(2) + ".id = "+id
        );
        return doFindAllValid(query);
    }

    public List<T> findAll() {
        List<String> names = getTablesNames();
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "select * from " + names.get(0) + " INNER JOIN "+names.get(2)
                        + " ON "+ names.get(0) + ".id_"+camelToSnake(names.get(2))+ " = "+names.get(2)+".id"
        );
        return doFindAllValid(query);
    }


    public List<T> findAllByFirstId(long id) {
        List<String> names = getTablesNames();
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "select * from " + names.get(0) + " INNER JOIN "+names.get(2)
                        + " ON "+ names.get(0) + ".id_"+camelToSnake(names.get(2))+ " = "+names.get(2)+".id"
                        + " WHERE "+ names.get(0) + ".id = "+id
        );
        return doFindAllValid(query);
    }

    public List<T> findAllBySecondId(long id) {
        List<String> names = getTablesNames();
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "select * from " + names.get(0) + " INNER JOIN "+names.get(2)
                        + " ON "+ names.get(0) + ".id_"+camelToSnake(names.get(2))+ " = "+names.get(2)+".id"
                        + " WHERE "+ names.get(0) + ".id = "+id
        );
        return doFindAllValid(query);
    }


    public List<T> findAllFromTo(int from, int to) {
        List<String> names = getTablesNames();
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "select * from " + names.get(from) + " INNER JOIN "+names.get(to)
                        + " ON "+ names.get(from) + ".id_"+camelToSnake(names.get(to))+ " = "+names.get(to)+".id"
        );
        return doFindAllValid(query);
    }


    public List<T> findAllFromToByFirstId(long id, int from, int to) {
        List<String> names = getTablesNames();
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "select * from " + names.get(from) + " INNER JOIN "+names.get(to)
                        + " ON "+ names.get(from) + ".id_"+camelToSnake(names.get(to))+ " = "+names.get(to)+".id"
                        + " WHERE "+ names.get(from) + ".id = "+id
        );
        return doFindAllValid(query);
    }

    public List<T> findAllFromToBySecondId(long id, int from, int to) {
        List<String> names = getTablesNames();
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "select * from " + names.get(from) + " INNER JOIN "+names.get(to)
                        + " ON "+ names.get(from) + ".id_"+camelToSnake(names.get(to))+ " = "+names.get(to)+".id"
                        + " WHERE "+ names.get(from) + ".id = "+id
        );
        return doFindAllValid(query);
    }

    public List<String> getTablesNames() {
        String tableName = classO.getSimpleName();
        String property1Name = classF.getSimpleName();
        String property2Name = classT.getSimpleName();

        return new ArrayList<>(Arrays.asList(tableName, property1Name, property2Name));
    }
}
