package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Size;
import com.stackroute.recommendationservice.Repository.SizeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class SizeServiceTest {
    Size size;

    @Mock
    SizeRepository sizeRepository;

    @InjectMocks
    SizeServiceImpl sizeService;
    List<Size> list = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        size = new Size();
        size.setId(1);
        size.setSize("8");
        list = new ArrayList<>();
        list.add(size);
    }

    @Test
    public void saveSizeTest()
    {
        when(sizeRepository.save((Size)any())).thenReturn(size);
        Size savedSize = sizeService.createSizeNode(size);
        Assert.assertEquals(size,savedSize);
    }

    @Test
    public void getTrackTest() {
        sizeRepository.save(size);
        when(sizeRepository.findAll()).thenReturn(list);
        List<Size> userList = sizeService.getAllSizes();
        Assert.assertEquals(list, userList);
    }
}
