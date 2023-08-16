import React from 'react';
import {NavLink,Link} from 'react-router-dom';
import {useState,useEffect} from 'react'
import NSRCategory from '../../models/NSRCategory';
export const NSRNavbar = () => {

  
    //State variable with initial state value
    const [categories, setCategories] = useState<NSRCategory[]>([]);
    const [loading, setLoading] = useState(false);
    const [httpError, setHttpError] = useState(null);

    useEffect(()=>{
      
      const fetchCategories = async () => {
        try{
          const response = await fetch("http://localhost:9090/catalog-service/catalog/1");
          const responseJson = await response.json();
          const categoriesData = responseJson.categories;
          const loadedCats: NSRCategory [] = [];
          console.log();
          for (const key in categoriesData) {
            loadedCats.push({
                id: categoriesData[key].id,
                name: categoriesData[key].name,
                displayName: categoriesData[key].description
            }
            );
        }
        console.log("loadedCats \t:" + loadedCats);
          setCategories(loadedCats);
          setLoading(false);
        }catch (error) {
          console.error('Error fetching data:', error);
        }
      };
      fetchCategories();//Call for getting Categories dynamically
    },
    /*2nd argument*/
    []
    );

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

          {
            categories.map((category) => ( 
              <li className='nav-item' >
                  <NavLink className='nav-link' to={`/category/${category.id}`}> {category.name} </NavLink>
              </li>
            )
            )
          }
          
          
          <li className='nav-item' >
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