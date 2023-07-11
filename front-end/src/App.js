import React,{useState} from 'react';
import './App.css';
import CatalogComponent from './component/CatalogComponent';
import ProductTable from './component/ProductTable';


function App() {

  const [color, setColor] = useState("red");

  const [skus,setSku]=
  useState(
            [
              {id:1,name:"Pen",description:"Beautiful Pen",price:"100.00"},
              {id:2,name:"Pencil",description:"Beautiful Pen",price:"52.00"},
              {id:3,name:"Book",description:"Beautiful Pen",price:"85.00"},
              {id:4,name:"Sharpner",description:"Beautiful Pen",price:"12.00"}
            ]
            );

  const addSku = () =>{
    alert("Button clicked..."+skus.length);
    if(skus.length >0){
      const newSku = {
        id:skus.length+1,
        name:"Phone",
        description:"Beautiful Pen",price:"1245.00"
      };
     // skus.push(newSku);
     setSku(skus => [...skus,newSku]);
      //console.log(skus);
      alert("Added new sku "+skus.length);
    }
  }


  return (
    <diV className="mt-5 container">
      <div className="card">
        <div className="card-header">
          Product- Skus
        </div>
        <div className="card-body">
         <ProductTable skus={skus}/>
         <button className='btn btn-primary' onClick={addSku}>Add Sku</button>
        </div>
      </div>
    </diV>
  );
}

export default App;
