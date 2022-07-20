package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.ProductService;
import com.example.northwind.core.utilities.results.DataResult;
import com.example.northwind.core.utilities.results.Result;
import com.example.northwind.core.utilities.results.SuccessDataResult;
import com.example.northwind.core.utilities.results.SuccessResult;
import com.example.northwind.dataAccess.abstracts.ProductDao;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(
                this.productDao.findAll(), "Veriler getirildi.");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<>(this.productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort=Sort.by(Sort.Direction.ASC,"productName");
        return new SuccessDataResult<>(this.productDao.findAll(sort));
    }

    @Override
    public DataResult<List<Product>> getAllSortedReverse() {
        Sort sort=Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<>(this.productDao.findAll(sort));
    }

    @Override
    public Result add(@RequestBody Product product) {
        this.productDao.save(product);
        return new SuccessResult("Yeni ürün eklendi.");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<>(this.productDao.getByProductName(productName),
                "Veri getirildi.");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<>(this.productDao.
                getByProductNameAndCategory_CategoryId(productName,categoryId),
                "Veri getirildi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
        return new SuccessDataResult<>(this.productDao.
                getByProductNameOrCategory_CategoryId(productName,categoryId),
                "Veriler getirildi.");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categoryId) {
        return new SuccessDataResult<>(this.productDao.getByCategory_CategoryIdIn(categoryId),
                "Veriler getirildi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String name) {
        return new SuccessDataResult<>(this.productDao.getByProductNameContains(name),
                "Veriler getirildi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String name) {
        return new SuccessDataResult<>(this.productDao.getByProductNameStartsWith(name),
                "Veriler getirildi.");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String name, int id) {
        return new SuccessDataResult<>(this.productDao.getByNameAndCategory(name,id),
                "Veriler getirildi");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<>(this.productDao.getProductWithCategoryDetails(),
                "Veriler getirildi.");
    }
}