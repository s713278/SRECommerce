class Product{
    private _name: string;
    private _desc: string;
    private _price : number;

    constructor(nm:string,descr:string,price1:number){
      this._name = nm;
      this._desc = descr;
      this._price = price1;
    }
    public get name(): string {
      return this._name;
    }
    public set name(value: string) {
      this._name = value;
    }
    public get desc(): string {
      return this._desc;
    }
    public set desc(value: string) {
      this._desc = value;
    }

    
    public get price(): number {
      return this._price;
    }
    public set price(value: number) {
      this._price = value;
    }
    
}
//Lets creation instance
let product = new Product("L","ddd",90);

console.log(product);