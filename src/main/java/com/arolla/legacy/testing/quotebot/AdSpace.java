package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.quotebot.domain.TechBlogsRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdSpace {

    private static final Map<String, Collection<String>> cache = new HashMap<String, Collection<String>>();
    private final TechBlogsRepository techBlogs;

    public AdSpace(TechBlogsRepository techBlogs) {
        this.techBlogs = techBlogs;
    }

    public Collection<String> getAdSpaces() {
        if (cache.containsKey("blogs list")) {
            return cache.get("blogs list");
        }
        var result = blogsStartWithT();
        cache.put("blogs list", result);
        return result;
    }

    private List<String> blogsStartWithT() {
        var allBlogs = techBlogs.listAllBlogs();
        return allBlogs.stream().filter(blog -> blog.startsWith("T")).toList();
    }
}
