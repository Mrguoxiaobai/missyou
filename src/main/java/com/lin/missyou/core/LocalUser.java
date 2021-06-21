package com.lin.missyou.core;

import com.lin.missyou.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Local user.
 *
 * @ClassName: LocalUser
 * @Author: Mrguo
 * @Description:
 * @Date: 2021 /6/2011:30
 * @Version: 1.0
 */
public class LocalUser {
    private static ThreadLocal<Map<String,Object>> threadLocal=new ThreadLocal<>();

    /**
     * Set.
     *
     * @param user  the user
     * @param scope the scope
     */
    public static void set(User user,Integer scope){
        HashMap<String, Object> map = new HashMap<>();
        map.put("user",user);
        map.put("scope",scope);
        LocalUser.threadLocal.set(map);
    }

    /**
     * Clear.
     */
    public static void clear(){
        LocalUser.threadLocal.remove();
    }

    /**
     * Get user user.
     *
     * @return the user
     */
    public static User getUser(){
        Map<String, Object> map = LocalUser.threadLocal.get();
        User user = (User)map.get("user");
        return user;
    }

    /**
     * Get scope integer.
     *
     * @return the integer
     */
    public static Integer getScope(){
        Map<String, Object> map = LocalUser.threadLocal.get();
        Integer scope = (Integer)map.get("scope");
        return scope;
    }


}
