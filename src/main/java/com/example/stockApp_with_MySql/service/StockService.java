package com.example.stockApp_with_MySql.service;


import com.example.stockApp_with_MySql.entity.Stock;
import com.example.stockApp_with_MySql.entity.Type;
import com.example.stockApp_with_MySql.repo.StockRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StockService {

    @Autowired
    StockRepo stockRepo;


    public String addStocks(List<Stock> newStocks) {
        stockRepo.saveAll(newStocks);
        return "stocks are added";
    }


    public List<Stock> getAllStocks() {
        return (List<Stock>) stockRepo.Stocksss();
    }


    public String removeStock(Long id) {
        stockRepo.deleteById(id);
        return "stock deleted";
    }


    public String updateStock(Long id, String name) {
        Stock stock=stockRepo.findById(id).orElseThrow();
        stock.setStockName(name);
        return "stock updated";
    }

    public Stock getStockById(Long id) {
        return stockRepo.findById(id).orElseThrow();

    }

    public List<Stock> getStocksByTypeLessThanEqualPrice(Type type, double price) {
        return stockRepo.findByStockTypeAndStockPriceLessThanEqual(type,price);
    }




    public List<Stock> findByStockName(String type) {
        return stockRepo.findByStockName(type);
    }


    public String updateStockName(String name, Type type) {

        Stock upsStock = stockRepo.findFirstByStockName(name);
        if(upsStock == null){
            return "stock is not present";
        }
        else{
            upsStock.setStockType(type);
            stockRepo.save(upsStock);
        }
        return "stock type updated";


    }


    public double getStocksByPrice(String name) {
        return stockRepo.getStockPrice(name);
    }

    @Transactional
    public String updateStockPrice(Long id, double price) {
         stockRepo.updateStockPrice(id,price);
         return "updated";
    }

    @Transactional
    public String deleteStockById(Long id) {
        stockRepo.deleteStockById(id);
        return "Stock Deleted";
    }

    public List<Stock> getStockByPricesss(double price) {
        return stockRepo.getStockByPricesss(price);
    }
}
