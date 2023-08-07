export const NSRFooter = () => {
    return (
        <div className='main-color'>
            <footer className='container d-flex flex-wrap 
                justify-content-between align-items-center py-5 main-color'>
                <p className='col-md-4 mb-0 text-white'>© Example NSR Farm's Online Store</p>
                <ul className='nav navbar-dark col-md-4 justify-content-end'>
                    <li className='nav-item'>
                        <a href='#' className='nav-link px-2 text-white'>
                            Home
                        </a>
                    </li>
                    <li className='nav-item'>
                        <a href='#' className='nav-link px-2 text-white'>
                            Search Products
                        </a>
                    </li>
                </ul>
            </footer>
        </div>
    );
}