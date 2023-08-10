class NSRProduct {
    id: number;
    name: string;
    desc?: string;
    img?: string
    constructor(id: number, name: string, desc: string,img:string) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.img = img;
    }
}
export default NSRProduct;