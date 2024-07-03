package com.arolla.legacy.testing.quotebot.infrastructure;

import com.arolla.legacy.testing.quotebot.domain.TechBlogsRepository;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;

public class TechBlogsDbRepository implements TechBlogsRepository {

    @Override
    public Collection<String> listAllBlogs() {
        try {
            Thread.sleep(5000);// Access to DB are very slow
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Unxepceted ecxeptoin", JOptionPane.WARNING_MESSAGE);
        }
        return Arrays.asList("HackerNews", "Reddit", "TechCrunch", "BuzzFeed",
                "TMZ", "TheHuffPost", "GigaOM");
    }
}
