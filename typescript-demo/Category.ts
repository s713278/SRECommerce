export class Category{
    constructor(private _name:string,private _desc:string){

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

    
    
}
