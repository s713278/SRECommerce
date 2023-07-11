import React, { Component } from 'react';
import CatalogService from '../service/CatalogService';

class CatalogComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            catalog : {},
            category : {},
            product : {},
            sku : {}
        }
    }
    

    componentDidMount(){
        CatalogService.getCatalog().then((response) => {
            this.setState({catalog : response.data})
            console.log("this.state.catalog :"+ this.state.catalog)
        })

        CatalogService.getCategory().then((response) => {
            this.setState({category : response.data})
            console.log("this.state.category :"+ this.state.category)
        })

        CatalogService.getProduct().then((response) => {
            this.setState({product : response.data})
            console.log("this.state.product :"+ this.state.product)
        })

        CatalogService.getSku().then((response) => {
            this.setState({sku : response.data})
            console.log("this.state.sku :"+ this.state.sku)
        })
    }

    /**
     * 
     * @returns 
     */
    render() {
        return (
            <div>
                 <div >
                    <p> {this.state.catalog.name} </p>
                    <p> {this.state.category.name} </p>
                    <p> {this.state.product.skus} </p>
                    <p> {this.state.sku.name} </p>
                 </div>
            </div>
        );
    }
}

export default CatalogComponent;