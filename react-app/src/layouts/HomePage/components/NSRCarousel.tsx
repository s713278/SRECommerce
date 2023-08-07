import { NSRReturnProduct } from "./NSRReturnProduct";
import { useEffect,useState } from "react";
import NSRProduct from "../../../models/NSRProduct";


export const NSRCarousel = () => {

    //State variable with initial state value
    const [products,setProducts] = useState<NSRProduct[]>([]);
    const [loading,setLoading] = useState(false);
    const [httpError,setHttpError] = useState(null);


    useEffect(()=>{

        const fetchProducts = async () =>{
            const baseUrl:string = "http://localhost:9090/catalog-service/catalog/category/100";
           
            const url: string = `${baseUrl}?page=0&size=9`;
            const response = await fetch(url);
            const responseJson = await response.json();
            console.log("responseJson :"+responseJson);
            const responseData = responseJson.products;
            console.log("responseData :"+responseData);

            const loadedProducts : NSRProduct[] = [];

            for(const key in responseData){
                loadedProducts.push({
                    id:responseData[key].id,
                    name: responseData[key].name,
                    desc: responseData[key].description
                }  
            );   
            }
            console.log("loadedProducts \t:"+loadedProducts);
            setProducts(loadedProducts);
            setLoading(false);
        };
        fetchProducts().catch((error: any) => {
            setLoading(false);
            setHttpError(error.message);
        })
    },[]);

    if(loading){
        return(
            <div>
                Loading..
            </div>
        );
    }

    if(httpError){
        return (
            <div className='container m-5'>
                <p>{httpError}</p>
            </div>
        )
    }
    
    return (
        <div className='container mt-5' style={{ height: 550 }}>
            <div className='homepage-carousel-title'>
                <h3>Find your next "I stayed up too late reading" book.</h3>
            </div>
            <div id='carouselExampleControls' className='carousel carousel-dark slide mt-5 
                d-none d-lg-block' data-bs-interval='false'>

                {/* Desktop */}
                <div className='carousel-inner'>
                    <div className='carousel-item active'>
                        <div className='row d-flex justify-content-center align-items-center'>
                            {products.slice(0, 3).map(product => (
                                <NSRReturnProduct product={product} key ={product.id} />
                            ))}
                        </div>
                    </div>
                    <div className='carousel-item'>
                        <div className='row d-flex justify-content-center align-items-center'>
                            {products.slice(0, 3).map(product => (
                                <NSRReturnProduct product={product} key ={product.id} />
                            ))}
                        </div>
                    </div>
                    <div className='carousel-item'>
                        <div className='row d-flex justify-content-center align-items-center'>
                        {   products.slice(0, 3).map(product => (
                                <NSRReturnProduct product={product} key ={product.id} />
                            ))}
                        </div>
                    </div>
                </div>
                <button className='carousel-control-prev' type='button'
                    data-bs-target='#carouselExampleControls' data-bs-slide='prev'>
                    <span className='carousel-control-prev-icon' aria-hidden='true'></span>
                    <span className='visually-hidden'>Previous</span>
                </button>
                <button className='carousel-control-next' type='button'
                    data-bs-target='#carouselExampleControls' data-bs-slide='next'>
                    <span className='carousel-control-next-icon' aria-hidden='true'></span>
                    <span className='visually-hidden'>Next</span>
                </button>
            </div>

            {/* Mobile */}
            <div className='d-lg-none mt-3'>
                <div className='row d-flex justify-content-center align-items-center'>
                    <div className='text-center'>
                        <img
                            src={require('./../../../Images/BooksImages/book-luv2code-1000.png')}
                            width='151'
                            height='233'
                            alt="book"
                        />
                        <h6 className='mt-2'><b>30 Days in Java</b> </h6>
                        <p>Kunta Swamy</p>
                        <a className='btn main-color text-white' href="#">Reserve</a>
                    </div>
                </div>
            </div>
            <div className='homepage-carousel-title mt-3'>
                <a className='btn btn-outline-secondary btn-lg' href="#">View More</a>
            </div>
        </div>
    );
}