import React from 'react';
import { Link } from "react-router-dom";
import NSRProduct from "../../../models/NSRProduct";

export const NSRSearchPRoduct: React.FC<{ product: NSRProduct }> = (props) => {
    return (
        <div className='card mt-3 shadow p-3 mb-3 bg-body rounded'>
            <div className='row g-0'>
                <div className='col-md-2'>
                    <div className='d-none d-lg-block'>
                        {props.product.img ?
                            <img src={props.product.img}
                                width='123'
                                height='196'
                                alt='Book'
                            />
                            :
                            <img src={require('../../../Images/BooksImages/book-luv2code-1000.png')}
                                width='123'
                                height='196'
                                alt='Product'
                            />
                        }
                    </div>
                    <div className='d-lg-none d-flex justify-content-center 
                        align-items-center'>
                        {props.product.img ?
                            <img src={props.product.img}
                                width='123'
                                height='196'
                                alt='Product'
                            />
                            :
                            <img src={require('../../../Images/BooksImages/book-luv2code-1000.png')}
                                width='123'
                                height='196'
                                alt='Book'
                            />
                        }
                    </div>
                </div>
                <div className='col-md-6'>
                    <div className='card-body'>
                        <h5 className='card-title'>
                            {props.product.name}
                        </h5>
                        <h4>
                            {props.product.name}
                        </h4>
                        <p className='card-text'>
                            {props.product.desc}
                        </p>
                    </div>
                </div>
                <div className='col-md-4 d-flex justify-content-center align-items-center'>
                    <Link className='btn btn-md main-color text-white' to={`/checkout/${props.product.id}`}>
                        View Details
                    </Link>
                </div>
            </div>
        </div>
    );
}