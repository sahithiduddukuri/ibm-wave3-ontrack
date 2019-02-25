package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Size;

import java.util.List;

public interface SizeService  {
    public List<Size> getAllSizes();
    public Size createSizeNode(Size size);
}
