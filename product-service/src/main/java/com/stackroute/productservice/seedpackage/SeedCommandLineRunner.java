////package com.stackroute.productservice.seedpackage;
////
////import Products;
////import ProductRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.CommandLineRunner;
////import org.springframework.context.annotation.Configuration;
////
////@Configuration
////public class SeedCommandLineRunner implements CommandLineRunner {
////    private ProductRepository trackRepository;
////    @Autowired
////    public SeedCommandLineRunner(ProductRepository trackRepository) {
////        this.trackRepository = trackRepository;
////    }
////
////    @Override
////    public void run(String... args) throws Exception {
////        Products track1=Products.builder().trackName("first track").comments("good").build();
////        trackRepository.save(track1);
////        Products track2=Products.builder().trackName("second track").comments("good").build();
////        trackRepository.save(track2);
////        trackRepository.save(new Products(6,"new track","good"));
////    }
////}
//package com.stackroute.productservice.seedpackage;
//
//import Products;
//import ProductService;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@Component
//@Data
//@PropertySource("application.properties")
//public class SeedCommandLineRunner implements CommandLineRunner {
//    private Products feedTrackData = new Products();
//    @Value("${song.total}")
//    private int totalSongs;
//    @Value("${song.1.id}")
//    private int id1;
//    @Value("${song.1.name}")
//    private String name1;
//    @Value("${song.1.comment}")
//    private String comment1;
//    @Value("${song.2.id}")
//    private int id2;
//    @Value("${song.2.name}")
//    private String name2;
//    @Value("${song.2.comment}")
//    private String comment2;
//    @Value("${song.3.id}")
//    private int id3;
//    @Value("${song.3.name}")
//    private String name3;
//    @Value("${song.3.comment}")
//    private String comment3;
//    @Value("${song.4.id}")
//    private int id4;
//    @Value("${song.4.name}")
//    private String name4;
//    @Value("${song.4.comment}")
//    private String comment4;
//
//
//    @Autowired
//    Environment env;
//    @Autowired
//    private ProductService trackServices;
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(env.getProperty("app.name"));
//        System.out.println(env.getProperty("JAVA_HOME"));
//        feedTrackData.setTrackId(id1);
//        feedTrackData.setTrackName(name1);
//        feedTrackData.setComments(comment1);
//        trackServices.saveTrack(feedTrackData);
//
////        feedTrackData.setTrackId(Integer.parseInt(env.getProperty("song.1.id")));
////        feedTrackData.setTrackName(env.getProperty("song.1.name"));
////        feedTrackData.setComments(env.getProperty("song.1.comment"));
////        trackServices.saveTrack(feedTrackData);
//
//        feedTrackData.setTrackId(id2);
//        feedTrackData.setTrackName(name2);
//        feedTrackData.setComments(comment2);
//        trackServices.saveTrack(feedTrackData);
//
//        feedTrackData.setTrackId(id3);
//        feedTrackData.setTrackName(name3);
//        feedTrackData.setComments(comment3);
//        trackServices.saveTrack(feedTrackData);
//
//        feedTrackData.setTrackId(id4);
//        feedTrackData.setTrackName(name4);
//        feedTrackData.setComments(comment4);
//        trackServices.saveTrack(feedTrackData);
//    }
//}
