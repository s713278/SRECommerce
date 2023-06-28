package org.nsrfarms.mapper;

import org.nsrfarms.entity.Catalog;
import org.nsrfarms.entity.Category;
import org.nsrfarms.entity.Product;
import org.nsrfarms.entity.Sku;
import org.nsrfarms.vo.CatalogVO;
import org.nsrfarms.vo.CategoryVO;
import org.nsrfarms.vo.ProductVO;
import org.nsrfarms.vo.SkuVO;
import org.springframework.stereotype.Component;


@Component
public class CatalogMapperImpl implements CatalogMapper {

    public CatalogVO toVO(Catalog catalog) {
        if ( catalog == null ) {
            return null;
        }

        CatalogVO catalogVO = new CatalogVO();

        catalogVO.setId( catalog.getId() );
        catalogVO.setName( catalog.getName() );
        catalogVO.setDescription( catalog.getDescription() );

        return catalogVO;
    }

    public CategoryVO toVO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryVO categoryVO = new CategoryVO();

        categoryVO.setId( category.getId() );
        categoryVO.setName( category.getName() );
        categoryVO.setDescription( category.getDescription() );

        return categoryVO;
    }

    public ProductVO toVO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductVO productVO = new ProductVO();

        productVO.setId( product.getId() );
        productVO.setName( product.getName() );
        productVO.setDescription( product.getDescription() );

        return productVO;
    }

    public SkuVO toVO(Sku sku) {
        if ( sku == null ) {
            return null;
        }

        SkuVO skuVO = new SkuVO();

        skuVO.setId( sku.getId() );
        skuVO.setName( sku.getName() );
        skuVO.setDescription( sku.getDescription() );
        skuVO.setListPrice( sku.getListPrice() );
        skuVO.setSalePrice( sku.getSalePrice() );
        skuVO.setWholesalePrice( sku.getWholesalePrice() );

        return skuVO;
    }

    public Catalog toEntity(CatalogVO catalogVO) {
        if ( catalogVO == null ) {
            return null;
        }

        Catalog catalog = new Catalog();

        catalog.setName( catalogVO.getName() );
        catalog.setDescription( catalogVO.getDescription() );

        return catalog;
    }

    public Category toEntity(CategoryVO categoryVO) {
        if ( categoryVO == null ) {
            return null;
        }

        Category category = new Category();

        category.setName( categoryVO.getName() );
        category.setDescription( categoryVO.getDescription() );

        return category;
    }

    public Product toEntity(ProductVO productVO) {
        if ( productVO == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( productVO.getName() );
        product.setDescription( productVO.getDescription() );

        return product;
    }

    public Sku toEntity(SkuVO skuVO) {
        if ( skuVO == null ) {
            return null;
        }

        Sku sku = new Sku();
        sku.setName( skuVO.getName() );
        sku.setDescription( skuVO.getDescription() );
        sku.setListPrice( skuVO.getListPrice() );
        sku.setSalePrice( skuVO.getSalePrice() );
        sku.setWholesalePrice( skuVO.getWholesalePrice() );

        return sku;
    }
}
