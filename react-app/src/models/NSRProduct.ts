import NSRSku from "./NSRSku";

class NSRProduct {
    id: number;
    name: string;
    longName: string;
    desc?: string;
    img?: string
    skus?: NSRSku[] =[];
    constructor(id: number, name: string, desc: string,img:string,longName: string,skus:NSRSku[]) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.img = img;
        this.longName = longName;
        this.skus =skus;
    }
}
export default NSRProduct;