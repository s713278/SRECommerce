import React from 'react';
import './App.css';
import { Navbar } from './layouts/NavbarAndFooter/Navbar';
import { NSRFooter } from './layouts/NavbarAndFooter/NSRFooter';
import { NSRHomePage } from './layouts/HomePage/NSRHomePage';
export const App = () => {
  return (
    <div>
      <Navbar />
      <NSRHomePage />
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