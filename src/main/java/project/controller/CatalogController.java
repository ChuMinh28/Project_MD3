package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import project.model.entity.Catalog;
import project.model.service.CatalogService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("catalogController")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;
    @RequestMapping(value = "GetAll")
    public ModelAndView getAllCatalog(){
        ModelAndView modelAndView = new ModelAndView("/admin/listCatalog");
        int limit = 5;
        int index = 0;
        List<Catalog> listCatalog = catalogService.phanTrang(index,limit);
        int total = catalogService.soLuongTrang(limit);
        List<Integer> listInteger = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            listInteger.add(i);
        }
        modelAndView.addObject("listPage",listInteger);
        modelAndView.addObject("listCatalog",listCatalog);
        return modelAndView;
    }
    @RequestMapping(value = "loadPage")
    public ModelAndView phantrang(int index){
        ModelAndView modelAndView = new ModelAndView("/admin/listCatalog");
        int limit = 5;
        int index1 = index*limit;
        List<Catalog> catalogList = catalogService.phanTrang(index1,limit);
        int total = catalogService.soLuongTrang(limit);
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            integerList.add(i);
        }
        modelAndView.addObject("listPage",integerList);
        modelAndView.addObject("listCatalog",catalogList);
        return modelAndView;
    }
    @RequestMapping("search")
    public ModelAndView search(String catalogName){
        ModelAndView modelAndView = new ModelAndView("/admin/listCatalog");
        List<Catalog> listCatalog = catalogService.searchCatalogByName(catalogName);
        modelAndView.addObject("listCatalog",listCatalog);
        return modelAndView;
    }
    @PostMapping("create")
    public String createCatalog( Catalog catalog){
        boolean result = catalogService.save(catalog);
        if (result) {
            return "redirect:GetAll";
        }else {
            return "/user/error";
        }
    }
    @GetMapping("delete")
    public String deleteCatalog(int catalogID){
        boolean result = catalogService.delete(catalogID);
        if (result) {
            return "redirect:GetAll";
        }else {
            return "/user/error";
        }
    }
    @GetMapping("initUpdate")
    public String initUpdate(Model model ,int catalogID){
        Catalog catalog = (Catalog) catalogService.findById(catalogID);
        model.addAttribute("updateCatalog",catalog);
        return "/admin/updateCatalog";
    }
    @PostMapping("update")
    public String updateCatalog(Catalog catalog){
        boolean result = catalogService.update(catalog);
        if (result) {
            return "redirect:GetAll";
        }else {
            return "/user/error";
        }
    }
}
