package com.blog.patterns.pattern10_observer;

import com.blog.patterns.shared.BlogPost;

public interface BlogSubscriber {
    void update(BlogPost post);
}
