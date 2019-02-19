package com.jx.service;

import com.jx.model.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog> queryCatalog();

    void addCalalog(Catalog catalog);
}
