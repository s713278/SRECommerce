import { useState } from "react";

function NewSkuForm(props){

    const [name ,setName] = useState('');
    const [description ,setDescription] = useState('');
    const [price ,setPrice] = useState('');

    const onChangeName = (event)=> {
        setName(event.target.value);
    }

    const onChangePrice = (event) =>{
        setPrice(event.target.value);
    }

    const submitAddSku = () => {
        alert("Form Data-Sku Name: "+name+ "\t Price :"+price);
        props.addSku(name,description,price);
        setName('');
        setPrice('');
        setDescription('');
    }

    return(
        <form>
            <div className="mb-5">
            <div>
                <label>Sku Name</label>
                <input type="text" value={name} 
                className="form-control" 
                onChange={onChangeName}/>
            </div>
            <div className="mb-5">
                <label>Sku description</label>
                <input type="textarea" cols={15} rows={3} value={description} 
                className="form-control" 
                onChange={e => setDescription(e.target.value)}/>
            </div>
            <div className="mb-5">
                <label>Sku Price</label>
                <input type="text" value={price} 
                className="form-control" 
                onChange={onChangePrice}/>
            </div>
            <button type="button" className="btn btn-primary mt-3" onClick={submitAddSku}>Add New SKU</button>
            </div>
        </form>
        
    );
}
export default NewSkuForm