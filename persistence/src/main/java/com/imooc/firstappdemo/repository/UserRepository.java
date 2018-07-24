package com.imooc.firstappdemo.repository;

import com.imooc.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User}  {@link Repository}
 */
@Repository
public class UserRepository {
    /**
     * 采用内存型的存储方式  map
     */
    private final ConcurrentMap<Integer, User> resository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();


    /**
     *
     * @param user {@link User}
     * @return 保存成功 true, 失败false
     */
    public boolean save(User user){

        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return resository.put(id, user) == null;
    }

    public Collection<User> findAll(){
        return resository.values();
    }

}
