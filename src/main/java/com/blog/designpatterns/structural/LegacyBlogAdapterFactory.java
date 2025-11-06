package com.blog.designpatterns.structural;

/**
 * Adapter Pattern - Factory for creating adapter instances
 */
public class LegacyBlogAdapterFactory {
    
    public static LegacyBlogAdapter createAdapter() {
        LegacyBlogSystem legacySystem = new LegacyBlogSystem();
        return new LegacyBlogAdapter(legacySystem);
    }
}
