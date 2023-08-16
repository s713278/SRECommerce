class NSRCategory {
    id: number;
    name: string;
    displayName:string
    desc?: string;
    img?: string

   
    constructor(id: number, name: string, desc: string,img:string,longName: string) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.img = img;
        this.displayName = longName;
    }
}
export default NSRCategory;