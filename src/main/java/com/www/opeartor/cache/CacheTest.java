package com.www.opeartor.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 谷歌LoadingCache缓存使用
 * invalidateAll方法从缓存中移除缓存项
 * asMap()方法获得缓存数据的ConcurrentMap<K, V>快照
 * cleanUp()清空缓存
 * refresh(Key) 刷新缓存，即重新取缓存数据，更新缓存
 * Created by Vincent on 2017/7/8.
 */
public class CacheTest {

    private static LoadingCache<String, String> cacheBuilder = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
        @Override
        public String load(String s) throws Exception {
            return cacheMap.get(s);
        }
    });

    private static Map<String, String> cacheMap = Maps.newHashMap();

    public static void test()throws Exception{
        cacheMap.put("test1","test11");
        cacheMap.put("test2","test12");
        cacheMap.put("test3","test13");
        for (String s: cacheMap.keySet()){
            if (!cacheBuilder.asMap().keySet().contains(s)){
                cacheBuilder.get(s);
            }
        }
    }

    public static void test2()throws Exception{
        cacheMap.put("test5","test21");
        cacheMap.put("test6","test22");
        cacheMap.put("test7","test23");
        for (String s: cacheMap.keySet()){
            if (!cacheBuilder.asMap().keySet().contains(s)){
                cacheBuilder.get(s);
            }
        }
    }

    public static void main(String[] args)throws Exception{
        for (int i = 0; i < 2; i++){
            if (cacheBuilder.size() < 1){
                test();
            }
            for (String s : cacheBuilder.asMap().keySet()){
                System.err.println(s + "+++111::" +cacheBuilder.get(s));
            }
        }
        test2();
        for (int i = 0; i < 2; i++){
            for (String s : cacheBuilder.asMap().keySet()){
                System.err.println(s + "+++222::" +cacheBuilder.get(s));
            }
        }
        //cacheBuilder.invalidateAll();
    }
}
