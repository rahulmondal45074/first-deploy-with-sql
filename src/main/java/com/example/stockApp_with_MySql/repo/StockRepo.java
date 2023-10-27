package com.example.stockApp_with_MySql.repo;

import com.example.stockApp_with_MySql.entity.Stock;
import com.example.stockApp_with_MySql.entity.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepo extends CrudRepository<Stock,Long> {
  // List<Stock> findByStockTypeAndStockPriceLessThanStockPrice(Type type, double price);
//    // List<Stock> findStockTypeAndStockPriceLessThanStockPrice(Type type, double price);

    List<Stock> findByStockTypeAndStockPriceLessThanEqual(Type type,double price);

    @Query(nativeQuery = true, value = "select * from stockDB.Stock")
    List<Stock> Stocksss ();

    List<Stock> findByStockName(String type);


    Stock findFirstByStockName(String name);

//    @Query(nativeQuery = true,value = "select * from stockDB.stock where stock_name = :stockType")
//    List<Stock> getStockNames();


    @Query(nativeQuery = true,value = "select stockPrice from stock where stock_name = : name")
    double getStockPrice(String name);


    @Modifying
    @Query(nativeQuery = true, value = "update stock set stock_price = :price where stock_id = :id ")
    void updateStockPrice(Long id, double price);


    @Modifying
    @Query(nativeQuery = true, value = "DELETE from stock where stock_id =:id")
    void deleteStockById(Long id);


    @Modifying
    @Query(nativeQuery = true,value = "select * from stockDB.stock where stock_price =:price")
    List<Stock> getStockByPricesss(double price);
}
