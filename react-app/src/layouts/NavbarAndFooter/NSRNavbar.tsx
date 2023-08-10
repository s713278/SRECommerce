import React from 'react';
import {NavLink} from 'react-router-dom';
export const NSRNavbar = () => {
  return (
    <nav className='navbar navbar-expand-lg navbar-dark main-color py-3'>
    <div className='container-fluid'>
      <span className='navbar-brand'>NSR Farm's Store</span>
      <button className='navbar-toggler' type='button'
        data-bs-toggle='collapse' data-bs-target='#navbarNavDropdown'
        aria-controls='navbarNavDropdown' aria-expanded='false'
        aria-label='Toggle Navigation'>
        <span className='navbar-toggler-icon'></span>
      </button>
      <div className='collapse navbar-collapse' id='navbarNavDropdown'>
        <ul className='navbar-nav'>
          <li className='nav-item'>
            {/*<a className='nav-link' href="/home"> Home </a>*/}
            <NavLink className="nav-link" to="/home">Home</NavLink>
          </li>
          <li className='nav-item'>
           {/* <a className='nav-link' href="/search"> Search Products </a>*/}
            <NavLink className="nav-link" to="/search">Search Products</NavLink>
          </li>
        </ul>
        <ul className='navbar-nav ms-auto'>
          <li className='nav-item m-1'> 
            <a className='btn btn-outline-light'>Sign in</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  );
}