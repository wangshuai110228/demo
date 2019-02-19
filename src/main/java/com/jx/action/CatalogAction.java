package com.jx.action;

import com.jx.model.Catalog;
import com.jx.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("catalog")
public class CatalogAction {
       @Autowired
       private CatalogService catalogService;
    @RequestMapping("queryCatalog")
    @ResponseBody
    public List<Catalog> queryCatalog(){
        return   catalogService.queryCatalog();
    }
    @RequestMapping("addCalalog")
    @ResponseBody
    public  void  addCalalog(Catalog  catalog){
        catalogService.addCalalog(catalog);
    }
}
