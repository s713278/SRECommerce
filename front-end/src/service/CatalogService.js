import axios from 'axios'
const CATALOG_BASE_URL = "http://localhost:9090/catalog-service/catalog";
const CATALOG_ID = 1;
const CATEGORY_ID = 100;
const PRODUCT_ID = 1002;
const SKU_ID = 10001;
class CatalogService {
    
    getCatalog(){
        return axios.get(CATALOG_BASE_URL+"/"+CATALOG_ID);
    }

    getCategory(){
        return axios.get(CATALOG_BASE_URL+"/category/"+CATEGORY_ID);
    }

    getProduct(){
        return axios.get(CATALOG_BASE_URL+"/product/"+PRODUCT_ID);
    }

    getSku(){
        return axios.get(CATALOG_BASE_URL+"/sku/"+SKU_ID);
    }
}

export default new CatalogService