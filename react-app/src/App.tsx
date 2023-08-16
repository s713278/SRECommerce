import React, { StrictMode } from 'react';
import './App.css';
import { NSRNavbar } from './layouts/NavbarAndFooter/NSRNavbar';
import { NSRFooter } from './layouts/NavbarAndFooter/NSRFooter';
import { NSRHomePage } from './layouts/HomePage/NSRHomePage';
import { Route, Switch, Redirect, BrowserRouter } from 'react-router-dom';
import { NSRSearchProductPage } from './layouts/SearchProductPage/NSRSearchProductPage';
import { NSRProductsList } from './layouts/ProductsList/NSRProductsList';

export const App = () => {
  return (
    <div className='d-flex flex-column min-vh-100'>
      <NSRNavbar />
      <div className='flex-grow-1'>
        <Switch>
          {/* <Route path="/">
            <Redirect to="/home" />
          </Route> */}

          <Route path="/home">
            <NSRHomePage />
          </Route>

          <Route path="/search">
            <NSRSearchProductPage />
          </Route>

          <Route path="/category/:categoryId" component={NSRProductsList}>
            
          </Route>

        </Switch>
      </div>
      <NSRFooter />
    </div>
  );
}