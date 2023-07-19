class Sku{
    name!: string;
    desc!: string;
    price!: number;   
    
}
//Lets creation instance
let sku1 = new Sku();
sku1.name = 'Laptop';
sku1.desc = 'Laptop Laptop';
sku1.price = 90900;
console.log(sku1);