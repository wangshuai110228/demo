package com.jx.service;

import com.jx.mapper.CatalogMapper;
import com.jx.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService{
      @Autowired
      private CatalogMapper catalogMapper;

    @Override
    public List<Catalog> queryCatalog() {
        return catalogMapper.queryCatalog();
    }

    @Override
    public void addCalalog(Catalog catalog) {
        catalogMapper.addCalalog(catalog);
    }
}
