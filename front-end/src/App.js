import './App.css';
import CatalogComponent from './component/CatalogComponent';
import RowItem from './component/ToDoItemComponent';

function App() {
  return (
    <diV className="mt-5 container">
      <div className="card">
        <div className="card-header">
          Your Todo's
        </div>
        <div className="card-body">
          <table className="table table-hover">
            <thead>
              <tr>
                <th scope='col'>#</th>
                <th scope='col'>Desc</th>
                <th scope='col'>Assign</th>  
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope='row'>1</th>
                <td >Drop Chetan @School </td>
                <td >Venkat</td>
              </tr>
              <tr>
                <th scope='row'>1</th>
                <td >Pickup Chetan from School </td>
                <td >Venkat</td>
              </tr>
              <RowItem/>
            </tbody>
          </table>
        </div>
      </div>
    </diV>
  );
}

export default App;
