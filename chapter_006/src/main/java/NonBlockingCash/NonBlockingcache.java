package NonBlockingCash;

import java.util.concurrent.ConcurrentHashMap;

public class NonBlockingcache {
    private ConcurrentHashMap<Integer, Base> cache = new ConcurrentHashMap<>();

    public void add(Base model) {
        cache.put(model.getId(), model);
    }

    public void update(Base model, int id) throws OptimisticException {
        cache.computeIfPresent(id, (mainId, mainBase) -> {
            if (mainBase.getVersion() != model.getVersion()) {
                throw new OptimisticException("Versions do not match.");
            }
            return model;
        });
    }

    public void delete(int id) {
        cache.remove(id);
    }

    public Base get(int id) {
        return cache.get(id);
    }
}
