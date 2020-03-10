package com.calc.arithmetic;

class CacheStore implements Store<String>{
    private static volatile CacheStore instance;
    private StringBuilder currentCache;

    private CacheStore() {
        currentCache = new StringBuilder();
    }

    static CacheStore getInstance() {
        if(instance == null) {
            synchronized (CacheStore.class) {
                if(instance == null)
                    instance = new CacheStore();
            }
        }
        return instance;
    }

    @Override
    public String getCurrent() {
        return currentCache.toString();
    }

    @Override
    public void setCurrent(String cacheToStore) {
        currentCache = new StringBuilder(cacheToStore);
    }

    @Override
    public void setDefault() {
        currentCache = new StringBuilder();
    }

    public void updateCurrent(String cacheToAdd) {
        currentCache.append(cacheToAdd);
    }
}
