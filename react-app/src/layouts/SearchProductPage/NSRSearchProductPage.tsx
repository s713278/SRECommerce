import React from 'react';
import { useEffect, useState } from "react";
import NSRProduct from "../../models/NSRProduct";
import { NSRLoading } from "../Utils/NSRLoading";
import { NSRSearchPRoduct } from "./components/NSRSearchProduct";
import { Pagination } from "../Utils/Pagination";

export const NSRSearchProductPage = () => {

    //State variable with initial state value
    const [products, setProducts] = useState<NSRProduct[]>([]);
    const [loading, setLoading] = useState(false);
    const [httpError, setHttpError] = useState(null);

    const [currentPage, setCurrentPage] = useState(1);
    const [booksPerPage] = useState(5);
    const [totalAmountOfBooks, setTotalAmountOfBooks] = useState(0);
    const [totalPages, setTotalPages] = useState(0);
    const [search, setSearch] = useState('');
    const [searchUrl, setSearchUrl] = useState('');
    const [categorySelection, setCategorySelection] = useState('Product Category');

    useEffect(() => {

        const fetchProducts = async () => {
            const baseUrl: string = "http://localhost:9090/catalog-service/catalog/products";

            let url: string = '';

            if (searchUrl === '') {
                url = `${baseUrl}?page=${currentPage - 1}&size=${booksPerPage}`;
            } else {
                url = baseUrl + searchUrl;
            }

            const response = await fetch(url);
            const responseJson = await response.json();
            
            const responseData = responseJson.content;
            console.log("responseJson.totalElements :" + responseJson.totalElements);

            setTotalAmountOfBooks(responseJson.totalElements);
            setTotalPages(responseJson.totalPages);

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
            console.log("loadedProducts \t:" + loadedProducts);
            setProducts(loadedProducts);
            setLoading(false);
        };
        fetchProducts().catch((error: any) => {
            setLoading(false);
            setHttpError(error.message);
        })
    }, []);

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

    const searchHandleChange = () => {
        if (search === '') {
            setSearchUrl('');
        } else {
            setSearchUrl(`/search/findByTitleContaining?title=${search}&page=0&size=${booksPerPage}`)
        }
    }

    const categoryField = (value: string) => {
        if (
            value.toLowerCase() === 'fe' || 
            value.toLowerCase() === 'be' || 
            value.toLowerCase() === 'data' || 
            value.toLowerCase() === 'Catalog'
        ) {
            setCategorySelection(value);
            setSearchUrl(`/search/findByCategory?category=${value}&page=0&size=${booksPerPage}`)
        } else {
            setCategorySelection('All');
            setSearchUrl(`?page=0&size=${booksPerPage}`)
        }
    }

    const indexOfLastBook: number = currentPage * booksPerPage;
    const indexOfFirstBook: number = indexOfLastBook - booksPerPage;
    let lastItem = booksPerPage * currentPage <= totalAmountOfBooks ?
        booksPerPage * currentPage : totalAmountOfBooks;

    const paginate = (pageNumber: number) => setCurrentPage(pageNumber);

    return (
        <div>
            <div className='container'>
                <div>
                    <div className='row mt-5'>
                        <div className='col-6'>
                            <div className='d-flex'>
                                <input className='form-control me-2' type='search'
                                    placeholder='Search' aria-labelledby='Search'
                                    onChange={e => setSearch(e.target.value)} />
                                <button className='btn btn-outline-success'
                                    onClick={() => searchHandleChange()}>
                                    Search
                                </button>
                            </div>
                        </div>
                        <div className='col-4'>
                            <div className='dropdown'>
                                <button className='btn btn-secondary dropdown-toggle' type='button'
                                    id='dropdownMenuButton1' data-bs-toggle='dropdown'
                                    aria-expanded='false'>
                                    {categorySelection}
                                </button>
                                <ul className='dropdown-menu' aria-labelledby='dropdownMenuButton1'>
                                    <li onClick={() => categoryField('All')}>
                                        <a className='dropdown-item' href='#'>
                                            All
                                        </a>
                                    </li>
                                    <li onClick={() => categoryField('FE')}>
                                        <a className='dropdown-item' href='#'>
                                            Sku
                                        </a>
                                    </li>
                                    <li onClick={() => categoryField('BE')}>
                                        <a className='dropdown-item' href='#'>
                                            Product
                                        </a>
                                    </li>
                                    <li onClick={() => categoryField('Data')}>
                                        <a className='dropdown-item' href='#'>
                                            Category
                                        </a>
                                    </li>
                                    <li onClick={() => categoryField('Catalog')}>
                                        <a className='dropdown-item' href='#'>
                                            Catalog
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    {totalAmountOfBooks > 0 ?
                        <>
                            <div className='mt-3'>
                                <h5>Number of results: ({totalAmountOfBooks})</h5>
                            </div>
                            <p>
                                {indexOfFirstBook + 1} to {lastItem} of {totalAmountOfBooks} items:
                            </p>
                            {products.map(product => (
                                <NSRSearchPRoduct product={product} key={product.id} />
                            ))}
                        </>
                        :
                        <div className='m-5'>
                            <h3>
                                Can't find what you are looking for?
                            </h3>
                            <a type='button' className='btn main-color btn-md px-4 me-md-2 fw-bold text-white'
                                href='#'>NSR Services</a>
                        </div>
                    }
                    {totalPages > 1 &&
                        <Pagination currentPage={currentPage} totalPages={totalPages} paginate={paginate} />
                    }
                </div>
            </div>
        </div>
    );
}