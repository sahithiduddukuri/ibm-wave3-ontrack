//package com.stackroute.deliverymanagerlogin.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.deliverymanagerlogin.model.DeliveryManager;
//import com.stackroute.deliverymanagerlogin.services.DeliveryManagerService;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.http.MediaType;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class DeliveryManagerControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    private DeliveryManager deliveryManager;
//    private List<DeliveryManager> deliveryManagers;
//
//    @MockBean
//    private DeliveryManagerService deliveryManagerService;
//
//    @InjectMocks
//    private DeliveryManagerController deliveryManagerController;
//
//    @Before
//    public void setUp() throws Exception
//    {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(deliveryManagerController).build();
//
//        deliveryManager = new DeliveryManager();
//        deliveryManager.setManagerId("ranganath");
//        deliveryManager.setPassword("cs");
//
//        deliveryManagers = new ArrayList<>();
//    }
//
//    @After
//    public void tearDown() throws Exception
//    {
//        deliveryManagers=null;
//        deliveryManagers=null;
//    }
//
//    @Test
//    public void saveEventSuccess() throws Exception {
//        when(deliveryManagerService.saveManager((DeliveryManager) any())).thenReturn(deliveryManager);
//        mockMvc.perform(MockMvcRequestBuilders.post("api/deliveryManager")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(deliveryManager)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void saveEventFailure() throws Exception {
//        when(deliveryManagerService.saveManager((DeliveryManager) any())).thenThrow();
//        mockMvc.perform(MockMvcRequestBuilders.post("api/deliveryManager")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(deliveryManager)))
//                .andExpect(MockMvcResultMatchers.status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    private static String asJsonString(final Object obj)
//    {
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }
//    }
//
////    @Test
////    public void updateTrackSuccess() throws Exception {
////        when(trackService.updateTrack((Track)any())).thenReturn(track);
////        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/tracks/track")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
////                .andExpect(MockMvcResultMatchers.status().isAccepted())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    @Test
////    public void updateTrackFailure() throws Exception {
////        when(trackService.updateTrack((Track)any())).thenThrow(TrackDoesNotExistException.class);
////        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/tracks/track")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
////                .andExpect(MockMvcResultMatchers.status().isNotFound())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    @Test
////    public void getTrackByIdSuccess() throws Exception {
////        when(trackService.getTrackById(anyInt())).thenReturn(track);
////        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks/track/id/{trackId}",track.getTrackId())
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
////                .andExpect(MockMvcResultMatchers.status().isFound())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    @Test
////    public void getTrackByIdFailure() throws Exception {
////        when(trackService.getTrackById(anyInt())).thenThrow(TrackDoesNotExistException.class);
////        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks/track/id/{trackId}",track.getTrackId())
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
////                .andExpect(MockMvcResultMatchers.status().isNotFound())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    @Test
////    public void getTrackByNameSuccess() throws Exception {
////        when(trackService.getTrackByName((String)any())).thenReturn(track);
////        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks/track/name/{trackName}",track.getTrackName())
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
////                .andExpect(MockMvcResultMatchers.status().isFound())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    @Test
////    public void getTrackByNameFailure() throws Exception {
////        when(trackService.getTrackByName((String) any())).thenThrow(TrackDoesNotExistException.class);
////        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks/track/name/{trackName}",track.getTrackName())
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
////                .andExpect(MockMvcResultMatchers.status().isNotFound())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    @Test
////    public void deleteTrackByIdSuccess() throws Exception {
////        when(trackService.getTrackById(anyInt())).thenReturn(track);
////        when(trackService.deleteTrack((Track)any())).thenReturn(track);
////        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/tracks/track/{trackId}",track.getTrackId())
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
////                .andExpect(MockMvcResultMatchers.status().isAccepted())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    @Test
////    public void deleteTrackByIdFailure() throws Exception {
////        when(trackService.getTrackById(anyInt())).thenThrow(TrackDoesNotExistException.class);
////        when(trackService.deleteTrack((Track)any())).thenThrow(TrackDoesNotExistException.class);
////        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/tracks/track/{trackId}",track.getTrackId())
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
////                .andExpect(MockMvcResultMatchers.status().isNotFound())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    @Test
////    public void getAllTracksSuccess() throws Exception {
////        when(trackService.getAllTracks()).thenReturn(tracks);
////        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
////                .andExpect(MockMvcResultMatchers.status().isFound())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////    @Test
////    public void getAllTracksFailure() throws Exception {
////        when(trackService.getAllTracks()).thenThrow(EmptyTrackListException.class);
////        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/tracks")
////                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
////                .andExpect(MockMvcResultMatchers.status().isNotFound())
////                .andDo(MockMvcResultHandlers.print());
////    }
////
////
////    private static String asJsonString(final Object obj)
////    {
////        try{
////            return new ObjectMapper().writeValueAsString(obj);
////
////        }catch(Exception e){
////            throw new RuntimeException(e);
////        }
////    }
//
//}