import RowItem from "./RowItem";

function ProductTable( props) {
  return (
          <table className="table table-hover">
            <thead>
              <tr>
                <th scope='col'>#</th>
                <th scope='col'>Sku Name</th>
                <th scope='col'>Price</th>  
              </tr>
            </thead>
            <tbody>
              <RowItem 
                id={props.skus[0].id} 
                name = {props.skus[0].name}
                price={props.skus[0].price}>
              </RowItem>
              <RowItem 
                id={props.skus[1].id} 
                name = {props.skus[1].name}
                price={props.skus[1].price}>
              </RowItem>
              <div className="card-header">
                Dynamic List
              </div>
              {props.skus.map(sku =>(
                <RowItem
                  key = {sku.id} 
                 id={sku.id} 
                 name = {sku.name}
                 price={sku.price}
                />
              ))}
            </tbody>
          </table>
  );
}

export default ProductTable;
