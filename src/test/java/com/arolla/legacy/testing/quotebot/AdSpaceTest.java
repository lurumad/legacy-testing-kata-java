package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.quotebot.domain.TechBlogsRepository;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdSpaceTest {
    @Test
    void only_return_blogs_that_start_with_a_T() {
        var adSpace = new AdSpace(new TechBlogsRepository(){
            @Override
            public Collection<String> listAllBlogs() {
                return List.of("HackerNews", "Reddit", "TechCrunch", "TechRadar");
            }
        });

        var blogs = adSpace.getAdSpaces();

        assertEquals(List.of("TechCrunch", "TechRadar"), blogs);
    }
}