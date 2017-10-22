package br.com.hackindebt.hackindebt.utils;

public abstract class Utils {

    public static void validate(Object object) throws Exception {
        if (object == null || object.equals("")) throw new Exception("Preencher todos os campos");
    }
}
