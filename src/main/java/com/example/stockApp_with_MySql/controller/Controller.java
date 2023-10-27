package com.example.stockApp_with_MySql.controller;


import com.example.stockApp_with_MySql.entity.Stock;
import com.example.stockApp_with_MySql.entity.Type;
import com.example.stockApp_with_MySql.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    StockService stockService;


     @PostMapping("stocks")
    public String addStocks(@RequestBody List<Stock> newStocks){
        return stockService.addStocks(newStocks);
    }

    @GetMapping("stocks")
    public List<Stock> getAllStocks(){
         return stockService.getAllStocks();
    }

    @DeleteMapping("stock/{id}")
    public String removeStock(@PathVariable Long id){
         return stockService.removeStock(id);
    }

    @PutMapping("stock/{id}")
    public String  updateStock(@PathVariable Long id, @RequestParam String name){
         return stockService.updateStock(id,name);
    }


    @GetMapping("stok/{id}")
    public Stock getStockById (@PathVariable Long id){
         return stockService.getStockById(id);
    }

    @GetMapping("stock/type/{type}/price/{price}")
    public List<Stock> getStocksByTypeLessThanEqualPrice(@PathVariable Type type,@PathVariable double price){
         return stockService.getStocksByTypeLessThanEqualPrice(type,price);
    }


    @GetMapping("stock/{type}")
    public List<Stock> findByStockName(@ PathVariable String type){
         return stockService.findByStockName(type);
    }




    @PutMapping("stock/name/{name}/type{type}")
    public String updateStockName(@PathVariable String name, @PathVariable Type type){
        return stockService.updateStockName(name,type);
    }


    @GetMapping("stock/{name}")
    public double getStockByPrice(@PathVariable String name){
         return  stockService.getStocksByPrice(name);
    }

    @PutMapping("stoks/{id}/price/{price}")
    public String updateStockPrice( @PathVariable Long id,@PathVariable double price){
         return stockService.updateStockPrice(id,price);

    }
    @DeleteMapping("stock/id/{id}")
    public String deleteStockById(@PathVariable Long id){
         return stockService.deleteStockById(id);
    }

    @GetMapping("stock/price/{price}")
    public List<Stock> getStockByPricesss(@PathVariable double price){
         return stockService.getStockByPricesss(price);
    }

}
