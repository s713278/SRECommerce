import React from 'react';
import './App.css';
import { NSRNavbar } from './layouts/NavbarAndFooter/NSRNavbar';
import { NSRFooter } from './layouts/NavbarAndFooter/NSRFooter';
import { NSRHomePage } from './layouts/HomePage/NSRHomePage';
import { Route, Switch, Redirect } from 'react-router-dom';
import { NSRSearchProductPage } from './layouts/SearchProductPage/NSRSearchProductPage';
export const App = () => {
  return (
    <div className='d-flex flex-column min-vh-100'>
      <NSRNavbar />
      <div className='flex-grow-1'>
        <Switch>
          <Route path="/" exact>
            <Redirect to="/home" />
          </Route>

          <Route path="/home">
            <NSRHomePage />
          </Route>

          <Route path="/search">
            <NSRSearchProductPage />
          </Route>
        </Switch>
      </div>
      <NSRFooter />
    </div>
  );
}
/*
function App(){
  return (
    <div className="App">
      <h1>Welcome to fullstack dev</h1>
    </div>
  );
}
export default App;
*/