import React from 'react'
import NSRProduct from '../../../models/NSRProduct';

export const NSRReturnProduct:React.FC<{product:NSRProduct}> =(props) => {
    return (
        <div className='col-xs-6 col-sm-6 col-md-4 col-lg-3 mb-3'>
            <div className='text-center'>
                <img
                    src={require('./../../../Images/BooksImages/book-luv2code-1000.png')}
                    width='151'
                    height='233'
                    alt="Product"
                />
                <h6 className='mt-2'><b>{props.product.name}</b> </h6>
                <p>{props.product.longName}</p>
                <a className='btn main-color text-white' href="#">Reserve</a>
            </div>
        </div >
    );
}