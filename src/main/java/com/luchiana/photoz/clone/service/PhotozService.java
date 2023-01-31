package com.luchiana.photoz.clone.service;

import com.luchiana.photoz.clone.model.Photo;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class PhotozService {

    private Map<String, Photo> db = new HashMap<>() {{
        put("7f0ed53c-7b35-4ec7-9221-d3e8f5754358", new Photo("7f0ed53c-7b35-4ec7-9221-d3e8f5754358", "(50).jpg"));
    }};

    public Collection<Photo> get() {
        return db.values();
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setContentType(contentType);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }
}
