package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.Domain.Size;
import com.stackroute.recommendationservice.Repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService{

    SizeRepository sizeRepository;

    @Autowired

    public SizeServiceImpl(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }


    public List<Size> getAllSizes()
    {
        return (List<Size>) sizeRepository.findAll();
    }

    public Size createSizeNode(Size size) {
        Size node = sizeRepository.save(size);
        return node;
    }
}
