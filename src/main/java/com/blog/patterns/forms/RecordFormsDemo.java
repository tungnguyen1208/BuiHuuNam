package com.blog.patterns.forms;

import java.util.Arrays;
import java.util.List;

/**
 * Demo class for Single Record and List Records forms
 * 
 * Demonstrates:
 * - Form 1: Single Record Entry (nhập 1 bản ghi)
 * - Form 2: List/Batch Records Entry (nhập 1 list)
 * 
 * Both forms use ALL 12 Design Patterns
 */
public class RecordFormsDemo {
    
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║          DEMO: SINGLE RECORD & LIST RECORDS FORMS            ║");
        System.out.println("║              Using All 12 Design Patterns                     ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        
        // Demo 1: Single Record Form
        demoSingleRecordForm();
        
        System.out.println("\n\n");
        System.out.println("═══════════════════════════════════════════════════════════════════");
        System.out.println("\n\n");
        
        // Demo 2: List Records Form
        demoListRecordsForm();
        
        System.out.println("\n\n");
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                   DEMO COMPLETED                              ║");
        System.out.println("║     Both forms successfully used all 12 patterns              ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        
        printSummary();
    }
    
    /**
     * Demo Form 1: Single Record Entry
     */
    private static void demoSingleRecordForm() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║         FORM 1: SINGLE RECORD ENTRY (Nhập 1 Bản Ghi)         ║");
        System.out.println("║    Demonstrating all 12 Design Patterns for ONE post         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
        
        // Create sample data
        SingleRecordData data = new SingleRecordData();
        data.setTitle("Introduction to Java Design Patterns");
        data.setAuthor("John Developer");
        data.setPostType("technical");
        data.setContentFormat("markdown");
        data.setContent("# Design Patterns in Java\n\nThis guide covers all 12 GoF patterns...");
        data.setTags(Arrays.asList("java", "design-patterns", "programming"));
        data.setTheme("modern");
        data.setEnableComments(true);
        data.setEnableLikes(true);
        data.setLazyLoad(true);
        data.setNotifyEmail(true);
        data.setNotifySMS(false);
        
        // Process with controller
        SingleRecordController controller = new SingleRecordController();
        String savedId = controller.saveSingleRecord(data);
        
        System.out.println("\n📄 Form HTML: src/main/webapp/forms/single-post-form.html");
        System.out.println("🎯 Controller: SingleRecordController.java");
        System.out.println("💾 Saved Record ID: " + savedId);
    }
    
    /**
     * Demo Form 2: List Records Entry
     */
    private static void demoListRecordsForm() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║         FORM 2: LIST RECORDS ENTRY (Nhập 1 List)             ║");
        System.out.println("║    Demonstrating all 12 Design Patterns for MULTIPLE posts   ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
        
        // Create sample list data
        java.util.List<ListRecordData> dataList = new java.util.ArrayList<>();
        
        // Record 1
        ListRecordData record1 = new ListRecordData();
        record1.setTitle("Singleton Pattern Explained");
        record1.setAuthor("Pattern Expert 1");
        record1.setPostType("technical");
        record1.setFormat("markdown");
        record1.setTheme("modern");
        record1.setContent("# Singleton Pattern\nEnsures only one instance...");
        record1.setTags(Arrays.asList("singleton", "creational", "patterns"));
        record1.setEnableComments(true);
        record1.setEnableLikes(true);
        record1.setLazyLoad(true);
        record1.setNotify(true);
        dataList.add(record1);
        
        // Record 2
        ListRecordData record2 = new ListRecordData();
        record2.setTitle("Healthy Living Tips");
        record2.setAuthor("Lifestyle Blogger");
        record2.setPostType("lifestyle");
        record2.setFormat("html");
        record2.setTheme("classic");
        record2.setContent("<p>Tips for maintaining a healthy lifestyle...</p>");
        record2.setTags(Arrays.asList("health", "lifestyle", "tips"));
        record2.setEnableComments(true);
        record2.setEnableLikes(true);
        record2.setLazyLoad(false);
        record2.setNotify(true);
        dataList.add(record2);
        
        // Record 3
        ListRecordData record3 = new ListRecordData();
        record3.setTitle("Latest Tech News: AI Breakthrough");
        record3.setAuthor("News Reporter");
        record3.setPostType("news");
        record3.setFormat("plain");
        record3.setTheme("modern");
        record3.setContent("Breaking news: Major AI breakthrough announced today...");
        record3.setTags(Arrays.asList("news", "ai", "technology"));
        record3.setEnableComments(true);
        record3.setEnableLikes(false);
        record3.setLazyLoad(true);
        record3.setNotify(true);
        dataList.add(record3);
        
        // Process with controller
        ListRecordsController controller = new ListRecordsController();
        List<String> savedIds = controller.saveListRecords(dataList);
        
        System.out.println("\n📄 Form HTML: src/main/webapp/forms/list-posts-form.html");
        System.out.println("🎯 Controller: ListRecordsController.java");
        System.out.println("💾 Saved Record IDs: " + savedIds);
    }
    
    /**
     * Print summary of both forms
     */
    private static void printSummary() {
        System.out.println("\n\n");
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║              FORMS SUMMARY & COMPARISON                       ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
        
        System.out.println("┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│ FORM 1: SINGLE RECORD ENTRY (Nhập 1 Bản Ghi)              │");
        System.out.println("├─────────────────────────────────────────────────────────────┤");
        System.out.println("│ Purpose: Input ONE blog post record                        │");
        System.out.println("│ HTML: single-post-form.html                                │");
        System.out.println("│ Controller: SingleRecordController.java                    │");
        System.out.println("│ Features:                                                   │");
        System.out.println("│  • Simple, focused interface for 1 post                    │");
        System.out.println("│  • Auto-generated ID (Singleton)                           │");
        System.out.println("│  • Load from template (Prototype)                          │");
        System.out.println("│  • All 12 patterns applied to single record               │");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
        
        System.out.println("\n┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│ FORM 2: LIST RECORDS ENTRY (Nhập 1 List)                  │");
        System.out.println("├─────────────────────────────────────────────────────────────┤");
        System.out.println("│ Purpose: Input MULTIPLE blog posts at once                 │");
        System.out.println("│ HTML: list-posts-form.html                                 │");
        System.out.println("│ Controller: ListRecordsController.java                     │");
        System.out.println("│ Features:                                                   │");
        System.out.println("│  • Dynamic list management (add/remove posts)              │");
        System.out.println("│  • Batch operations                                        │");
        System.out.println("│  • Live statistics (Singleton counting)                    │");
        System.out.println("│  • Load template list (Prototype batch)                    │");
        System.out.println("│  • All 12 patterns applied to EACH record in list         │");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
        
        System.out.println("\n🎨 12 Design Patterns Used in Both Forms:");
        System.out.println("───────────────────────────────────────────");
        
        String[][] patterns = {
            {"1", "Singleton", "ID Generator & Config"},
            {"2", "Factory Method", "Create posts by type"},
            {"3", "Abstract Factory", "UI themes"},
            {"4", "Builder", "Build post objects"},
            {"5", "Prototype", "Clone from templates"},
            {"6", "Adapter", "Format conversion"},
            {"7", "Decorator", "Add features dynamically"},
            {"8", "Facade", "Simplify save operation"},
            {"9", "Proxy", "Lazy loading config"},
            {"10", "Observer", "Notification system"},
            {"11", "Strategy", "Rendering strategies"},
            {"12", "Template Method", "Publishing workflow"}
        };
        
        for (String[] p : patterns) {
            System.out.printf("  %2s. ✓ %-20s - %s%n", p[0], p[1], p[2]);
        }
        
        System.out.println("\n📋 Files Created:");
        System.out.println("  1. single-post-form.html (19KB) - Single record form");
        System.out.println("  2. list-posts-form.html (24KB) - List records form");
        System.out.println("  3. SingleRecordController.java (9KB) - Controller for form 1");
        System.out.println("  4. ListRecordsController.java (10KB) - Controller for form 2");
        System.out.println("  5. RecordFormsDemo.java (This file) - Demo runner");
        
        System.out.println("\n💡 How to Use:");
        System.out.println("  1. Open HTML forms in web browser");
        System.out.println("  2. Fill in the forms and submit");
        System.out.println("  3. Run demo: mvn exec:java -Dexec.mainClass=\"com.blog.patterns.forms.RecordFormsDemo\"");
        
        System.out.println("\n✅ Both forms successfully demonstrate all 12 GoF Design Patterns!");
    }
}
