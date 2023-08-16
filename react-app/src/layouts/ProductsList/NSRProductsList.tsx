import React from 'react';
import { useEffect, useState } from "react";
import NSRProduct from "../../models/NSRProduct";
import { NSRLoading } from "../Utils/NSRLoading";
import { useLocation, useParams } from 'react-router-dom';
import { NSRSearchPRoduct } from '../SearchProductPage/components/NSRSearchProduct';

export const NSRProductsList =() => {

   
    //State variable with initial state value
    const [products, setProducts] = useState<NSRProduct[]>([]);
    const [loading, setLoading] = useState(false);
    const [httpError, setHttpError] = useState(null);
    // Book to lookup reviews;
    const { categoryId }: { categoryId: string } = useParams();
    const location = useLocation();
    useEffect(() => {
        console.log(location,categoryId)
        const fetchProducts = async () => {
            const url = "http://localhost:9090/catalog-service/catalog/category/"+categoryId;
            const response = await fetch(url);
            const responseJson = await response.json();
            const responseData = responseJson.products;
            const loadedProducts: NSRProduct[] = [];
            for (const key in responseData) {
                loadedProducts.push({
                    id: responseData[key].id,
                    name: responseData[key].name,
                    desc: responseData[key].description,
                    longName:responseData[key].longName,
                    skus:responseData[key].skus
                }
                );
            }
            setProducts(loadedProducts);
            setLoading(false);
        };
        fetchProducts().catch((error: any) => {
            setLoading(false);
            setHttpError(error.message);
        })
    }, [{/*location,categoryId*/}]);

    if (loading) {
        return (
            <NSRLoading />
        );
    }

    if (httpError) {
        return (
            <div className='container m-5'>
                <p>{httpError}</p>
            </div>
        )
    }
    return (
        
       <div>
        {
            products.map((item) =>
                <NSRSearchPRoduct product={item}></NSRSearchPRoduct>
            )
            
        }
       </div>
    );
}